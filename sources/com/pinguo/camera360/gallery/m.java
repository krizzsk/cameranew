package com.pinguo.camera360.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.ui.AlbumCoverInfoView;
import com.pinguo.camera360.gallery.ui.c;
import com.pinguo.camera360.gallery.ui.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumCoverPage.java */
/* loaded from: classes3.dex */
public class m extends ActivityState implements View.OnClickListener, Toolbar.OnMenuItemClickListener {
    private int A;
    private Path B;
    private com.pinguo.camera360.gallery.ui.toolbar.b C;
    protected com.pinguo.camera360.gallery.ui.r D;
    protected com.pinguo.camera360.gallery.ui.x E;
    private Bitmap F;
    private AtomicBoolean G = new AtomicBoolean(false);
    private final com.pinguo.album.views.a H = new a();
    private com.pinguo.camera360.gallery.ui.d p;
    private float q;
    private com.pinguo.album.opengles.c r;
    private String s;
    private long[] t;
    private int u;
    private int[] v;
    private q w;
    protected com.pinguo.camera360.gallery.ui.g x;
    private com.pinguo.camera360.gallery.data.y y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumCoverPage.java */
    /* loaded from: classes3.dex */
    public class a extends com.pinguo.album.views.a {

        /* renamed from: l  reason: collision with root package name */
        private final float[] f6411l = new float[16];

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.pinguo.album.views.a
        public void v(boolean z, int i2, int i3, int i4, int i5) {
            m.this.p.r(i2, i3, i4, i5);
            com.pinguo.album.j.c.n(this.f6411l, p() / 2, n() / 2, -m.this.q);
        }

        @Override // com.pinguo.album.views.a
        public void y(com.pinguo.album.opengles.l lVar) {
            lVar.s(2);
            lVar.j(this.f6411l, 0);
            super.y(lVar);
            lVar.b();
        }

        @Override // com.pinguo.album.views.a
        protected void z(com.pinguo.album.opengles.l lVar) {
            lVar.m();
        }
    }

    /* compiled from: AlbumCoverPage.java */
    /* loaded from: classes3.dex */
    class b extends com.pinguo.camera360.gallery.ui.y {
        b() {
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void o(int i2) {
            d.f.a.b.d.d("AlbumCoverImageView flingOri = " + i2, new Object[0]);
            if (i2 == 3 || i2 == 4) {
                m.this.D0(i2);
            } else if (i2 == 2) {
                m.this.z0();
            } else if (i2 == 1) {
                m.this.E();
            }
        }
    }

    /* compiled from: AlbumCoverPage.java */
    /* loaded from: classes3.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            m.this.E();
        }
    }

    /* compiled from: AlbumCoverPage.java */
    /* loaded from: classes3.dex */
    class d implements c.b {
        final /* synthetic */ com.pinguo.camera360.gallery.data.y a;

        d(com.pinguo.camera360.gallery.data.y yVar) {
            this.a = yVar;
        }

