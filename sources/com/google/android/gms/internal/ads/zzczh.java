package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzczh implements zzdzl<zzbnt> {
    private final /* synthetic */ zzcze zzgzg;
    private final /* synthetic */ zzcau zzgzh;
    final /* synthetic */ zzczg zzgzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzczh(zzczg zzczgVar, zzcze zzczeVar, zzcau zzcauVar) {
        this.zzgzi = zzczgVar;
        this.zzgzg = zzczeVar;
        this.zzgzh = zzcauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzbnt zzbntVar) {
        zzcza zzczaVar;
        zzbgc zzbgcVar;
        zzbnt zzbntVar2 = zzbntVar;
        synchronized (this.zzgzi) {
            zzbve zzakt = zzbntVar2.zzakt();
            zzczaVar = this.zzgzi.zzgze;
            zzakt.zza(zzczaVar.zzasp());
            this.zzgzg.onSuccess(zzbntVar2);
            zzbgcVar = this.zzgzi.zzguy;
            zzbgcVar.zzafa().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzczk
                private final zzczh zzgzj;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgzj = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcza zzczaVar2;
                    zzczaVar2 = this.zzgzj.zzgzi.zzgze;
                    zzczaVar2.zzasq().onAdLoaded();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzbgc zzbgcVar;
        final zzvg zze = this.zzgzh.zzagj().zze(th);
        this.zzgzh.zzagk().zzc(zze);
        zzbgcVar = this.zzgzi.zzguy;
        zzbgcVar.zzafa().execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzczj
            private final zzczh zzgzj;
            private final zzvg zzgzk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgzj = this;
                this.zzgzk = zze;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcza zzczaVar;
                zzczh zzczhVar = this.zzgzj;
                zzvg zzvgVar = this.zzgzk;
                zzczaVar = zzczhVar.zzgzi.zzgze;
                zzczaVar.zzasr().zzc(zzvgVar);
            }
        });
        zzdod.zza(zze.errorCode, th, "NativeAdLoader.onFailure");
        this.zzgzg.zzasi();
    }
}
