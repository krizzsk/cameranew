package com.ironsource.mediationsdk.adunit.smash;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.l;
import org.json.JSONObject;
/* compiled from: AdSmashData.java */
/* loaded from: classes2.dex */
public class a {
    private IronSource.AD_UNIT a;
    private String b;
    private l c;

    /* renamed from: d  reason: collision with root package name */
    private int f5532d;

    /* renamed from: e  reason: collision with root package name */
    private int f5533e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f5534f;

    /* renamed from: g  reason: collision with root package name */
    private String f5535g;

    /* renamed from: h  reason: collision with root package name */
    private int f5536h;

    /* renamed from: i  reason: collision with root package name */
    private String f5537i;

    public a(IronSource.AD_UNIT ad_unit, String str, String str2, int i2, JSONObject jSONObject, String str3, int i3, String str4, l lVar, int i4) {
        this.a = ad_unit;
        this.b = str2;
        this.f5533e = i2;
        this.f5534f = jSONObject;
        this.f5535g = str3;
        this.f5536h = i3;
        this.f5537i = str4;
        this.c = lVar;
        this.f5532d = i4;
    }

    public IronSource.AD_UNIT a() {
        return this.a;
    }

    public String b() {
        return this.f5537i;
    }

    public String c() {
        return this.f5535g;
    }

    public int d() {
        return this.f5536h;
    }

    public JSONObject e() {
        return this.f5534f;
    }

    public int f() {
        return this.f5532d;
    }

    public l g() {
        return this.c;
    }

    public int h() {
        return this.f5533e;
    }

    public String i() {
        return this.b;
    }
}
