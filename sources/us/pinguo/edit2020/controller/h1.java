package us.pinguo.edit2020.controller;

import android.animation.ValueAnimator;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class h1 implements ValueAnimator.AnimatorUpdateListener {
    public static final /* synthetic */ h1 a = new h1();

    private /* synthetic */ h1() {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        EliminationController.a(valueAnimator);
    }
}
