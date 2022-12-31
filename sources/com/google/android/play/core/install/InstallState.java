package com.google.android.play.core.install;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public abstract class InstallState {
    public static InstallState a(int i2, long j2, long j3, int i3, @NonNull String str) {
        return new a(i2, j2, j3, i3, str);
    }

    public abstract long b();

    public abstract int c();

    public abstract int d();

    public abstract String e();

    public abstract long f();
}
