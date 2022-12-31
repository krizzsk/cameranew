package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcgu implements com.google.android.gms.ads.internal.overlay.zzv {
    private final zzbsm zzgjh;

    private zzcgu(zzbsm zzbsmVar) {
        this.zzgjh = zzbsmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.ads.internal.overlay.zzv zza(zzbsm zzbsmVar) {
        return new zzcgu(zzbsmVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzv
    public final void zzwg() {
        this.zzgjh.onAdLeftApplication();
    }
}
