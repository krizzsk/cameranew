package com.pinguo.camera360.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.pinguo.album.common.d;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.g0;
import com.pinguo.camera360.gallery.ui.b0.a;
import com.pinguo.camera360.gallery.ui.m;
import com.pinguo.camera360.gallery.util.ScrollerHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* compiled from: SlotView.java */
/* loaded from: classes3.dex */
public class z extends com.pinguo.album.views.a {
    private com.pinguo.album.animations.h A;
    private com.pinguo.camera360.gallery.ui.b0.a B;
    private int C;
    private boolean D;
    private int E;
    private e F;
    private int[] G;
    private final Rect H;
    private com.pinguo.album.opengles.c I;
    private int J;
    private int K;
    private int L;
    private float M;
    private Rect N;
    private int O;
    private float P;
    private float Q;
    private float R;
    private b S;
    private final int T;
    private int U;
    private int V;
    private boolean W;
    private boolean X;
    private int Y;
    private final Handler Z;

    /* renamed from: l  reason: collision with root package name */
    private float f6695l;
    private AlbumScrollerIcon m;
    private boolean n;
    private t o;
    private final m p;
    private final com.pinguo.album.common.d q;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u;
    private final ScrollerHelper v;
    private final com.pinguo.album.views.utils.e w;
    private p x;
    private a0 y;
    private boolean z;

    /* compiled from: SlotView.java */
    /* loaded from: classes3.dex */
    class a implements Runnable {
        final /* synthetic */ a0 a;

