package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvi extends zzxa {
    private final AdListener zzchm;

    public zzvi(AdListener adListener) {
        this.zzchm = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzchm;
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdClicked() {
        this.zzchm.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdClosed() {
        this.zzchm.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdFailedToLoad(int i2) {
        this.zzchm.onAdFailedToLoad(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdImpression() {
        this.zzchm.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdLeftApplication() {
        this.zzchm.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdLoaded() {
        this.zzchm.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdOpened() {
        this.zzchm.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void zzd(zzvg zzvgVar) {
        this.zzchm.onAdFailedToLoad(zzvgVar.zzqc());
    }
}
