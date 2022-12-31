package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmw implements zzeqb<zzcrj<zzblv>> {
    private final zzeqo<zzcwi<zzblv, zzdog, zzctd>> zzfde;
    private final zzeqo<Boolean> zzfnm;
    private final zzeqo<zzcuq> zzfno;

    public zzbmw(zzeqo<Boolean> zzeqoVar, zzeqo<zzcuq> zzeqoVar2, zzeqo<zzcwi<zzblv, zzdog, zzctd>> zzeqoVar3) {
        this.zzfnm = zzeqoVar;
        this.zzfno = zzeqoVar2;
        this.zzfde = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzfnm.get().booleanValue();
        zzcuq zzcuqVar = this.zzfno.get();
        zzcwi<zzblv, zzdog, zzctd> zzcwiVar = this.zzfde.get();
        if (!booleanValue) {
            zzcuqVar = zzcwiVar;
        }
        return (zzcrj) zzeqh.zza(zzcuqVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
