package com.ironsource.environment;

import android.content.Context;
import android.content.SharedPreferences;
/* compiled from: IronSourceSharedPreferencesUtilities.java */
/* loaded from: classes2.dex */
public class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str, String str2, boolean z) {
        return context == null ? z : context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    public static String b(Context context, String str, String str2, String str3) {
        return context == null ? str3 : context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void c(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }
}
