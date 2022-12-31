package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdig implements zzdzl<AppOpenAd> {
    private final /* synthetic */ zzcze zzgzg;
    private final /* synthetic */ zzdii zzhfo;
    final /* synthetic */ zzdif zzhfp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdig(zzdif zzdifVar, zzcze zzczeVar, zzdii zzdiiVar) {
        this.zzhfp = zzdifVar;
        this.zzgzg = zzczeVar;
        this.zzhfo = zzdiiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(Object obj) {
        zzdil zzdilVar;
        zzbnt zzbntVar = (zzbnt) obj;
        synchronized (this.zzhfp) {
            this.zzhfp.zzhfn = null;
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczt)).booleanValue()) {
                zzbve zzakt = zzbntVar.zzakt();
                zzdilVar = this.zzhfp.zzhfl;
                zzakt.zza(zzdilVar);
            }
            this.zzgzg.onSuccess(zzbntVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzdkn zzdknVar;
        final zzvg zze;
        zzdil zzdilVar;
        zzbqy zzb;
        Executor executor;
        zzdknVar = this.zzhfp.zzhfm;
        zzbld zzbldVar = (zzbld) zzdknVar.zzaun();
        if (zzbldVar == null) {
            zze = zzdok.zza(th, (zzcrq) null);
        } else {
            zze = zzbldVar.zzagj().zze(th);
        }
        synchronized (this.zzhfp) {
            this.zzhfp.zzhfn = null;
            if (zzbldVar != null) {
                zzbldVar.zzagk().zzc(zze);
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczt)).booleanValue()) {
                    executor = this.zzhfp.zzfsj;
                    executor.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdij
                        private final zzvg zzgzk;
                        private final zzdig zzhfq;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzhfq = this;
                            this.zzgzk = zze;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdil zzdilVar2;
                            zzdig zzdigVar = this.zzhfq;
                            zzvg zzvgVar = this.zzgzk;
                            zzdilVar2 = zzdigVar.zzhfp.zzhfl;
                            zzdilVar2.zzc(zzvgVar);
                        }
                    });
                }
            } else {
                zzdilVar = this.zzhfp.zzhfl;
                zzdilVar.zzc(zze);
                zzb = this.zzhfp.zzb(this.zzhfo);
                ((zzbld) zzb.zzagm()).zzagj().zzalc().zzalx();
            }
            zzdod.zza(zze.errorCode, th, "AppOpenAdLoader.onFailure");
            this.zzgzg.zzasi();
        }
    }
}
