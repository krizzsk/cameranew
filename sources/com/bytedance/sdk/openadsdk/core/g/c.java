package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.openadsdk.utils.ab;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: DnsItem.java */
/* loaded from: classes.dex */
public class c {
    String a;
    int b;
    JSONArray c;

    /* renamed from: d  reason: collision with root package name */
    List<String> f1644d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    long f1645e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f1646f;

    private c() {
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(jSONObject.optString("host"));
            cVar.a(jSONObject.optInt(Constants.FirelogAnalytics.PARAM_TTL, 60));
            cVar.a(jSONObject.optJSONArray("ips"));
            cVar.a(jSONObject.optBoolean(" statsdnstime", false));
            long optLong = jSONObject.optLong("starttime", 0L);
            if (optLong > 0) {
                cVar.a(optLong);
            } else {
                cVar.a(System.currentTimeMillis());
            }
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public int b() {
        return this.b;
    }

    public JSONArray c() {
        return this.c;
    }

    public long d() {
        return this.f1645e;
    }

    public boolean e() {
        return this.f1646f;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("host", a());
            jSONObject.put(Constants.FirelogAnalytics.PARAM_TTL, b());
            jSONObject.put("ips", c());
            jSONObject.put("starttime", d());
            jSONObject.put("statsdnstime", e());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.c = jSONArray;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                String obj = jSONArray.get(i2).toString();
                if (ab.l(obj)) {
                    this.f1644d.add(obj);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(long j2) {
        this.f1645e = j2;
    }

    public void a(boolean z) {
        this.f1646f = z;
    }
}
