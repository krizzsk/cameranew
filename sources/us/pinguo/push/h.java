package us.pinguo.push;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PushNotifyBean.java */
/* loaded from: classes6.dex */
public class h {
    private String a = null;
    private String b = null;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h c(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            h hVar = new h();
            hVar.a = jSONObject.getString("title");
            hVar.b = jSONObject.getString("msg");
            return hVar;
        } catch (JSONException e2) {
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }
}
