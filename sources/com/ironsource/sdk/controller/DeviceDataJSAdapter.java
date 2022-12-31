package com.ironsource.sdk.controller;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.controller.WebController;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DeviceDataJSAdapter {
    private static final String b = "DeviceDataJSAdapter";
    private Context a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        String a;
        String b;

        private b() {
        }
    }

    public DeviceDataJSAdapter(Context context) {
        this.a = context;
    }

    private b b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString("deviceDataFunction");
        jSONObject.optJSONObject("deviceDataParams");
        bVar.b = jSONObject.optString(FirebaseAnalytics.Param.SUCCESS);
        jSONObject.optString("fail");
        return bVar;
    }

    private com.ironsource.sdk.data.d c() {
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d();
        dVar.h(com.ironsource.sdk.utils.f.c("sdCardAvailable"), com.ironsource.sdk.utils.f.c(String.valueOf(com.ironsource.environment.e.P())));
        dVar.h(com.ironsource.sdk.utils.f.c("totalDeviceRAM"), com.ironsource.sdk.utils.f.c(String.valueOf(com.ironsource.environment.e.L(this.a))));
        dVar.h(com.ironsource.sdk.utils.f.c("isCharging"), com.ironsource.sdk.utils.f.c(String.valueOf(com.ironsource.environment.e.N(this.a))));
        dVar.h(com.ironsource.sdk.utils.f.c("chargingType"), com.ironsource.sdk.utils.f.c(String.valueOf(com.ironsource.environment.e.a(this.a))));
        dVar.h(com.ironsource.sdk.utils.f.c("airplaneMode"), com.ironsource.sdk.utils.f.c(String.valueOf(com.ironsource.environment.e.M(this.a))));
        dVar.h(com.ironsource.sdk.utils.f.c("stayOnWhenPluggedIn"), com.ironsource.sdk.utils.f.c(String.valueOf(com.ironsource.environment.e.T(this.a))));
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, WebController.r.b0 b0Var) throws Exception {
        b b2 = b(str);
        if ("getDeviceData".equals(b2.a)) {
            b0Var.a(true, b2.b, c());
            return;
        }
        String str2 = b;
        com.ironsource.sdk.utils.d.d(str2, "unhandled API request " + str);
    }
}
