package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
/* renamed from: com.facebook.ads.redexgen.X.Ds  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0804Ds extends C1437b7 {
    public PZ A00;

    public final void A04(NativeAdLayout nativeAdLayout, XT xt, NativeAd nativeAd, C0955Jt c0955Jt) {
        OA oa = new OA(xt);
        MediaView mediaView = new MediaView(xt);
        AdOptionsView adOptionsView = new AdOptionsView(xt, nativeAd, nativeAdLayout);
        c0955Jt.A09(adOptionsView, 28);
        this.A00 = new C1108Px(xt, nativeAd, c0955Jt, C1198Tj.A0J(nativeAd.getInternalNativeAd()).A15(), oa, mediaView, adOptionsView);
        M5.A0M(nativeAdLayout, c0955Jt.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, oa, this.A00.getViewsForInteraction());
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
