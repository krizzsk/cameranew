package com.pinguo.album.views.utils;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
/* compiled from: ViewPaper.java */
/* loaded from: classes3.dex */
class b {
    private final Interpolator a = new DecelerateInterpolator();
    private int b = 0;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f6126d;

    /* renamed from: e  reason: collision with root package name */
    private float f6127e;

    /* renamed from: f  reason: collision with root package name */
    private long f6128f;

    /* renamed from: g  reason: collision with root package name */
    private long f6129g;

    private long b() {
        return com.pinguo.album.animations.c.a();
    }

    private void f(float f2, float f3, long j2, int i2) {
        this.f6126d = f2;
        this.f6127e = f3;
        this.f6129g = j2;
        this.f6128f = b();
        this.b = i2;
    }

    public float a() {
        return this.c;
    }

    public void c(float f2) {
        f(this.c, com.pinguo.album.j.a.d(this.c + (f2 * 0.1f), -1.0f, 1.0f), 200L, 2);
    }

    public void d(float f2) {
        if (this.b == 2) {
            return;
        }
        this.c = com.pinguo.album.j.a.d(this.c + f2, -1.0f, 1.0f);
        this.b = 1;
    }

    public void e() {
        int i2 = this.b;
        if (i2 == 0 || i2 == 2) {
            return;
        }
        f(this.c, 0.0f, 500L, 3);
    }

    public boolean g() {
        int i2 = this.b;
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        float d2 = com.pinguo.album.j.a.d(((float) (b() - this.f6128f)) / ((float) this.f6129g), 0.0f, 1.0f);
        float interpolation = this.b == 2 ? d2 : this.a.getInterpolation(d2);
        float f2 = this.f6126d;
        float f3 = f2 + ((this.f6127e - f2) * interpolation);
        this.c = f3;
        if (d2 >= 1.0f) {
            int i3 = this.b;
            if (i3 == 2) {
                f(f3, 0.0f, 500L, 3);
            } else if (i3 == 3) {
                this.b = 0;
            }
        }
        return true;
    }
}
