package com.ironsource.sdk.controller;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.controller.WebController;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PermissionsJSAdapter {
    private static final String b = "PermissionsJSAdapter";
    private Context a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        String a;
        JSONObject b;
        String c;

        /* renamed from: d  reason: collision with root package name */
        String f5725d;

        private b() {
        }
    }

    public PermissionsJSAdapter(Context context) {
        this.a = context;
    }

    private b b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString("functionName");
        bVar.b = jSONObject.optJSONObject("functionParams");
        bVar.c = jSONObject.optString(FirebaseAnalytics.Param.SUCCESS);
        bVar.f5725d = jSONObject.optString("fail");
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, WebController.r.b0 b0Var) throws Exception {
        b b2 = b(str);
        if ("getPermissions".equals(b2.a)) {
            c(b2.b, b2, b0Var);
        } else if ("isPermissionGranted".equals(b2.a)) {
            d(b2.b, b2, b0Var);
        } else {
            String str2 = b;
            com.ironsource.sdk.utils.d.d(str2, "PermissionsJSAdapter unhandled API request " + str);
        }
    }

    public void c(JSONObject jSONObject, b bVar, WebController.r.b0 b0Var) {
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d();
        try {
            dVar.i("permissions", com.ironsource.environment.c.g(this.a, jSONObject.getJSONArray("permissions")));
            b0Var.a(true, bVar.c, dVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            String str = b;
            com.ironsource.sdk.utils.d.d(str, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e2.getMessage());
            dVar.h("errMsg", e2.getMessage());
            b0Var.a(false, bVar.f5725d, dVar);
        }
    }

    public void d(JSONObject jSONObject, b bVar, WebController.r.b0 b0Var) {
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d();
        try {
            String string = jSONObject.getString("permission");
            dVar.h("permission", string);
            if (com.ironsource.environment.c.j(this.a, string)) {
                dVar.h("status", String.valueOf(com.ironsource.environment.c.i(this.a, string)));
                b0Var.a(true, bVar.c, dVar);
            } else {
                dVar.h("status", "unhandledPermission");
                b0Var.a(false, bVar.f5725d, dVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            dVar.h("errMsg", e2.getMessage());
            b0Var.a(false, bVar.f5725d, dVar);
        }
    }
}
