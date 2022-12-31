package com.huawei.hianalytics.v2.a.a;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends d {
    private String a;

    @Override // com.huawei.hianalytics.v2.a.a.d
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.a = jSONObject.optString("serverUrl");
    }

    public String b() {
        return this.a;
    }
}
