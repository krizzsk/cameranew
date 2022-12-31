package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzcia implements zzbyq {
    private final zzbeb zzeuk;

    private zzcia(zzbeb zzbebVar) {
        this.zzeuk = zzbebVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbyq zzk(zzbeb zzbebVar) {
        return new zzcia(zzbebVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzams() {
        this.zzeuk.destroy();
    }
}
