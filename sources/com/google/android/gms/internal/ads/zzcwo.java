package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcwo implements zzcrj<zzblv> {
    private final zzdrj zzfwz;
    private final zzbmr zzgto;
    private final zzdzv zzgwi;
    private final Context zzgwp;
    @Nullable
    private final zzacl zzgwq;

    public zzcwo(Context context, zzbmr zzbmrVar, zzdrj zzdrjVar, zzdzv zzdzvVar, @Nullable zzacl zzaclVar) {
        this.zzgwp = context;
        this.zzgto = zzbmrVar;
        this.zzfwz = zzdrjVar;
        this.zzgwi = zzdzvVar;
        this.zzgwq = zzaclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final boolean zza(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        zzdnd zzdndVar;
        return (this.zzgwq == null || (zzdndVar = zzdmwVar.zzhjg) == null || zzdndVar.zzdsy == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final zzdzw<zzblv> zzb(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        zzbly zza = this.zzgto.zza(new zzboj(zzdnlVar, zzdmwVar, null), new zzcwp(this, new View(this.zzgwp), null, zzcwn.zzgwo, zzdmwVar.zzhji.get(0)));
        zzcws zzahq = zza.zzahq();
        zzdnd zzdndVar = zzdmwVar.zzhjg;
        final zzace zzaceVar = new zzace(zzahq, zzdndVar.zzdsw, zzdndVar.zzdsy);
        return this.zzfwz.zzt(zzdrk.CUSTOM_RENDER_SYN).zza(new zzdqt(this, zzaceVar) { // from class: com.google.android.gms.internal.ads.zzcwq
            private final zzcwo zzgwr;
            private final zzace zzgws;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwr = this;
                this.zzgws = zzaceVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdqt
            public final void run() {
                this.zzgwr.zza(this.zzgws);
            }
        }, this.zzgwi).zzv(zzdrk.CUSTOM_RENDER_ACK).zze(zzdzk.zzag(zza.zzaho())).zzaxj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzace zzaceVar) throws Exception {
        this.zzgwq.zza(zzaceVar);
    }
}
