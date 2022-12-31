package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.h;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class RemoteConfigComponent {
    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    @VisibleForTesting
    public static final String DEFAULT_NAMESPACE = "firebase";
    public static final String FETCH_FILE_NAME = "fetch";
    private static final String FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX = "frc";
    private static final String PREFERENCES_FILE_NAME = "settings";
    @Nullable
    private final AnalyticsConnector analyticsConnector;
    private final String appId;
    private final Context context;
    @GuardedBy("this")
    private Map<String, String> customHeaders;
    private final ExecutorService executorService;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    @GuardedBy("this")
    private final Map<String, FirebaseRemoteConfig> frcNamespaceInstances;
    private static final Clock DEFAULT_CLOCK = h.getInstance();
    private static final Random DEFAULT_RANDOM = new Random();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConfigComponent(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, @Nullable AnalyticsConnector analyticsConnector) {
        this(context, Executors.newCachedThreadPool(), firebaseApp, firebaseInstallationsApi, firebaseABTesting, analyticsConnector, true);
    }

    private ConfigCacheClient getCacheClient(String str, String str2) {
        return ConfigCacheClient.getInstance(Executors.newCachedThreadPool(), ConfigStorageClient.getInstance(this.context, String.format("%s_%s_%s_%s.json", "frc", this.appId, str, str2)));
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.executorService, configCacheClient, configCacheClient2);
    }

    @VisibleForTesting
    static ConfigMetadataClient getMetadataClient(Context context, String str, String str2) {
        return new ConfigMetadataClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, PREFERENCES_FILE_NAME), 0));
    }

    @Nullable
    private static Personalization getPersonalization(FirebaseApp firebaseApp, String str, @Nullable AnalyticsConnector analyticsConnector) {
        if (isPrimaryApp(firebaseApp) && str.equals(DEFAULT_NAMESPACE) && analyticsConnector != null) {
            return new Personalization(analyticsConnector);
        }
        return null;
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp, String str) {
        return str.equals(DEFAULT_NAMESPACE) && isPrimaryApp(firebaseApp);
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp) {
        return firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME);
    }

    @VisibleForTesting
    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient cacheClient;
        ConfigCacheClient cacheClient2;
        ConfigCacheClient cacheClient3;
        ConfigMetadataClient metadataClient;
        ConfigGetParameterHandler getHandler;
        cacheClient = getCacheClient(str, FETCH_FILE_NAME);
        cacheClient2 = getCacheClient(str, "activate");
        cacheClient3 = getCacheClient(str, DEFAULTS_FILE_NAME);
        metadataClient = getMetadataClient(this.context, this.appId, str);
        getHandler = getGetHandler(cacheClient2, cacheClient3);
        Personalization personalization = getPersonalization(this.firebaseApp, str, this.analyticsConnector);
        if (personalization != null) {
            personalization.getClass();
            getHandler.addListener(RemoteConfigComponent$$Lambda$4.lambdaFactory$(personalization));
        }
        return get(this.firebaseApp, str, this.firebaseInstallations, this.firebaseAbt, this.executorService, cacheClient, cacheClient2, cacheClient3, getFetchHandler(str, cacheClient, metadataClient), getHandler, metadataClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig getDefault() {
        return get(DEFAULT_NAMESPACE);
    }

    @VisibleForTesting
    synchronized ConfigFetchHandler getFetchHandler(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHandler(this.firebaseInstallations, isPrimaryApp(this.firebaseApp) ? this.analyticsConnector : null, this.executorService, DEFAULT_CLOCK, DEFAULT_RANDOM, configCacheClient, getFrcBackendApiClient(this.firebaseApp.getOptions().getApiKey(), str, configMetadataClient), configMetadataClient, this.customHeaders);
    }

    @VisibleForTesting
    ConfigFetchHttpClient getFrcBackendApiClient(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.context, this.firebaseApp.getOptions().getApplicationId(), str, str2, configMetadataClient.getFetchTimeoutInSeconds(), configMetadataClient.getFetchTimeoutInSeconds());
    }

    @VisibleForTesting
    public synchronized void setCustomHeaders(Map<String, String> map) {
        this.customHeaders = map;
    }

    @VisibleForTesting
    protected RemoteConfigComponent(Context context, ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, @Nullable AnalyticsConnector analyticsConnector, boolean z) {
        this.frcNamespaceInstances = new HashMap();
        this.customHeaders = new HashMap();
        this.context = context;
        this.executorService = executorService;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = analyticsConnector;
        this.appId = firebaseApp.getOptions().getApplicationId();
        if (z) {
            j.c(executorService, RemoteConfigComponent$$Lambda$1.lambdaFactory$(this));
        }
    }

    @VisibleForTesting
    synchronized FirebaseRemoteConfig get(FirebaseApp firebaseApp, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        if (!this.frcNamespaceInstances.containsKey(str)) {
            FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(this.context, firebaseApp, firebaseInstallationsApi, isAbtSupported(firebaseApp, str) ? firebaseABTesting : null, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
            firebaseRemoteConfig.startLoadingConfigsFromDisk();
            this.frcNamespaceInstances.put(str, firebaseRemoteConfig);
        }
        return this.frcNamespaceInstances.get(str);
    }
}
