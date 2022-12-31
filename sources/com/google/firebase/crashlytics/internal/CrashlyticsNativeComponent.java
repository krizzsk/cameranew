package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public interface CrashlyticsNativeComponent {
    boolean finalizeSession(@NonNull String str);

    @NonNull
    NativeSessionFileProvider getSessionFileProvider(@NonNull String str);

    boolean hasCrashDataForSession(@NonNull String str);

    boolean openSession(@NonNull String str);

    void writeBeginSession(@NonNull String str, @NonNull String str2, long j2);

    void writeSessionApp(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i2, @NonNull String str6);

    void writeSessionDevice(@NonNull String str, int i2, @NonNull String str2, int i3, long j2, long j3, boolean z, int i4, @NonNull String str3, @NonNull String str4);

    void writeSessionOs(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z);
}
