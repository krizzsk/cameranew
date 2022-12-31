package com.pinguo.camera360.gallery.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.n;
import com.pinguo.camera360.gallery.ui.j;
import java.util.ArrayList;
/* compiled from: AlbumSlidingWindow.java */
/* loaded from: classes3.dex */
public class i implements n.b {
    private final com.pinguo.camera360.gallery.n a;
    private final b[] b;
    private final com.pinguo.album.g c;

    /* renamed from: d  reason: collision with root package name */
    private final com.pinguo.album.common.b f6570d;

    /* renamed from: e  reason: collision with root package name */
    private final com.pinguo.album.opengles.v f6571e;

    /* renamed from: f  reason: collision with root package name */
    private int f6572f;

    /* renamed from: k  reason: collision with root package name */
    private c f6577k;
    private boolean n;
    private int o;
    private l p;
    private l q;

    /* renamed from: g  reason: collision with root package name */
    private int f6573g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f6574h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f6575i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f6576j = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f6578l = 0;
    private volatile boolean m = false;

    /* compiled from: AlbumSlidingWindow.java */
    /* loaded from: classes3.dex */
    class a extends com.pinguo.album.g {
        a(i iVar, com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                ((d) message.obj).a();
            }
        }
    }

    /* compiled from: AlbumSlidingWindow.java */
    /* loaded from: classes3.dex */
    public static class b {
        public com.pinguo.camera360.gallery.data.w a;
        public Path b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6579d;

        /* renamed from: e  reason: collision with root package name */
        public com.pinguo.album.opengles.c f6580e;

        /* renamed from: f  reason: collision with root package name */
        public com.pinguo.album.opengles.t f6581f;

        /* renamed from: g  reason: collision with root package name */
        public com.pinguo.album.opengles.u f6582g;

        /* renamed from: h  reason: collision with root package name */
        private com.pinguo.album.data.utils.c f6583h;
    }

    /* compiled from: AlbumSlidingWindow.java */
    /* loaded from: classes3.dex */
    public interface c {
        void a(int i2, ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3);

        void onContentChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumSlidingWindow.java */
    /* loaded from: classes3.dex */
    public class d extends com.pinguo.album.data.utils.c {

        /* renamed from: d  reason: collision with root package name */
        private final int f6584d;

        /* renamed from: e  reason: collision with root package name */
        private final com.pinguo.camera360.gallery.data.w f6585e;

        public d(int i2, com.pinguo.camera360.gallery.data.w wVar) {
            this.f6584d = i2;
            this.f6585e = wVar;
        }

        public void a() {
            Bitmap d2 = d();
            if (d2 == null) {
                return;
            }
            b bVar = i.this.b[this.f6584d % i.this.b.length];
            bVar.f6580e = new com.pinguo.album.opengles.c(d2);
            if ((bVar.a instanceof com.pinguo.camera360.gallery.data.u) && i.this.n) {
                bVar.f6581f = com.pinguo.album.opengles.t.K(((com.pinguo.camera360.gallery.data.u) bVar.a).G(), com.pinguo.album.j.c.e(13), -1);
            }
            bVar.f6582g = bVar.f6580e;
            if (i.this.s(this.f6584d)) {
                i.this.f6571e.d(bVar.f6580e);
                if (bVar.f6581f != null) {
                    i.this.f6571e.d(bVar.f6581f);
                }
                i.j(i.this);
                if (i.this.f6578l == 0) {
                    i.this.v();
                }
                if (i.this.f6577k != null) {
                    i.this.f6577k.onContentChanged();
                    return;
                }
                return;
            }
            i.this.f6571e.c(bVar.f6580e);
            if (bVar.f6581f != null) {
                i.this.f6571e.c(bVar.f6581f);
            }
        }

        @Override // com.pinguo.album.data.utils.c
        protected void f(Bitmap bitmap) {
            i.this.c.obtainMessage(0, this).sendToTarget();
        }

        @Override // com.pinguo.album.data.utils.c
        protected void h(Bitmap bitmap) {
            PGAlbumBitmapPool.getInstance().f(bitmap);
        }

        @Override // com.pinguo.album.data.utils.c
        protected com.pinguo.album.c<Bitmap> j(com.pinguo.album.d<Bitmap> dVar) {
            System.currentTimeMillis();
            return i.this.o == 4 ? i.this.f6570d.a(this.f6585e.A(4), this) : i.this.f6570d.a(this.f6585e.A(2), this);
        }
    }

    public i(com.pinguo.camera360.gallery.l lVar, com.pinguo.camera360.gallery.n nVar, j.d dVar, int i2, int i3, int i4, int i5, boolean z) {
        nVar.F(this);
        this.a = nVar;
        this.b = new b[i4];
        this.o = i5;
        this.f6572f = nVar.H();
        this.c = new a(this, lVar.E());
        this.f6570d = new com.pinguo.album.common.b(lVar.G(), 2);
        com.pinguo.album.opengles.v vVar = new com.pinguo.album.opengles.v(lVar.E());
        this.f6571e = vVar;
        this.p = new l(lVar, this, vVar, dVar, i2, i3, l.o);
        this.q = new l(lVar, this, vVar, dVar, i2, i3, l.p);
        this.n = z;
    }

    private void B() {
        this.f6578l = 0;
        int i2 = this.f6576j;
        for (int i3 = this.f6575i; i3 < i2; i3++) {
            if (w(i3)) {
                this.f6578l++;
            }
        }
        if (this.f6578l == 0) {
            v();
        } else {
            m();
        }
    }

    private void C() {
        if (this.m) {
            this.f6571e.e();
            int i2 = this.f6576j;
            for (int i3 = this.f6575i; i3 < i2; i3++) {
                b[] bVarArr = this.b;
                b bVar = bVarArr[i3 % bVarArr.length];
                com.pinguo.album.opengles.c cVar = bVar.f6580e;
                if (cVar != null) {
                    this.f6571e.d(cVar);
                }
                com.pinguo.album.opengles.t tVar = bVar.f6581f;
                if (tVar != null) {
                    this.f6571e.d(tVar);
                }
            }
            int max = Math.max(this.f6574h - this.f6576j, this.f6575i - this.f6573g);
            for (int i4 = 0; i4 < max; i4++) {
                D(this.f6576j + i4);
                D((this.f6575i - i4) - 1);
            }
        }
    }

    private void D(int i2) {
        com.pinguo.album.opengles.v vVar = this.f6571e;
        if (vVar != null && i2 < this.f6574h && i2 >= this.f6573g) {
            b[] bVarArr = this.b;
            b bVar = bVarArr[i2 % bVarArr.length];
            com.pinguo.album.opengles.c cVar = bVar.f6580e;
            if (cVar != null) {
                vVar.c(cVar);
            }
            com.pinguo.album.opengles.t tVar = bVar.f6581f;
            if (tVar != null) {
                this.f6571e.c(tVar);
            }
        }
    }

    static /* synthetic */ int j(i iVar) {
        int i2 = iVar.f6578l - 1;
        iVar.f6578l = i2;
        return i2;
    }

    private void m() {
        int max = Math.max(this.f6574h - this.f6576j, this.f6575i - this.f6573g);
        for (int i2 = 0; i2 < max; i2++) {
            n(this.f6576j + i2);
            n((this.f6575i - 1) - i2);
        }
    }

    private void n(int i2) {
        if (i2 < this.f6573g || i2 >= this.f6574h) {
            return;
        }
        b[] bVarArr = this.b;
        b bVar = bVarArr[i2 % bVarArr.length];
        if (bVar.f6583h != null) {
            bVar.f6583h.c();
        }
    }

    private void o(int i2) {
        b[] bVarArr = this.b;
        int length = i2 % bVarArr.length;
        b bVar = bVarArr[length];
        if (bVar == null) {
            return;
        }
        if (bVar.f6583h != null) {
            bVar.f6583h.g();
        }
        com.pinguo.album.opengles.c cVar = bVar.f6580e;
        if (cVar != null) {
            cVar.o();
        }
        com.pinguo.album.opengles.t tVar = bVar.f6581f;
        if (tVar != null) {
            tVar.o();
        }
        bVarArr[length] = null;
    }

    private void u(int i2) {
        b bVar = new b();
        com.pinguo.camera360.gallery.data.w w = this.a.w(i2);
        bVar.a = w;
        if (w != null) {
            w.f();
        }
        bVar.b = w == null ? null : w.g();
        bVar.c = w == null ? 0 : w.t();
        bVar.f6583h = new d(i2, bVar.a);
        b[] bVarArr = this.b;
        bVarArr[i2 % bVarArr.length] = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        int max = Math.max(this.f6574h - this.f6576j, this.f6575i - this.f6573g);
        for (int i2 = 0; i2 < max; i2++) {
            w(this.f6576j + i2);
            w((this.f6575i - 1) - i2);
        }
    }

    private boolean w(int i2) {
        if (i2 >= this.f6573g && i2 < this.f6574h) {
            b[] bVarArr = this.b;
            b bVar = bVarArr[i2 % bVarArr.length];
            if (bVar.f6582g == null && bVar.a != null) {
                bVar.f6583h.i();
                return bVar.f6583h.e();
            }
        }
        return false;
    }

    private void z(int i2, int i3) {
        int i4;
        if (i2 == this.f6573g && i3 == this.f6574h) {
            return;
        }
        if (!this.m) {
            this.f6573g = i2;
            this.f6574h = i3;
            this.a.D(i2, i3);
            return;
        }
        int i5 = this.f6574h;
        if (i2 < i5 && (i4 = this.f6573g) < i3) {
            for (i4 = this.f6573g; i4 < i2; i4++) {
                o(i4);
            }
            int i6 = this.f6574h;
            for (int i7 = i3; i7 < i6; i7++) {
                o(i7);
            }
            this.a.D(i2, i3);
            int i8 = this.f6573g;
            for (int i9 = i2; i9 < i8; i9++) {
                u(i9);
            }
            for (int i10 = this.f6574h; i10 < i3; i10++) {
                u(i10);
            }
        } else {
            for (int i11 = this.f6573g; i11 < i5; i11++) {
                o(i11);
            }
            this.a.D(i2, i3);
            for (int i12 = i2; i12 < i3; i12++) {
                u(i12);
            }
        }
        this.f6573g = i2;
        this.f6574h = i3;
    }

    public void A(c cVar) {
        this.f6577k = cVar;
        this.p.y(cVar);
        this.q.y(cVar);
    }

    @Override // com.pinguo.camera360.gallery.n.b
    public void a(int i2, ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3) {
        if (this.f6572f != i2) {
            us.pinguo.common.log.a.k("----------1-----------onSizeChanged:" + System.currentTimeMillis(), new Object[0]);
            this.f6572f = i2;
            this.p.A(arrayList);
            this.q.A(arrayList2);
            this.p.q(i2, arrayList, arrayList2, arrayList3);
            this.q.q(i2, arrayList2, arrayList, arrayList3);
            int i3 = this.f6574h;
            int i4 = this.f6572f;
            if (i3 > i4) {
                this.f6574h = i4;
            }
        }
    }

    @Override // com.pinguo.camera360.gallery.n.b
    public void b(int i2) {
        if (i2 < this.f6573g || i2 >= this.f6574h || !this.m) {
            return;
        }
        com.pinguo.album.opengles.v vVar = this.f6571e;
        if (vVar != null) {
            vVar.e();
        }
        o(i2);
        u(i2);
        B();
        w(i2);
        if (this.f6577k == null || !s(i2)) {
            return;
        }
        this.f6577k.onContentChanged();
    }

    public b p(int i2) {
        if (s(i2)) {
            b[] bVarArr = this.b;
            return bVarArr[i2 % bVarArr.length];
        }
        com.pinguo.album.j.a.k("invalid slot: %s outsides (%s, %s)", Integer.valueOf(i2), Integer.valueOf(this.f6575i), Integer.valueOf(this.f6576j));
        throw null;
    }

    public l q(int i2) {
        if (i2 == l.o) {
            return this.p;
        }
        if (i2 == l.p) {
            return this.q;
        }
        return this.p;
    }

    public boolean r() {
        return this.m;
    }

    public boolean s(int i2) {
        return i2 >= this.f6575i && i2 < this.f6576j;
    }

    public void t() {
        this.m = false;
        this.f6571e.e();
        int i2 = this.f6574h;
        for (int i3 = this.f6573g; i3 < i2; i3++) {
            o(i3);
        }
        this.p.s();
        this.q.s();
    }

    public void x() {
        us.pinguo.common.log.a.k("------------------------resume - mContentStart" + this.f6573g + " mContentEnd:" + this.f6574h, new Object[0]);
        this.m = true;
        int i2 = this.f6574h;
        for (int i3 = this.f6573g; i3 < i2; i3++) {
            u(i3);
        }
        this.p.w();
        this.q.w();
        B();
    }

    public void y(int i2, int i3) {
        int i4;
        if (i2 == 0 && i3 == 0 && this.f6572f < 0) {
            return;
        }
        if (i2 <= i3) {
            int i5 = i3 - i2;
            b[] bVarArr = this.b;
            if (i5 <= bVarArr.length && i3 <= (i4 = this.f6572f)) {
                this.f6575i = i2;
                this.f6576j = i3;
                int e2 = com.pinguo.album.j.a.e(((i2 + i3) / 2) - (bVarArr.length / 2), 0, Math.max(0, i4 - bVarArr.length));
                z(e2, Math.min(bVarArr.length + e2, this.f6572f));
                C();
                if (this.m) {
                    B();
                    return;
                }
                return;
            }
        }
        com.pinguo.album.j.a.k("%s, %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.b.length), Integer.valueOf(this.f6572f));
        throw null;
    }
}
