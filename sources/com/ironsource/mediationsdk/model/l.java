package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.IronSource;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: NetworkSettings.java */
/* loaded from: classes2.dex */
public class l {
    private String a;
    private String b;
    private JSONObject c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f5610d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f5611e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f5612f;

    /* renamed from: g  reason: collision with root package name */
    private String f5613g;

    /* renamed from: h  reason: collision with root package name */
    private String f5614h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5615i;

    /* renamed from: j  reason: collision with root package name */
    private String f5616j;

    /* renamed from: k  reason: collision with root package name */
    private int f5617k;

    /* renamed from: l  reason: collision with root package name */
    private int f5618l;
    private int m;
    private String n;

    public l(String str) {
        this.a = str;
        this.f5616j = str;
        this.b = str;
        this.n = str;
        this.f5610d = new JSONObject();
        this.f5611e = new JSONObject();
        this.f5612f = new JSONObject();
        this.c = new JSONObject();
        this.f5617k = -1;
        this.f5618l = -1;
        this.m = -1;
    }

    public void A(String str, Object obj) {
        try {
            this.f5611e.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void B(JSONObject jSONObject) {
        this.f5611e = jSONObject;
    }

    public void C(boolean z) {
        this.f5615i = z;
    }

    public void D(int i2) {
        this.f5617k = i2;
    }

    public void E(String str, Object obj) {
        try {
            this.f5610d.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void F(JSONObject jSONObject) {
        this.f5610d = jSONObject;
    }

    public void G(String str) {
        this.f5613g = str;
    }

    public String a() {
        return this.f5614h;
    }

    public JSONObject b() {
        return this.c;
    }

    public int c() {
        return this.m;
    }

    public JSONObject d() {
        return this.f5612f;
    }

    public String e() {
        JSONObject jSONObject = this.c;
        return jSONObject != null ? jSONObject.optString("customNetworkPackage", "") : "";
    }

    public int f(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return h().optInt("instanceType");
        }
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return o().optInt("instanceType");
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return d().optInt("instanceType");
        }
        return 1;
    }

    public int g() {
        return this.f5618l;
    }

    public JSONObject h() {
        return this.f5611e;
    }

    public int i(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return h().optInt("maxAdsPerSession", 99);
        }
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return o().optInt("maxAdsPerSession", 99);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return d().optInt("maxAdsPerSession", 99);
        }
        return 99;
    }

    public String j() {
        return this.n;
    }

    public String k() {
        return this.f5616j;
    }

    public String l() {
        return this.a;
    }

    public String m() {
        return this.b;
    }

    public int n() {
        return this.f5617k;
    }

    public JSONObject o() {
        return this.f5610d;
    }

    public String p() {
        return this.f5613g;
    }

    public boolean q(IronSource.AD_UNIT ad_unit) {
        return !r() && f(ad_unit) == 2;
    }

    public boolean r() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optBoolean("isCustomNetwork", false);
        }
        return false;
    }

    public boolean s() {
        return m().equalsIgnoreCase("SupersonicAds") || m().equalsIgnoreCase("IronSource");
    }

    public boolean t() {
        return this.f5615i;
    }

    public void u(String str) {
        this.f5614h = str;
    }

    public void v(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void w(int i2) {
        this.m = i2;
    }

    public void x(String str, Object obj) {
        try {
            this.f5612f.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void y(JSONObject jSONObject) {
        this.f5612f = jSONObject;
    }

    public void z(int i2) {
        this.f5618l = i2;
    }

    public l(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.a = str;
        this.f5616j = str;
        this.b = str2;
        this.n = str3;
        this.f5610d = jSONObject2;
        this.f5611e = jSONObject3;
        this.f5612f = jSONObject4;
        this.c = jSONObject;
        this.f5617k = -1;
        this.f5618l = -1;
        this.m = -1;
    }

    public l(l lVar) {
        this.a = lVar.l();
        this.f5616j = lVar.l();
        this.b = lVar.m();
        this.f5610d = lVar.o();
        this.f5611e = lVar.h();
        this.f5612f = lVar.d();
        this.c = lVar.b();
        this.f5617k = lVar.n();
        this.f5618l = lVar.g();
        this.m = lVar.c();
        this.n = lVar.j();
    }
}
