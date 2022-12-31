package com.pinguo.camera360.gallery.photopick;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import com.pinguo.album.opengles.l;
import com.pinguo.camera360.gallery.ActivityState;
import com.pinguo.camera360.gallery.RootActivity;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.u;
import com.pinguo.camera360.gallery.data.w;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.f0;
import com.pinguo.camera360.gallery.n;
import com.pinguo.camera360.gallery.photopick.PhotoPickLauncher;
import com.pinguo.camera360.gallery.ui.j;
import com.pinguo.camera360.gallery.ui.o;
import com.pinguo.camera360.gallery.ui.s;
import com.pinguo.camera360.gallery.ui.toolbar.q;
import com.pinguo.camera360.gallery.ui.toolbar.r;
import com.pinguo.camera360.gallery.ui.x;
import com.pinguo.camera360.gallery.ui.z;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import us.pinguo.foundation.utils.n0;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoPickAlbumPage.java */
/* loaded from: classes3.dex */
public class c extends ActivityState implements y.d, o.b {
    private float B;
    private s C;
    private com.pinguo.camera360.gallery.ui.toolbar.b D;
    private Handler F;
    private Handler G;
    private int H;
    private PhotoPickLauncher.LaunchMode I;
    protected x p;
    private y r;
    private n s;
    private int w;
    private z x;
    private z.f y;
    private j z;
    private boolean q = false;
    private int t = 0;
    private boolean u = false;
    private com.pinguo.album.c<Integer> v = null;
    private com.pinguo.album.j.i A = new com.pinguo.album.j.i();
    private com.pinguo.camera360.gallery.ui.toolbar.b E = new q();
    private final com.pinguo.album.views.a J = new a();
    private s.b K = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoPickAlbumPage.java */
    /* loaded from: classes3.dex */
    public class a extends com.pinguo.album.views.a {

        /* renamed from: l  reason: collision with root package name */
        private final float[] f6436l = new float[16];

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.pinguo.album.views.a
        public void v(boolean z, int i2, int i3, int i4, int i5) {
            c.this.y.m = ((ActivityState) c.this).a.F0().getHeight();
            c.this.A.d(0, i3);
            c.this.x.r(c.this.y.f6712g + i2, c.this.y.f6714i + i3, i4 - c.this.y.f6713h, i5 - c.this.y.f6715j);
            com.pinguo.album.j.c.n(this.f6436l, (i4 - i2) / 2, (i5 - i3) / 2, -c.this.B);
        }

        @Override // com.pinguo.album.views.a
        public void y(l lVar) {
            lVar.s(2);
            lVar.j(this.f6436l, 0);
            super.y(lVar);
            if (c.this.C != null) {
                boolean n = c.this.C.n(lVar, p(), n());
                float p = 1.0f - c.this.C.p();
                Message message = new Message();
                message.what = 6;
                message.obj = Float.valueOf(p);
                c.this.G.sendMessage(message);
                if (!n) {
                    c.this.C = null;
                }
                q();
                if (!n) {
                    c.this.C = null;
                }
                q();
            }
            lVar.b();
        }

        @Override // com.pinguo.album.views.a
        protected void z(l lVar) {
            lVar.m();
        }
    }

    /* compiled from: PhotoPickAlbumPage.java */
    /* loaded from: classes3.dex */
    class b implements s.b {
        b() {
        }

        @Override // com.pinguo.camera360.gallery.ui.s.b
        public Rect a(int i2) {
            Rect O0 = c.this.x.O0(i2);
            Rect e2 = c.this.x.e();
            O0.offset(e2.left - c.this.x.L0(), e2.top - c.this.x.M0());
            return O0;
        }

        @Override // com.pinguo.camera360.gallery.ui.s.b
        public int b(Path path) {
            int Q0 = c.this.x.Q0();
            for (int R0 = c.this.x.R0(); R0 < Q0; R0++) {
                w w = c.this.s.w(R0);
                if (w != null && w.g().equals(path)) {
                    return R0;
                }
            }
            return -1;
        }
    }

