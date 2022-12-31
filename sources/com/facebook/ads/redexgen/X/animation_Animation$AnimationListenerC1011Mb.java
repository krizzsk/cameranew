package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.animation.Animation;
/* renamed from: com.facebook.ads.redexgen.X.Mb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class animation.Animation$AnimationListenerC1011Mb implements Animation.AnimationListener {
    public final /* synthetic */ AnonymousClass52 A00;
    public final /* synthetic */ T4 A01;
    public final /* synthetic */ T4 A02;

    public animation.Animation$AnimationListenerC1011Mb(T4 t4, T4 t42, AnonymousClass52 anonymousClass52) {
        this.A01 = t4;
        this.A02 = t42;
        this.A00 = anonymousClass52;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.A01.A04 = false;
        M5.A0H(this.A02);
        new Handler().postDelayed(new T7(this), 200L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
