package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawableWithAnimatedVisibilityChange.java */
/* loaded from: classes2.dex */
public abstract class f extends Drawable implements Animatable2Compat {
    private static final Property<f, Float> o = new c(Float.class, "growFraction");
    final Context a;
    final com.google.android.material.progressindicator.b b;

    /* renamed from: d  reason: collision with root package name */
    private ValueAnimator f4446d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f4447e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4448f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4449g;

    /* renamed from: h  reason: collision with root package name */
    private float f4450h;

    /* renamed from: i  reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f4451i;

    /* renamed from: j  reason: collision with root package name */
    private Animatable2Compat.AnimationCallback f4452j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4453k;

    /* renamed from: l  reason: collision with root package name */
    private float f4454l;
    private int n;
    final Paint m = new Paint();
    com.google.android.material.progressindicator.a c = new com.google.android.material.progressindicator.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.super.setVisible(false, false);
            f.this.d();
        }
    }

    /* compiled from: DrawableWithAnimatedVisibilityChange.java */
    /* loaded from: classes2.dex */
    static class c extends Property<f, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.g());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(f fVar, Float f2) {
            fVar.l(f2.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(@NonNull Context context, @NonNull com.google.android.material.progressindicator.b bVar) {
        this.a = context;
        this.b = bVar;
        setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Animatable2Compat.AnimationCallback animationCallback = this.f4452j;
        if (animationCallback != null) {
            animationCallback.onAnimationEnd(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.f4451i;
        if (list == null || this.f4453k) {
            return;
        }
        for (Animatable2Compat.AnimationCallback animationCallback2 : list) {
            animationCallback2.onAnimationEnd(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Animatable2Compat.AnimationCallback animationCallback = this.f4452j;
        if (animationCallback != null) {
            animationCallback.onAnimationStart(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.f4451i;
        if (list == null || this.f4453k) {
            return;
        }
        for (Animatable2Compat.AnimationCallback animationCallback2 : list) {
            animationCallback2.onAnimationStart(this);
        }
    }

    private void f(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z = this.f4453k;
        this.f4453k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f4453k = z;
    }

    private void k() {
        if (this.f4446d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            this.f4446d = ofFloat;
            ofFloat.setDuration(500L);
            this.f4446d.setInterpolator(com.google.android.material.animation.a.b);
            n(this.f4446d);
        }
        if (this.f4447e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, o, 1.0f, 0.0f);
            this.f4447e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f4447e.setInterpolator(com.google.android.material.animation.a.b);
            m(this.f4447e);
        }
    }

    private void m(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f4447e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f4447e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    private void n(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f4446d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f4446d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.f4451i.clear();
        this.f4451i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        if (this.b.b() || this.b.a()) {
            if (!this.f4449g && !this.f4448f) {
                return this.f4454l;
            }
            return this.f4450h;
        }
        return 1.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h() {
        return o(false, false, false);
    }

    public boolean i() {
        ValueAnimator valueAnimator = this.f4447e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f4449g;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return j() || i();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f4446d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f4448f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f4454l != f2) {
            this.f4454l = f2;
            invalidateSelf();
        }
    }

    public boolean o(boolean z, boolean z2, boolean z3) {
        return p(z, z2, z3 && this.c.a(this.a.getContentResolver()) > 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p(boolean z, boolean z2, boolean z3) {
        k();
        if (isVisible() || z) {
            ValueAnimator valueAnimator = z ? this.f4446d : this.f4447e;
            if (!z3) {
                if (valueAnimator.isRunning()) {
                    valueAnimator.end();
                } else {
                    f(valueAnimator);
                }
                return super.setVisible(z, false);
            } else if (z3 && valueAnimator.isRunning()) {
                return false;
            } else {
                boolean z4 = !z || super.setVisible(z, false);
                if (!(z ? this.b.b() : this.b.a())) {
                    f(valueAnimator);
                    return z4;
                }
                if (!z2 && Build.VERSION.SDK_INT >= 19 && valueAnimator.isPaused()) {
                    valueAnimator.resume();
                } else {
                    valueAnimator.start();
                }
                return z4;
            }
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.f4451i == null) {
            this.f4451i = new ArrayList();
        }
        if (this.f4451i.contains(animationCallback)) {
            return;
        }
        this.f4451i.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.n = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return o(z, z2, true);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        p(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        p(false, true, false);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f4451i;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.f4451i.remove(animationCallback);
        if (this.f4451i.isEmpty()) {
            this.f4451i = null;
            return true;
        }
        return true;
    }
}
