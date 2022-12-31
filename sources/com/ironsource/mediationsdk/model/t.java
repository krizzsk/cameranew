package com.ironsource.mediationsdk.model;

import org.json.JSONObject;
/* compiled from: ServerSegmetData.java */
/* loaded from: classes2.dex */
public class t {
    private String a;
    private String b;
    private JSONObject c;

    public t(String str, String str2, JSONObject jSONObject) {
        this.a = str;
        this.b = str2;
        this.c = jSONObject;
    }

    public JSONObject a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }
}
