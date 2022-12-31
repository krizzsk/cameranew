package us.pinguo.webview.f.h;

import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGShareImage.java */
/* loaded from: classes6.dex */
public class j extends us.pinguo.webview.f.b<w, h0> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public w c(JSONObject jSONObject) throws JSONException {
        w wVar = new w();
        wVar.a = jSONObject.getString("localId");
        if (jSONObject.has(SocialConstants.PARAM_APP_DESC)) {
            wVar.b = jSONObject.getString(SocialConstants.PARAM_APP_DESC);
        }
        return wVar;
    }
}
