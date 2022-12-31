package us.pinguo.webview.f.h;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGAlipay.java */
/* loaded from: classes6.dex */
public class b extends us.pinguo.webview.f.b<p, us.pinguo.webview.f.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public p c(JSONObject jSONObject) throws JSONException {
        p pVar = new p();
        if (!jSONObject.isNull("packageValue")) {
            pVar.b(jSONObject.getString("packageValue"));
        }
        return pVar;
    }
}
