package com.airbnb.lottie.w;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private com.airbnb.lottie.e f578j;
    private float c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private boolean f572d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f573e = 0;

    /* renamed from: f  reason: collision with root package name */
    private float f574f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f575g = 0;

    /* renamed from: h  reason: collision with root package name */
    private float f576h = -2.14748365E9f;

    /* renamed from: i  reason: collision with root package name */
    private float f577i = 2.14748365E9f;
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    protected boolean f579k = false;

    private void C() {
        if (this.f578j == null) {
            return;
        }
        float f2 = this.f574f;
        if (f2 < this.f576h || f2 > this.f577i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f576h), Float.valueOf(this.f577i), Float.valueOf(this.f574f)));
        }
    }

    private float k() {
        com.airbnb.lottie.e eVar = this.f578j;
        if (eVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / eVar.h()) / Math.abs(this.c);
    }

    private boolean o() {
        return n() < 0.0f;
    }

    public void A(int i2) {
        z(i2, (int) this.f577i);
    }

    public void B(float f2) {
        this.c = f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        b();
        s();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        r();
        if (this.f578j == null || !isRunning()) {
            return;
        }
        com.airbnb.lottie.d.a("LottieValueAnimator#doFrame");
        long j3 = this.f573e;
        float k2 = ((float) (j3 != 0 ? j2 - j3 : 0L)) / k();
        float f2 = this.f574f;
        if (o()) {
            k2 = -k2;
        }
        float f3 = f2 + k2;
        this.f574f = f3;
        boolean z = !g.d(f3, m(), l());
        this.f574f = g.b(this.f574f, m(), l());
        this.f573e = j2;
        f();
        if (z) {
            if (getRepeatCount() != -1 && this.f575g >= getRepeatCount()) {
                this.f574f = this.c < 0.0f ? m() : l();
                s();
                c(o());
            } else {
                d();
                this.f575g++;
                if (getRepeatMode() == 2) {
                    this.f572d = !this.f572d;
                    v();
                } else {
                    this.f574f = o() ? l() : m();
                }
                this.f573e = j2;
            }
        }
        C();
        com.airbnb.lottie.d.b("LottieValueAnimator#doFrame");
    }

    public void g() {
        this.f578j = null;
        this.f576h = -2.14748365E9f;
        this.f577i = 2.14748365E9f;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getAnimatedFraction() {
        float m;
        float l2;
        float m2;
        if (this.f578j == null) {
            return 0.0f;
        }
        if (o()) {
            m = l() - this.f574f;
            l2 = l();
            m2 = m();
        } else {
            m = this.f574f - m();
            l2 = l();
            m2 = m();
        }
        return m / (l2 - m2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(i());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.airbnb.lottie.e eVar = this.f578j;
        if (eVar == null) {
            return 0L;
        }
        return eVar.d();
    }

    @MainThread
    public void h() {
        s();
        c(o());
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float i() {
        com.airbnb.lottie.e eVar = this.f578j;
        if (eVar == null) {
            return 0.0f;
        }
        return (this.f574f - eVar.o()) / (this.f578j.f() - this.f578j.o());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f579k;
    }

    public float j() {
        return this.f574f;
    }

    public float l() {
        com.airbnb.lottie.e eVar = this.f578j;
        if (eVar == null) {
            return 0.0f;
        }
        float f2 = this.f577i;
        return f2 == 2.14748365E9f ? eVar.f() : f2;
    }

    public float m() {
        com.airbnb.lottie.e eVar = this.f578j;
        if (eVar == null) {
            return 0.0f;
        }
        float f2 = this.f576h;
        return f2 == -2.14748365E9f ? eVar.o() : f2;
    }

    public float n() {
        return this.c;
    }

    @MainThread
    public void p() {
        s();
    }

    @MainThread
    public void q() {
        this.f579k = true;
        e(o());
        x((int) (o() ? l() : m()));
        this.f573e = 0L;
        this.f575g = 0;
        r();
    }

    protected void r() {
        if (isRunning()) {
            t(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void s() {
        t(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f572d) {
            return;
        }
        this.f572d = false;
        v();
    }

    @MainThread
    protected void t(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f579k = false;
        }
    }

    @MainThread
    public void u() {
        this.f579k = true;
        r();
        this.f573e = 0L;
        if (o() && j() == m()) {
            this.f574f = l();
        } else if (o() || j() != l()) {
        } else {
            this.f574f = m();
        }
    }

    public void v() {
        B(-n());
    }

    public void w(com.airbnb.lottie.e eVar) {
        boolean z = this.f578j == null;
        this.f578j = eVar;
        if (z) {
            z((int) Math.max(this.f576h, eVar.o()), (int) Math.min(this.f577i, eVar.f()));
        } else {
            z((int) eVar.o(), (int) eVar.f());
        }
        float f2 = this.f574f;
        this.f574f = 0.0f;
        x((int) f2);
        f();
    }

    public void x(float f2) {
        if (this.f574f == f2) {
            return;
        }
        this.f574f = g.b(f2, m(), l());
        this.f573e = 0L;
        f();
    }

    public void y(float f2) {
        z(this.f576h, f2);
    }

    public void z(float f2, float f3) {
        if (f2 <= f3) {
            com.airbnb.lottie.e eVar = this.f578j;
            float o = eVar == null ? -3.4028235E38f : eVar.o();
            com.airbnb.lottie.e eVar2 = this.f578j;
            float f4 = eVar2 == null ? Float.MAX_VALUE : eVar2.f();
            this.f576h = g.b(f2, o, f4);
            this.f577i = g.b(f3, o, f4);
            x((int) g.b(this.f574f, f2, f3));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
    }
}
