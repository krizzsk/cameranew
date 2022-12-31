package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: NativeVideoController.java */
/* loaded from: classes.dex */
public class f implements c, d, ad.a {
    private WeakReference<c.InterfaceC0056c> C;
    private WeakReference<a> D;
    private int E;
    private int F;
    private long R;
    private int T;
    private h b;
    private final WeakReference<ViewGroup> c;

    /* renamed from: g  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.e.d f1834g;

    /* renamed from: h  reason: collision with root package name */
    private c.a f1835h;

    /* renamed from: k  reason: collision with root package name */
    private long f1838k;

    /* renamed from: l  reason: collision with root package name */
    private List<Runnable> f1839l;
    private boolean m;
    private final WeakReference<Context> n;
    private final boolean o;
    private final com.bytedance.sdk.openadsdk.core.d.h r;
    private String u;
    private WeakReference<e> v;

    /* renamed from: d  reason: collision with root package name */
    private final ad f1831d = new ad(this);

    /* renamed from: e  reason: collision with root package name */
    private long f1832e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f1833f = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f1836i = 0;

    /* renamed from: j  reason: collision with root package name */
    private long f1837j = 0;
    private boolean p = false;
    private boolean q = false;
    private boolean s = true;
    private boolean t = false;
    private long w = 0;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private boolean B = true;
    private int G = 0;
    private boolean H = false;
    private boolean I = true;
    private final Runnable J = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f1834g != null) {
                f.this.f1834g.e();
            }
        }
    };
    private final Runnable K = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f1835h != null) {
                f.this.f1835h.a();
            }
        }
    };
    private final Runnable L = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.5
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f1834g != null) {
                if (f.this.f1838k <= 0) {
                    f.this.f1834g.e();
                }
                f.this.f1834g.f();
            }
            f.this.f1831d.postDelayed(this, 200L);
        }
    };
    private int M = 0;
    private long N = 0;
    Runnable a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.6
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.b != null) {
                f.this.b.a(f.this.r, f.this.n, false);
                f.this.b.w();
                f.this.d(true);
                o.e("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private long O = 0;
    private long P = 0;
    private boolean Q = false;
    private final BroadcastReceiver S = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.7
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                f.this.h();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                f.this.d(context);
            }
        }
    };
    private boolean U = false;

    /* compiled from: NativeVideoController.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.f$8  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.a.values().length];
            a = iArr;
            try {
                iArr[e.a.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.a.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.a.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: NativeVideoController.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i2);

        void f();
    }

    public f(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, boolean z) {
        this.u = "embeded_ad";
        this.E = 0;
        this.F = 0;
        this.T = 1;
        this.T = q.c(context);
        b(z);
        this.u = str;
        try {
            this.E = viewGroup.getWidth();
            this.F = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.c = new WeakReference<>(viewGroup);
        this.n = new WeakReference<>(context);
        this.r = hVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        B();
        this.f1831d.postDelayed(this.L, 800L);
    }

    private void B() {
        this.f1831d.removeCallbacks(this.L);
    }

    private boolean C() {
        WeakReference<Context> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void D() {
        List<Runnable> list = this.f1839l;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.f1839l).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f1839l.clear();
    }

    private void E() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar != null) {
            dVar.a(false, this.f1836i, !this.t);
            A();
        }
        if (this.p) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_continue", o(), q(), c());
        }
    }

    private void F() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.O;
        this.P = elapsedRealtime;
        if (this.p) {
            return;
        }
        Map<String, Object> a2 = ab.a(elapsedRealtime, this.r, t());
        if (this.B) {
            com.bytedance.sdk.openadsdk.c.d.b(this.n.get(), this.r, this.u, "feed_auto_play", a2);
        } else if (this.f1836i <= 0) {
            com.bytedance.sdk.openadsdk.c.d.b(this.n.get(), this.r, this.u, "feed_play", a2);
        }
        this.p = true;
    }

    private void G() {
        if (this.c.get() == null || w.a(this.c.get(), 20, 0)) {
            return;
        }
        o.e("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
        this.b.a(this.r, this.n, false);
        d(true);
        l();
    }

    private void H() {
        o.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
        if (this.c.get() == null || w.a(this.c.get(), 20, 0)) {
            return;
        }
        o.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
        if (r2 > 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0091, code lost:
        r3 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void I() {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.I():void");
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b J() {
        h hVar;
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null || this.n.get().getResources().getConfiguration().orientation != 1 || (hVar = this.b) == null) {
            return null;
        }
        return hVar.o();
    }

    private void K() {
        if (C()) {
            h(!this.Q);
            if (!(this.n.get() instanceof Activity)) {
                o.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            h hVar = this.b;
            if (hVar != null) {
                hVar.b(this.c.get());
                this.b.b(false);
            }
            a(1);
            WeakReference<e> weakReference = this.v;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.Q);
            }
        }
    }

    private void L() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.c(0);
            this.b.a(false, false);
            this.b.b(false);
            this.b.b();
            this.b.d();
        }
    }

    private void M() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.r;
        if (hVar != null) {
            com.bytedance.sdk.openadsdk.core.o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.F(), true, this.r));
        }
    }

    private boolean z() {
        o.b("NativeVideoController", "retryCount=" + this.G);
        int i2 = this.G;
        if (1 <= i2) {
            h hVar = this.b;
            if (hVar != null) {
                hVar.w();
                this.b.a(this.r, this.n, false);
            }
            return false;
        } else if (this.f1834g == null) {
            return false;
        } else {
            this.G = i2 + 1;
            o.b("NativeVideoController", "isPlaying=" + this.f1834g.g() + ",isPaused=" + this.f1834g.i() + ",isPrepared=" + this.f1834g.k() + ",isStarted=" + this.f1834g.h());
            return (this.f1834g.g() && this.f1834g.i() && this.f1834g.k() && this.f1834g.h()) ? false : true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar != null) {
            dVar.c();
            this.f1834g = null;
        }
        if (!ab.a(this.r) || this.M == 2) {
            this.b.a(this.r, this.n, true);
        }
        ad adVar = this.f1831d;
        if (adVar != null) {
            adVar.removeCallbacks(this.L);
            this.f1831d.removeCallbacks(this.K);
            this.f1831d.removeCallbacks(this.J);
            this.f1831d.removeCallbacksAndMessages(null);
        }
        B();
        List<Runnable> list = this.f1839l;
        if (list != null) {
            list.clear();
        }
        if (this.s) {
            y();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long m() {
        return this.f1836i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        if (t() == null) {
            return 0L;
        }
        return t().n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar == null) {
            return 0L;
        }
        return dVar.o() + this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int q() {
        return com.bytedance.sdk.openadsdk.core.video.f.a.a(this.f1837j, this.f1838k);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long r() {
        return this.f1838k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean s() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.e.d t() {
        return this.f1834g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h u() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean v() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.H;
    }

    public void x() {
        if (this.U || !this.I) {
            return;
        }
        Context applicationContext = com.bytedance.sdk.openadsdk.core.o.a().getApplicationContext();
        this.U = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            applicationContext.registerReceiver(this.S, intentFilter);
        } catch (Exception unused) {
        }
    }

    public void y() {
        if (this.U && this.I) {
            Context applicationContext = com.bytedance.sdk.openadsdk.core.o.a().getApplicationContext();
            this.U = false;
            try {
                applicationContext.unregisterReceiver(this.S);
            } catch (Exception unused) {
            }
        }
    }

    @SuppressLint({"InflateParams"})
    private void b(Context context) {
        View inflate;
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        if (this.s) {
            inflate = c(context);
        } else {
            inflate = LayoutInflater.from(context.getApplicationContext()).inflate(t.f(context, "tt_video_detail_layout"), (ViewGroup) null, false);
        }
        View view = inflate;
        if (view == null) {
            return;
        }
        if (this.s) {
            this.b = new h(context, view, true, noneOf, this.r, this, a());
        } else {
            this.b = new g(context, view, true, noneOf, this.r, this, false);
        }
        this.b.a(this);
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(t.e(context, "tt_root_view"));
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(t.e(context, "tt_video_loading_retry_layout"));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(t.e(context, "tt_video_loading_cover_image"));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        ProgressBar progressBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        progressBar.setId(t.e(context, "tt_video_loading_progress"));
        layoutParams3.addRule(13, -1);
        progressBar.setLayoutParams(layoutParams3);
        progressBar.setIndeterminateDrawable(t.c(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(progressBar);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(t.e(context, "tt_video_play"));
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageResource(t.d(context, "tt_play_movebar_textpage"));
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        ProgressBar progressBar2 = new ProgressBar(context, null, t.g(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        progressBar2.setMax(100);
        progressBar2.setId(t.e(context, "tt_video_progress"));
        progressBar2.setBackgroundColor(0);
        progressBar2.setIndeterminateDrawable(null);
        progressBar2.setProgressDrawable(t.c(context, "tt_video_progress_drawable"));
        progressBar2.setVisibility(8);
        VdsAgent.onSetViewVisibility(progressBar2, 8);
        layoutParams5.addRule(12, -1);
        progressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(progressBar2);
        ViewStub viewStub = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        viewStub.setId(t.e(context, "tt_video_ad_cover"));
        viewStub.setLayoutParams(layoutParams6);
        viewStub.setLayoutResource(t.f(context, "tt_video_ad_cover_layout"));
        relativeLayout.addView(viewStub);
        ViewStub viewStub2 = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(13, -1);
        viewStub2.setId(t.e(context, "tt_video_draw_layout_viewStub"));
        viewStub2.setLayoutParams(layoutParams7);
        viewStub2.setLayoutResource(t.f(context, "tt_video_draw_btn_layout"));
        relativeLayout.addView(viewStub2);
        return relativeLayout;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void e(long j2) {
        this.N = j2;
    }

    public boolean f() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        return dVar != null && dVar.g();
    }

    public void g(boolean z) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
        }
        h hVar2 = this.b;
        if (hVar2 != null && z) {
            hVar2.u();
        }
        E();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar != null) {
            dVar.b();
        }
        if (this.q || !this.p) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", o(), q(), c());
            }
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", Boolean.TRUE);
            return;
        }
        if (s.a().b()) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", o(), q(), c());
        }
        s.a().a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
        }
        h hVar2 = this.b;
        if (hVar2 != null) {
            hVar2.u();
        }
        E();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(b bVar, View view) {
        a(bVar, view, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.I = z;
    }

    public void a(final NativeVideoTsView.b bVar) {
        h hVar;
        if (!this.s || (hVar = this.b) == null) {
            return;
        }
        hVar.a(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
            public void a(View view, int i2) {
                NativeVideoTsView.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(view, i2);
                }
            }
        });
    }

    public void d(long j2) {
        this.f1836i = j2;
        long j3 = this.f1837j;
        if (j3 > j2) {
            j2 = j3;
        }
        this.f1837j = j2;
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar != null) {
            dVar.a(true, this.f1836i, !this.t);
            A();
        }
    }

    public boolean e() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        return dVar == null || dVar.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
        this.B = z;
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(drawVideoListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        if (q.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0) {
            return;
        }
        l();
        a(this.r.v().h(), this.r.J(), this.E, this.F, null, this.r.M(), 0L, b());
        d(false);
    }

    public void a(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return;
        }
        this.E = i2;
        this.F = i3;
        o.b("NativeVideoController", "width=" + i2 + "height=" + i3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0056c interfaceC0056c) {
        this.C = new WeakReference<>(interfaceC0056c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.Q) {
            h(false);
            h hVar = this.b;
            if (hVar != null) {
                hVar.b(this.c.get());
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i2, int i3, List<String> list, String str3, long j2, boolean z) {
        o.b("tag_video_play", "[video] start NativeVideoController#playVideoUrl and video url is :\r\n" + str);
        if (TextUtils.isEmpty(str)) {
            o.e("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.t = z;
        this.f1836i = j2;
        int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i4 <= 0) {
            this.q = false;
            this.p = false;
        }
        if (i4 > 0) {
            this.f1836i = j2;
            long j3 = this.f1837j;
            if (j3 > j2) {
                j2 = j3;
            }
            this.f1837j = j2;
        }
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
            if (this.M == 0) {
                this.b.d();
            }
            this.b.c(i2, i3);
            this.b.c(this.c.get());
            this.b.a(i2, i3);
        }
        if (this.f1834g == null) {
            this.f1834g = new com.bytedance.sdk.openadsdk.core.video.e.d(this.f1831d);
        }
        o.b("tag_video_play", "[video] new MediaPlayer");
        this.f1833f = 0L;
        try {
            a(str);
            return true;
        } catch (Exception e2) {
            o.e("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + e2.toString());
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.s = z;
        h hVar = this.b;
        if (hVar != null) {
            hVar.c(z);
        }
    }

    private void h(boolean z) {
        this.Q = z;
    }

    private boolean d(int i2) {
        com.bytedance.sdk.openadsdk.core.d.h hVar;
        int c = q.c(com.bytedance.sdk.openadsdk.core.o.a());
        if (c == 0) {
            h();
            this.x = true;
            h hVar2 = this.b;
            if (hVar2 != null) {
                hVar2.a(this.r, this.n, false);
            }
        }
        if (c != 4 && c != 0) {
            h hVar3 = this.b;
            if (hVar3 != null) {
                hVar3.e();
            }
            h();
            this.x = true;
            this.y = false;
            h hVar4 = this.b;
            if (hVar4 != null && (hVar = this.r) != null) {
                return hVar4.a(i2, hVar.v());
            }
        } else if (c == 4) {
            this.x = false;
            h hVar5 = this.b;
            if (hVar5 != null) {
                hVar5.q();
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j2) {
        this.w = j2;
    }

    public boolean b() {
        return this.t;
    }

    private void b(int i2) {
        h hVar;
        this.M++;
        if (C() && (hVar = this.b) != null) {
            hVar.w();
            c.a aVar = this.f1835h;
            if (aVar != null) {
                aVar.a(this.f1833f, com.bytedance.sdk.openadsdk.core.video.f.a.a(this.f1836i, this.f1838k));
            }
            this.f1833f = System.currentTimeMillis() - this.f1832e;
            if (!ab.a(this.r) || this.M >= 2) {
                this.b.a(this.r, this.n, true);
            }
            if (!this.q) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_over", o(), 100, c());
                this.q = true;
                long j2 = this.f1838k;
                a(j2, j2);
                long j3 = this.f1838k;
                this.f1836i = j3;
                this.f1837j = j3;
            }
            if (!this.s && this.Q) {
                e(this.b, null);
            }
            this.z = true;
            if (!ab.a(this.r) || this.M >= 2) {
                return;
            }
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        int c = q.c(context);
        a(context, c);
        if (c == 4) {
            this.x = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j2) {
        this.f1836i = j2;
        long j3 = this.f1837j;
        if (j3 > j2) {
            j2 = j3;
        }
        this.f1837j = j2;
    }

    public boolean a() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.z = z;
    }

    private void a(String str) {
        o.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
        if (this.f1834g != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.a = str;
            com.bytedance.sdk.openadsdk.core.d.h hVar = this.r;
            if (hVar != null) {
                if (hVar.v() != null) {
                    aVar.f1784d = this.r.v().k();
                }
                aVar.b = String.valueOf(ab.d(this.r.M()));
            }
            aVar.c = 0;
            this.f1834g.a(aVar);
            o.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
        }
        this.f1832e = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.b.d(8);
            this.b.d(0);
            a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f1832e = System.currentTimeMillis();
                    f.this.b.c(0);
                    if (f.this.f1834g == null || f.this.f1836i != 0) {
                        if (f.this.f1834g != null) {
                            f.this.f1834g.a(true, f.this.f1836i, !f.this.t);
                        }
                    } else {
                        f.this.f1834g.a(true, 0L, !f.this.t);
                    }
                    if (f.this.f1831d != null) {
                        f.this.f1831d.postDelayed(f.this.J, 100L);
                    }
                    f.this.A();
                }
            });
        }
        if (this.s) {
            x();
        }
    }

    private void b(Runnable runnable) {
        if (this.f1839l == null) {
            this.f1839l = Collections.synchronizedList(new ArrayList());
        }
        this.f1839l.add(runnable);
    }

    private void b(int i2, int i3) {
        if (this.r == null) {
            return;
        }
        boolean f2 = f();
        String str = f2 ? "play_error" : "play_start_error";
        Map<String, Object> a2 = ab.a(this.r, i2, i3, t());
        if (f2) {
            a2.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(o()));
            a2.put("percent", Integer.valueOf(q()));
            a2.put("buffers_time", Long.valueOf(n()));
        }
        com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, str, a2);
    }

    public f(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        this.u = "embeded_ad";
        this.E = 0;
        this.F = 0;
        this.T = 1;
        this.T = q.c(context);
        try {
            this.E = viewGroup.getWidth();
            this.F = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.c = new WeakReference<>(viewGroup);
        this.u = str;
        this.n = new WeakReference<>(context);
        this.r = hVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i2) {
        if (this.f1834g != null) {
            B();
        }
        h hVar = this.b;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.v = new WeakReference<>(eVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.b.k() && this.m) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    public void b(b bVar, View view, boolean z, boolean z2) {
        if (C()) {
            h(!this.Q);
            if (!(this.n.get() instanceof Activity)) {
                o.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.Q) {
                a(z ? 8 : 0);
                h hVar = this.b;
                if (hVar != null) {
                    hVar.a(this.c.get());
                    this.b.b(false);
                }
            } else {
                a(1);
                h hVar2 = this.b;
                if (hVar2 != null) {
                    hVar2.b(this.c.get());
                    this.b.b(false);
                }
            }
            WeakReference<e> weakReference = this.v;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.Q);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.f1835h = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        if (this.s) {
            this.N = o();
        }
        if (!this.q && this.p) {
            if (z) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_break", this.N, q(), c());
                this.q = false;
            } else {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", this.N, q(), c());
            }
        }
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j2) {
        this.f1838k = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.t = z;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    protected Map<String, Object> c() {
        return ab.a(this.r, n(), t());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(b bVar, View view) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.g();
        }
        a(true);
    }

    private boolean c(int i2) {
        return this.b.b(i2);
    }

    private boolean c(int i2, int i3) {
        o.b("TTVideoLandingPageActivity", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        WeakReference<a> weakReference2;
        if (this.b == null || message == null || (weakReference = this.n) == null || weakReference.get() == null) {
            return;
        }
        int i2 = message.what;
        if (i2 == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.f1838k = ((Long) message.obj).longValue();
        } else if (i2 == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                long longValue = ((Long) obj2).longValue();
                this.f1836i = longValue;
                long j2 = this.f1837j;
                if (j2 <= longValue) {
                    j2 = longValue;
                }
                this.f1837j = j2;
                a(longValue, this.f1838k);
            }
        } else if (i2 == 308) {
            o.e("NativeVideoController", "播放器状态出错 STAT_ERROR 200 、、、、、、、");
            G();
            b(308, 0);
        } else if (i2 != 309) {
            switch (i2) {
                case 302:
                    b(i2);
                    return;
                case 303:
                    int i3 = message.arg1;
                    int i4 = message.arg2;
                    b(i3, i4);
                    o.e("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!f() || i4 == -1004) {
                        o.e("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + i3 + "," + i4);
                        if (c(i3, i4)) {
                            o.e("NativeVideoController", "出错后展示结果页、、、、、、、");
                            this.b.a(this.r, this.n, false);
                            d(true);
                            l();
                        }
                        h hVar = this.b;
                        if (hVar != null) {
                            hVar.w();
                        }
                        c.a aVar = this.f1835h;
                        if (aVar != null) {
                            aVar.b(this.f1833f, com.bytedance.sdk.openadsdk.core.video.f.a.a(this.f1836i, this.f1838k));
                        }
                        WeakReference<c.InterfaceC0056c> weakReference3 = this.C;
                        if (weakReference3 == null || weakReference3.get() == null || f()) {
                            return;
                        }
                        this.C.get().a(i3, i4);
                        return;
                    }
                    return;
                case 304:
                    int i5 = message.arg1;
                    h hVar2 = this.b;
                    if (hVar2 != null) {
                        if (i5 == 3 || i5 == 702) {
                            hVar2.w();
                            this.f1831d.removeCallbacks(this.a);
                            this.H = false;
                        } else if (i5 == 701) {
                            hVar2.t();
                            this.f1831d.postDelayed(this.a, 8000L);
                            this.H = true;
                        }
                    }
                    if (this.o && i5 == 3) {
                        if (this.s && (weakReference2 = this.D) != null && weakReference2.get() != null) {
                            this.D.get().f();
                        }
                        M();
                        this.f1831d.removeCallbacks(this.a);
                    }
                    if (this.o && i5 == 3) {
                        F();
                        return;
                    }
                    return;
                case 305:
                    WeakReference<c.InterfaceC0056c> weakReference4 = this.C;
                    if (weakReference4 != null && weakReference4.get() != null) {
                        this.C.get().f();
                    }
                    ad adVar = this.f1831d;
                    if (adVar != null) {
                        adVar.removeCallbacks(this.K);
                    }
                    if (!this.o) {
                        F();
                    }
                    h hVar3 = this.b;
                    if (hVar3 != null) {
                        hVar3.w();
                    }
                    this.f1831d.removeCallbacks(this.a);
                    return;
                case 306:
                    h hVar4 = this.b;
                    if (hVar4 != null) {
                        hVar4.w();
                        return;
                    }
                    return;
                default:
                    switch (i2) {
                        case 311:
                            I();
                            return;
                        case 312:
                            if (z()) {
                                o.e("NativeVideoController", "CALLBACK_ON_RETRY_VIDEO_TIME-....重试....");
                                l();
                                this.f1834g = null;
                                a(this.r.v().h(), this.r.J(), this.E, this.F, null, this.r.M(), 0L, b());
                                return;
                            }
                            o.c("NativeVideoController", "不满足条件，无法重试");
                            return;
                        case 313:
                            H();
                            return;
                        case 314:
                            this.O = SystemClock.elapsedRealtime();
                            return;
                        default:
                            return;
                    }
            }
        } else {
            o.c("NativeVideoController", "SSMediaPlayerWrapper 释放了。。。。。");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.m = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.m = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.f1834g == null || !C()) {
            return;
        }
        if (this.f1834g.g()) {
            h();
            this.b.b(true, false);
            this.b.c();
        } else if (!this.f1834g.i()) {
            h hVar = this.b;
            if (hVar != null) {
                hVar.c(this.c.get());
            }
            d(this.f1836i);
            h hVar2 = this.b;
            if (hVar2 != null) {
                hVar2.b(false, false);
            }
        } else {
            g(false);
            h hVar3 = this.b;
            if (hVar3 != null) {
                hVar3.b(false, false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2) {
        if (this.f1834g == null) {
            return;
        }
        A();
        a(this.R, c(i2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2, boolean z) {
        if (C()) {
            long l2 = (((float) (i2 * this.f1838k)) * 1.0f) / t.l(this.n.get(), "tt_video_progress_max");
            if (this.f1838k > 0) {
                this.R = (int) l2;
            } else {
                this.R = 0L;
            }
            h hVar = this.b;
            if (hVar != null) {
                hVar.a(this.R);
            }
        }
    }

    private void a(long j2, long j3) {
        this.f1836i = j2;
        this.f1838k = j3;
        this.b.a(j2, j3);
        this.b.a(com.bytedance.sdk.openadsdk.core.video.f.a.a(j2, j3));
        try {
            c.a aVar = this.f1835h;
            if (aVar != null) {
                aVar.a(j2, j3);
            }
        } catch (Throwable th) {
            o.c("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    public void a(int i2) {
        if (C()) {
            boolean z = i2 == 0 || i2 == 8;
            Context context = this.n.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i2);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view, boolean z, boolean z2) {
        if (this.s) {
            h();
        }
        if (z && !this.s && !e()) {
            this.b.b(!f(), false);
            this.b.a(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar != null && dVar.g()) {
            this.b.c();
            this.b.b();
            return;
        }
        this.b.c();
    }

    public void a(b bVar, View view, boolean z) {
        K();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.m = true;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceHolder);
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.m = true;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.f1834g;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceTexture);
        D();
    }

    private void a(long j2, boolean z) {
        if (this.f1834g == null) {
            return;
        }
        if (z) {
            L();
        }
        this.f1834g.a(j2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(e.a aVar, String str) {
        int i2 = AnonymousClass8.a[aVar.ordinal()];
        if (i2 == 1) {
            h();
        } else if (i2 == 2) {
            a(true);
        } else if (i2 != 3) {
        } else {
            j();
            this.x = false;
            this.y = true;
        }
    }

    private void a(Context context, int i2) {
        if (!C() || context == null || this.T == i2) {
            return;
        }
        this.T = i2;
        if (i2 != 4 && i2 != 0) {
            this.y = false;
        }
        if (!this.y && !v()) {
            d(2);
        }
        WeakReference<a> weakReference = this.D;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.D.get().a(this.T);
    }

    public void a(Context context) {
        int c = q.c(context);
        a(context, c);
        if (c == 4) {
            this.x = false;
            j();
        }
    }

    public void a(a aVar) {
        this.D = new WeakReference<>(aVar);
    }
}
