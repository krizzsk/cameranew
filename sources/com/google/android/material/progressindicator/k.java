package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* loaded from: classes2.dex */
public final class k extends h<ObjectAnimator> {

    /* renamed from: j  reason: collision with root package name */
    private static final Property<k, Float> f4457j = new b(Float.class, "animationFraction");

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f4458d;

    /* renamed from: e  reason: collision with root package name */
    private FastOutSlowInInterpolator f4459e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f4460f;

    /* renamed from: g  reason: collision with root package name */
    private int f4461g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4462h;

    /* renamed from: i  reason: collision with root package name */
    private float f4463i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            k kVar = k.this;
            kVar.f4461g = (kVar.f4461g + 1) % k.this.f4460f.c.length;
            k.this.f4462h = true;
        }
    }

    /* compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    /* loaded from: classes2.dex */
    static class b extends Property<k, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(k kVar) {
            return Float.valueOf(kVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, Float f2) {
            kVar.r(f2.floatValue());
        }
    }

    public k(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f4461g = 1;
        this.f4460f = linearProgressIndicatorSpec;
        this.f4459e = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f4463i;
    }

    private void o() {
        if (this.f4458d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f4457j, 0.0f, 1.0f);
            this.f4458d = ofFloat;
            ofFloat.setDuration(333L);
            this.f4458d.setInterpolator(null);
            this.f4458d.setRepeatCount(-1);
            this.f4458d.addListener(new a());
        }
    }

    private void p() {
        if (!this.f4462h || this.b[3] >= 1.0f) {
            return;
        }
        int[] iArr = this.c;
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = com.google.android.material.b.a.a(this.f4460f.c[this.f4461g], this.a.getAlpha());
        this.f4462h = false;
    }

    private void s(int i2) {
        this.b[0] = 0.0f;
        float b2 = b(i2, 0, 667);
        float[] fArr = this.b;
        float interpolation = this.f4459e.getInterpolation(b2);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.b;
        float interpolation2 = this.f4459e.getInterpolation(b2 + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.b[5] = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.f4458d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // com.google.android.material.progressindicator.h
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.h
    public void g() {
        o();
        q();
        this.f4458d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
    }

    @VisibleForTesting
    void q() {
        this.f4462h = true;
        this.f4461g = 1;
        Arrays.fill(this.c, com.google.android.material.b.a.a(this.f4460f.c[0], this.a.getAlpha()));
    }

    @VisibleForTesting
    void r(float f2) {
        this.f4463i = f2;
        s((int) (f2 * 333.0f));
        p();
        this.a.invalidateSelf();
    }
}
