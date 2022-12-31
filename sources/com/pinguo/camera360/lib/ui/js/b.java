package com.pinguo.camera360.lib.ui.js;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGChooseC360Img.java */
/* loaded from: classes3.dex */
public class b extends us.pinguo.webview.f.b<e, g> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public e c(JSONObject jSONObject) throws JSONException {
        e eVar = new e();
        eVar.a = jSONObject.getString("url");
        eVar.b = jSONObject.optString("imageSize", "2048");
        return eVar;
    }
}
