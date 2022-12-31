package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: SPUtils.java */
/* loaded from: classes.dex */
public class v {
    private static Map<String, v> a = new HashMap();
    private SharedPreferences b;

    private v(String str, Context context) {
        if (context != null) {
            this.b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public static v a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        v vVar = a.get(str);
        if (vVar == null) {
            v vVar2 = new v(str, context);
            a.put(str, vVar2);
            return vVar2;
        }
        return vVar;
    }

    public String b(@NonNull String str, @NonNull String str2) {
        try {
            return this.b.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public int b(@NonNull String str, int i2) {
        try {
            return this.b.getInt(str, i2);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public long b(@NonNull String str, long j2) {
        try {
            return this.b.getLong(str, j2);
        } catch (Throwable unused) {
            return j2;
        }
    }

    public Set<String> b(@NonNull String str, @NonNull Set<String> set) {
        try {
            return this.b.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    public void a(@NonNull String str, @NonNull String str2) {
        try {
            this.b.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str) {
        try {
            this.b.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    public String a(@NonNull String str) {
        try {
            return b(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(@NonNull String str, int i2) {
        try {
            this.b.edit().putInt(str, i2).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(@NonNull String str, long j2) {
        try {
            this.b.edit().putLong(str, j2).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(@NonNull String str, @NonNull Set<String> set) {
        try {
            this.b.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }
}
