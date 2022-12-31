package us.pinguo.edit.sdk.core.utils;

import android.util.Log;
/* loaded from: classes4.dex */
public class SdkLog {
    private static boolean a = false;

    /* loaded from: classes4.dex */
    private enum LOG_TAG {
        FOOTPRINT,
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public static void a(String str, String str2) {
        if (a) {
            Log.e(str, b(LOG_TAG.ERROR.name(), str2));
        }
    }

    private static String b(String str, String str2) {
        return "[" + str + "]" + str2;
    }

    public static void c(String str, String str2) {
        if (a) {
            Log.i(str, b(LOG_TAG.INFO.name(), str2));
        }
    }
}
