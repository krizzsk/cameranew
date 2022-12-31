package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcsg implements zzcrj<zzblv> {
    private final Context context;
    private final Executor zzfsj;
    private final zzdnp zzfwy;
    private final zzchq zzggk;
    private final zzbmr zzgto;
    private final zzdvz<zzdmw, com.google.android.gms.ads.internal.util.zzad> zzgtp;

    public zzcsg(zzbmr zzbmrVar, Context context, Executor executor, zzchq zzchqVar, zzdnp zzdnpVar, zzdvz<zzdmw, com.google.android.gms.ads.internal.util.zzad> zzdvzVar) {
        this.context = context;
        this.zzgto = zzbmrVar;
        this.zzfsj = executor;
        this.zzggk = zzchqVar;
        this.zzfwy = zzdnpVar;
        this.zzgtp = zzdvzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final boolean zza(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        zzdnd zzdndVar = zzdmwVar.zzhjg;
        return (zzdndVar == null || zzdndVar.zzdsy == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final zzdzw<zzblv> zzb(final zzdnl zzdnlVar, final zzdmw zzdmwVar) {
        return zzdzk.zzb(zzdzk.zzag(null), new zzdyu(this, zzdnlVar, zzdmwVar) { // from class: com.google.android.gms.internal.ads.zzcsf
            private final zzdmw zzfva;
            private final zzdnl zzghw;
            private final zzcsg zzgtn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgtn = this;
                this.zzghw = zzdnlVar;
                this.zzfva = zzdmwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgtn.zzb(this.zzghw, this.zzfva, obj);
            }
        }, this.zzfsj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzbeb zzbebVar) {
        zzbebVar.zzacr();
        zzbev zzabc = zzbebVar.zzabc();
        zzaau zzaauVar = this.zzfwy.zzhkv;
        if (zzaauVar == null || zzabc == null) {
            return;
        }
        zzabc.zzb(zzaauVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zzb(zzdnl zzdnlVar, zzdmw zzdmwVar, Object obj) throws Exception {
        View zzcidVar;
        zzvs zzb = zzdnu.zzb(this.context, zzdmwVar.zzhji);
        final zzbeb zza = this.zzggk.zza(zzb, zzdmwVar, zzdnlVar.zzhks.zzess);
        zza.zzbb(zzdmwVar.zzdwz);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczh)).booleanValue() && zzdmwVar.zzhjx) {
            zzcidVar = zzbnj.zza(this.context, zza.getView(), zzdmwVar);
        } else {
            zzcidVar = new zzcid(this.context, zza.getView(), this.zzgtp.apply(zzdmwVar));
        }
        zzbmr zzbmrVar = this.zzgto;
        zzboj zzbojVar = new zzboj(zzdnlVar, zzdmwVar, null);
        zza.getClass();
        final zzbly zza2 = zzbmrVar.zza(zzbojVar, new zzbmc(zzcidVar, zza, zzcsi.zzm(zza), zzdnu.zzh(zzb)));
        zza2.zzahe().zza(zza, false);
        zzbsd zzagq = zza2.zzagq();
        zzbse zzbseVar = new zzbse(zza) { // from class: com.google.android.gms.internal.ads.zzcsh
            private final zzbeb zzeuk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeuk = zza;
            }

            @Override // com.google.android.gms.internal.ads.zzbse
            public final void onAdImpression() {
                zzbeb zzbebVar = this.zzeuk;
                if (zzbebVar.zzacx() != null) {
                    zzbebVar.zzacx().zzadv();
                }
            }
        };
        zzdzv zzdzvVar = zzazp.zzeih;
        zzagq.zza(zzbseVar, zzdzvVar);
        zza2.zzahe();
        zzdnd zzdndVar = zzdmwVar.zzhjg;
        zzdzw<?> zza3 = zzchs.zza(zza, zzdndVar.zzdsw, zzdndVar.zzdsy);
        if (zzdmwVar.zzdxt) {
            zza.getClass();
            zza3.addListener(zzcsk.zze(zza), this.zzfsj);
        }
        zza3.addListener(new Runnable(this, zza) { // from class: com.google.android.gms.internal.ads.zzcsj
            private final zzbeb zzggw;
            private final zzcsg zzgtn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgtn = this;
                this.zzggw = zza;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgtn.zzl(this.zzggw);
            }
        }, this.zzfsj);
        return zzdzk.zzb(zza3, new zzdvz(zza2) { // from class: com.google.android.gms.internal.ads.zzcsm
            private final zzbly zzgtr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgtr = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj2) {
                return this.zzgtr.zzaho();
            }
        }, zzdzvVar);
    }
}
