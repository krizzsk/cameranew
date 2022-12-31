package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdso implements zzdrz {
    private final zzdsj zzgmc;
    private final zzdsh zzgmd;

    public zzdso(zzdsj zzdsjVar, zzdsh zzdshVar) {
        this.zzgmc = zzdsjVar;
        this.zzgmd = zzdshVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final void zzb(zzdsa zzdsaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final String zzc(zzdsa zzdsaVar) {
        zzdsj zzdsjVar = this.zzgmc;
        Map<String, String> zzls = zzdsaVar.zzls();
        this.zzgmd.zzq(zzls);
        return zzdsjVar.zzr(zzls);
    }
}
