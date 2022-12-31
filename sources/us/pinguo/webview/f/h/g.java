package us.pinguo.webview.f.h;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGDownloadImage.java */
/* loaded from: classes6.dex */
public class g extends us.pinguo.webview.f.b<u, g0> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public u c(JSONObject jSONObject) throws JSONException {
        u uVar = new u();
        uVar.a = jSONObject.getString("url");
        return uVar;
    }
}
