package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: BannerJSAdapter.java */
/* loaded from: classes2.dex */
public class b implements com.ironsource.sdk.ISNAdView.a {
    private static final String c = "b";
    private ISNAdView a;
    private r b;

    @Override // com.ironsource.sdk.ISNAdView.a
    public void a(String str, JSONObject jSONObject) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.a(str, jSONObject);
    }

    @Override // com.ironsource.sdk.ISNAdView.a
    public void b(String str, String str2, String str3) {
        a(str, com.ironsource.sdk.utils.g.a(str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("functionName");
            JSONObject optJSONObject = jSONObject.optJSONObject("functionParams");
            String optString2 = jSONObject.optString(FirebaseAnalytics.Param.SUCCESS);
            String optString3 = jSONObject.optString("fail");
            if (TextUtils.isEmpty(optString)) {
                String str2 = c;
                com.ironsource.sdk.utils.d.d(str2, "BannerJSAdapter | sendMessageToISNAdView | Invalid message format: " + str);
                return;
            }
            ISNAdView iSNAdView = this.a;
            if (iSNAdView == null) {
                b(optString3, "Send message to ISNAdView failed", "");
            } else {
                iSNAdView.q(optString, optJSONObject, optString2, optString3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void d(ISNAdView iSNAdView) {
        this.a = iSNAdView;
        iSNAdView.setControllerDelegate(this);
    }

    public void e(r rVar) {
        this.b = rVar;
    }
}
