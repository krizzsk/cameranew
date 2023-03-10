package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdmh implements zzdzl<zzchb> {
    private final /* synthetic */ zzcze zzgzg;
    private final /* synthetic */ zzdmi zzhim;
    final /* synthetic */ zzdmc zzhin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmh(zzdmc zzdmcVar, zzcze zzczeVar, zzdmi zzdmiVar) {
        this.zzhin = zzdmcVar;
        this.zzgzg = zzczeVar;
        this.zzhim = zzdmiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzchb zzchbVar) {
        zzdlh zzdlhVar;
        Executor executor;
        zzdlh zzdlhVar2;
        zzdlh zzdlhVar3;
        zzchb zzchbVar2 = zzchbVar;
        synchronized (this.zzhin) {
            zzbve zzakt = zzchbVar2.zzakt();
            zzdlhVar = this.zzhin.zzhii;
            zzakt.zza(zzdlhVar);
            this.zzgzg.onSuccess(zzchbVar2);
            executor = this.zzhin.zzfsj;
            zzdlhVar2 = this.zzhin.zzhii;
            zzdlhVar2.getClass();
            executor.execute(zzdmg.zzb(zzdlhVar2));
            zzdlhVar3 = this.zzhin.zzhii;
            zzdlhVar3.onAdMetadataChanged();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzdkn zzdknVar;
        final zzvg zze;
        zzdlh zzdlhVar;
        zzchh zze2;
        Executor executor;
        zzdknVar = this.zzhin.zzhfm;
        zzchi zzchiVar = (zzchi) zzdknVar.zzaun();
        if (zzchiVar == null) {
            zze = zzdok.zza(th, (zzcrq) null);
        } else {
            zze = zzchiVar.zzagj().zze(th);
        }
        synchronized (this.zzhin) {
            if (zzchiVar != null) {
                zzchiVar.zzagk().zzc(zze);
                executor = this.zzhin.zzfsj;
                executor.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdmj
                    private final zzvg zzgzk;
                    private final zzdmh zzhio;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhio = this;
                        this.zzgzk = zze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdlh zzdlhVar2;
                        zzdmh zzdmhVar = this.zzhio;
                        zzvg zzvgVar = this.zzgzk;
                        zzdlhVar2 = zzdmhVar.zzhin.zzhii;
                        zzdlhVar2.zzc(zzvgVar);
                    }
                });
            } else {
                zzdlhVar = this.zzhin.zzhii;
                zzdlhVar.zzc(zze);
                zze2 = this.zzhin.zze(this.zzhim);
                zze2.zzaid().zzagj().zzalc().zzalx();
            }
            zzdod.zza(zze.errorCode, th, "RewardedAdLoader.onFailure");
            this.zzgzg.zzasi();
        }
    }
}
