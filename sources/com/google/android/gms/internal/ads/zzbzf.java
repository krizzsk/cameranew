package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbzf implements zzeqb<zzbya<zzbtb>> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzazn> zzfqo;
    private final zzeqo<zzdmw> zzfta;
    private final zzeqo<zzdnp> zzfvf;
    private final zzbyz zzgbk;

    private zzbzf(zzbyz zzbyzVar, zzeqo<Context> zzeqoVar, zzeqo<zzazn> zzeqoVar2, zzeqo<zzdmw> zzeqoVar3, zzeqo<zzdnp> zzeqoVar4) {
        this.zzgbk = zzbyzVar;
        this.zzewk = zzeqoVar;
        this.zzfqo = zzeqoVar2;
        this.zzfta = zzeqoVar3;
        this.zzfvf = zzeqoVar4;
    }

    public static zzbzf zza(zzbyz zzbyzVar, zzeqo<Context> zzeqoVar, zzeqo<zzazn> zzeqoVar2, zzeqo<zzdmw> zzeqoVar3, zzeqo<zzdnp> zzeqoVar4) {
        return new zzbzf(zzbyzVar, zzeqoVar, zzeqoVar2, zzeqoVar3, zzeqoVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        final Context context = this.zzewk.get();
        final zzazn zzaznVar = this.zzfqo.get();
        final zzdmw zzdmwVar = this.zzfta.get();
        final zzdnp zzdnpVar = this.zzfvf.get();
        return (zzbya) zzeqh.zza(new zzbya(new zzbtb(context, zzaznVar, zzdmwVar, zzdnpVar) { // from class: com.google.android.gms.internal.ads.zzbzc
            private final Context zzcmi;
            private final zzazn zzfuz;
            private final zzdmw zzfva;
            private final zzdnp zzfvb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcmi = context;
                this.zzfuz = zzaznVar;
                this.zzfva = zzdmwVar;
                this.zzfvb = zzdnpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtb
            public final void onAdLoaded() {
                com.google.android.gms.ads.internal.zzr.zzlb().zzb(this.zzcmi, this.zzfuz.zzbrp, this.zzfva.zzhjl.toString(), this.zzfvb.zzhkx);
            }
        }, zzazp.zzeih), "Cannot return null from a non-@Nullable @Provides method");
    }
}
