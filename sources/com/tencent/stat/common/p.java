package com.tencent.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* loaded from: classes3.dex */
public class p {
    private static SharedPreferences a;

    public static int a(Context context, String str, int i2) {
        return a(context).getInt(k.b(context, "" + str), i2);
    }

    public static long a(Context context, String str, long j2) {
        return a(context).getLong(k.b(context, "" + str), j2);
    }

    static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (p.class) {
            if (a == null) {
                a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(k.b(context, "" + str), str2);
    }

    public static void b(Context context, String str, int i2) {
        String b = k.b(context, "" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putInt(b, i2);
        edit.commit();
    }

    public static void b(Context context, String str, long j2) {
        String b = k.b(context, "" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(b, j2);
        edit.commit();
    }

    public static void b(Context context, String str, String str2) {
        String b = k.b(context, "" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(b, str2);
        edit.commit();
    }
}
