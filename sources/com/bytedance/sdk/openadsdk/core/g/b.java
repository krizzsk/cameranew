package com.bytedance.sdk.openadsdk.core.g;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: DnsInfo.java */
/* loaded from: classes.dex */
public class b {
    String a;
    HashMap<String, c> b = new HashMap<>();

    private b() {
    }

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            b bVar = new b();
            bVar.a(jSONObject.optString("cip"));
            JSONArray optJSONArray = jSONObject.optJSONArray("dns");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    c a = c.a(optJSONArray.getJSONObject(i2));
                    bVar.b().put(a.a(), a);
                }
            } else {
                c a2 = c.a(jSONObject);
                bVar.b().put(a2.a(), a2);
            }
            return bVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public HashMap<String, c> b() {
        return this.b;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cip", a());
            JSONArray jSONArray = new JSONArray();
            if (b() != null) {
                for (Map.Entry<String, c> entry : b().entrySet()) {
                    jSONArray.put(entry.getValue().f());
                }
            }
            jSONObject.put("dns", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }
}
