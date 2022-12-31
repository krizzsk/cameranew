package com.pinguo.camera360.gallery.ui;

import android.graphics.Bitmap;
import com.pinguo.album.a;
import com.pinguo.camera360.gallery.RootActivity;
import com.pinguo.camera360.gallery.ui.g;
/* compiled from: AlbumSetSlotRenderer.java */
/* loaded from: classes3.dex */
public class h extends com.pinguo.camera360.gallery.ui.a {

    /* renamed from: k  reason: collision with root package name */
    protected com.pinguo.album.opengles.e f6559k;

    /* renamed from: l  reason: collision with root package name */
    private final RootActivity f6560l;
    protected final b m;
    protected g n;
    private z o;
    private int p;
    private boolean q;
    protected o r;
    private boolean s;
    private int t;

    /* compiled from: AlbumSetSlotRenderer.java */
    /* loaded from: classes3.dex */
    class a implements a.c {
        a(h hVar) {
        }

        @Override // com.pinguo.album.a.c
        public void a(a.InterfaceC0229a interfaceC0229a) {
        }

        @Override // com.pinguo.album.a.c
        public boolean b(int i2) {
            return false;
        }

        @Override // com.pinguo.album.a.c
        public boolean isCancelled() {
            return false;
        }
    }

    /* compiled from: AlbumSetSlotRenderer.java */
    /* loaded from: classes3.dex */
    public static class b {
        public int a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f6561d;

        /* renamed from: e  reason: collision with root package name */
        public int f6562e;

        /* renamed from: f  reason: collision with root package name */
        public int f6563f;

        /* renamed from: g  reason: collision with root package name */
        public int f6564g;

        /* renamed from: h  reason: collision with root package name */
        public int f6565h;

        /* renamed from: i  reason: collision with root package name */
        public int f6566i;

        /* renamed from: j  reason: collision with root package name */
        public int f6567j;

        /* renamed from: k  reason: collision with root package name */
        public int f6568k;

        /* renamed from: l  reason: collision with root package name */
        public int f6569l;
        public int m;
        public int n;
    }

    /* compiled from: AlbumSetSlotRenderer.java */
    /* loaded from: classes3.dex */
    private class c implements g.f {
        private c() {
        }

        @Override // com.pinguo.camera360.gallery.ui.g.f
        public void a(int i2) {
            h.this.o.q();
        }

        @Override // com.pinguo.camera360.gallery.ui.g.f
        public void b(int i2) {
            h.this.o.g1(i2);
            h.this.o.q();
        }

        /* synthetic */ c(h hVar, a aVar) {
            this();
        }
    }

    public h(RootActivity rootActivity, z zVar, o oVar, b bVar, int i2) {
        super(rootActivity);
        this.p = -1;
        this.f6560l = rootActivity;
        this.o = zVar;
        this.m = bVar;
        com.pinguo.album.opengles.e eVar = new com.pinguo.album.opengles.e(-2236963);
        this.f6559k = eVar;
        eVar.d(1, 1);
        this.r = oVar;
        this.t = i2;
    }

    private static com.pinguo.album.opengles.u w(com.pinguo.album.opengles.u uVar) {
        if ((uVar instanceof com.pinguo.album.opengles.y) && ((com.pinguo.album.opengles.y) uVar).z()) {
            return null;
        }
        return uVar;
    }

