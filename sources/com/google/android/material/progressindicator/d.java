package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircularIndeterminateAnimatorDelegate.java */
/* loaded from: classes2.dex */
public final class d extends h<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f4437l = {0, 1350, 2700, 4050};
    private static final int[] m = {667, 2017, 3367, 4717};
    private static final int[] n = {1000, 2350, 3700, 5050};
    private static final Property<d, Float> o = new c(Float.class, "animationFraction");
    private static final Property<d, Float> p = new C0177d(Float.class, "completeEndFraction");

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f4438d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f4439e;

    /* renamed from: f  reason: collision with root package name */
    private final FastOutSlowInInterpolator f4440f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f4441g;

    /* renamed from: h  reason: collision with root package name */
    private int f4442h;

    /* renamed from: i  reason: collision with root package name */
    private float f4443i;

    /* renamed from: j  reason: collision with root package name */
    private float f4444j;

    /* renamed from: k  reason: collision with root package name */
    Animatable2Compat.AnimationCallback f4445k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f4442h = (dVar.f4442h + 4) % d.this.f4441g.c.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            dVar.f4445k.onAnimationEnd(dVar.a);
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* loaded from: classes2.dex */
    static class c extends Property<d, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(d dVar, Float f2) {
            dVar.t(f2.floatValue());
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* renamed from: com.google.android.material.progressindicator.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0177d extends Property<d, Float> {
        C0177d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(d dVar, Float f2) {
            dVar.u(f2.floatValue());
        }
    }

    public d(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f4442h = 0;
        this.f4445k = null;
        this.f4441g = circularProgressIndicatorSpec;
        this.f4440f = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f4443i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f4444j;
    }

    private void q() {
        if (this.f4438d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            this.f4438d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f4438d.setInterpolator(null);
            this.f4438d.setRepeatCount(-1);
            this.f4438d.addListener(new a());
        }
        if (this.f4439e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, p, 0.0f, 1.0f);
            this.f4439e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f4439e.setInterpolator(this.f4440f);
            this.f4439e.addListener(new b());
        }
    }

    private void r(int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            float b2 = b(i2, n[i3], 333);
            if (b2 >= 0.0f && b2 <= 1.0f) {
                int i4 = i3 + this.f4442h;
                int[] iArr = this.f4441g.c;
                int length = i4 % iArr.length;
                int a2 = com.google.android.material.b.a.a(iArr[length], this.a.getAlpha());
                int a3 = com.google.android.material.b.a.a(this.f4441g.c[(length + 1) % iArr.length], this.a.getAlpha());
                this.c[0] = ArgbEvaluatorCompat.getInstance().evaluate(this.f4440f.getInterpolation(b2), Integer.valueOf(a2), Integer.valueOf(a3)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f2) {
        this.f4444j = f2;
    }

    private void v(int i2) {
        float[] fArr = this.b;
        float f2 = this.f4443i;
        fArr[0] = (f2 * 1520.0f) - 20.0f;
        fArr[1] = f2 * 1520.0f;
        for (int i3 = 0; i3 < 4; i3++) {
            float b2 = b(i2, f4437l[i3], 667);
            float[] fArr2 = this.b;
            fArr2[1] = fArr2[1] + (this.f4440f.getInterpolation(b2) * 250.0f);
            float b3 = b(i2, m[i3], 667);
            float[] fArr3 = this.b;
            fArr3[0] = fArr3[0] + (this.f4440f.getInterpolation(b3) * 250.0f);
        }
        float[] fArr4 = this.b;
        fArr4[0] = fArr4[0] + ((fArr4[1] - fArr4[0]) * this.f4444j);
        fArr4[0] = fArr4[0] / 360.0f;
        fArr4[1] = fArr4[1] / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    void a() {
        ObjectAnimator objectAnimator = this.f4438d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f4445k = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.h
    void f() {
        if (this.f4439e.isRunning()) {
            return;
        }
        if (this.a.isVisible()) {
            this.f4439e.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    void g() {
        q();
        s();
        this.f4438d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
        this.f4445k = null;
    }

    @VisibleForTesting
    void s() {
        this.f4442h = 0;
        this.c[0] = com.google.android.material.b.a.a(this.f4441g.c[0], this.a.getAlpha());
        this.f4444j = 0.0f;
    }

    @VisibleForTesting
    void t(float f2) {
        this.f4443i = f2;
        int i2 = (int) (f2 * 5400.0f);
        v(i2);
        r(i2);
        this.a.invalidateSelf();
    }
}
