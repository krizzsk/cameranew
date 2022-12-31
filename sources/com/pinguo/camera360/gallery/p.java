package com.pinguo.camera360.gallery;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import com.pinguo.camera360.gallery.ActivityState;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.o;
import com.pinguo.camera360.gallery.ui.z;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.IBigAlbumSyncListener;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumPickPage.java */
/* loaded from: classes3.dex */
public class p extends ActivityState implements y.d, o.a {
    private static final String L = "p";
    private com.pinguo.camera360.gallery.ui.z B;
    private z.f C;
    private com.pinguo.camera360.gallery.ui.j D;
    private int F;
    private float G;
    private com.pinguo.camera360.gallery.ui.toolbar.b H;
    private AlertDialog J;
    protected com.pinguo.camera360.gallery.ui.t p;
    private com.pinguo.camera360.gallery.data.y q;
    private n s;
    private Handler v;
    private int r = 0;
    private boolean t = false;
    private ActivityState.State u = ActivityState.State.Normal;
    private boolean w = false;
    private com.pinguo.album.c<Integer> x = null;
    private Path y = null;
    private String z = "";
    private int A = 0;
    private com.pinguo.album.j.i E = new com.pinguo.album.j.i();
    private final com.pinguo.album.views.a I = new a();
    private boolean K = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPickPage.java */
    /* loaded from: classes3.dex */
    public class a extends com.pinguo.album.views.a {

        /* renamed from: l  reason: collision with root package name */
        private final float[] f6430l = new float[16];

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.pinguo.album.views.a
        public void v(boolean z, int i2, int i3, int i4, int i5) {
            int height = p.this.a.F0().getHeight();
            p.this.C.m = height;
            p.this.E.d(0, i3);
            p.this.B.k1(height);
            p.this.B.r(p.this.C.f6712g + i2, p.this.C.f6714i + i3, i4 - p.this.C.f6713h, i5 - p.this.C.f6715j);
            com.pinguo.album.j.c.n(this.f6430l, (i4 - i2) / 2, (i5 - i3) / 2, -p.this.G);
        }

        @Override // com.pinguo.album.views.a
        public void y(com.pinguo.album.opengles.l lVar) {
            lVar.s(2);
            lVar.j(this.f6430l, 0);
            super.y(lVar);
            lVar.b();
        }

