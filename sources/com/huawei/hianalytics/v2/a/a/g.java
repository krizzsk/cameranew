package com.huawei.hianalytics.v2.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5132d;

    /* renamed from: e  reason: collision with root package name */
    private String f5133e;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.f5133e = str;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("protocol_version", "1");
            jSONObject.put("compress_mode", "1");
            jSONObject.put("serviceid", this.f5132d);
            jSONObject.put("appid", this.a);
            jSONObject.put("hmac", this.b);
            jSONObject.put("chifer", this.f5133e);
            jSONObject.put("timestamp", this.c);
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("HeadData", "toJsonObj(): JSONException");
        }
        return jSONObject;
    }

    public void b(String str) {
        this.f5132d = str;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(String str) {
        this.b = str;
    }

    public void e(String str) {
        this.c = str;
    }
}
