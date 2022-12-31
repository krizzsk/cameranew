package com.facebook.ads.redexgen.X;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
/* renamed from: com.facebook.ads.redexgen.X.Rq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1153Rq extends AbstractRunnableC0981Kv {
    public final /* synthetic */ P4 A00;
    public final /* synthetic */ P5 A01;

    public C1153Rq(P5 p5, P4 p4) {
        this.A01 = p5;
        this.A00 = p4;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new C1154Rr(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