        @Override // com.pinguo.album.views.a
        protected void z(com.pinguo.album.opengles.l lVar) {
            lVar.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPickPage.java */
    /* loaded from: classes3.dex */
    public class b extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ com.pinguo.camera360.gallery.data.w a;

        /* compiled from: AlbumPickPage.java */
        /* loaded from: classes3.dex */
        class a implements IBigAlbumSyncListener {
            a() {
            }

            @Override // us.pinguo.bigalbum.IBigAlbumSyncListener
            public void onSyncDone() {
                p.this.v.obtainMessage(2).sendToTarget();
            }
        }

        b(com.pinguo.camera360.gallery.data.w wVar) {
            this.a = wVar;
        }

        @Override // us.pinguo.foundation.utils.AsyncTask
        protected Object doInBackground(Object... objArr) {
            if (p.this.q instanceof com.pinguo.camera360.gallery.data.z) {
                ((com.pinguo.camera360.gallery.data.z) p.this.q).I(this.a);
                return null;
            } else if (p.this.q instanceof com.pinguo.camera360.gallery.data.b) {
                ((com.pinguo.camera360.gallery.data.b) p.this.q).K(this.a);
                return null;
            } else {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        public void onPostExecute(Object obj) {
            BigAlbumManager.instance().syncSystemAsync(true, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPickPage.java */
    /* loaded from: classes3.dex */
    public class c extends com.pinguo.camera360.gallery.ui.y {
        c() {
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void c(int i2) {
            p.this.E0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void d(List<Integer> list) {
            p.this.J0(list);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void e(int i2) {
            p.this.G0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void g(int i2) {
            p.this.F0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void i(boolean z) {
            p.this.I0(z);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void l(int i2, float f2, float f3) {
            p.this.H0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void n() {
            us.pinguo.common.log.a.k("toggleSlot onScrollOriChanged", new Object[0]);
            p pVar = p.this;
            pVar.K = !pVar.K;
        }
    }

    /* compiled from: AlbumPickPage.java */
    /* loaded from: classes3.dex */
    class d extends com.pinguo.album.g {
        d(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 2) {
                if (i2 == 3) {
                    p pVar = p.this;
                    pVar.J = pVar.a.x0(R.string.sandbox_loading);
                    p.this.J.setCancelable(false);
                    return;
                }
                throw new AssertionError(message.what);
            } else if (p.this.C() || p.this.J == null || !p.this.J.isShowing()) {
            } else {
                p.this.J.dismiss();
            }
        }
    }

    /* compiled from: AlbumPickPage.java */
    /* loaded from: classes3.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (p.this.p.i()) {
                p.this.p.f();
            }
            com.pinguo.album.views.b E = p.this.a.E();
            E.c();
            p.this.E();
            E.g();
        }
    }

    /* compiled from: AlbumPickPage.java */
    /* loaded from: classes3.dex */
    class f implements Toolbar.OnMenuItemClickListener {
        f() {
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        @Instrumented
        public boolean onMenuItemClick(MenuItem menuItem) {
            VdsAgent.onMenuItemClick(this, menuItem);
            ArrayList<Path> g2 = p.this.p.g(false);
            us.pinguo.common.log.a.k("paths = " + g2.size(), new Object[0]);
            Intent intent = new Intent();
            intent.putExtra("path_list", g2);
            p.this.Z(-1, intent);
            p.this.a.E0().d(p.this);
            VdsAgent.handleClickResult(new Boolean(true));
            return true;
        }
    }

    /* compiled from: AlbumPickPage.java */
    /* loaded from: classes3.dex */
    class g implements Runnable {
        final /* synthetic */ int a;

        g(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.pinguo.album.views.b E = p.this.a.E();
            E.c();
            try {
                if (this.a == 0) {
                    p.this.w = true;
                }
                p.this.y0(2);
                if (this.a == 2 && p.this.t && p.this.s.H() == 0) {
                    RootActivity rootActivity = p.this.a;
                    new us.pinguo.foundation.ui.e(rootActivity, (int) R.string.sync_album_error, rootActivity.q0()).d();
                }
            } finally {
                E.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumPickPage.java */
    /* loaded from: classes3.dex */
    public class h implements x {
        private h() {
        }

        @Override // com.pinguo.camera360.gallery.x
        public void c() {
            synchronized (com.pinguo.camera360.gallery.data.o.f6371d) {
                p pVar = p.this;
                pVar.F = pVar.q.r();
            }
            p.this.y0(1);
            p pVar2 = p.this;
            pVar2.L0(pVar2.F);
        }

        @Override // com.pinguo.camera360.gallery.x
        public void d() {
            p.this.L0(1);
            p.this.K0(1);
        }

        /* synthetic */ h(p pVar, a aVar) {
            this();
        }
    }

    private void A0() {
        com.pinguo.camera360.gallery.ui.t tVar = new com.pinguo.camera360.gallery.ui.t(this.a, true);
        this.p = tVar;
        tVar.d(this);
        f0 a2 = f0.a(this.a);
        this.C = f0.a(this.a).a;
        com.pinguo.camera360.gallery.ui.b0.a d2 = com.pinguo.camera360.gallery.ui.b0.a.d(3, this.a.getResources().getDimensionPixelSize(R.dimen.select_page_bottom_bar_height));
        com.pinguo.camera360.gallery.ui.z zVar = new com.pinguo.camera360.gallery.ui.z(this.a, this.C, d2, this.p);
        this.B = zVar;
        com.pinguo.camera360.gallery.ui.j jVar = new com.pinguo.camera360.gallery.ui.j(this.a, zVar, this.p, a2.b, d2.l(), d2.s());
        this.D = jVar;
        this.B.h1(jVar);
        this.I.c(this.B);
        this.B.e1(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public /* synthetic */ void D0(com.pinguo.camera360.gallery.data.w wVar, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            this.v.obtainMessage(3).sendToTarget();
            new b(wVar).executeOnPoolExecutor(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i2) {
        this.D.F(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(int i2) {
        if (this.t && this.p.i()) {
            this.p.r(i2);
            this.B.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(int i2) {
        final com.pinguo.camera360.gallery.data.w w;
        if (this.t && (w = this.s.w(i2)) != null) {
            boolean l2 = w.l();
            w.o();
            us.pinguo.common.log.a.k(i2 + "-------图片是否存在：" + l2 + ":是否不在制图过程中:true:路径:" + w.o(), new Object[0]);
            if (this.p.i()) {
                if (!l2) {
                    RootActivity rootActivity = this.a;
                    rootActivity.z0(rootActivity.getResources().getString(R.string.album_photo_not_exist));
                    return;
                }
                this.p.q(i2, w.g());
                this.B.q();
            } else if (!l2) {
                com.pinguo.camera360.gallery.data.y yVar = this.q;
                if ((yVar instanceof com.pinguo.camera360.gallery.data.f) || (yVar instanceof com.pinguo.camera360.gallery.data.g) || ((yVar instanceof com.pinguo.camera360.gallery.data.z) && ((com.pinguo.camera360.gallery.data.z) yVar).D())) {
                    us.pinguo.foundation.utils.w.k(this.a, R.string.plus_sandbox_tips_file_not_exit, R.string.pic_save_path_custom_ok, R.string.pic_save_path_custom_cancle, false, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.gallery.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            p.this.D0(w, dialogInterface, i3);
                        }
                    });
                }
            } else {
                this.D.F(i2);
                this.D.G();
                this.p.k();
                this.p.q(i2, w.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(boolean z) {
        if (z) {
            this.D.F(-1);
        } else {
            this.D.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(List<Integer> list) {
        if (this.t) {
            for (Integer num : list) {
                com.pinguo.camera360.gallery.data.w w = this.s.w(num.intValue());
                if (this.K) {
                    if (!this.p.h(w.g(), num.intValue())) {
                        this.p.q(num.intValue(), w.g());
                        this.p.o(num.intValue());
                        this.B.q();
                    }
                } else if (this.p.h(w.g(), num.intValue())) {
                    this.p.q(num.intValue(), w.g());
                    this.p.o(num.intValue());
                    this.B.q();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(int i2) {
        this.r = i2 | this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i2) {
        T(i2 <= 0, R.drawable.empty_camera, R.string.empty_album_tips);
        B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i2) {
        this.r = (~i2) & this.r;
    }

    private void z0(Bundle bundle) {
        this.y = new Path(bundle.getInt("media-type"), bundle.getString("media-path-id"));
        this.z = bundle.getString("media-name");
        com.pinguo.camera360.gallery.data.y e2 = this.a.P().e(this.y, this.z);
        this.q = e2;
        if (e2 instanceof com.pinguo.camera360.gallery.data.f) {
            e2.A();
        }
        this.p.j(this.q);
        this.H = com.pinguo.camera360.gallery.ui.toolbar.r.a(7);
        n nVar = new n(this.a, this.q, 2);
        this.s = nVar;
        nVar.G(new h(this, null));
        this.D.D(this.s);
        Path path = (Path) bundle.getParcelable("path_list");
    }

    public void B0() {
        this.I.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void E() {
        if (this.p.i()) {
            this.p.f();
        }
        a0(p.class, m.class, StateTransAnim.Transition.TopToBottom);
        super.E();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void F(Configuration configuration) {
    }

    public void F0(int i2) {
        com.pinguo.camera360.gallery.data.w w = this.s.w(i2);
        if (w == null) {
            return;
        }
        if (!w.l()) {
            this.p.k();
            return;
        }
        this.p.q(i2, w.g());
        this.K = this.p.h(w.g(), i2);
        this.H.p(this.p.c());
        this.B.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        int[] intArray;
        this.G = n0.o(0.3f);
        A0();
        z0(bundle);
        if (bundle2 == null && bundle != null && (intArray = bundle.getIntArray("set-center")) != null) {
            this.E.c(intArray[0], intArray[1]);
            this.B.n1(this.E);
        }
        this.v = new d(this.a.E());
        new com.pinguo.camera360.gallery.ui.r(this.a, this.p);
        this.p.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public boolean H(Menu menu) {
        this.H.g(this.a.F0(), this.a.G0(), menu, this.a);
        this.H.k(new e());
        if (this.p.c() > 0) {
            this.H.p(this.p.c());
        }
        this.H.l(new f());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void I() {
        super.I();
        n nVar = this.s;
        if (nVar != null) {
            nVar.G(null);
            this.s.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void J() {
        super.J();
        this.t = false;
        this.D.H(null);
        this.s.A();
        this.D.z();
        com.pinguo.album.c<Integer> cVar = this.x;
        if (cVar != null) {
            cVar.cancel();
            this.x = null;
            y0(2);
        }
        this.H.i(this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void L() {
        super.L();
        us.pinguo.common.log.a.m(L, "onResume", new Object[0]);
        this.t = true;
        Q(this.I);
        R(this.a.getResources().getColor(R.color.common_album_background_color));
        K0(1);
        this.s.C();
        this.D.C();
        if (!this.w) {
            K0(2);
            this.x = this.q.z(this);
        }
        if (this.u == ActivityState.State.ResetUI) {
            if (this.p.i()) {
                this.p.f();
            }
            this.u = ActivityState.State.Normal;
        }
        this.F = this.q.r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void O(int i2, int i3, Intent intent) {
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.B.m1();
        } else if (intent != null) {
            int intExtra = intent.getIntExtra("return-index-hint", 0);
            this.A = intExtra;
            this.B.V0(intExtra);
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.o.a
    public void l() {
        this.H.p(this.p.c());
    }

    @Override // com.pinguo.camera360.gallery.data.y.d
    public void r(com.pinguo.camera360.gallery.data.y yVar, int i2) {
        us.pinguo.common.log.a.c("onSyncDone: " + com.pinguo.album.j.a.o(yVar.s()) + " result=" + i2, new Object[0]);
        this.a.runOnUiThread(new g(i2));
    }

    @Override // com.pinguo.camera360.gallery.ui.o.a
    public void s(int i2) {
        if (i2 == 1) {
            this.H.b(this.a);
            this.I.q();
        } else if (i2 == 2) {
            this.H.f(this.a);
            this.I.q();
        } else if (i2 != 3) {
        } else {
            this.I.q();
        }
    }
}
