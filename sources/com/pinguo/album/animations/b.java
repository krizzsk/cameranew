package com.pinguo.album.animations;

import android.view.animation.Interpolator;
/* compiled from: Animation.java */
/* loaded from: classes3.dex */
public abstract class b {
    private long a = -2;
    private int b;
    private Interpolator c;

    /* renamed from: d  reason: collision with root package name */
    private a f6000d;

    /* compiled from: Animation.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public boolean b(long j2) {
        long j3 = this.a;
        if (j3 == -2) {
            return false;
        }
        if (j3 == -3) {
            this.a = -2L;
            return g();
        }
        if (j3 == -1) {
            this.a = j2;
            f();
        }
        int i2 = (int) (j2 - this.a);
        float d2 = com.pinguo.album.j.a.d(i2 / this.b, 0.0f, 1.0f);
        Interpolator interpolator = this.c;
        if (interpolator != null) {
            d2 = interpolator.getInterpolation(d2);
        }
        e(d2);
        if (i2 >= this.b) {
            this.a = -3L;
            return true;
        }
        return true;
    }

    public void c() {
        this.a = -2L;
    }

    public boolean d() {
        return this.a != -2;
    }

    protected abstract void e(float f2);

    protected void f() {
        a aVar = this.f6000d;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        a aVar = this.f6000d;
        if (aVar != null) {
            aVar.a();
            return false;
        }
        return false;
    }

    public void h(a aVar) {
        this.f6000d = aVar;
    }

    public void i(int i2) {
        this.b = i2;
    }

    public void j(Interpolator interpolator) {
        this.c = interpolator;
    }

    public void k(long j2) {
        this.a = j2;
    }

    public void l() {
        this.a = -1L;
    }
}
