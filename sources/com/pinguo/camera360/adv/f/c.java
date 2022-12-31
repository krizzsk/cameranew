package com.pinguo.camera360.adv.f;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: SPUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* compiled from: SPUtils.java */
    /* loaded from: classes3.dex */
    private static class a {
        private static final Method a = b();

        public static void a(SharedPreferences.Editor editor) {
            try {
                Method method = a;
                if (method != null) {
                    method.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
            editor.commit();
        }

        private static Method b() {
            try {
                return SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    public static Object a(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("adv_share_data", 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static void b(Context context, String str, Object obj) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("adv_share_data", 0).edit();
            if (obj != null) {
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else {
                    edit.putString(str, obj.toString());
                }
                a.a(edit);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
