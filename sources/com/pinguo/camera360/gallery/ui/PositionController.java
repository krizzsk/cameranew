package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Rect;
import com.pinguo.camera360.gallery.ui.u;
import com.pinguo.camera360.gallery.util.OverScroller;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.foundation.utils.n0;
/* loaded from: classes3.dex */
public class PositionController {
    private static final int[] A = {0, 0, 100, IjkMediaCodecInfo.RANK_SECURE, IjkMediaCodecInfo.RANK_SECURE, 0, 0, 0, 0, 700};
    private static final int[] B = new int[5];
    private static final int C = n0.c(16);
    private static final int D = n0.c(12);
    boolean a;

    /* renamed from: d  reason: collision with root package name */
    private f f6469d;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6472g;

    /* renamed from: h  reason: collision with root package name */
    private float f6473h;

    /* renamed from: i  reason: collision with root package name */
    private float f6474i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6475j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6476k;
    private OverScroller m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean b = false;
    private boolean c = false;

    /* renamed from: e  reason: collision with root package name */
    private int f6470e = 1200;

    /* renamed from: f  reason: collision with root package name */
    private int f6471f = 1200;
    private Rect r = new Rect();
    private boolean s = true;
    private g t = new g();
    private com.pinguo.album.j.g<c> u = new com.pinguo.album.j.g<>(-2, 2);
    private com.pinguo.album.j.g<e> v = new com.pinguo.album.j.g<>(-2, 1);
    private d w = new d();
    private com.pinguo.album.j.g<c> x = new com.pinguo.album.j.g<>(-2, 2);
    private com.pinguo.album.j.g<e> y = new com.pinguo.album.j.g<>(-2, 1);
    private com.pinguo.album.j.g<Rect> z = new com.pinguo.album.j.g<>(-2, 2);

