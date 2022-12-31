package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcoa implements zzdzl<zzdnl> {
    private final /* synthetic */ zzcny zzgpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcoa(zzcny zzcnyVar) {
        this.zzgpf = zzcnyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzdnl zzdnlVar) {
        zzbtz zzbtzVar;
        zzbtzVar = this.zzgpf.zzgpe;
        zzbtzVar.zzb(zzdnlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
    }
}