        a(z zVar, a0 a0Var) {
            this.a = a0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SlotView.java */
    /* loaded from: classes3.dex */
    public class b extends com.pinguo.album.animations.b {

        /* renamed from: e  reason: collision with root package name */
        private int f6696e;

        /* renamed from: f  reason: collision with root package name */
        private float f6697f;

        /* renamed from: g  reason: collision with root package name */
        private float f6698g;

        /* renamed from: h  reason: collision with root package name */
        private float f6699h;

        /* renamed from: i  reason: collision with root package name */
        private int f6700i;

        /* renamed from: j  reason: collision with root package name */
        private float f6701j;

        /* renamed from: k  reason: collision with root package name */
        private float f6702k;

        /* renamed from: l  reason: collision with root package name */
        private float f6703l;
        private boolean m;
        private float n;

        public b(boolean z) {
            j(new DecelerateInterpolator());
            if (z.this.K0() == 1) {
                i(IjkMediaCodecInfo.RANK_SECURE);
            } else {
                i(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            }
            if (!z) {
                this.m = z.this.M > 0.3f;
            } else {
                this.m = true;
            }
            this.n = z.this.M;
            this.f6696e = z.this.O;
            while (true) {
                int i2 = this.f6696e;
                if (i2 >= -180 && i2 <= 180) {
                    break;
                } else if (i2 < -180) {
                    this.f6696e = i2 + BaseBlurEffect.ROTATION_360;
                } else if (i2 > 180) {
                    this.f6696e = i2 - 360;
                }
            }
            this.f6697f = z.this.P;
            this.f6698g = z.this.Q;
            this.f6699h = z.this.R;
            if (this.m) {
                this.f6700i = 0;
                this.f6702k = ((z.this.p() / 2.0f) + ((com.pinguo.album.views.a) z.this).f6113i) - z.this.N.centerX();
                this.f6703l = ((z.this.n() / 2.0f) + ((com.pinguo.album.views.a) z.this).f6112h) - z.this.N.centerY();
                float p = z.this.p() + z.this.B.r().f6712g + z.this.B.r().f6713h;
                float n = z.this.n() + z.this.B.r().f6714i + z.this.B.r().f6715j;
                if (z.this.J > 0 && z.this.K > 0 && z.this.J < p && z.this.K < n && Math.min(p / z.this.J, n / z.this.K) > 6.0f) {
                    p = z.this.J * 6.0f;
                    n = z.this.K * 6.0f;
                }
                this.f6701j = Math.min(p / z.this.N.width(), n / z.this.N.height());
                return;
            }
            this.f6700i = 0;
            this.f6702k = 0.0f;
            this.f6703l = 0.0f;
            this.f6701j = 1.0f;
        }

        @Override // com.pinguo.album.animations.b
        protected void e(float f2) {
            z zVar = z.this;
            int i2 = this.f6696e;
            zVar.O = Float.valueOf(i2 + ((this.f6700i - i2) * f2)).intValue();
            z zVar2 = z.this;
            float f3 = this.f6698g;
            zVar2.Q = f3 + ((this.f6702k - f3) * f2);
            z zVar3 = z.this;
            float f4 = this.f6699h;
            zVar3.R = f4 + ((this.f6703l - f4) * f2);
            z zVar4 = z.this;
            float f5 = this.f6697f;
            zVar4.P = f5 + ((this.f6701j - f5) * f2);
            if (this.m) {
                z zVar5 = z.this;
                float f6 = this.n;
                zVar5.M = f6 + ((1.0f - f6) * f2);
            } else {
                z zVar6 = z.this;
                float f7 = this.n;
                zVar6.M = f7 + ((-f7) * f2);
            }
            z.this.x.k(z.this.M);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.pinguo.album.animations.b
        public boolean g() {
            super.g();
            z.this.x.h(this.m, z.this.L, z.this.I);
            if (this.m) {
                z.this.J0(false);
                return false;
            }
            z.this.J0(true);
            return true;
        }
    }

    /* compiled from: SlotView.java */
    /* loaded from: classes3.dex */
    private class d extends com.pinguo.album.g {
        public d(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                us.pinguo.common.log.a.k("handleMessage mCurrentScaleRate = " + z.this.f6695l, new Object[0]);
                float f2 = z.this.t ? 0.1f : -0.1f;
                z.this.f6695l += f2;
                z zVar = z.this;
                zVar.f6695l = com.pinguo.album.j.a.d(zVar.f6695l, 0.0f, 1.0f);
                z.this.o1();
                z.this.q();
                if (z.this.f6695l <= 0.0f || z.this.f6695l >= 1.0f) {
                    z.this.v.g(((com.pinguo.camera360.gallery.ui.b0.g) z.this.B).R());
                } else {
                    sendEmptyMessageDelayed(1, 20L);
                }
            } else if (i2 != 2) {
                if (i2 == 3 && z.this.W) {
                    int i3 = z.this.V == 3 ? -message.arg1 : message.arg1;
                    if (i3 == 0) {
                        i3 = z.this.V == 3 ? 15 : -15;
                    }
                    z.this.v.h(Math.round(i3), 0, z.this.B.j());
                    List<Integer> h2 = z.this.B.h(0.0f, message.arg2);
                    if (h2 != null) {
                        z.this.x.d(h2);
                    }
                    z.this.q();
                    Message message2 = new Message();
                    message2.what = 3;
                    message2.arg2 = message.arg2;
                    z.this.Z.sendMessageDelayed(message2, 20L);
                }
            } else {
                z.this.m.I();
            }
        }
    }

    /* compiled from: SlotView.java */
    /* loaded from: classes3.dex */
    public interface e {
        int a(int i2);

        void b();

        Bitmap c(int i2, boolean z);

        void d(int i2, int i3);

        int e(int i2);

        int f(int i2);

        int g(com.pinguo.album.opengles.l lVar, int i2, int i3, int i4);

        int h(com.pinguo.album.opengles.l lVar, int i2, int i3, int i4, int i5);

        void i(int i2, int i3, int i4);

        void j(int i2, int i3);
    }

    /* compiled from: SlotView.java */
    /* loaded from: classes3.dex */
    public static class f {
        public int a = -1;
        public int b = -1;
        public int c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f6709d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f6710e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f6711f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f6712g = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f6713h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f6714i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f6715j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f6716k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f6717l = -1;
        public int m = -1;
    }

    public z(com.pinguo.camera360.gallery.l lVar, f fVar, com.pinguo.camera360.gallery.ui.b0.a aVar) {
        this.f6695l = 1.0f;
        this.r = true;
        this.s = false;
        this.t = false;
        this.w = new com.pinguo.album.views.utils.e();
        this.z = false;
        this.A = null;
        this.B = null;
        this.C = -1;
        this.E = 2;
        this.G = new int[16];
        this.H = new Rect();
        this.L = -1;
        this.M = 0.0f;
        this.N = new Rect();
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = -1;
        this.B = aVar;
        c cVar = new c(this, null);
        this.p = new m(lVar.a(), cVar);
        this.q = new com.pinguo.album.common.d(lVar.a(), cVar);
        this.v = new ScrollerHelper(lVar.a());
        this.T = lVar.a().getResources().getColor(R.color.photo_background_color);
        int i2 = g0.a(lVar.a()).b.f6563f;
        i1(fVar);
        this.m = new AlbumScrollerIcon(lVar.a());
        this.Z = new d(lVar.E());
        super.c(this.m);
    }

    private static int[] I0(int[] iArr, int i2) {
        while (iArr.length < i2) {
            iArr = new int[iArr.length * 2];
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(boolean z) {
        this.L = -1;
        com.pinguo.album.opengles.c cVar = this.I;
        if (cVar != null) {
            this.I = null;
            if (z) {
                cVar.o();
            }
        }
        this.S = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(Bitmap bitmap, int i2) {
        this.N.set(O0(this.L));
        this.I = new com.pinguo.album.opengles.c(bitmap);
        this.J = this.F.a(this.L);
        int f2 = this.F.f(this.L);
        this.K = f2;
        if (i2 == 90 || i2 == 270) {
            this.K = this.J;
            this.J = f2;
        }
        int centerX = this.N.centerX();
        int centerY = this.N.centerY();
        int width = this.N.width();
        int height = this.N.height();
        float width2 = this.I.getWidth();
        float f3 = (width2 * 1.0f) / width;
        float height2 = this.I.getHeight();
        float min = Math.min(f3, (height2 * 1.0f) / height);
        float f4 = centerX;
        float f5 = (width2 / min) / 2.0f;
        float f6 = centerY;
        float f7 = (height2 / min) / 2.0f;
        this.N.set((int) (f4 - f5), (int) (f6 - f7), (int) (f4 + f5), (int) (f6 + f7));
        this.Q = 0.0f;
        this.R = 0.0f;
        this.O = 0;
        this.P = 1.0f;
        this.M = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T0() {
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        return (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) || (aVar instanceof com.pinguo.camera360.gallery.ui.b0.d) || (aVar instanceof com.pinguo.camera360.gallery.ui.b0.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        float f2 = this.P;
        if (f2 < 1.0f) {
            this.P = 1.0f;
        } else if (f2 > 6.0f) {
            this.P = 6.0f;
        }
        float p = (p() * 1.0f) / this.N.width();
        if (p <= 1.0f) {
            this.M = 1.0f;
        } else {
            float f3 = (this.P - 1.0f) / (p - 1.0f);
            this.M = f3;
            this.M = com.pinguo.album.j.a.d(f3, 0.0f, 1.0f);
        }
        this.x.k(this.M);
    }

    private int Z0(com.pinguo.album.opengles.l lVar, int i2, int i3, boolean z, float f2) {
        lVar.s(3);
        int e2 = this.B.e();
        Rect g2 = this.B.g(i2, this.H);
        if (g2 != null) {
            g2 = new Rect(g2.left, g2.top - e2, g2.right, g2.bottom - e2);
        }
        Rect f3 = this.B.f(i2, this.H);
        if (f3 == null) {
            return 0;
        }
        int k2 = this.B.k();
        Rect rect = new Rect(f3.left, f3.top - k2, f3.right, f3.bottom - k2);
        float d2 = com.pinguo.album.j.a.d(1.0f - f2, 0.0f, 1.0f);
        int i4 = rect.left;
        int i5 = i4 + ((int) (((g2.left - i4) * d2) + 0.5f));
        rect.left = i5;
        int i6 = rect.top;
        int i7 = i6 + ((int) (((g2.top - i6) * d2) + 0.5f));
        rect.top = i7;
        int i8 = rect.right;
        rect.right = i8 + ((int) (((g2.right - i8) * d2) + 0.5f));
        int i9 = rect.bottom;
        rect.bottom = i9 + ((int) (((g2.bottom - i9) * d2) + 0.5f));
        if (z) {
            lVar.j(this.w.c(false, rect, k2), 0);
        } else {
            lVar.p(i5, i7, 0.0f);
        }
        com.pinguo.album.animations.h hVar = this.A;
        if (hVar != null && hVar.d()) {
            this.A.m(lVar, i2, rect);
        }
        lVar.setAlpha(d2);
        int g3 = this.F.g(lVar, i2, rect.width(), rect.height());
        lVar.b();
        return g3;
    }

    private void a1(com.pinguo.album.opengles.l lVar, int i2, Rect rect, float f2) {
        float f3 = 0.5f + f2;
        if (f2 > 0.0f) {
            f2 = f3;
        }
        float d2 = com.pinguo.album.j.a.d(f2, 0.0f, 1.0f);
        int e2 = this.B.e();
        lVar.s(3);
        lVar.setAlpha(1.0f - d2);
        Rect rect2 = new Rect(rect.left, rect.top - e2, rect.right, rect.bottom - e2);
        lVar.p(rect2.left, rect2.top, 0.0f);
        this.F.h(lVar, i2, rect2.width(), rect2.height(), l.p);
        lVar.b();
    }

    private int b1(com.pinguo.album.opengles.l lVar, int i2, int i3, boolean z, float f2) {
        lVar.s(3);
        Rect q = this.B.q(i2, this.H);
        int e2 = this.B.e();
        Rect i4 = this.B.i(i2, this.H);
        if (i4 != null) {
            i4 = new Rect(i4.left, i4.top - e2, i4.right, i4.bottom - e2);
        }
        if (q == null) {
            return 0;
        }
        int k2 = this.B.k();
        Rect rect = new Rect(q.left, q.top - k2, q.right, q.bottom - k2);
        float f3 = 1.0f;
        float d2 = com.pinguo.album.j.a.d(f2, 0.0f, 1.0f);
        if (i4 != null && i4.width() != 0) {
            float f4 = 1.0f - d2;
            int i5 = rect.left;
            rect.left = i5 + ((int) (((i4.left - i5) * f4) + 0.5f));
            int i6 = rect.top;
            rect.top = i6 + ((int) (((i4.top - i6) * f4) + 0.5f));
            int i7 = rect.right;
            rect.right = i7 + ((int) (((i4.right - i7) * f4) + 0.5f));
            int i8 = rect.bottom;
            rect.bottom = i8 + ((int) (((i4.bottom - i8) * f4) + 0.5f));
            f3 = d2;
        } else {
            rect.left = (int) (rect.left * d2);
            rect.top = (int) (rect.top * d2);
            rect.right = (int) (rect.right * d2);
            rect.bottom = (int) (rect.bottom * d2);
        }
        if (z) {
            lVar.j(this.w.c(false, rect, k2), 0);
        } else {
            lVar.p(rect.left, rect.top, 0.0f);
        }
        com.pinguo.album.animations.h hVar = this.A;
        if (hVar != null && hVar.d()) {
            this.A.m(lVar, i2, rect);
        }
        lVar.setAlpha(f3);
        int g2 = this.F.g(lVar, i2, rect.width(), rect.height());
        lVar.b();
        return g2;
    }

    private void c1(com.pinguo.album.opengles.l lVar, int i2, Rect rect, float f2) {
        float f3 = f2 - 0.5f;
        if (f2 < 1.0f) {
            f2 = f3;
        }
        float d2 = com.pinguo.album.j.a.d(f2, 0.0f, 1.0f);
        lVar.s(3);
        lVar.setAlpha(d2);
        int k2 = this.B.k();
        Rect rect2 = new Rect(rect.left, rect.top - k2, rect.right, rect.bottom - k2);
        lVar.p(rect2.left, rect2.top, 0.0f);
        this.F.h(lVar, i2, rect2.width(), rect2.height(), l.o);
        lVar.b();
    }

    static /* synthetic */ float e0(z zVar, float f2) {
        float f3 = zVar.Q + f2;
        zVar.Q = f3;
        return f3;
    }

    static /* synthetic */ float h0(z zVar, float f2) {
        float f3 = zVar.R + f2;
        zVar.R = f3;
        return f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        us.pinguo.common.log.a.k("renderBelowItem isZoomInSlot = " + this.t + " mCurrentScaleRate = " + this.f6695l, new Object[0]);
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
            com.pinguo.camera360.gallery.ui.b0.g gVar = (com.pinguo.camera360.gallery.ui.b0.g) aVar;
            boolean z = this.t;
            if (z && this.f6695l >= 1.0f) {
                gVar.J = 0;
                this.x.a();
            } else if (z || this.f6695l > 0.0f) {
            } else {
                gVar.J = 1;
                this.x.a();
            }
        }
    }

    static /* synthetic */ int q0(z zVar, float f2) {
        int i2 = (int) (zVar.O - f2);
        zVar.O = i2;
        return i2;
    }

    private void r1(int i2, boolean z) {
        if (z || i2 != this.f6112h) {
            this.f6112h = i2;
            this.B.F(i2);
            X0(i2);
            if (this.n) {
                return;
            }
            this.m.N((int) ((((n() - this.m.n()) - this.U) / this.B.j()) * i2));
        }
    }

    public int K0() {
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
            return ((com.pinguo.camera360.gallery.ui.b0.g) aVar).J;
        }
        return -1;
    }

    public int L0() {
        return this.f6113i;
    }

    public int M0() {
        return this.f6112h;
    }

    public SparseArray<a.C0242a> N0() {
        return this.B.p();
    }

    public Rect O0(int i2) {
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
            com.pinguo.camera360.gallery.ui.b0.g gVar = (com.pinguo.camera360.gallery.ui.b0.g) aVar;
            if (1 == gVar.J) {
                return gVar.g(i2, new Rect());
            }
            return gVar.q(i2, new Rect());
        }
        return aVar.q(i2, new Rect());
    }

    public ArrayList<y.c> P0() {
        return this.B.u();
    }

    public int Q0() {
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
            com.pinguo.camera360.gallery.ui.b0.g gVar = (com.pinguo.camera360.gallery.ui.b0.g) aVar;
            if (1 == gVar.J) {
                return gVar.T();
            }
            return gVar.z();
        }
        return aVar.z();
    }

    public int R0() {
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
            com.pinguo.camera360.gallery.ui.b0.g gVar = (com.pinguo.camera360.gallery.ui.b0.g) aVar;
            if (1 == gVar.J) {
                return gVar.U();
            }
            return gVar.A();
        }
        return aVar.A();
    }

    public boolean U0() {
        b bVar = this.S;
        if (bVar != null) {
            return bVar.d();
        }
        return false;
    }

    public void V0(int i2) {
        Rect q;
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
            com.pinguo.camera360.gallery.ui.b0.g gVar = (com.pinguo.camera360.gallery.ui.b0.g) aVar;
            if (1 == gVar.J) {
                q = gVar.g(i2, this.H);
            } else {
                q = gVar.q(i2, this.H);
            }
        } else {
            q = aVar.q(i2, this.H);
        }
        int i3 = this.f6112h;
        int n = n();
        int i4 = i3 + n;
        int i5 = q.top;
        int i6 = q.bottom;
        if (n >= i6 - i5) {
            if (i5 < i3) {
                i3 = i5;
            } else if (i6 > i4) {
                i3 = i6 - n;
            }
        }
        f1(i3);
    }

    protected void X0(int i2) {
        this.x.f(i2, this.B.j());
    }

    public boolean Y0(int i2) {
        this.L = i2;
        Bitmap c2 = this.F.c(i2, true);
        if (c2 == null) {
            this.L = -1;
            return false;
        }
        int e2 = this.F.e(this.L);
        Bitmap l2 = com.pinguo.album.data.utils.b.l(c2, e2, true);
        if (l2 != null) {
            S0(l2, e2);
            this.x.b();
        } else {
            this.L = -1;
        }
        b bVar = new b(true);
        this.S = bVar;
        bVar.l();
        q();
        return true;
    }

    @Override // com.pinguo.album.views.a
    public void c(com.pinguo.album.views.a aVar) {
        throw new UnsupportedOperationException();
    }

    public void d1(int i2) {
        int m = this.B.m();
        if (i2 < 0 || i2 >= m) {
            return;
        }
        Rect q = this.B.q(i2, this.H);
        f1(((q.top + q.bottom) - n()) / 2);
    }

    public void e1(p pVar) {
        this.x = pVar;
    }

    public void f1(int i2) {
        int e2 = com.pinguo.album.j.a.e(i2, 0, this.B.j());
        this.v.g(e2);
        r1(e2, false);
    }

    public boolean g1(int i2) {
        boolean H = this.B.H(i2);
        int i3 = this.C;
        if (i3 != -1) {
            d1(i3);
            this.C = -1;
        }
        f1(this.f6112h);
        return H;
    }

    public void h1(e eVar) {
        this.F = eVar;
        if (eVar != null) {
            this.B.I(eVar);
            this.F.j(this.B.t(), this.B.n());
            this.F.d(this.B.A(), this.B.z());
            this.F.i(this.B.C(), this.B.B(), l.o);
            com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
            if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
                com.pinguo.camera360.gallery.ui.b0.g gVar = (com.pinguo.camera360.gallery.ui.b0.g) aVar;
                this.F.i(gVar.W(), gVar.V(), l.p);
            }
        }
    }

