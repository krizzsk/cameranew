package com.bytedance.sdk.openadsdk.utils;

import android.util.Log;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class o {
    private static boolean a = false;
    private static int b = 4;

    public static void a(int i2) {
        b = i2;
    }

    public static void b() {
        a = true;
        a(3);
    }

    public static boolean c() {
        return a;
    }

    public static void d(String str, String str2) {
        if (c() && str2 != null && b <= 5) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (c() && str2 != null && b <= 6) {
            Log.e(str, str2);
        }
    }

    public static boolean a() {
        return b <= 3;
    }

    public static void c(String str, String str2) {
        if (c() && str2 != null && b <= 4) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (c() && str2 != null && b <= 2) {
            Log.v(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (c() && str2 != null && b <= 3) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (c()) {
            if (!(str2 == null && th == null) && b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void a(String str) {
        if (c()) {
            b("Logger", str);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (c()) {
            if (!(str2 == null && th == null) && b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (c()) {
            if (!(str2 == null && th == null) && b <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void b(String str) {
        if (c()) {
            e("Logger", str);
        }
    }
}
