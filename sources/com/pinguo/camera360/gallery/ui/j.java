package com.pinguo.camera360.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import com.pinguo.album.a;
import com.pinguo.camera360.gallery.RootActivity;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.f0;
import com.pinguo.camera360.gallery.ui.i;
import com.pinguo.camera360.gallery.ui.l;
import com.pinguo.camera360.gallery.ui.z;
import java.util.ArrayList;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumSlotRenderer.java */
/* loaded from: classes3.dex */
public class j extends com.pinguo.camera360.gallery.ui.a {

    /* renamed from: k  reason: collision with root package name */
    private i f6587k;

    /* renamed from: l  reason: collision with root package name */
    private final RootActivity f6588l;
    private final z m;
    protected o n;
    protected int o;
    protected boolean p;
    private c q;
    protected final d r;
    private boolean s;
    private int t;
    private int u;
    private com.pinguo.camera360.gallery.n v;
    private final com.pinguo.album.opengles.r w;
    private final com.pinguo.album.opengles.r x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSlotRenderer.java */
    /* loaded from: classes3.dex */
    public class a implements a.c {
        a(j jVar) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumSlotRenderer.java */
    /* loaded from: classes3.dex */
    public class b implements i.c {
        private b() {
        }

        @Override // com.pinguo.camera360.gallery.ui.i.c
        public void a(int i2, ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3) {
            j.this.m.j1(arrayList, arrayList2, arrayList3);
            j.this.m.g1(i2);
            j jVar = j.this;
            jVar.n.a(jVar.m.P0(), j.this.m.N0());
        }

        @Override // com.pinguo.camera360.gallery.ui.i.c
        public void onContentChanged() {
            j.this.m.q();
        }

        /* synthetic */ b(j jVar, a aVar) {
            this();
        }
    }

    /* compiled from: AlbumSlotRenderer.java */
    /* loaded from: classes3.dex */
    public interface c {
        boolean a(int i2);
    }

    /* compiled from: AlbumSlotRenderer.java */
    /* loaded from: classes3.dex */
    public static class d {
        public int a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f6589d;

        /* renamed from: e  reason: collision with root package name */
        public int f6590e;

        /* renamed from: f  reason: collision with root package name */
        public int f6591f;

        /* renamed from: g  reason: collision with root package name */
        public int f6592g;

        /* renamed from: h  reason: collision with root package name */
        public int f6593h;

        /* renamed from: i  reason: collision with root package name */
        public int f6594i;

        /* renamed from: j  reason: collision with root package name */
        public int f6595j;
    }

    public j(RootActivity rootActivity, z zVar, o oVar, d dVar, int i2, int i3) {
        super(rootActivity);
        this.o = -1;
        this.f6588l = rootActivity;
        this.m = zVar;
        this.n = oVar;
        this.r = dVar;
        int i4 = f0.a(rootActivity).a.f6712g;
        this.y = i2;
        this.z = i3;
        new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.ARGB_8888;
        this.w = new com.pinguo.album.opengles.r(rootActivity, R.drawable.sound_on);
        this.x = new com.pinguo.album.opengles.r(rootActivity, R.drawable.video);
    }

    private static com.pinguo.album.opengles.u w(com.pinguo.album.opengles.u uVar) {
        if ((uVar instanceof com.pinguo.album.opengles.y) && ((com.pinguo.album.opengles.y) uVar).z()) {
            return null;
        }
        return uVar;
    }

    protected int A(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        lVar.s(2);
        int i4 = (this.r.f6590e * 6) / 5;
        lVar.a(i2 - i4, i3 - i4);
        int i5 = this.r.f6590e;
        y(lVar, i5, i5);
        lVar.b();
        return 0;
    }

    protected int B(com.pinguo.album.opengles.l lVar, int i2, i.b bVar, int i3, int i4, int i5) {
        int i6 = 0;
        if (this.o == i2) {
            if (this.p) {
                s(lVar, i3, i4);
                if (u()) {
                    this.p = false;
                    this.o = -1;
                }
                i6 = 2;
            } else {
                r(lVar, i3, i4);
            }
        }
        if (this.s) {
            if (this.n.h(bVar.b, i2)) {
                int i7 = this.r.f6594i + i5;
                l(lVar, i3 - i7, i4 - i7, i7, i7);
            } else {
                int i8 = this.r.f6594i;
                k(lVar, i3 - i8, i4 - i8, i8, i8);
            }
        }
        return i6;
    }

    public void C() {
        this.f6587k.x();
    }

    public void D(com.pinguo.camera360.gallery.n nVar) {
        E(nVar, true);
    }

