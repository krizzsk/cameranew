package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdgd implements zzdfj<JSONObject> {
    private final String zzheb;

    public zzdgd(String str) {
        this.zzheb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.zzheb);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Failed putting Ad ID.", e2);
        }
    }
}
