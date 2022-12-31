package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class QE implements Animator.AnimatorListener {
    public final /* synthetic */ C0905Ht A00;

    public QE(C0905Ht c0905Ht) {
        this.A00 = c0905Ht;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A09(false);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        View view;
        this.A00.A01 = Q5.A05;
        view = this.A00.A05;
        M5.A0H(view);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
