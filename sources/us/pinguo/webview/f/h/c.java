package us.pinguo.webview.f.h;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGCheckJsApi.java */
/* loaded from: classes6.dex */
public class c extends us.pinguo.webview.f.b<q, e0> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public q c(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("jsApiList")) {
            JSONArray jSONArray = jSONObject.getJSONArray("jsApiList");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.getString(i2));
            }
        }
        q qVar = new q();
        qVar.a = arrayList;
        return qVar;
    }
}
