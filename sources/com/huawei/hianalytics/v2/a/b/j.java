package com.huawei.hianalytics.v2.a.b;

import android.content.Context;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    private static final Object a = new Object();
    private static Context b;

    public static void a() {
        if (b == null) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "You must execute Builder.create() before you execute this method.");
            return;
        }
        synchronized (a) {
            if (com.huawei.hianalytics.v2.a.c.a.a(b)) {
                com.huawei.hianalytics.b.b.b("HiAnalytics/V1Server", "cached data by BISDK has already handled.");
                return;
            }
            com.huawei.hianalytics.v2.a.c.a.b(b);
            i.a(new com.huawei.hianalytics.v2.a.c.b(b));
        }
    }

    public static void a(Context context) {
        b = context.getApplicationContext();
    }

    private static void a(Context context, String str, long j2, LinkedHashMap<String, String> linkedHashMap, String str2, String str3, long j3) {
        i.a(new e(context, str2, com.huawei.hianalytics.util.g.a(str, j2, linkedHashMap, str3).toString(), j3));
    }

    public static void a(com.huawei.hianalytics.v2.a.c.b.a aVar) {
        if (aVar == null || !aVar.d()) {
            return;
        }
        a(b, aVar.a(), aVar.c(), null, "$AppOnPause", "OnPause", aVar.b());
    }

    public static void a(com.huawei.hianalytics.v2.a.c.b.b bVar) {
        if (b == null) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/V1Server", "onEvent null context");
            return;
        }
        String a2 = bVar.a();
        String b2 = bVar.b();
        Long c = bVar.c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", b2);
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/V1Server", "onEvent(): JSONException");
        }
        i.a(new e(b, a2, jSONObject.toString(), c.longValue()));
    }

    public static void b(com.huawei.hianalytics.v2.a.c.b.a aVar) {
        if (aVar == null || !aVar.d()) {
            return;
        }
        a(b, aVar.a(), 0L, null, "$AppOnResume", "OnResume", aVar.b());
    }
}
