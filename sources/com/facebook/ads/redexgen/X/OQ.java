package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class OQ implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SK A00;

    public OQ(SK sk) {
        this.A00 = sk;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.A00.A06;
        view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view2 = this.A00.A06;
        view2.requestLayout();
    }
}
