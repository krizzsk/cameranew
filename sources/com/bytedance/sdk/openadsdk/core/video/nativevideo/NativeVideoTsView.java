package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class NativeVideoTsView extends FrameLayout implements c.a, f.a, ad.a {
    private AtomicBoolean A;
    protected final com.bytedance.sdk.openadsdk.core.d.h a;
    protected c b;
    protected FrameLayout c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f1818d;

    /* renamed from: e  reason: collision with root package name */
    protected RelativeLayout f1819e;

    /* renamed from: f  reason: collision with root package name */
    protected ImageView f1820f;

    /* renamed from: g  reason: collision with root package name */
    protected ImageView f1821g;

    /* renamed from: h  reason: collision with root package name */
    protected ImageView f1822h;

    /* renamed from: i  reason: collision with root package name */
    protected String f1823i;

    /* renamed from: j  reason: collision with root package name */
    protected int f1824j;

    /* renamed from: k  reason: collision with root package name */
    AtomicBoolean f1825k;

    /* renamed from: l  reason: collision with root package name */
    boolean f1826l;
    public a m;
    private final Context n;
    private ViewGroup o;
    private boolean p;
    private boolean q;
    private boolean r;
    private long s;
    private final ad t;
    private boolean u;
    private final String v;
    private ViewStub w;
    private c.b x;
    private final AtomicBoolean y;
    private boolean z;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, long j2, long j3, long j4, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, int i2);
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this(context, hVar, false);
    }

    private void e() {
        a(0L, 0);
        this.x = null;
    }

    private void j() {
        addView(a(this.n));
        l();
    }

    private void k() {
        if (!(this instanceof NativeDrawVideoTsView) || this.f1825k.get() || com.bytedance.sdk.openadsdk.core.h.b().q() == null) {
            return;
        }
        this.f1822h.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.b().q());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f1822h.getLayoutParams();
        int a2 = (int) ac.a(getContext(), this.f1824j);
        layoutParams.width = a2;
        layoutParams.height = a2;
        this.f1822h.setLayoutParams(layoutParams);
        this.f1825k.set(true);
    }

    private void l() {
        this.b = new f(this.n, this.c, this.a, this.f1823i, !w());
        m();
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                ((f) nativeVideoTsView.b).a(nativeVideoTsView.o.getWidth(), NativeVideoTsView.this.o.getHeight());
                NativeVideoTsView.this.o.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void m() {
        c cVar = this.b;
        if (cVar == null) {
            return;
        }
        cVar.e(this.p);
        ((f) this.b).a((f.a) this);
        this.b.a(this);
    }

    private void n() {
        c cVar = this.b;
        if (cVar == null) {
            l();
        } else if ((cVar instanceof f) && !w()) {
            ((f) this.b).x();
        }
        if (this.b == null || !this.y.get()) {
            return;
        }
        this.y.set(false);
        c();
        if (h()) {
            ac.a((View) this.f1819e, 8);
            ImageView imageView = this.f1821g;
            if (imageView != null) {
                ac.a((View) imageView, 8);
            }
            this.b.a(this.a.v().h(), this.a.J(), this.o.getWidth(), this.o.getHeight(), null, this.a.M(), 0L, v());
            this.b.d(false);
        } else if (this.b.v()) {
            o.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.b.v());
            b(true);
        } else {
            o.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            g();
            ac.a((View) this.f1819e, 0);
        }
    }

    private void o() {
        this.m = null;
        i();
        p();
    }

    private void p() {
        if (!this.y.get()) {
            this.y.set(true);
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(true);
            }
        }
        this.A.set(false);
    }

    private void q() {
        c(w.a(this, 50, 5));
        this.t.sendEmptyMessageDelayed(1, 500L);
    }

    private boolean r() {
        if (w()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private void s() {
        if (w()) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", bool);
    }

    private void t() {
        if (this.b == null || w() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)) {
            return;
        }
        boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
        long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", 0L);
        long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.b.o());
        long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.b.r());
        this.b.d(a2);
        this.b.a(a3);
        this.b.b(a4);
        this.b.c(a5);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
        o.e("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
    }

    private boolean u() {
        return 2 == com.bytedance.sdk.openadsdk.core.o.h().c(ab.d(this.a.M()));
    }

    private boolean v() {
        return this.f1818d;
    }

    private boolean w() {
        return this.q;
    }

    private void x() {
        ac.f(this.f1821g);
        ac.f(this.f1819e);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j2, int i2) {
    }

    public void b(boolean z) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.d(z);
            h u = this.b.u();
            if (u != null) {
                u.w();
                View s = u.s();
                if (s != null) {
                    if (s.getParent() != null) {
                        ((ViewGroup) s.getParent()).removeView(s);
                    }
                    s.setVisibility(0);
                    VdsAgent.onSetViewVisibility(s, 0);
                    addView(s);
                    u.a(this.a, new WeakReference<>(this.n), false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.a;
        if (hVar == null) {
            return;
        }
        int d2 = ab.d(hVar.M());
        int c = com.bytedance.sdk.openadsdk.core.o.h().c(d2);
        if (c == 1) {
            this.p = q.d(this.n);
        } else if (c == 2) {
            this.p = q.e(this.n) || q.d(this.n);
        } else if (c == 3) {
            this.p = false;
        } else if (c == 4) {
            this.f1826l = true;
        }
        if (!this.q) {
            this.f1818d = com.bytedance.sdk.openadsdk.core.o.h().a(d2);
        } else {
            this.f1818d = false;
        }
        if ("splash_ad".equals(this.f1823i)) {
            this.p = true;
            this.f1818d = true;
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.e(this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (q.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0) {
            return;
        }
        if (this.b.t() != null) {
            if (this.b.t().g()) {
                c(false);
                ad adVar = this.t;
                if (adVar != null) {
                    adVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.b.t().i()) {
                c(true);
                ad adVar2 = this.t;
                if (adVar2 != null) {
                    adVar2.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
                return;
            }
        }
        if (h() || this.A.get()) {
            return;
        }
        this.A.set(true);
        x();
        this.b.a(this.a.v().h(), this.a.J(), this.o.getWidth(), this.o.getHeight(), null, this.a.M(), this.s, v());
        ad adVar3 = this.t;
        if (adVar3 != null) {
            adVar3.sendEmptyMessageDelayed(1, 500L);
        }
        a(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void f() {
        c.b bVar = this.x;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        ViewStub viewStub;
        if (this.n == null || (viewStub = this.w) == null || viewStub.getParent() == null || this.a == null || this.f1819e != null) {
            return;
        }
        this.f1819e = (RelativeLayout) this.w.inflate();
        if (this.a.v() != null && this.a.v().g() != null) {
            com.bytedance.sdk.openadsdk.g.d.a(this.n).a(this.a.v().g(), this.f1820f);
        }
        this.f1820f = (ImageView) findViewById(t.e(this.n, "tt_native_video_img_id"));
        this.f1822h = (ImageView) findViewById(t.e(this.n, "tt_native_video_play"));
        k();
    }

    public c getNativeVideoController() {
        return this.b;
    }

    public boolean h() {
        return this.p;
    }

    public void i() {
        h u;
        c cVar = this.b;
        if (cVar == null || (u = cVar.u()) == null) {
            return;
        }
        u.e();
        View s = u.s();
        if (s != null) {
            s.setVisibility(8);
            VdsAgent.onSetViewVisibility(s, 8);
            if (s.getParent() != null) {
                ((ViewGroup) s.getParent()).removeView(s);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        n();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar;
        c cVar;
        if (!this.q && (aVar = this.m) != null && (cVar = this.b) != null) {
            aVar.a(cVar.v(), this.b.r(), this.b.o(), this.b.m(), this.p);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        o();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        super.onWindowFocusChanged(z);
        t();
        if (r() && (cVar4 = this.b) != null && cVar4.v()) {
            s();
            ac.a((View) this.f1819e, 8);
            b(true);
            e();
            return;
        }
        c();
        if (!w() && h() && (cVar2 = this.b) != null && !cVar2.s()) {
            if (this.t != null) {
                if (z && (cVar3 = this.b) != null && !cVar3.v()) {
                    this.t.obtainMessage(1).sendToTarget();
                    return;
                }
                this.t.removeMessages(1);
                c(false);
            }
        } else if (h()) {
        } else {
            if (!z && (cVar = this.b) != null && cVar.t() != null && this.b.t().g()) {
                this.t.removeMessages(1);
                c(false);
            } else if (z) {
                this.t.obtainMessage(1).sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        c cVar;
        c cVar2;
        c cVar3;
        super.onWindowVisibilityChanged(i2);
        t();
        if (this.z) {
            this.z = i2 == 0;
        }
        if (r() && (cVar3 = this.b) != null && cVar3.v()) {
            s();
            ac.a((View) this.f1819e, 8);
            b(true);
            e();
            return;
        }
        c();
        if (w() || !h() || (cVar = this.b) == null || cVar.s()) {
            return;
        }
        if (this.r) {
            this.b.a(this.a.v().h(), this.a.J(), this.o.getWidth(), this.o.getHeight(), null, this.a.M(), this.s, v());
            this.r = false;
            ac.a((View) this.f1819e, 8);
        }
        if (i2 != 0 || this.t == null || (cVar2 = this.b) == null || cVar2.v()) {
            return;
        }
        this.t.obtainMessage(1).sendToTarget();
    }

    public void setControllerStatusCallBack(a aVar) {
        this.m = aVar;
    }

    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        c cVar = this.b;
        if (cVar != null) {
            ((f) cVar).a(drawVideoListener);
        }
    }

    public void setIsAutoPlay(boolean z) {
        if (this.u) {
            return;
        }
        int c = com.bytedance.sdk.openadsdk.core.o.h().c(ab.d(this.a.M()));
        if (z && c != 4 && (!q.e(this.n) ? !q.d(this.n) : !u())) {
            z = false;
        }
        this.p = z;
        c cVar = this.b;
        if (cVar != null) {
            cVar.e(z);
        }
        if (!this.p) {
            g();
            RelativeLayout relativeLayout = this.f1819e;
            if (relativeLayout != null) {
                ac.a((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.g.d.a(this.n).a(this.a.v().g(), this.f1820f);
            }
        } else {
            ac.a((View) this.f1819e, 8);
        }
        this.u = true;
    }

    public void setIsQuiet(boolean z) {
        this.f1818d = z;
        c cVar = this.b;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void setNativeVideoController(c cVar) {
        this.b = cVar;
    }

    public void setVideoAdClickListener(b bVar) {
        c cVar = this.b;
        if (cVar != null) {
            ((f) cVar).a(bVar);
        }
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        this.x = bVar;
    }

    public void setVideoAdLoadListener(c.InterfaceC0056c interfaceC0056c) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(interfaceC0056c);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        VdsAgent.onSetViewVisibility(this, i2);
        if (i2 == 4 || i2 == 8) {
            p();
        }
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.h hVar, boolean z) {
        this(context, hVar, z, "embeded_ad");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j2, int i2) {
        c.b bVar = this.x;
        if (bVar != null) {
            bVar.d_();
        }
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.h hVar, boolean z, String str) {
        super(context);
        this.p = true;
        this.f1818d = true;
        this.q = false;
        this.f1823i = "embeded_ad";
        this.f1824j = 50;
        this.r = true;
        this.f1825k = new AtomicBoolean(false);
        this.t = new ad(this);
        this.u = false;
        this.v = Build.MODEL;
        this.f1826l = false;
        this.y = new AtomicBoolean(false);
        this.z = true;
        this.A = new AtomicBoolean(false);
        this.f1823i = str;
        this.n = context;
        this.a = hVar;
        this.q = z;
        setContentDescription("NativeVideoAdView");
        c();
        j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j2, long j3) {
        c.b bVar = this.x;
        if (bVar != null) {
            bVar.a(j2, j3);
        }
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(t.e(this.n, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(frameLayout, 8);
        this.o = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(t.e(this.n, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.c = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        viewStub.setId(t.e(this.n, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(t.f(this.n, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.w = viewStub;
        return frameLayout;
    }

    private void c(boolean z) {
        if (this.a == null || this.b == null) {
            return;
        }
        boolean r = r();
        s();
        if (r && this.b.v()) {
            o.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + r + "，mNativeVideoController.isPlayComplete()=" + this.b.v());
            b(true);
            e();
        } else if (z && !this.b.v() && !this.b.s()) {
            if (this.b.t() != null && this.b.t().i()) {
                if (this.p) {
                    if ("ALP-AL00".equals(this.v)) {
                        this.b.j();
                    } else {
                        ((f) this.b).g(r);
                    }
                    c.b bVar = this.x;
                    if (bVar != null) {
                        bVar.c();
                    }
                }
            } else if (this.p && this.b.t() == null) {
                if (!this.y.get()) {
                    this.y.set(true);
                }
                this.A.set(false);
                n();
            }
        } else if (this.b.t() == null || !this.b.t().g()) {
        } else {
            this.b.h();
            c.b bVar2 = this.x;
            if (bVar2 != null) {
                bVar2.d();
            }
        }
    }

    public boolean a(long j2, boolean z, boolean z2) {
        c cVar;
        ViewGroup viewGroup = this.o;
        viewGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup, 0);
        if (this.b == null) {
            this.b = new f(this.n, this.c, this.a, this.f1823i);
            m();
        }
        this.s = j2;
        if (w()) {
            this.b.b(false);
            boolean a2 = this.b.a(this.a.v().h(), this.a.J(), this.o.getWidth(), this.o.getHeight(), null, this.a.M(), j2, v());
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (((i2 > 0 && !z && !z2) || (i2 > 0 && z)) && (cVar = this.b) != null) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n, this.a, this.f1823i, "feed_continue", cVar.o(), this.b.q(), ab.a(this.a, this.b.n(), this.b.t()));
            }
            return a2;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message.what != 1) {
            return;
        }
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void a(int i2) {
        c();
    }

    protected void a(boolean z) {
        if (this.f1821g == null) {
            this.f1821g = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.h.b().q() != null) {
                this.f1821g.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.b().q());
            } else {
                this.f1821g.setImageResource(t.d(com.bytedance.sdk.openadsdk.core.o.a(), "tt_new_play_video"));
            }
            this.f1821g.setScaleType(ImageView.ScaleType.FIT_XY);
            int a2 = (int) ac.a(getContext(), this.f1824j);
            int a3 = (int) ac.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = a3;
            layoutParams.bottomMargin = a3;
            this.o.addView(this.f1821g, layoutParams);
        }
        if (z) {
            this.f1821g.setVisibility(0);
        } else {
            this.f1821g.setVisibility(8);
        }
    }
}
