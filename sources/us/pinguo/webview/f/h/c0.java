package us.pinguo.webview.f.h;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RespCommonInfo.java */
/* loaded from: classes6.dex */
public class c0 extends us.pinguo.webview.f.e {
    private Map<String, String> c;

    @Override // us.pinguo.webview.f.e
    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        if (this.c == null) {
            a.put("result", "[]");
        } else {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            a.put("result", jSONObject);
        }
        return a;
    }

    public void b(Map<String, String> map) {
        this.c = map;
    }
}
