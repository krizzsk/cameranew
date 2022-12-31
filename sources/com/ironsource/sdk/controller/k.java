package com.ironsource.sdk.controller;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: JSInterfaceMessage.java */
/* loaded from: classes2.dex */
public class k {
    private String a;
    private JSONObject b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5762d;

    public k(JSONObject jSONObject) {
        this.a = jSONObject.optString("functionName");
        this.b = jSONObject.optJSONObject("functionParams");
        this.c = jSONObject.optString(FirebaseAnalytics.Param.SUCCESS);
        this.f5762d = jSONObject.optString("fail");
    }

    public String a() {
        return this.f5762d;
    }

    public String b() {
        return this.a;
    }

    public JSONObject c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("functionName", this.a);
            jSONObject.put("functionParams", this.b);
            jSONObject.put(FirebaseAnalytics.Param.SUCCESS, this.c);
            jSONObject.put("fail", this.f5762d);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
