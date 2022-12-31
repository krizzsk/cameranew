package us.pinguo.webview.f.h;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PGSign.java */
/* loaded from: classes6.dex */
public class m extends us.pinguo.webview.f.b<z, d0> {

    /* renamed from: d  reason: collision with root package name */
    Map<String, String> f12501d = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public z c(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.isNull(next)) {
                this.f12501d.put(next, jSONObject2.getString(next));
            }
        }
        z zVar = new z();
        zVar.b(this.f12501d);
        return zVar;
    }
}
