package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Pv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1106Pv extends AnimatorListenerAdapter {
    public final /* synthetic */ JX A00;

    public C1106Pv(JX jx) {
        this.A00 = jx;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        View view;
        view = this.A00.A00;
        view.setVisibility(8);
    }
}