    protected int A(com.pinguo.album.opengles.l lVar, g.d dVar, int i2, int i3) {
        com.pinguo.album.opengles.u w = w(dVar.f6550d);
        if (w != null) {
            int height = w.getHeight();
            w.a(lVar, 0, i3 - height, w.getWidth(), height);
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int B(com.pinguo.album.opengles.l lVar, int i2, g.d dVar, int i3, int i4) {
        if (this.p == i2) {
            if (this.q) {
                s(lVar, i3, i4);
                if (u()) {
                    this.q = false;
                    this.p = -1;
                }
                return 2;
            }
            return 0;
        } else if (this.s) {
            int i5 = this.m.a + 6;
            if (this.r.h(dVar.f6552f, 0)) {
                l(lVar, i3 - i5, i4 - i5, i5, i5);
                return 0;
            }
            k(lVar, i3 - i5, i4 - i5, i5, i5);
            return 0;
        } else {
            return 0;
        }
    }

    public void C() {
        this.n.A();
    }

    public void D(com.pinguo.camera360.gallery.q qVar) {
        g gVar = this.n;
        if (gVar != null) {
            gVar.E(null);
            this.n = null;
            this.o.g1(0);
        }
        if (qVar != null) {
            g gVar2 = new g(this.f6560l, qVar, this.m, this.t, false);
            this.n = gVar2;
            gVar2.E(new c(this, null));
            this.o.g1(this.n.F());
        }
    }

    public void E(com.pinguo.camera360.gallery.q qVar, boolean z) {
        g gVar = this.n;
        if (gVar != null) {
            gVar.E(null);
            this.n = null;
            this.o.g1(0);
        }
        if (qVar != null) {
            g gVar2 = new g(this.f6560l, qVar, this.m, this.t, z);
            this.n = gVar2;
            gVar2.E(new c(this, null));
            this.o.g1(this.n.F());
        }
    }

    public void F(int i2) {
        if (this.p == i2) {
            return;
        }
        this.p = i2;
        this.o.q();
    }

    public void G() {
        if (this.p == -1) {
            return;
        }
        this.q = true;
        this.o.q();
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int a(int i2) {
        com.pinguo.camera360.gallery.data.w wVar;
        g.d r = this.n.r(i2);
        if (r == null || (wVar = r.b) == null) {
            return 0;
        }
        return wVar.w();
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public void b() {
        this.s = this.r.i();
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public Bitmap c(int i2, boolean z) {
        com.pinguo.camera360.gallery.data.w wVar;
        g.d r = this.n.r(i2);
        if (r == null || (wVar = r.b) == null) {
            return null;
        }
        return wVar.z(z ? 5 : 1).a(new a(this));
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public void d(int i2, int i3) {
        g gVar = this.n;
        if (gVar != null) {
            gVar.B(i2, i3);
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int e(int i2) {
        com.pinguo.camera360.gallery.data.w wVar;
        g.d r = this.n.r(i2);
        if (r == null || (wVar = r.b) == null) {
            return 0;
        }
        return wVar.t();
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int f(int i2) {
        com.pinguo.camera360.gallery.data.w wVar;
        g.d r = this.n.r(i2);
        if (r == null || (wVar = r.b) == null) {
            return 0;
        }
        return wVar.q();
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int g(com.pinguo.album.opengles.l lVar, int i2, int i3, int i4) {
        g.d r = this.n.r(i2);
        if (lVar == null || r == null) {
            return 0;
        }
        return B(lVar, i2, r, i3, i4) | 0 | z(lVar, r, i3, i4) | y(lVar, i3, i4) | A(lVar, r, i3, i4);
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int h(com.pinguo.album.opengles.l lVar, int i2, int i3, int i4, int i5) {
        return 0;
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public void i(int i2, int i3, int i4) {
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public void j(int i2, int i3) {
        g gVar = this.n;
        if (gVar != null) {
            gVar.v(i2, i3);
        }
    }

    public void x() {
        this.n.w();
    }

    protected int y(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int z(com.pinguo.album.opengles.l lVar, g.d dVar, int i2, int i3) {
        com.pinguo.album.opengles.u w = w(dVar.c);
        if (w == null) {
            this.f6559k.d(i2, i3);
            w = this.f6559k;
            dVar.f6557k = true;
        } else if (dVar.f6557k) {
            dVar.f6557k = false;
            w = dVar.f6551e;
            dVar.c = w;
        }
        q(lVar, w, i2, i3, dVar.f6556j, 0);
        return 0;
    }
}
