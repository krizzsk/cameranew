package com.hw.photomovie.util;

import android.util.Log;
/* compiled from: MLog.java */
/* loaded from: classes2.dex */
public class b {
    public static void a(String str, String str2) {
        Log.e(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    public static void c(String str, String str2) {
        Log.i(str, str2);
    }

    public static void d(String str, String str2) {
        Log.w(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }
}
