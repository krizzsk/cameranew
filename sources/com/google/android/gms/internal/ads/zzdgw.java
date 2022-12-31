package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdgw implements zzdfj<JSONObject> {
    private String zzhen;
    private String zzheo;

    public zzdgw(String str, String str2) {
        this.zzhen = str;
        this.zzheo = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject, "pii");
            zzb.put("doritos", this.zzhen);
            zzb.put("doritos_v2", this.zzheo);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Failed putting doritos string.");
        }
    }
}
