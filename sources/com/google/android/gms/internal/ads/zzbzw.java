package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbzw implements com.google.android.gms.ads.internal.overlay.zzq {
    private final zzbtj zzgbl;
    private final zzbxw zzgbm;

    public zzbzw(zzbtj zzbtjVar, zzbxw zzbxwVar) {
        this.zzgbl = zzbtjVar;
        this.zzgbm = zzbxwVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onPause() {
        this.zzgbl.onPause();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onResume() {
        this.zzgbl.onResume();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onUserLeaveHint() {
        this.zzgbl.onUserLeaveHint();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zza(com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        this.zzgbl.zza(zznVar);
        this.zzgbm.onHide();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zzvo() {
        this.zzgbl.zzvo();
        this.zzgbm.zzamp();
    }
}
