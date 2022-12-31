package us.pinguo.inspire.util;

import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import java.util.Objects;
/* compiled from: FakeProgress.kt */
/* loaded from: classes9.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {
    private final int a;
    private final long b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final long f11262d;

    /* renamed from: e  reason: collision with root package name */
    private final n f11263e;

    /* renamed from: f  reason: collision with root package name */
    private ValueAnimator f11264f;

    public m(int i2, long j2, int i3, long j3, n listener) {
        kotlin.jvm.internal.s.h(listener, "listener");
        this.a = i2;
        this.b = j2;
        this.c = i3;
        this.f11262d = j3;
        this.f11263e = listener;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i2 - i3);
        kotlin.jvm.internal.s.g(ofInt, "ofInt(0, max - waitArea)");
        this.f11264f = ofInt;
        ofInt.setDuration(j2);
        this.f11264f.setInterpolator(new DecelerateInterpolator());
        this.f11264f.addUpdateListener(this);
    }

    public final void a() {
        this.f11264f.cancel();
        Object animatedValue = this.f11264f.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ValueAnimator ofInt = ValueAnimator.ofInt(((Integer) animatedValue).intValue(), this.a);
        kotlin.jvm.internal.s.g(ofInt, "ofInt(animator.animatedValue as Int, max)");
        this.f11264f = ofInt;
        ofInt.addUpdateListener(this);
        this.f11264f.setDuration(this.f11262d);
        this.f11264f.start();
    }

    public final void b() {
        this.f11264f.start();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        kotlin.jvm.internal.s.h(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this.f11263e.a(((Integer) animatedValue).intValue(), this.a);
    }
}
