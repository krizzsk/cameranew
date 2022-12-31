package com.tencent.stat.common;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    static c a;

    /* renamed from: d  reason: collision with root package name */
    private static StatLogger f8274d = k.b();

    /* renamed from: e  reason: collision with root package name */
    private static JSONObject f8275e = null;
    Integer b;
    String c;

    public a(Context context) {
        this.b = null;
        this.c = null;
        try {
            a(context);
            this.b = k.q(context.getApplicationContext());
            this.c = k.p(context);
        } catch (Throwable th) {
            f8274d.e(th);
        }
    }

    static synchronized c a(Context context) {
        c cVar;
        synchronized (a.class) {
            if (a == null) {
                a = new c(context.getApplicationContext());
            }
            cVar = a;
        }
        return cVar;
    }

    public static void a(Context context, Map<String, String> map) {
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        if (f8275e == null) {
            f8275e = new JSONObject();
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            f8275e.put((String) entry.getKey(), entry.getValue());
        }
    }

    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            c cVar = a;
            if (cVar != null) {
                cVar.a(jSONObject2);
            }
            k.a(jSONObject2, "cn", this.c);
            Integer num = this.b;
            if (num != null) {
                jSONObject2.put("tn", num);
            }
            jSONObject.put("ev", jSONObject2);
            JSONObject jSONObject3 = f8275e;
            if (jSONObject3 == null || jSONObject3.length() <= 0) {
                return;
            }
            jSONObject.put("eva", f8275e);
        } catch (Throwable th) {
            f8274d.e(th);
        }
    }
}
