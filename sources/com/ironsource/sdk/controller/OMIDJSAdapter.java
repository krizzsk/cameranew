package com.ironsource.sdk.controller;

import android.content.Context;
import android.webkit.WebView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.controller.WebController;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OMIDJSAdapter {
    private static final String b = "OMIDJSAdapter";
    private Context a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        String a;
        JSONObject b;
        String c;

        /* renamed from: d  reason: collision with root package name */
        String f5716d;

        private b() {
        }
    }

    public OMIDJSAdapter(Context context) {
        this.a = context;
    }

    private b b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString("omidFunction");
        bVar.b = jSONObject.optJSONObject("omidParams");
        bVar.c = jSONObject.optString(FirebaseAnalytics.Param.SUCCESS);
        bVar.f5716d = jSONObject.optString("fail");
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, WebController.r.b0 b0Var, WebView webView) throws Exception {
        b b2 = b(str);
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d();
        try {
            String str2 = b2.a;
            char c = 65535;
            switch (str2.hashCode()) {
                case -1655974669:
                    if (str2.equals("activate")) {
                        c = 0;
                        break;
                    }
                    break;
                case -984459207:
                    if (str2.equals("getOmidData")) {
                        c = 4;
                        break;
                    }
                    break;
                case 70701699:
                    if (str2.equals("finishSession")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1208109646:
                    if (str2.equals("impressionOccurred")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1850541012:
                    if (str2.equals("startSession")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                d.e.d.l.a.a.a(this.a);
                dVar = d.e.d.l.a.a.e();
            } else if (c == 1) {
                d.e.d.l.a.a.h(b2.b, webView);
            } else if (c == 2) {
                d.e.d.l.a.a.d();
            } else if (c == 3) {
                d.e.d.l.a.a.f(b2.b);
            } else if (c == 4) {
                dVar = d.e.d.l.a.a.e();
            } else {
                throw new IllegalArgumentException(String.format("%s | unsupported OMID API", b2.a));
            }
            b0Var.a(true, b2.c, dVar);
        } catch (Exception e2) {
            dVar.h("errMsg", e2.getMessage());
            String str3 = b;
            com.ironsource.sdk.utils.d.d(str3, "OMIDJSAdapter " + b2.a + " Exception: " + e2.getMessage());
            b0Var.a(false, b2.f5716d, dVar);
        }
    }
}
