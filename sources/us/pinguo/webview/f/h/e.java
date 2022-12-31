package us.pinguo.webview.f.h;

import com.tencent.tauth.AuthActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGConfigReturnBtn.java */
/* loaded from: classes6.dex */
public class e extends us.pinguo.webview.f.b<s, us.pinguo.webview.f.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public s c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(AuthActivity.ACTION_KEY)) {
            s sVar = new s();
            sVar.a = jSONObject.getString(AuthActivity.ACTION_KEY);
            return sVar;
        }
        return null;
    }
}
