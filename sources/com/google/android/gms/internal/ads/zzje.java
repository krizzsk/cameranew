package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzje implements zziz {
    private final /* synthetic */ zzjc zzamw;

    private zzje(zzjc zzjcVar) {
        this.zzamw = zzjcVar;
    }

    @Override // com.google.android.gms.internal.ads.zziz
    public final void zzc(int i2, long j2, long j3) {
        zzjc.zza(this.zzamw).zza(i2, j2, j3);
        zzjc.zzb(i2, j2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zziz
    public final void zzek() {
        zzjc.zzgd();
        zzjc.zza(this.zzamw, true);
    }

    @Override // com.google.android.gms.internal.ads.zziz
    public final void zzx(int i2) {
        zzjc.zza(this.zzamw).zzw(i2);
        zzjc.zzx(i2);
    }
}
