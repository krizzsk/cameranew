package com.huawei.hianalytics.v2.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends c {
    public static a[] b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new a[0];
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("events");
            if (jSONArray != null) {
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    a aVar = new a();
                    aVar.a(optJSONObject);
                    arrayList.add(aVar);
                }
                return (a[]) arrayList.toArray(new a[arrayList.size()]);
            }
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("ActionData", "parseAppActionDate(): JSONException");
        }
        return new a[0];
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", d());
            jSONObject.put("eventtime", this.a);
            jSONObject.put("event", this.b);
            jSONObject.put("properties", new JSONObject(e()));
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("ActionData", "toJsonObj() JSONException");
        }
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("eventtime", "");
        this.b = jSONObject.optString("event", "");
        d(jSONObject.optString("properties", ""));
        this.f5128d = jSONObject.optString("type", "");
    }
}