    /* renamed from: l  reason: collision with root package name */
    private com.pinguo.album.views.utils.c f6477l = new com.pinguo.album.views.utils.c();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class b {
        public long a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6478d;

        private b() {
            this.f6478d = true;
        }

        public boolean a() {
            long j2 = this.a;
            if (j2 == -1) {
                return false;
            }
            if (j2 == -2 && this.f6478d) {
                this.a = -1L;
                return c();
            }
            if (b(this.c == 0 ? 1.0f : ((float) (com.pinguo.album.animations.c.a() - this.a)) / this.c)) {
                this.a = -2L;
                return true;
            }
            return true;
        }

        protected abstract boolean b(float f2);

        public abstract boolean c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends b {

        /* renamed from: e  reason: collision with root package name */
        public int f6479e;

        /* renamed from: f  reason: collision with root package name */
        public int f6480f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6481g;

        /* renamed from: h  reason: collision with root package name */
        public float f6482h;

        /* renamed from: i  reason: collision with root package name */
        public float f6483i;

        /* renamed from: j  reason: collision with root package name */
        public int f6484j;

        /* renamed from: k  reason: collision with root package name */
        public int f6485k;

        /* renamed from: l  reason: collision with root package name */
        public int f6486l;
        public float m;
        public float n;
        public float o;
        public int p;

        private c() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f(int i2, float f2, int i3) {
            float e2 = e(f2);
            int i4 = this.f6484j;
            if (i4 == i2 && this.m == e2 && i3 != 9) {
                return false;
            }
            this.b = i3;
            this.f6485k = i4;
            this.n = this.m;
            this.f6486l = i2;
            this.o = e2;
            this.a = com.pinguo.album.animations.c.b();
            this.c = PositionController.A[i3];
            a();
            return true;
        }

        private boolean g(float f2) {
            PositionController.this.f6477l.a(f2);
            PositionController.this.B(this.m);
            int i2 = this.f6484j;
            this.f6484j = PositionController.this.f6477l.f();
            if (i2 <= PositionController.this.p || this.f6484j != PositionController.this.p) {
                if (i2 < PositionController.this.q && this.f6484j == PositionController.this.q) {
                    int d2 = (int) (PositionController.this.f6477l.d() + 0.5f);
                    if (PositionController.this.f6469d != null) {
                        PositionController.this.f6469d.a(d2, 0);
                    }
                }
            } else {
                int i3 = (int) ((-PositionController.this.f6477l.d()) + 0.5f);
                if (PositionController.this.f6469d != null) {
                    PositionController.this.f6469d.a(i3, 2);
                }
            }
            return f2 >= 1.0f;
        }

        private boolean h(float f2) {
            if (f2 >= 1.0f) {
                this.f6484j = this.f6486l;
                this.m = this.o;
                return true;
            }
            int i2 = this.f6485k;
            int i3 = this.f6486l;
            int i4 = (int) (i2 + ((i3 - i2) * f2));
            this.f6484j = i4;
            float f3 = this.n;
            float f4 = this.o;
            float f5 = f3 + ((f4 - f3) * f2);
            this.m = f5;
            if (this.b != 9) {
                return i4 == i3 && f5 == f4;
            }
            this.m *= com.pinguo.album.animations.e.a(f2);
            return false;
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.b
        protected boolean b(float f2) {
            if (this.b == 6) {
                return g(f2);
            }
            return h(f2);
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.b
        public boolean c() {
            float f2;
            int i2;
            if (this.a != -1) {
                return false;
            }
            if (this.b == 0 && PositionController.this.f6469d != null && PositionController.this.f6469d.c()) {
                return false;
            }
            if (this.b == 8 && PositionController.this.f6469d != null && PositionController.this.f6469d.d()) {
                return false;
            }
            if (PositionController.this.f6472g && this == PositionController.this.u.a(0)) {
                return false;
            }
            int i3 = this.f6484j;
            if (this == PositionController.this.u.a(0)) {
                f2 = com.pinguo.album.j.a.d(this.m, PositionController.this.b ? this.f6482h * 0.7f : this.f6482h, PositionController.this.b ? this.f6483i * 1.4f : this.f6483i);
                if (!PositionController.this.c) {
                    PositionController.this.C(f2, PositionController.D);
                    if (!PositionController.this.J0(f2)) {
                        i3 += (int) ((PositionController.this.f6474i * (this.m - f2)) + 0.5f);
                    }
                    i2 = com.pinguo.album.j.a.e(i3, PositionController.this.p, PositionController.this.q);
                    if (this.f6484j == i2 || this.m != f2) {
                        return f(i2, f2, 2);
                    }
                    return false;
                }
            } else {
                f2 = this.f6482h;
            }
            i2 = 0;
            if (this.f6484j == i2) {
            }
            return f(i2, f2, 2);
        }

        public float e(float f2) {
            return com.pinguo.album.j.a.d(f2, this.f6482h * 0.7f, this.f6483i * 1.4f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends b {

        /* renamed from: e  reason: collision with root package name */
        public float f6487e;

        /* renamed from: f  reason: collision with root package name */
        public float f6488f;

        /* renamed from: g  reason: collision with root package name */
        public float f6489g;

        private d() {
            super();
        }

        private boolean d(float f2, int i2) {
            this.b = i2;
            this.f6488f = this.f6487e;
            this.f6489g = f2;
            this.a = com.pinguo.album.animations.c.b();
            this.c = PositionController.A[this.b];
            a();
            return true;
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.b
        protected boolean b(float f2) {
            if (f2 >= 1.0f) {
                this.f6487e = this.f6489g;
                return true;
            }
            float f3 = this.f6488f;
            float f4 = this.f6489g;
            float f5 = f3 + (f2 * (f4 - f3));
            this.f6487e = f5;
            return f5 == f4;
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.b
        public boolean c() {
            float f2 = PositionController.this.c ? 1.0f : 0.0f;
            float f3 = this.f6489g;
            if (f2 == f3 && f2 == f3) {
                return false;
            }
            return d(f2, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class e extends b {

        /* renamed from: e  reason: collision with root package name */
        public int f6491e;

        /* renamed from: f  reason: collision with root package name */
        public int f6492f;

        /* renamed from: g  reason: collision with root package name */
        public int f6493g;

        /* renamed from: h  reason: collision with root package name */
        public int f6494h;

        private e(PositionController positionController) {
            super();
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.b
        protected boolean b(float f2) {
            if (f2 >= 1.0f) {
                this.f6492f = this.f6494h;
                return true;
            }
            int i2 = this.f6493g;
            int i3 = this.f6494h;
            int i4 = (int) (i2 + ((i3 - i2) * f2));
            this.f6492f = i4;
            if (this.b != 9) {
                return i4 == i3;
            }
            this.f6492f = (int) (this.f6492f * com.pinguo.album.animations.e.a(f2));
            return false;
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.b
        public boolean c() {
            if (this.a != -1) {
                return false;
            }
            return d(this.f6491e, 2);
        }

        public boolean d(int i2, int i3) {
            int i4 = this.f6492f;
            if (i4 != i2 || i3 == 9) {
                this.b = i3;
                this.f6493g = i4;
                this.f6494h = i2;
                this.a = com.pinguo.album.animations.c.b();
                this.c = PositionController.A[this.b];
                a();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(int i2, int i3);

        void b();

        boolean c();

        boolean d();

        void e(int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class g extends b {

        /* renamed from: e  reason: collision with root package name */
        public int f6495e;

        /* renamed from: f  reason: collision with root package name */
        public int f6496f;

        /* renamed from: g  reason: collision with root package name */
        public int f6497g;

        /* renamed from: h  reason: collision with root package name */
        public int f6498h;

        /* renamed from: i  reason: collision with root package name */
        public int f6499i;

        /* renamed from: j  reason: collision with root package name */
        public int f6500j;

        /* renamed from: k  reason: collision with root package name */
        public int f6501k;

        /* renamed from: l  reason: collision with root package name */
        public int f6502l;
        public int m;

        private g() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e(int i2, int i3, int i4) {
            int i5 = this.f6495e;
            if (i5 == i2 && this.f6499i == i3) {
                return false;
            }
            this.b = i4;
            this.f6496f = i5;
            this.f6500j = this.f6499i;
            this.f6497g = i2;
            this.f6501k = i3;
            this.a = com.pinguo.album.animations.c.b();
            this.c = PositionController.A[i4];
            this.m = 0;
            a();
            return true;
        }

        private boolean f(float f2) {
            int i2;
            PositionController.this.m.b();
            int g2 = PositionController.this.m.g() + this.m;
            this.f6495e = g2;
            int i3 = this.f6498h;
            if (g2 < i3) {
                if (!PositionController.this.f6476k) {
                    i2 = 3;
                }
                i2 = -1;
            } else {
                if (g2 > i3 && !PositionController.this.f6475j) {
                    i2 = 1;
                }
                i2 = -1;
            }
            if (i2 != -1) {
                int f3 = (int) (PositionController.this.m.f() + 0.5f);
                if (PositionController.this.f6469d != null) {
                    PositionController.this.f6469d.a(f3, i2);
                }
                PositionController.this.m.e(true);
                this.f6495e = this.f6498h;
            }
            return PositionController.this.m.k();
        }

        private boolean g(float f2) {
            PositionController.this.f6477l.a(f2);
            PositionController.this.B(((c) PositionController.this.u.a(0)).m);
            int i2 = this.f6495e;
            this.f6495e = PositionController.this.f6477l.e();
            if (i2 <= PositionController.this.n || this.f6495e != PositionController.this.n) {
                if (i2 < PositionController.this.o && this.f6495e == PositionController.this.o) {
                    int c = (int) (PositionController.this.f6477l.c() + 0.5f);
                    if (PositionController.this.f6469d != null) {
                        PositionController.this.f6469d.a(c, 1);
                    }
                }
            } else {
                int i3 = (int) ((-PositionController.this.f6477l.c()) + 0.5f);
                if (PositionController.this.f6469d != null) {
                    PositionController.this.f6469d.a(i3, 3);
                }
            }
            return f2 >= 1.0f;
        }

        private boolean h(float f2) {
            if (f2 >= 1.0f) {
                this.f6495e = this.f6497g;
                this.f6499i = this.f6501k;
                return true;
            }
            if (this.b == 9) {
                f2 = com.pinguo.album.animations.e.b(f2);
            }
            int i2 = this.f6496f;
            int i3 = this.f6497g;
            int i4 = (int) (i2 + ((i3 - i2) * f2));
            this.f6495e = i4;
            int i5 = this.f6500j;
            int i6 = this.f6501k;
            int i7 = (int) (i5 + (f2 * (i6 - i5)));
            this.f6499i = i7;
            return this.b != 9 && i4 == i3 && i7 == i6;
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.b
        protected boolean b(float f2) {
            int i2 = this.b;
            if (i2 == 6) {
                return g(f2);
            }
            if (i2 == 7) {
                return f(f2);
            }
            return h(f2);
        }

        @Override // com.pinguo.camera360.gallery.ui.PositionController.b
        public boolean c() {
            if (this.a != -1) {
                return false;
            }
            if ((this.b == 0 && PositionController.this.f6469d != null && PositionController.this.f6469d.c()) || PositionController.this.f6472g) {
                return false;
            }
            c cVar = (c) PositionController.this.u.a(0);
            float d2 = com.pinguo.album.j.a.d(cVar.m, PositionController.this.b ? cVar.f6482h * 0.7f : cVar.f6482h, PositionController.this.b ? cVar.f6483i * 1.4f : cVar.f6483i);
            int i2 = this.f6495e;
            int i3 = this.f6502l;
            if (!PositionController.this.c) {
                PositionController.this.C(d2, PositionController.D);
                if (!PositionController.this.K0(d2)) {
                    i2 += (int) ((PositionController.this.f6473h * (cVar.m - d2)) + 0.5f);
                }
                i2 = com.pinguo.album.j.a.e(i2, PositionController.this.n, PositionController.this.o);
            } else {
                int i4 = this.f6498h;
                if (!PositionController.this.f6476k) {
                    i2 = Math.max(i2, i4);
                }
                if (!PositionController.this.f6475j) {
                    i2 = Math.min(i2, i4);
                }
            }
            if (this.f6495e == i2 && this.f6499i == i3) {
                return false;
            }
            return e(i2, i3, 2);
        }

        public void i() {
            if (PositionController.this.s && !PositionController.this.r.isEmpty()) {
                this.f6498h = PositionController.this.r.centerX() - (PositionController.this.f6470e / 2);
                this.f6502l = PositionController.this.c ? 0 : PositionController.this.r.centerY() - (PositionController.this.f6471f / 2);
                return;
            }
            this.f6498h = 0;
            this.f6502l = 0;
        }
    }

    static {
        int i2 = 0;
        while (true) {
            int[] iArr = B;
            if (i2 >= iArr.length) {
                return;
            }
            int i3 = i2 + 1;
            int i4 = i3 / 2;
            if ((i2 & 1) == 0) {
                i4 = -i4;
            }
            iArr[i2] = i4;
            i2 = i3;
        }
    }

    public PositionController(Context context) {
        this.m = new OverScroller(context, null, false);
        b0();
        for (int i2 = -2; i2 <= 2; i2++) {
            this.u.b(i2, new c());
            X(i2);
            this.z.b(i2, new Rect());
        }
        for (int i3 = -2; i3 < 2; i3++) {
            this.v.b(i3, new e());
            Z(i3);
        }
    }

    private void A0() {
        this.t.c();
        for (int i2 = -2; i2 <= 2; i2++) {
            this.u.a(i2).c();
        }
        for (int i3 = -2; i3 < 2; i3++) {
            this.v.a(i3).c();
        }
        this.w.c();
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(float f2) {
        C(f2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f2, int i2) {
        c a2 = this.u.a(0);
        int M0 = M0(a2, f2);
        int U = U(a2, f2);
        int i3 = this.f6470e;
        this.n = (((i3 + 1) / 2) - ((M0 + 1) / 2)) - i2;
        this.o = ((M0 / 2) - (i3 / 2)) + i2;
        int i4 = this.f6471f;
        this.p = ((i4 + 1) / 2) - ((U + 1) / 2);
        this.q = (U / 2) - (i4 / 2);
        if (J0(f2)) {
            this.q = 0;
            this.p = 0;
        }
        if (K0(f2)) {
            int i5 = this.t.f6498h;
            this.o = i5;
            this.n = i5;
        }
    }

    private boolean C0(int i2, int i3, float f2, int i4) {
        us.pinguo.common.log.a.k("---startAnimation kind:" + i4, new Object[0]);
        g gVar = this.t;
        boolean e2 = gVar.e(i2, gVar.f6502l, i4) | false | this.u.a(0).f(i3, f2, i4);
        if (e2) {
            k0();
        }
        return e2;
    }

    private boolean D() {
        int i2;
        c a2 = this.u.a(0);
        return a2.a == -1 || (i2 = a2.b) == 0 || i2 == 6 || i2 == 7;
    }

    private void E(int i2) {
        c a2 = this.u.a(i2);
        Rect a3 = this.z.a(i2);
        int i3 = a2.f6484j + this.t.f6499i + (this.f6471f / 2);
        int L0 = L0(a2);
        int T = T(a2);
        if (i2 == 0) {
            int i4 = (this.t.f6495e + (this.f6470e / 2)) - (L0 / 2);
            a3.left = i4;
            a3.right = i4 + L0;
        } else if (i2 > 0) {
            int i5 = i2 - 1;
            int i6 = this.z.a(i5).right + this.v.a(i5).f6492f;
            a3.left = i6;
            a3.right = i6 + L0;
        } else {
            int i7 = this.z.a(i2 + 1).left - this.v.a(i2).f6492f;
            a3.right = i7;
            a3.left = i7 - L0;
        }
        int i8 = i3 - (T / 2);
        a3.top = i8;
        a3.bottom = i8 + T;
    }

    private boolean F0() {
        c a2 = this.u.a(0);
        if (a2.f6481g) {
            return false;
        }
        int i2 = this.f6470e;
        int i3 = this.f6471f;
        Rect rect = new Rect((i2 / 2) - 100, (i3 / 2) - 100, (i2 / 2) + 100, (i3 / 2) + 100);
        this.t.f6495e = rect.centerX() - (this.f6470e / 2);
        a2.f6484j = rect.centerY() - (this.f6471f / 2);
        a2.m = Math.max(rect.width() / a2.f6479e, rect.height() / a2.f6480f);
        C0(this.t.f6498h, 0, a2.f6482h, 5);
        for (int i4 = -1; i4 < 1; i4++) {
            e a3 = this.v.a(i4);
            a3.f6492f = this.f6470e;
            a3.d(a3.f6491e, 5);
        }
        return true;
    }

    private int I(c cVar) {
        return (int) (((this.f6470e - (Q(cVar) * cVar.f6479e)) / 2.0f) + 0.5f);
    }

    private void I0() {
        for (int i2 = -2; i2 <= 2; i2++) {
            c a2 = this.u.a(i2);
            a2.f6482h = Q(a2);
            a2.f6483i = P(a2);
        }
        for (int i3 = -2; i3 < 2; i3++) {
            this.v.a(i3).f6491e = J(i3);
        }
    }

    private int J(int i2) {
        if (this.c) {
            return C;
        }
        return C + Math.max(I(this.u.a(i2)), I(this.u.a(i2 + 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J0(float f2) {
        return this.f6471f >= U(this.u.a(0), f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K0(float f2) {
        return this.f6470e >= M0(this.u.a(0), f2);
    }

    private int L0(c cVar) {
        return (int) ((cVar.f6479e * cVar.m) + 0.5f);
    }

    private int M0(c cVar, float f2) {
        return (int) ((cVar.f6479e * f2) + 0.5f);
    }

    private float P(c cVar) {
        if (this.c) {
            return Q(cVar);
        }
        if (!this.s || this.r.isEmpty()) {
            return 6.0f;
        }
        return Q(cVar);
    }

    private float Q(c cVar) {
        int i2;
        int i3;
        if (!this.c && this.s && !this.r.isEmpty() && cVar == this.u.a(0)) {
            i2 = this.r.width();
            i3 = this.r.height();
        } else {
            i2 = this.f6470e;
            i3 = this.f6471f;
        }
        float f2 = 1.0f;
        float f3 = 0.7f;
        if (!this.c) {
            f3 = 1.0f;
        } else if (this.f6471f > this.f6470e) {
            f2 = 0.7f;
            f3 = 0.48f;
        } else {
            f2 = 0.7f;
        }
        return Math.min(6.0f, Math.min((f2 * i2) / cVar.f6479e, (f3 * i3) / cVar.f6480f));
    }

    private float S(c cVar) {
        return cVar.a == -1 ? cVar.m : cVar.o;
    }

    private int T(c cVar) {
        return (int) ((cVar.f6480f * cVar.m) + 0.5f);
    }

    private int U(c cVar, float f2) {
        return (int) ((cVar.f6480f * f2) + 0.5f);
    }

    private void X(int i2) {
        c a2 = this.u.a(i2);
        a2.f6479e = this.f6470e;
        a2.f6480f = this.f6471f;
        a2.f6481g = true;
        a2.f6482h = Q(a2);
        a2.f6483i = P(a2);
        a2.f6484j = 0;
        a2.m = a2.f6482h;
        a2.a = -1L;
        a2.b = -1;
    }

    private void Y(int i2, u.h hVar) {
        if (hVar.a != 0 && hVar.b != 0) {
            c a2 = this.u.a(i2);
            a2.f6479e = hVar.a;
            a2.f6480f = hVar.b;
            a2.f6481g = false;
            a2.f6482h = Q(a2);
            a2.f6483i = P(a2);
            a2.f6484j = 0;
            a2.m = a2.f6482h;
            a2.a = -1L;
            a2.b = -1;
            return;
        }
        X(i2);
    }

    private void Z(int i2) {
        e a2 = this.v.a(i2);
        int J = J(i2);
        a2.f6491e = J;
        a2.f6492f = J;
        a2.a = -1L;
    }

    private void a0(int i2, int i3) {
        e a2 = this.v.a(i2);
        a2.f6491e = J(i2);
        a2.f6492f = i3;
        a2.a = -1L;
    }

    private void b0() {
        this.t.i();
        g gVar = this.t;
        gVar.f6495e = gVar.f6498h;
        gVar.f6499i = gVar.f6502l;
        gVar.a = -1L;
    }

    private static boolean c0(float f2, float f3) {
        float f4 = f2 - f3;
        if (f4 < 0.0f) {
            f4 = -f4;
        }
        return f4 < 0.02f;
    }

    private void i0() {
        for (int i2 = 0; i2 < 5; i2++) {
            E(B[i2]);
        }
    }

    private void k0() {
        i0();
        f fVar = this.f6469d;
        if (fVar != null) {
            fVar.b();
        }
    }

    private boolean r0(int i2, int i3, int i4, boolean z) {
        float f2;
        float f3;
        c a2 = this.u.a(i2);
        boolean z2 = a2.f6481g;
        if (z2 || !z) {
            a2.f6481g = z;
            int i5 = a2.f6479e;
            if (i3 == i5 && i4 == a2.f6480f) {
                return false;
            }
            if (i3 > i4) {
                f2 = i5;
                f3 = i3;
            } else {
                f2 = a2.f6480f;
                f3 = i4;
            }
            float f4 = f2 / f3;
            a2.f6479e = i3;
            a2.f6480f = i4;
            if ((z2 && !z) || !this.c) {
                a2.m = Q(a2);
                a2.a = -1L;
            } else {
                a2.m *= f4;
                a2.n *= f4;
                a2.o *= f4;
            }
            if (i2 == 0) {
                this.f6473h /= f4;
                this.f6474i /= f4;
                return true;
            }
            return true;
        }
        return false;
    }

    public void A(float f2, float f3) {
        float f4 = f2 - (this.f6470e / 2);
        float f5 = f3 - (this.f6471f / 2);
        c a2 = this.u.a(0);
        g gVar = this.t;
        this.f6472g = true;
        float f6 = f4 - gVar.f6495e;
        float f7 = a2.m;
        this.f6473h = (int) ((f6 / f7) + 0.5f);
        this.f6474i = (int) (((f5 - a2.f6484j) / f7) + 0.5f);
    }

    public void B0() {
        A0();
    }

    public boolean D0() {
        c a2 = this.u.a(0);
        if (a2.f6481g) {
            return false;
        }
        int i2 = this.f6470e;
        int i3 = this.f6471f;
        Rect rect = new Rect((i2 / 2) - 100, (i3 / 2) - 100, (i2 / 2) + 100, (i3 / 2) + 100);
        this.t.f6495e = rect.centerX() - (this.f6470e / 2);
        a2.f6484j = rect.centerY() - (this.f6471f / 2);
        a2.m = Math.max(rect.width() / a2.f6479e, rect.height() / a2.f6480f);
        C0(this.t.f6498h, 0, a2.f6482h, 5);
        for (int i4 = -1; i4 < 1; i4++) {
            e a3 = this.v.a(i4);
            a3.f6492f = this.f6470e;
            a3.d(a3.f6491e, 5);
        }
        return true;
    }

    public void E0() {
        us.pinguo.common.log.a.k("  startHorizontalSlide:", new Object[0]);
        C0(this.t.f6498h, 0, this.u.a(0).f6482h, 3);
    }

    public void F() {
        this.f6472g = false;
        A0();
    }

    public boolean G(int i2) {
        if (i2 == 0) {
            return false;
        }
        c a2 = this.u.a(0);
        g gVar = this.t;
        int i3 = gVar.f6498h;
        if ((this.f6475j || gVar.f6495e < i3) && (this.f6476k || gVar.f6495e > i3)) {
            this.m.c(gVar.f6495e, 0, i2, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            return C0(this.m.i(), a2.f6484j, a2.m, 7);
        }
        return false;
    }

    public void G0() {
        this.t.a = -1L;
        for (int i2 = -2; i2 <= 2; i2++) {
            this.u.a(i2).a = -1L;
        }
        for (int i3 = -2; i3 < 2; i3++) {
            this.v.a(i3).a = -1L;
        }
    }

    public boolean H(int i2, int i3) {
        c a2 = this.u.a(0);
        g gVar = this.t;
        if (K0(a2.m) && J0(a2.m)) {
            return false;
        }
        int L = L();
        int i4 = ((i2 <= 0 || (L & 1) == 0) && (i2 >= 0 || (L & 2) == 0)) ? i2 : 0;
        int i5 = ((i3 <= 0 || (L & 4) == 0) && (i3 >= 0 || (L & 8) == 0)) ? i3 : 0;
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        this.f6477l.b(gVar.f6495e, a2.f6484j, i4, i5, this.n, this.o, this.p, this.q);
        int h2 = this.f6477l.h();
        int i6 = this.f6477l.i();
        A[6] = this.f6477l.g();
        return C0(h2, i6, a2.m, 6);
    }

    public void H0() {
        if (this.t.a == -1) {
            return;
        }
        if (this.c) {
            this.m.e(true);
        }
        g gVar = this.t;
        int i2 = gVar.f6495e;
        gVar.f6497g = i2;
        gVar.f6496f = i2;
    }

    public float K() {
        return this.w.f6487e;
    }

    public int L() {
        c a2 = this.u.a(0);
        g gVar = this.t;
        B(a2.m);
        int i2 = gVar.f6495e;
        int i3 = i2 <= this.n ? 2 : 0;
        if (i2 >= this.o) {
            i3 |= 1;
        }
        int i4 = a2.f6484j;
        if (i4 <= this.p) {
            i3 |= 8;
        }
        return i4 >= this.q ? i3 | 4 : i3;
    }

    public int M() {
        return this.u.a(0).f6480f;
    }

    public float N() {
        return this.u.a(0).m;
    }

    public void N0(float f2, float f3, float f4) {
        float f5 = f2 - (this.f6470e / 2);
        float f6 = f3 - (this.f6471f / 2);
        c a2 = this.u.a(0);
        float f7 = f5 - this.t.f6495e;
        float f8 = a2.m;
        B(f4);
        C0(com.pinguo.album.j.a.e((int) (((-(f7 / f8)) * f4) + 0.5f), this.n, this.o), com.pinguo.album.j.a.e((int) (((-((f6 - a2.f6484j) / f8)) * f4) + 0.5f), this.p, this.q), com.pinguo.album.j.a.d(f4, a2.f6482h, a2.f6483i), 4);
    }

    public int O() {
        return this.u.a(0).f6479e;
    }

    public Rect R(int i2) {
        return this.z.a(i2);
    }

    public int V(int i2, int i3) {
        for (int i4 = 0; i4 < 5; i4++) {
            int i5 = B[i4];
            if (this.z.a(i5).contains(i2, i3)) {
                return i5;
            }
        }
        return Integer.MAX_VALUE;
    }

    public boolean W() {
        g gVar = this.t;
        return (gVar.b == 5 && gVar.a != -1) || (this.u.a(0).b == 5 && this.u.a(0).a != -1);
    }

    public boolean d0() {
        c a2 = this.u.a(0);
        return c0(a2.m, a2.f6482h);
    }

    public boolean e0() {
        c a2 = this.u.a(0);
        return a2.n == a2.m;
    }

    public boolean f0() {
        c a2 = this.u.a(0);
        g gVar = this.t;
        return gVar.f6495e == gVar.f6498h && a2.f6484j == 0;
    }

    public boolean g0() {
        g gVar = this.t;
        return (gVar.a == -1 || gVar.f6495e == gVar.f6497g) ? false : true;
    }

    public boolean h0() {
        g gVar = this.t;
        return Math.abs(gVar.f6495e - gVar.f6498h) < 10;
    }

    public void j0(int[] iArr, boolean z, boolean z2, boolean z3, u.h[] hVarArr) {
        int a2;
        this.f6475j = z;
        this.f6476k = z2;
        com.pinguo.album.j.h hVar = new com.pinguo.album.j.h(iArr, -2, 2);
        i0();
        for (int i2 = -2; i2 <= 2; i2++) {
            this.u.a(i2).p = this.z.a(i2).centerX() - (this.f6470e / 2);
        }
        for (int i3 = -2; i3 <= 2; i3++) {
            this.x.b(i3, this.u.a(i3));
            this.u.b(i3, null);
        }
        for (int i4 = -2; i4 < 2; i4++) {
            this.y.b(i4, this.v.a(i4));
            this.v.b(i4, null);
        }
        for (int i5 = -2; i5 <= 2; i5++) {
            int a3 = hVar.a(i5);
            if (a3 != Integer.MAX_VALUE) {
                this.u.b(i5, this.x.a(a3));
                this.x.b(a3, null);
            }
        }
        for (int i6 = -2; i6 < 2; i6++) {
            int a4 = hVar.a(i6);
            if (a4 != Integer.MAX_VALUE && (a2 = hVar.a(i6 + 1)) != Integer.MAX_VALUE && a4 + 1 == a2) {
                this.v.b(i6, this.y.a(a4));
                this.y.b(a4, null);
            }
        }
        int i7 = -2;
        for (int i8 = -2; i8 <= 2; i8++) {
            if (this.u.a(i8) == null) {
                while (this.x.a(i7) == null) {
                    i7++;
                }
                this.u.b(i8, this.x.a(i7));
                Y(i8, hVarArr[i8 + 2]);
                i7++;
            }
        }
        int i9 = -2;
        while (i9 <= 2 && hVar.a(i9) == Integer.MAX_VALUE) {
            i9++;
        }
        int i10 = 2;
        while (i10 >= -2 && hVar.a(i10) == Integer.MAX_VALUE) {
            i10--;
        }
        if (i9 > 2) {
            this.u.a(0).p = this.t.f6495e;
            i9 = 0;
            i10 = 0;
        }
        for (int max = Math.max(0, i9 + 1); max < i10; max++) {
            if (hVar.a(max) == Integer.MAX_VALUE) {
                c a5 = this.u.a(max - 1);
                c a6 = this.u.a(max);
                int L0 = L0(a5);
                a6.p = a5.p + (L0 - (L0 / 2)) + (L0(a6) / 2) + J(max);
                if (this.a) {
                    a6.f6484j = -((this.f6471f / 2) + (T(a6) / 2));
                } else {
                    a6.f6484j = (this.f6471f / 2) + (T(a6) / 2);
                }
            }
        }
        for (int min = Math.min(-1, i10 - 1); min > i9; min--) {
            if (hVar.a(min) == Integer.MAX_VALUE) {
                c a7 = this.u.a(min + 1);
                c a8 = this.u.a(min);
                int L02 = L0(a7);
                int L03 = L0(a8);
                a8.p = ((a7.p - (L02 / 2)) - (L03 - (L03 / 2))) - J(min);
                if (this.a) {
                    a8.f6484j = -((this.f6471f / 2) + (T(a8) / 2));
                } else {
                    a8.f6484j = (this.f6471f / 2) + (T(a8) / 2);
                }
            }
        }
        int i11 = -2;
        for (int i12 = -2; i12 < 2; i12++) {
            if (this.v.a(i12) == null) {
                while (this.y.a(i11) == null) {
                    i11++;
                }
                int i13 = i11 + 1;
                this.v.b(i12, this.y.a(i11));
                c a9 = this.u.a(i12);
                c a10 = this.u.a(i12 + 1);
                int L04 = L0(a9);
                int L05 = L0(a10);
                if (i12 >= i9 && i12 < i10) {
                    a0(i12, ((a10.p - a9.p) - (L05 / 2)) - (L04 - (L04 / 2)));
                } else {
                    Z(i12);
                }
                i11 = i13;
            }
        }
        for (int i14 = i9 - 1; i14 >= -2; i14--) {
            c a11 = this.u.a(i14 + 1);
            c a12 = this.u.a(i14);
            int L06 = L0(a11);
            int L07 = L0(a12);
            a12.p = ((a11.p - (L06 / 2)) - (L07 - (L07 / 2))) - this.v.a(i14).f6492f;
        }
        while (true) {
            i10++;
            if (i10 > 2) {
                break;
            }
            int i15 = i10 - 1;
            c a13 = this.u.a(i15);
            c a14 = this.u.a(i10);
            int L08 = L0(a13);
            a14.p = a13.p + (L08 - (L08 / 2)) + (L0(a14) / 2) + this.v.a(i15).f6492f;
        }
        int i16 = this.u.a(0).p;
        g gVar = this.t;
        int i17 = gVar.f6495e;
        int i18 = i16 - i17;
        gVar.f6495e = i17 + i18;
        gVar.f6496f += i18;
        gVar.f6497g += i18;
        gVar.m += i18;
        if (this.s != z3) {
            this.s = z3;
            gVar.i();
            I0();
        }
        A0();
    }

    public void l0() {
        C0(this.t.f6498h, 0, this.u.a(0).f6482h, 4);
    }

    public int m0(float f2, float f3, float f4) {
        float f5 = f3 - (this.f6470e / 2);
        float f6 = f4 - (this.f6471f / 2);
        c a2 = this.u.a(0);
        g gVar = this.t;
        float e2 = a2.e(f2 * S(a2));
        boolean z = this.c;
        C0(z ? gVar.f6495e : (int) ((f5 - (this.f6473h * e2)) + 0.5f), z ? a2.f6484j : (int) ((f6 - (this.f6474i * e2)) + 0.5f), e2, 1);
        if (e2 < a2.f6482h) {
            return -1;
        }
        return e2 > a2.f6483i ? 1 : 0;
    }

    public void n0(int i2, float f2) {
        if (D()) {
            c a2 = this.u.a(0);
            a2.f(a2.f6484j + i2, a2.f6482h * f2, 0);
            k0();
        }
    }

    public void o0(int i2) {
        int i3;
        if (D()) {
            c a2 = this.u.a(0);
            g gVar = this.t;
            if (a2.a == -1 || (i3 = a2.b) == 0 || i3 == 6 || i3 == 7) {
                int i4 = (gVar.f6495e + i2) - gVar.f6498h;
                if (!this.f6475j && i4 > 0) {
                    f fVar = this.f6469d;
                    if (fVar != null) {
                        fVar.e(i4, 1);
                    }
                } else {
                    if (!this.f6476k && i4 < 0) {
                        f fVar2 = this.f6469d;
                        if (fVar2 != null) {
                            fVar2.e(-i4, 3);
                        }
                    }
                    C0(i4 + this.t.f6498h, a2.f6484j, a2.m, 0);
                }
                i4 = 0;
                C0(i4 + this.t.f6498h, a2.f6484j, a2.m, 0);
            }
        }
    }

    public void p0(int i2, int i3) {
        if (D()) {
            c a2 = this.u.a(i2);
            a2.f(a2.f6484j + i3, a2.m, 0);
            k0();
        }
    }

    public void q0(int i2, int i3) {
        int i4;
        int i5;
        f fVar;
        if (D()) {
            c a2 = this.u.a(0);
            g gVar = this.t;
            B(a2.m);
            int i6 = gVar.f6495e + i2;
            int i7 = a2.f6484j + i3;
            int i8 = this.p;
            int i9 = this.q;
            if (i8 != i9) {
                if (i7 < i8) {
                    f fVar2 = this.f6469d;
                    if (fVar2 != null) {
                        fVar2.e(i8 - i7, 2);
                    }
                } else if (i7 > i9 && (fVar = this.f6469d) != null) {
                    fVar.e(i7 - i9, 0);
                }
            }
            int e2 = com.pinguo.album.j.a.e(i7, this.p, this.q);
            if (!this.f6475j && i6 > (i5 = this.o)) {
                int i10 = i6 - i5;
                f fVar3 = this.f6469d;
                if (fVar3 != null) {
                    fVar3.e(i10, 1);
                }
                i6 = this.o;
            } else if (!this.f6476k && i6 < (i4 = this.n)) {
                int i11 = i4 - i6;
                f fVar4 = this.f6469d;
                if (fVar4 != null) {
                    fVar4.e(i11, 3);
                }
                i6 = this.n;
            }
            C0(i6, e2, a2.m, 0);
        }
    }

    public void s0(Rect rect) {
        if (this.r.equals(rect)) {
            return;
        }
        this.r.set(rect);
        this.t.i();
        I0();
        A0();
    }

    public void t0(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        if (z) {
            return;
        }
        A0();
    }

    public void u0(boolean z) {
        if (z == this.c) {
            return;
        }
        this.c = z;
        this.t.i();
        I0();
        G0();
        A0();
    }

    public void v0(int i2, u.h hVar, Rect rect) {
        boolean z;
        if (hVar.a == 0 || hVar.b == 0) {
            return;
        }
        if (rect == null || this.r.equals(rect)) {
            z = false;
        } else {
            this.r.set(rect);
            this.t.i();
            z = true;
        }
        if (!r0(i2, hVar.a, hVar.b, false) && !z) {
            return;
        }
        I0();
        A0();
    }

    public void w0(f fVar) {
        this.f6469d = fVar;
    }

    public void x0(int i2, int i3) {
        if (i2 == this.f6470e && i3 == this.f6471f) {
            return;
        }
        boolean d0 = d0();
        this.f6470e = i2;
        this.f6471f = i3;
        b0();
        for (int i4 = -2; i4 <= 2; i4++) {
            r0(i4, i2, i3, true);
        }
        I0();
        if (d0) {
            c a2 = this.u.a(0);
            a2.m = a2.f6482h;
        }
        if (F0()) {
            return;
        }
        z0();
    }

    public void y0() {
        g gVar = this.t;
        if (gVar.a != -1) {
            gVar.f6495e = gVar.f6497g;
            gVar.f6499i = gVar.f6501k;
            gVar.a = -1L;
        }
        for (int i2 = -2; i2 <= 2; i2++) {
            c a2 = this.u.a(i2);
            if (a2.a != -1) {
                a2.f6484j = a2.f6486l;
                a2.m = a2.o;
                a2.a = -1L;
            }
        }
        for (int i3 = -2; i3 < 2; i3++) {
            e a3 = this.v.a(i3);
            if (a3.a != -1) {
                a3.f6492f = a3.f6494h;
                a3.a = -1L;
            }
        }
        k0();
    }

    public void z() {
        boolean a2 = this.t.a() | false;
        for (int i2 = -2; i2 <= 2; i2++) {
            if (this.u.a(i2) != null) {
                a2 |= this.u.a(i2).a();
            }
        }
        for (int i3 = -2; i3 < 2; i3++) {
            if (this.v.a(i3) != null) {
                a2 |= this.v.a(i3).a();
            }
        }
        if (a2 || this.w.a()) {
            k0();
        }
    }

    public void z0() {
        G0();
        A0();
        y0();
    }
}
