package us.pinguo.webview.f.h;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGWXpay.java */
/* loaded from: classes6.dex */
public class o extends us.pinguo.webview.f.b<b0, us.pinguo.webview.f.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public b0 c(JSONObject jSONObject) throws JSONException {
        b0 b0Var = new b0();
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        if (!jSONObject2.isNull("noncestr")) {
            b0Var.f12499e = jSONObject2.getString("noncestr");
        }
        if (!jSONObject2.isNull("package")) {
            b0Var.a = jSONObject2.getString("package");
        }
        if (!jSONObject2.isNull("prepayid")) {
            b0Var.b = jSONObject2.getString("prepayid");
        }
        if (!jSONObject2.isNull("timestamp")) {
            b0Var.c = jSONObject2.getString("timestamp");
        }
        if (!jSONObject2.isNull("sign")) {
            b0Var.f12498d = jSONObject2.getString("sign");
        }
        if (!jSONObject2.isNull("packagevalue")) {
            jSONObject2.getString("packagevalue");
        }
        return b0Var;
    }
}
