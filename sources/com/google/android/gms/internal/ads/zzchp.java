package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzchp implements com.google.android.gms.ads.internal.zzm {
    private final /* synthetic */ zzchq zzgjv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchp(zzchq zzchqVar) {
        this.zzgjv = zzchqVar;
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final void zzkn() {
        zzbts zzbtsVar;
        zzbtsVar = this.zzgjv.zzgjw;
        zzbtsVar.onPause();
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final void zzko() {
        zzbts zzbtsVar;
        zzbtsVar = this.zzgjv.zzgjw;
        zzbtsVar.onResume();
    }
}
