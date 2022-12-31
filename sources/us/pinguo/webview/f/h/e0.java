package us.pinguo.webview.f.h;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RspCheckJsApi.java */
/* loaded from: classes6.dex */
public class e0 extends us.pinguo.webview.f.e {
    private List<a> c = null;

    @Override // us.pinguo.webview.f.e
    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        List<a> list = this.c;
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (a aVar : this.c) {
                jSONObject.put(aVar.a, aVar.b ? "1" : "0");
            }
            a.put("apiResult", jSONObject);
        } else {
            a.put("apiResult", "{}");
        }
        return a;
    }

    public void b(List<a> list) {
        this.c = list;
    }
}
