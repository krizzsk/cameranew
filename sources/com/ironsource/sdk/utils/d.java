package com.ironsource.sdk.utils;

import android.util.Log;
import com.ironsource.sdk.data.ISNEnums$DebugMode;
/* compiled from: Logger.java */
/* loaded from: classes2.dex */
public class d {
    private static boolean a;

    public static void a(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void c(int i2) {
        a = ISNEnums$DebugMode.MODE_0.getValue() != i2;
    }

    public static void d(String str, String str2) {
        if (a) {
            Log.i(str, str2);
        }
    }
}
