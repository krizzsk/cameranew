package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqx;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcaz implements zzeqb<zzbny<zzblv>> {
    private final zzeqo<zzbts> zzfyg;
    private final zzeqo<zzbgc> zzgca;
    private final zzeqo<zzbqx.zza> zzgcb;
    private final zzeqo<zzbwg> zzgcc;
    private final zzeqo<zzcaq> zzgcd;

    public zzcaz(zzeqo<zzbgc> zzeqoVar, zzeqo<zzbqx.zza> zzeqoVar2, zzeqo<zzbwg> zzeqoVar3, zzeqo<zzcaq> zzeqoVar4, zzeqo<zzbts> zzeqoVar5) {
        this.zzgca = zzeqoVar;
        this.zzgcb = zzeqoVar2;
        this.zzgcc = zzeqoVar3;
        this.zzgcd = zzeqoVar4;
        this.zzfyg = zzeqoVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbny) zzeqh.zza(this.zzgca.get().zzafh().zzd(this.zzgcb.get().zzalo()).zzd(this.zzgcc.get()).zzb(this.zzgcd.get()).zza(new zzcxa(null)).zza(new zzbnq(this.zzfyg.get())).zzd(new zzblu(null)).zzahk().zzahs(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
