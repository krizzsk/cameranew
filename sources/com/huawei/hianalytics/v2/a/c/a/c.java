package com.huawei.hianalytics.v2.a.c.a;

import android.text.TextUtils;
import com.huawei.hianalytics.v2.HiAnalytics;
import com.huawei.hianalytics.v2.a.b.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements a {
    private void c(String str) {
        String[] split = str.split(",");
        if (split.length != 3) {
            return;
        }
        String str2 = split[0];
        String str3 = split[1];
        String str4 = split[2];
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        long longValue = com.huawei.hianalytics.v2.a.c.a.a(str3).longValue();
        long d2 = d(str4);
        if (longValue <= 0 || d2 < 0) {
            return;
        }
        j.b(new com.huawei.hianalytics.v2.a.c.b.a(str2, longValue));
        j.a(new com.huawei.hianalytics.v2.a.c.b.a(str2, longValue + d2, d2));
    }

    private long d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.parseLong(str) * 1000;
        } catch (NumberFormatException unused) {
            com.huawei.hianalytics.b.b.c("V1LifeCycleAdapter", "failed to bisdk convertDuration.");
            return -1L;
        }
    }

    @Override // com.huawei.hianalytics.v2.a.c.a.a
    public void a() {
        HiAnalytics.onReport();
    }

    @Override // com.huawei.hianalytics.v2.a.c.a.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(";")) {
            c(str2);
        }
    }

    @Override // com.huawei.hianalytics.v2.a.c.a.a
    public void b(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray2 = new JSONObject(str).getJSONArray("termination");
            if (jSONArray2 == null) {
                return;
            }
            int length = jSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                if (jSONObject != null && jSONObject.has("b") && (jSONArray = jSONObject.getJSONArray("b")) != null) {
                    int length2 = jSONArray.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        c(jSONArray.getString(i3));
                    }
                }
            }
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.d("V1LifeCycleAdapter", "Exception occurred in parsing file data.");
        }
    }
}
