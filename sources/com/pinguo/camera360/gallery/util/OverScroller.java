package com.pinguo.camera360.gallery.util;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes3.dex */
public class OverScroller {

    /* renamed from: f  reason: collision with root package name */
    private static float f6722f = 8.0f;

    /* renamed from: g  reason: collision with root package name */
    private static float f6723g = 1.0f / m(1.0f);
    private int a;
    private final a b;
    private final a c;

    /* renamed from: d  reason: collision with root package name */
    private final Interpolator f6724d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6725e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        private static float o;
        private static float p = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] q = new float[101];
        private static final float[] r = new float[101];
        private int a;
        private int b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f6726d;

        /* renamed from: e  reason: collision with root package name */
        private float f6727e;

        /* renamed from: f  reason: collision with root package name */
        private float f6728f;

        /* renamed from: g  reason: collision with root package name */
        private long f6729g;

        /* renamed from: h  reason: collision with root package name */
        private int f6730h;

        /* renamed from: i  reason: collision with root package name */
        private int f6731i;

        /* renamed from: j  reason: collision with root package name */
        private int f6732j;

        /* renamed from: l  reason: collision with root package name */
        private int f6734l;
        private float m = ViewConfiguration.getScrollFriction();
        private int n = 0;

        /* renamed from: k  reason: collision with root package name */
        private boolean f6733k = true;

        static {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i2 = 0; i2 < 100; i2++) {
                float f14 = i2 / 100.0f;
                float f15 = 1.0f;
                while (true) {
                    f2 = 2.0f;
                    f3 = ((f15 - f12) / 2.0f) + f12;
                    f4 = 3.0f;
                    f5 = 1.0f - f3;
                    f6 = f3 * 3.0f * f5;
                    f7 = f3 * f3 * f3;
                    float f16 = (((f5 * 0.175f) + (f3 * 0.35000002f)) * f6) + f7;
                    if (Math.abs(f16 - f14) < 1.0E-5d) {
                        break;
                    } else if (f16 > f14) {
                        f15 = f3;
                    } else {
                        f12 = f3;
                    }
                }
                q[i2] = (f6 * ((f5 * 0.5f) + f3)) + f7;
                float f17 = 1.0f;
                while (true) {
                    f8 = ((f17 - f13) / f2) + f13;
                    f9 = 1.0f - f8;
                    f10 = f8 * f4 * f9;
                    f11 = f8 * f8 * f8;
                    float f18 = (((f9 * 0.5f) + f8) * f10) + f11;
                    if (Math.abs(f18 - f14) < 1.0E-5d) {
                        break;
                    }
                    if (f18 > f14) {
                        f17 = f8;
                    } else {
                        f13 = f8;
                    }
                    f2 = 2.0f;
                    f4 = 3.0f;
                }
                r[i2] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
            }
            float[] fArr = q;
            r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        a() {
        }

        private void h(int i2, int i3, int i4) {
            float abs = Math.abs((i4 - i2) / (i3 - i2));
            int i5 = (int) (abs * 100.0f);
            if (i5 < 100) {
                float f2 = i5 / 100.0f;
                int i6 = i5 + 1;
                float[] fArr = r;
                float f3 = fArr[i5];
                this.f6730h = (int) (this.f6730h * (f3 + (((abs - f2) / ((i6 / 100.0f) - f2)) * (fArr[i6] - f3))));
            }
        }

        private void k(int i2, int i3, int i4) {
            float f2 = this.f6728f;
            float sqrt = (float) Math.sqrt((((((i4 * i4) / 2.0f) / Math.abs(f2)) + Math.abs(i3 - i2)) * 2.0d) / Math.abs(this.f6728f));
            this.f6729g -= (int) ((sqrt - ((-i4) / f2)) * 1000.0f);
            this.a = i3;
            this.f6726d = (int) ((-this.f6728f) * sqrt);
        }

        private static float m(int i2) {
            return i2 > 0 ? -2000.0f : 2000.0f;
        }

        private double n(int i2) {
            return Math.log((Math.abs(i2) * 0.35f) / (this.m * o));
        }

        private double o(int i2) {
            double n = n(i2);
            float f2 = p;
            return this.m * o * Math.exp((f2 / (f2 - 1.0d)) * n);
        }

        private int p(int i2) {
            return (int) (Math.exp(n(i2) / (p - 1.0d)) * 1000.0d);
        }

        static void q(Context context) {
            o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        private void r() {
            int i2 = this.f6726d;
            float abs = (i2 * i2) / (Math.abs(this.f6728f) * 2.0f);
            float signum = Math.signum(this.f6726d);
            int i3 = this.f6734l;
            if (abs > i3) {
                float f2 = -signum;
                int i4 = this.f6726d;
                this.f6728f = ((f2 * i4) * i4) / (i3 * 2.0f);
                abs = i3;
            }
            this.f6734l = (int) abs;
            this.n = 2;
            int i5 = this.a;
            int i6 = this.f6726d;
            if (i6 <= 0) {
                abs = -abs;
            }
            this.c = i5 + ((int) abs);
            this.f6730h = -((int) ((i6 * 1000.0f) / this.f6728f));
        }

        private void s(int i2, int i3, int i4, int i5) {
            if (i2 > i3 && i2 < i4) {
                us.pinguo.common.log.a.g("OverScroller", "startAfterEdge called from a valid position", new Object[0]);
                this.f6733k = true;
                return;
            }
            boolean z = i2 > i4;
            int i6 = z ? i4 : i3;
            int i7 = i2 - i6;
            if (i7 * i5 >= 0) {
                t(i2, i6, i5);
            } else if (o(i5) > Math.abs(i7)) {
                l(i2, i5, z ? i3 : i2, z ? i2 : i4, this.f6734l);
            } else {
                v(i2, i6, i5);
            }
        }

        private void t(int i2, int i3, int i4) {
            this.f6728f = m(i4 == 0 ? i2 - i3 : i4);
            k(i2, i3, i4);
            r();
        }

        private void v(int i2, int i3, int i4) {
            this.f6733k = false;
            this.n = 1;
            this.a = i2;
            this.c = i3;
            int i5 = i2 - i3;
            this.f6728f = m(i5);
            this.f6726d = -i5;
            this.f6734l = Math.abs(i5);
            this.f6730h = (int) (Math.sqrt((i5 * (-2.0d)) / this.f6728f) * 1000.0d);
        }

        boolean i() {
            int i2 = this.n;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                if (i2 == 2) {
                    this.f6729g += this.f6730h;
                    v(this.c, this.a, 0);
                }
            } else if (this.f6730h >= this.f6731i) {
                return false;
            } else {
                this.a = this.c;
                int i3 = (int) this.f6727e;
                this.f6726d = i3;
                this.f6728f = m(i3);
                this.f6729g += this.f6730h;
                r();
            }
            w();
            return true;
        }

        void j() {
            this.b = this.c;
            this.f6733k = true;
        }

        void l(int i2, int i3, int i4, int i5, int i6) {
            float f2;
            this.f6734l = i6;
            this.f6733k = false;
            this.f6726d = i3;
            this.f6727e = i3;
            this.f6731i = 0;
            this.f6730h = 0;
            this.f6729g = AnimationUtils.currentAnimationTimeMillis();
            this.a = i2;
            this.b = i2;
            if (i2 <= i5 && i2 >= i4) {
                this.n = 0;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                if (i3 != 0) {
                    int p2 = p(i3);
                    this.f6731i = p2;
                    this.f6730h = p2;
                    d2 = o(i3);
                }
                int signum = (int) (d2 * Math.signum(f2));
                this.f6732j = signum;
                int i7 = i2 + signum;
                this.c = i7;
                if (i7 < i4) {
                    h(this.a, i7, i4);
                    this.c = i4;
                }
                int i8 = this.c;
                if (i8 > i5) {
                    h(this.a, i8, i5);
                    this.c = i5;
                    return;
                }
                return;
            }
            s(i2, i4, i5, i3);
        }

        void u(int i2, int i3, int i4) {
            this.f6733k = false;
            this.a = i2;
            this.c = i2 + i3;
            this.f6729g = AnimationUtils.currentAnimationTimeMillis();
            this.f6730h = i4;
            this.f6728f = 0.0f;
            this.f6726d = 0;
        }

        boolean w() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f6729g;
            int i2 = this.f6730h;
            if (currentAnimationTimeMillis > i2) {
                return false;
            }
            double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            int i3 = this.n;
            if (i3 == 0) {
                int i4 = this.f6731i;
                float f2 = ((float) currentAnimationTimeMillis) / i4;
                int i5 = (int) (f2 * 100.0f);
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (i5 < 100) {
                    float f5 = i5 / 100.0f;
                    int i6 = i5 + 1;
                    float[] fArr = q;
                    float f6 = fArr[i5];
                    f4 = (fArr[i6] - f6) / ((i6 / 100.0f) - f5);
                    f3 = f6 + ((f2 - f5) * f4);
                }
                int i7 = this.f6732j;
                d2 = f3 * i7;
                this.f6727e = ((f4 * i7) / i4) * 1000.0f;
            } else if (i3 == 1) {
                float f7 = ((float) currentAnimationTimeMillis) / i2;
                float f8 = f7 * f7;
                float signum = Math.signum(this.f6726d);
                int i8 = this.f6734l;
                this.f6727e = signum * i8 * 6.0f * ((-f7) + f8);
                d2 = i8 * signum * ((3.0f * f8) - ((2.0f * f7) * f8));
            } else if (i3 == 2) {
                float f9 = ((float) currentAnimationTimeMillis) / 1000.0f;
                int i9 = this.f6726d;
                float f10 = this.f6728f;
                this.f6727e = i9 + (f10 * f9);
                d2 = (i9 * f9) + (((f10 * f9) * f9) / 2.0f);
            }
            this.b = this.a + ((int) Math.round(d2));
            return true;
        }

        void x(float f2) {
            int i2 = this.a;
            this.b = i2 + Math.round(f2 * (this.c - i2));
        }
    }

    public OverScroller(Context context) {
        this(context, null);
    }

    static float m(float f2) {
        float exp;
        float f3 = f2 * f6722f;
        if (f3 < 1.0f) {
            exp = f3 - (1.0f - ((float) Math.exp(-f3)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
        }
        return exp * f6723g;
    }

    public void a() {
        this.b.j();
        this.c.j();
    }

    public boolean b() {
        float interpolation;
        if (k()) {
            return false;
        }
        int i2 = this.a;
        if (i2 == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.b.f6729g;
            int i3 = this.b.f6730h;
            if (currentAnimationTimeMillis < i3) {
                float f2 = ((float) currentAnimationTimeMillis) / i3;
                Interpolator interpolator = this.f6724d;
                if (interpolator == null) {
                    interpolation = m(f2);
                } else {
                    interpolation = interpolator.getInterpolation(f2);
                }
                this.b.x(interpolation);
                this.c.x(interpolation);
            } else {
                a();
            }
        } else if (i2 == 1) {
            if (!this.b.f6733k && !this.b.w() && !this.b.i()) {
                this.b.j();
            }
            if (!this.c.f6733k && !this.c.w() && !this.c.i()) {
                this.c.j();
            }
        }
        return true;
    }

    public void c(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        d(i2, i3, i4, i5, i6, i7, i8, i9, 0, 0);
    }

    public void d(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (!this.f6725e || k()) {
            i12 = i4;
        } else {
            float f2 = this.b.f6727e;
            float f3 = this.c.f6727e;
            i12 = i4;
            float f4 = i12;
            if (Math.signum(f4) == Math.signum(f2)) {
                i13 = i5;
                float f5 = i13;
                if (Math.signum(f5) == Math.signum(f3)) {
                    i14 = (int) (f5 + f3);
                    i15 = (int) (f4 + f2);
                    this.a = 1;
                    this.b.l(i2, i15, i6, i7, i10);
                    this.c.l(i3, i14, i8, i9, i11);
                }
                i14 = i13;
                i15 = i12;
                this.a = 1;
                this.b.l(i2, i15, i6, i7, i10);
                this.c.l(i3, i14, i8, i9, i11);
            }
        }
        i13 = i5;
        i14 = i13;
        i15 = i12;
        this.a = 1;
        this.b.l(i2, i15, i6, i7, i10);
        this.c.l(i3, i14, i8, i9, i11);
    }

    public final void e(boolean z) {
        a aVar = this.b;
        this.c.f6733k = z;
        aVar.f6733k = z;
    }

    public float f() {
        return (float) Math.sqrt((this.b.f6727e * this.b.f6727e) + (this.c.f6727e * this.c.f6727e));
    }

    public final int g() {
        return this.b.b;
    }

    public final int h() {
        return this.c.b;
    }

    public final int i() {
        return this.b.c;
    }

    public final int j() {
        return this.c.c;
    }

    public final boolean k() {
        return this.b.f6733k && this.c.f6733k;
    }

    public void l(int i2, int i3, int i4, int i5, int i6) {
        this.a = 0;
        this.b.u(i2, i4, i6);
        this.c.u(i3, i5, i6);
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean z) {
        this.f6724d = interpolator;
        this.f6725e = z;
        this.b = new a();
        this.c = new a();
        a.q(context);
    }
}
