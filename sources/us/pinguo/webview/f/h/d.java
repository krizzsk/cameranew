package us.pinguo.webview.f.h;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGChooseImage.java */
/* loaded from: classes6.dex */
public class d extends us.pinguo.webview.f.b<r, f0> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public r c(JSONObject jSONObject) throws JSONException {
        r rVar = new r();
        if (jSONObject.has("type")) {
            rVar.a = jSONObject.getString("type");
        }
        if (jSONObject.has("imageSize")) {
            rVar.b = jSONObject.getString("imageSize");
        }
        return rVar;
    }
}
