package com.huawei.hianalytics.v2.a.b;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* loaded from: classes2.dex */
public class i {
    private static long a;
    private static Context b;
    private static com.huawei.hianalytics.a.c c;

    public static void a() {
        a(b);
    }

    public static void a(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (com.huawei.hianalytics.util.g.a(b, i2, str, linkedHashMap, c)) {
            JSONObject a2 = com.huawei.hianalytics.util.e.a(linkedHashMap);
            long currentTimeMillis = System.currentTimeMillis();
            if (2 == i2) {
                currentTimeMillis = com.huawei.hianalytics.util.f.a(AdvTimeUtils.DATE_FORMAT_HYPHEN, currentTimeMillis);
            }
            a(new e(b, i2, str, a2.toString(), currentTimeMillis));
        }
    }

    public static void a(Context context) {
        if (context == null || b == null) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onPause null context or SDK was not init.");
        } else {
            a(f.a(context));
        }
    }

    public static void a(Context context, com.huawei.hianalytics.a.c cVar) {
        b = context.getApplicationContext();
        c = cVar;
        j.a(context);
    }

    private static void a(Context context, String str, long j2, LinkedHashMap<String, String> linkedHashMap, String str2, String str3) {
        a(new e(context, str2, com.huawei.hianalytics.util.g.a(str, j2, linkedHashMap, str3).toString(), System.currentTimeMillis()));
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onEvent null context");
        } else if (com.huawei.hianalytics.util.g.a(b, str, str2, c)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_constants", str2);
            } catch (JSONException unused) {
                com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onEvent(): JSONException");
            }
            a(new e(context, str, jSONObject.toString(), System.currentTimeMillis()));
        }
    }

    private static void a(Context context, String str, LinkedHashMap<String, String> linkedHashMap) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = a;
        a(context, str, j2 == 0 ? 0L : currentTimeMillis - j2, linkedHashMap, "$AppOnPause", "OnPause");
    }

    public static void a(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (context == null || b == null || !com.huawei.hianalytics.util.g.a(0, c)) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onPause null context or SDK was not init.");
            return;
        }
        if (com.huawei.hianalytics.util.g.a(linkedHashMap)) {
            a(b, context.getClass().getCanonicalName(), linkedHashMap);
        }
        a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(l lVar) {
        if (lVar == null) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "runTaskHandler - task is null");
            return;
        }
        q a2 = q.a();
        if (a2 != null) {
            a2.a(lVar);
        } else {
            com.huawei.hianalytics.b.b.b("HiAnalytics/Server", "SessionHandler is NULL, failed to call task: %s", lVar.getClass().getSimpleName());
        }
    }

    public static void a(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (b == null || TextUtils.isEmpty(str) || !com.huawei.hianalytics.util.g.a(0, c)) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onPause() :viewName is empty or SDK was not init.");
            return;
        }
        if (com.huawei.hianalytics.util.g.a(str, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}") && com.huawei.hianalytics.util.g.a(linkedHashMap)) {
            a(b, str, linkedHashMap);
        }
        a = 0L;
    }

    public static void b(Context context) {
        if (context == null || b == null || !com.huawei.hianalytics.util.g.a(0, c)) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onPause null context or SDK was not init.");
            return;
        }
        a(b, context.getClass().getCanonicalName(), (LinkedHashMap<String, String>) null);
        a = 0L;
    }

    public static void b(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (context == null || b == null || !com.huawei.hianalytics.util.g.a(0, c)) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onPause null context or SDK was not init.");
            return;
        }
        a = System.currentTimeMillis();
        if (com.huawei.hianalytics.util.g.a(linkedHashMap)) {
            a(b, context.getClass().getCanonicalName(), 0L, linkedHashMap, "$AppOnResume", "OnResume");
        }
    }

    public static void b(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (b == null || TextUtils.isEmpty(str) || !com.huawei.hianalytics.util.g.a(0, c)) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onResume() viewName is empty or SDK was not init.");
        } else if (com.huawei.hianalytics.util.g.a(str, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}") && com.huawei.hianalytics.util.g.a(linkedHashMap)) {
            a = System.currentTimeMillis();
            a(b, str, 0L, linkedHashMap, "$AppOnResume", "OnResume");
        }
    }

    public static void c(Context context) {
        if (context == null || b == null || !com.huawei.hianalytics.util.g.a(0, c)) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/Server", "onPause null context or SDK was not init.");
            return;
        }
        a = System.currentTimeMillis();
        a(b, context.getClass().getCanonicalName(), 0L, null, "$AppOnResume", "OnResume");
    }
}
