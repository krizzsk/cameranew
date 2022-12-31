package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class SessionReportingCoordinator implements CrashlyticsLifecycleEvents {
    private static final int EVENT_THREAD_IMPORTANCE = 4;
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
    private final CrashlyticsReportDataCapture dataCapture;
    private final LogFileManager logFileManager;
    private final UserMetadata reportMetadata;
    private final CrashlyticsReportPersistence reportPersistence;
    private final DataTransportCrashlyticsReportSender reportsSender;

    SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.dataCapture = crashlyticsReportDataCapture;
        this.reportPersistence = crashlyticsReportPersistence;
        this.reportsSender = dataTransportCrashlyticsReportSender;
        this.logFileManager = logFileManager;
        this.reportMetadata = userMetadata;
    }

    public static SessionReportingCoordinator create(Context context, IdManager idManager, FileStore fileStore, AppData appData, LogFileManager logFileManager, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsDataProvider settingsDataProvider) {
        return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager, appData, stackTraceTrimmingStrategy), new CrashlyticsReportPersistence(new File(fileStore.getFilesDirPath()), settingsDataProvider), DataTransportCrashlyticsReportSender.create(context), logFileManager, userMetadata);
    }

    @NonNull
    private static List<CrashlyticsReport.CustomAttribute> getSortedCustomAttributes(@NonNull Map<String, String> map) {
        Comparator comparator;
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.builder().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        comparator = SessionReportingCoordinator$$Lambda$2.instance;
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean onReportSendComplete(@NonNull g<CrashlyticsReportWithSessionId> gVar) {
        if (gVar.n()) {
            CrashlyticsReportWithSessionId j2 = gVar.j();
            Logger logger = Logger.getLogger();
            logger.d("Crashlytics report successfully enqueued to DataTransport: " + j2.getSessionId());
            this.reportPersistence.deleteFinalizedReport(j2.getSessionId());
            return true;
        }
        Logger.getLogger().w("Crashlytics report could not be enqueued to DataTransport", gVar.i());
        return false;
    }

    private void persistEvent(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j2, boolean z) {
        boolean equals = str2.equals(EVENT_TYPE_CRASH);
        CrashlyticsReport.Session.Event captureEventData = this.dataCapture.captureEventData(th, thread, str2, j2, 4, 8, z);
        CrashlyticsReport.Session.Event.Builder builder = captureEventData.toBuilder();
        String logString = this.logFileManager.getLogString();
        if (logString != null) {
            builder.setLog(CrashlyticsReport.Session.Event.Log.builder().setContent(logString).build());
        } else {
            Logger.getLogger().v("No log data to include with this event.");
        }
        List<CrashlyticsReport.CustomAttribute> sortedCustomAttributes = getSortedCustomAttributes(this.reportMetadata.getCustomKeys());
        if (!sortedCustomAttributes.isEmpty()) {
            builder.setApp(captureEventData.getApp().toBuilder().setCustomAttributes(ImmutableList.from(sortedCustomAttributes)).build());
        }
        this.reportPersistence.persistEvent(builder.build(), str, equals);
    }

    public void finalizeSessionWithNativeEvent(@NonNull String str, @NonNull List<NativeSessionFile> list) {
        ArrayList arrayList = new ArrayList();
        for (NativeSessionFile nativeSessionFile : list) {
            CrashlyticsReport.FilesPayload.File asFilePayload = nativeSessionFile.asFilePayload();
            if (asFilePayload != null) {
                arrayList.add(asFilePayload);
            }
        }
        this.reportPersistence.finalizeSessionWithNativeEvent(str, CrashlyticsReport.FilesPayload.builder().setFiles(ImmutableList.from(arrayList)).build());
    }

    public void finalizeSessions(long j2, @Nullable String str) {
        this.reportPersistence.finalizeReports(str, j2);
    }

    public boolean hasReportsToSend() {
        return this.reportPersistence.hasFinalizedReports();
    }

    @NonNull
    public List<String> listSortedOpenSessionIds() {
        return this.reportPersistence.listSortedOpenSessionIds();
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void onBeginSession(@NonNull String str, long j2) {
        this.reportPersistence.persistReport(this.dataCapture.captureReportData(str, j2));
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void onCustomKey(String str, String str2) {
        this.reportMetadata.setCustomKey(str, str2);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void onLog(long j2, String str) {
        this.logFileManager.writeToLog(j2, str);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void onUserId(String str) {
        this.reportMetadata.setUserId(str);
    }

    public void persistFatalEvent(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j2) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting fatal event for session " + str);
        persistEvent(th, thread, str, EVENT_TYPE_CRASH, j2, true);
    }

    public void persistNonFatalEvent(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j2) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting non-fatal event for session " + str);
        persistEvent(th, thread, str, "error", j2, false);
    }

    public void persistUserId(@NonNull String str) {
        String userId = this.reportMetadata.getUserId();
        if (userId == null) {
            Logger.getLogger().v("Could not persist user ID; no user ID available");
        } else {
            this.reportPersistence.persistUserIdForSession(userId, str);
        }
    }

    public void removeAllReports() {
        this.reportPersistence.deleteAllReports();
    }

    public g<Void> sendReports(@NonNull Executor executor) {
        List<CrashlyticsReportWithSessionId> loadFinalizedReports = this.reportPersistence.loadFinalizedReports();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId crashlyticsReportWithSessionId : loadFinalizedReports) {
            arrayList.add(this.reportsSender.sendReport(crashlyticsReportWithSessionId).f(executor, SessionReportingCoordinator$$Lambda$1.lambdaFactory$(this)));
        }
        return j.f(arrayList);
    }
}
