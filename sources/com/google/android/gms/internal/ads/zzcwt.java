package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcwt<AdT> implements zzcrj<AdT> {
    private final zzdrj zzfwz;
    private final zzdzv zzgwi;
    @Nullable
    private final zzacl zzgwq;
    private final zzcwy<AdT> zzgwu;

    public zzcwt(zzdrj zzdrjVar, zzdzv zzdzvVar, @Nullable zzacl zzaclVar, zzcwy<AdT> zzcwyVar) {
        this.zzfwz = zzdrjVar;
        this.zzgwi = zzdzvVar;
        this.zzgwq = zzaclVar;
        this.zzgwu = zzcwyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final boolean zza(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        zzdnd zzdndVar;
        return (this.zzgwq == null || (zzdndVar = zzdmwVar.zzhjg) == null || zzdndVar.zzdsy == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final zzdzw<AdT> zzb(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        zzbaa zzbaaVar = new zzbaa();
        zzcxb zzcxbVar = new zzcxb();
        zzcxbVar.zza(new zzcwv(this, zzbaaVar, zzdnlVar, zzdmwVar, zzcxbVar));
        zzdnd zzdndVar = zzdmwVar.zzhjg;
        final zzace zzaceVar = new zzace(zzcxbVar, zzdndVar.zzdsw, zzdndVar.zzdsy);
        return this.zzfwz.zzt(zzdrk.CUSTOM_RENDER_SYN).zza(new zzdqt(this, zzaceVar) { // from class: com.google.android.gms.internal.ads.zzcww
            private final zzace zzgws;
            private final zzcwt zzgxa;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxa = this;
                this.zzgws = zzaceVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdqt
            public final void run() {
                this.zzgxa.zzb(this.zzgws);
            }
        }, this.zzgwi).zzv(zzdrk.CUSTOM_RENDER_ACK).zze(zzbaaVar).zzaxj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzace zzaceVar) throws Exception {
        this.zzgwq.zza(zzaceVar);
    }
}
