package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdgl implements zzdfj<JSONObject> {
    private String zzheg;

    public zzdgl(String str) {
        this.zzheg = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject, "pii");
            if (TextUtils.isEmpty(this.zzheg)) {
                return;
            }
            zzb.put("attok", this.zzheg);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Failed putting attestation token.", e2);
        }
    }
}
