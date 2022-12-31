package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.query.QueryInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzx {
    private final String zzbrb;
    private final Bundle zzcli;

    public zzzx(String str, Bundle bundle) {
        this.zzbrb = str;
        this.zzcli = bundle;
    }

    public static String zza(QueryInfo queryInfo) {
        String str = zzwr.zzqv().get(queryInfo);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final String getQuery() {
        return this.zzbrb;
    }

    public final Bundle getQueryBundle() {
        return this.zzcli;
    }
}
