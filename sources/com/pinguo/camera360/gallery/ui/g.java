package com.pinguo.camera360.gallery.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.google.android.material.timepicker.TimeModel;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.q;
import com.pinguo.camera360.gallery.ui.h;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumSetSlidingWindow.java */
/* loaded from: classes3.dex */
public class g implements q.b {
    private final com.pinguo.camera360.gallery.q a;
    private int b;

    /* renamed from: g  reason: collision with root package name */
    private f f6536g;

    /* renamed from: h  reason: collision with root package name */
    private final d[] f6537h;

    /* renamed from: i  reason: collision with root package name */
    private final com.pinguo.album.g f6538i;

    /* renamed from: j  reason: collision with root package name */
    private final com.pinguo.album.a f6539j;

    /* renamed from: k  reason: collision with root package name */
    private final n f6540k;

    /* renamed from: l  reason: collision with root package name */
    private final com.pinguo.album.opengles.v f6541l;
    private int o;
    private String p;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f6533d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected int f6534e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f6535f = 0;
    private int m = 0;
    private volatile boolean n = false;
    private int q = 3;

    /* compiled from: AlbumSetSlidingWindow.java */
    /* loaded from: classes3.dex */
    class a extends com.pinguo.album.g {
        a(g gVar, com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.pinguo.album.j.a.a(message.what == 1);
            ((e) message.obj).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumSetSlidingWindow.java */
    /* loaded from: classes3.dex */
    public class b extends com.pinguo.album.data.utils.c implements e {

        /* renamed from: d  reason: collision with root package name */
        private com.pinguo.camera360.gallery.data.w f6542d;

        /* renamed from: e  reason: collision with root package name */
        private final int f6543e;

        public b(int i2, com.pinguo.camera360.gallery.data.w wVar) {
            us.pinguo.common.log.a.k("AlbumCoverLoader slotIndex = " + i2, new Object[0]);
            this.f6543e = i2;
            this.f6542d = wVar;
        }

        @Override // com.pinguo.camera360.gallery.ui.g.e
        public void a() {
            Bitmap d2 = d();
            if (d2 == null) {
                return;
            }
            d dVar = g.this.f6537h[this.f6543e % g.this.f6537h.length];
            com.pinguo.album.opengles.c cVar = new com.pinguo.album.opengles.c(d2);
            dVar.f6551e = cVar;
            dVar.c = cVar;
            if (g.this.t(this.f6543e)) {
                g.this.f6541l.d(cVar);
                g.l(g.this);
                if (g.this.m == 0) {
                    g.this.z();
                }
                if (g.this.f6536g != null) {
                    g.this.f6536g.a(this.f6543e);
                    return;
                }
                return;
            }
            g.this.f6541l.c(cVar);
        }

        @Override // com.pinguo.album.data.utils.c
        protected void f(Bitmap bitmap) {
            g.this.f6538i.obtainMessage(1, this).sendToTarget();
        }

        @Override // com.pinguo.album.data.utils.c
        protected void h(Bitmap bitmap) {
            PGAlbumBitmapPool.getInstance().f(bitmap);
        }

        @Override // com.pinguo.album.data.utils.c
        protected com.pinguo.album.c<Bitmap> j(com.pinguo.album.d<Bitmap> dVar) {
            return g.this.f6539j.b(this.f6542d.A(g.this.q), dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumSetSlidingWindow.java */
    /* loaded from: classes3.dex */
    public class c extends com.pinguo.album.data.utils.c implements e {

        /* renamed from: d  reason: collision with root package name */
        private final int f6545d;

        /* renamed from: e  reason: collision with root package name */
        private final int f6546e;

        /* renamed from: f  reason: collision with root package name */
        private final long[] f6547f;

        /* renamed from: g  reason: collision with root package name */
        private final String f6548g;

        public c(int i2, int i3, long[] jArr, String str) {
            this.f6545d = i2;
            this.f6546e = i3;
            this.f6547f = jArr;
            this.f6548g = str;
        }

        @Override // com.pinguo.camera360.gallery.ui.g.e
        public void a() {
            Bitmap d2 = d();
            if (d2 == null) {
                return;
            }
            d dVar = g.this.f6537h[this.f6545d % g.this.f6537h.length];
            com.pinguo.album.opengles.c cVar = new com.pinguo.album.opengles.c(d2);
            cVar.E(false);
            dVar.f6550d = cVar;
            if (g.this.t(this.f6545d)) {
                g.this.f6541l.d(cVar);
                g.l(g.this);
                if (g.this.m == 0) {
                    g.this.z();
                }
                if (g.this.f6536g != null) {
                    g.this.f6536g.a(this.f6545d);
                    return;
                }
                return;
            }
            g.this.f6541l.c(cVar);
        }

        @Override // com.pinguo.album.data.utils.c
        protected void f(Bitmap bitmap) {
            g.this.f6538i.obtainMessage(1, this).sendToTarget();
        }

        @Override // com.pinguo.album.data.utils.c
        protected com.pinguo.album.c<Bitmap> j(com.pinguo.album.d<Bitmap> dVar) {
            String str;
            long[] jArr;
            if (g.this.p == null) {
                g.this.p = TimeModel.NUMBER_FORMAT;
            }
            long[] jArr2 = this.f6547f;
            if (jArr2 == null || jArr2.length == 0) {
                str = null;
            } else {
                String d2 = us.pinguo.util.u.d(jArr2[0], "yyyy.MM");
                str = us.pinguo.util.u.d(this.f6547f[jArr.length - 1], "yyyy.MM");
                if (d2 == null || !str.equals(d2)) {
                    str = str + "--" + d2;
                }
            }
            return g.this.f6539j.b(g.this.f6540k.a(String.valueOf(this.f6546e), str, this.f6548g), dVar);
        }
    }

    /* compiled from: AlbumSetSlidingWindow.java */
    /* loaded from: classes3.dex */
    public static class d {
        public com.pinguo.camera360.gallery.data.y a;
        public com.pinguo.camera360.gallery.data.w b;
        public com.pinguo.album.opengles.u c;

        /* renamed from: d  reason: collision with root package name */
        public com.pinguo.album.opengles.c f6550d;

        /* renamed from: e  reason: collision with root package name */
        public com.pinguo.album.opengles.c f6551e;

        /* renamed from: f  reason: collision with root package name */
        public Path f6552f;

        /* renamed from: g  reason: collision with root package name */
        public String f6553g;

        /* renamed from: h  reason: collision with root package name */
        public int f6554h;

        /* renamed from: i  reason: collision with root package name */
        public long[] f6555i;

        /* renamed from: j  reason: collision with root package name */
        public int f6556j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f6557k;

        /* renamed from: l  reason: collision with root package name */
        public long f6558l;
        private com.pinguo.album.data.utils.c m;
        private com.pinguo.album.data.utils.c n;
    }

    /* compiled from: AlbumSetSlidingWindow.java */
    /* loaded from: classes3.dex */
    private interface e {
        void a();
    }

    /* compiled from: AlbumSetSlidingWindow.java */
    /* loaded from: classes3.dex */
    public interface f {
        void a(int i2);

        void b(int i2);
    }

    public g(com.pinguo.camera360.gallery.l lVar, com.pinguo.camera360.gallery.q qVar, h.b bVar, int i2, boolean z) {
        this.p = null;
        qVar.I(this);
        this.a = qVar;
        this.f6537h = new d[i2];
        this.b = qVar.J();
        this.f6539j = lVar.G();
        if (z) {
            this.f6540k = new com.pinguo.camera360.gallery.ui.f(lVar.a(), bVar);
        } else {
            this.f6540k = new com.pinguo.camera360.gallery.ui.e(lVar.a(), bVar);
        }
        lVar.a().getString(R.string.loading);
        this.f6541l = new com.pinguo.album.opengles.v(lVar.E());
        this.p = lVar.getResources().getString(R.string.pic_count_format);
        this.f6538i = new a(this, lVar.E());
    }

    private void D(int i2, int i3) {
        int i4 = this.c;
        if (i2 == i4 && i3 == this.f6533d) {
            return;
        }
        int i5 = this.f6533d;
        if (i2 < i5 && i4 < i3) {
            while (i4 < i2) {
                q(i4);
                i4++;
            }
            int i6 = this.f6533d;
            for (int i7 = i3; i7 < i6; i7++) {
                q(i7);
            }
            this.a.F(i2, i3);
            int i8 = this.c;
            for (int i9 = i2; i9 < i8; i9++) {
                x(i9);
            }
            for (int i10 = this.f6533d; i10 < i3; i10++) {
                x(i10);
            }
        } else {
            while (i4 < i5) {
                q(i4);
                i4++;
            }
            this.a.F(i2, i3);
            for (int i11 = i2; i11 < i3; i11++) {
                x(i11);
            }
        }
        this.c = i2;
        this.f6533d = i3;
    }

    private static boolean G(com.pinguo.album.data.utils.c cVar) {
        if (cVar == null) {
            return false;
        }
        cVar.i();
        return cVar.e();
    }

    private void H(d dVar, int i2) {
        com.pinguo.camera360.gallery.data.y B = this.a.B(i2);
        com.pinguo.camera360.gallery.data.w A = this.a.A(i2);
        int C = this.a.C(i2);
        dVar.a = B;
        dVar.b = A;
        dVar.f6552f = B == null ? null : B.g();
        String i3 = B == null ? "" : com.pinguo.album.j.a.i(B.s());
        if (u(dVar, i3, C, 1)) {
            dVar.f6553g = i3;
            dVar.f6554h = C;
            if (dVar.m != null) {
                dVar.m.g();
                dVar.m = null;
                dVar.f6550d = null;
            }
            if (B != null) {
                if (B instanceof com.pinguo.camera360.gallery.data.g) {
                    dVar.f6555i = ((com.pinguo.camera360.gallery.data.g) B).L();
                }
                dVar.m = new c(i2, C, dVar.f6555i, dVar.f6553g);
            }
        }
        if (s(A) != dVar.f6558l) {
            dVar.f6558l = s(A);
            dVar.f6556j = A == null ? 0 : A.t();
            if (dVar.n != null) {
                dVar.n.g();
                dVar.n = null;
                dVar.f6551e = null;
                dVar.c = null;
            }
            if (A != null) {
                dVar.n = new b(i2, A);
            }
        }
    }

    private void I() {
        this.m = 0;
        int i2 = this.f6535f;
        for (int i3 = this.f6534e; i3 < i2; i3++) {
            d[] dVarArr = this.f6537h;
            d dVar = dVarArr[i3 % dVarArr.length];
            if (G(dVar.n)) {
                this.m++;
            }
            if (G(dVar.m)) {
                this.m++;
            }
        }
        if (this.m == 0) {
            z();
        } else {
            p();
        }
    }

    private void J() {
        if (this.n) {
            this.f6541l.e();
            int i2 = this.f6535f;
            for (int i3 = this.f6534e; i3 < i2; i3++) {
                d[] dVarArr = this.f6537h;
                d dVar = dVarArr[i3 % dVarArr.length];
                com.pinguo.album.opengles.c cVar = dVar.f6551e;
                if (cVar != null) {
                    this.f6541l.d(cVar);
                }
                com.pinguo.album.opengles.c cVar2 = dVar.f6550d;
                if (cVar2 != null) {
                    this.f6541l.d(cVar2);
                }
            }
            int max = Math.max(this.f6533d - this.f6535f, this.f6534e - this.c);
            for (int i4 = 0; i4 < max; i4++) {
                K(this.f6535f + i4);
                K((this.f6534e - i4) - 1);
            }
        }
    }

    private void K(int i2) {
        if (i2 < this.c || i2 >= this.f6533d) {
            return;
        }
        d[] dVarArr = this.f6537h;
        d dVar = dVarArr[i2 % dVarArr.length];
        com.pinguo.album.opengles.c cVar = dVar.f6551e;
        if (cVar != null) {
            this.f6541l.c(cVar);
        }
        com.pinguo.album.opengles.c cVar2 = dVar.f6550d;
        if (cVar2 != null) {
            this.f6541l.c(cVar2);
        }
    }

    static /* synthetic */ int l(g gVar) {
        int i2 = gVar.m - 1;
        gVar.m = i2;
        return i2;
    }

    private void o(int i2) {
        if (i2 < this.c || i2 >= this.f6533d) {
            return;
        }
        d[] dVarArr = this.f6537h;
        d dVar = dVarArr[i2 % dVarArr.length];
        if (dVar.n != null) {
            dVar.n.c();
        }
        if (dVar.m != null) {
            dVar.m.c();
        }
    }

    private void p() {
        int max = Math.max(this.f6533d - this.f6535f, this.f6534e - this.c);
        for (int i2 = 0; i2 < max; i2++) {
            o(this.f6535f + i2);
            o((this.f6534e - 1) - i2);
        }
    }

    private void q(int i2) {
        d[] dVarArr = this.f6537h;
        d dVar = dVarArr[i2 % dVarArr.length];
        if (dVar == null) {
            return;
        }
        if (dVar.n != null) {
            dVar.n.g();
        }
        if (dVar.m != null) {
            dVar.m.g();
        }
        com.pinguo.album.opengles.c cVar = dVar.f6550d;
        if (cVar != null) {
            cVar.o();
        }
        com.pinguo.album.opengles.c cVar2 = dVar.f6551e;
        if (cVar2 != null) {
            cVar2.o();
        }
        d[] dVarArr2 = this.f6537h;
        dVarArr2[i2 % dVarArr2.length] = null;
    }

    private static long s(com.pinguo.camera360.gallery.data.x xVar) {
        if (xVar == null) {
            return -1L;
        }
        return xVar.d();
    }

    private boolean u(d dVar, String str, int i2, int i3) {
        return (com.pinguo.album.j.a.j(dVar.f6553g, str) && dVar.f6554h == i2) ? false : true;
    }

    private void x(int i2) {
        d dVar = new d();
        H(dVar, i2);
        d[] dVarArr = this.f6537h;
        dVarArr[i2 % dVarArr.length] = dVar;
    }

    private void y(int i2) {
        if (i2 < this.c || i2 >= this.f6533d) {
            return;
        }
        d[] dVarArr = this.f6537h;
        d dVar = dVarArr[i2 % dVarArr.length];
        if (dVar.n != null) {
            dVar.n.i();
        }
        if (dVar.m != null) {
            dVar.m.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        int max = Math.max(this.f6533d - this.f6535f, this.f6534e - this.c);
        for (int i2 = 0; i2 < max; i2++) {
            y(this.f6535f + i2);
            y((this.f6534e - 1) - i2);
        }
    }

    public void A() {
        this.n = true;
        int i2 = this.f6533d;
        for (int i3 = this.c; i3 < i2; i3++) {
            x(i3);
        }
        I();
    }

    public void B(int i2, int i3) {
        int i4;
        if (i2 <= i3) {
            int i5 = i3 - i2;
            d[] dVarArr = this.f6537h;
            if (i5 <= dVarArr.length && i3 <= (i4 = this.b)) {
                this.f6534e = i2;
                this.f6535f = i3;
                int e2 = com.pinguo.album.j.a.e(((i2 + i3) / 2) - (dVarArr.length / 2), 0, Math.max(0, i4 - dVarArr.length));
                D(e2, Math.min(dVarArr.length + e2, this.b));
                if (this.n) {
                    J();
                    I();
                    return;
                }
                return;
            }
        }
        com.pinguo.album.j.a.k("start = %s, end = %s, length = %s, size = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.f6537h.length), Integer.valueOf(this.b));
        throw null;
    }

    public void C(int i2) {
        this.q = i2;
    }

    public void E(f fVar) {
        this.f6536g = fVar;
    }

    public int F() {
        return this.b;
    }

    @Override // com.pinguo.camera360.gallery.q.b
    public void a(int i2) {
        if (this.n) {
            if (i2 < this.c || i2 >= this.f6533d) {
                us.pinguo.common.log.a.s(String.format("invalid update: %s is outside (%s, %s)", Integer.valueOf(i2), Integer.valueOf(this.c), Integer.valueOf(this.f6533d)), new Object[0]);
                return;
            }
            d[] dVarArr = this.f6537h;
            H(dVarArr[i2 % dVarArr.length], i2);
            I();
            J();
            if (this.f6536g == null || !t(i2)) {
                return;
            }
            this.f6536g.a(i2);
        }
    }

    @Override // com.pinguo.camera360.gallery.q.b
    public void b(int i2) {
        if (!this.n || this.b == i2) {
            return;
        }
        this.b = i2;
        f fVar = this.f6536g;
        if (fVar != null) {
            fVar.b(i2);
        }
        int i3 = this.f6533d;
        int i4 = this.b;
        if (i3 > i4) {
            this.f6533d = i4;
        }
        if (this.f6535f > i4) {
            this.f6535f = i4;
        }
    }

    public d r(int i2) {
        if (t(i2)) {
            d[] dVarArr = this.f6537h;
            return dVarArr[i2 % dVarArr.length];
        }
        com.pinguo.album.j.a.k("invalid slot: %s outsides (%s, %s)", Integer.valueOf(i2), Integer.valueOf(this.f6534e), Integer.valueOf(this.f6535f));
        throw null;
    }

    public boolean t(int i2) {
        return i2 >= this.f6534e && i2 < this.f6535f;
    }

    public void v(int i2, int i3) {
        if (this.o == i2) {
            return;
        }
        this.o = i2;
        this.f6540k.b(i2, i3);
        if (this.n) {
            int i4 = this.f6533d;
            for (int i5 = this.c; i5 < i4; i5++) {
                d[] dVarArr = this.f6537h;
                d dVar = dVarArr[i5 % dVarArr.length];
                if (dVar.m != null) {
                    dVar.m.g();
                    dVar.m = null;
                    dVar.f6550d = null;
                }
                if (dVar.a != null) {
                    dVar.m = new c(i5, dVar.f6554h, dVar.f6555i, dVar.f6553g);
                }
            }
            I();
            J();
        }
    }

    public void w() {
        this.n = false;
        this.f6541l.e();
        int i2 = this.f6533d;
        for (int i3 = this.c; i3 < i2; i3++) {
            q(i3);
        }
    }
}
