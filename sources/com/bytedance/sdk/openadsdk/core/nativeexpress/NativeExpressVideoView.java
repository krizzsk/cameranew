package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
/* loaded from: classes.dex */
public class NativeExpressVideoView extends NativeExpressView implements g, c.b, c.InterfaceC0056c {
    int a;
    boolean b;
    boolean c;

    /* renamed from: d  reason: collision with root package name */
    int f1697d;
    private ExpressVideoView t;
    private com.bytedance.sdk.openadsdk.multipro.b.a u;
    private long v;
    private long w;

    public NativeExpressVideoView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot, String str) {
        super(context, hVar, adSlot, str);
        this.a = 1;
        this.b = false;
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (jVar == null) {
            return;
        }
        double d2 = jVar.d();
        double e2 = jVar.e();
        double f2 = jVar.f();
        double g2 = jVar.g();
        int a = (int) ac.a(this.f1700f, (float) d2);
        int a2 = (int) ac.a(this.f1700f, (float) e2);
        int a3 = (int) ac.a(this.f1700f, (float) f2);
        int a4 = (int) ac.a(this.f1700f, (float) g2);
        o.b("ExpressView", "videoWidth:" + f2);
        o.b("ExpressView", "videoHeight:" + g2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(a3, a4);
        }
        layoutParams.width = a3;
        layoutParams.height = a4;
        layoutParams.topMargin = a2;
        layoutParams.leftMargin = a;
        this.m.setLayoutParams(layoutParams);
        this.m.removeAllViews();
        this.m.addView(this.t);
        this.t.a(0L, true, false);
        setShowAdInteractionView(false);
    }

    private void n() {
        try {
            this.u = new com.bytedance.sdk.openadsdk.multipro.b.a();
            ExpressVideoView expressVideoView = new ExpressVideoView(this.f1700f, this.f1705k, this.f1703i);
            this.t = expressVideoView;
            expressVideoView.setShouldCheckNetChange(false);
            this.t.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                    NativeExpressVideoView.this.u.a = z;
                    NativeExpressVideoView.this.u.f2094e = j2;
                    NativeExpressVideoView.this.u.f2095f = j3;
                    NativeExpressVideoView.this.u.f2096g = j4;
                    NativeExpressVideoView.this.u.f2093d = z2;
                }
            });
            this.t.setVideoAdLoadListener(this);
            this.t.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.f1703i)) {
                this.t.setIsAutoPlay(this.b ? this.f1704j.isAutoPlay() : this.c);
            } else if ("splash_ad".equals(this.f1703i)) {
                this.t.setIsAutoPlay(true);
            } else {
                this.t.setIsAutoPlay(this.c);
            }
            if ("splash_ad".equals(this.f1703i)) {
                this.t.setIsQuiet(true);
            } else {
                this.t.setIsQuiet(com.bytedance.sdk.openadsdk.core.o.h().a(this.f1697d));
            }
            this.t.e();
        } catch (Exception unused) {
            this.t = null;
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void K() {
        o.b("NativeExpressVideoView", "onSkipVideo");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long L() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int M() {
        if (this.t.getNativeVideoController().w()) {
            return 1;
        }
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void N() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void b() {
        super.b();
        this.f1702h.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d() {
        o.b("NativeExpressVideoView", "onVideoAdPaused");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f1706l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdPaused();
        }
        this.n = true;
        this.a = 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d_() {
        o.b("NativeExpressVideoView", "onVideoComplete");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f1706l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdComplete();
        }
        this.a = 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        o.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView == null || expressVideoView.getNativeVideoController() == null) {
            return;
        }
        this.t.getNativeVideoController().c(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0056c
    public void f() {
        o.b("NativeExpressVideoView", "onVideoLoad");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f1706l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoLoad();
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        return this.u;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    private void b(final com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (jVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(jVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.c(jVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void a() {
        this.m = new FrameLayout(this.f1700f);
        int d2 = ab.d(this.f1705k.M());
        this.f1697d = d2;
        a(d2);
        n();
        addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e() {
        o.b("NativeExpressVideoView", "onVideoAdStartPlay");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f1706l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdStartPlay();
        }
        this.a = 2;
    }

    void a(int i2) {
        int c = com.bytedance.sdk.openadsdk.core.o.h().c(i2);
        if (3 == c) {
            this.b = false;
            this.c = false;
        } else if (1 == c && q.d(this.f1700f)) {
            this.b = false;
            this.c = true;
        } else if (2 != c) {
            if (4 == c) {
                this.b = true;
            }
        } else if (q.e(this.f1700f) || q.d(this.f1700f)) {
            this.b = false;
            this.c = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (jVar != null && jVar.a()) {
            b(jVar);
        }
        super.a(jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void c(int i2) {
        o.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i2);
        if (i2 == 1) {
            this.t.a(0L, true, false);
        } else if (i2 == 2 || i2 == 3) {
            this.t.setCanInterruptVideoPlay(true);
            this.t.performClick();
        } else if (i2 == 4) {
            this.t.getNativeVideoController().l();
        } else if (i2 != 5) {
        } else {
            this.t.a(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        if (i2 == -1 || fVar == null) {
            return;
        }
        if (i2 == 4 && this.f1703i == "draw_ad") {
            ExpressVideoView expressVideoView = this.t;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        super.a(i2, fVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j2, long j3) {
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f1706l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onProgressUpdate(j2, j3);
        }
        int i2 = this.a;
        if (i2 != 5 && i2 != 3 && j2 > this.v) {
            this.a = 2;
        }
        this.v = j2;
        this.w = j3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void c() {
        o.b("NativeExpressVideoView", "onVideoAdContinuePlay");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f1706l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdContinuePlay();
        }
        this.n = false;
        this.a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0056c
    public void a(int i2, int i3) {
        o.b("NativeExpressVideoView", "onVideoError,errorCode:" + i2 + ",extraCode:" + i3);
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f1706l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoError(i2, i3);
        }
        this.v = this.w;
        this.a = 4;
    }
}
