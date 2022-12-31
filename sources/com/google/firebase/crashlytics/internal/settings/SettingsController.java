package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.h;
import com.google.android.gms.tasks.j;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SettingsController implements SettingsDataProvider {
    private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
    private static final String SETTINGS_URL_FORMAT = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";
    private final AtomicReference<h<AppSettingsData>> appSettingsData;
    private final CachedSettingsIo cachedSettingsIo;
    private final Context context;
    private final CurrentTimeProvider currentTimeProvider;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final AtomicReference<Settings> settings;
    private final SettingsJsonParser settingsJsonParser;
    private final SettingsRequest settingsRequest;
    private final SettingsSpiCall settingsSpiCall;

    SettingsController(Context context, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.settings = atomicReference;
        this.appSettingsData = new AtomicReference<>(new h());
        this.context = context;
        this.settingsRequest = settingsRequest;
        this.currentTimeProvider = currentTimeProvider;
        this.settingsJsonParser = settingsJsonParser;
        this.cachedSettingsIo = cachedSettingsIo;
        this.settingsSpiCall = settingsSpiCall;
        this.dataCollectionArbiter = dataCollectionArbiter;
        atomicReference.set(DefaultSettingsJsonTransform.defaultSettings(currentTimeProvider));
    }

    public static SettingsController create(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, DataCollectionArbiter dataCollectionArbiter) {
        String installerPackageName = idManager.getInstallerPackageName();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        return new SettingsController(context, new SettingsRequest(str, idManager.getModelName(), idManager.getOsBuildVersionString(), idManager.getOsDisplayVersionString(), idManager, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(installerPackageName).getId()), systemCurrentTimeProvider, new SettingsJsonParser(systemCurrentTimeProvider), new CachedSettingsIo(context), new DefaultSettingsSpiCall(String.format(Locale.US, SETTINGS_URL_FORMAT, str), httpRequestFactory), dataCollectionArbiter);
    }

    private SettingsData getCachedSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        SettingsData settingsData = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject readCachedSettings = this.cachedSettingsIo.readCachedSettings();
                if (readCachedSettings != null) {
                    SettingsData parseSettingsJson = this.settingsJsonParser.parseSettingsJson(readCachedSettings);
                    if (parseSettingsJson != null) {
                        logSettings(readCachedSettings, "Loaded cached settings: ");
                        long currentTimeMillis = this.currentTimeProvider.getCurrentTimeMillis();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && parseSettingsJson.isExpired(currentTimeMillis)) {
                            Logger.getLogger().v("Cached settings have expired.");
                        }
                        try {
                            Logger.getLogger().v("Returning cached settings.");
                            settingsData = parseSettingsJson;
                        } catch (Exception e2) {
                            e = e2;
                            settingsData = parseSettingsJson;
                            Logger.getLogger().e("Failed to get cached settings", e);
                            return settingsData;
                        }
                    } else {
                        Logger.getLogger().e("Failed to parse cached settings data.", null);
                    }
                } else {
                    Logger.getLogger().d("No cached settings data found.");
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return settingsData;
    }

    private String getStoredBuildInstanceIdentifier() {
        return CommonUtils.getSharedPrefs(this.context).getString(PREFS_BUILD_INSTANCE_IDENTIFIER, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logSettings(JSONObject jSONObject, String str) throws JSONException {
        Logger logger = Logger.getLogger();
        logger.d(str + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean setStoredBuildInstanceIdentifier(String str) {
        SharedPreferences.Editor edit = CommonUtils.getSharedPrefs(this.context).edit();
        edit.putString(PREFS_BUILD_INSTANCE_IDENTIFIER, str);
        edit.apply();
        return true;
    }

    boolean buildInstanceIdentifierChanged() {
        return !getStoredBuildInstanceIdentifier().equals(this.settingsRequest.instanceId);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    public g<AppSettingsData> getAppSettings() {
        return this.appSettingsData.get().a();
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    public Settings getSettings() {
        return this.settings.get();
    }

    public g<Void> loadSettingsData(Executor executor) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public g<Void> loadSettingsData(SettingsCacheBehavior settingsCacheBehavior, Executor executor) {
        SettingsData cachedSettingsData;
        if (!buildInstanceIdentifierChanged() && (cachedSettingsData = getCachedSettingsData(settingsCacheBehavior)) != null) {
            this.settings.set(cachedSettingsData);
            this.appSettingsData.get().e(cachedSettingsData.getAppSettingsData());
            return j.e(null);
        }
        SettingsData cachedSettingsData2 = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (cachedSettingsData2 != null) {
            this.settings.set(cachedSettingsData2);
            this.appSettingsData.get().e(cachedSettingsData2.getAppSettingsData());
        }
        return this.dataCollectionArbiter.waitForDataCollectionPermission().p(executor, new f<Void, Void>() { // from class: com.google.firebase.crashlytics.internal.settings.SettingsController.1
            @Override // com.google.android.gms.tasks.f
            @NonNull
            public g<Void> then(@Nullable Void r5) throws Exception {
                JSONObject invoke = SettingsController.this.settingsSpiCall.invoke(SettingsController.this.settingsRequest, true);
                if (invoke != null) {
                    SettingsData parseSettingsJson = SettingsController.this.settingsJsonParser.parseSettingsJson(invoke);
                    SettingsController.this.cachedSettingsIo.writeCachedSettings(parseSettingsJson.getExpiresAtMillis(), invoke);
                    SettingsController.this.logSettings(invoke, "Loaded settings: ");
                    SettingsController settingsController = SettingsController.this;
                    settingsController.setStoredBuildInstanceIdentifier(settingsController.settingsRequest.instanceId);
                    SettingsController.this.settings.set(parseSettingsJson);
                    ((h) SettingsController.this.appSettingsData.get()).e(parseSettingsJson.getAppSettingsData());
                    h hVar = new h();
                    hVar.e(parseSettingsJson.getAppSettingsData());
                    SettingsController.this.appSettingsData.set(hVar);
                }
                return j.e(null);
            }
        });
    }
}
