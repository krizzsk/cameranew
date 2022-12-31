package com.google.android.gms.internal.ads;

import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzctv implements zzcro<zzdog, zzctd> {
    private final zzcin zzgmw;

    public zzctv(zzcin zzcinVar) {
        this.zzgmw = zzcinVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcro
    public final zzcrl<zzdog, zzctd> zzf(String str, JSONObject jSONObject) throws zzdnt {
        zzdog zzd = this.zzgmw.zzd(str, jSONObject);
        if (zzd == null) {
            return null;
        }
        return new zzcrl<>(zzd, new zzctd(), str);
    }
}
