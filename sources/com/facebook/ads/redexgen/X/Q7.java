package com.facebook.ads.redexgen.X;

import android.animation.Animator;
/* loaded from: assets/audience_network.dex */
public class Q7 implements Animator.AnimatorListener {
    public final /* synthetic */ I5 A00;

    public Q7(I5 i5) {
        this.A00 = i5;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A07(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A01 = null;
        this.A00.A02 = Q5.A03;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