    public void i1(f fVar) {
        this.B.J(fVar);
    }

    public void j1(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3) {
        this.B.K(arrayList, arrayList2, arrayList3);
    }

    public void k1(int i2) {
        this.U = i2;
    }

    public void l1(boolean z) {
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
            ((com.pinguo.camera360.gallery.ui.b0.g) aVar).J = 2;
            aVar.O(0.0f, 0.0f);
            this.m.D(4);
            this.t = z;
            this.Z.sendEmptyMessage(1);
        }
    }

    public void m1() {
        com.pinguo.album.animations.f fVar = new com.pinguo.album.animations.f();
        this.A = fVar;
        fVar.l();
        if (this.B.m() != 0) {
            q();
        }
    }

    public void n1(com.pinguo.album.j.i iVar) {
        com.pinguo.album.animations.g gVar = new com.pinguo.album.animations.g(iVar);
        this.A = gVar;
        gVar.l();
        if (this.B.m() != 0) {
            q();
        }
    }

    public void p1(int i2) {
        AlbumScrollerIcon albumScrollerIcon = this.m;
        if (albumScrollerIcon != null) {
            albumScrollerIcon.D(i2);
        }
    }

    public void q1(String str) {
        this.m.O(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.views.a
    public void v(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            int i6 = this.U + i3;
            AlbumScrollerIcon albumScrollerIcon = this.m;
            albumScrollerIcon.r(i4 - this.m.G(), i6, i4, albumScrollerIcon.F() + i6);
            int i7 = i4 - i2;
            int i8 = i5 - i3;
            this.B.G(i7, i8);
            V0((this.B.A() + this.B.z()) / 2);
            if (this.E == 0) {
                this.w.f(i7, i8);
            }
        }
    }

    @Override // com.pinguo.album.views.a
    protected boolean w(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = ((int) motionEvent.getY()) + e().top;
        a0 a0Var = this.y;
        if (a0Var != null) {
            a0Var.c();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
            if ((aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) && ((com.pinguo.camera360.gallery.ui.b0.g) aVar).J == 0) {
                this.n = this.m.e().contains(x, y);
            } else {
                this.n = false;
            }
            this.Z.removeMessages(2);
            this.r = true;
            this.Y = -1;
            this.D = !this.v.f();
            this.v.c();
        } else if (actionMasked == 1) {
            if (this.m.o() == 0) {
                this.Z.removeMessages(2);
                this.Z.sendEmptyMessageDelayed(2, 1000L);
            }
            this.r = true;
            this.w.d();
            q();
        } else if (actionMasked == 5) {
            if (this.r) {
                this.s = true;
            }
            this.r = false;
        }
        if (!this.r) {
            this.q.onTouchEvent(motionEvent);
        } else {
            this.p.l(motionEvent);
        }
        if (this.s) {
            motionEvent.setAction(3);
            this.p.l(motionEvent);
            this.s = false;
        }
        return true;
    }

    @Override // com.pinguo.album.views.a
    public void y(com.pinguo.album.opengles.l lVar) {
        boolean z;
        int i2;
        com.pinguo.camera360.gallery.ui.b0.d dVar;
        ArrayList<y.c> u;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.y(lVar);
        e eVar = this.F;
        if (eVar == null) {
            return;
        }
        eVar.b();
        long a2 = com.pinguo.album.animations.c.a();
        boolean a3 = this.v.a(a2) | this.B.a(a2);
        int i12 = this.f6113i;
        int e2 = this.v.e();
        if (e2 >= this.B.j() || e2 < 0) {
            this.v.c();
            e2 = this.B.j();
        }
        if (e2 < 0) {
            this.v.c();
            e2 = 0;
        }
        r1(e2, false);
        if (this.E == 0) {
            int i13 = this.f6113i;
            int j2 = this.B.j();
            if ((i12 > 0 && i13 == 0) || (i12 < j2 && i13 == j2)) {
                float d2 = this.v.d();
                if (i13 == j2) {
                    d2 = -d2;
                }
                if (!Float.isNaN(d2)) {
                    this.w.b(d2);
                }
            }
            z = this.w.a();
        } else {
            z = false;
        }
        boolean z2 = a3 | z;
        com.pinguo.album.animations.h hVar = this.A;
        if (hVar != null) {
            z2 |= hVar.b(a2);
        }
        lVar.d();
        float f2 = this.f6695l;
        com.pinguo.camera360.gallery.ui.b0.a aVar = this.B;
        if (aVar instanceof com.pinguo.camera360.gallery.ui.b0.g) {
            com.pinguo.camera360.gallery.ui.b0.g gVar = (com.pinguo.camera360.gallery.ui.b0.g) aVar;
            int i14 = gVar.J;
            ArrayList<y.c> u2 = gVar.u();
            ArrayList<y.c> S = gVar.S();
            if (i14 != 1 && u2 != null && u2.size() > 0) {
                int B = gVar.B();
                for (int C = gVar.C(); C < B; C++) {
                    c1(lVar, C, u2.get(C).f6396h, f2);
                }
            }
            if (i14 != 0 && S != null && S.size() > 0) {
                int V = gVar.V();
                for (int W = gVar.W(); W < V; W++) {
                    a1(lVar, W, S.get(W).f6396h, f2);
                }
            }
            i2 = i14;
        } else {
            if ((aVar instanceof com.pinguo.camera360.gallery.ui.b0.d) && (u = (dVar = (com.pinguo.camera360.gallery.ui.b0.d) aVar).u()) != null && u.size() > 0) {
                for (int C2 = dVar.C(); C2 < dVar.B(); C2++) {
                    c1(lVar, C2, u.get(C2).f6396h, f2);
                }
            }
            i2 = 0;
        }
        int[] I0 = I0(this.G, this.B.z() - this.B.A());
        if (i2 != 1) {
            boolean z3 = z2;
            int z4 = this.B.z() - 1;
            i3 = 0;
            for (int A = this.B.A(); z4 >= A; A = i10) {
                if (this.L != z4) {
                    i9 = z4;
                    i10 = A;
                    i11 = b1(lVar, z4, 0, z, f2);
                } else {
                    i9 = z4;
                    i10 = A;
                    i11 = 0;
                }
                if ((i11 & 2) != 0) {
                    z3 = true;
                }
                if ((i11 & 1) != 0) {
                    I0[i3] = i9;
                    i3++;
                }
                z4 = i9 - 1;
            }
            z2 = z3;
        } else {
            i3 = 0;
        }
        com.pinguo.camera360.gallery.ui.b0.a aVar2 = this.B;
        if ((aVar2 instanceof com.pinguo.camera360.gallery.ui.b0.g) && i2 != 0) {
            com.pinguo.camera360.gallery.ui.b0.g gVar2 = (com.pinguo.camera360.gallery.ui.b0.g) aVar2;
            int U = gVar2.U();
            boolean z5 = z2;
            for (int T = gVar2.T() - 1; T >= U; T = i7 - 1) {
                if (this.L != T) {
                    i7 = T;
                    i8 = Z0(lVar, T, 0, z, f2);
                } else {
                    i7 = T;
                    i8 = 0;
                }
                if ((i8 & 2) != 0) {
                    z5 = true;
                }
                if ((i8 & 1) != 0) {
                    I0[i3] = i7;
                    i3++;
                }
            }
            z2 = z5;
        }
        boolean z6 = z2;
        int i15 = i3;
        int i16 = 1;
        while (i15 != 0) {
            int i17 = 0;
            int i18 = 0;
            while (i17 < i15) {
                if (this.L != i17) {
                    int i19 = I0[i17];
                    int i20 = i16;
                    i4 = i17;
                    boolean z7 = z;
                    i5 = i15;
                    b1(lVar, i19, i20, z7, f2);
                    i6 = Z0(lVar, I0[i4], i20, z7, f2);
                } else {
                    i4 = i17;
                    i5 = i15;
                    i6 = 0;
                }
                if ((i6 & 2) != 0) {
                    z6 = true;
                }
                if ((i6 & 1) != 0) {
                    I0[i18] = i4;
                    i18++;
                }
                i17 = i4 + 1;
                i15 = i5;
            }
            i16++;
            i15 = i18;
        }
        this.m.y(lVar);
        lVar.b();
        if (this.L >= 0 && this.I != null) {
            int width = this.N.width();
            int height = this.N.height();
            lVar.setAlpha(this.M);
            Rect rect = this.a;
            lVar.g(-rect.left, -rect.top, p() + this.B.r().f6712g + this.B.r().f6713h, n() + this.B.r().f6714i + this.B.r().f6715j + this.U, this.T);
            lVar.setAlpha(1.0f);
            lVar.s(3);
            lVar.a(-this.f6113i, -this.f6112h);
            Rect rect2 = this.N;
            lVar.p(rect2.left, rect2.top, 0.0f);
            lVar.a(this.Q, this.R);
            lVar.a(width / 2, height / 2);
            int i21 = this.O;
            if (i21 != 0) {
                lVar.v(i21, 0.0f, 0.0f, 1.0f);
            }
            float f3 = this.P;
            lVar.k(f3, f3, 1.0f);
            this.I.a(lVar, (-width) / 2, (-height) / 2, width, height);
            lVar.b();
        }
        b bVar = this.S;
        if (bVar != null) {
            z6 |= bVar.b(a2);
        }
        if (z6) {
            q();
        }
        a0 a0Var = this.y;
        if (this.z && !z6 && a0Var != null) {
            this.Z.post(new a(this, a0Var));
        }
        this.z = z6;
    }

    /* compiled from: SlotView.java */
    /* loaded from: classes3.dex */
    private class c implements m.c, d.a {
        private boolean a;
        private boolean b;
        private boolean c;

        /* renamed from: d  reason: collision with root package name */
        private float f6704d;

        /* renamed from: e  reason: collision with root package name */
        private float f6705e;

        /* renamed from: f  reason: collision with root package name */
        private int f6706f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f6707g;

        private c() {
            this.b = false;
            this.c = false;
            this.f6707g = false;
        }

        private void c(boolean z) {
            if (this.a) {
                this.a = false;
                z.this.x.i(z);
            }
        }

        private boolean d() {
            return (z.this.B instanceof com.pinguo.camera360.gallery.ui.b0.g) || (z.this.B instanceof com.pinguo.camera360.gallery.ui.b0.d) || (z.this.B instanceof com.pinguo.camera360.gallery.ui.b0.b);
        }

        @Override // com.pinguo.album.common.d.a
        public boolean a(com.pinguo.album.common.d dVar) {
            if (!this.c || z.this.L < 0) {
                return true;
            }
            z.q0(z.this, dVar.a());
            return true;
        }

        @Override // com.pinguo.camera360.gallery.ui.m.c
        public boolean b() {
            z.this.W = false;
            z.this.X = false;
            if (z.this.m.o() == 0 && z.this.n) {
                z.this.m.M();
            }
            z.this.V = -1;
            z.this.x.i(false);
            return false;
        }

        @Override // com.pinguo.camera360.gallery.ui.m.c
        public boolean onDown(MotionEvent motionEvent) {
            if (z.this.B instanceof com.pinguo.camera360.gallery.ui.b0.g) {
                boolean z = true;
                this.b = (z.this.B.j() / z.this.n() < 2 || !(((com.pinguo.camera360.gallery.ui.b0.g) z.this.B).J == 0) || z.this.o == null || z.this.o.i()) ? false : false;
                if (z.this.m.o() == 0 && z.this.n) {
                    z.this.m.P();
                    y.c v = z.this.B.v(z.this.p(), motionEvent.getY());
                    if (v != null) {
                        z.this.x.j(v.b);
                    }
                }
            }
            z.this.V = -1;
            this.f6707g = false;
            return false;
        }

        @Override // com.pinguo.camera360.gallery.ui.m.c
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (this.f6707g || z.this.L != -1) {
                return true;
            }
            if (z.this.m.o() == 0) {
                z.this.Z.removeMessages(2);
                z.this.Z.sendEmptyMessageDelayed(2, 1000L);
            }
            c(false);
            z.this.W = false;
            if (z.this.x != null) {
                int x = (int) motionEvent2.getX();
                int abs = Math.abs(((int) motionEvent2.getY()) - ((int) motionEvent.getY()));
                int x2 = x - ((int) motionEvent.getX());
                if (abs < Math.abs(x2)) {
                    if (x2 < 0) {
                        z.this.x.o(2);
                    } else if (x2 > 0) {
                        z.this.x.o(1);
                    }
                    return true;
                }
            }
            int j2 = z.this.B.j();
            if (j2 != 0 && z.this.v.e() < j2) {
                z.this.v.b((((int) (-f3)) * 2) / 3, 0, j2);
                if (z.this.y != null) {
                    z.this.y.b();
                }
                z.this.q();
                return true;
            }
            z.this.q();
            return false;
        }

        @Override // com.pinguo.camera360.gallery.ui.m.c
        public void onLongPress(MotionEvent motionEvent) {
            if (z.this.T0()) {
                z.this.p.m(true);
                c(true);
                if (z.this.D) {
                    return;
                }
                z.this.s();
                try {
                    int o = z.this.B.o(motionEvent.getX(), motionEvent.getY());
                    if (o != -1) {
                        z.this.x.g(o);
                        z.this.X = true;
                    }
                } finally {
                    z.this.E();
                }
            }
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (this.c) {
                if (z.this.L < 0) {
                    z zVar = z.this;
                    zVar.L = zVar.B.o(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    if (z.this.L < 0) {
                        return true;
                    }
                    Bitmap c = z.this.F.c(z.this.L, true);
                    int e2 = z.this.F.e(z.this.L);
                    Bitmap l2 = com.pinguo.album.data.utils.b.l(c, e2, true);
                    if (l2 != null) {
                        z.this.S0(l2, e2);
                        z.this.x.b();
                    } else {
                        z.this.L = -1;
                        return false;
                    }
                } else {
                    z.e0(z.this, (int) (scaleGestureDetector.getFocusX() - this.f6704d));
                    z.h0(z.this, (int) (scaleGestureDetector.getFocusY() - this.f6705e));
                    float scaleFactor = scaleGestureDetector.getScaleFactor();
                    float abs = Math.abs(1.0f - scaleFactor) * 3.0f;
                    float f2 = scaleFactor > 1.0f ? abs + 1.0f : 1.0f - abs;
                    z.this.P *= f2;
                    this.f6704d = scaleGestureDetector.getFocusX();
                    this.f6705e = scaleGestureDetector.getFocusY();
                    z.this.W0();
                }
                z.this.q();
            } else {
                float scaleFactor2 = scaleGestureDetector.getScaleFactor();
                z zVar2 = z.this;
                zVar2.f6695l = (((zVar2.f6695l + 0.33f) * scaleFactor2) * scaleFactor2) - 0.33f;
                if (z.this.f6695l <= 1.0f) {
                    if (!(z.this.B instanceof com.pinguo.camera360.gallery.ui.b0.g)) {
                        z.this.f6695l = 1.0f;
                    }
                } else {
                    if (this.f6706f == 0) {
                        ((com.pinguo.camera360.gallery.ui.b0.g) z.this.B).J = 0;
                    }
                    this.c = true;
                    z.this.f6695l = 1.0f;
                }
                if (z.this.f6695l < 0.0f) {
                    z.this.f6695l = 0.0f;
                }
                z.this.t = scaleFactor2 > 1.0f;
                z.this.q();
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            us.pinguo.common.log.a.k("MyGestureListener onScaleBegin mScale = " + this.f6707g, new Object[0]);
            if ((z.this.o == null || !z.this.o.i()) && z.this.B.m() != 0) {
                this.f6707g = true;
                this.c = false;
                this.f6704d = scaleGestureDetector.getFocusX();
                this.f6705e = scaleGestureDetector.getFocusY();
                z.this.L = -1;
                this.f6706f = -1;
                if (z.this.B instanceof com.pinguo.camera360.gallery.ui.b0.g) {
                    com.pinguo.camera360.gallery.ui.b0.g gVar = (com.pinguo.camera360.gallery.ui.b0.g) z.this.B;
                    this.f6706f = gVar.J;
                    gVar.J = 2;
                    z.this.B.O(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    z.this.m.D(4);
                }
                return d();
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f6707g = false;
            if (this.c) {
                this.c = false;
                z zVar = z.this;
                zVar.S = new b(false);
                z.this.S.l();
                z.this.q();
            }
            us.pinguo.common.log.a.k("MyGestureListener onScaleEnd mScale = " + this.f6707g + " isZoomInSlot = " + z.this.t + " mCurrentScaleRate = " + z.this.f6695l, new Object[0]);
            if (z.this.B instanceof com.pinguo.camera360.gallery.ui.b0.g) {
                z.this.o1();
                if ((z.this.t && z.this.f6695l < 1.0f) || (!z.this.t && z.this.f6695l > 0.0f)) {
                    z.this.Z.sendEmptyMessage(1);
                }
                z.this.v.g(((com.pinguo.camera360.gallery.ui.b0.g) z.this.B).R());
            }
        }

        @Override // com.pinguo.camera360.gallery.ui.m.c
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (!this.f6707g && z.this.L == -1) {
                z.this.u = true;
                if (!z.this.n) {
                    z.this.m.J();
                }
                boolean z = Math.abs(f3) > Math.abs(f2);
                if (z && z.this.o != null && !z.this.o.i()) {
                    z.this.m.D(this.b ? 0 : 4);
                }
                c(false);
                if (f3 == 0.0f) {
                    return true;
                }
                int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                int i3 = i2 < 0 ? 3 : 4;
                if (z) {
                    z.this.x.m(i3);
                }
                if (z.this.V != -1 && i3 != z.this.V) {
                    z.this.V = i3;
                    z.this.x.n();
                    z.this.W = false;
                }
                if (z.this.W) {
                    return true;
                }
                z.this.V = i2 < 0 ? 3 : 4;
                float y = (int) motionEvent2.getY();
                float abs = Math.abs(y - motionEvent.getY());
                float n = (z.this.B.n() * 2) / 3;
                float h2 = n0.h() - n;
                int i4 = z.this.V == 3 ? -10 : 10;
                if (z.this.o == null || !z.this.X || ((abs < i4 || y < h2 || z.this.V != 3) && (y > n || z.this.V == 3))) {
                    if (z.this.o != null && z.this.o.i() && z.this.X) {
                        List<Integer> h3 = z.this.B.h(0.0f, motionEvent2.getY());
                        if (z.this.Y == -1) {
                            z zVar = z.this;
                            zVar.Y = zVar.B.o(motionEvent2.getX(), motionEvent2.getY());
                        }
                        if (h3 != null && h3.contains(Integer.valueOf(z.this.Y))) {
                            Iterator<Integer> it = h3.iterator();
                            while (it.hasNext()) {
                                if (z.this.Y == it.next().intValue()) {
                                    break;
                                }
                                it.remove();
                            }
                        }
                        if (h3 != null) {
                            z.this.x.d(h3);
                        }
                        z.this.q();
                        return true;
                    } else if (Math.abs(f2) > Math.abs(1.1f * f3)) {
                        return false;
                    } else {
                        if (!z.this.X) {
                            if (z.this.n) {
                                int n2 = (z.this.n() - z.this.m.n()) - z.this.U;
                                z.this.m.K(f3, n2);
                                z.this.v.g((int) (Math.abs(z.this.m.H()) * (z.this.B.j() / n2)));
                                y.c v = z.this.B.v(z.this.p(), motionEvent2.getY());
                                if (v != null) {
                                    z.this.x.j(v.b);
                                }
                            } else {
                                int h4 = z.this.v.h(Math.round(f3), 0, z.this.B.j());
                                if (z.this.E == 0 && h4 != 0) {
                                    z.this.w.e(h4);
                                }
                            }
                        }
                        z.this.q();
                    }
                } else {
                    z.this.W = true;
                    float f4 = -f3;
                    if (f4 == 0.0f) {
                        f4 = 15.0f;
                    }
                    z.this.v.h(Math.round(f4), 0, z.this.B.j());
                    Message message = new Message();
                    message.what = 3;
                    message.arg1 = (int) f3;
                    message.arg2 = (int) motionEvent2.getY();
                    z.this.Z.sendMessageDelayed(message, 50L);
                    return true;
                }
            }
            return true;
        }

        @Override // com.pinguo.camera360.gallery.ui.m.c
        public void onShowPress(MotionEvent motionEvent) {
            com.pinguo.album.views.b m = z.this.m();
            m.c();
            try {
                if (this.a) {
                    return;
                }
                int o = z.this.B.o(motionEvent.getX(), motionEvent.getY());
                if (o != -1) {
                    this.a = true;
                    z.this.x.c(o);
                }
            } finally {
                m.g();
            }
        }

        @Override // com.pinguo.camera360.gallery.ui.m.c
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            c(false);
            if (z.this.D) {
                return true;
            }
            z.this.W = false;
            z.this.X = false;
            int o = z.this.B.o(motionEvent.getX(), motionEvent.getY());
            if (o != -1) {
                float[] y = z.this.B.y(o, motionEvent.getX(), motionEvent.getY());
                z.this.x.l(o, y[0], y[1]);
            } else {
                int w = z.this.B.w(motionEvent.getX(), motionEvent.getY());
                if (w != -1) {
                    z.this.x.e(w);
                }
            }
            return true;
        }

        /* synthetic */ c(z zVar, a aVar) {
            this();
        }
    }

    public z(com.pinguo.camera360.gallery.l lVar, f fVar, com.pinguo.camera360.gallery.ui.b0.a aVar, t tVar) {
        this(lVar, fVar, aVar);
        this.o = tVar;
    }
}
