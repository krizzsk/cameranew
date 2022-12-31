package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.h;
import com.google.android.gms.tasks.j;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class CrashlyticsController {
    static final FilenameFilter APP_EXCEPTION_MARKER_FILTER;
    static final String APP_EXCEPTION_MARKER_PREFIX = ".ae";
    static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
    static final String FIREBASE_CRASH_TYPE = "fatal";
    static final int FIREBASE_CRASH_TYPE_FATAL = 1;
    static final String FIREBASE_TIMESTAMP = "timestamp";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    static final String NATIVE_SESSION_DIR = "native-sessions";
    private final AnalyticsEventLogger analyticsEventLogger;
    private final AppData appData;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    private final Context context;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    private final CrashlyticsFileMarker crashMarker;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final FileStore fileStore;
    private final IdManager idManager;
    private final LogFileManager.DirectoryProvider logFileDirectoryProvider;
    private final LogFileManager logFileManager;
    private final CrashlyticsNativeComponent nativeComponent;
    private final SessionReportingCoordinator reportingCoordinator;
    private final String unityVersion;
    private final UserMetadata userMetadata;
    final h<Boolean> unsentReportsAvailable = new h<>();
    final h<Boolean> reportActionProvided = new h<>();
    final h<Void> unsentReportsHandled = new h<>();
    final AtomicBoolean checkForUnsentReportsCalled = new AtomicBoolean(false);

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$4 */
    /* loaded from: classes2.dex */
    public class AnonymousClass4 implements f<Boolean, Void> {
        final /* synthetic */ g val$appSettingsDataTask;

        AnonymousClass4(g gVar) {
            CrashlyticsController.this = r1;
            this.val$appSettingsDataTask = gVar;
        }

        @Override // com.google.android.gms.tasks.f
        @NonNull
        public g<Void> then(@Nullable final Boolean bool) throws Exception {
            return CrashlyticsController.this.backgroundWorker.submitTask(new Callable<g<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1
                {
                    AnonymousClass4.this = this;
                }

                @Override // java.util.concurrent.Callable
                public g<Void> call() throws Exception {
                    if (!bool.booleanValue()) {
                        Logger.getLogger().v("Deleting cached crash reports...");
                        CrashlyticsController.deleteFiles(CrashlyticsController.this.listAppExceptionMarkerFiles());
                        CrashlyticsController.this.reportingCoordinator.removeAllReports();
                        CrashlyticsController.this.unsentReportsHandled.e(null);
                        return j.e(null);
                    }
                    Logger.getLogger().d("Sending cached crash reports...");
                    CrashlyticsController.this.dataCollectionArbiter.grantDataCollectionPermission(bool.booleanValue());
                    final Executor executor = CrashlyticsController.this.backgroundWorker.getExecutor();
                    return AnonymousClass4.this.val$appSettingsDataTask.p(executor, new f<AppSettingsData, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // com.google.android.gms.tasks.f
                        @NonNull
                        public g<Void> then(@Nullable AppSettingsData appSettingsData) throws Exception {
                            if (appSettingsData != null) {
                                CrashlyticsController.this.logAnalyticsAppExceptionEvents();
                                CrashlyticsController.this.reportingCoordinator.sendReports(executor);
                                CrashlyticsController.this.unsentReportsHandled.e(null);
                                return j.e(null);
                            }
                            Logger.getLogger().w("Received null app settings at app startup. Cannot send cached reports");
                            return j.e(null);
                        }
                    });
                }
            });
        }
    }

    static {
        FilenameFilter filenameFilter;
        filenameFilter = CrashlyticsController$$Lambda$1.instance;
        APP_EXCEPTION_MARKER_FILTER = filenameFilter;
    }

    public CrashlyticsController(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, UserMetadata userMetadata, LogFileManager logFileManager, LogFileManager.DirectoryProvider directoryProvider, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger) {
        this.context = context;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.idManager = idManager;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.fileStore = fileStore;
        this.crashMarker = crashlyticsFileMarker;
        this.appData = appData;
        this.userMetadata = userMetadata;
        this.logFileManager = logFileManager;
        this.logFileDirectoryProvider = directoryProvider;
        this.nativeComponent = crashlyticsNativeComponent;
        this.unityVersion = appData.unityVersionProvider.getUnityVersion();
        this.analyticsEventLogger = analyticsEventLogger;
        this.reportingCoordinator = sessionReportingCoordinator;
    }

    private void cacheKeyData(final Map<String, String> map) {
        this.backgroundWorker.submit(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.8
            {
                CrashlyticsController.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeKeyData(CrashlyticsController.this.getCurrentSessionId(), map);
                return null;
            }
        });
    }

    private void cacheUserData(final UserMetadata userMetadata) {
        this.backgroundWorker.submit(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.7
            {
                CrashlyticsController.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                String currentSessionId = CrashlyticsController.this.getCurrentSessionId();
                if (currentSessionId != null) {
                    CrashlyticsController.this.reportingCoordinator.persistUserId(currentSessionId);
                    new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeUserData(currentSessionId, userMetadata);
                    return null;
                }
                Logger.getLogger().d("Tried to cache user data while no session was open.");
                return null;
            }
        });
    }

    public static void deleteFiles(File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            file.delete();
        }
    }

    public void doOpenSession() {
        long currentTimestampSeconds = getCurrentTimestampSeconds();
        String clsuuid = new CLSUUID(this.idManager).toString();
        Logger logger = Logger.getLogger();
        logger.d("Opening a new session with ID " + clsuuid);
        this.nativeComponent.openSession(clsuuid);
        writeBeginSession(clsuuid, currentTimestampSeconds);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
        this.reportingCoordinator.onBeginSession(clsuuid, currentTimestampSeconds);
    }

    public void doWriteAppExceptionMarker(long j2) {
        try {
            File filesDir = getFilesDir();
            new File(filesDir, APP_EXCEPTION_MARKER_PREFIX + j2).createNewFile();
        } catch (IOException e2) {
            Logger.getLogger().w("Could not create app exception marker file.", e2);
        }
    }

    private static File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void finalizePreviousNativeSession(String str) {
        Logger logger = Logger.getLogger();
        logger.v("Finalizing native report for session " + str);
        NativeSessionFileProvider sessionFileProvider = this.nativeComponent.getSessionFileProvider(str);
        File minidumpFile = sessionFileProvider.getMinidumpFile();
        if (minidumpFile != null && minidumpFile.exists()) {
            long lastModified = minidumpFile.lastModified();
            LogFileManager logFileManager = new LogFileManager(this.context, this.logFileDirectoryProvider, str);
            File file = new File(getNativeSessionFilesDir(), str);
            if (!file.mkdirs()) {
                Logger.getLogger().w("Couldn't create directory to store native session files, aborting.");
                return;
            }
            doWriteAppExceptionMarker(lastModified);
            List<NativeSessionFile> nativeSessionFiles = getNativeSessionFiles(sessionFileProvider, str, getFilesDir(), logFileManager.getBytesForLog());
            NativeSessionFileGzipper.processNativeSessions(file, nativeSessionFiles);
            this.reportingCoordinator.finalizeSessionWithNativeEvent(str, nativeSessionFiles);
            logFileManager.clearLog();
            return;
        }
        Logger logger2 = Logger.getLogger();
        logger2.w("No minidump data found for session " + str);
    }

    private static boolean firebaseCrashExists() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private Context getContext() {
        return this.context;
    }

    @Nullable
    public String getCurrentSessionId() {
        List<String> listSortedOpenSessionIds = this.reportingCoordinator.listSortedOpenSessionIds();
        if (listSortedOpenSessionIds.isEmpty()) {
            return null;
        }
        return listSortedOpenSessionIds.get(0);
    }

    private static long getCurrentTimestampSeconds() {
        return getTimestampSeconds(new Date());
    }

    @NonNull
    static List<NativeSessionFile> getNativeSessionFiles(NativeSessionFileProvider nativeSessionFileProvider, String str, File file, byte[] bArr) {
        MetaDataStore metaDataStore = new MetaDataStore(file);
        File userDataFileForSession = metaDataStore.getUserDataFileForSession(str);
        File keysFileForSession = metaDataStore.getKeysFileForSession(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.getMetadataFile()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.getSessionFile()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.getAppFile()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, nativeSessionFileProvider.getDeviceFile()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProvider.getOsFile()));
        arrayList.add(new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProvider.getMinidumpFile()));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", "user", userDataFileForSession));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", "keys", keysFileForSession));
        return arrayList;
    }

    public static long getTimestampSeconds(Date date) {
        return date.getTime() / 1000;
    }

    private File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private g<Void> logAnalyticsAppExceptionEvent(final long j2) {
        if (firebaseCrashExists()) {
            Logger.getLogger().w("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return j.e(null);
        }
        Logger.getLogger().d("Logging app exception event to Firebase Analytics");
        return j.c(new ScheduledThreadPoolExecutor(1), new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.10
            {
                CrashlyticsController.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                Bundle bundle = new Bundle();
                bundle.putInt(CrashlyticsController.FIREBASE_CRASH_TYPE, 1);
                bundle.putLong("timestamp", j2);
                CrashlyticsController.this.analyticsEventLogger.logEvent(CrashlyticsController.FIREBASE_APPLICATION_EXCEPTION, bundle);
                return null;
            }
        });
    }

    public g<Void> logAnalyticsAppExceptionEvents() {
        File[] listAppExceptionMarkerFiles;
        ArrayList arrayList = new ArrayList();
        for (File file : listAppExceptionMarkerFiles()) {
            try {
                arrayList.add(logAnalyticsAppExceptionEvent(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger.getLogger().w("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return j.f(arrayList);
    }

    private g<Boolean> waitForReportAction() {
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            this.unsentReportsAvailable.e(Boolean.FALSE);
            return j.e(Boolean.TRUE);
        }
        Logger.getLogger().d("Automatic data collection is disabled.");
        Logger.getLogger().v("Notifying that unsent reports are available.");
        this.unsentReportsAvailable.e(Boolean.TRUE);
        g<TContinuationResult> o = this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled().o(new f<Void, Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.3
            {
                CrashlyticsController.this = this;
            }

            @Override // com.google.android.gms.tasks.f
            @NonNull
            public g<Boolean> then(@Nullable Void r1) throws Exception {
                return j.e(Boolean.TRUE);
            }
        });
        Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
        return Utils.race(o, this.reportActionProvided.a());
    }

    private void writeBeginSession(String str, long j2) {
        this.nativeComponent.writeBeginSession(str, String.format(Locale.US, GENERATOR_FORMAT, CrashlyticsCore.getVersion()), j2);
    }

    private void writeSessionApp(String str) {
        String appIdentifier = this.idManager.getAppIdentifier();
        AppData appData = this.appData;
        this.nativeComponent.writeSessionApp(str, appIdentifier, appData.versionCode, appData.versionName, this.idManager.getCrashlyticsInstallId(), DeliveryMechanism.determineFrom(this.appData.installerPackageName).getId(), this.unityVersion);
    }

    private void writeSessionDevice(String str) {
        Context context = getContext();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int cpuArchitectureInt = CommonUtils.getCpuArchitectureInt();
        String str2 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockSize = statFs.getBlockSize();
        this.nativeComponent.writeSessionDevice(str, cpuArchitectureInt, str2, availableProcessors, totalRamInBytes, blockSize * statFs.getBlockCount(), CommonUtils.isEmulator(context), CommonUtils.getDeviceState(context), Build.MANUFACTURER, Build.PRODUCT);
    }

    private void writeSessionOS(String str) {
        this.nativeComponent.writeSessionOs(str, Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.isRooted(getContext()));
    }

    @NonNull
    public g<Boolean> checkForUnsentReports() {
        if (!this.checkForUnsentReportsCalled.compareAndSet(false, true)) {
            Logger.getLogger().w("checkForUnsentReports should only be called once per execution.");
            return j.e(Boolean.FALSE);
        }
        return this.unsentReportsAvailable.a();
    }

    public g<Void> deleteUnsentReports() {
        this.reportActionProvided.e(Boolean.FALSE);
        return this.unsentReportsHandled.a();
    }

    public boolean didCrashOnPreviousExecution() {
        if (!this.crashMarker.isPresent()) {
            String currentSessionId = getCurrentSessionId();
            return currentSessionId != null && this.nativeComponent.hasCrashDataForSession(currentSessionId);
        }
        Logger.getLogger().v("Found previous crash marker.");
        this.crashMarker.remove();
        return true;
    }

    void doCloseSessions() {
        doCloseSessions(false);
    }

    public void enableExceptionHandling(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsDataProvider settingsDataProvider) {
        openSession();
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.1
            {
                CrashlyticsController.this = this;
            }

            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.CrashListener
            public void onUncaughtException(@NonNull SettingsDataProvider settingsDataProvider2, @NonNull Thread thread, @NonNull Throwable th) {
                CrashlyticsController.this.handleUncaughtException(settingsDataProvider2, thread, th);
            }
        }, settingsDataProvider, uncaughtExceptionHandler);
        this.crashHandler = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    public boolean finalizeSessions() {
        this.backgroundWorker.checkRunningOnThread();
        if (isHandlingException()) {
            Logger.getLogger().w("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.getLogger().v("Finalizing previously open sessions.");
        try {
            doCloseSessions(true);
            Logger.getLogger().v("Closed all previously open sessions.");
            return true;
        } catch (Exception e2) {
            Logger.getLogger().e("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }

    File getFilesDir() {
        return this.fileStore.getFilesDir();
    }

    File getNativeSessionFilesDir() {
        return new File(getFilesDir(), NATIVE_SESSION_DIR);
    }

    UserMetadata getUserMetadata() {
        return this.userMetadata;
    }

    synchronized void handleUncaughtException(@NonNull final SettingsDataProvider settingsDataProvider, @NonNull final Thread thread, @NonNull final Throwable th) {
        Logger logger = Logger.getLogger();
        logger.d("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        final Date date = new Date();
        try {
            Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submitTask(new Callable<g<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2
                {
                    CrashlyticsController.this = this;
                }

                @Override // java.util.concurrent.Callable
                public g<Void> call() throws Exception {
                    long timestampSeconds = CrashlyticsController.getTimestampSeconds(date);
                    String currentSessionId = CrashlyticsController.this.getCurrentSessionId();
                    if (currentSessionId != null) {
                        CrashlyticsController.this.crashMarker.create();
                        CrashlyticsController.this.reportingCoordinator.persistFatalEvent(th, thread, currentSessionId, timestampSeconds);
                        CrashlyticsController.this.doWriteAppExceptionMarker(date.getTime());
                        CrashlyticsController.this.doCloseSessions();
                        CrashlyticsController.this.doOpenSession();
                        if (CrashlyticsController.this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
                            final Executor executor = CrashlyticsController.this.backgroundWorker.getExecutor();
                            return settingsDataProvider.getAppSettings().p(executor, new f<AppSettingsData, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2.1
                                {
                                    AnonymousClass2.this = this;
                                }

                                @Override // com.google.android.gms.tasks.f
                                @NonNull
                                public g<Void> then(@Nullable AppSettingsData appSettingsData) throws Exception {
                                    if (appSettingsData == null) {
                                        Logger.getLogger().w("Received null app settings, cannot send reports at crash time.");
                                        return j.e(null);
                                    }
                                    return j.g(CrashlyticsController.this.logAnalyticsAppExceptionEvents(), CrashlyticsController.this.reportingCoordinator.sendReports(executor));
                                }
                            });
                        }
                        return j.e(null);
                    }
                    Logger.getLogger().e("Tried to write a fatal exception while no session was open.");
                    return j.e(null);
                }
            }));
        } catch (Exception e2) {
            Logger.getLogger().e("Error handling uncaught exception", e2);
        }
    }

    boolean isHandlingException() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.isHandlingException();
    }

    File[] listAppExceptionMarkerFiles() {
        return listFilesMatching(APP_EXCEPTION_MARKER_FILTER);
    }

    File[] listNativeSessionFileDirectories() {
        return ensureFileArrayNotNull(getNativeSessionFilesDir().listFiles());
    }

    void openSession() {
        this.backgroundWorker.submit(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.9
            {
                CrashlyticsController.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                CrashlyticsController.this.doOpenSession();
                return null;
            }
        });
    }

    public g<Void> sendUnsentReports() {
        this.reportActionProvided.e(Boolean.TRUE);
        return this.unsentReportsHandled.a();
    }

    public void setCustomKey(String str, String str2) {
        try {
            this.userMetadata.setCustomKey(str, str2);
            cacheKeyData(this.userMetadata.getCustomKeys());
        } catch (IllegalArgumentException e2) {
            Context context = this.context;
            if (context != null && CommonUtils.isAppDebuggable(context)) {
                throw e2;
            }
            Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    public void setCustomKeys(Map<String, String> map) {
        this.userMetadata.setCustomKeys(map);
        cacheKeyData(this.userMetadata.getCustomKeys());
    }

    public void setUserId(String str) {
        this.userMetadata.setUserId(str);
        cacheUserData(this.userMetadata);
    }

    public g<Void> submitAllReports(g<AppSettingsData> gVar) {
        if (!this.reportingCoordinator.hasReportsToSend()) {
            Logger.getLogger().v("No crash reports are available to be sent.");
            this.unsentReportsAvailable.e(Boolean.FALSE);
            return j.e(null);
        }
        Logger.getLogger().v("Crash reports are available to be sent.");
        return waitForReportAction().o(new AnonymousClass4(gVar));
    }

    public void writeNonFatalException(@NonNull final Thread thread, @NonNull final Throwable th) {
        final Date date = new Date();
        this.backgroundWorker.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.6
            {
                CrashlyticsController.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (CrashlyticsController.this.isHandlingException()) {
                    return;
                }
                long timestampSeconds = CrashlyticsController.getTimestampSeconds(date);
                String currentSessionId = CrashlyticsController.this.getCurrentSessionId();
                if (currentSessionId != null) {
                    CrashlyticsController.this.reportingCoordinator.persistNonFatalEvent(th, thread, currentSessionId, timestampSeconds);
                } else {
                    Logger.getLogger().w("Tried to write a non-fatal exception while no session was open.");
                }
            }
        });
    }

    public void writeToLog(final long j2, final String str) {
        this.backgroundWorker.submit(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.5
            {
                CrashlyticsController.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (CrashlyticsController.this.isHandlingException()) {
                    return null;
                }
                CrashlyticsController.this.logFileManager.writeToLog(j2, str);
                return null;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void doCloseSessions(boolean z) {
        List<String> listSortedOpenSessionIds = this.reportingCoordinator.listSortedOpenSessionIds();
        if (listSortedOpenSessionIds.size() <= z) {
            Logger.getLogger().v("No open sessions to be closed.");
            return;
        }
        String str = listSortedOpenSessionIds.get(z ? 1 : 0);
        if (this.nativeComponent.hasCrashDataForSession(str)) {
            finalizePreviousNativeSession(str);
            if (!this.nativeComponent.finalizeSession(str)) {
                Logger logger = Logger.getLogger();
                logger.w("Could not finalize native session: " + str);
            }
        }
        this.reportingCoordinator.finalizeSessions(getCurrentTimestampSeconds(), z != 0 ? listSortedOpenSessionIds.get(0) : null);
    }

    private static File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }
}
