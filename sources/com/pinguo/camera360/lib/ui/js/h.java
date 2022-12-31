package com.pinguo.camera360.lib.ui.js;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RespLogin.java */
/* loaded from: classes3.dex */
public class h extends us.pinguo.webview.f.e {
    private RespJsData c;

    public h() {
    }

    @Override // us.pinguo.webview.f.e
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.c != null) {
            jSONObject.put("result", new JSONObject(new com.google.gson.e().t(this.c, RespJsData.class)));
        } else {
            jSONObject.put("result", "[]");
        }
        return jSONObject;
    }

    public void b(RespJsData respJsData) {
        this.c = respJsData;
    }

    public h(int i2, String str) {
        super(i2, str);
    }
}
