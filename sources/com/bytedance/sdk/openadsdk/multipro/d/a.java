package com.bytedance.sdk.openadsdk.multipro.d;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashSet;
import java.util.Set;
/* compiled from: SPMultiHelper.java */
/* loaded from: classes.dex */
public class a {
    private static Context a;

    public static boolean a() {
        if (a == null || o.a() == null) {
            com.bytedance.sdk.openadsdk.utils.o.b("The context of SPHelper is null, please initialize sdk in main process");
            return false;
        }
        return true;
    }

    private static ContentResolver b() {
        try {
            if (a()) {
                return c().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Context c() {
        Context context = a;
        return context == null ? o.a() : context;
    }

    private static String d() {
        return e.b + "/t_sp/";
    }

    public static void a(Context context) {
        a = context == null ? o.a() : context.getApplicationContext();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + TypedValues.Custom.S_BOOLEAN + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(FirebaseAnalytics.Param.VALUE, bool);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String b(String str, String str2, String str3) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    String type = b.getType(Uri.parse(d() + TypedValues.Custom.S_STRING + "/" + str2 + b(str)));
                    if (type != null) {
                        if (!type.equals("null")) {
                            return type;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return str3;
        }
        return str3;
    }

    @TargetApi(11)
    public static Set<String> b(String str, String str2, Set<String> set) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    String type = b.getType(Uri.parse(d() + "string_set/" + str2 + b(str)));
                    if (type == null || type.equals("null") || !type.matches("\\[.*\\]")) {
                        return set;
                    }
                    String[] split = type.substring(1, type.length() - 1).split(", ");
                    HashSet hashSet = new HashSet();
                    for (String str3 : split) {
                        hashSet.add(str3.replace("__COMMA__", ", "));
                    }
                    return hashSet;
                }
            } catch (Throwable unused) {
            }
            return set;
        }
        return set;
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + TypedValues.Custom.S_STRING + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(FirebaseAnalytics.Param.VALUE, str3);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "int/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(FirebaseAnalytics.Param.VALUE, num);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Long l2) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + Constants.LONG + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(FirebaseAnalytics.Param.VALUE, l2);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Float f2) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + TypedValues.Custom.S_FLOAT + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(FirebaseAnalytics.Param.VALUE, f2);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Set<String> set) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "string_set/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        HashSet hashSet = new HashSet();
                        for (String str3 : set) {
                            hashSet.add(str3.replace(",", "__COMMA__"));
                        }
                        contentValues.put(FirebaseAnalytics.Param.VALUE, hashSet.toString());
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static int a(String str, String str2, int i2) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    String type = b.getType(Uri.parse(d() + "int/" + str2 + b(str)));
                    if (type != null && !type.equals("null")) {
                        return Integer.parseInt(type);
                    }
                }
            } catch (Throwable unused) {
            }
            return i2;
        }
        return i2;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    String type = b.getType(Uri.parse(d() + TypedValues.Custom.S_BOOLEAN + "/" + str2 + b(str)));
                    if (type != null && !type.equals("null")) {
                        return Boolean.parseBoolean(type);
                    }
                }
            } catch (Throwable unused) {
            }
            return z;
        }
        return z;
    }

    public static long a(String str, String str2, long j2) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    String type = b.getType(Uri.parse(d() + Constants.LONG + "/" + str2 + b(str)));
                    if (type != null && !type.equals("null")) {
                        return Long.parseLong(type);
                    }
                }
            } catch (Throwable unused) {
            }
            return j2;
        }
        return j2;
    }

    public static void a(String str, String str2) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    b.delete(Uri.parse(d() + Constants.LONG + "/" + str2 + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    b.delete(Uri.parse(d() + "clean" + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
