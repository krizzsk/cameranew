package us.pinguo.webview.f.h;

import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGShareUrl.java */
/* loaded from: classes6.dex */
public class k extends us.pinguo.webview.f.b<x, Object> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public x c(JSONObject jSONObject) throws JSONException {
        x xVar = new x();
        if (jSONObject.has("shareData")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("shareData");
            if (jSONObject2.has("imgUrl")) {
                xVar.f12502d = jSONObject2.getString("imgUrl");
            }
            if (jSONObject2.has(SocialConstants.PARAM_APP_DESC)) {
                xVar.b = jSONObject2.getString(SocialConstants.PARAM_APP_DESC);
            }
            if (jSONObject2.has("link")) {
                xVar.c = jSONObject2.getString("link");
            }
            if (jSONObject2.has("title")) {
                xVar.a = jSONObject2.getString("title");
            }
        }
        if (jSONObject.has("channel")) {
            xVar.f12503e = jSONObject.getString("channel");
        }
        return xVar;
    }
}
