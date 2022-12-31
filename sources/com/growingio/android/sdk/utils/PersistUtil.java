package com.growingio.android.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class PersistUtil {
    private static final String DEVICE_ID_KEY = "device_id";
    private static final String HOST_INFORMATION_KEY = "host_info";
    private static final String LAST_VERSION = "host_app_last_version";
    private static final String PERSIST_FILE_NAME = "growing_persist_data";
    private static SharedPreferences sharedPreferences;

    public static String fetchDeviceId() {
        return sharedPreferences.getString(DEVICE_ID_KEY, null);
    }

    public static String fetchHostInformationData() {
        return sharedPreferences.getString(HOST_INFORMATION_KEY, null);
    }

    public static int fetchLastAppVersion() {
        return sharedPreferences.getInt(LAST_VERSION, 0);
    }

    public static void init(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PERSIST_FILE_NAME, 0);
        }
    }

    public static void saveDeviceId(String str) {
        sharedPreferences.edit().putString(DEVICE_ID_KEY, str).commit();
    }

    public static void saveHostInformationData(String str) {
        sharedPreferences.edit().putString(HOST_INFORMATION_KEY, str).commit();
    }

    public static void saveLastAppVersion(int i2) {
        sharedPreferences.edit().putInt(LAST_VERSION, i2).commit();
    }
}
