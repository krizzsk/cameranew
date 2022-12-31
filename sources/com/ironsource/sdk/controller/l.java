package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;
import org.json.JSONObject;
/* compiled from: JSMessageDispatcher.java */
/* loaded from: classes2.dex */
public class l {
    private WebController.r.b0 a;

    public l(WebController.r.b0 b0Var) {
        this.a = b0Var;
    }

    public void a(k kVar, JSONObject jSONObject) {
        this.a.c(false, kVar.a(), jSONObject);
    }

    public void b(k kVar, JSONObject jSONObject) {
        this.a.c(true, kVar.d(), jSONObject);
    }
}
