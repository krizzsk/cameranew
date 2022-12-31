package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;
/* compiled from: LogStatsBase.java */
/* loaded from: classes.dex */
public class c<T extends c> implements a {
    private String a;
    private String b;
    private String c;

    /* renamed from: e  reason: collision with root package name */
    private String f1959e;

    /* renamed from: h  reason: collision with root package name */
    private String f1962h;

    /* renamed from: j  reason: collision with root package name */
    private String f1964j;

    /* renamed from: k  reason: collision with root package name */
    private String f1965k;

    /* renamed from: l  reason: collision with root package name */
    private String f1966l;
    private String m;

    /* renamed from: d  reason: collision with root package name */
    private String f1958d = "3.1.5.4";

    /* renamed from: f  reason: collision with root package name */
    private long f1960f = System.currentTimeMillis() / 1000;

    /* renamed from: g  reason: collision with root package name */
    private int f1961g = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f1963i = 0;

    public static c<c> b() {
        return new c<>();
    }

    private JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private T q() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(c())) {
                jSONObject.put("type", c());
            }
            if (!TextUtils.isEmpty(e())) {
                jSONObject.put("rit", e());
            }
            if (!TextUtils.isEmpty(f())) {
                jSONObject.put("creative_id", f());
            }
            if (!TextUtils.isEmpty(g())) {
                jSONObject.put("ad_sdk_version", g());
            }
            if (!TextUtils.isEmpty(h())) {
                jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, h());
            } else {
                jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, ab.h());
            }
            if (i() > 0) {
                jSONObject.put("timestamp", i());
            }
            if (j() > 0) {
                jSONObject.put("adtype", j());
            }
            if (!TextUtils.isEmpty(k())) {
                jSONObject.put("req_id", k());
            }
            jSONObject.put("error_code", l());
            if (!TextUtils.isEmpty(m())) {
                jSONObject.put("error_msg", m());
            }
            if (!TextUtils.isEmpty(n())) {
                jSONObject.put(JsonMarshaller.EXTRA, n());
            }
            if (!TextUtils.isEmpty(o())) {
                jSONObject.put("image_url", o());
            }
            if (!TextUtils.isEmpty(d())) {
                jSONObject.put("event_extra", d());
            }
            jSONObject.put("conn_type", q.b(o.a()));
            jSONObject.put("device_info", p());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.m;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.f1958d;
    }

    public String h() {
        return this.f1959e;
    }

    public long i() {
        return this.f1960f;
    }

    public int j() {
        return this.f1961g;
    }

    public String k() {
        return this.f1962h;
    }

    public int l() {
        return this.f1963i;
    }

    public String m() {
        return this.f1964j;
    }

    public String n() {
        return this.f1965k;
    }

    public String o() {
        return this.f1966l;
    }

    public T b(String str) {
        this.m = str;
        return q();
    }

    public T c(String str) {
        this.b = str;
        return q();
    }

    public T d(String str) {
        this.c = str;
        return q();
    }

    public T e(String str) {
        this.f1962h = str;
        return q();
    }

    public T f(String str) {
        this.f1964j = str;
        return q();
    }

    public T g(String str) {
        this.f1965k = str;
        return q();
    }

    public T b(int i2) {
        this.f1963i = i2;
        return q();
    }

    public T c(long j2) {
        this.f1960f = j2;
        return q();
    }

    public T a(String str) {
        this.a = str;
        return q();
    }

    public T a(int i2) {
        this.f1961g = i2;
        return q();
    }
}