    /* compiled from: PhotoPickAlbumPage.java */
    /* renamed from: com.pinguo.camera360.gallery.photopick.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class HandlerC0241c extends Handler {
        HandlerC0241c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 6) {
                return;
            }
            c.this.D.a(((ActivityState) c.this).a, c.this.E, ((Float) message.obj).floatValue());
            if (((Float) message.obj).floatValue() > 0.5f || PhotoPickBroker.k().i() <= 0 || c.this.I == PhotoPickLauncher.LaunchMode.MULTI_PHOTO_FOR_PUZZLE) {
                return;
            }
            c.this.D.p(PhotoPickBroker.k().i());
        }
    }

    /* compiled from: PhotoPickAlbumPage.java */
    /* loaded from: classes3.dex */
    class d extends com.pinguo.album.g {
        d(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 4) {
                if (i2 == 5) {
                    c.this.Y0(message.arg1);
                    return;
                }
                throw new AssertionError(message.what);
            }
            Object obj = message.obj;
            if (obj != null) {
                c.this.X0(message.arg1, (com.pinguo.album.opengles.c) obj);
            } else {
                c.this.W0(message.arg1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoPickAlbumPage.java */
    /* loaded from: classes3.dex */
    public class e extends com.pinguo.camera360.gallery.ui.y {

        /* compiled from: PhotoPickAlbumPage.java */
        /* loaded from: classes3.dex */
        class a implements Runnable {
            final /* synthetic */ float a;

            a(float f2) {
                this.a = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.D.a(((ActivityState) c.this).a, c.this.E, this.a);
                if (this.a > 0.5f || PhotoPickBroker.k().i() <= 0 || c.this.I == PhotoPickLauncher.LaunchMode.MULTI_PHOTO_FOR_PUZZLE) {
                    return;
                }
                c.this.D.p(PhotoPickBroker.k().i());
            }
        }

        /* compiled from: PhotoPickAlbumPage.java */
        /* loaded from: classes3.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.D.a(((ActivityState) c.this).a, c.this.E, 0.0f);
                if (PhotoPickBroker.k().i() > 0 && c.this.I != PhotoPickLauncher.LaunchMode.MULTI_PHOTO_FOR_PUZZLE) {
                    c.this.D.p(PhotoPickBroker.k().i());
                }
                if (c.this.w() >= 0) {
                    ((ActivityState) c.this).a.B0().setBottomBarAnimVisibility(0);
                }
            }
        }

        e() {
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void h(boolean z, int i2, com.pinguo.album.opengles.c cVar) {
            if (!z || i2 < 0) {
                c.this.G.post(new b());
                return;
            }
            Message obtainMessage = c.this.F.obtainMessage(4, i2, 0);
            obtainMessage.obj = cVar;
            c.this.F.sendMessage(obtainMessage);
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void j(String str) {
            c.this.x.q1(str.substring(0, 7));
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void k(float f2) {
            c.this.G.post(new a(f2));
        }

        @Override // com.pinguo.camera360.gallery.ui.y, com.pinguo.camera360.gallery.ui.p
        public void l(int i2, float f2, float f3) {
            if (c.this.I.isSinglePhotoMode()) {
                c.this.U0(i2);
            } else if (f2 <= 0.65f || f3 >= 0.4f) {
                c.this.V0(i2);
            } else {
                c.this.U0(i2);
            }
        }
    }

    /* compiled from: PhotoPickAlbumPage.java */
    /* loaded from: classes3.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            com.pinguo.album.views.b E = ((ActivityState) c.this).a.E();
            E.c();
            c.this.E();
            E.g();
        }
    }

    /* compiled from: PhotoPickAlbumPage.java */
    /* loaded from: classes3.dex */
    class g implements Toolbar.OnMenuItemClickListener {
        g() {
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        @Instrumented
        public boolean onMenuItemClick(MenuItem menuItem) {
            VdsAgent.onMenuItemClick(this, menuItem);
            if (((ActivityState) c.this).a instanceof PhotoPickActivity) {
                ((PhotoPickActivity) ((ActivityState) c.this).a).W0();
                VdsAgent.handleClickResult(new Boolean(true));
                return true;
            }
            VdsAgent.handleClickResult(new Boolean(false));
            return false;
        }
    }

    /* compiled from: PhotoPickAlbumPage.java */
    /* loaded from: classes3.dex */
    class h implements Runnable {
        final /* synthetic */ int a;

        h(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.pinguo.album.views.b E = ((ActivityState) c.this).a.E();
            E.c();
            try {
                if (this.a == 0) {
                    c.this.u = true;
                }
                c.this.K0(2);
                if (this.a == 2 && c.this.q && c.this.s.H() == 0) {
                    new us.pinguo.foundation.ui.e(((ActivityState) c.this).a, (int) R.string.sync_album_error, ((ActivityState) c.this).a.q0()).d();
                }
            } finally {
                E.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoPickAlbumPage.java */
    /* loaded from: classes3.dex */
    public class i implements com.pinguo.camera360.gallery.x {
        private i() {
        }

        @Override // com.pinguo.camera360.gallery.x
        public void c() {
            synchronized (com.pinguo.camera360.gallery.data.o.f6371d) {
                c cVar = c.this;
                cVar.w = cVar.r.r();
            }
            c.this.K0(1);
            c cVar2 = c.this;
            cVar2.T(cVar2.w <= 0, R.drawable.empty_camera, R.string.empty_album_tips);
            if (c.this.w > 0) {
                c.this.Z0();
            }
        }

        @Override // com.pinguo.camera360.gallery.x
        public void d() {
            c.this.a1(1);
        }

        /* synthetic */ i(c cVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(int i2) {
        this.t = (~i2) & this.t;
    }

    private void M0(Bundle bundle) {
        y e2 = this.a.P().e(new Path(bundle.getInt("media-type"), bundle.getString("media-path-id")), bundle.getString("media-name"));
        this.r = e2;
        e2.A();
        this.p.j(this.r);
        n nVar = new n(this.a, this.r, 2);
        this.s = nVar;
        nVar.G(new i(this, null));
        this.z.E(this.s, true);
        this.D = r.a(7);
    }

    private void N0() {
        this.p = new x(this.a, true, false);
        if (this.I.isSinglePhotoMode()) {
            this.p.f();
        } else {
            this.p.l();
        }
        this.p.d(this);
        f0 a2 = f0.a(this.a);
        this.y = a2.a;
        com.pinguo.camera360.gallery.ui.b0.a c = com.pinguo.camera360.gallery.ui.b0.a.c(3);
        z zVar = new z(this.a, this.y, c);
        this.x = zVar;
        j jVar = new j(this.a, zVar, this.p, a2.b, c.l(), c.s());
        this.z = jVar;
        this.x.h1(jVar);
        this.J.c(this.x);
        this.x.e1(new e());
    }

    private com.pinguo.camera360.gallery.photopick.e O0(int i2) {
        Bitmap bitmap;
        try {
            w w = this.s.w(i2);
            String o = w.o();
            int t = w.t();
            Path g2 = w.g();
            try {
                bitmap = this.z.x(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                bitmap = null;
            }
            if (bitmap == null) {
                return null;
            }
            return new com.pinguo.camera360.gallery.photopick.e(i2, o, bitmap, t, g2.a(), this.r.g());
        } catch (Exception unused) {
            return null;
        }
    }

    private com.pinguo.camera360.gallery.photopick.e P0(int i2) {
        try {
            w w = this.s.w(i2);
            return new com.pinguo.camera360.gallery.photopick.e(i2, w.o(), w.g().a(), this.r.g());
        } catch (Exception unused) {
            return null;
        }
    }

    private void Q0(List<com.pinguo.camera360.gallery.photopick.e> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        PhotoPickBroker.k().m(list);
    }

    private void R0(Set<Integer> set) {
        ArrayList arrayList = new ArrayList(set.size());
        for (Integer num : set) {
            com.pinguo.camera360.gallery.photopick.e O0 = O0(num.intValue());
            if (O0 != null) {
                arrayList.add(O0);
            }
        }
        PhotoPickBroker.k().b(arrayList);
    }

    private void S0(int i2) {
        com.pinguo.camera360.gallery.photopick.e P0 = P0(i2);
        if (P0 != null) {
            PhotoPickBroker.k().l(P0);
        }
    }

    private void T0(int i2) {
        com.pinguo.camera360.gallery.photopick.e O0 = O0(i2);
        if (O0 != null) {
            PhotoPickBroker.k().a(O0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(int i2) {
        w w;
        if (this.q && (w = this.s.w(i2)) != null) {
            if (w.y()) {
                if (this.I.isMultiPhotoWithVideoMode()) {
                    if (PhotoPickBroker.k().i() == 0) {
                        if ((w instanceof u) && ((u) w).F() > this.H) {
                            c1(this.a.getResources().getString(R.string.photo_pick_video_time_filter, Integer.valueOf(this.H)));
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("photo_path", w.o());
                        RootActivity rootActivity = this.a;
                        rootActivity.a();
                        RootActivity rootActivity2 = rootActivity;
                        rootActivity2.setResult(-1, intent);
                        rootActivity2.finish();
                        return;
                    }
                    b1(R.string.photo_pick_video_multi_not_support);
                    return;
                }
                b1(R.string.photo_pick_video_msg_not_support);
            } else if (!TextUtils.isEmpty(w.o()) && w.o().toLowerCase().endsWith(".gif")) {
                b1(R.string.not_support_gif);
            } else {
                String s = w.s();
                PhotoPickLauncher.LaunchMode launchMode = this.I;
                PhotoPickLauncher.LaunchMode launchMode2 = PhotoPickLauncher.LaunchMode.MULTI_PHOTO_FOR_PUZZLE;
                if (launchMode == launchMode2 && !TextUtils.isEmpty(s) && s.contains(Emoticon.TYPE_PNG)) {
                    b1(R.string.puzzle_msg_pic_error);
                    return;
                }
                us.pinguo.common.log.a.k("mimeType = " + s, new Object[0]);
                boolean h2 = this.p.h(w.g(), i2);
                String o = w.o();
                if (!w.l()) {
                    b1(R.string.album_photo_not_exist);
                } else if (this.I.isSinglePhotoMode()) {
                    this.z.F(i2);
                    this.z.G();
                    Intent intent2 = new Intent();
                    intent2.putExtra("photo_path", w.o());
                    RootActivity rootActivity3 = this.a;
                    rootActivity3.a();
                    RootActivity rootActivity4 = rootActivity3;
                    rootActivity4.setResult(-1, intent2);
                    rootActivity4.finish();
                } else if (!h2 && !PhotoPickBroker.k().c()) {
                    c1(String.format(this.a.getString(R.string.album_puzzle_over_max_photo_limit), Integer.valueOf(PhotoPickBroker.k().h())));
                } else if (this.I == launchMode2 && !com.pinguo.camera360.gallery.photopick.h.a(o)) {
                    b1(R.string.album_photo_can_not_puzzled);
                } else {
                    this.p.q(i2, w.g());
                    this.x.q();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(int i2) {
        w w;
        if (this.q && (w = this.s.w(i2)) != null && w.l()) {
            Handler handler = this.F;
            handler.sendMessageDelayed(handler.obtainMessage(5, i2, 0), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(int i2, com.pinguo.album.opengles.c cVar) {
        if (this.q && this.s.w(i2) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("index-hint", i2);
            bundle.putInt("media-type", this.r.g().h());
            bundle.putString("media-path-id", this.r.g().f());
            this.a.H0().d("photo_anim_texture", cVar);
            this.a.E0().r(com.pinguo.camera360.gallery.photopick.g.class, 2, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(int i2) {
        if (this.q && !this.x.Y0(i2)) {
            W0(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        Path path;
        ArrayList arrayList = new ArrayList();
        for (com.pinguo.camera360.gallery.photopick.e eVar : PhotoPickBroker.k().j()) {
            if (eVar != null && (path = eVar.f6438e) != null && path.equals(this.r.g())) {
                arrayList.add(eVar.f6437d);
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Path path2 = (Path) it.next();
                if (!this.p.h(path2, -1)) {
                    this.p.b(path2);
                }
            }
            this.x.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(int i2) {
        this.t = i2 | this.t;
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void E() {
        a0(c.class, com.pinguo.camera360.gallery.photopick.d.class, StateTransAnim.Transition.TranslateOut);
        this.a.E0().d(this);
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void G(Bundle bundle, Bundle bundle2) {
        int[] intArray;
        this.B = n0.o(0.3f);
        this.G = new HandlerC0241c();
        this.F = new d(this.a.E());
        Serializable serializable = bundle.getSerializable("photo_pick_mode");
        if (serializable != null) {
            this.I = (PhotoPickLauncher.LaunchMode) serializable;
        } else {
            this.I = PhotoPickLauncher.LaunchMode.MULTI_PHOTO;
        }
        this.H = bundle.getInt(InspirePublishFragment.KEY_VIDEO_TIME_LIMIT, 60);
        N0();
        M0(bundle);
        if (bundle2 != null || bundle == null || (intArray = bundle.getIntArray("set-center")) == null) {
            return;
        }
        this.A.c(intArray[0], intArray[1]);
        this.x.n1(this.A);
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected boolean H(Menu menu) {
        if (this.C != null && this.D.e()) {
            this.D.a(this.a, this.E, 1.0f - this.C.p());
        } else {
            this.D.g(this.a.F0(), this.a.G0(), menu, this.a);
        }
        this.D.d();
        this.D.k(new f());
        this.D.l(new g());
        if (PhotoPickBroker.k().i() <= 0 || this.I == PhotoPickLauncher.LaunchMode.MULTI_PHOTO_FOR_PUZZLE) {
            return true;
        }
        this.D.p(PhotoPickBroker.k().i());
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void I() {
        super.I();
        n nVar = this.s;
        if (nVar != null) {
            nVar.G(null);
            this.s.B();
        }
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void J() {
        super.J();
        this.q = false;
        this.C = null;
        this.G.removeMessages(6);
        this.z.H(null);
        this.s.A();
        this.z.z();
        PhotoPickBroker.k().n(null);
        com.pinguo.album.c<Integer> cVar = this.v;
        if (cVar != null) {
            cVar.cancel();
            this.v = null;
            K0(2);
        }
        this.D.i(this.a);
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void L() {
        super.L();
        this.q = true;
        s sVar = (s) this.a.H0().b("resume_animation");
        this.C = sVar;
        if (sVar != null) {
            sVar.r(this.K);
            this.C.l();
        }
        Q(this.J);
        PhotoPickBroker.k().n(this);
        R(this.a.getResources().getColor(R.color.common_album_background_color));
        a1(1);
        this.s.C();
        this.z.C();
        if (!this.u) {
            a1(2);
            this.v = this.r.z(this);
        }
        this.w = this.r.r();
    }

    public void L0(int i2, String str) {
        try {
            if (this.s.w(i2).o() == null || !this.s.w(i2).o().equals(str)) {
                return;
            }
            Path g2 = this.s.w(i2).g();
            if (this.p.h(g2, i2)) {
                this.p.q(i2, g2);
                this.x.q();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void O(int i2, int i3, Intent intent) {
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.x.m1();
        } else if (intent != null) {
            this.x.V0(intent.getIntExtra("return-index-hint", 0));
        }
    }

    protected void W0(int i2) {
        if (this.q && this.s.w(i2) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("index-hint", i2);
            bundle.putInt("media-type", this.r.g().h());
            bundle.putString("media-path-id", this.r.g().f());
            Rect O0 = this.x.O0(i2);
            bundle.putParcelable("open-animation-rect", new Rect(O0.left, O0.top - this.x.M0(), O0.right, O0.bottom - this.x.M0()));
            this.a.E0().r(com.pinguo.camera360.gallery.photopick.g.class, 2, bundle);
        }
    }

    public void b1(int i2) {
        RootActivity rootActivity = this.a;
        if (rootActivity == null) {
            return;
        }
        rootActivity.y0(i2);
    }

    public void c1(String str) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.z0(str);
    }

    @Override // com.pinguo.camera360.gallery.ui.o.b
    public void h(boolean z, Set<Integer> set) {
        if (z) {
            R0(set);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : set) {
            com.pinguo.camera360.gallery.photopick.e P0 = P0(num.intValue());
            if (P0 != null) {
                arrayList.add(P0);
            }
        }
        Q0(arrayList);
    }

    @Override // com.pinguo.camera360.gallery.ui.o.a
    public void l() {
        if (this.I.isMultiPhotoNotPuzzleMode()) {
            this.D.p(PhotoPickBroker.k().i());
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.o.b
    public void n(boolean z, int i2) {
        if (z) {
            T0(i2);
        } else {
            S0(i2);
        }
    }

    @Override // com.pinguo.camera360.gallery.data.y.d
    public void r(y yVar, int i2) {
        this.a.runOnUiThread(new h(i2));
    }

    @Override // com.pinguo.camera360.gallery.ui.o.a
    public void s(int i2) {
        if (i2 == 1) {
            this.D.b(this.a);
            if (this.I.isMultiPhotoNotPuzzleMode()) {
                this.D.p(PhotoPickBroker.k().i());
            }
            this.J.q();
        } else if (i2 != 2) {
        } else {
            this.D.f(this.a);
            if (this.I.isMultiPhotoNotPuzzleMode()) {
                this.D.p(PhotoPickBroker.k().i());
            }
            this.J.q();
        }
    }
}
