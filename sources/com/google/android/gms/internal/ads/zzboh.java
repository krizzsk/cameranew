package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzboh implements zzdzl<zzbnz> {
    private final /* synthetic */ zzdzl zzfwr;
    private final /* synthetic */ zzboe zzfws;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboh(zzboe zzboeVar, zzdzl zzdzlVar) {
        this.zzfws = zzboeVar;
        this.zzfwr = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzbnz zzbnzVar) {
        this.zzfws.zza(zzbnzVar.zzfwk, this.zzfwr);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        this.zzfwr.zzb(th);
        this.zzfws.zzaku();
    }
}
