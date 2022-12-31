package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.f.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
/* compiled from: NativeVideoLayout.java */
/* loaded from: classes.dex */
public class h implements b, com.bytedance.sdk.openadsdk.core.video.renderview.a, d.a, e.b, ad.a {
    com.bytedance.sdk.openadsdk.core.widget.e A;
    d B;
    boolean C;
    d.a.a.a.a.a.b D;
    c E;
    com.bytedance.sdk.openadsdk.core.a.a F;
    com.bytedance.sdk.openadsdk.core.a.a G;
    TTDrawFeedAd.DrawVideoListener H;
    boolean I;
    private View J;
    private TextView K;
    private TextView L;
    private NativeVideoTsView.b M;
    private final String N;
    View a;
    com.bytedance.sdk.openadsdk.core.video.renderview.b b;
    ImageView c;

    /* renamed from: d  reason: collision with root package name */
    View f1840d;

    /* renamed from: e  reason: collision with root package name */
    View f1841e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f1842f;

    /* renamed from: g  reason: collision with root package name */
    ViewStub f1843g;

    /* renamed from: h  reason: collision with root package name */
    View f1844h;

    /* renamed from: i  reason: collision with root package name */
    ImageView f1845i;

    /* renamed from: j  reason: collision with root package name */
    View f1846j;

    /* renamed from: k  reason: collision with root package name */
    RoundImageView f1847k;

