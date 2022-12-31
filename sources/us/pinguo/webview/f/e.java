package us.pinguo.webview.f;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: Rsp.java */
/* loaded from: classes6.dex */
public class e {
    private int a;
    private String b;

    public e(int i2, String str) {
        this.a = i2;
        this.b = str == null ? "" : str;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", this.a);
        jSONObject.put("message", this.b);
        return jSONObject;
    }

    public e() {
        this(200, null);
    }
}
