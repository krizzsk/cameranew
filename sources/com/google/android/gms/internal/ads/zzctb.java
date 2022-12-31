package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzctb implements zzdzl<zzblv> {
    private final /* synthetic */ zzcta zzgue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzctb(zzcta zzctaVar) {
        this.zzgue = zzctaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzblv zzblvVar) {
        zzblvVar.zzakb();
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzbmr zzbmrVar;
        zzbrp zzbrpVar;
        zzbmrVar = this.zzgue.zzguc;
        zzvg zze = zzbmrVar.zzagj().zze(th);
        zzbrpVar = this.zzgue.zzgas;
        zzbrpVar.zzc(zze);
        zzdod.zza(zze.errorCode, th, "DelayedBannerAd.onFailure");
    }
}
