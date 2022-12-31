package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final String TAG = "FirebaseRemoteConfig";
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;
    private final ConfigCacheClient activatedConfigsCache;
    private final Context context;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final ConfigFetchHandler fetchHandler;
    private final ConfigCacheClient fetchedConfigsCache;
    @Nullable
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigMetadataClient frcMetadata;
    private final ConfigGetParameterHandler getHandler;

    public FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        this.context = context;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.executor = executor;
        this.fetchedConfigsCache = configCacheClient;
        this.activatedConfigsCache = configCacheClient2;
        this.defaultConfigsCache = configCacheClient3;
        this.fetchHandler = configFetchHandler;
        this.getHandler = configGetParameterHandler;
        this.frcMetadata = configMetadataClient;
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private static boolean isFetchedFresh(ConfigContainer configContainer, @Nullable ConfigContainer configContainer2) {
        return configContainer2 == null || !configContainer.getFetchTime().equals(configContainer2.getFetchTime());
    }

    public static /* synthetic */ g lambda$activate$2(FirebaseRemoteConfig firebaseRemoteConfig, g gVar, g gVar2, g gVar3) throws Exception {
        if (gVar.n() && gVar.j() != null) {
            ConfigContainer configContainer = (ConfigContainer) gVar.j();
            if (gVar2.n() && !isFetchedFresh(configContainer, (ConfigContainer) gVar2.j())) {
                return j.e(Boolean.FALSE);
            }
            return firebaseRemoteConfig.activatedConfigsCache.put(configContainer).f(firebaseRemoteConfig.executor, FirebaseRemoteConfig$$Lambda$10.lambdaFactory$(firebaseRemoteConfig));
        }
        return j.e(Boolean.FALSE);
    }

    public static /* synthetic */ FirebaseRemoteConfigInfo lambda$ensureInitialized$0(g gVar, g gVar2) throws Exception {
        return (FirebaseRemoteConfigInfo) gVar.j();
    }

    public static /* synthetic */ Void lambda$reset$6(FirebaseRemoteConfig firebaseRemoteConfig) throws Exception {
        firebaseRemoteConfig.activatedConfigsCache.clear();
        firebaseRemoteConfig.fetchedConfigsCache.clear();
        firebaseRemoteConfig.defaultConfigsCache.clear();
        firebaseRemoteConfig.frcMetadata.clear();
        return null;
    }

    public boolean processActivatePutTask(g<ConfigContainer> gVar) {
        if (gVar.n()) {
            this.fetchedConfigsCache.clear();
            if (gVar.j() != null) {
                updateAbtWithActivatedExperiments(gVar.j().getAbtExperiments());
                return true;
            }
            Log.e(TAG, "Activated configs written to disk are null.");
            return true;
        }
        return false;
    }

    private g<Void> setDefaultsWithStringsMapAsync(Map<String, String> map) {
        f<ConfigContainer, TContinuationResult> fVar;
        try {
            g<ConfigContainer> put = this.defaultConfigsCache.put(ConfigContainer.newBuilder().replaceConfigsWith(map).build());
            fVar = FirebaseRemoteConfig$$Lambda$9.instance;
            return put.o(fVar);
        } catch (JSONException e2) {
            Log.e(TAG, "The provided defaults map could not be processed.", e2);
            return j.e(null);
        }
    }

    @VisibleForTesting
    static List<Map<String, String>> toExperimentInfoMaps(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @NonNull
    public g<Boolean> activate() {
        g<ConfigContainer> gVar = this.fetchedConfigsCache.get();
        g<ConfigContainer> gVar2 = this.activatedConfigsCache.get();
        return j.i(gVar, gVar2).h(this.executor, FirebaseRemoteConfig$$Lambda$4.lambdaFactory$(this, gVar, gVar2));
    }

    @NonNull
    public g<FirebaseRemoteConfigInfo> ensureInitialized() {
        g<ConfigContainer> gVar = this.activatedConfigsCache.get();
        g<ConfigContainer> gVar2 = this.defaultConfigsCache.get();
        g<ConfigContainer> gVar3 = this.fetchedConfigsCache.get();
        g c = j.c(this.executor, FirebaseRemoteConfig$$Lambda$1.lambdaFactory$(this));
        return j.i(gVar, gVar2, gVar3, c, this.firebaseInstallations.getId(), this.firebaseInstallations.getToken(false)).f(this.executor, FirebaseRemoteConfig$$Lambda$2.lambdaFactory$(c));
    }

    @NonNull
    public g<Void> fetch() {
        f<ConfigFetchHandler.FetchResponse, TContinuationResult> fVar;
        g<ConfigFetchHandler.FetchResponse> fetch = this.fetchHandler.fetch();
        fVar = FirebaseRemoteConfig$$Lambda$5.instance;
        return fetch.o(fVar);
    }

    @NonNull
    public g<Boolean> fetchAndActivate() {
        return fetch().p(this.executor, FirebaseRemoteConfig$$Lambda$3.lambdaFactory$(this));
    }

    @NonNull
    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.getHandler.getAll();
    }

    public boolean getBoolean(@NonNull String str) {
        return this.getHandler.getBoolean(str);
    }

    public double getDouble(@NonNull String str) {
        return this.getHandler.getDouble(str);
    }

    @NonNull
    public FirebaseRemoteConfigInfo getInfo() {
        return this.frcMetadata.getInfo();
    }

    @NonNull
    public Set<String> getKeysByPrefix(@NonNull String str) {
        return this.getHandler.getKeysByPrefix(str);
    }

    public long getLong(@NonNull String str) {
        return this.getHandler.getLong(str);
    }

    @NonNull
    public String getString(@NonNull String str) {
        return this.getHandler.getString(str);
    }

    @NonNull
    public FirebaseRemoteConfigValue getValue(@NonNull String str) {
        return this.getHandler.getValue(str);
    }

    @NonNull
    public g<Void> reset() {
        return j.c(this.executor, FirebaseRemoteConfig$$Lambda$8.lambdaFactory$(this));
    }

    @NonNull
    public g<Void> setConfigSettingsAsync(@NonNull FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return j.c(this.executor, FirebaseRemoteConfig$$Lambda$7.lambdaFactory$(this, firebaseRemoteConfigSettings));
    }

    @NonNull
    public g<Void> setDefaultsAsync(@NonNull Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                hashMap.put(entry.getKey(), new String((byte[]) value));
            } else {
                hashMap.put(entry.getKey(), value.toString());
            }
        }
        return setDefaultsWithStringsMapAsync(hashMap);
    }

    public void startLoadingConfigsFromDisk() {
        this.activatedConfigsCache.get();
        this.defaultConfigsCache.get();
        this.fetchedConfigsCache.get();
    }

    @VisibleForTesting
    void updateAbtWithActivatedExperiments(@NonNull JSONArray jSONArray) {
        if (this.firebaseAbt == null) {
            return;
        }
        try {
            this.firebaseAbt.replaceAllExperiments(toExperimentInfoMaps(jSONArray));
        } catch (AbtException e2) {
            Log.w(TAG, "Could not update ABT experiments.", e2);
        } catch (JSONException e3) {
            Log.e(TAG, "Could not parse ABT experiments from the JSON response.", e3);
        }
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance(@NonNull FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.get(RemoteConfigComponent.class)).getDefault();
    }

    @NonNull
    public g<Void> fetch(long j2) {
        f<ConfigFetchHandler.FetchResponse, TContinuationResult> fVar;
        g<ConfigFetchHandler.FetchResponse> fetch = this.fetchHandler.fetch(j2);
        fVar = FirebaseRemoteConfig$$Lambda$6.instance;
        return fetch.o(fVar);
    }

    @NonNull
    public g<Void> setDefaultsAsync(@XmlRes int i2) {
        return setDefaultsWithStringsMapAsync(DefaultsXmlParser.getDefaultsFromXml(this.context, i2));
    }
}
