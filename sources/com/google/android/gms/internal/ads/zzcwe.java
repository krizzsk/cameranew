package com.google.android.gms.internal.ads;

import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcwe implements zzcro<zzapk, zzctd> {
    private final zzcxh zzgwe;

    public zzcwe(zzcxh zzcxhVar) {
        this.zzgwe = zzcxhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcro
    public final zzcrl<zzapk, zzctd> zzf(String str, JSONObject jSONObject) throws zzdnt {
        zzapk zzgo = this.zzgwe.zzgo(str);
        if (zzgo == null) {
            return null;
        }
        return new zzcrl<>(zzgo, new zzctd(), str);
    }
}
