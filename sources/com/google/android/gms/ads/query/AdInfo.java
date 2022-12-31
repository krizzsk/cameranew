package com.google.android.gms.ads.query;

import com.google.android.gms.internal.ads.zzazk;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class AdInfo {
    private final QueryInfo a;
    private final String b;

    public AdInfo(QueryInfo queryInfo, String str) {
        this.a = queryInfo;
        this.b = str;
    }

    public static String getRequestId(String str) {
        if (str == null) {
            zzazk.zzex("adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.");
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            zzazk.zzex("Invalid adString passed to AdInfo.getRequestId(). Returning empty string.");
            return "";
        }
    }

    public String getAdString() {
        return this.b;
    }

    public QueryInfo getQueryInfo() {
        return this.a;
    }
}
