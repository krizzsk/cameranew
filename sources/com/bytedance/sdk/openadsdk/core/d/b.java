package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.openadsdk.utils.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;
/* compiled from: AppInfo.java */
/* loaded from: classes.dex */
public class b {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private int f1550d;

    /* renamed from: e  reason: collision with root package name */
    private int f1551e;

    /* renamed from: f  reason: collision with root package name */
    private int f1552f;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.f1550d;
    }

    public int e() {
        return this.f1551e;
    }

    public int f() {
        return this.f1552f;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", b());
            jSONObject.put("app_size", f());
            jSONObject.put("comment_num", e());
            jSONObject.put("download_url", a());
            jSONObject.put("package_name", c());
            jSONObject.put(FirebaseAnalytics.Param.SCORE, d());
        } catch (Exception e2) {
            o.b(e2.toString());
        }
        return jSONObject;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void a(int i2) {
        this.f1550d = i2;
    }

    public void b(int i2) {
        this.f1551e = i2;
    }

    public void c(int i2) {
        this.f1552f = i2;
    }
}
