package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* compiled from: SourceApplicationInfo.java */
/* loaded from: classes.dex */
class k {
    private String a;
    private boolean b;

    private k(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public static void a() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.facebook.f.f()).edit();
        edit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
        edit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
        edit.apply();
    }

    public static k b() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.facebook.f.f());
        if (defaultSharedPreferences.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
            return new k(defaultSharedPreferences.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
        }
        return null;
    }

    public void c() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.facebook.f.f()).edit();
        edit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.a);
        edit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.b);
        edit.apply();
    }

    public String toString() {
        String str = this.b ? "Applink" : "Unclassified";
        if (this.a != null) {
            return str + "(" + this.a + ")";
        }
        return str;
    }
}
