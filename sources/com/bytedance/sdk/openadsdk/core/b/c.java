package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import com.bytedance.sdk.adnet.b.h;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FrequentCallEventHelper.java */
/* loaded from: classes.dex */
public class c {
    public static void a(Context context, String str, long j2) {
        new h(1, ab.i("/api/ad/union/sdk/stats/"), a(str, j2), null).setRetryPolicy(d.b().a(10000));
    }

    private static JSONObject a(String str, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", "3.1.5.4");
            jSONObject.put("timestamp", j2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
