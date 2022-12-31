package com.facebook.ads.redexgen.X;

import android.animation.Animator;
/* loaded from: assets/audience_network.dex */
public class QD implements Animator.AnimatorListener {
    public final /* synthetic */ C0905Ht A00;

    public QD(C0905Ht c0905Ht) {
        this.A00 = c0905Ht;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A08(false);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A00 = null;
        this.A00.A01 = Q5.A03;
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
