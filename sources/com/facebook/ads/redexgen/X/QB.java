package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
/* loaded from: assets/audience_network.dex */
public class QB extends AnimatorListenerAdapter {
    public final /* synthetic */ I4 A00;

    public QB(I4 i4) {
        this.A00 = i4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        boolean z;
        View view;
        ViewPropertyAnimator viewPropertyAnimator;
        ViewPropertyAnimator viewPropertyAnimator2;
        View view2;
        z = this.A00.A04;
        if (z) {
            view2 = this.A00.A03;
            M5.A0L(view2);
        }
        view = this.A00.A03;
        view.setAlpha(1.0f);
        this.A00.A01 = Q5.A03;
        viewPropertyAnimator = this.A00.A00;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator2 = this.A00.A00;
            viewPropertyAnimator2.setListener(null);
            this.A00.A00 = null;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        boolean z;
        ViewPropertyAnimator viewPropertyAnimator;
        ViewPropertyAnimator viewPropertyAnimator2;
        View view;
        z = this.A00.A04;
        if (z) {
            view = this.A00.A03;
            M5.A0H(view);
        }
        this.A00.A01 = Q5.A05;
        viewPropertyAnimator = this.A00.A00;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator2 = this.A00.A00;
            viewPropertyAnimator2.setListener(null);
            this.A00.A00 = null;
        }
    }
}
