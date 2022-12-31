package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.RequiresApi;
@RequiresApi(16)
/* loaded from: assets/audience_network.dex */
public class F1 extends C1481br {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final int A03(View view) {
        return view.getImportantForAccessibility();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final int A05(View view) {
        return view.getMinimumHeight();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final int A06(View view) {
        return view.getMinimumWidth();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final void A0A(View view) {
        view.postInvalidateOnAnimation();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public void A0C(View view, int i2) {
        if (i2 == 4) {
            i2 = 2;
        }
        view.setImportantForAccessibility(i2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final void A0D(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final void A0G(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final void A0H(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final boolean A0I(View view) {
        return view.hasTransientState();
    }
}
