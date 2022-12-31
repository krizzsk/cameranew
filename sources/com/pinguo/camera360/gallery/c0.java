package com.pinguo.camera360.gallery;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.views.b;
import com.pinguo.camera360.gallery.a0;
import com.pinguo.camera360.gallery.b0;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.ui.PhotoPageBottomController;
import com.pinguo.camera360.gallery.ui.u;
import com.pinguo.camera360.k.b.a;
import java.io.File;
import java.io.IOException;
import us.pinguo.foundation.statistics.F$key;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.share.util.InspireShareUtils;
import us.pinguo.ui.widget.dialog.LifeCycleDialog;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoPage.java */
/* loaded from: classes3.dex */
public class c0 extends ActivityState implements u.i, a0.a, View.OnClickListener, PhotoPageBottomController.b, Toolbar.OnMenuItemClickListener {
    private a0 A;
    private boolean B;
    private com.pinguo.camera360.gallery.h0.a C;
    private com.pinguo.camera360.gallery.ui.toolbar.b E;
    protected PhotoPageBottomController F;
    protected com.pinguo.camera360.gallery.ui.r G;
    private boolean I;
    private RelativeLayout J;
    private h K;
    private Handler N;
    protected LifeCycleDialog p;
    protected com.pinguo.camera360.gallery.ui.x r;
    private int s;
    protected com.pinguo.camera360.gallery.ui.u t;
    protected f u;
    private Path v;
    private com.pinguo.camera360.gallery.data.y w;
    private final com.pinguo.album.views.a q = new a();
    private int x = 0;
    private int y = 0;
    private com.pinguo.camera360.gallery.data.w z = null;
    private boolean D = false;
    private int H = 0;
    private b0.b L = new b();
    private boolean M = false;

    /* compiled from: PhotoPage.java */
    /* loaded from: classes3.dex */
    class a extends com.pinguo.album.views.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.pinguo.album.views.a
        public void v(boolean z, int i2, int i3, int i4, int i5) {
            us.pinguo.common.log.a.m("PhotoPage", "onlayout changed = " + z + "left =" + i2 + " top = right = " + i4 + " bottom = " + i5, new Object[0]);
            c0.this.t.r(0, 0, i4 - i2, i5 - i3);
        }

