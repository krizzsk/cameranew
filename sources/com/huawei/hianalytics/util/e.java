package com.huawei.hianalytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class e {
    public static SharedPreferences a(Context context) {
        return k.a(context, "stat_v2");
    }

    public static String a(com.huawei.hianalytics.a.c cVar) {
        if (cVar.c() || cVar.e()) {
            String m = cVar.m();
            if (TextUtils.isEmpty(m)) {
                m = o.a();
                cVar.j(m);
            }
            return m;
        }
        return "";
    }

    public static String a(com.huawei.hianalytics.a.c cVar, Context context) {
        if (cVar.e()) {
            String t = cVar.t();
            if (TextUtils.isEmpty(t)) {
                String d2 = o.d(context);
                cVar.g(d2);
                return d2;
            }
            return t;
        }
        return "";
    }

    public static JSONObject a(LinkedHashMap<String, String> linkedHashMap) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            try {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                com.huawei.hianalytics.b.b.c("DataUtil", "onEvent(): JSONException: mapValue");
            }
        }
        return jSONObject;
    }

    public static void a(long j2, String str, String str2, com.huawei.hianalytics.a.c cVar) {
        cVar.a(j2);
        cVar.o(str);
        cVar.n(str2);
    }

    public static boolean a(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j2 - Long.parseLong(str) > 604800000;
        } catch (NumberFormatException unused) {
            com.huawei.hianalytics.b.b.c("DataUtil", "isTimeExpired(): NumberFormatException");
            return true;
        }
    }

    public static String b(com.huawei.hianalytics.a.c cVar, Context context) {
        String u = cVar.u();
        if (TextUtils.isEmpty(u) && cVar.b()) {
            String u2 = cVar.u();
            if (TextUtils.isEmpty(u2)) {
                String c = o.c(context);
                cVar.h(c);
                return c;
            }
            return u2;
        }
        return u;
    }

    public static JSONObject b(Context context) {
        return l.a(context, "cached_v2");
    }

    public static String c(Context context) {
        Bundle bundle;
        Object obj;
        String str;
        String str2 = "Unknown";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            obj.toString();
            try {
                String obj2 = obj.toString();
                return obj2.length() > 256 ? "Unknown" : obj2;
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = str;
                com.huawei.hianalytics.b.b.c("DataUtil", "getChannel(): PackageManager_NameNotFoundException");
                return str2;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }
}
