package com.pinguo.album.animations;

import android.os.SystemClock;
/* compiled from: AnimationTime.java */
/* loaded from: classes3.dex */
public class c {
    private static volatile long a;

    public static long a() {
        return a;
    }

    public static long b() {
        a = SystemClock.uptimeMillis();
        return a;
    }

    public static void c() {
        a = SystemClock.uptimeMillis();
    }
}
