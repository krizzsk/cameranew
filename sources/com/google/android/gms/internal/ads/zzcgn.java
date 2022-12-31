package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgn implements zzdzl<zzbeb> {
    private final /* synthetic */ String zzerp;
    private final /* synthetic */ zzaif zzgja;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcgn(zzcgk zzcgkVar, String str, zzaif zzaifVar) {
        this.zzerp = str;
        this.zzgja = zzaifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzbeb zzbebVar) {
        zzbebVar.zzb(this.zzerp, this.zzgja);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
    }
}
