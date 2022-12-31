package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import com.pinguo.album.views.c;
import com.pinguo.album.views.utils.d;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.pinguo.camera360.gallery.c0;
import com.pinguo.camera360.gallery.ui.PositionController;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoView.java */
/* loaded from: classes3.dex */
public class u extends com.pinguo.album.views.a {
    private static float U = 0.74f;
    private com.pinguo.album.opengles.t A;
    private com.pinguo.album.opengles.t B;
    private com.pinguo.album.views.c C;
    private com.pinguo.album.g D;
    private boolean E;
    private boolean J;
    private int M;
    private int N;
    private int O;
    private boolean Q;
    private Context R;
    private com.pinguo.album.opengles.u m;
    private com.pinguo.album.opengles.u n;
    private com.pinguo.album.opengles.u o;
    private final d u;
    private final com.pinguo.album.views.utils.d v;
    private final PositionController w;
    private final PositionController.f x;
    private i y;
    private c z;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6661l = false;
    private boolean p = true;
    private j q = new j(0.5f);
    private AccelerateInterpolator r = new AccelerateInterpolator(0.9f);
    private final com.pinguo.album.j.g<f> s = new com.pinguo.album.j.g<>(-2, 2);
    private h[] t = new h[5];
    private boolean F = false;
    private boolean G = false;
    private int H = 0;
    private int I = 0;
    private Rect K = new Rect();
    private Rect L = new Rect();
    private int P = Integer.MAX_VALUE;
    protected boolean S = true;
    private boolean T = true;

    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    class a implements PositionController.f {
        a() {
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.f
        public void a(int i2, int i3) {
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.f
        public void b() {
            u.this.q();
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.f
        public boolean c() {
            return (u.this.O & 1) != 0;
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.f
        public boolean d() {
            return (u.this.O & 4) != 0;
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.f
        public void e(int i2, int i3) {
        }
    }

    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    class b implements f {
        private String b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6662d;

        /* renamed from: g  reason: collision with root package name */
        private boolean f6665g;

        /* renamed from: h  reason: collision with root package name */
        private int f6666h;

        /* renamed from: i  reason: collision with root package name */
        private int f6667i;

        /* renamed from: k  reason: collision with root package name */
        public int f6669k;
        private long a = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f6663e = 0;

        /* renamed from: f  reason: collision with root package name */
        private h f6664f = new h();

        /* renamed from: j  reason: collision with root package name */
        private long f6668j = -1;

        b() {
        }

        private void g(float f2, float f3, int i2, int i3, float f4) {
            int i4;
            int O = u.this.w.O();
            int M = u.this.w.M();
            int i5 = (int) ((O / 2.0f) + (((i2 / 2.0f) - f2) / f4) + 0.5f);
            int i6 = (int) ((M / 2.0f) + (((i3 / 2.0f) - f3) / f4) + 0.5f);
            int i7 = O - i5;
            int i8 = M - i6;
            if (f()) {
                i4 = this.f6667i;
            } else {
                i4 = this.c;
            }
            while (i4 < 0) {
                i4 = (i4 + BaseBlurEffect.ROTATION_360) % BaseBlurEffect.ROTATION_360;
            }
            while (i4 >= 360) {
                i4 = (i4 - 360) % BaseBlurEffect.ROTATION_360;
            }
            if (i4 != 0) {
                if (i4 == 90) {
                    i5 = i6;
                    i6 = i7;
                } else if (i4 == 180) {
                    i5 = i7;
                    i6 = i8;
                } else if (i4 != 270) {
                    throw new RuntimeException(String.valueOf(i4));
                } else {
                    i6 = i5;
                    i5 = i8;
                }
            }
            u.this.C.g0(i5, i6, f4, this.c);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void j() {
            /*
                r7 = this;
                com.pinguo.camera360.gallery.ui.u r0 = com.pinguo.camera360.gallery.ui.u.this
                com.pinguo.camera360.gallery.ui.u$c r0 = com.pinguo.camera360.gallery.ui.u.o0(r0)
                r1 = 0
                com.pinguo.camera360.gallery.data.w r0 = r0.g(r1)
                if (r0 == 0) goto L2b
                long r2 = r0.n()
                java.lang.String r0 = r0.o()
                long r4 = r7.a
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L25
                if (r0 == 0) goto L2b
                java.lang.String r4 = r7.b
                boolean r4 = r0.equals(r4)
                if (r4 != 0) goto L2b
            L25:
                r4 = 1
                r7.a = r2
                r7.b = r0
                goto L2c
            L2b:
                r4 = 0
            L2c:
                com.pinguo.camera360.gallery.ui.u r0 = com.pinguo.camera360.gallery.ui.u.this
                com.pinguo.camera360.gallery.ui.u$c r0 = com.pinguo.camera360.gallery.ui.u.o0(r0)
                int r0 = r0.e(r1)
                if (r4 != 0) goto L3c
                int r2 = r7.c
                if (r0 == r2) goto L50
            L3c:
                r7.i()
                com.pinguo.camera360.gallery.ui.u r2 = com.pinguo.camera360.gallery.ui.u.this
                com.pinguo.album.views.c r2 = com.pinguo.camera360.gallery.ui.u.m0(r2)
                boolean r2 = r2.V()
                if (r2 == 0) goto L4e
                r7.c = r1
                goto L50
            L4e:
                r7.c = r0
            L50:
                com.pinguo.camera360.gallery.ui.u r0 = com.pinguo.camera360.gallery.ui.u.this
                com.pinguo.album.views.c r0 = com.pinguo.camera360.gallery.ui.u.m0(r0)
                int r0 = r0.z
                com.pinguo.camera360.gallery.ui.u r1 = com.pinguo.camera360.gallery.ui.u.this
                com.pinguo.album.views.c r1 = com.pinguo.camera360.gallery.ui.u.m0(r1)
                int r1 = r1.A
                com.pinguo.camera360.gallery.ui.u$h r2 = r7.f6664f
                int r3 = r7.c
                int r3 = com.pinguo.camera360.gallery.ui.u.n0(r3, r0, r1)
                r2.a = r3
                com.pinguo.camera360.gallery.ui.u$h r2 = r7.f6664f
                int r3 = r7.c
                int r0 = com.pinguo.camera360.gallery.ui.u.n0(r3, r1, r0)
                r2.b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.gallery.ui.u.b.j():void");
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public void a() {
            u.this.C.Z();
            this.f6662d = u.this.z.o(0);
            this.f6663e = u.this.z.i(0);
            this.f6665g = u.this.z.a(0);
            b(u.this.z.c(0));
            j();
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public void b(com.pinguo.album.opengles.s sVar) {
            u.this.C.h0(sVar);
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public boolean c(com.pinguo.album.opengles.l lVar, Rect rect) {
            float N = u.this.w.N();
            int p = u.this.p();
            int n = u.this.n();
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            boolean e2 = e();
            lVar.s(3);
            float K = u.this.w.K();
            boolean z = false;
            int i2 = (K > 1.0f ? 1 : (K == 1.0f ? 0 : -1));
            boolean z2 = (i2 == 0 || u.this.w.W()) ? false : true;
            if (this.f6662d && i2 == 0 && rect.centerY() != n / 2) {
                z = true;
            }
            if (z2) {
                int i3 = rect.left;
                int i4 = rect.right;
                float d2 = com.pinguo.album.j.a.d(u.s0(i3, i4, p), -1.0f, 1.0f);
                if (d2 < 0.0f) {
                    float G0 = u.this.G0(d2);
                    float F0 = u.this.F0(d2);
                    float H0 = u.H0(K, G0, 1.0f);
                    N *= H0;
                    lVar.z(u.H0(K, F0, 1.0f));
                    int i5 = i4 - i3;
                    exactCenterX = u.H0(K, (i5 <= p ? p : i5 * H0) / 2.0f, exactCenterX);
                }
            } else if (z) {
                lVar.z(u.this.B0((rect.centerY() - (n / 2)) / n));
            }
            g(exactCenterX, exactCenterY, p, n, N);
            u uVar = u.this;
            uVar.A(lVar, uVar.C);
            lVar.a((int) (exactCenterX + 0.5f), (int) (0.5f + exactCenterY));
            if (this.f6663e == 2) {
                u.this.u0(lVar);
            }
            lVar.b();
            if (this.f6663e != 2 && this.f6665g) {
                u.this.w0(lVar, exactCenterX, exactCenterY, true);
            }
            return e2;
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public boolean d() {
            return this.f6662d;
        }

        public boolean e() {
            long j2 = this.f6668j;
            if (j2 == -1) {
                return false;
            }
            if (j2 == -2) {
                this.f6668j = -1L;
                return false;
            }
            float a = this.f6669k == 0 ? 1.0f : ((float) (com.pinguo.album.animations.c.a() - this.f6668j)) / this.f6669k;
            if (a >= 1.0f) {
                this.c = this.f6667i;
                this.f6668j = -2L;
                return true;
            }
            int i2 = this.f6666h;
            this.c = (int) (i2 + (a * (this.f6667i - i2)));
            return true;
        }

        public boolean f() {
            long j2 = this.f6668j;
            return (j2 == -1 || j2 == -2) ? false : true;
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public int getRotation() {
            return this.c;
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public h getSize() {
            return this.f6664f;
        }

        public void h(int i2) {
            if (f() || this.f6665g) {
                return;
            }
            int i3 = this.c;
            this.f6666h = i3;
            this.f6667i = i3 + i2;
            this.f6668j = com.pinguo.album.animations.c.b();
            this.f6669k = IjkMediaCodecInfo.RANK_SECURE;
            int i4 = u.this.C.z;
            int i5 = u.this.C.A;
            this.f6664f.a = u.E0(this.f6667i, i4, i5);
            this.f6664f.b = u.E0(this.f6667i, i5, i4);
            u.this.w.v0(0, getSize(), null);
        }

        public void i() {
            this.f6668j = -1L;
            this.c = this.f6667i;
        }
    }

    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    public interface c extends c.e {
        boolean a(int i2);

        com.pinguo.album.opengles.s c(int i2);

        int d();

        int e(int i2);

        void f(int i2);

        com.pinguo.camera360.gallery.data.w g(int i2);

        int i(int i2);

        void m(int i2);

        void n(int i2, h hVar);

        boolean o(int i2);

        void p(boolean z);
    }

    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    private class d implements d.b {
        private boolean b;
        private boolean c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6672e;

        /* renamed from: f  reason: collision with root package name */
        private float f6673f;

        /* renamed from: g  reason: collision with root package name */
        private float f6674g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f6675h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f6676i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f6677j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f6678k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f6679l;
        private boolean m;
        private int n;
        private float o;
        private boolean a = false;

        /* renamed from: d  reason: collision with root package name */
        private float f6671d = 0.9f;

        d(Context context) {
            this.f6673f = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        private int i(float f2) {
            if (u.this.Q) {
                return (int) (f2 + 0.5f);
            }
            float n = u.this.n();
            float f3 = 0.4f * n;
            if (Math.abs(f2) < n) {
                f3 = (float) (f3 * Math.sin((f2 / n) * 1.5707963267948966d));
            } else if (f2 <= 0.0f) {
                f3 = -f3;
            }
            return (int) (f3 + 0.5f);
        }

        private boolean j(float f2, float f3, float f4) {
            int i2 = (int) (f2 + 0.5f);
            int i3 = (int) (0.5f + f3);
            us.pinguo.common.log.a.k(" mFilmMode:" + u.this.F, new Object[0]);
            if (!u.this.F) {
                us.pinguo.common.log.a.k(" flingPage", new Object[0]);
                return u.this.w.H(i2, i3);
            } else if (Math.abs(f2) > Math.abs(f3)) {
                us.pinguo.common.log.a.k(" flingFilmX", new Object[0]);
                return u.this.w.G(i2);
            } else {
                return false;
            }
        }

        private void l() {
            if (u.this.E) {
                return;
            }
            u.this.D.sendEmptyMessageDelayed(2, 700L);
            u.this.w.t0(true);
            u.this.E = true;
        }

        private void m() {
            if (u.this.E) {
                u.this.D.removeMessages(2);
                u.this.w.t0(false);
                u.this.E = false;
            }
        }

        @Override // com.pinguo.album.views.utils.d.b
        public void a() {
            us.pinguo.common.log.a.m("PhotoView", "GESTURE: RESET Gesture from OnUp mInPhotoMode is:" + this.f6675h, new Object[0]);
            u uVar = u.this;
            if (uVar.S) {
                if (this.f6675h) {
                    if (uVar.y != null) {
                        u.this.y.q();
                        us.pinguo.common.log.a.m("PhotoView", "GESTURE: RESET Gesture from OnUp Success", new Object[0]);
                        u.this.G = false;
                    }
                    this.f6675h = false;
                    return;
                }
                u.G(uVar, -2);
                if (!this.a) {
                    u.this.W0();
                    if (u.this.y != null) {
                        u.this.y.a();
                        return;
                    }
                    return;
                }
                this.a = false;
            }
        }

        @Override // com.pinguo.album.views.utils.d.b
        public boolean b(float f2, float f3, float f4) {
            u uVar = u.this;
            if (uVar.S) {
                if (this.f6676i) {
                    return true;
                }
                if ((f4 <= 1.0f || !uVar.z.a(0)) && !this.c) {
                    if (Float.isNaN(f4) || Float.isInfinite(f4)) {
                        return false;
                    }
                    int m0 = u.this.w.m0(f4, f2, f3);
                    float f5 = this.o * f4;
                    this.o = f5;
                    if ((f5 < 0.97f || f5 > 1.03f) && this.b && ((m0 < 0 && !u.this.F) || (m0 > 0 && u.this.F))) {
                        m();
                        u.G(u.this, -2);
                        u uVar2 = u.this;
                        uVar2.N0(!uVar2.F);
                        c();
                        this.c = true;
                        return true;
                    }
                    if (this.f6672e && this.o < this.f6671d && m0 < 0) {
                        this.f6675h = true;
                    }
                    if (this.f6675h && m0 >= 0) {
                        this.f6675h = false;
                    }
                    if (m0 != 0) {
                        l();
                    } else {
                        m();
                    }
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // com.pinguo.album.views.utils.d.b
        public void c() {
            u uVar = u.this;
            if (uVar.S) {
                this.f6672e = false;
                if (this.f6676i || this.c) {
                    return;
                }
                uVar.w.F();
                if (u.this.y != null) {
                    u.this.y.c();
                }
            }
        }

        @Override // com.pinguo.album.views.utils.d.b
        public boolean d(float f2, float f3) {
            u uVar = u.this;
            if (uVar.S && uVar.T) {
                if (u.this.y != null) {
                    u.this.y.o();
                }
                PositionController positionController = u.this.w;
                float N = positionController.N();
                this.a = true;
                if (N > 1.0f && !positionController.d0()) {
                    positionController.l0();
                } else {
                    positionController.N0(f2, f3, Math.max(1.5f, N * 1.5f));
                }
                if (u.this.y != null) {
                    u.this.y.c();
                }
                return true;
            }
            return false;
        }

        @Override // com.pinguo.album.views.utils.d.b
        public void e(float f2, float f3) {
            u uVar = u.this;
            if (uVar.S) {
                this.n = 0;
                this.f6677j = false;
                this.f6675h = false;
                u.H(uVar, 1);
                if (u.this.F && u.this.w.g0()) {
                    this.f6678k = true;
                    u.this.w.H0();
                } else {
                    this.f6678k = false;
                }
                this.f6679l = false;
                if (!u.this.F) {
                    u.this.P = Integer.MAX_VALUE;
                } else {
                    u uVar2 = u.this;
                    uVar2.P = uVar2.w.V((int) (f2 + 0.5f), (int) (f3 + 0.5f));
                    if (u.this.P < u.this.M || u.this.P > u.this.N) {
                        u.this.P = Integer.MAX_VALUE;
                    } else {
                        u uVar3 = u.this;
                        uVar3.Q = ((f) uVar3.s.a(u.this.P)).d();
                    }
                }
                if (u.this.y != null) {
                    u.this.y.d();
                }
            }
        }

        @Override // com.pinguo.album.views.utils.d.b
        public boolean f(float f2, float f3) {
            if (Build.VERSION.SDK_INT >= 14 || (u.this.O & 1) != 0) {
                u.G(u.this, -2);
                if (u.this.F && !this.f6678k) {
                    u.this.a1((int) (f2 + 0.5f), (int) (0.5f + f3));
                    u.this.N0(false);
                    this.a = true;
                }
                if (u.this.y != null) {
                    u.this.y.m((int) f2, (int) f3);
                }
                return true;
            }
            return true;
        }

        @Override // com.pinguo.album.views.utils.d.b
        public boolean g(float f2, float f3, float f4, float f5, MotionEvent motionEvent, MotionEvent motionEvent2) {
            int i2;
            int i3;
            u uVar = u.this;
            if (uVar.S && !this.f6672e) {
                if (uVar.w.e0() || Math.abs(f3) <= Math.abs(f2) || f3 <= 0.0f) {
                    if (!this.f6679l) {
                        this.f6679l = true;
                        this.m = Math.abs(f2) > Math.abs(f3);
                    }
                    int i4 = (int) ((-f2) + 0.5f);
                    int i5 = (int) ((-f3) + 0.5f);
                    if (u.this.F) {
                        if (this.m) {
                            u.this.w.o0(i4);
                        } else if (u.this.P != Integer.MAX_VALUE && (i3 = (i2 = i(f5)) - this.n) != 0) {
                            u.this.w.p0(u.this.P, i3);
                            this.n = i2;
                        }
                    } else {
                        if (!this.f6675h && u.this.w.d0() && u.this.w.h0() && motionEvent.getX() > u.this.p() / 4.0f && motionEvent.getX() < (u.this.p() * 3) / 4.0f && f5 > this.f6673f && Math.abs(f4) < Math.abs(f5)) {
                            this.f6675h = true;
                            this.f6674g = 1.0f;
                        }
                        if (!this.f6675h) {
                            u.this.w.q0(i4, i5);
                        } else {
                            int i6 = i(f5);
                            int i7 = i6 - this.n;
                            if (i7 != 0) {
                                float f6 = this.f6674g * 0.98f;
                                this.f6674g = f6;
                                if (f6 < 0.7f) {
                                    this.f6674g = 0.7f;
                                }
                                u.this.w.n0(i7, this.f6674g);
                                this.n = i6;
                                us.pinguo.common.log.a.m("PhotoView", "GESTURE: SET Gesture back to true", new Object[0]);
                                u.this.G = true;
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // com.pinguo.album.views.utils.d.b
        public boolean h(float f2, float f3) {
            u uVar = u.this;
            if (uVar.S) {
                if ((uVar.y == null || !u.this.y.k()) && !this.f6675h) {
                    u.this.w.A(f2, f3);
                    this.b = u.this.F || u.this.w.d0();
                    this.c = false;
                    this.f6677j = true;
                    this.o = 1.0f;
                    if (u.this.y != null) {
                        return u.this.y.o();
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        public boolean k() {
            return this.f6675h || this.f6672e;
        }

        @Override // com.pinguo.album.views.utils.d.b
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            u uVar = u.this;
            if (uVar.S) {
                if (this.f6677j) {
                    return true;
                }
                if (this.f6675h) {
                    return false;
                }
                if (uVar.y == null || !u.this.y.k()) {
                    float abs = Math.abs(motionEvent.getX() - motionEvent2.getX());
                    float abs2 = Math.abs(motionEvent.getY() - motionEvent2.getY());
                    if (!u.this.F && u.this.w.d0() && abs2 > abs && Math.abs(f3) > Math.abs(f2)) {
                        if (motionEvent.getX() < u.this.p() / 4.0f) {
                            if (motionEvent.getY() < motionEvent2.getY()) {
                                if (u.this.s.a(0) instanceof b) {
                                    ((b) u.this.s.a(0)).h(-90);
                                }
                            } else if (u.this.s.a(0) instanceof b) {
                                ((b) u.this.s.a(0)).h(90);
                            }
                            return true;
                        } else if (motionEvent.getX() > (u.this.p() * 3) / 4.0f) {
                            if (motionEvent.getY() < motionEvent2.getY()) {
                                if (u.this.s.a(0) instanceof b) {
                                    ((b) u.this.s.a(0)).h(90);
                                }
                            } else if (u.this.s.a(0) instanceof b) {
                                ((b) u.this.s.a(0)).h(-90);
                            }
                            return true;
                        } else if (motionEvent.getY() > motionEvent2.getY()) {
                            u.this.y.i();
                            return true;
                        }
                    }
                    if (u.this.X0(f2, f3)) {
                        us.pinguo.common.log.a.k(" swipeImages", new Object[0]);
                        this.a = true;
                    } else {
                        us.pinguo.common.log.a.k(" flingImages", new Object[0]);
                        j(f2, f3, Math.abs(motionEvent2.getY() - motionEvent.getY()));
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // com.pinguo.album.views.utils.d.b
        public void onLongPress(MotionEvent motionEvent) {
            u uVar = u.this;
            if (uVar.S) {
                uVar.y.b();
            }
        }
    }

    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    class e extends com.pinguo.album.g {
        public e(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 2) {
                u.this.v.b();
                u.this.w.t0(false);
                u.this.E = false;
            } else if (i2 == 3) {
                u.this.Y0();
            } else if (i2 == 6) {
                u.this.w.D0();
            } else {
                throw new AssertionError(message.what);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b(com.pinguo.album.opengles.s sVar);

        boolean c(com.pinguo.album.opengles.l lVar, Rect rect);

        boolean d();

        int getRotation();

        h getSize();
    }

    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    private class g implements f {
        private int a;
        private int b;
        private com.pinguo.album.opengles.s c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6680d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6681e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6682f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f6683g;

        /* renamed from: h  reason: collision with root package name */
        private int f6684h = 0;

        /* renamed from: i  reason: collision with root package name */
        private h f6685i = new h();

        public g(int i2) {
            this.a = i2;
        }

        private boolean e() {
            com.pinguo.album.opengles.s sVar = this.c;
            return (sVar instanceof com.pinguo.album.opengles.b) && ((com.pinguo.album.opengles.b) sVar).e();
        }

        private void f() {
            if (this.f6681e) {
                this.b = u.this.C0();
            } else if (this.f6680d) {
                this.b = u.this.y0();
            } else {
                this.b = u.this.z.e(this.a);
            }
            com.pinguo.album.opengles.s sVar = this.c;
            if (sVar == null) {
                u.this.z.n(this.a, this.f6685i);
            } else {
                this.f6685i.a = sVar.getWidth();
                this.f6685i.b = this.c.getHeight();
            }
            h hVar = this.f6685i;
            int i2 = hVar.a;
            int i3 = hVar.b;
            hVar.a = u.E0(this.b, i2, i3);
            this.f6685i.b = u.E0(this.b, i3, i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public void a() {
            this.f6683g = u.this.z.o(this.a);
            this.f6684h = u.this.z.i(this.a);
            this.f6682f = u.this.z.a(this.a);
            b(u.this.z.c(this.a));
            f();
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public void b(com.pinguo.album.opengles.s sVar) {
            this.c = sVar;
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public boolean c(com.pinguo.album.opengles.l lVar, Rect rect) {
            if (this.c == null) {
                if (this.a >= u.this.M && this.a <= u.this.N) {
                    u.this.v0(lVar, rect);
                }
                return false;
            }
            int p = u.this.p();
            int n = u.this.n();
            if (rect.left < p && rect.right > 0 && rect.top < n && rect.bottom > 0) {
                float K = u.this.w.K();
                boolean z = true;
                boolean z2 = this.a > 0 && K != 1.0f;
                z = (this.f6683g && K == 1.0f && rect.centerY() != n / 2) ? false : false;
                int H0 = z2 ? (int) (u.H0(K, p / 2, rect.centerX()) + 0.5f) : rect.centerX();
                int centerY = rect.centerY();
                lVar.s(3);
                float f2 = H0;
                float f3 = centerY;
                lVar.a(f2, f3);
                if (z2) {
                    float d2 = com.pinguo.album.j.a.d(((p / 2) - rect.centerX()) / p, -1.0f, 1.0f);
                    float F0 = u.this.F0(d2);
                    float G0 = u.this.G0(d2);
                    float H02 = u.H0(K, F0, 1.0f);
                    float H03 = u.H0(K, G0, 1.0f);
                    lVar.z(H02);
                    lVar.k(H03, H03, 1.0f);
                } else if (z) {
                    lVar.z(u.this.B0((rect.centerY() - (n / 2)) / n));
                }
                int i2 = this.b;
                if (i2 != 0) {
                    lVar.v(i2, 0.0f, 0.0f, 1.0f);
                }
                int E0 = u.E0(this.b, rect.width(), rect.height());
                int E02 = u.E0(this.b, rect.height(), rect.width());
                this.c.a(lVar, (-E0) / 2, (-E02) / 2, E0, E02);
                if (e()) {
                    u.this.q();
                }
                if (this.f6684h == 2) {
                    u.this.u0(lVar);
                }
                lVar.b();
                if (this.f6684h != 2 && this.f6682f) {
                    u.this.w0(lVar, f2, f3, false);
                }
                return false;
            }
            this.c.b();
            return false;
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public boolean d() {
            return this.f6683g;
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public int getRotation() {
            return this.b;
        }

        @Override // com.pinguo.camera360.gallery.ui.u.f
        public h getSize() {
            return this.f6685i;
        }
    }

    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    public static class h {
        public int a;
        public int b;
    }

    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    public interface i {
        void a();

        void b();

        void c();

        void d();

        void f();

        void i();

        void j(boolean z);

        boolean k();

        void m(int i2, int i3);

        boolean o();

        void p();

        void q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoView.java */
    /* loaded from: classes3.dex */
    public static class j {
        private float a;

        public j(float f2) {
            this.a = f2;
        }

        public float a(float f2) {
            float f3 = this.a;
            return (1.0f - (f3 / (f2 + f3))) / (1.0f - (f3 / (f3 + 1.0f)));
        }
    }

    public u(com.pinguo.camera360.gallery.l lVar) {
        com.pinguo.album.views.c cVar = new com.pinguo.album.views.c(lVar.a(), lVar.G());
        this.C = cVar;
        c(cVar);
        Context a2 = lVar.a();
        this.R = a2;
        this.A = com.pinguo.album.opengles.t.K(a2.getString(R.string.loading), 20.0f, -1);
        this.B = com.pinguo.album.opengles.t.K("", 20.0f, -1);
        this.D = new e(lVar.E());
        d dVar = new d(this.R);
        this.u = dVar;
        this.v = new com.pinguo.album.views.utils.d(this.R, dVar);
        this.w = new PositionController(this.R);
        this.x = new a();
        for (int i2 = -2; i2 <= 2; i2++) {
            if (i2 == 0) {
                this.s.b(i2, new b());
            } else {
                this.s.b(i2, new g(i2));
            }
        }
        this.m = new com.pinguo.album.opengles.r(this.R, R.drawable.gg_ic_video_play);
        this.n = new com.pinguo.album.opengles.r(this.R, R.drawable.gg_ic_video_play_on);
        this.o = this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float B0(float f2) {
        float f3 = f2 / 0.5f;
        return com.pinguo.album.j.a.d(f3 > 0.0f ? 1.0f - f3 : f3 + 1.0f, 0.03f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C0() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E0(int i2, int i3, int i4) {
        return i2 % BaseBlurEffect.ROTATION_180 == 0 ? i3 : i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float F0(float f2) {
        if (f2 < 0.0f) {
            return this.r.getInterpolation(1.0f - Math.abs(f2));
        }
        return 1.0f;
    }

    static /* synthetic */ int G(u uVar, int i2) {
        int i3 = i2 & uVar.O;
        uVar.O = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float G0(float f2) {
        float a2 = this.q.a(Math.abs(f2));
        return (1.0f - a2) + (a2 * U);
    }

    static /* synthetic */ int H(u uVar, int i2) {
        int i3 = i2 | uVar.O;
        uVar.O = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float H0(float f2, float f3, float f4) {
        return f3 + ((f4 - f3) * f2 * f2);
    }

    private void I0(int i2) {
        this.z.m(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(boolean z) {
        if (this.F == z) {
            return;
        }
        this.F = z;
        this.w.u0(z);
        this.z.p(!z);
        this.z.f(this.F ? 1 : 0);
        if (z) {
            return;
        }
        this.y.f();
    }

    private void P0(int i2) {
        this.w.v0(i2, this.s.a(i2).getSize(), null);
    }

    private boolean T0() {
        if (this.N <= 0) {
            return false;
        }
        us.pinguo.common.log.a.k("  slideToNextPicture:", new Object[0]);
        b1();
        this.w.E0();
        return true;
    }

    private boolean U0() {
        if (this.M >= 0) {
            return false;
        }
        us.pinguo.common.log.a.k("  slideToPrevPicture:", new Object[0]);
        c1();
        this.w.E0();
        return true;
    }

    private boolean V0() {
        if (this.F) {
            return false;
        }
        Rect R = this.w.R(0);
        int p = p();
        int x0 = x0(R.width(), p) + 256;
        if (p - R.right > x0) {
            return T0();
        }
        if (R.left > x0) {
            return U0();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        if (V0()) {
            return;
        }
        this.w.B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X0(float f2, float f3) {
        if (this.F) {
            return false;
        }
        PositionController positionController = this.w;
        boolean d0 = positionController.d0();
        int L = positionController.L();
        if (d0 || Math.abs(f3) <= Math.abs(f2) || !((L & 4) == 0 || (L & 8) == 0)) {
            if (f2 >= -300.0f || (!d0 && (L & 2) == 0)) {
                if (f2 <= 300.0f || (!d0 && (L & 1) == 0)) {
                    return false;
                }
                return U0();
            }
            return T0();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        if (this.O != 0) {
            return;
        }
        int Z0 = Z0();
        if (Z0 == -1) {
            c1();
        } else if (Z0 != 1) {
        } else {
            b1();
        }
    }

    private int Z0() {
        Rect R = this.w.R(0);
        int p = p() / 2;
        if (R.left > p && this.M < 0) {
            Rect R2 = this.w.R(-1);
            if (p - R2.right < R.left - p) {
                return -1;
            }
        } else if (R.right < p && this.N > 0) {
            Rect R3 = this.w.R(1);
            if (R3.left - p < p - R.right) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(int i2, int i3) {
        if (this.M < 0 && this.w.R(-1).right >= i2) {
            U0();
        } else if (this.N <= 0 || this.w.R(1).left > i2) {
        } else {
            T0();
        }
    }

    private void b1() {
        I0(this.z.d() + 1);
    }

    private void c1() {
        I0(this.z.d() - 1);
    }

    private void d1() {
        int p = p();
        int n = n();
        int i2 = this.I;
        if (i2 % BaseBlurEffect.ROTATION_180 == 0) {
            n = p;
            p = n;
        }
        Rect rect = this.K;
        int i3 = rect.left;
        int i4 = rect.top;
        int i5 = rect.right;
        int i6 = rect.bottom;
        if (i2 == 0) {
            this.L.set(i3, i4, i5, i6);
        } else if (i2 == 90) {
            this.L.set(p - i6, i3, p - i4, i5);
        } else if (i2 == 180) {
            this.L.set(n - i5, p - i6, n - i3, p - i4);
        } else if (i2 == 270) {
            this.L.set(i4, n - i5, i6, n - i3);
        }
        us.pinguo.common.log.a.c("compensation = " + this.I + ", CameraRelativeFrame = " + this.K + ", mCameraRect = " + this.L, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float s0(int i2, int i3, int i4) {
        int i5;
        float f2;
        int i6 = i3 - i2;
        if (i6 < i4) {
            int i7 = (i4 / 2) - (i6 / 2);
            if (i2 > i7) {
                f2 = -(i2 - i7);
            } else {
                f2 = i2 - i7;
                i4 = -i6;
            }
            i4 -= i7;
        } else {
            if (i2 > 0) {
                i5 = -i2;
            } else if (i3 >= i4) {
                return 0.0f;
            } else {
                i5 = i4 - i3;
            }
            f2 = i5;
        }
        return f2 / i4;
    }

    private void t0() {
        if (!this.F || this.D.hasMessages(3) || Z0() == 0) {
            return;
        }
        this.D.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(com.pinguo.album.opengles.l lVar) {
        com.pinguo.album.opengles.t tVar = this.B;
        tVar.c(lVar, (-tVar.getWidth()) / 2, (-tVar.getHeight()) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(com.pinguo.album.opengles.l lVar, Rect rect) {
        lVar.g(rect.left, rect.top, rect.width(), rect.height(), 861954144);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(com.pinguo.album.opengles.l lVar, float f2, float f3, boolean z) {
        lVar.s(2);
        if (!this.F && z) {
            lVar.a(p() / 2, n() / 2);
        } else {
            lVar.a(f2, f3);
        }
        com.pinguo.album.opengles.u uVar = this.o;
        uVar.c(lVar, (-uVar.getWidth()) / 2, (-this.o.getHeight()) / 2);
        lVar.b();
    }

    private static int x0(int i2, int i3) {
        return Math.max(0, (i3 - i2) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y0() {
        return ((this.I - this.H) + BaseBlurEffect.ROTATION_360) % BaseBlurEffect.ROTATION_360;
    }

    public boolean A0() {
        return this.G;
    }

    public Rect D0(int i2) {
        return this.w.R(i2);
    }

    public void J0(int[] iArr, int i2, int i3) {
        this.M = i2;
        this.N = i3;
        int i4 = this.P;
        if (i4 != Integer.MAX_VALUE) {
            this.P = Integer.MAX_VALUE;
            int i5 = 0;
            while (true) {
                if (i5 >= 5) {
                    break;
                } else if (iArr[i5] == i4) {
                    this.P = i5 - 2;
                    break;
                } else {
                    i5++;
                }
            }
        }
        for (int i6 = -2; i6 <= 2; i6++) {
            f a2 = this.s.a(i6);
            a2.a();
            this.t[i6 + 2] = a2.getSize();
        }
        if (this.f6661l) {
            iArr[0] = Integer.MAX_VALUE;
            this.f6661l = false;
            this.D.obtainMessage(6).sendToTarget();
        }
        this.w.j0(iArr, this.M < 0, this.N > 0, false, this.t);
        for (int i7 = -2; i7 <= 2; i7++) {
            P0(i7);
        }
        q();
    }

    public void K0(int i2) {
        if (i2 == 0) {
            this.y.p();
        }
        this.s.a(i2).a();
        P0(i2);
        q();
    }

    public void L0() {
        this.w.w0(null);
        this.w.y0();
        this.C.P();
        for (int i2 = -2; i2 <= 2; i2++) {
            this.s.a(i2).b(null);
        }
    }

    public void M0() {
        this.w.w0(this.x);
        this.C.b0();
    }

    public void O0(c cVar) {
        this.z = cVar;
        this.C.f0(cVar);
    }

    public void Q0(boolean z) {
        this.T = z;
    }

    public void R0(boolean z) {
        this.S = z;
    }

    public void S0(i iVar) {
        this.y = iVar;
    }

    public s r0(com.pinguo.album.views.a aVar, com.pinguo.album.opengles.l lVar, int i2) {
        int i3;
        com.pinguo.album.opengles.q qVar;
        u uVar = this;
        Rect rect = new Rect();
        com.pinguo.album.j.a.a(aVar.j(uVar, rect));
        Rect e2 = e();
        s sVar = new s(i2);
        int i4 = -2;
        while (i4 <= 2) {
            com.pinguo.camera360.gallery.data.w g2 = uVar.z.g(i4);
            if (g2 != null) {
                com.pinguo.album.opengles.s c2 = uVar.z.c(i4);
                if ((c2 instanceof com.pinguo.album.opengles.b) && ((!((com.pinguo.album.opengles.b) c2).f() || g2.l()) && (uVar.F || i4 == 0))) {
                    Rect rect2 = new Rect(uVar.D0(i4));
                    if (Rect.intersects(e2, rect2)) {
                        rect2.offset(rect.left, rect.top);
                        int width = c2.getWidth();
                        int height = c2.getHeight();
                        int e3 = uVar.z.e(i4);
                        if (i4 == 0) {
                            int rotation = e3 - uVar.s.a(0).getRotation();
                            while (true) {
                                if (rotation >= -180 && rotation <= 180) {
                                    break;
                                } else if (rotation < -180) {
                                    rotation += BaseBlurEffect.ROTATION_360;
                                } else if (rotation > 180) {
                                    rotation -= 360;
                                }
                            }
                            i3 = rotation;
                            e3 = uVar.s.a(0).getRotation();
                        } else {
                            i3 = 0;
                        }
                        if (e3 % BaseBlurEffect.ROTATION_180 == 0) {
                            qVar = new com.pinguo.album.opengles.q(width, height, true);
                            lVar.q(qVar);
                            lVar.a(width / 2.0f, height / 2.0f);
                        } else {
                            qVar = new com.pinguo.album.opengles.q(height, width, true);
                            lVar.q(qVar);
                            lVar.a(height / 2.0f, width / 2.0f);
                        }
                        lVar.v(e3, 0.0f, 0.0f, 1.0f);
                        lVar.a((-width) / 2.0f, (-height) / 2.0f);
                        c2.a(lVar, 0, 0, width, height);
                        lVar.w();
                        sVar.m(g2.g(), rect2, qVar, i3);
                    }
                }
            }
            i4++;
            uVar = this;
        }
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.views.a
    public void v(boolean z, int i2, int i3, int i4, int i5) {
        this.C.r(0, 0, i4 - i2, i5 - i3);
        com.pinguo.album.views.b m = m();
        int b2 = m.b();
        int a2 = m.a();
        if (this.H != b2 || this.I != a2) {
            this.H = b2;
            this.I = a2;
        }
        d1();
        us.pinguo.common.log.a.k(" setConstrainedFrame:" + this.L, new Object[0]);
        this.w.s0(this.L);
        if (z) {
            this.w.x0(p(), n());
        }
    }

    @Override // com.pinguo.album.views.a
    protected boolean w(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3 || action == 4) {
                this.o = this.m;
                q();
            }
        } else if (this.z.a(0) && c0.C0((int) motionEvent.getX(), (int) motionEvent.getY(), this)) {
            this.o = this.n;
            q();
        } else {
            this.o = this.m;
            q();
        }
        this.v.c(motionEvent);
        return true;
    }

    @Override // com.pinguo.album.views.a
    public void y(com.pinguo.album.opengles.l lVar) {
        boolean z;
        boolean z2 = false;
        if (this.p) {
            this.s.a(0).a();
            P0(0);
            this.p = false;
        }
        int i2 = 1;
        boolean z3 = !this.F && this.w.f0();
        if (z3 != this.J) {
            this.J = z3;
            this.y.j(z3);
        }
        if (this.J) {
            i2 = 0;
        } else {
            boolean z4 = this.w.K() == 0.0f;
            boolean z5 = (this.O & 2) != 0;
            if (!z4 || z5) {
                i2 = 2;
            }
        }
        if ((this.s.a(0) instanceof b) && (((b) this.s.a(0)).f() || this.u.k())) {
            z = this.s.a(0).c(lVar, this.w.R(0));
        } else {
            for (int i3 = i2; i3 >= (-i2); i3--) {
                z2 |= this.s.a(i3).c(lVar, this.w.R(i3));
            }
            z = z2;
        }
        this.w.z();
        if (z) {
            q();
        }
        t0();
    }

    public boolean z0() {
        return this.F;
    }
}
