package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.MissingNativeComponent;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class FirebaseCrashlytics {
    private static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    private static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    private final CrashlyticsCore core;

    private FirebaseCrashlytics(@NonNull CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.firebase.crashlytics.CrashlyticsAnalyticsListener] */
    /* JADX WARN: Type inference failed for: r13v7, types: [com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger] */
    /* JADX WARN: Type inference failed for: r14v13, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger] */
    @Nullable
    public static FirebaseCrashlytics init(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseInstallationsApi firebaseInstallationsApi, @Nullable CrashlyticsNativeComponent crashlyticsNativeComponent, @Nullable AnalyticsConnector analyticsConnector) {
        DisabledBreadcrumbSource disabledBreadcrumbSource;
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger;
        DisabledBreadcrumbSource disabledBreadcrumbSource2;
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger2;
        Logger logger = Logger.getLogger();
        logger.i("Initializing Firebase Crashlytics " + CrashlyticsCore.getVersion());
        Context applicationContext = firebaseApp.getApplicationContext();
        IdManager idManager = new IdManager(applicationContext, applicationContext.getPackageName(), firebaseInstallationsApi);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        if (crashlyticsNativeComponent == null) {
            crashlyticsNativeComponent = new MissingNativeComponent();
        }
        CrashlyticsNativeComponent crashlyticsNativeComponent2 = crashlyticsNativeComponent;
        if (analyticsConnector != null) {
            ?? crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
            ?? crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
            if (subscribeToAnalyticsEvents(analyticsConnector, crashlyticsAnalyticsListener) != null) {
                Logger.getLogger().d("Registered Firebase Analytics listener.");
                ?? breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
                ?? blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
                crashlyticsAnalyticsListener.setBreadcrumbEventReceiver(breadcrumbAnalyticsEventReceiver);
                crashlyticsAnalyticsListener.setCrashlyticsOriginEventReceiver(blockingAnalyticsEventLogger);
                unavailableAnalyticsEventLogger2 = blockingAnalyticsEventLogger;
                disabledBreadcrumbSource2 = breadcrumbAnalyticsEventReceiver;
            } else {
                Logger.getLogger().w("Could not register Firebase Analytics listener; a listener is already registered.");
                unavailableAnalyticsEventLogger2 = crashlyticsOriginAnalyticsEventLogger;
                disabledBreadcrumbSource2 = new DisabledBreadcrumbSource();
            }
            unavailableAnalyticsEventLogger = unavailableAnalyticsEventLogger2;
            disabledBreadcrumbSource = disabledBreadcrumbSource2;
        } else {
            Logger.getLogger().d("Firebase Analytics is not available.");
            disabledBreadcrumbSource = new DisabledBreadcrumbSource();
            unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
        }
        final CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponent2, dataCollectionArbiter, disabledBreadcrumbSource, unavailableAnalyticsEventLogger, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
        String applicationId = firebaseApp.getOptions().getApplicationId();
        String mappingFileId = CommonUtils.getMappingFileId(applicationContext);
        Logger logger2 = Logger.getLogger();
        logger2.d("Mapping file ID is: " + mappingFileId);
        try {
            AppData create = AppData.create(applicationContext, idManager, applicationId, mappingFileId, new ResourceUnityVersionProvider(applicationContext));
            Logger logger3 = Logger.getLogger();
            logger3.v("Installer package name is: " + create.installerPackageName);
            ExecutorService buildSingleThreadExecutorService = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
            final SettingsController create2 = SettingsController.create(applicationContext, applicationId, idManager, new HttpRequestFactory(), create.versionCode, create.versionName, dataCollectionArbiter);
            create2.loadSettingsData(buildSingleThreadExecutorService).f(buildSingleThreadExecutorService, new a<Void, Object>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.1
                @Override // com.google.android.gms.tasks.a
                public Object then(@NonNull g<Void> gVar) throws Exception {
                    if (gVar.n()) {
                        return null;
                    }
                    Logger.getLogger().e("Error fetching settings.", gVar.i());
                    return null;
                }
            });
            final boolean onPreExecute = crashlyticsCore.onPreExecute(create, create2);
            j.c(buildSingleThreadExecutorService, new Callable<Void>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.2
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    if (onPreExecute) {
                        crashlyticsCore.doBackgroundInitializationAsync(create2);
                        return null;
                    }
                    return null;
                }
            });
            return new FirebaseCrashlytics(crashlyticsCore);
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.getLogger().e("Error retrieving app package info.", e2);
            return null;
        }
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(@NonNull AnalyticsConnector analyticsConnector, @NonNull CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener(FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN, crashlyticsAnalyticsListener);
        if (registerAnalyticsConnectorListener == null) {
            Logger.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener(LEGACY_CRASH_ANALYTICS_ORIGIN, crashlyticsAnalyticsListener);
            if (registerAnalyticsConnectorListener != null) {
                Logger.getLogger().w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return registerAnalyticsConnectorListener;
    }

    @NonNull
    public g<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void log(@NonNull String str) {
        this.core.log(str);
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            Logger.getLogger().w("A null value was passed to recordException. Ignoring.");
        } else {
            this.core.logException(th);
        }
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCustomKey(@NonNull String str, boolean z) {
        this.core.setCustomKey(str, Boolean.toString(z));
    }

    public void setCustomKeys(@NonNull CustomKeysAndValues customKeysAndValues) {
        this.core.setCustomKeys(customKeysAndValues.keysAndValues);
    }

    public void setUserId(@NonNull String str) {
        this.core.setUserId(str);
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.core.setCrashlyticsCollectionEnabled(bool);
    }

    public void setCustomKey(@NonNull String str, double d2) {
        this.core.setCustomKey(str, Double.toString(d2));
    }

    public void setCustomKey(@NonNull String str, float f2) {
        this.core.setCustomKey(str, Float.toString(f2));
    }

    public void setCustomKey(@NonNull String str, int i2) {
        this.core.setCustomKey(str, Integer.toString(i2));
    }

    public void setCustomKey(@NonNull String str, long j2) {
        this.core.setCustomKey(str, Long.toString(j2));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.core.setCustomKey(str, str2);
    }
}
