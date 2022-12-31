package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* loaded from: classes2.dex */
public final class l extends h<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f4464l = {533, 567, 850, 750};
    private static final int[] m = {1267, 1000, 333, 0};
    private static final Property<l, Float> n = new b(Float.class, "animationFraction");

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f4465d;

    /* renamed from: e  reason: collision with root package name */
    private final Interpolator[] f4466e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f4467f;

    /* renamed from: g  reason: collision with root package name */
    private int f4468g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4469h;

    /* renamed from: i  reason: collision with root package name */
    private float f4470i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4471j;

    /* renamed from: k  reason: collision with root package name */
    Animatable2Compat.AnimationCallback f4472k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (l.this.f4471j) {
                l.this.f4465d.setRepeatCount(-1);
                l lVar = l.this;
                lVar.f4472k.onAnimationEnd(lVar.a);
                l.this.f4471j = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f4468g = (lVar.f4468g + 1) % l.this.f4467f.c.length;
            l.this.f4469h = true;
        }
    }

    /* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    /* loaded from: classes2.dex */
    static class b extends Property<l, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(l lVar) {
            return Float.valueOf(lVar.q());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(l lVar, Float f2) {
            lVar.u(f2.floatValue());
        }
    }

    public l(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f4468g = 0;
        this.f4472k = null;
        this.f4467f = linearProgressIndicatorSpec;
        this.f4466e = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q() {
        return this.f4470i;
    }

    private void r() {
        if (this.f4465d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, n, 0.0f, 1.0f);
            this.f4465d = ofFloat;
            ofFloat.setDuration(1800L);
            this.f4465d.setInterpolator(null);
            this.f4465d.setRepeatCount(-1);
            this.f4465d.addListener(new a());
        }
    }

    private void s() {
        if (this.f4469h) {
            Arrays.fill(this.c, com.google.android.material.b.a.a(this.f4467f.c[this.f4468g], this.a.getAlpha()));
            this.f4469h = false;
        }
    }

    private void v(int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.b[i3] = Math.max(0.0f, Math.min(1.0f, this.f4466e[i3].getInterpolation(b(i2, m[i3], f4464l[i3]))));
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.f4465d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        t();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f4472k = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.h
    public void f() {
        if (this.a.isVisible()) {
            this.f4471j = true;
            this.f4465d.setRepeatCount(0);
            return;
        }
        a();
    }

    @Override // com.google.android.material.progressindicator.h
    public void g() {
        r();
        t();
        this.f4465d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
        this.f4472k = null;
    }

    @VisibleForTesting
    void t() {
        this.f4468g = 0;
        int a2 = com.google.android.material.b.a.a(this.f4467f.c[0], this.a.getAlpha());
        int[] iArr = this.c;
        iArr[0] = a2;
        iArr[1] = a2;
    }

    @VisibleForTesting
    void u(float f2) {
        this.f4470i = f2;
        v((int) (f2 * 1800.0f));
        s();
        this.a.invalidateSelf();
    }
}