        @Override // com.pinguo.album.views.a
        protected void z(com.pinguo.album.opengles.l lVar) {
            lVar.m();
        }
    }

    /* compiled from: PhotoPage.java */
    /* loaded from: classes3.dex */
    class b implements b0.b {
        b() {
        }

        private void b() {
            com.pinguo.camera360.gallery.data.w g2 = c0.this.u.g(0);
            if (g2 != null) {
                c0.this.Q0(g2);
                c0.this.t.Q0(!g2.y());
            }
        }

        @Override // com.pinguo.camera360.gallery.b0.b
        public void a(int i2, String str) {
            us.pinguo.common.log.a.m("PhotoPage", "onPhotoChanged index = " + i2 + " item = " + str, new Object[0]);
            if (c0.this.D) {
                c0.this.N.removeMessages(1);
            }
            c0.this.x = i2;
            b();
        }

        @Override // com.pinguo.camera360.gallery.x
        public void c() {
            if (c0.this.u.isEmpty()) {
                if (!c0.this.B || c0.this.s == 1) {
                    if (c0.this.s == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("media-type", 1304);
                        bundle.putString("media-path-id", "");
                        c0.this.a.E0().p(t.class, bundle);
                        return;
                    }
                    c0.this.a.E0().d(c0.this);
                    return;
                }
                c0.this.I0();
                return;
            }
            c0.this.T(false, R.drawable.empty_camera, R.string.empty_album_tips);
            b();
        }

        @Override // com.pinguo.camera360.gallery.x
        public void d() {
            c0 c0Var = c0.this;
            c0Var.y = c0Var.w.r();
            if (c0.this.x >= c0.this.y - 1) {
                return;
            }
            int unused = c0.this.x;
        }
    }

    /* compiled from: PhotoPage.java */
    /* loaded from: classes3.dex */
    class c extends com.pinguo.album.g {
        c(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                c0.this.B0(true);
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
            } else {
                if (i2 == 6) {
                    c0.this.a.E().d();
                    return;
                }
                throw new AssertionError(message.what);
            }
        }
    }

    /* compiled from: PhotoPage.java */
    /* loaded from: classes3.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (c0.this.t.A0() || !c0.this.D) {
                return;
            }
            com.pinguo.album.views.b E = c0.this.a.E();
            E.c();
            c0.this.A0();
            E.g();
        }
    }

    /* compiled from: PhotoPage.java */
    /* loaded from: classes3.dex */
    class e extends AsyncTask<Object, Object, Boolean> {
        final /* synthetic */ double a;
        final /* synthetic */ double b;

        e(double d2, double d3) {
            this.a = d2;
            this.b = d3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Object... objArr) {
            return Boolean.valueOf(c0.this.U0(this.a, this.b));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (c0.this.D() || bool == null || !bool.booleanValue()) {
                return;
            }
            Toast makeText = Toast.makeText(c0.this.a, (int) R.string.album_picture_update_success, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        }
    }

    /* compiled from: PhotoPage.java */
    /* loaded from: classes3.dex */
    public interface f extends u.c {
        boolean isEmpty();

        void pause();

        void resume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoPage.java */
    /* loaded from: classes3.dex */
    public class g implements b.a {
        private com.pinguo.camera360.gallery.ui.s a;
        private boolean b = false;
        private int c;

        g(int i2) {
            this.c = i2;
            this.a = new com.pinguo.camera360.gallery.ui.s(i2);
        }

        @Override // com.pinguo.album.views.b.a
        public synchronized void a() {
            this.b = true;
            notifyAll();
        }

        @Override // com.pinguo.album.views.b.a
        public synchronized boolean b(com.pinguo.album.opengles.l lVar, boolean z) {
            c0 c0Var = c0.this;
            this.a = c0Var.t.r0(c0Var.q, lVar, this.c);
            this.b = true;
            notifyAll();
            return false;
        }

        public synchronized com.pinguo.camera360.gallery.ui.s c() {
            while (!this.b) {
                com.pinguo.album.j.a.r(this);
            }
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoPage.java */
    /* loaded from: classes3.dex */
    public class h {
        private ViewGroup a;
        private AnimatorSet b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PhotoPage.java */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                com.pinguo.camera360.gallery.i0.a.c().f(false);
                if (c0.this.J != null && h.this.a != null) {
                    c0.this.J.removeView(h.this.a);
                }
                c0.this.a.F0().setVisibility(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PhotoPage.java */
        /* loaded from: classes3.dex */
        public class b extends AnimatorListenerAdapter {
            final /* synthetic */ ImageView a;

            b(ImageView imageView) {
                this.a = imageView;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.a.setTranslationY(0.0f);
                h.this.b.start();
            }
        }

        private h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            com.pinguo.camera360.gallery.i0.a.c().f(false);
            if (c0.this.J != null && this.a != null) {
                c0.this.J.removeView(this.a);
                c0.this.a.F0().setVisibility(0);
                this.a = null;
                c0.this.K = null;
            }
            AnimatorSet animatorSet = this.b;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.b.removeAllListeners();
                this.b = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(RelativeLayout relativeLayout) {
            if (relativeLayout != null) {
                ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) c0.this.a.getSystemService("layout_inflater")).inflate(R.layout.photo_page_anim_layer, (ViewGroup) relativeLayout, false);
                this.a = viewGroup;
                relativeLayout.addView(viewGroup);
                this.b = (AnimatorSet) AnimatorInflater.loadAnimator(c0.this.a, R.animator.photo_page_guide_anim);
                ImageView imageView = (ImageView) this.a.findViewById(R.id.anim_circle);
                ((TextView) this.a.findViewById(R.id.cancel_guide)).setOnClickListener(new a());
                this.b.setTarget(imageView);
                this.b.addListener(new b(imageView));
                this.b.start();
            }
        }

        boolean f() {
            AnimatorSet animatorSet = this.b;
            return animatorSet != null && animatorSet.isRunning();
        }

        /* synthetic */ h(c0 c0Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        if (com.pinguo.camera360.gallery.i0.a.c().a()) {
            h hVar = this.K;
            if (hVar != null) {
                hVar.e();
                return;
            }
            return;
        }
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(boolean z) {
        if (this.D) {
            this.N.removeMessages(1);
            this.D = false;
            if (this.M) {
                R(this.a.getResources().getColor(R.color.black));
                this.a.E().requestRender();
                if (z) {
                    this.a.F0().setTopBarAnimVisibility(4);
                    this.F.o();
                    this.a.F0().getMenu().clear();
                }
                this.E.o(4);
            }
        }
    }

    public static boolean C0(int i2, int i3, com.pinguo.camera360.gallery.ui.u uVar) {
        int p = uVar.p();
        int n = uVar.n();
        return Math.abs(i2 - (p / 2)) * 10 <= p && Math.abs(i3 - (n / 2)) * 10 <= n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public /* synthetic */ void F0() {
        com.pinguo.camera360.gallery.data.w wVar = this.z;
        if (wVar == null) {
            return;
        }
        if (wVar.y()) {
            InspireShareUtils.showShareDialogToSNS(2, this.z.o(), (String) null, (Context) this.a, true, "album_browse_photo");
        } else {
            d.h.a.a.e(this.a, this.z, true, "album_browse_photo");
        }
        if (!this.I) {
            com.pinguo.camera360.gallery.data.y yVar = this.w;
            if (!(yVar instanceof com.pinguo.camera360.gallery.data.p)) {
                if (yVar instanceof com.pinguo.camera360.gallery.data.g) {
                    us.pinguo.foundation.statistics.l.onEvent("c360_gallery_Post_fromStory", F$key.gallery);
                    return;
                } else {
                    us.pinguo.foundation.statistics.l.onEvent("c360_gallery_Post_fromPhoto", F$key.gallery);
                    return;
                }
            }
        }
        us.pinguo.foundation.statistics.l.onEvent("c360_gallery_Post_fromAlbum", F$key.gallery);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void G0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void H0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.a.finish();
        Intent intent = new Intent();
        RootActivity rootActivity = this.a;
        rootActivity.a();
        intent.setClassName(rootActivity, "com.pinguo.camera360.gallery.GalleryActivity");
        this.a.startActivity(intent);
    }

    private void K0() {
        Intent intent = new Intent();
        intent.putExtra("return-index-hint", this.x);
        Z(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        us.pinguo.user.util.j.a.b(this.a, new Runnable() { // from class: com.pinguo.camera360.gallery.g
            @Override // java.lang.Runnable
            public final void run() {
                c0.this.F0();
            }
        }, j.a, i.a);
    }

    private void M0(boolean z) {
        if (this.D || !this.M) {
            return;
        }
        R(this.a.getResources().getColor(R.color.photo_background_color));
        this.a.E().requestRender();
        this.N.removeMessages(1);
        this.D = true;
        this.a.E().requestRender();
        if (z) {
            this.a.F0().setTopBarAnimVisibility(0);
            this.F.w();
        }
        this.E.o(0);
    }

    private void N0(String str) {
        float f2;
        try {
            float[] fArr = new float[2];
            if (!new ExifInterface(str).getLatLong(fArr)) {
                fArr = null;
            }
            float f3 = -9999.0f;
            if (fArr == null) {
                f2 = -9999.0f;
            } else {
                f3 = fArr[0];
                f2 = fArr[1];
            }
            this.a.startActivityForResult(us.pinguo.librouter.b.b.b().getInterface().e(this.a, f3, f2), 110);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    private void O0() {
        if (this.D) {
            B0(true);
        } else {
            M0(true);
        }
    }

    private void P0() {
        if (this.F.r()) {
            this.F.f();
            return;
        }
        com.pinguo.camera360.gallery.data.w wVar = this.z;
        if (wVar == null) {
            return;
        }
        if (wVar.y()) {
            com.pinguo.camera360.gallery.data.u uVar = (com.pinguo.camera360.gallery.data.u) this.z;
        }
        this.F.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(com.pinguo.camera360.gallery.data.w wVar) {
        if (this.z == wVar) {
            return;
        }
        this.z = wVar;
        R0();
        this.z.y();
        com.pinguo.camera360.gallery.data.w wVar2 = this.z;
        if (wVar2 instanceof com.pinguo.camera360.gallery.data.u) {
            ((com.pinguo.camera360.gallery.data.u) wVar2).F();
        }
        this.r.p(wVar.g());
        this.E.n(true, 0);
        Size y0 = y0(this.z);
        this.F.v(wVar, y0.getWidth(), y0.getHeight());
    }

    private void R0() {
        ImageView imageView = (ImageView) this.a.F0().findViewById(R.id.favorite);
        if (imageView == null) {
            return;
        }
        if (this.z instanceof com.pinguo.camera360.gallery.data.h) {
            if (imageView.getVisibility() != 0) {
                imageView.setVisibility(0);
            }
            S0(imageView, this.z.x());
        } else if (imageView.getVisibility() != 4) {
            imageView.setVisibility(4);
        }
    }

    private void S0(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(R.drawable.ic_album_favorite_selected);
        } else {
            imageView.setImageResource(R.drawable.ic_album_favorite);
        }
    }

    private void T0(boolean z) {
        S0((ImageView) this.a.F0().findViewById(R.id.favorite), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U0(double d2, double d3) {
        try {
            ExifInterface exifInterface = new ExifInterface(this.z.o());
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, w0(d2));
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? "N" : androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, w0(d3));
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST : androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST);
            exifInterface.saveAttributes();
            return true;
        } catch (IOException e2) {
            us.pinguo.common.log.a.f(e2);
            return false;
        }
    }

    private String w0(double d2) {
        double d3 = d2 % 1.0d;
        String valueOf = String.valueOf((int) d2);
        double d4 = d3 * 60.0d;
        double d5 = d4 % 1.0d;
        int i2 = (int) d4;
        if (i2 < 0) {
            i2 *= -1;
        }
        String valueOf2 = String.valueOf(i2);
        int i3 = (int) (d5 * 60.0d);
        if (i3 < 0) {
            i3 *= -1;
        }
        String valueOf3 = String.valueOf(i3);
        return valueOf + "/1," + valueOf2 + "/1," + valueOf3 + "/1";
    }

    private Size y0(com.pinguo.camera360.gallery.data.w wVar) {
        int w = wVar.w();
        int q = wVar.q();
        if ((w == 0 || q == 0) && !TextUtils.isEmpty(wVar.o()) && new File(wVar.o()).exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(wVar.o(), options);
            int i2 = options.outWidth;
            q = options.outHeight;
            w = i2;
        }
        return new Size(w, q);
    }

    private void z0() {
        if (this.z.y()) {
            this.a.y0(R.string.video_not_support);
            return;
        }
        this.C.d(this.z.o(), null);
        us.pinguo.foundation.statistics.l.onEvent("c360_gallery_edit", F$key.gallery);
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void E() {
        if (this.F.r()) {
            this.F.f();
        } else {
            A0();
        }
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        b0 b0Var;
        a.d.b();
        com.pinguo.camera360.gallery.ui.u uVar = new com.pinguo.camera360.gallery.ui.u(this.a);
        this.t = uVar;
        uVar.S0(this);
        this.N = new c(this.a.E());
        this.C = new com.pinguo.camera360.gallery.h0.a(this.a);
        this.q.c(this.t);
        a0 D0 = this.a.D0();
        this.A = D0;
        D0.h(this);
        this.a.E().setOrientationSource(this.A);
        this.B = bundle.getBoolean("only-page-in-stack", false);
        this.H = bundle.getInt("pic_source", 0);
        int i2 = bundle.getInt("media-type");
        this.v = new Path(i2, bundle.getString("media-path-id"));
        this.s = bundle.getInt("photo_page_come_from", 0);
        this.E = u0(i2);
        com.pinguo.camera360.gallery.data.y t0 = t0(this.v);
        this.w = t0;
        if (t0 instanceof com.pinguo.camera360.gallery.data.r) {
            this.I = true;
        } else if ((t0 instanceof com.pinguo.camera360.gallery.data.z) && ((com.pinguo.camera360.gallery.data.z) t0).G()) {
            this.I = true;
        }
        this.x = bundle.getInt("index-hint", 0);
        com.pinguo.album.opengles.c cVar = (com.pinguo.album.opengles.c) this.a.H0().b("photo_anim_texture");
        if (cVar != null) {
            b0Var = new b0(this.a, this.t, this.w, this.x, cVar, this.H);
        } else {
            b0Var = new b0(this.a, this.t, this.w, this.x, this.H);
        }
        this.u = b0Var;
        this.t.O0(b0Var);
        b0Var.b0(this.L);
        this.r = new com.pinguo.camera360.gallery.ui.x(this.a, false);
        RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.content_res_0x7f0901de);
        this.J = relativeLayout;
        if (relativeLayout != null) {
            PhotoPageBottomController photoPageBottomController = new PhotoPageBottomController(this.J);
            this.F = photoPageBottomController;
            photoPageBottomController.u(this);
        }
        this.G = new com.pinguo.camera360.gallery.ui.r(this.a, this.r);
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected boolean H(Menu menu) {
        this.E.g(this.a.F0(), this.a.G0(), menu, this.a);
        this.E.l(this);
        this.E.k(new d());
        View findViewById = this.a.F0().findViewById(R.id.operationLayout);
        if (findViewById != null) {
            findViewById.setVisibility(0);
            VdsAgent.onSetViewVisibility(findViewById, 0);
            ImageView imageView = (ImageView) this.a.F0().findViewById(R.id.favorite);
            if (this.z == null) {
                imageView.setVisibility(4);
            }
            this.a.F0().findViewById(R.id.picInfo).setOnClickListener(this);
            imageView.setOnClickListener(this);
            return true;
        }
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void I() {
        View findViewById = this.a.F0().findViewById(R.id.operationLayout);
        if (findViewById != null) {
            findViewById.setVisibility(8);
            VdsAgent.onSetViewVisibility(findViewById, 8);
        }
        a.d.c(R.id.header_bar_back);
        this.A.l(this);
        this.a.E().setOrientationSource(null);
        this.N.removeCallbacksAndMessages(null);
        this.N.removeMessages(1);
        this.s = 0;
        this.E.h(this.a);
        PhotoPageBottomController photoPageBottomController = this.F;
        if (photoPageBottomController != null) {
            photoPageBottomController.e();
        }
        super.I();
        this.p = null;
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public void J() {
        super.J();
        us.pinguo.foundation.statistics.g.e("Community_AlbumDetail_Page");
        this.a.E().i();
        this.M = false;
        this.a.E().d();
        this.N.removeMessages(1);
        this.N.removeMessages(6);
        if (C() && this.s != 1) {
            J0();
        }
        this.t.L0();
        this.u.pause();
        B0(false);
        if (C()) {
            this.E.i(this.a);
        }
        h hVar = this.K;
        if (hVar != null) {
            hVar.e();
        }
        LifeCycleDialog lifeCycleDialog = this.p;
        if (lifeCycleDialog != null) {
            lifeCycleDialog.onPause();
        }
    }

    protected void J0() {
        g gVar;
        com.pinguo.album.views.b E = this.a.E();
        if (this.D) {
            RootActivity rootActivity = this.a;
            rootActivity.a();
            gVar = new g(rootActivity.getResources().getColor(R.color.photo_background_color));
        } else {
            RootActivity rootActivity2 = this.a;
            rootActivity2.a();
            gVar = new g(rootActivity2.getResources().getColor(R.color.black));
        }
        E.g();
        try {
            E.f();
            E.j(gVar);
            com.pinguo.camera360.gallery.ui.s c2 = gVar.c();
            E.c();
            com.pinguo.camera360.gallery.data.w wVar = this.z;
            if (wVar != null) {
                if (!wVar.y() || this.z.o().toLowerCase().endsWith("mp4")) {
                    this.a.H0().d("resume_animation", c2);
                }
            }
        } catch (Throwable th) {
            E.c();
            throw th;
        }
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    protected void L() {
        super.L();
        us.pinguo.foundation.statistics.g.f("Community_AlbumDetail_Page");
        RootActivity rootActivity = this.a;
        rootActivity.a();
        us.pinguo.foundation.statistics.l.onEvent(rootActivity, "Community_AlbumDetail_Page");
        this.M = true;
        this.a.E().e();
        Q(this.q);
        this.D = false;
        M0(false);
        this.u.resume();
        this.t.M0();
        this.N.sendEmptyMessageDelayed(6, 300L);
        if (com.pinguo.camera360.gallery.i0.a.c().a() && !us.pinguo.foundation.f.f10996d && v0()) {
            this.K = new h(this, null);
            this.a.F0().setVisibility(4);
            this.K.g(this.J);
        }
        LifeCycleDialog lifeCycleDialog = this.p;
        if (lifeCycleDialog != null) {
            lifeCycleDialog.onResume();
        }
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public void O(int i2, int i3, Intent intent) {
        Window window;
        if (i2 == 110 && i3 == -1) {
            if (this.z.o() == null) {
                return;
            }
            us.pinguo.librouter.b.c.f c2 = us.pinguo.librouter.b.b.b().getInterface().c(this.a, intent);
            new e(c2.c(), c2.d()).execute(new Object[0]);
        } else if ((i2 == 205 || i2 == 1005) && i3 == -1 && !this.f6292g && (window = this.a.getWindow()) != null) {
            window.getDecorView().post(new Runnable() { // from class: com.pinguo.camera360.gallery.h
                @Override // java.lang.Runnable
                public final void run() {
                    c0.this.L0();
                }
            });
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void a() {
        if (this.F.r()) {
            this.F.f();
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void b() {
        us.pinguo.common.log.a.m("PhotoPage", "onLongPress mPhotoView.getFilmMode() = " + this.t.z0(), new Object[0]);
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void c() {
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void d() {
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void f() {
        this.N.sendEmptyMessage(2);
    }

    @Override // com.pinguo.camera360.gallery.a0.a
    public void g() {
        this.a.E().h();
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void i() {
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void j(boolean z) {
        this.N.obtainMessage(4, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public boolean k() {
        h hVar = this.K;
        return hVar != null && hVar.f();
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void m(int i2, int i3) {
        if (this.F.r()) {
            this.F.f();
            return;
        }
        com.pinguo.camera360.gallery.data.w g2 = this.u.g(0);
        if (g2 == null) {
            return;
        }
        if (g2.y() && C0(i2, i3, this.t)) {
            this.p = us.pinguo.inspire_proxy.media.e.j(this.a, g2.o());
        } else {
            O0();
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public boolean o() {
        B0(true);
        return true;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        if (id == R.id.favorite) {
            t(view);
        } else if (id == R.id.go_to_google_maps) {
            N0(this.z.o());
        } else if (id != R.id.picInfo) {
        } else {
            P0();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    @Instrumented
    public boolean onMenuItemClick(MenuItem menuItem) {
        VdsAgent.onMenuItemClick(this, menuItem);
        int itemId = menuItem.getItemId();
        if ((this.z != null || itemId == R.id.action_go_to_album) && !this.t.A0() && this.D) {
            int itemId2 = menuItem.getItemId();
            if (itemId2 == R.id.action_go_to_album) {
                Bundle bundle = new Bundle();
                bundle.putInt("media-type", 1304);
                bundle.putString("media-path-id", "");
                this.a.E0().p(t.class, bundle);
            } else if (itemId2 == R.id.action_set_to_cover) {
                this.G.y(R.id.action_set_to_cover, this.z.g(), null);
            } else if (itemId2 == R.id.check_picture_info) {
                P0();
            }
            VdsAgent.handleClickResult(new Boolean(true));
            return true;
        }
        VdsAgent.handleClickResult(new Boolean(false));
        return false;
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void p() {
        this.a.E().d();
    }

    @Override // com.pinguo.camera360.gallery.ui.u.i
    public void q() {
        s0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0() {
        K0();
        super.E();
    }

    @Override // com.pinguo.camera360.gallery.ui.PhotoPageBottomController.b
    public void t(View view) {
        if (this.z == null || this.t.A0() || !this.D || com.pinguo.camera360.gallery.i0.a.c().a()) {
            return;
        }
        boolean l2 = this.z.l();
        if (view.getId() != R.id.delete_button && !l2) {
            RootActivity rootActivity = this.a;
            rootActivity.a();
            Toast makeText = Toast.makeText(rootActivity, (int) R.string.plus_sandbox_tips_file_not_exit_without_sync, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
            return;
        }
        switch (view.getId()) {
            case R.id.delete_button /* 2131296784 */:
                this.r.e(this.z.g(), true);
                int i2 = R.string.pgcommon_delete_tip;
                if (this.z.g().h() == 1205) {
                    i2 = R.string.remove_pic_tips;
                }
                this.G.p(view.getId(), i2, null);
                us.pinguo.foundation.statistics.l.onEvent("c360_gallery_delete", F$key.gallery);
                return;
            case R.id.edit_button /* 2131296834 */:
                z0();
                return;
            case R.id.favorite /* 2131296898 */:
                if (this.z.y()) {
                    this.a.y0(R.string.video_not_support);
                    return;
                }
                boolean z = !this.z.x();
                T0(z);
                this.z.C(z);
                RootActivity rootActivity2 = this.a;
                rootActivity2.a();
                int b2 = us.pinguo.foundation.base.e.b(rootActivity2, "favorite_tip");
                if (b2 < 3 && z) {
                    RootActivity rootActivity3 = this.a;
                    rootActivity3.a();
                    us.pinguo.foundation.base.e.f(rootActivity3, "favorite_tip", b2 + 1);
                    this.a.y0(R.string.add_favorite_toast);
                }
                us.pinguo.foundation.statistics.l.onEvent("c360_gallery_favorite", F$key.gallery);
                return;
            case R.id.share_button /* 2131297916 */:
                if (us.pinguo.foundation.utils.j.b(1000L)) {
                    return;
                }
                L0();
                return;
            default:
                return;
        }
    }

    protected com.pinguo.camera360.gallery.data.y t0(Path path) {
        return this.a.P().e(path, "");
    }

    protected com.pinguo.camera360.gallery.ui.toolbar.b u0(int i2) {
        if (this.s == 1) {
            return com.pinguo.camera360.gallery.ui.toolbar.r.a(13);
        }
        return com.pinguo.camera360.gallery.ui.toolbar.r.a(i2 == 1203 ? 6 : 5);
    }

    protected boolean v0() {
        return true;
    }

    public Path x0() {
        return this.v;
    }
}
