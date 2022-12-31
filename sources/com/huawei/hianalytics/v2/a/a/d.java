package com.huawei.hianalytics.v2.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private String a;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("ResponseResult", "fromJson(): JSONException");
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("resultcode");
    }
}
