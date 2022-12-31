package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.Pu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1105Pu extends AnimatorListenerAdapter {
    public final /* synthetic */ C06547d A00;

    public C1105Pu(C06547d c06547d) {
        this.A00 = c06547d;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Handler handler;
        handler = this.A00.A00.A04;
        handler.postDelayed(new JZ(this), 2000L);
    }
}
