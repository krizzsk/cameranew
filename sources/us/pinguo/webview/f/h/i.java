package us.pinguo.webview.f.h;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGSaveImage.java */
/* loaded from: classes6.dex */
public class i extends us.pinguo.webview.f.b<v, us.pinguo.webview.f.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public v c(JSONObject jSONObject) throws JSONException {
        v vVar = new v();
        vVar.a = jSONObject.getString("localId");
        return vVar;
    }
}
