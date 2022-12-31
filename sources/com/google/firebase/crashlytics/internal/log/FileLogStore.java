package com.google.firebase.crashlytics.internal.log;

import androidx.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface FileLogStore {
    void closeLogFile();

    void deleteLogFile();

    @Nullable
    byte[] getLogAsBytes();

    @Nullable
    String getLogAsString();

    void writeToLog(long j2, String str);
}
