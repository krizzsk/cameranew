package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgp implements zzdzl<zzbeb> {
    private final /* synthetic */ zzdmw zzgjb;
    private final /* synthetic */ zzdnb zzgjc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcgp(zzcgk zzcgkVar, zzdmw zzdmwVar, zzdnb zzdnbVar) {
        this.zzgjb = zzdmwVar;
        this.zzgjc = zzdnbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzbeb zzbebVar) {
        zzbebVar.zza(this.zzgjb, this.zzgjc);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
    }
}
