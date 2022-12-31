package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbok implements zzdzl<zzbnt> {
    private final /* synthetic */ zzdzl zzfwr;
    private final /* synthetic */ zzboe zzfws;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbok(zzboe zzboeVar, zzdzl zzdzlVar) {
        this.zzfws = zzboeVar;
        this.zzfwr = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzbnt zzbntVar) {
        this.zzfws.zzaku();
        this.zzfwr.onSuccess(zzbntVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        this.zzfws.zzaku();
        this.zzfwr.zzb(th);
    }
}
