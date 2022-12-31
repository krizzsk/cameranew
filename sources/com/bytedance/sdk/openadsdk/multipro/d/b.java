package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/* compiled from: SPMultiHelperImpl.java */
/* loaded from: classes.dex */
class b {
    private static SoftReference<Map<String, Map<String, Object>>> a;

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static void b(String str) {
        Map<String, Object> map;
        SoftReference<Map<String, Map<String, Object>>> softReference = a;
        if (softReference == null || softReference.get() == null || (map = a.get().get(a(str))) == null) {
            return;
        }
        map.clear();
    }

    private static SharedPreferences c(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(a(str), 0);
    }

    private static Object a(String str, String str2) {
        Map<String, Map<String, Object>> map;
        Map<String, Object> map2;
        SoftReference<Map<String, Map<String, Object>>> softReference = a;
        if (softReference == null || (map = softReference.get()) == null || (map2 = map.get(a(str))) == null) {
            return null;
        }
        return map2.get(str2);
    }

    private static String c(Context context, String str, String str2, String str3) {
        SharedPreferences c = c(context, str);
        return c == null ? str3 : c.getString(str2, str3);
    }

    private static Object b(Context context, String str, String str2, String str3) {
        String a2 = a(str);
        if (a(context, a2, str2)) {
            if (str3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
                return c(context, a2, str2, null);
            }
            if (str3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
                return Boolean.valueOf(a(context, a2, str2, false));
            }
            if (str3.equalsIgnoreCase("int")) {
                return Integer.valueOf(a(context, a2, str2, 0));
            }
            if (str3.equalsIgnoreCase(Constants.LONG)) {
                return Long.valueOf(a(context, a2, str2, 0L));
            }
            if (str3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
                return Float.valueOf(a(context, a2, str2, 0.0f));
            }
            if (str3.equalsIgnoreCase("string_set")) {
                return c(context, a2, str2, null);
            }
            return null;
        }
        return null;
    }

    private static void a(String str, String str2, Object obj) {
        SoftReference<Map<String, Map<String, Object>>> softReference = a;
        if (softReference == null || softReference.get() == null) {
            a = new SoftReference<>(new HashMap());
        }
        String a2 = a(str);
        Map<String, Map<String, Object>> map = a.get();
        if (map.get(a2) == null) {
            map.put(a2, new HashMap());
        }
        map.get(a2).put(str2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized <T> void a(Context context, String str, String str2, T t) {
        synchronized (b.class) {
            SharedPreferences c = c(context, str);
            if (c == null) {
                return;
            }
            if (t.equals(a(str, str2))) {
                return;
            }
            SharedPreferences.Editor edit = c.edit();
            if (t instanceof Boolean) {
                edit.putBoolean(str2, ((Boolean) t).booleanValue());
            }
            if (t instanceof String) {
                edit.putString(str2, (String) t);
            }
            if (t instanceof Integer) {
                edit.putInt(str2, ((Integer) t).intValue());
            }
            if (t instanceof Long) {
                edit.putLong(str2, ((Long) t).longValue());
            }
            if (t instanceof Float) {
                edit.putFloat(str2, ((Float) t).floatValue());
            }
            edit.apply();
            a(str, str2, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str, String str2) {
        SharedPreferences c = c(context, str);
        if (c == null) {
            return;
        }
        SharedPreferences.Editor edit = c.edit();
        edit.remove(str2);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, ?> b(Context context, String str) {
        return c(context, str).getAll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str, String str2, String str3) {
        Object a2 = a(str, str2);
        if (a2 != null) {
            return a2 + "";
        }
        Object b = b(context, str, str2, str3);
        a(str, str2, b);
        return b + "";
    }

    private static int a(Context context, String str, String str2, int i2) {
        SharedPreferences c = c(context, str);
        return c == null ? i2 : c.getInt(str2, i2);
    }

    private static float a(Context context, String str, String str2, float f2) {
        SharedPreferences c = c(context, str);
        return c == null ? f2 : c.getFloat(str2, f2);
    }

    private static boolean a(Context context, String str, String str2, boolean z) {
        SharedPreferences c = c(context, str);
        return c == null ? z : c.getBoolean(str2, z);
    }

    private static long a(Context context, String str, String str2, long j2) {
        SharedPreferences c = c(context, str);
        return c == null ? j2 : c.getLong(str2, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str, String str2) {
        SharedPreferences c = c(context, str);
        return c != null && c.contains(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = c(context, str).edit();
        edit.clear();
        edit.apply();
        b(str);
    }
}
