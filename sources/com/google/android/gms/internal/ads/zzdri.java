package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdri implements zzdzl<O> {
    private final /* synthetic */ zzdqw zzhqf;
    private final /* synthetic */ zzdrb zzhqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdri(zzdrb zzdrbVar, zzdqw zzdqwVar) {
        this.zzhqg = zzdrbVar;
        this.zzhqf = zzdqwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void onSuccess(O o) {
        zzdqv.zzc(this.zzhqg.zzhpy).zzc(this.zzhqf);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzdqv.zzc(this.zzhqg.zzhpy).zza(this.zzhqf, th);
    }
}
