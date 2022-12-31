package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class ConfigFetchHandler {
    @VisibleForTesting
    static final int HTTP_TOO_MANY_REQUESTS = 429;
    @Nullable
    private final AnalyticsConnector analyticsConnector;
    private final Clock clock;
    private final Map<String, String> customHttpHeaders;
    private final Executor executor;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigFetchHttpClient frcBackendApiClient;
    private final ConfigMetadataClient frcMetadata;
    private final Random randomGenerator;
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    @VisibleForTesting
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};

    /* loaded from: classes2.dex */
    public static class FetchResponse {
        private final Date fetchTime;
        private final ConfigContainer fetchedConfigs;
        @Nullable
        private final String lastFetchETag;
        private final int status;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Status {
            public static final int BACKEND_HAS_NO_UPDATES = 1;
            public static final int BACKEND_UPDATES_FETCHED = 0;
            public static final int LOCAL_STORAGE_USED = 2;
        }

        private FetchResponse(Date date, int i2, ConfigContainer configContainer, @Nullable String str) {
            this.fetchTime = date;
            this.status = i2;
            this.fetchedConfigs = configContainer;
            this.lastFetchETag = str;
        }

        public static FetchResponse forBackendHasNoUpdates(Date date) {
            return new FetchResponse(date, 1, null, null);
        }

        public static FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.getFetchTime(), 0, configContainer, str);
        }

        public static FetchResponse forLocalStorageUsed(Date date) {
            return new FetchResponse(date, 2, null, null);
        }

        Date getFetchTime() {
            return this.fetchTime;
        }

        public ConfigContainer getFetchedConfigs() {
            return this.fetchedConfigs;
        }

        @Nullable
        String getLastFetchETag() {
            return this.lastFetchETag;
        }

        int getStatus() {
            return this.status;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, @Nullable AnalyticsConnector analyticsConnector, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map<String, String> map) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = analyticsConnector;
        this.executor = executor;
        this.clock = clock;
        this.randomGenerator = random;
        this.fetchedConfigsCache = configCacheClient;
        this.frcBackendApiClient = configFetchHttpClient;
        this.frcMetadata = configMetadataClient;
        this.customHttpHeaders = map;
    }

    private boolean areCachedFetchConfigsValid(long j2, Date date) {
        Date lastSuccessfulFetchTime = this.frcMetadata.getLastSuccessfulFetchTime();
        if (lastSuccessfulFetchTime.equals(ConfigMetadataClient.LAST_FETCH_TIME_NO_FETCH_YET)) {
            return false;
        }
        return date.before(new Date(lastSuccessfulFetchTime.getTime() + TimeUnit.SECONDS.toMillis(j2)));
    }

    private FirebaseRemoteConfigServerException createExceptionWithGenericMessage(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (httpStatusCode == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else if (httpStatusCode == 429) {
            throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
        } else {
            if (httpStatusCode != 500) {
                switch (httpStatusCode) {
                    case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                    case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                    case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "The server returned an unexpected error.";
                        break;
                }
            } else {
                str = "There was an internal server error.";
            }
        }
        int httpStatusCode2 = firebaseRemoteConfigServerException.getHttpStatusCode();
        return new FirebaseRemoteConfigServerException(httpStatusCode2, "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    private String createThrottledMessage(long j2) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j2)));
    }

    @WorkerThread
    private FetchResponse fetchFromBackend(String str, String str2, Date date) throws FirebaseRemoteConfigException {
        try {
            FetchResponse fetch = this.frcBackendApiClient.fetch(this.frcBackendApiClient.createHttpURLConnection(), str, str2, getUserProperties(), this.frcMetadata.getLastFetchETag(), this.customHttpHeaders, date);
            if (fetch.getLastFetchETag() != null) {
                this.frcMetadata.setLastFetchETag(fetch.getLastFetchETag());
            }
            this.frcMetadata.resetBackoff();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e2) {
            ConfigMetadataClient.BackoffMetadata updateAndReturnBackoffMetadata = updateAndReturnBackoffMetadata(e2.getHttpStatusCode(), date);
            if (shouldThrottle(updateAndReturnBackoffMetadata, e2.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(updateAndReturnBackoffMetadata.getBackoffEndTime().getTime());
            }
            throw createExceptionWithGenericMessage(e2);
        }
    }

    private g<FetchResponse> fetchFromBackendAndCacheResponse(String str, String str2, Date date) {
        try {
            FetchResponse fetchFromBackend = fetchFromBackend(str, str2, date);
            if (fetchFromBackend.getStatus() != 0) {
                return j.e(fetchFromBackend);
            }
            return this.fetchedConfigsCache.put(fetchFromBackend.getFetchedConfigs()).p(this.executor, ConfigFetchHandler$$Lambda$4.lambdaFactory$(fetchFromBackend));
        } catch (FirebaseRemoteConfigException e2) {
            return j.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g<FetchResponse> fetchIfCacheExpiredAndNotThrottled(g<ConfigContainer> gVar, long j2) {
        g h2;
        Date date = new Date(this.clock.currentTimeMillis());
        if (gVar.n() && areCachedFetchConfigsValid(j2, date)) {
            return j.e(FetchResponse.forLocalStorageUsed(date));
        }
        Date backoffEndTimeInMillis = getBackoffEndTimeInMillis(date);
        if (backoffEndTimeInMillis != null) {
            h2 = j.d(new FirebaseRemoteConfigFetchThrottledException(createThrottledMessage(backoffEndTimeInMillis.getTime() - date.getTime()), backoffEndTimeInMillis.getTime()));
        } else {
            g<String> id = this.firebaseInstallations.getId();
            g<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
            h2 = j.i(id, token).h(this.executor, ConfigFetchHandler$$Lambda$2.lambdaFactory$(this, id, token, date));
        }
        return h2.h(this.executor, ConfigFetchHandler$$Lambda$3.lambdaFactory$(this, date));
    }

    @Nullable
    private Date getBackoffEndTimeInMillis(Date date) {
        Date backoffEndTime = this.frcMetadata.getBackoffMetadata().getBackoffEndTime();
        if (date.before(backoffEndTime)) {
            return backoffEndTime;
        }
        return null;
    }

    private long getRandomizedBackoffDurationInMillis(int i2) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        long millis = timeUnit.toMillis(iArr[Math.min(i2, iArr.length) - 1]);
        return (millis / 2) + this.randomGenerator.nextInt((int) millis);
    }

    @WorkerThread
    private Map<String, String> getUserProperties() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector = this.analyticsConnector;
        if (analyticsConnector == null) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : analyticsConnector.getUserProperties(false).entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    private boolean isThrottleableServerError(int i2) {
        return i2 == 429 || i2 == 502 || i2 == 503 || i2 == 504;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ g lambda$fetchIfCacheExpiredAndNotThrottled$1(ConfigFetchHandler configFetchHandler, g gVar, g gVar2, Date date, g gVar3) throws Exception {
        if (!gVar.n()) {
            return j.d(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", gVar.i()));
        }
        if (!gVar2.n()) {
            return j.d(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", gVar2.i()));
        }
        return configFetchHandler.fetchFromBackendAndCacheResponse((String) gVar.j(), ((InstallationTokenResult) gVar2.j()).getToken(), date);
    }

    private boolean shouldThrottle(ConfigMetadataClient.BackoffMetadata backoffMetadata, int i2) {
        return backoffMetadata.getNumFailedFetches() > 1 || i2 == 429;
    }

    private ConfigMetadataClient.BackoffMetadata updateAndReturnBackoffMetadata(int i2, Date date) {
        if (isThrottleableServerError(i2)) {
            updateBackoffMetadataWithLastFailedFetchTime(date);
        }
        return this.frcMetadata.getBackoffMetadata();
    }

    private void updateBackoffMetadataWithLastFailedFetchTime(Date date) {
        int numFailedFetches = this.frcMetadata.getBackoffMetadata().getNumFailedFetches() + 1;
        this.frcMetadata.setBackoffMetadata(numFailedFetches, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedFetches)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLastFetchStatusAndTime(g<FetchResponse> gVar, Date date) {
        if (gVar.n()) {
            this.frcMetadata.updateLastFetchAsSuccessfulAt(date);
            return;
        }
        Exception i2 = gVar.i();
        if (i2 == null) {
            return;
        }
        if (i2 instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.frcMetadata.updateLastFetchAsThrottled();
        } else {
            this.frcMetadata.updateLastFetchAsFailed();
        }
    }

    public g<FetchResponse> fetch() {
        return fetch(this.frcMetadata.getMinimumFetchIntervalInSeconds());
    }

    @Nullable
    @VisibleForTesting
    public AnalyticsConnector getAnalyticsConnector() {
        return this.analyticsConnector;
    }

    public g<FetchResponse> fetch(long j2) {
        return this.fetchedConfigsCache.get().h(this.executor, ConfigFetchHandler$$Lambda$1.lambdaFactory$(this, j2));
    }
}
