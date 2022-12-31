package com.pinguo.camera360.gallery;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import com.pinguo.camera360.adv.InterstitialManager;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.b;
import com.pinguo.camera360.gallery.ui.c;
import com.pinguo.camera360.gallery.ui.o;
import com.pinguo.camera360.gallery.ui.s;
import com.pinguo.camera360.gallery.ui.toolbar.PgShadowTabLayout;
import com.pinguo.camera360.gallery.ui.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.IBigAlbumSyncListener;
import us.pinguo.edit2020.activity.AIEditActivity;
import us.pinguo.edit2020.activity.EditActivity;
import us.pinguo.edit2020.model.editgoto.EditGotoType;
import us.pinguo.foundation.statistics.F$key;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.n0;
import us.pinguo.share.util.InspireShareUtils;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumPage.java */
/* loaded from: classes3.dex */
public abstract class o extends ActivityState implements y.d, o.a, Toolbar.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {
    private static final String S = o.class.getSimpleName();
    private com.pinguo.camera360.gallery.ui.z C;
    protected z.f D;
    protected com.pinguo.camera360.gallery.ui.j E;
    protected int G;
    private float H;
    private com.pinguo.camera360.gallery.ui.s I;
    protected com.pinguo.camera360.gallery.ui.toolbar.b J;
    protected com.pinguo.camera360.gallery.ui.r M;
    private AlertDialog R;
    protected com.pinguo.camera360.gallery.ui.t p;
    protected com.pinguo.camera360.gallery.data.y q;
    protected n s;
    private Handler u;
    private Handler v;
    private int r = 2;
    private boolean t = false;
    private int w = 0;
    private boolean x = false;
    private com.pinguo.album.c<Integer> y = null;
    private Path z = null;
    protected String A = "";
    private int B = 0;
    private com.pinguo.album.j.i F = new com.pinguo.album.j.i();
    private int K = 0;
    private com.pinguo.camera360.gallery.ui.toolbar.b L = new com.pinguo.camera360.gallery.ui.toolbar.o();
    private boolean N = false;
    private boolean O = false;
    private final com.pinguo.album.views.a P = new d();
    private s.b Q = new e();

    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    class a implements b.a {
        final /* synthetic */ ArrayList a;

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.pinguo.camera360.gallery.ui.b.a
        public void a() {
            o.this.c1();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.pinguo.camera360.gallery.ui.b.a
        public void b() {
            com.pinguo.album.views.b E = o.this.a.E();
            E.c();
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("path_list", this.a);
                bundle.putInt("media-type", 1201);
                bundle.putString("media-path-id", "path-big-album-def");
                o oVar = o.this;
                oVar.a0(oVar.getClass(), r.class, StateTransAnim.Transition.TranslateIn);
                o.this.p.f();
                o.this.a.E0().o(r.class, bundle);
            } finally {
                E.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class b implements c.b {
        b() {
        }

        @Override // com.pinguo.camera360.gallery.ui.c.b
        public void a(String str) {
            o oVar = o.this;
            oVar.M.z(R.id.add_pic_to_new_album, oVar.z, str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EditGotoType.values().length];
            a = iArr;
            try {
                iArr[EditGotoType.IMAGE_RESTORARION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class d extends com.pinguo.album.views.a {

        /* renamed from: l  reason: collision with root package name */
        private final float[] f6429l = new float[16];

        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.pinguo.album.views.a
        public void v(boolean z, int i2, int i3, int i4, int i5) {
            int height = o.this.a.F0().getHeight();
            int k2 = us.pinguo.foundation.t.b.a.k();
            if (us.pinguo.foundation.utils.x.a.b(o.this.a) && k2 > 0) {
                height += k2;
            }
            o oVar = o.this;
            z.f fVar = oVar.D;
            fVar.m = height;
            oVar.F.d(0, i3);
            o.this.a1(height);
            com.pinguo.camera360.gallery.ui.z zVar = o.this.C;
            z.f fVar2 = o.this.D;
            zVar.r(fVar2.f6712g + i2, fVar.f6714i + i3, i4 - fVar.f6713h, i5 - fVar2.f6715j);
            com.pinguo.album.j.c.n(this.f6429l, (i4 - i2) / 2, (i5 - i3) / 2, -o.this.H);
        }

        @Override // com.pinguo.album.views.a
        public void y(com.pinguo.album.opengles.l lVar) {
            lVar.s(2);
            lVar.j(this.f6429l, 0);
            super.y(lVar);
            if (o.this.I != null) {
                boolean n = o.this.I.n(lVar, p(), n());
                float p = 1.0f - o.this.I.p();
                Message message = new Message();
                message.what = 6;
                message.obj = Float.valueOf(p);
                o.this.v.sendMessage(message);
                if (!n) {
                    o.this.I = null;
                }
                q();
            }
            lVar.b();
        }

        @Override // com.pinguo.album.views.a
        protected void z(com.pinguo.album.opengles.l lVar) {
            lVar.m();
        }
    }

    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    class e implements s.b {
        e() {
        }

        @Override // com.pinguo.camera360.gallery.ui.s.b
        public Rect a(int i2) {
            Rect O0 = o.this.C.O0(i2);
            Rect e2 = o.this.C.e();
            O0.offset(e2.left - o.this.C.L0(), e2.top - o.this.C.M0());
            return O0;
        }

        @Override // com.pinguo.camera360.gallery.ui.s.b
        public int b(Path path) {
            int Q0 = o.this.C.Q0();
            for (int R0 = o.this.C.R0(); R0 < Q0; R0++) {
                com.pinguo.camera360.gallery.data.w w = o.this.s.w(R0);
                if (w != null && w.g().equals(path)) {
                    return R0;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            o.this.a.finish();
            us.pinguo.foundation.b.j(o.this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class g extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ com.pinguo.camera360.gallery.data.w a;

        /* compiled from: AlbumPage.java */
        /* loaded from: classes3.dex */
        class a implements IBigAlbumSyncListener {
            a() {
            }

            @Override // us.pinguo.bigalbum.IBigAlbumSyncListener
            public void onSyncDone() {
                o.this.u.obtainMessage(2).sendToTarget();
            }
        }

        g(com.pinguo.camera360.gallery.data.w wVar) {
            this.a = wVar;
        }

        @Override // us.pinguo.foundation.utils.AsyncTask
        protected Object doInBackground(Object... objArr) {
            com.pinguo.camera360.gallery.data.y yVar = o.this.q;
            if (yVar instanceof com.pinguo.camera360.gallery.data.z) {
                ((com.pinguo.camera360.gallery.data.z) yVar).I(this.a);
                return null;
            } else if (yVar instanceof com.pinguo.camera360.gallery.data.b) {
                ((com.pinguo.camera360.gallery.data.b) yVar).K(this.a);
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
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class h extends com.pinguo.camera360.gallery.ui.y {

        /* compiled from: AlbumPage.java */
        /* loaded from: classes3.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.a.F0().c();
                o.this.a.B0().U();
            }
        }

        /* compiled from: AlbumPage.java */
        /* loaded from: classes3.dex */
        class b implements Runnable {
            final /* synthetic */ int a;

            b(int i2) {
                this.a = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.d1(this.a);
            }
        }

        /* compiled from: AlbumPage.java */
        /* loaded from: classes3.dex */
        class c implements Runnable {
            final /* synthetic */ int a;

            c(int i2) {
                this.a = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (us.pinguo.foundation.utils.x.a.b(o.this.a)) {
                    return;
                }
                o.this.a.O0(this.a);
            }
        }

        /* compiled from: AlbumPage.java */
        /* loaded from: classes3.dex */
        class d implements Runnable {
            final /* synthetic */ float a;

            d(float f2) {
                this.a = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                o oVar = o.this;
                oVar.J.a(oVar.a, oVar.L, this.a);
                if (o.this.w() >= 0) {
                    float f2 = 1.0f - (this.a * 2.0f);
                    PgShadowTabLayout B0 = o.this.a.B0();
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    B0.setAlpha(f2);
                }
            }
        }

        /* compiled from: AlbumPage.java */
        /* loaded from: classes3.dex */
        class e implements Runnable {
            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o oVar = o.this;
                oVar.J.a(oVar.a, oVar.L, 0.0f);
                if (o.this.w() >= 0) {
                    o.this.a.B0().setBottomBarAnimVisibility(0);
                }
            }
        }

        h() {
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void a() {
            o oVar = o.this;
            oVar.p.a(oVar.C.P0(), o.this.C.N0());
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void b() {
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void c(int i2) {
            o.this.L0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void d(List<Integer> list) {
            o.this.Y0(list);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void e(int i2) {
            o.this.P0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void f(int i2, int i3) {
            o.this.a.runOnUiThread(new b(i2));
            if (o.this.p.i() || o.this.B != 0) {
                o.this.B = 0;
            } else {
                o.this.a.runOnUiThread(new c(i2));
            }
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void g(int i2) {
            o.this.O0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void h(boolean z, int i2, com.pinguo.album.opengles.c cVar) {
            if (!z || i2 < 0) {
                o.this.v.post(new e());
                return;
            }
            Message obtainMessage = o.this.u.obtainMessage(4, i2, 0);
            obtainMessage.obj = cVar;
            o.this.u.sendMessage(obtainMessage);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void i(boolean z) {
            o.this.R0(z);
            if (o.this.p.i()) {
                return;
            }
            o.this.a.runOnUiThread(new a());
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void j(String str) {
            o.this.C.q1(str.substring(0, 7));
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void k(float f2) {
            o.this.v.post(new d(f2));
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void l(int i2, float f2, float f3) {
            o.this.Q0(i2);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void n() {
            us.pinguo.common.log.a.k("toggleSlot onScrollOriChanged", new Object[0]);
            o oVar = o.this;
            oVar.N = !oVar.N;
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void o(int i2) {
            if (i2 == 2) {
                o.this.N0();
            } else if (i2 == 1) {
                o.this.M0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class i extends Handler {
        i() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 6) {
                return;
            }
            o oVar = o.this;
            oVar.J.a(oVar.a, oVar.L, ((Float) message.obj).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class j extends com.pinguo.album.g {
        j(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                o.this.T0(message.arg1);
            } else if (i2 == 2) {
                if (o.this.C() || o.this.R == null || !o.this.R.isShowing()) {
                    return;
                }
                o.this.R.dismiss();
            } else if (i2 == 3) {
                o oVar = o.this;
                oVar.R = oVar.a.x0(R.string.sandbox_loading);
                o.this.R.setCancelable(false);
            } else if (i2 != 4) {
                if (i2 == 5) {
                    o.this.V0(message.arg1);
                    return;
                }
                throw new AssertionError(message.what);
            } else {
                Object obj = message.obj;
                if (obj != null) {
                    o.this.U0(message.arg1, (com.pinguo.album.opengles.c) obj);
                } else {
                    o.this.T0(message.arg1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (o.this.p.i()) {
                o.this.p.f();
                return;
            }
            com.pinguo.album.views.b E = o.this.a.E();
            E.c();
            o.this.E();
            E.g();
        }
    }

    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    class l implements Runnable {
        final /* synthetic */ int a;

        l(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.pinguo.album.views.b E = o.this.a.E();
            E.c();
            try {
                if (this.a == 0) {
                    o.this.x = true;
                }
                o.this.E0(2);
                if (this.a == 2 && o.this.t && o.this.s.H() == 0) {
                    RootActivity rootActivity = o.this.a;
                    new us.pinguo.foundation.ui.e(rootActivity, (int) R.string.sync_album_error, rootActivity.q0()).d();
                }
            } finally {
                E.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumPage.java */
    /* loaded from: classes3.dex */
    public class m implements x {
        private m() {
        }

        @Override // com.pinguo.camera360.gallery.x
        public void c() {
            synchronized (com.pinguo.camera360.gallery.data.o.f6371d) {
                o oVar = o.this;
                oVar.G = oVar.q.r();
            }
            o.this.E0(1);
            o oVar2 = o.this;
            oVar2.h1(oVar2.G);
        }

        @Override // com.pinguo.camera360.gallery.x
        public void d() {
            o.this.Z0(1);
        }

        /* synthetic */ m(o oVar, d dVar) {
            this();
        }
    }

    private Bundle C0(int i2) {
        Bundle bundle = new Bundle();
        if (this.r == 3) {
            bundle.putInt("pic_source", 1);
        }
        bundle.putInt("index-hint", i2);
        bundle.putParcelable("bundle_key_goto", x().getParcelable("bundle_key_goto"));
        bundle.putInt("media-type", this.q.g().h());
        bundle.putString("media-path-id", this.q.g().f());
        x().putParcelable("bundle_key_goto", null);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i2) {
        this.w = (~i2) & this.w;
    }

    private void G0(Bundle bundle) {
        this.z = new Path(bundle.getInt("media-type"), bundle.getString("media-path-id"));
        this.A = bundle.getString("media-name");
        this.K = bundle.getInt("toolbar_type", 0);
        this.q = this.a.P().e(this.z, this.A);
        if (!com.pinguo.camera360.gallery.i0.a.c().d()) {
            com.pinguo.camera360.gallery.data.y yVar = this.q;
            if (yVar instanceof com.pinguo.camera360.gallery.data.z) {
                yVar.A();
            }
        }
        this.J = com.pinguo.camera360.gallery.ui.toolbar.r.a(this.K);
        this.p.j(this.q);
        n nVar = new n(this.a, this.q, this.r);
        this.s = nVar;
        nVar.G(new m(this, null));
        this.E.D(this.s);
    }

    private void H0() {
        com.pinguo.camera360.gallery.ui.t tVar = new com.pinguo.camera360.gallery.ui.t(this.a, true);
        this.p = tVar;
        tVar.d(this);
        f0 a2 = f0.a(this.a);
        this.D = f0.a(this.a).a;
        com.pinguo.camera360.gallery.ui.b0.a F0 = F0(this.r);
        com.pinguo.camera360.gallery.ui.z zVar = new com.pinguo.camera360.gallery.ui.z(this.a, this.D, F0, this.p);
        this.C = zVar;
        com.pinguo.camera360.gallery.ui.j jVar = new com.pinguo.camera360.gallery.ui.j(this.a, zVar, this.p, a2.b, F0.l(), F0.s());
        this.E = jVar;
        this.C.h1(jVar);
        this.P.c(this.C);
        this.C.e1(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(com.pinguo.camera360.gallery.data.w wVar, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            this.u.obtainMessage(3).sendToTarget();
            new g(wVar).executeOnPoolExecutor(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i2) {
        this.E.F(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(int i2) {
        if (this.t && this.p.i()) {
            this.p.r(i2);
            this.C.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i2) {
        final com.pinguo.camera360.gallery.data.w w;
        if (!this.t || (w = this.s.w(i2)) == null || this.C.U0()) {
            return;
        }
        boolean l2 = w.l();
        String o = w.o();
        us.pinguo.common.log.a.k(i2 + "-------图片是否存在：" + l2 + ":是否不在制图过程中:true:路径:" + w.o(), new Object[0]);
        if (this.p.i()) {
            if (!l2) {
                RootActivity rootActivity = this.a;
                rootActivity.z0(rootActivity.getResources().getString(R.string.album_photo_not_exist));
                return;
            }
            this.p.q(i2, w.g());
            this.C.q();
        } else if (!l2) {
            com.pinguo.camera360.gallery.data.y yVar = this.q;
            if ((yVar instanceof com.pinguo.camera360.gallery.data.f) || (yVar instanceof com.pinguo.camera360.gallery.data.g) || ((yVar instanceof com.pinguo.camera360.gallery.data.z) && ((com.pinguo.camera360.gallery.data.z) yVar).D())) {
                us.pinguo.foundation.utils.w.k(this.a, R.string.plus_sandbox_tips_file_not_exit, R.string.pic_save_path_custom_ok, R.string.pic_save_path_custom_cancle, false, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.gallery.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        o.this.K0(w, dialogInterface, i3);
                    }
                });
            }
        } else if (this.u.hasMessages(5)) {
        } else {
            Uri uri = (Uri) x().getParcelable("bundle_key_goto");
            if (uri != null) {
                if (w.y()) {
                    this.a.y0(R.string.video_not_support);
                    return;
                }
                this.E.F(i2);
                this.E.G();
                us.pinguo.edit2020.model.editgoto.b a2 = new us.pinguo.edit2020.model.editgoto.c().a(uri);
                if (a2 != null) {
                    if (c.a[a2.a().ordinal()] != 1) {
                        EditActivity.a.b(this.a, o, false, uri, false);
                    } else {
                        AIEditActivity.a.a(this.a, o, false, uri, false);
                    }
                } else {
                    EditActivity.a.b(this.a, o, false, uri, false);
                }
                us.pinguo.foundation.statistics.l.onEvent("c360_gallery_edit", F$key.gallery);
            } else if (w.y() && !w.o().toLowerCase().endsWith("mp4")) {
                T0(i2);
            } else {
                this.E.F(i2);
                this.E.G();
                Handler handler = this.u;
                handler.sendMessageDelayed(handler.obtainMessage(5, i2, 0), 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(boolean z) {
        if (z) {
            this.E.F(-1);
        } else {
            this.E.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(int i2, com.pinguo.album.opengles.c cVar) {
        if (this.t && this.s.w(i2) != null) {
            Bundle C0 = C0(i2);
            this.a.H0().d("photo_anim_texture", cVar);
            e1(C0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(int i2) {
        if (this.t && !this.C.Y0(i2)) {
            T0(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(List<Integer> list) {
        if (this.t) {
            for (Integer num : list) {
                com.pinguo.camera360.gallery.data.w w = this.s.w(num.intValue());
                if (this.N) {
                    if (!this.p.h(w.g(), num.intValue())) {
                        this.p.q(num.intValue(), w.g());
                        this.p.o(num.intValue());
                        this.C.q();
                    }
                } else if (this.p.h(w.g(), num.intValue())) {
                    this.p.q(num.intValue(), w.g());
                    this.p.o(num.intValue());
                    this.C.q();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(int i2) {
        this.w = i2 | this.w;
    }

    private void b1(Set<Integer> set) {
        com.pinguo.camera360.gallery.data.w w = this.s.w(set.iterator().next().intValue());
        InspireShareUtils.showShareDialogToSNS(this.a, w.o(), w.y(), true, "album_browse_photo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        com.pinguo.camera360.gallery.ui.c cVar = new com.pinguo.camera360.gallery.ui.c(this.a, R.string.create_new_album_tips);
        cVar.b(new b());
        cVar.show();
    }

    protected boolean D0(int i2) {
        return this.G != 0 || i2 == R.id.action_waterfall_add_pics || i2 == R.id.action_add;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void E() {
        if (this.p.i()) {
            this.p.f();
        } else {
            super.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void F(Configuration configuration) {
    }

    protected com.pinguo.camera360.gallery.ui.b0.a F0(int i2) {
        return com.pinguo.camera360.gallery.ui.b0.a.d(i2, this.D.f6717l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        int[] intArray;
        this.H = n0.o(0.3f);
        this.r = bundle.getInt("layout_type", 2);
        H0();
        G0(bundle);
        if (bundle2 == null && bundle != null && (intArray = bundle.getIntArray("set-center")) != null && !z()) {
            this.F.c(intArray[0], intArray[1]);
            this.C.n1(this.F);
        }
        this.v = new i();
        this.u = new j(this.a.E());
        this.M = new com.pinguo.camera360.gallery.ui.r(this.a, this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public boolean H(Menu menu) {
        if (this.p.i()) {
            this.J.g(this.a.F0(), this.a.G0(), menu, this.a);
            this.J.c(this.a, this.p.c());
            W0();
            this.P.q();
            return true;
        }
        if (this.I == null || !this.J.e()) {
            this.J.g(this.a.F0(), this.a.G0(), menu, this.a);
        }
        i1();
        com.pinguo.camera360.gallery.ui.s sVar = this.I;
        if (sVar != null) {
            this.J.a(this.a, this.L, 1.0f - sVar.p());
        }
        W0();
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

    public void I0() {
        this.P.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void J() {
        if (this.O) {
            R(this.a.getResources().getColor(R.color.photo_background_color));
        }
        super.J();
        this.t = false;
        this.E.H(null);
        S0();
        com.pinguo.album.c<Integer> cVar = this.y;
        if (cVar != null) {
            cVar.cancel();
            this.y = null;
            E0(2);
        }
        this.I = null;
        this.v.removeMessages(6);
        this.J.i(this.a);
        this.L.i(this.a);
        this.J.m(null);
        this.a.L0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void L() {
        super.L();
        if (ContextCompat.checkSelfPermission(us.pinguo.foundation.e.b(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            us.pinguo.common.log.a.m(S, "onResume", new Object[0]);
            this.t = true;
            com.pinguo.camera360.gallery.ui.s sVar = (com.pinguo.camera360.gallery.ui.s) this.a.H0().b("resume_animation");
            this.I = sVar;
            if (sVar != null) {
                sVar.r(this.Q);
                if (this.C.K0() == 1) {
                    this.I.i(IjkMediaCodecInfo.RANK_SECURE);
                } else {
                    this.I.i(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                }
                this.I.l();
            }
            Q(this.P);
            R(this.a.getResources().getColor(R.color.common_album_background_color));
            Z0(1);
            X0();
            if (!this.x) {
                Z0(2);
                this.y = this.q.z(this);
            }
            this.G = this.q.r();
        }
    }

    protected void M0() {
        E();
    }

    protected void N0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.ActivityState
    public void O(int i2, int i3, Intent intent) {
        ArrayList<Path> parcelableArrayListExtra;
        if (i2 == 2) {
            if (intent != null) {
                int intExtra = intent.getIntExtra("return-index-hint", 0);
                this.B = intExtra;
                this.C.V0(intExtra);
                InterstitialManager.getInstance().g(this.a, IADStatisticBase.UNIT_ID_INTERSTITIAL_ALBUM);
            }
        } else if (i2 != 3) {
            if (i2 == 4 && intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("path_list")) != null && parcelableArrayListExtra.size() > 0) {
                this.M.w(R.id.action_confirm_add_pics, this.z, parcelableArrayListExtra, null);
            }
        } else {
            this.C.m1();
        }
    }

    public void O0(int i2) {
        com.pinguo.camera360.gallery.data.w w = this.s.w(i2);
        if (w == null) {
            return;
        }
        if (!w.l()) {
            this.p.k();
            return;
        }
        this.p.q(i2, w.g());
        this.N = this.p.h(w.g(), i2);
        this.J.p(this.p.c());
        this.C.q();
        f1(true);
    }

    protected void S0() {
        this.s.A();
        this.E.z();
    }

    protected void T0(int i2) {
        if (this.t && this.s.w(i2) != null) {
            Bundle C0 = C0(i2);
            Rect O0 = this.C.O0(i2);
            C0.putParcelable("open-animation-rect", new Rect(O0.left, O0.top - this.C.M0(), O0.right, O0.bottom - this.C.M0()));
            e1(C0);
        }
    }

    protected void W0() {
        this.J.k(new k());
        this.J.l(this);
        int i2 = this.K;
        if (i2 == 1 || i2 == 0) {
            this.J.m(this);
        }
    }

    protected void X0() {
        this.s.C();
        this.E.C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a1(int i2) {
        this.C.k1(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d1(int i2) {
    }

    protected void e1(Bundle bundle) {
        this.O = true;
        this.a.E0().r(c0.class, 2, bundle);
        this.O = false;
    }

    protected abstract void f1(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public void g1(boolean z) {
        if (z && this.p.i()) {
            this.p.f();
        }
    }

    protected void h1(int i2) {
        boolean z = i2 <= 0;
        g1(z);
        V(z, R.drawable.empty_camera, R.string.empty_album_tips, new f());
        I0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i1() {
        com.pinguo.camera360.gallery.ui.toolbar.b bVar = this.J;
        if (bVar instanceof com.pinguo.camera360.gallery.ui.toolbar.f) {
            ((com.pinguo.camera360.gallery.ui.toolbar.f) bVar).s(this.A);
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.o.a
    public void l() {
        this.J.p(this.p.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    @Instrumented
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        VdsAgent.onItemSelected(this, adapterView, view, i2, j2);
        com.pinguo.album.views.b E = this.a.E();
        com.pinguo.camera360.gallery.i0.a c2 = com.pinguo.camera360.gallery.i0.a.c();
        if (i2 != 0) {
            if (i2 == 1 && c2.d() && x() != null) {
                c2.g(false);
                us.pinguo.foundation.statistics.l.onEvent("c360_gallery_photo_switchAllPhoto", F$key.gallery);
                E.c();
                try {
                    x().putInt("layout_type", 2);
                    x().putInt("toolbar_type", 0);
                    a0(getClass(), getClass(), StateTransAnim.Transition.Incoming);
                    this.a.E0().k(x());
                } finally {
                }
            }
        } else if (c2.d() || x() == null) {
        } else {
            c2.g(true);
            us.pinguo.foundation.statistics.l.onEvent("c360_gallery_photo_switchMyAlbum", F$key.gallery);
            E.c();
            try {
                x().putInt("layout_type", 2);
                x().putInt("toolbar_type", 0);
                a0(getClass(), getClass(), StateTransAnim.Transition.Incoming);
                this.a.E0().k(x());
            } finally {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    @Instrumented
    public boolean onMenuItemClick(MenuItem menuItem) {
        com.pinguo.album.views.b E;
        VdsAgent.onMenuItemClick(this, menuItem);
        if (!D0(menuItem.getItemId())) {
            VdsAgent.handleClickResult(new Boolean(false));
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.action_add /* 2131296340 */:
                ArrayList<Path> g2 = this.p.g(false);
                if (g2 != null && g2.size() == 0) {
                    VdsAgent.handleClickResult(new Boolean(false));
                    return false;
                } else if (g2 != null && g2.size() == 1 && g2.get(0).h() == 1101) {
                    this.a.y0(R.string.video_not_support);
                    VdsAgent.handleClickResult(new Boolean(true));
                    return true;
                } else {
                    boolean E2 = ((com.pinguo.camera360.gallery.data.i) this.a.P().e(new Path(1201, "path-big-album-def"), "")).E();
                    com.pinguo.camera360.gallery.ui.b bVar = new com.pinguo.camera360.gallery.ui.b(this.a);
                    bVar.a(new a(g2));
                    bVar.show();
                    VdsAgent.showDialog(bVar);
                    bVar.b(E2);
                    break;
                }
                break;
            case R.id.action_date /* 2131296353 */:
                if (this.C.K0() == 0) {
                    VdsAgent.handleClickResult(new Boolean(true));
                    return true;
                }
                this.C.l1(true);
                break;
            case R.id.action_delete /* 2131296354 */:
                this.M.p(menuItem.getItemId(), R.string.pgcommon_delete_tip, null);
                break;
            case R.id.action_month /* 2131296364 */:
                if (this.C.K0() == 1) {
                    VdsAgent.handleClickResult(new Boolean(true));
                    return true;
                }
                this.C.l1(false);
                break;
            case R.id.action_normal /* 2131296365 */:
                if (this.r != 2 && x() != null) {
                    E = this.a.E();
                    E.c();
                    try {
                        x().remove("layout_type");
                        x().putInt("toolbar_type", 2);
                        a0(getClass(), getClass(), StateTransAnim.Transition.Incoming);
                        this.a.E0().k(x());
                        E.g();
                        break;
                    } finally {
                    }
                }
                break;
            case R.id.action_select /* 2131296367 */:
                this.p.k();
                f1(false);
                break;
            case R.id.action_share /* 2131296369 */:
                Set<Integer> m2 = this.p.m();
                if (m2 != null && m2.size() == 0) {
                    VdsAgent.handleClickResult(new Boolean(false));
                    return false;
                } else if (m2 != null) {
                    if (m2.size() > 1) {
                        this.a.y0(R.string.not_support_share_mul_pics);
                        break;
                    } else {
                        b1(m2);
                        break;
                    }
                }
                break;
            case R.id.action_waterfall /* 2131296372 */:
                if (this.r != 4 && x() != null) {
                    E = this.a.E();
                    E.c();
                    try {
                        x().putInt("layout_type", 4);
                        x().putInt("toolbar_type", 2);
                        a0(getClass(), getClass(), StateTransAnim.Transition.Incoming);
                        this.a.E0().k(x());
                        E.g();
                        break;
                    } finally {
                    }
                }
                break;
            case R.id.action_waterfall_add_pics /* 2131296373 */:
                this.a.E().c();
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("path_list", this.z);
                    bundle.putInt("media-type", 1202);
                    bundle.putString("media-path-id", "path-big-album-def");
                    a0(getClass(), p.class, StateTransAnim.Transition.BottomToTop);
                    this.a.E0().r(p.class, 4, bundle);
                    break;
                } finally {
                }
            case R.id.action_waterfall_select /* 2131296374 */:
                if (!this.p.i()) {
                    f1(false);
                    this.p.k();
                    break;
                }
                break;
        }
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // com.pinguo.camera360.gallery.data.y.d
    public void r(com.pinguo.camera360.gallery.data.y yVar, int i2) {
        us.pinguo.common.log.a.c("onSyncDone: " + com.pinguo.album.j.a.o(yVar.s()) + " result=" + i2, new Object[0]);
        this.a.runOnUiThread(new l(i2));
    }

    @Override // com.pinguo.camera360.gallery.ui.o.a
    public void s(int i2) {
        if (i2 == 1) {
            this.J.c(this.a, this.p.c());
            this.C.p1(8);
            this.a.F0().setTranslationY(0.0f);
            this.P.q();
        } else if (i2 == 2) {
            this.J.f(this.a);
            this.P.q();
        } else if (i2 != 3) {
        } else {
            this.P.q();
        }
    }
}
