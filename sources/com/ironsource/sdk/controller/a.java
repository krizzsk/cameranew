package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.WPAD.AdViewsManager;
import com.ironsource.sdk.controller.WebController;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AdViewsJSAdapter.java */
/* loaded from: classes2.dex */
public class a implements com.ironsource.sdk.ISNAdView.a {
    private r a;
    private AdViewsManager b = AdViewsManager.getInstance();
    c c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdViewsJSAdapter.java */
    /* loaded from: classes2.dex */
    public static class b {
        String a;
        JSONObject b;
        String c;

        /* renamed from: d  reason: collision with root package name */
        String f5744d;

        private b() {
        }
    }

    public a(c cVar) {
        this.c = cVar;
    }

    private b d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString("functionName");
        bVar.b = jSONObject.optJSONObject("functionParams");
        bVar.c = jSONObject.optString(FirebaseAnalytics.Param.SUCCESS);
        bVar.f5744d = jSONObject.optString("fail");
        return bVar;
    }

    @Override // com.ironsource.sdk.ISNAdView.a
    public void a(String str, JSONObject jSONObject) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.a(str, jSONObject);
    }

    @Override // com.ironsource.sdk.ISNAdView.a
    public void b(String str, String str2, String str3) {
        a(str, com.ironsource.sdk.utils.g.a(str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, WebController.r.b0 b0Var) throws Exception {
        b d2 = d(str);
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d();
        try {
            String str2 = d2.a;
            char c = 65535;
            switch (str2.hashCode()) {
                case -1384357108:
                    if (str2.equals("removeAdView")) {
                        c = 3;
                        break;
                    }
                    break;
                case 691453791:
                    if (str2.equals("sendMessage")) {
                        c = 1;
                        break;
                    }
                    break;
                case 842351363:
                    if (str2.equals("loadWithUrl")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1633780878:
                    if (str2.equals("isExternalAdViewInitiated")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                this.b.c(this, d2.b, this.c.a(), d2.c, d2.f5744d);
            } else if (c == 1) {
                this.b.f(d2.b, d2.c, d2.f5744d);
            } else if (c == 2) {
                this.b.e(d2.b, d2.c);
            } else if (c == 3) {
                this.b.d(d2.b, d2.c, d2.f5744d);
            } else {
                throw new IllegalArgumentException(String.format("%s | unsupported AdViews API", d2.a));
            }
        } catch (Exception e2) {
            dVar.h("errMsg", e2.getMessage());
            String b2 = this.b.b(d2.b);
            if (!TextUtils.isEmpty(b2)) {
                dVar.h("adViewId", b2);
            }
            b0Var.a(false, d2.f5744d, dVar);
        }
    }

    public void e(r rVar) {
        this.a = rVar;
    }
}
