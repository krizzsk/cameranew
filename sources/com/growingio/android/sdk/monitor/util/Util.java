package com.growingio.android.sdk.monitor.util;
/* loaded from: classes2.dex */
public final class Util {
    private Util() {
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String trimString(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (str.length() > i2) {
            return str.substring(0, i2 - 3) + "...";
        }
        return str;
    }
}
