package com.tapjoy.internal;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class n {
    public static void a(SharedPreferences sharedPreferences, String str, boolean z) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void a(SharedPreferences sharedPreferences, String str, int i2) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str, i2);
        edit.apply();
    }

    public static void a(SharedPreferences sharedPreferences, String str, String str2) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