    /* renamed from: l  reason: collision with root package name */
    TextView f1848l;
    TextView m;
    TextView n;
    ProgressBar o;
    ViewStub p;
    int q;
    int r;
    int s;
    int t;
    boolean u;
    boolean v;
    int w;
    EnumSet<b.a> x;
    com.bytedance.sdk.openadsdk.core.d.h y;
    Context z;

    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, com.bytedance.sdk.openadsdk.core.d.h hVar, c cVar, boolean z2) {
        this.u = true;
        this.C = true;
        this.I = true;
        this.N = Build.MODEL;
        if (this instanceof g) {
            return;
        }
        this.z = o.a().getApplicationContext();
        c(z2);
        this.a = view;
        this.u = z;
        this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.E = cVar;
        this.y = hVar;
        c(8);
        a(context, this.a);
        a();
        n();
    }

    private boolean A() {
        return "C8817D".equals(this.N) || "M5".equals(this.N) || "R7t".equals(this.N);
    }

    private void b(View view, Context context) {
        ViewStub viewStub;
        if (view == null || context == null || (viewStub = this.p) == null || viewStub.getParent() == null || this.J != null) {
            return;
        }
        this.p.inflate();
        this.J = view.findViewById(t.e(context, "tt_video_ad_cover_center_layout_draw"));
        this.K = (TextView) view.findViewById(t.e(context, "tt_video_ad_button_draw"));
        this.L = (TextView) view.findViewById(t.e(context, "tt_video_ad_replay"));
    }

    private int e(int i2) {
        if (this.s <= 0 || this.t <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.z.getResources().getDimensionPixelSize(t.h(this.z, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.z.getResources().getDimensionPixelSize(t.h(this.z, "tt_video_container_minheight"));
        int i3 = (int) (this.t * ((i2 * 1.0f) / this.s));
        return i3 > dimensionPixelSize ? dimensionPixelSize : i3 < dimensionPixelSize2 ? dimensionPixelSize2 : i3;
    }

    private void f(int i2) {
        ac.a(this.f1846j, i2);
        ac.a(this.J, i2);
    }

    private boolean y() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.y;
        return hVar != null && hVar.u() == null && this.y.e() == 1 && (this.y.N() == 5 || this.y.N() == 15);
    }

    private void z() {
        if (this.z == null || this.a == null) {
            return;
        }
        View view = new View(this.z) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.3
            private void a() {
            }

            private void b() {
            }

            @Override // android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                b();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                a();
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                b();
            }
        };
        View view2 = this.a;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public void a(long j2) {
    }

    public void a(long j2, long j3) {
    }

    public void a(Message message) {
    }

    public void a(View view, boolean z) {
    }

    public void a(@Nullable ViewGroup viewGroup) {
    }

    public void a(String str) {
    }

    public void a(boolean z) {
    }

    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void b(@Nullable ViewGroup viewGroup) {
    }

    public void b(boolean z) {
    }

    public boolean b(int i2) {
        return false;
    }

    public void c() {
    }

    public void c(boolean z) {
        this.C = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.a.a aVar = this.F;
            if (aVar != null) {
                aVar.a(true);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar2 = this.G;
            if (aVar2 != null) {
                aVar2.a(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar3 = this.F;
        if (aVar3 != null) {
            aVar3.a(false);
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar4 = this.G;
        if (aVar4 != null) {
            aVar4.a(false);
        }
    }

    public void d(int i2) {
        ac.a(this.a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.b;
        if (bVar != null) {
            bVar.setVisibility(i2);
        }
    }

    public void g() {
        this.o.setProgress(0);
        this.o.setSecondaryProgress(0);
        c(8);
        if (x()) {
            this.b.setVisibility(8);
        }
        ImageView imageView = this.f1842f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        c(8);
        ac.a(this.f1844h, 8);
        ac.a((View) this.f1845i, 8);
        ac.a(this.f1846j, 8);
        ac.a((View) this.f1847k, 8);
        ac.a((View) this.f1848l, 8);
        ac.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.A;
        if (eVar != null) {
            eVar.a(true);
        }
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return this.u;
    }

    public void j() {
        a(true, false);
    }

    public boolean k() {
        return this.v;
    }

    public void l() {
    }

    public boolean m() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.A;
        return eVar != null && eVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        String str;
        int i2;
        com.bytedance.sdk.openadsdk.core.a.a aVar;
        String str2 = this.C ? "embeded_ad" : "embeded_ad_landingpage";
        if (ab.a(this.y)) {
            str = this.C ? "draw_ad" : "draw_ad_landingpage";
            i2 = 6;
        } else if (ab.c(this.y)) {
            str = "rewarded_video";
            i2 = 7;
        } else if (ab.d(this.y)) {
            str = "fullscreen_interstitial_ad";
            i2 = 5;
        } else {
            str = str2;
            i2 = 1;
        }
        if (this.y.x() == 4) {
            this.D = d.a.a.a.a.a.c.a(this.z, this.y, str);
        }
        z();
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i2);
        this.F = aVar2;
        aVar2.b(true);
        if (this.C) {
            this.F.a(true);
        } else {
            this.F.a(false);
            this.F.c(true);
        }
        this.F.a(this.E);
        this.F.d(true);
        d.a.a.a.a.a.b bVar = this.D;
        if (bVar != null && (aVar = this.F) != null) {
            aVar.a(bVar);
        }
        if (y()) {
            com.bytedance.sdk.openadsdk.core.a.a aVar3 = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i2) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.1
                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean b() {
                    com.bytedance.sdk.openadsdk.core.widget.e eVar = h.this.A;
                    boolean a = eVar != null ? eVar.a() : false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("isVisible=");
                    sb.append(a);
                    sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                    sb.append(h.this.c.getVisibility() == 0);
                    com.bytedance.sdk.openadsdk.utils.o.c("ClickCreativeListener", sb.toString());
                    return a || h.this.c.getVisibility() == 0;
                }

                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean c() {
                    View view;
                    RoundImageView roundImageView;
                    TextView textView;
                    View view2 = h.this.f1844h;
                    return (view2 != null && view2.getVisibility() == 0) || ((view = h.this.f1846j) != null && view.getVisibility() == 0) || (((roundImageView = h.this.f1847k) != null && roundImageView.getVisibility() == 0) || ((textView = h.this.f1848l) != null && textView.getVisibility() == 0));
                }
            };
            this.G = aVar3;
            aVar3.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.2
                @Override // com.bytedance.sdk.openadsdk.core.a.b.a
                public void a(View view, int i3) {
                    if (h.this.M != null) {
                        h.this.M.a(view, i3);
                    }
                }
            });
            this.G.b(true);
            if (this.C) {
                this.G.a(true);
            } else {
                this.G.a(false);
            }
            this.G.a(this.E);
            this.G.d(true);
            d.a.a.a.a.a.b bVar2 = this.D;
            if (bVar2 != null) {
                this.G.a(bVar2);
            }
            View view = this.a;
            if (view != null) {
                view.setOnClickListener(this.G);
                this.a.setOnTouchListener(this.G);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.renderview.b o() {
        return this.b;
    }

    void p() {
        if (this.B == null || this.A != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.widget.e eVar = new com.bytedance.sdk.openadsdk.core.widget.e();
        this.A = eVar;
        eVar.a(this.z, this.a);
        this.A.a(this.B, this);
        com.bytedance.sdk.openadsdk.utils.o.b("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.A;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        if (this.B == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("NewLiveViewLayout", "callback is null");
            return false;
        }
        return true;
    }

    public View s() {
        return this.a;
    }

    public void t() {
        ac.g(this.f1840d);
        ac.g(this.f1841e);
        if (this.c.getVisibility() == 0) {
            ac.a((View) this.c, 8);
        }
    }

    @RequiresApi(api = 14)
    @TargetApi(14)
    public void u() {
        ac.a(this.a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.b;
        if (bVar != null) {
            View view = bVar.getView();
            if (view instanceof TextureView) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    viewGroup.removeView(view);
                    viewGroup.addView(view, indexOfChild);
                }
            }
            ac.a(view, 8);
            ac.a(view, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        ac.a(this.f1844h, 8);
        ac.a((View) this.f1845i, 8);
        ac.a(this.f1846j, 8);
        ac.a((View) this.f1847k, 8);
        ac.a((View) this.f1848l, 8);
        ac.a((View) this.m, 8);
        ac.a((View) this.n, 8);
    }

    public void w() {
        ac.f(this.f1840d);
        ac.f(this.f1841e);
        ImageView imageView = this.f1842f;
        if (imageView != null) {
            ac.f(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return !this.x.contains(b.a.alwayShowMediaView) || this.u;
    }

    public void a(NativeVideoTsView.b bVar) {
        this.M = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v36, types: [com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView] */
    public void a(Context context, View view) {
        SSRenderSurfaceView sSRenderSurfaceView;
        long currentTimeMillis = System.currentTimeMillis();
        String a = ab.a(context);
        if (a == null) {
            a = "0";
        }
        int intValue = Integer.valueOf(a).intValue();
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 != 20 || intValue >= 1572864;
        if (!A() && z && com.bytedance.sdk.openadsdk.core.h.b().p() && i2 >= 14) {
            ?? sSRenderTextureView = new SSRenderTextureView(this.z);
            com.bytedance.sdk.openadsdk.utils.o.b("NewLiveViewLayout", "use TextureView......");
            sSRenderSurfaceView = sSRenderTextureView;
        } else {
            SSRenderSurfaceView sSRenderSurfaceView2 = new SSRenderSurfaceView(this.z);
            com.bytedance.sdk.openadsdk.utils.o.b("NewLiveViewLayout", "use SurfaceView......");
            sSRenderSurfaceView = sSRenderSurfaceView2;
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderSurfaceView, 0, layoutParams);
        }
        ac.a((View) sSRenderSurfaceView, 8);
        this.b = sSRenderSurfaceView;
        this.c = (ImageView) view.findViewById(t.e(context, "tt_video_play"));
        this.o = (ProgressBar) view.findViewById(t.e(context, "tt_video_progress"));
        this.f1840d = view.findViewById(t.e(context, "tt_video_loading_retry_layout"));
        this.f1841e = view.findViewById(t.e(context, "tt_video_loading_progress"));
        this.f1842f = (ImageView) view.findViewById(t.e(context, "tt_video_loading_cover_image"));
        this.f1843g = (ViewStub) view.findViewById(t.e(context, "tt_video_ad_cover"));
        this.p = (ViewStub) view.findViewById(t.e(context, "tt_video_draw_layout_viewStub"));
        com.bytedance.sdk.openadsdk.utils.o.b("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void f() {
        ac.f(this.f1840d);
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.d.h hVar;
        ac.g(this.f1840d);
        ac.g(this.f1841e);
        if (this.f1842f != null && (hVar = this.y) != null && hVar.v() != null && this.y.v().g() != null) {
            ac.g(this.f1842f);
            com.bytedance.sdk.openadsdk.g.d.a(this.z).a(this.y.v().g(), this.f1842f);
        }
        if (this.c.getVisibility() == 0) {
            ac.a((View) this.c, 8);
        }
    }

    public void e() {
        a(false, this.u);
        v();
    }

    public void b(boolean z, boolean z2) {
        ImageView imageView = this.c;
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(t.d(this.z, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageResource(t.d(this.z, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void b(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.width = i2;
        }
        if (i3 == -1 || i3 == -2 || i3 > 0) {
            layoutParams.height = i3;
        }
        this.a.setLayoutParams(layoutParams);
    }

    public void c(int i2, int i3) {
        this.s = i2;
        this.t = i3;
    }

    public void c(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.a.getParent() != null) {
            ((ViewGroup) this.a.getParent()).removeView(this.a);
        }
        viewGroup.addView(this.a);
        c(0);
    }

    public void d(boolean z) {
        this.I = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.b.getHolder()) {
            return;
        }
        this.v = false;
        if (r()) {
            this.B.b(this, surfaceHolder);
        }
    }

    public void c(int i2) {
        this.w = i2;
        ac.a(this.a, i2);
    }

    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, com.bytedance.sdk.openadsdk.core.d.h hVar, c cVar) {
        this(context, view, z, enumSet, hVar, cVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, Context context) {
        ViewStub viewStub;
        if (view == null || context == null || (viewStub = this.f1843g) == null || viewStub.getParent() == null || this.f1844h != null) {
            return;
        }
        this.f1844h = this.f1843g.inflate();
        this.f1845i = (ImageView) view.findViewById(t.e(context, "tt_video_ad_finish_cover_image"));
        this.f1846j = view.findViewById(t.e(context, "tt_video_ad_cover_center_layout"));
        this.f1847k = (RoundImageView) view.findViewById(t.e(context, "tt_video_ad_logo_image"));
        this.f1848l = (TextView) view.findViewById(t.e(context, "tt_video_btn_ad_image_tv"));
        this.m = (TextView) view.findViewById(t.e(context, "tt_video_ad_name"));
        this.n = (TextView) view.findViewById(t.e(context, "tt_video_ad_button"));
    }

    public boolean a(int i2, n nVar) {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.A;
        return eVar == null || eVar.a(i2, nVar);
    }

    public void a(a aVar) {
        if (aVar instanceof d) {
            this.B = (d) aVar;
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b.a(this);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.4
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                if (h.this.r()) {
                    TextView textView = h.this.n;
                    if (textView == null || textView.getVisibility() != 0) {
                        h hVar = h.this;
                        hVar.B.a(hVar, view);
                    }
                }
            }
        });
    }

    public void a(int i2, int i3) {
        if (i2 == -1) {
            i2 = ac.c(this.z);
        }
        if (i2 <= 0) {
            return;
        }
        this.q = i2;
        if (!i() && !h() && !this.x.contains(b.a.fixedSize)) {
            this.r = e(i2);
        } else {
            this.r = i3;
        }
        b(this.q, this.r);
    }

    public void a(int i2) {
        com.bytedance.sdk.openadsdk.utils.o.c("Progress", "setSeekProgress-percent=" + i2);
        ac.a((View) this.o, 0);
        this.o.setProgress(i2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar, WeakReference<Context> weakReference, boolean z) {
        com.bytedance.sdk.openadsdk.core.d.h hVar2;
        String H;
        String a;
        com.bytedance.sdk.openadsdk.core.d.h hVar3;
        com.bytedance.sdk.openadsdk.core.d.h hVar4;
        if (hVar == null) {
            return;
        }
        a(false, this.u);
        a(this.a, o.a());
        View view = this.f1844h;
        if (view != null) {
            ac.a(view, 0);
        }
        ImageView imageView = this.f1845i;
        if (imageView != null) {
            ac.a((View) imageView, 0);
        }
        if (ab.a(this.y)) {
            b(this.a, o.a());
            ac.a(this.f1846j, 8);
            ac.a((View) this.f1845i, 0);
            ac.a(this.J, 0);
            ac.a((View) this.K, 0);
            ac.a((View) this.L, 0);
            if (this.L != null && q.c(o.a()) == 0) {
                ac.a((View) this.L, 8);
            }
            View view2 = this.f1844h;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.5
                    @Override // android.view.View.OnClickListener
                    @Instrumented
                    public void onClick(View view3) {
                        VdsAgent.onClick(this, view3);
                        c cVar = h.this.E;
                        if (cVar != null) {
                            ((a) cVar).g();
                            TTDrawFeedAd.DrawVideoListener drawVideoListener = h.this.H;
                            if (drawVideoListener != null) {
                                drawVideoListener.onClickRetry();
                            }
                        }
                    }
                });
            }
            if (this.f1845i != null && (hVar4 = this.y) != null && hVar4.v() != null && this.y.v().g() != null) {
                com.bytedance.sdk.openadsdk.core.video.f.b.a((long) this.y.v().e(), this.y.v().h(), new b.InterfaceC0055b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.6
                    @Override // com.bytedance.sdk.openadsdk.core.video.f.b.InterfaceC0055b
                    public void a(Bitmap bitmap) {
                        if (bitmap != null) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h.this.f1845i.getLayoutParams();
                            if (bitmap.getWidth() > bitmap.getHeight()) {
                                layoutParams.width = ac.c(o.a());
                                layoutParams.height = (bitmap.getHeight() * ac.c(o.a())) / bitmap.getWidth();
                                layoutParams.addRule(13);
                                h.this.f1845i.setLayoutParams(layoutParams);
                            }
                            h.this.f1845i.setImageBitmap(bitmap);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.g.d.a(h.this.z).a(h.this.y.v().g(), h.this.f1845i);
                    }
                });
            }
        } else {
            ac.a(this.f1846j, 0);
            if (this.f1845i != null && (hVar2 = this.y) != null && hVar2.v() != null && this.y.v().g() != null) {
                com.bytedance.sdk.openadsdk.g.d.a(this.z).a(this.y.v().g(), this.f1845i);
            }
        }
        if (!TextUtils.isEmpty(hVar.w())) {
            H = hVar.w();
        } else if (!TextUtils.isEmpty(hVar.G())) {
            H = hVar.G();
        } else {
            H = !TextUtils.isEmpty(hVar.H()) ? hVar.H() : "";
        }
        if (this.f1847k != null && (hVar3 = this.y) != null && hVar3.y() != null && this.y.y().a() != null) {
            ac.a((View) this.f1847k, 0);
            ac.a((View) this.f1848l, 4);
            com.bytedance.sdk.openadsdk.g.d.a(this.z).a(this.y.y().a(), this.f1847k);
            if (y()) {
                this.f1847k.setOnClickListener(this.G);
                this.f1847k.setOnTouchListener(this.G);
            } else {
                this.f1847k.setOnClickListener(this.F);
                this.f1847k.setOnTouchListener(this.F);
            }
        } else if (!TextUtils.isEmpty(H)) {
            ac.a((View) this.f1847k, 4);
            ac.a((View) this.f1848l, 0);
            TextView textView = this.f1848l;
            if (textView != null) {
                textView.setText(H.substring(0, 1));
                if (y()) {
                    this.f1848l.setOnClickListener(this.G);
                    this.f1848l.setOnTouchListener(this.G);
                } else {
                    this.f1848l.setOnClickListener(this.F);
                    this.f1848l.setOnTouchListener(this.F);
                }
            }
        }
        if (this.m != null && !TextUtils.isEmpty(H)) {
            this.m.setText(H);
        }
        ac.a((View) this.m, 0);
        ac.a((View) this.n, 0);
        int x = hVar.x();
        if (x == 2 || x == 3) {
            a = t.a(this.z, "tt_video_mobile_go_detail");
        } else if (x == 4) {
            a = t.a(this.z, "tt_video_download_apk");
        } else if (x != 5) {
            a = t.a(this.z, "tt_video_mobile_go_detail");
        } else {
            a = t.a(this.z, "tt_video_dial_phone");
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setText(a);
            this.n.setOnClickListener(this.F);
            this.n.setOnTouchListener(this.F);
        }
        TextView textView3 = this.K;
        if (textView3 != null) {
            textView3.setText(a);
            this.K.setOnClickListener(this.F);
            this.K.setOnTouchListener(this.F);
        }
        if (this.I) {
            return;
        }
        f(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.b.getHolder()) {
            return;
        }
        this.v = true;
        if (r()) {
            this.B.a(this, surfaceHolder);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (surfaceHolder == this.b.getHolder() && r()) {
            this.B.a(this, surfaceHolder, i2, i3, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.v = true;
        if (r()) {
            this.B.a(this, surfaceTexture);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public boolean a(SurfaceTexture surfaceTexture) {
        this.v = false;
        if (r()) {
            this.B.b(this, surfaceTexture);
            return true;
        }
        return true;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        ac.a((View) this.o, 0);
        ac.a((View) this.c, (!z || this.f1840d.getVisibility() == 0) ? 8 : 8);
    }

    public void a(boolean z, boolean z2) {
        ac.a((View) this.o, z ? 0 : 8);
        ac.a((View) this.c, 8);
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.H = drawVideoListener;
        com.bytedance.sdk.openadsdk.core.a.a aVar = this.F;
        if (aVar != null) {
            aVar.a(drawVideoListener);
        }
    }
}
