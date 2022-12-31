package com.ironsource.mediationsdk;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AuctionResponseItem.java */
/* loaded from: classes2.dex */
public class f {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f5560d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f5561e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f5562f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5563g;

    /* renamed from: h  reason: collision with root package name */
    private com.ironsource.mediationsdk.l0.b f5564h;

    public f(String str) {
        this.a = str;
        this.b = "";
        this.c = "";
        this.f5560d = new ArrayList();
        this.f5561e = new ArrayList();
        this.f5562f = new ArrayList();
        this.f5563g = true;
        this.f5564h = null;
    }

    public List<String> a() {
        return this.f5560d;
    }

    public com.ironsource.mediationsdk.l0.b b(String str) {
        com.ironsource.mediationsdk.l0.b bVar = this.f5564h;
        if (bVar != null) {
            bVar.a("${PLACEMENT_NAME}", str);
        }
        return this.f5564h;
    }

    public String c() {
        return this.a;
    }

    public List<String> d() {
        return this.f5561e;
    }

    public List<String> e() {
        return this.f5562f;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.b;
    }

    public boolean h() {
        return this.f5563g;
    }

    public f(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f5563g = false;
        try {
            if (jSONObject.has("instance")) {
                this.a = jSONObject.getString("instance");
            }
            if (jSONObject.has("adMarkup")) {
                this.b = jSONObject.getString("adMarkup");
            } else if (jSONObject.has("serverData")) {
                this.b = jSONObject.getString("serverData");
            } else {
                this.b = "";
            }
            if (jSONObject.has(FirebaseAnalytics.Param.PRICE)) {
                this.c = jSONObject.getString(FirebaseAnalytics.Param.PRICE);
            } else {
                this.c = "0";
            }
            this.f5560d = new ArrayList();
            this.f5561e = new ArrayList();
            this.f5562f = new ArrayList();
            if (jSONObject.has("notifications")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("notifications");
                if (optJSONObject.has("burl")) {
                    JSONArray jSONArray = optJSONObject.getJSONArray("burl");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        this.f5560d.add(jSONArray.getString(i2));
                    }
                }
                if (optJSONObject.has("lurl")) {
                    JSONArray jSONArray2 = optJSONObject.getJSONArray("lurl");
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        this.f5561e.add(jSONArray2.getString(i3));
                    }
                }
                if (optJSONObject.has("nurl")) {
                    JSONArray jSONArray3 = optJSONObject.getJSONArray("nurl");
                    for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                        this.f5562f.add(jSONArray3.getString(i4));
                    }
                }
            }
            this.f5564h = new com.ironsource.mediationsdk.l0.b(com.ironsource.mediationsdk.q0.a.d(jSONObject2, jSONObject.has("armData") ? jSONObject.optJSONObject("armData") : null));
            this.f5563g = true;
        } catch (Exception unused) {
        }
    }

    public f(JSONObject jSONObject) {
        this(jSONObject, null);
    }
}
