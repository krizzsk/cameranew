package com.ironsource.mediationsdk.model;

import org.json.JSONObject;
/* compiled from: AdapterConfig.java */
/* loaded from: classes2.dex */
public class a {
    private l a;
    private JSONObject b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private int f5580d;

    /* renamed from: e  reason: collision with root package name */
    private int f5581e;

    public a(l lVar, JSONObject jSONObject) {
        this.a = lVar;
        this.b = jSONObject;
        int optInt = jSONObject.optInt("instanceType");
        this.f5580d = optInt;
        this.c = optInt == 2;
        this.f5581e = jSONObject.optInt("maxAdsPerSession", 99);
    }

    public String a() {
        return this.a.a();
    }

    public JSONObject b() {
        return this.b;
    }

    public int c() {
        return this.f5580d;
    }

    public int d() {
        return this.f5581e;
    }

    public String e() {
        return this.a.l();
    }

    public String f() {
        return this.a.m();
    }

    public l g() {
        return this.a;
    }

    public String h() {
        return this.a.p();
    }

    public boolean i() {
        return this.c;
    }
}
