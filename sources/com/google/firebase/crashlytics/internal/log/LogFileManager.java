package com.google.firebase.crashlytics.internal.log;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class LogFileManager {
    private static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
    private static final String LOGFILE_EXT = ".temp";
    private static final String LOGFILE_PREFIX = "crashlytics-userlog-";
    static final int MAX_LOG_SIZE = 65536;
    private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore();
    private final Context context;
    private FileLogStore currentLog;
    private final DirectoryProvider directoryProvider;

    /* loaded from: classes2.dex */
    public interface DirectoryProvider {
        File getLogFileDir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public void closeLogFile() {
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public void deleteLogFile() {
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public byte[] getLogAsBytes() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public String getLogAsString() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public void writeToLog(long j2, String str) {
        }
    }

    public LogFileManager(Context context, DirectoryProvider directoryProvider) {
        this(context, directoryProvider, null);
    }

    private String getSessionIdForFile(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(LOGFILE_EXT);
        return lastIndexOf == -1 ? name : name.substring(20, lastIndexOf);
    }

    private File getWorkingFileForSession(String str) {
        return new File(this.directoryProvider.getLogFileDir(), LOGFILE_PREFIX + str + LOGFILE_EXT);
    }

    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    public void discardOldLogFiles(Set<String> set) {
        File[] listFiles = this.directoryProvider.getLogFileDir().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(getSessionIdForFile(file))) {
                    file.delete();
                }
            }
        }
    }

    public byte[] getBytesForLog() {
        return this.currentLog.getLogAsBytes();
    }

    @Nullable
    public String getLogString() {
        return this.currentLog.getLogAsString();
    }

    public final void setCurrentSession(String str) {
        this.currentLog.closeLogFile();
        this.currentLog = NOOP_LOG_STORE;
        if (str == null) {
            return;
        }
        if (!CommonUtils.getBooleanResourceValue(this.context, COLLECT_CUSTOM_LOGS, true)) {
            Logger.getLogger().d("Preferences requested no custom logs. Aborting log file creation.");
        } else {
            setLogFile(getWorkingFileForSession(str), 65536);
        }
    }

    void setLogFile(File file, int i2) {
        this.currentLog = new QueueFileLogStore(file, i2);
    }

    public void writeToLog(long j2, String str) {
        this.currentLog.writeToLog(j2, str);
    }

    public LogFileManager(Context context, DirectoryProvider directoryProvider, String str) {
        this.context = context;
        this.directoryProvider = directoryProvider;
        this.currentLog = NOOP_LOG_STORE;
        setCurrentSession(str);
    }
}
