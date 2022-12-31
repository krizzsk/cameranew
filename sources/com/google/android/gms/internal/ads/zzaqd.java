package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaqd implements com.google.android.gms.ads.internal.overlay.zzq {
    private final /* synthetic */ zzaqa zzdpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqd(zzaqa zzaqaVar) {
        this.zzdpb = zzaqaVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onPause() {
        zzazk.zzdy("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onResume() {
        zzazk.zzdy("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onUserLeaveHint() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zza(com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        MediationInterstitialListener mediationInterstitialListener;
        zzazk.zzdy("AdMobCustomTabsAdapter overlay is closed.");
        mediationInterstitialListener = this.zzdpb.zzdoz;
        mediationInterstitialListener.onAdClosed(this.zzdpb);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zzvo() {
        MediationInterstitialListener mediationInterstitialListener;
        zzazk.zzdy("Opening AdMobCustomTabsAdapter overlay.");
        mediationInterstitialListener = this.zzdpb.zzdoz;
        mediationInterstitialListener.onAdOpened(this.zzdpb);
    }
}
