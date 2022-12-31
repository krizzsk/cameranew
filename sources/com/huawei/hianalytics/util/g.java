package com.huawei.hianalytics.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 4096) {
            com.huawei.hianalytics.b.b.c("HiAnalytics", "oaid Parameter error!");
            return "";
        }
        return str;
    }

    private static JSONObject a(long j2, String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        JSONObject jSONObject = linkedHashMap == null ? new JSONObject() : e.a(linkedHashMap);
        try {
            if ("OnPause".equals(str2)) {
                jSONObject.put("_event_duration", j2);
            }
            jSONObject.put("_activity_name", str);
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("EventUtils", "getEventContent(): JSONException");
        }
        return jSONObject;
    }

    public static JSONObject a(String str, long j2, LinkedHashMap<String, String> linkedHashMap, String str2) {
        return a(j2, str, str2, linkedHashMap);
    }

    public static void a(com.huawei.hianalytics.a.c cVar, com.huawei.hianalytics.a.b bVar, Context context) {
        cVar.a(bVar.a());
        cVar.d(bVar.b());
        cVar.b(bVar.d());
        cVar.c(bVar.c());
        String f2 = bVar.f();
        if (TextUtils.isEmpty(f2) || f2.length() > 256) {
            com.huawei.hianalytics.b.b.c("HiAnalytics", "channel Parameter error!");
            f2 = "";
        }
        cVar.p(f2);
        String g2 = bVar.g();
        if (TextUtils.isEmpty(g2) || g2.length() > 256 || !a(g2, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}")) {
            com.huawei.hianalytics.b.b.c("HiAnalytics", "appid Parameter error!");
            cVar.k(o.a(context));
        } else {
            cVar.k(g2);
        }
        c.a(cVar, bVar);
    }

    public static boolean a(int i2, com.huawei.hianalytics.a.c cVar) {
        if (cVar == null || cVar.y() == null || !b(i2, cVar)) {
            com.huawei.hianalytics.b.b.c("HiAnalytics", "collectUrl is null or url is empty");
            return false;
        }
        return true;
    }

    public static boolean a(Context context, int i2, String str, LinkedHashMap<String, String> linkedHashMap, com.huawei.hianalytics.a.c cVar) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || !a(i2, cVar)) {
            str2 = "onEvent context evnetid or value is null or empty";
        } else if (str.length() <= 256 && a(linkedHashMap)) {
            return true;
        } else {
            str2 = "eventid or value Parameter error !";
        }
        com.huawei.hianalytics.b.b.c("HiAnalytics", str2);
        return false;
    }

    public static boolean a(Context context, String str, String str2, com.huawei.hianalytics.a.c cVar) {
        String str3;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str3 = "onEvent context evnetid or value is null or empty";
        } else if (str.length() > 256 || str2.length() > 65536) {
            str3 = "eventid or value Parameter error !";
        } else if (cVar.y() != null && !TextUtils.isEmpty(cVar.y().get("oper"))) {
            return true;
        } else {
            str3 = "collectUrl is null or url is empty";
        }
        com.huawei.hianalytics.b.b.c("HiAnalytics", str3);
        return false;
    }

    public static boolean a(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }

    public static boolean a(LinkedHashMap<String, String> linkedHashMap) {
        String str;
        if (linkedHashMap == null || linkedHashMap.size() < 1) {
            return false;
        }
        if (linkedHashMap.size() == 1) {
            if (linkedHashMap.get("constants") != null || linkedHashMap.get("_constants") != null) {
                str = "the value of map is error";
                com.huawei.hianalytics.b.b.c("HiAnalytics", str);
                return false;
            }
            return true;
        }
        if (linkedHashMap.size() > 2048 || linkedHashMap.toString().length() > 204800) {
            str = "onevent map value too big!";
            com.huawei.hianalytics.b.b.c("HiAnalytics", str);
            return false;
        }
        return true;
    }

    private static boolean b(int i2, com.huawei.hianalytics.a.c cVar) {
        String str;
        if (i2 == 0) {
            str = "oper";
        } else if (i2 != 1) {
            return i2 == 2;
        } else {
            str = "maint";
        }
        return !TextUtils.isEmpty(cVar.y().get(str));
    }
}
