package com.tapjoy.internal;

import android.os.SystemClock;
import androidx.core.location.LocationRequestCompat;
/* loaded from: classes3.dex */
public final class v {
    private static String a = "pool.ntp.org";
    private static long b = 20000;
    private static volatile boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private static volatile String f7773d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile long f7774e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile long f7775f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile long f7776g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile long f7777h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile long f7778i;

    static {
        a(false, "System", System.currentTimeMillis(), SystemClock.elapsedRealtime(), LocationRequestCompat.PASSIVE_INTERVAL);
    }

    private static synchronized void a(boolean z, String str, long j2, long j3, long j4) {
        synchronized (v.class) {
            c = z;
            f7773d = str;
            f7774e = j2;
            f7775f = j3;
            f7776g = j4;
            f7777h = f7774e - f7775f;
            f7778i = (SystemClock.elapsedRealtime() + f7777h) - System.currentTimeMillis();
        }
    }

    public static long b() {
        return SystemClock.elapsedRealtime() + f7777h;
    }

    public static boolean c() {
        return c;
    }

    public static boolean a() {
        String str = a;
        long j2 = b;
        gk gkVar = new gk();
        if (gkVar.a(str, (int) j2)) {
            a(true, "SNTP", gkVar.a, gkVar.b, gkVar.c / 2);
            return true;
        }
        return false;
    }

    public static long a(long j2) {
        return j2 + f7777h;
    }
}
