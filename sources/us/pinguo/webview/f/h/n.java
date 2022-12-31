package us.pinguo.webview.f.h;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGUploadImage.java */
/* loaded from: classes6.dex */
public class n extends us.pinguo.webview.f.b<a0, i0> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public a0 c(JSONObject jSONObject) throws JSONException {
        a0 a0Var = new a0();
        a0Var.a = jSONObject.getString("localId");
        a0Var.b = jSONObject.getString("uploadUrl");
        return a0Var;
    }
}