        @Override // com.pinguo.camera360.gallery.ui.c.b
        public void a(String str) {
            m mVar = m.this;
            mVar.F0(mVar.t, m.this.u, str);
            m.this.D.z(R.id.action_rename_album, this.a.g(), str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumCoverPage.java */
    /* loaded from: classes3.dex */
    public class e implements g.f {
        private e() {
        }

        @Override // com.pinguo.camera360.gallery.ui.g.f
        public void a(int i2) {
            if (i2 == m.this.z && m.this.G.get()) {
                m mVar = m.this;
                g.d r = mVar.x.r(mVar.z);
                com.pinguo.album.opengles.c cVar = r.f6551e;
                d.f.a.b.d.d("AlbumCoverPage bitmapTexture slotIndex = " + cVar, new Object[0]);
                if (cVar == null) {
                    cVar = m.this.A0();
                }
                if (cVar != null) {
                    m.this.r = cVar;
                    m mVar2 = m.this;
                    mVar2.G0(mVar2.r, r.f6556j);
                }
                com.pinguo.camera360.gallery.data.y B = m.this.w.B(m.this.z);
                if (B != null) {
                    if (B instanceof com.pinguo.camera360.gallery.data.g) {
                        m.this.t = ((com.pinguo.camera360.gallery.data.g) B).L();
                    }
                    m.this.s = B.s();
                    m.this.u = B.r();
                    m mVar3 = m.this;
                    mVar3.F0(mVar3.t, m.this.u, m.this.s);
                }
            }
        }

        @Override // com.pinguo.camera360.gallery.ui.g.f
        public void b(int i2) {
            if (m.this.A != 0 && m.this.A - i2 == 1 && i2 > 0) {
                m mVar = m.this;
                mVar.z = com.pinguo.album.j.a.e(m.q0(mVar), 0, i2 - 1);
            }
            m.this.A = i2;
            m mVar2 = m.this;
            mVar2.E0(mVar2.z);
        }

        /* synthetic */ e(m mVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.pinguo.album.opengles.c A0() {
        if (this.F == null) {
            this.F = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
            new Canvas(this.F).drawColor(-2236963);
        }
        return new com.pinguo.album.opengles.c(this.F);
    }

    private float B0(int i2, com.pinguo.album.opengles.c cVar) {
        int i3 = n0.i();
        int h2 = n0.h();
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        if (i2 == 90 || i2 == 270) {
            width = cVar.getHeight();
            height = cVar.getWidth();
        }
        return Math.max(i3 / width, h2 / height);
    }

    private void C0(Bundle bundle) {
        this.s = bundle.getString("media-name");
        this.t = bundle.getLongArray("pics_date");
        this.u = bundle.getInt("pics_count");
        this.z = bundle.getInt(FirebaseAnalytics.Param.INDEX);
        this.v = bundle.getIntArray("set-center");
        this.B = new Path(bundle.getInt("media-type"), bundle.getString("media-path-id"));
        com.pinguo.camera360.gallery.data.y e2 = this.a.P().e(this.B, "");
        this.y = e2;
        q qVar = new q(this.a, e2);
        this.w = qVar;
        qVar.H(new f(this, null));
        this.C = com.pinguo.camera360.gallery.ui.toolbar.r.a(4);
        g0 a2 = g0.a(this.a);
        com.pinguo.camera360.gallery.ui.g gVar = this.x;
        if (gVar != null) {
            gVar.E(null);
            this.x = null;
        }
        q qVar2 = this.w;
        if (qVar2 != null) {
            com.pinguo.camera360.gallery.ui.g gVar2 = new com.pinguo.camera360.gallery.ui.g(this.a, qVar2, a2.b, 5, false);
            this.x = gVar2;
            gVar2.E(new e(this, null));
            this.x.C(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i2) {
        int i3 = this.A;
        if (i3 == 0) {
            return;
        }
        int i4 = this.z;
        if (i2 == 3) {
            i4 = com.pinguo.album.j.a.e(i4 - 1, 0, i3 - 1);
        } else if (i2 == 4) {
            i4 = com.pinguo.album.j.a.e(i4 + 1, 0, i3 - 1);
        }
        if (i4 == this.z) {
            return;
        }
        this.z = i4;
        com.pinguo.camera360.gallery.data.y B = this.w.B(i4);
        if (B instanceof com.pinguo.camera360.gallery.data.g) {
            this.t = ((com.pinguo.camera360.gallery.data.g) B).L();
        }
        this.s = B.s();
        int r = B.r();
        this.u = r;
        F0(this.t, r, this.s);
        E0(this.z);
        d.f.a.b.d.d("AlbumCoverPage mCurAlbumSetIndex = " + this.z, new Object[0]);
        g.d r2 = this.x.r(this.z);
        this.r = r2.f6551e;
        this.G.set(true);
        if (this.r == null) {
            this.r = A0();
        }
        d.f.a.b.d.d("AlbumCoverPage bitmapTexture = " + this.r, new Object[0]);
        G0(this.r, r2.f6556j);
        this.p.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i2) {
        int e2 = com.pinguo.album.j.a.e(i2 - 1, 0, this.A);
        int e3 = com.pinguo.album.j.a.e(i2 + 2, 0, this.A);
        d.f.a.b.d.d("AlbumCoverPage startIndex = " + e2 + " endIndex = " + e3, new Object[0]);
        this.x.B(e2, e3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(long[] jArr, int i2, String str) {
        AlbumCoverInfoView albumCoverInfoView = (AlbumCoverInfoView) y();
        String d2 = us.pinguo.util.u.d(jArr[0], "yyyy.MM");
        String d3 = us.pinguo.util.u.d(jArr[jArr.length - 1], "yyyy.MM");
        if (d2 == null || !d3.equals(d2)) {
            d3 = d3 + "--" + d2;
        }
        albumCoverInfoView.setEnterAlbumPageListener(this);
        albumCoverInfoView.b(str, d3, i2 + this.a.getResources().getString(R.string.album_label_suffix));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(com.pinguo.album.opengles.c cVar, int i2) {
        d.f.a.b.d.d("AlbumCoverPage updateCoverViewContent bitmapTexture = " + cVar, new Object[0]);
        this.p.P(cVar, B0(i2, cVar), i2);
    }

    static /* synthetic */ int q0(m mVar) {
        int i2 = mVar.z;
        mVar.z = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        int z = this.w.z(this.z);
        if (z == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        com.pinguo.camera360.gallery.data.y B = this.w.B(this.z);
        bundle.putInt("media-type", B.g().h());
        bundle.putString("media-path-id", String.valueOf(z));
        bundle.putString("media-name", B.s());
        bundle.putIntArray("set-center", this.v);
        bundle.putInt("layout_type", 4);
        bundle.putInt("toolbar_type", 2);
        a0(m.class, v.class, StateTransAnim.Transition.TranslateIn);
        this.a.E0().r(v.class, 1, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        Bitmap bitmap;
        int i2;
        super.G(bundle, bundle2);
        C0(bundle);
        this.q = n0.o(0.3f);
        int i3 = n0.i();
        int h2 = n0.h();
        if (this.a.H0() != null) {
            bitmap = (Bitmap) this.a.H0().b("texture_key");
            i2 = ((Integer) this.a.H0().c("rotation_key", 0)).intValue();
        } else {
            bitmap = null;
            i2 = 0;
        }
        if (bitmap == null) {
            this.r = A0();
            this.G.set(true);
        } else {
            this.G.set(false);
            this.r = new com.pinguo.album.opengles.c(bitmap);
        }
        float B0 = B0(i2, this.r);
        d.f.a.b.d.d("AlbumCoverImageView screenWidth = " + i3 + "screenHeight =  " + h2 + " texture.getWidth() = " + this.r.getWidth() + " texture.getHeight() = " + this.r.getHeight() + " textureScale = " + B0, new Object[0]);
        com.pinguo.camera360.gallery.ui.d dVar = new com.pinguo.camera360.gallery.ui.d(this.a, this.r, B0, i2);
        this.p = dVar;
        this.H.c(dVar);
        this.p.O(new b());
        com.pinguo.camera360.gallery.ui.x xVar = new com.pinguo.camera360.gallery.ui.x(this.a, false);
        this.E = xVar;
        this.D = new com.pinguo.camera360.gallery.ui.r(this.a, xVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public boolean H(Menu menu) {
        this.C.g(this.a.F0(), this.a.G0(), menu, this.a);
        this.C.l(this);
        this.C.k(new c());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void I() {
        super.I();
        this.F = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void J() {
        super.J();
        this.w.D();
        this.x.w();
        this.C.i(this.a);
        com.pinguo.album.opengles.c cVar = this.r;
        if (cVar != null) {
            cVar.o();
        }
        this.p.I();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void L() {
        super.L();
        d.f.a.b.d.d("sBitmapTexture = " + this.r, new Object[0]);
        Q(this.H);
        W(R.layout.album_cover_page_info_layout);
        this.p.D(0);
        F0(this.t, this.u, this.s);
        com.pinguo.album.opengles.c cVar = this.r;
        if (cVar == null || cVar.I()) {
            this.G.set(true);
        }
        this.w.E();
        this.x.A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void O(int i2, int i3, Intent intent) {
        ArrayList<Path> parcelableArrayListExtra;
        if (i2 == 1 && intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("path_list")) != null && parcelableArrayListExtra.size() > 0) {
            this.G.set(true);
            this.D.w(R.id.action_confirm_add_pics, this.w.B(this.z).g(), parcelableArrayListExtra, null);
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        com.pinguo.album.views.b E = this.a.E();
        if (view.getId() != R.id.enter_slot_page_icon) {
            return;
        }
        E.c();
        try {
            z0();
        } finally {
            E.g();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    @Instrumented
    public boolean onMenuItemClick(MenuItem menuItem) {
        VdsAgent.onMenuItemClick(this, menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_add_pics) {
            com.pinguo.album.views.b E = this.a.E();
            E.c();
            try {
                com.pinguo.camera360.gallery.data.y B = this.w.B(this.z);
                Bundle bundle = new Bundle();
                bundle.putParcelable("path_list", B.g());
                bundle.putInt("media-type", 1202);
                bundle.putString("media-path-id", "path-big-album-def");
                a0(m.class, p.class, StateTransAnim.Transition.BottomToTop);
                this.a.E0().r(p.class, 1, bundle);
            } finally {
                E.g();
            }
        } else if (itemId == R.id.action_delete_album) {
            com.pinguo.camera360.gallery.data.y B2 = this.w.B(this.z);
            this.E.k();
            this.E.b(B2.g());
            this.D.p(R.id.action_delete_album, R.string.pgcommon_delete_tip, null);
            this.G.set(true);
        } else if (itemId == R.id.action_rename_album) {
            com.pinguo.camera360.gallery.data.y B3 = this.w.B(this.z);
            com.pinguo.camera360.gallery.ui.c cVar = new com.pinguo.camera360.gallery.ui.c(this.a, R.string.input_update_album_name);
            cVar.c(this.s);
            cVar.b(new d(B3));
            cVar.show();
        }
        VdsAgent.handleClickResult(new Boolean(false));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumCoverPage.java */
    /* loaded from: classes3.dex */
    public class f implements x {
        int a;

        private f() {
            this.a = 0;
        }

        @Override // com.pinguo.camera360.gallery.x
        public void c() {
            if (m.this.D()) {
                return;
            }
            m.this.a.M0(false);
            synchronized (com.pinguo.camera360.gallery.data.o.f6371d) {
                int u = m.this.y.u();
                this.a = u;
                if (u == 0) {
                    m.this.a.E0().d(m.this);
                }
                com.pinguo.camera360.gallery.data.y B = m.this.w.B(m.this.z);
                if (B != null && B.r() == 0) {
                    if (m.this.r == null || m.this.r.I()) {
                        m mVar = m.this;
                        mVar.r = mVar.A0();
                    }
                    m mVar2 = m.this;
                    mVar2.G0(mVar2.r, 0);
                }
            }
        }

        @Override // com.pinguo.camera360.gallery.x
        public void d() {
        }

        /* synthetic */ f(m mVar, a aVar) {
            this();
        }
    }
}
