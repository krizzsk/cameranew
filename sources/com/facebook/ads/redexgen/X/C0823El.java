package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeBannerAd;
/* renamed from: com.facebook.ads.redexgen.X.El  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0823El extends C1437b7 {
    public PZ A00;

    public final void A04(XT xt, NativeBannerAd nativeBannerAd, C0955Jt c0955Jt, NativeAdLayout nativeAdLayout) {
        MediaView adIconView = new MediaView(nativeAdLayout.getContext());
        AdOptionsView adOptionsView = new AdOptionsView(nativeAdLayout.getContext(), nativeBannerAd, nativeAdLayout);
        c0955Jt.A09(adOptionsView, 20);
        this.A00 = new C1110Pz(xt, nativeBannerAd, c0955Jt, C1198Tj.A0J(nativeBannerAd.getInternalNativeAd()).A15(), adIconView, adOptionsView);
        M5.A0M(nativeAdLayout, c0955Jt.A00());
        nativeBannerAd.registerViewForInteraction(nativeAdLayout, adIconView, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
