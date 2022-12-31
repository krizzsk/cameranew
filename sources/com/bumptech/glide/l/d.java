package com.bumptech.glide.l;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
/* compiled from: LogTime.java */
/* loaded from: classes.dex */
public final class d {
    private static final double a;

    static {
        a = 17 <= Build.VERSION.SDK_INT ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    public static double a(long j2) {
        return (b() - j2) * a;
    }

    @TargetApi(17)
    public static long b() {
        if (17 <= Build.VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return System.currentTimeMillis();
    }
}
