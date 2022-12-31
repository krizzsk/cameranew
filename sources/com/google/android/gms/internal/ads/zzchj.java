package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzchj implements zzeqb<zzcrj<zzchb>> {
    private final zzeqo<zzcwi<zzchb, zzdog, zzctg>> zzfsx;
    private final zzeqo<zzdnp> zzfvf;
    private final zzeqo<zzcwi<zzchb, zzdog, zzctd>> zzgjt;

    public zzchj(zzeqo<zzcwi<zzchb, zzdog, zzctg>> zzeqoVar, zzeqo<zzcwi<zzchb, zzdog, zzctd>> zzeqoVar2, zzeqo<zzdnp> zzeqoVar3) {
        this.zzfsx = zzeqoVar;
        this.zzgjt = zzeqoVar2;
        this.zzfvf = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        zzcwi<zzchb, zzdog, zzctg> zzcwiVar;
        zzeqo<zzcwi<zzchb, zzdog, zzctg>> zzeqoVar = this.zzfsx;
        zzeqo<zzcwi<zzchb, zzdog, zzctd>> zzeqoVar2 = this.zzgjt;
        if (zzchk.zzgju[this.zzfvf.get().zzhle.zzhki - 1] != 1) {
            zzcwiVar = zzeqoVar2.get();
        } else {
            zzcwiVar = zzeqoVar.get();
        }
        return (zzcrj) zzeqh.zza(zzcwiVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
