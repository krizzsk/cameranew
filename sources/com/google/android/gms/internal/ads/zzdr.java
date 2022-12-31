package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdr implements zzdug {
    private final /* synthetic */ zzdsy zzvm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdr(zzdsy zzdsyVar) {
        this.zzvm = zzdsyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdug
    public final void zza(int i2, long j2) {
        this.zzvm.zzh(i2, System.currentTimeMillis() - j2);
    }

    @Override // com.google.android.gms.internal.ads.zzdug
    public final void zza(int i2, long j2, String str) {
        this.zzvm.zzb(i2, System.currentTimeMillis() - j2, str);
    }
}
