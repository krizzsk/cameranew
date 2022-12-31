package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
/* compiled from: AdPreference.java */
/* loaded from: classes.dex */
public class d {
    private static volatile d a;
    private final SharedPreferences b;

    private d(Context context) {
        this.b = context.getSharedPreferences("ttopenadsdk", 0);
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    public String b(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("ttopenadsdk", str, str2);
        }
        return this.b.getString(str, str2);
    }

    public int b(String str, int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, i2);
        }
        return this.b.getInt(str, i2);
    }

    public void a(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, str2);
        } else {
            this.b.edit().putString(str, str2).apply();
        }
    }

    public boolean b(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, z);
        }
        return this.b.getBoolean(str, z);
    }

    public void a(String str, int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Integer.valueOf(i2));
        } else {
            this.b.edit().putInt(str, i2).apply();
        }
    }

    public void a(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Boolean.valueOf(z));
        } else {
            this.b.edit().putBoolean(str, z).apply();
        }
    }
}
