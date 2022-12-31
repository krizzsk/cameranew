package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzalo implements zzbae<zzalx> {
    private final /* synthetic */ zzalm zzdkf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalo(zzalm zzalmVar) {
        this.zzdkf = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbae
    public final /* synthetic */ void zzg(zzalx zzalxVar) {
        zzalq zzalqVar;
        com.google.android.gms.ads.internal.util.zzd.zzeb("Releasing engine reference.");
        zzalqVar = this.zzdkf.zzdkd;
        zzalqVar.zzun();
    }
}
