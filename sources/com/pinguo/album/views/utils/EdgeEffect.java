package com.pinguo.album.views.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.pinguo.album.R;
import com.pinguo.album.opengles.l;
import com.pinguo.album.opengles.r;
/* loaded from: classes3.dex */
public class EdgeEffect {
    private final a a;
    private final a b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6117d;

    /* renamed from: e  reason: collision with root package name */
    private float f6118e;

    /* renamed from: f  reason: collision with root package name */
    private float f6119f;

    /* renamed from: g  reason: collision with root package name */
    private float f6120g;

    /* renamed from: h  reason: collision with root package name */
    private float f6121h;

    /* renamed from: i  reason: collision with root package name */
    private float f6122i;

    /* renamed from: j  reason: collision with root package name */
    private float f6123j;

    /* renamed from: k  reason: collision with root package name */
    private float f6124k;

    /* renamed from: l  reason: collision with root package name */
    private float f6125l;
    private float m;
    private float n;
    private float o;
    private float p;
    private long q;
    private float r;
    private int t = 0;
    private final Interpolator s = new DecelerateInterpolator();

    /* loaded from: classes3.dex */
    private static class a extends r {
        private Rect v;
        private int w;

        public a(Context context, int i2) {
            super(context, i2);
            this.v = new Rect();
            this.w = 255;
        }

        public void I(l lVar) {
            lVar.s(1);
            lVar.z(this.w / 255.0f);
            Rect rect = this.v;
            a(lVar, rect.left, rect.top, rect.width(), rect.height());
            lVar.b();
        }

        public int J() {
            return getHeight();
        }

        public int K() {
            return getWidth();
        }

        public void L(int i2) {
            this.w = i2;
        }

        public void M(int i2, int i3, int i4, int i5) {
            this.v.set(i2, i3, i4, i5);
        }
    }

    public EdgeEffect(Context context) {
        this.a = new a(context, R.drawable.ab_overscroll_edge);
        this.b = new a(context, R.drawable.ab_overscroll_glow);
        this.f6117d = (int) ((context.getResources().getDisplayMetrics().density * 300.0f) + 0.5f);
    }

    private void c() {
        float min = Math.min(((float) (com.pinguo.album.animations.c.a() - this.q)) / this.r, 1.0f);
        float interpolation = this.s.getInterpolation(min);
        float f2 = this.f6122i;
        this.f6118e = f2 + ((this.f6123j - f2) * interpolation);
        float f3 = this.f6124k;
        float f4 = this.f6125l;
        this.f6119f = ((f4 - f3) * interpolation) + f3;
        float f5 = this.m;
        this.f6120g = f5 + ((this.n - f5) * interpolation);
        float f6 = this.o;
        float f7 = this.p;
        this.f6121h = f6 + ((f7 - f6) * interpolation);
        if (min >= 0.999f) {
            int i2 = this.t;
            if (i2 == 1) {
                this.t = 4;
                this.q = com.pinguo.album.animations.c.a();
                this.r = 1000.0f;
                this.f6122i = this.f6118e;
                this.f6124k = this.f6119f;
                this.m = this.f6120g;
                this.o = this.f6121h;
                this.f6123j = 0.0f;
                this.f6125l = 0.0f;
                this.n = 0.0f;
                this.p = 0.0f;
            } else if (i2 != 2) {
                if (i2 == 3) {
                    this.t = 0;
                } else if (i2 != 4) {
                } else {
                    this.f6119f = f3 + ((f4 - f3) * interpolation * (f7 != 0.0f ? 1.0f / (f7 * f7) : Float.MAX_VALUE));
                    this.t = 3;
                }
            } else {
                this.t = 3;
                this.q = com.pinguo.album.animations.c.a();
                this.r = 1000.0f;
                this.f6122i = this.f6118e;
                this.f6124k = this.f6119f;
                this.m = this.f6120g;
                this.o = this.f6121h;
                this.f6123j = 0.0f;
                this.f6125l = 0.0f;
                this.n = 0.0f;
                this.p = 0.0f;
            }
        }
    }

    public boolean a(l lVar) {
        c();
        int J = this.a.J();
        this.a.K();
        int J2 = this.b.J();
        int K = this.b.K();
        this.b.L((int) (Math.max(0.0f, Math.min(this.f6120g, 1.0f)) * 255.0f));
        float f2 = J2;
        int min = (int) Math.min((((this.f6121h * f2) * f2) / K) * 0.6f, f2 * 4.0f);
        int i2 = this.c;
        int i3 = this.f6117d;
        if (i2 < i3) {
            int i4 = (i2 - i3) / 2;
            this.b.M(i4, 0, i2 - i4, min);
        } else {
            this.b.M(0, 0, i2, min);
        }
        this.b.I(lVar);
        this.a.L((int) (Math.max(0.0f, Math.min(this.f6118e, 1.0f)) * 255.0f));
        int i5 = (int) (J * this.f6119f);
        int i6 = this.c;
        int i7 = this.f6117d;
        if (i6 < i7) {
            int i8 = (i6 - i7) / 2;
            this.a.M(i8, 0, i6 - i8, i5);
        } else {
            this.a.M(0, 0, i6, i5);
        }
        this.a.I(lVar);
        return this.t != 0;
    }

    public void b(int i2, int i3) {
        this.c = i2;
    }
}
