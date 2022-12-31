package com.huawei.hianalytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class k {
    public static SharedPreferences a(Context context, String str) {
        String packageName = context.getPackageName();
        return context.getSharedPreferences("hianalytics_" + str + "_" + packageName, 0);
    }

    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return sharedPreferences.getString(str, str2);
        } catch (ClassCastException unused) {
            com.huawei.hianalytics.b.b.c("SharedPreferenceUtil", "getString(): ClassCastException: ClassCastException in sp getString");
            return str2;
        }
    }

    public static void a(SharedPreferences sharedPreferences, String str, long j2) {
        sharedPreferences.edit().putLong(str, j2).commit();
    }

    public static boolean a(Context context, String str, int i2) {
        File filesDir = context.getFilesDir();
        long length = new File(filesDir, "../shared_prefs/" + ("hianalytics_" + str + "_" + context.getPackageName() + ".xml")).length();
        if (length > i2) {
            com.huawei.hianalytics.b.b.a("HiAnalytics", "reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i2));
            return true;
        }
        return false;
    }

    public static boolean a(SharedPreferences sharedPreferences, String str, boolean z) {
        try {
            return sharedPreferences.getBoolean(str, z);
        } catch (ClassCastException unused) {
            com.huawei.hianalytics.b.b.c("SharedPreferenceUtil", "getBoolean(): ClassCastException: ClassCastException in sp getBoolean");
            return z;
        }
    }

    public static long b(SharedPreferences sharedPreferences, String str, long j2) {
        try {
            return sharedPreferences.getLong(str, j2);
        } catch (ClassCastException unused) {
            com.huawei.hianalytics.b.b.c("SharedPreferenceUtil", "getString(): ClassCastException: ClassCastException in sp getString");
            return j2;
        }
    }

    public static void b(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }
}
