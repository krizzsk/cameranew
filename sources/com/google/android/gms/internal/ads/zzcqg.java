package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcqg implements zzdrp {
    private final zzcqb zzgrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcqg(zzcqb zzcqbVar) {
        this.zzgrc = zzcqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final void zza(zzdrk zzdrkVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final void zza(zzdrk zzdrkVar, String str, Throwable th) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxy)).booleanValue() && zzdrk.RENDERER == zzdrkVar && this.zzgrc.zzaru() != 0) {
            this.zzgrc.zzer(com.google.android.gms.ads.internal.zzr.zzky().a() - this.zzgrc.zzaru());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final void zzb(zzdrk zzdrkVar, String str) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxy)).booleanValue() && zzdrk.RENDERER == zzdrkVar) {
            this.zzgrc.zzfe(com.google.android.gms.ads.internal.zzr.zzky().a());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final void zzc(zzdrk zzdrkVar, String str) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxy)).booleanValue() && zzdrk.RENDERER == zzdrkVar && this.zzgrc.zzaru() != 0) {
            this.zzgrc.zzer(com.google.android.gms.ads.internal.zzr.zzky().a() - this.zzgrc.zzaru());
        }
    }
}
