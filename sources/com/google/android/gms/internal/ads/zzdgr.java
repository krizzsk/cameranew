package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdgr implements zzdfj<JSONObject> {
    private JSONObject zzhej;

    public zzdgr(JSONObject jSONObject) {
        this.zzhej = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.zzhej);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Unable to get cache_state");
        }
    }
}
