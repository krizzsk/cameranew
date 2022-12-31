package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ControllerMessageHandler.java */
/* loaded from: classes2.dex */
public final class g {
    private static final String c = "com.ironsource.sdk.controller.g";
    private final d a;
    private final o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, o oVar) {
        this.a = dVar;
        this.b = oVar;
    }

    private String a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("functionName", com.ironsource.sdk.utils.f.c(str));
            jSONObject.put("params", com.ironsource.sdk.utils.f.c(str2));
            jSONObject.put("hash", com.ironsource.sdk.utils.f.c(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void b(Exception exc) {
        exc.printStackTrace();
        String str = c;
        com.ironsource.sdk.utils.d.d(str, "messageHandler failed with exception " + exc.getMessage());
    }

    private void c(String str, String str2, String str3) {
        this.a.b(a(str, str2, str3));
    }

    private void d(String str, String str2) throws Exception {
        this.a.a(str, str2);
    }

    @JavascriptInterface
    public void messageHandler(String str, String str2, String str3) {
        try {
            String str4 = c;
            com.ironsource.sdk.utils.d.d(str4, "messageHandler(" + str + " " + str3 + ")");
            if (this.b.f(str, str2, str3)) {
                d(str, str2);
            } else {
                c(str, str2, str3);
            }
        } catch (Exception e2) {
            b(e2);
        }
    }
}
