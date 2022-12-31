package us.pinguo.foundation.base;

import android.content.Context;
/* compiled from: PGPreferences.java */
/* loaded from: classes4.dex */
public class e {
    public static boolean a(Context context, String str, boolean z) {
        return context.getSharedPreferences("pg_preference", 0).getBoolean(str, z);
    }

    public static int b(Context context, String str) {
        return context.getSharedPreferences("pg_preference", 0).getInt(str, 0);
    }

    public static int c(Context context, String str, int i2) {
        return context.getSharedPreferences("pg_preference", 0).getInt(str, i2);
    }

    public static String d(Context context, String str) {
        return context.getSharedPreferences("pg_preference", 0).getString(str, "");
    }

    public static void e(Context context, String str, boolean z) {
        context.getSharedPreferences("pg_preference", 0).edit().putBoolean(str, z).apply();
    }

    public static void f(Context context, String str, int i2) {
        context.getSharedPreferences("pg_preference", 0).edit().putInt(str, i2).apply();
    }

    public static void g(Context context, String str, String str2) {
        context.getSharedPreferences("pg_preference", 0).edit().putString(str, str2).apply();
    }
}
