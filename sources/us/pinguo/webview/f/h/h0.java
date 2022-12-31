package us.pinguo.webview.f.h;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RspShareImage.java */
/* loaded from: classes6.dex */
public class h0 extends us.pinguo.webview.f.e {
    private List<String> c;

    public h0(int i2, String str) {
        super(i2, str);
    }

    @Override // us.pinguo.webview.f.e
    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        List<String> list = this.c;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                jSONArray.put(this.c.get(i2));
            }
            a.put("channels", jSONArray);
        } else {
            a.put("channels", "[]");
        }
        return a;
    }
}
