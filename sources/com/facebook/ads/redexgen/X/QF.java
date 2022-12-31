package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class QF implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View A00;
    public final /* synthetic */ C0905Ht A01;

    public QF(C0905Ht c0905Ht, View view) {
        this.A01 = c0905Ht;
        this.A00 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.A00.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
