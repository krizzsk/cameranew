package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.ValueAnimator;
/* loaded from: assets/audience_network.dex */
public class QC implements Animator.AnimatorListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0911Hz A02;

    public QC(C0911Hz c0911Hz, int i2, int i3) {
        this.A02 = c0911Hz;
        this.A01 = i2;
        this.A00 = i3;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        this.A02.A07(this.A00, this.A01, false);
        valueAnimator = this.A02.A00;
        if (valueAnimator != null) {
            valueAnimator2 = this.A02.A00;
            valueAnimator2.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i2;
        Q5 q5;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        C0911Hz c0911Hz = this.A02;
        int i3 = this.A01;
        i2 = c0911Hz.A04;
        if (i3 == i2) {
            q5 = Q5.A03;
        } else {
            q5 = Q5.A05;
        }
        c0911Hz.A01 = q5;
        valueAnimator = this.A02.A00;
        if (valueAnimator != null) {
            valueAnimator2 = this.A02.A00;
            valueAnimator2.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
