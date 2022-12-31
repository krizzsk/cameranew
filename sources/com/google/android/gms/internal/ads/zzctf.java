package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzctf implements zzcrj<zzbyy> {
    private final Context context;
    private final zzazn zzboz;
    private final Executor zzfsj;
    private final zzdnp zzfwy;
    private final zzchq zzggk;
    private final zzbzy zzgtz;

    public zzctf(Context context, zzazn zzaznVar, zzdnp zzdnpVar, Executor executor, zzbzy zzbzyVar, zzchq zzchqVar) {
        this.context = context;
        this.zzfwy = zzdnpVar;
        this.zzgtz = zzbzyVar;
        this.zzfsj = executor;
        this.zzboz = zzaznVar;
        this.zzggk = zzchqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final boolean zza(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        zzdnd zzdndVar = zzdmwVar.zzhjg;
        return (zzdndVar == null || zzdndVar.zzdsy == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final zzdzw<zzbyy> zzb(final zzdnl zzdnlVar, final zzdmw zzdmwVar) {
        final zzcig zzcigVar = new zzcig();
        zzdzw<zzbyy> zzb = zzdzk.zzb(zzdzk.zzag(null), new zzdyu(this, zzdmwVar, zzdnlVar, zzcigVar) { // from class: com.google.android.gms.internal.ads.zzcti
            private final zzdmw zzgtb;
            private final zzdnl zzgtc;
            private final zzcig zzgtd;
            private final zzctf zzguj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguj = this;
                this.zzgtb = zzdmwVar;
                this.zzgtc = zzdnlVar;
                this.zzgtd = zzcigVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzguj.zzb(this.zzgtb, this.zzgtc, this.zzgtd, obj);
            }
        }, this.zzfsj);
        zzb.addListener(zzcth.zza(zzcigVar), this.zzfsj);
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zzb(final zzdmw zzdmwVar, zzdnl zzdnlVar, zzcig zzcigVar, Object obj) throws Exception {
        final zzbeb zza = this.zzggk.zza(this.zzfwy.zzbpo, zzdmwVar, zzdnlVar.zzhks.zzess);
        zza.zzbb(zzdmwVar.zzdwz);
        zzcigVar.zzc(this.context, zza.getView());
        zzbaa zzbaaVar = new zzbaa();
        final zzbza zza2 = this.zzgtz.zza(new zzboj(zzdnlVar, zzdmwVar, null), new zzbyz(new zzctl(this.context, this.zzboz, zzbaaVar, zzdmwVar, zza), zza));
        zzbaaVar.set(zza2);
        zza2.zzagq().zza(new zzbse(zza) { // from class: com.google.android.gms.internal.ads.zzctk
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
        }, zzazp.zzeih);
        zza2.zzahe().zza(zza, true);
        zza2.zzahe();
        zzdnd zzdndVar = zzdmwVar.zzhjg;
        return zzdzk.zzb(zzchs.zza(zza, zzdndVar.zzdsw, zzdndVar.zzdsy), new zzdvz(this, zza, zzdmwVar, zza2) { // from class: com.google.android.gms.internal.ads.zzctj
            private final zzdmw zzfva;
            private final zzbeb zzggw;
            private final zzctf zzguj;
            private final zzbza zzguk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguj = this;
                this.zzggw = zza;
                this.zzfva = zzdmwVar;
                this.zzguk = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj2) {
                zzbeb zzbebVar = this.zzggw;
                zzdmw zzdmwVar2 = this.zzfva;
                zzbza zzbzaVar = this.zzguk;
                if (zzdmwVar2.zzdxt) {
                    zzbebVar.zzadk();
                }
                zzbebVar.zzacr();
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcoz)).booleanValue()) {
                    zzbebVar.onPause();
                }
                return zzbzaVar.zzahz();
            }
        }, this.zzfsj);
    }
}
