package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsf implements zzdrz {
    private final zzdsj zzgmc;
    private final zzdsh zzgmd;
    private final zzdrw zzhrt;

    public zzdsf(zzdrw zzdrwVar, zzdsj zzdsjVar, zzdsh zzdshVar) {
        this.zzhrt = zzdrwVar;
        this.zzgmc = zzdsjVar;
        this.zzgmd = zzdshVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final void zzb(zzdsa zzdsaVar) {
        this.zzhrt.zzgv(zzc(zzdsaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final String zzc(zzdsa zzdsaVar) {
        zzdsj zzdsjVar = this.zzgmc;
        Map<String, String> zzls = zzdsaVar.zzls();
        this.zzgmd.zzq(zzls);
        return zzdsjVar.zzr(zzls);
    }
}
