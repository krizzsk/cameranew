package com.ironsource.sdk.controller;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.service.TokenService;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: TokenJSAdapter.java */
/* loaded from: classes2.dex */
public class p {
    private static final String c = "p";
    private TokenService a;
    private Context b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TokenJSAdapter.java */
    /* loaded from: classes2.dex */
    public static class b {
        String a;
        JSONObject b;
        String c;

        /* renamed from: d  reason: collision with root package name */
        String f5763d;

        private b() {
        }
    }

    public p(Context context, TokenService tokenService) {
        this.a = tokenService;
        this.b = context;
    }

    private b b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString("functionName");
        bVar.b = jSONObject.optJSONObject("functionParams");
        bVar.c = jSONObject.optString(FirebaseAnalytics.Param.SUCCESS);
        bVar.f5763d = jSONObject.optString("fail");
        return bVar;
    }

    private void c(b bVar, WebController.r.b0 b0Var) {
        try {
            b0Var.c(true, bVar.c, this.a.l(this.b));
        } catch (Exception e2) {
            b0Var.b(false, bVar.f5763d, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, WebController.r.b0 b0Var) throws Exception {
        b b2 = b(str);
        if ("updateToken".equals(b2.a)) {
            d(b2.b, b2, b0Var);
        } else if ("getToken".equals(b2.a)) {
            c(b2, b0Var);
        } else {
            String str2 = c;
            com.ironsource.sdk.utils.d.d(str2, "unhandled API request " + str);
        }
    }

    public void d(JSONObject jSONObject, b bVar, WebController.r.b0 b0Var) {
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d();
        try {
            this.a.o(jSONObject);
            b0Var.a(true, bVar.c, dVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            String str = c;
            com.ironsource.sdk.utils.d.d(str, "updateToken exception " + e2.getMessage());
            b0Var.a(false, bVar.f5763d, dVar);
        }
    }
}