    public void E(com.pinguo.camera360.gallery.n nVar, boolean z) {
        i iVar = this.f6587k;
        if (iVar != null) {
            iVar.A(null);
            this.m.g1(0);
            this.f6587k = null;
        }
        if (nVar != null) {
            this.v = nVar;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f6588l.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            z.f fVar = f0.a(this.f6588l).a;
            int i2 = (displayMetrics.widthPixels - fVar.f6713h) - fVar.f6712g;
            this.t = i2;
            int i3 = displayMetrics.heightPixels;
            int i4 = fVar.f6715j;
            int i5 = (i3 - i4) - i4;
            this.u = i5;
            i iVar2 = new i(this.f6588l, nVar, this.r, Math.min(i2, i5), fVar.f6711f, this.y, this.z, z);
            this.f6587k = iVar2;
            iVar2.A(new b(this, null));
            this.m.g1(nVar.H());
        }
    }

    public void F(int i2) {
        if (this.o == i2) {
            return;
        }
        this.o = i2;
        this.m.q();
    }

    public void G() {
        if (this.o == -1) {
            return;
        }
        this.p = true;
        this.m.q();
    }

    public void H(c cVar) {
        this.q = cVar;
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int a(int i2) {
        com.pinguo.camera360.gallery.data.w wVar;
        i.b p = this.f6587k.p(i2);
        if (p == null || (wVar = p.a) == null) {
            return 0;
        }
        return wVar.w();
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public void b() {
        this.s = this.n.i();
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public Bitmap c(int i2, boolean z) {
        com.pinguo.camera360.gallery.data.w wVar;
        i.b p = this.f6587k.p(i2);
        if (p == null || (wVar = p.a) == null) {
            return null;
        }
        return wVar.z(z ? 5 : 1).a(new a(this));
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public void d(int i2, int i3) {
        us.pinguo.common.log.a.k("onVisibleSlotRangeChanged visibleStart = " + i2 + " visibleEnd = " + i3, new Object[0]);
        i iVar = this.f6587k;
        if (iVar != null) {
            iVar.y(i2, i3);
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int e(int i2) {
        com.pinguo.camera360.gallery.data.w wVar;
        i.b p = this.f6587k.p(i2);
        if (p == null || (wVar = p.a) == null) {
            return 0;
        }
        return wVar.t();
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int f(int i2) {
        com.pinguo.camera360.gallery.data.w wVar;
        i.b p = this.f6587k.p(i2);
        if (p == null || (wVar = p.a) == null) {
            return 0;
        }
        return wVar.q();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    @Override // com.pinguo.camera360.gallery.ui.z.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int g(com.pinguo.album.opengles.l r16, int r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.gallery.ui.j.g(com.pinguo.album.opengles.l, int, int, int):int");
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public int h(com.pinguo.album.opengles.l lVar, int i2, int i3, int i4, int i5) {
        l q;
        l.b o;
        i iVar = this.f6587k;
        if (iVar == null || (o = (q = iVar.q(i5)).o(i2)) == null) {
            return 0;
        }
        com.pinguo.album.opengles.u w = w(o.a);
        y.c n = q.n(i2);
        if (w != null) {
            int height = w.getHeight();
            if (n.f6394f) {
                lVar.a((this.m.p() - Math.min(this.t, this.u)) / 2, (-i4) / 2);
            }
            w.a(lVar, this.r.f6593h, (i4 - height) / 2, Math.min(this.t, this.u), height);
        }
        if (this.s && !n.f6394f) {
            int width = this.f6504e.getWidth();
            int height2 = this.f6504e.getHeight();
            int i6 = (i4 - height2) / 2;
            if (n.f6397i) {
                lVar.a((this.m.p() - this.f6504e.getWidth()) - this.r.f6595j, i6);
                m(lVar, width, height2);
            } else {
                lVar.a((this.m.p() - this.f6505f.getWidth()) - this.r.f6595j, i6);
                t(lVar, this.f6505f.getWidth(), this.f6505f.getHeight());
            }
        }
        return 0;
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public void i(int i2, int i3, int i4) {
        i iVar = this.f6587k;
        if (iVar != null) {
            iVar.q(i4).x(i2, i3);
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.z.e
    public void j(int i2, int i3) {
    }

    public Bitmap x(int i2) {
        try {
            Bitmap v = this.f6587k.p(i2).f6580e.v();
            Bitmap createBitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), v.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            int i3 = this.f6587k.p(i2).c;
            Matrix matrix = new Matrix();
            matrix.setRotate(i3, v.getWidth() / 2, v.getHeight() / 2);
            canvas.drawBitmap(v, matrix, null);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    protected void y(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        com.pinguo.album.opengles.r rVar = this.w;
        if (rVar != null) {
            com.pinguo.camera360.gallery.ui.a.p(lVar, rVar, 0, 0, i2, i3);
        }
    }

    public void z() {
        this.f6587k.t();
    }
}
