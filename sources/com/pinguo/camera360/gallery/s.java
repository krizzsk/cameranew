package com.pinguo.camera360.gallery;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import com.pinguo.album.b;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.c;
import com.pinguo.camera360.gallery.ui.o;
import com.pinguo.camera360.gallery.ui.z;
import com.pinguo.camera360.k.b.a;
import us.pinguo.bigalbum.BigAlbumManager;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumSetPage.java */
/* loaded from: classes3.dex */
public abstract class s extends ActivityState implements b.InterfaceC0230b, y.d, o.a {
    private com.pinguo.camera360.gallery.ui.h A;
    private com.pinguo.album.b B;
    private float C;
    private float D;
    private float E;
    protected com.pinguo.camera360.gallery.ui.toolbar.b F;
    protected com.pinguo.camera360.gallery.ui.b0.a G;
    protected com.pinguo.camera360.gallery.ui.r H;
    private String I;
    private AlertDialog J;
    private com.pinguo.camera360.gallery.data.y p;
    private Path q;
    protected q r;
    private Handler w;
    protected com.pinguo.camera360.gallery.ui.o x;
    protected com.pinguo.camera360.gallery.ui.z y;
    protected z.f z;
    protected boolean s = false;
    private com.pinguo.album.c<Integer> t = null;
    private int u = 0;
    private boolean v = false;
    private final com.pinguo.album.views.a K = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    public class a extends com.pinguo.album.views.a {

        /* renamed from: l  reason: collision with root package name */
        private final float[] f6453l = new float[16];

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.pinguo.album.views.a
        public void v(boolean z, int i2, int i3, int i4, int i5) {
            int height = s.this.a.F0().getHeight();
            s sVar = s.this;
            sVar.z.m = height;
            sVar.B.f();
            int i6 = i4 - i2;
            s.this.y.k1(height);
            s sVar2 = s.this;
            com.pinguo.camera360.gallery.ui.z zVar = sVar2.y;
            z.f fVar = sVar2.z;
            zVar.r(fVar.f6712g + 0, 0, i6 - fVar.f6713h, (i5 - i3) - fVar.f6715j);
        }

        @Override // com.pinguo.album.views.a
        public void y(com.pinguo.album.opengles.l lVar) {
            lVar.s(2);
            com.pinguo.album.j.c.n(this.f6453l, (p() / 2) + s.this.C, (n() / 2) + s.this.D, s.this.E);
            lVar.j(this.f6453l, 0);
            super.y(lVar);
            lVar.b();
        }

        @Override // com.pinguo.album.views.a
        protected void z(com.pinguo.album.opengles.l lVar) {
            lVar.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    public class b extends com.pinguo.album.g {
        b(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                s.this.G0(message.arg1);
                return;
            }
            throw new AssertionError(message.what);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    public class c extends com.pinguo.camera360.gallery.ui.y {

        /* compiled from: AlbumSetPage.java */
        /* loaded from: classes3.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                s.this.a.F0().c();
                if (s.this.a.B0() != null) {
                    s.this.a.B0().U();
                }
            }
        }

        /* compiled from: AlbumSetPage.java */
        /* loaded from: classes3.dex */
        class b implements Runnable {
            final /* synthetic */ int a;

            b(int i2) {
                this.a = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                s.this.I0(this.a);
            }
        }

        c() {
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void c(int i2) {
            s.this.A0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void f(int i2, int i3) {
            us.pinguo.common.log.a.k("onScrollPositionChanged position = " + i2 + " total = " + i3, new Object[0]);
            s.this.a.runOnUiThread(new b(i2));
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void g(int i2) {
            s.this.D0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void i(boolean z) {
            s.this.F0(z);
            s.this.a.runOnUiThread(new a());
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void l(int i2, float f2, float f3) {
            s.this.E0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void o(int i2) {
            if (i2 == 1) {
                s.this.B0();
            } else if (i2 == 2) {
                s.this.C0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            if (i2 == -1) {
                BigAlbumManager.instance().commitMapGallery();
                s.this.J0();
                return;
            }
            dialogInterface.cancel();
            if ((s.this.p instanceof com.pinguo.camera360.gallery.data.i) && ((com.pinguo.camera360.gallery.data.i) s.this.p).E()) {
                s.this.J0();
            } else {
                s.this.L0(0, false);
            }
            BigAlbumManager.instance().rollbackMapGallery();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            com.pinguo.album.views.b E = s.this.a.E();
            E.c();
            s.this.E();
            E.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    public class f implements Toolbar.OnMenuItemClickListener {
        f() {
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        @Instrumented
        public boolean onMenuItemClick(MenuItem menuItem) {
            VdsAgent.onMenuItemClick(this, menuItem);
            if (menuItem.getItemId() == R.id.action_add_album) {
                s.this.o0();
            }
            VdsAgent.handleClickResult(new Boolean(true));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    public class g implements c.b {
        g() {
        }

        @Override // com.pinguo.camera360.gallery.ui.c.b
        public void a(String str) {
            s.this.I = str;
            s.this.s0();
            a.d.a();
        }
    }

    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    class h implements Runnable {
        final /* synthetic */ int a;

        h(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.pinguo.album.views.b E = s.this.a.E();
            E.c();
            try {
                if (this.a == 0) {
                    s.this.v = true;
                }
                s.this.p0(2);
                if (this.a == 2 && s.this.s) {
                    us.pinguo.common.log.a.s("failed to load album set", new Object[0]);
                }
            } finally {
                E.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumSetPage.java */
    /* loaded from: classes3.dex */
    public class i implements x {
        private i() {
        }

        @Override // com.pinguo.camera360.gallery.x
        public void c() {
            int u;
            if (s.this.D()) {
                return;
            }
            s.this.a.M0(false);
            synchronized (com.pinguo.camera360.gallery.data.o.f6371d) {
                u = s.this.p.u();
                s.this.K0(u);
            }
            s.this.L0(u, true);
            s.this.p0(1);
        }

        @Override // com.pinguo.camera360.gallery.x
        public void d() {
            s.this.H0(1);
        }

        /* synthetic */ i(s sVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i2) {
        this.A.F(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(boolean z) {
        if (z) {
            this.A.F(-1);
        } else {
            this.A.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(int i2) {
        this.u = i2 | this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        H0(1);
        this.r.E();
        this.A.C();
        this.B.g();
        if (this.v) {
            return;
        }
        H0(2);
        this.t = this.p.z(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i2) {
        this.u = (~i2) & this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        com.pinguo.album.views.b E = this.a.E();
        E.c();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("media-type", 1202);
            bundle.putString("media-path-id", "path-big-album-def");
            a0(m.class, p.class, StateTransAnim.Transition.BottomToTop);
            this.a.E0().r(p.class, 2, bundle);
        } finally {
            E.g();
        }
    }

    private void w0(Bundle bundle) {
        this.q = new Path(bundle.getInt("media-type"), bundle.getString("media-path-id"));
        com.pinguo.camera360.gallery.data.y e2 = this.a.P().e(this.q, "");
        this.p = e2;
        this.x.j(e2);
        this.r = new q(this.a, this.p);
        this.F = v0();
        this.r.H(new i(this, null));
        this.A.D(this.r);
    }

    private void x0() {
        this.z = g0.a(this.a).a;
        com.pinguo.camera360.gallery.ui.t tVar = new com.pinguo.camera360.gallery.ui.t(this.a, true);
        this.x = tVar;
        tVar.d(this);
        com.pinguo.camera360.gallery.ui.b0.a u0 = u0();
        this.G = u0;
        this.y = new com.pinguo.camera360.gallery.ui.z(this.a, this.z, u0);
        com.pinguo.camera360.gallery.ui.h t0 = t0();
        this.A = t0;
        this.y.h1(t0);
        this.y.e1(new c());
        this.K.c(this.y);
    }

    protected void B0() {
        E();
    }

    protected void C0() {
    }

    public void D0(int i2) {
        com.pinguo.camera360.gallery.data.y B = this.r.B(i2);
        if (B == null || this.x.i()) {
            return;
        }
        this.x.b(B.g());
        this.y.q();
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public void E() {
        if (this.x.i()) {
            this.x.f();
        } else {
            super.E();
        }
    }

    public void E0(int i2) {
        if (this.s) {
            if (this.x.i()) {
                com.pinguo.camera360.gallery.data.y B = this.r.B(i2);
                if (B == null) {
                    return;
                }
                this.x.b(B.g());
                this.y.q();
                return;
            }
            this.A.F(i2);
            this.A.G();
            Handler handler = this.w;
            handler.sendMessageDelayed(handler.obtainMessage(1, i2, 0), 180L);
        }
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        x0();
        w0(bundle);
        RootActivity rootActivity = this.a;
        rootActivity.a();
        this.B = new com.pinguo.album.b(rootActivity, this);
        this.w = new b(this.a.E());
        this.a.M0(true);
        this.H = new com.pinguo.camera360.gallery.ui.r(this.a, this.x);
    }

    protected void G0(int i2) {
        if (this.s) {
            Bitmap c2 = this.A.c(i2, false);
            int e2 = this.A.e(i2);
            if (c2 == null) {
                c2 = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
                new Canvas(c2).drawColor(-7829368);
            }
            this.a.H0().d("texture_key", c2);
            this.a.H0().d("rotation_key", Integer.valueOf(e2));
            if (this.r.z(i2) == 0) {
                return;
            }
            com.pinguo.camera360.gallery.data.y B = this.r.B(i2);
            Bundle bundle = new Bundle();
            bundle.putInt("media-type", this.q.h());
            bundle.putString("media-path-id", this.q.f());
            bundle.putString("media-name", this.r.B(i2).s());
            bundle.putLongArray("pics_date", ((com.pinguo.camera360.gallery.data.g) B).L());
            bundle.putInt(FirebaseAnalytics.Param.INDEX, i2);
            bundle.putInt("pics_count", this.r.B(i2).r());
            int[] iArr = new int[2];
            r0(i2, iArr);
            bundle.putIntArray("set-center", iArr);
            this.a.E0().r(m.class, 1, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public boolean H(Menu menu) {
        this.F.g(this.a.F0(), this.a.G0(), menu, this.a);
        this.F.k(new e());
        this.F.l(new f());
        return true;
    }

    protected void I0(int i2) {
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public void J() {
        super.J();
        this.s = false;
        this.r.D();
        this.A.x();
        this.B.e();
        com.pinguo.album.c<Integer> cVar = this.t;
        if (cVar != null) {
            cVar.cancel();
            this.t = null;
            p0(2);
        }
        AlertDialog alertDialog = this.J;
        if (alertDialog != null && alertDialog.isShowing()) {
            BigAlbumManager.instance().rollbackMapGallery();
            this.J.cancel();
        }
        this.F.i(this.a);
    }

    protected void K0(int i2) {
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public void L() {
        super.L();
        this.s = true;
        Q(this.K);
        R(q0());
        if (!z0()) {
            this.J = us.pinguo.foundation.utils.w.i(this.a, R.string.map_local_dire_to_album_tips, R.string.pgcommon_ok, R.string.pgcommon_cancel, new d());
            return;
        }
        J0();
    }

    protected void L0(int i2, boolean z) {
        T(i2 <= 0, R.drawable.empty_album, R.string.empty_album_set_tips);
        if (z) {
            y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void O(int i2, int i3, Intent intent) {
        us.pinguo.common.log.a.k("onStateResult requestCode = " + i2 + " resultCode = " + i3, new Object[0]);
        if (i2 == 1) {
            this.y.m1();
        } else if (i2 == 2 && intent != null) {
            this.H.x(R.id.action_add_album, intent.getParcelableArrayListExtra("path_list"), null, this.I);
        }
    }

    @Override // com.pinguo.album.b.InterfaceC0230b
    public void e(float f2, float f3, float f4) {
        this.K.s();
        this.C = f2;
        this.D = f3;
        this.E = f4;
        this.K.E();
        this.K.q();
    }

    @Override // com.pinguo.camera360.gallery.ui.o.a
    public void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o0() {
        com.pinguo.camera360.gallery.ui.c cVar = new com.pinguo.camera360.gallery.ui.c(this.a, R.string.create_new_album_tips);
        cVar.b(new g());
        cVar.show();
    }

    protected int q0() {
        return this.a.getResources().getColor(R.color.common_album_background_color);
    }

    @Override // com.pinguo.camera360.gallery.data.y.d
    public void r(com.pinguo.camera360.gallery.data.y yVar, int i2) {
        if (i2 == 2) {
            us.pinguo.common.log.a.k("onSyncDone: " + com.pinguo.album.j.a.o(yVar.s()) + " result=" + i2, new Object[0]);
        }
        this.a.runOnUiThread(new h(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r0(int i2, int[] iArr) {
        Rect rect = new Rect();
        this.K.j(this.y, rect);
        Rect O0 = this.y.O0(i2);
        int L0 = this.y.L0();
        int M0 = this.y.M0();
        iArr[0] = (rect.left + ((O0.left + O0.right) / 2)) - L0;
        iArr[1] = (rect.top + ((O0.top + O0.bottom) / 2)) - M0;
    }

    @Override // com.pinguo.camera360.gallery.ui.o.a
    public void s(int i2) {
        if (i2 == 1) {
            this.K.q();
        } else if (i2 == 2) {
            this.K.q();
        } else if (i2 != 3) {
        } else {
            this.K.q();
        }
    }

    protected com.pinguo.camera360.gallery.ui.h t0() {
        return new com.pinguo.camera360.gallery.ui.h(this.a, this.y, this.x, g0.a(this.a).b, this.G.l());
    }

    protected abstract com.pinguo.camera360.gallery.ui.b0.a u0();

    protected com.pinguo.camera360.gallery.ui.toolbar.b v0() {
        return com.pinguo.camera360.gallery.ui.toolbar.r.a(3);
    }

    public void y0() {
        this.K.q();
    }

    protected boolean z0() {
        return true;
    }
}
