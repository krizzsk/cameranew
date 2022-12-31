package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcsi implements zzbnu {
    private final zzbeb zzeuk;

    private zzcsi(zzbeb zzbebVar) {
        this.zzeuk = zzbebVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbnu zzm(zzbeb zzbebVar) {
        return new zzcsi(zzbebVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbnu
    public final zzzc getVideoController() {
        return this.zzeuk.zzabc();
    }
}
