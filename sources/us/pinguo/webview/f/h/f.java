package us.pinguo.webview.f.h;

import com.tencent.tauth.AuthActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.api.QiniuAuthToken;
import us.pinguo.webview.f.h.t;
/* compiled from: PGConfigToolBar.java */
/* loaded from: classes6.dex */
public class f extends us.pinguo.webview.f.b<t, us.pinguo.webview.f.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public t c(JSONObject jSONObject) throws JSONException {
        t tVar = new t();
        JSONArray jSONArray = jSONObject.getJSONArray("toolBar");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                t.c cVar = new t.c(jSONObject2.getString(AuthActivity.ACTION_KEY));
                if (jSONObject2.has("display")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("display");
                    cVar.c(jSONObject3.has(QiniuAuthToken.TYPE_IMAGE) ? jSONObject3.getString(QiniuAuthToken.TYPE_IMAGE) : null, jSONObject3.has("text") ? jSONObject3.getString("text") : null);
                }
                tVar.a(cVar);
            } catch (JSONException unused) {
            }
        }
        return tVar;
    }
}
