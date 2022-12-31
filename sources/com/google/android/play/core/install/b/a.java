package com.google.android.play.core.install.b;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    private static final Map<Integer, String> a;
    private static final Map<Integer, String> b;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        HashMap hashMap2 = new HashMap();
        b = hashMap2;
        hashMap.put(-2, "An unknown error occurred.");
        hashMap.put(-3, "The API is not available on this device.");
        hashMap.put(-4, "The request that was sent by the app is malformed.");
        hashMap.put(-5, "The install is unavailable to this user or device.");
        hashMap.put(-6, "The download/install is not allowed, due to the current device state (e.g. low battery, low disk space, ...).");
        hashMap.put(-7, "The install/update has not been (fully) downloaded yet.");
        hashMap.put(-8, "The install is already in progress and there is no UI flow to resume.");
        hashMap.put(-9, "The Play Store app is either not installed or not the official version.");
        hashMap.put(-10, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        hashMap.put(-100, "An internal error happened in the Play Store.");
        hashMap2.put(-2, "ERROR_UNKNOWN");
        hashMap2.put(-3, "ERROR_API_NOT_AVAILABLE");
        hashMap2.put(-4, "ERROR_INVALID_REQUEST");
        hashMap2.put(-5, "ERROR_INSTALL_UNAVAILABLE");
        hashMap2.put(-6, "ERROR_INSTALL_NOT_ALLOWED");
        hashMap2.put(-7, "ERROR_DOWNLOAD_NOT_PRESENT");
        hashMap2.put(-8, "ERROR_INSTALL_IN_PROGRESS");
        hashMap2.put(-100, "ERROR_INTERNAL_ERROR");
        hashMap2.put(-9, "ERROR_PLAY_STORE_NOT_FOUND");
        hashMap2.put(-10, "ERROR_APP_NOT_OWNED");
    }

    public static String a(int i2) {
        Map<Integer, String> map = a;
        Integer valueOf = Integer.valueOf(i2);
        if (map.containsKey(valueOf)) {
            Map<Integer, String> map2 = b;
            if (map2.containsKey(valueOf)) {
                String str = map.get(valueOf);
                String str2 = map2.get(valueOf);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 103 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" (https://developer.android.com/reference/com/google/android/play/core/install/model/InstallErrorCode#");
                sb.append(str2);
                sb.append(")");
                return sb.toString();
            }
            return "";
        }
        return "";
    }
}
