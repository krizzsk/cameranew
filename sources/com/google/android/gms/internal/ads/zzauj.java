package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzauj implements zzatu {
    private zzamb<JSONObject, JSONObject> zzdyy;
    private zzamb<JSONObject, JSONObject> zzdzd;

    public zzauj(Context context) {
        zzamj zza = com.google.android.gms.ads.internal.zzr.zzle().zza(context, zzazn.zzaab());
        zzamf<JSONObject> zzamfVar = zzame.zzdks;
        this.zzdzd = zza.zza("google.afma.request.getAdDictionary", zzamfVar, zzamfVar);
        this.zzdyy = com.google.android.gms.ads.internal.zzr.zzle().zza(context, zzazn.zzaab()).zza("google.afma.sdkConstants.getSdkConstants", zzamfVar, zzamfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatu
    public final zzamb<JSONObject, JSONObject> zzwk() {
        return this.zzdyy;
    }
}
