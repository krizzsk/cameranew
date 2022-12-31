package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class BannerSmash implements com.ironsource.mediationsdk.n0.c {
    private b a;
    private Timer b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private com.ironsource.mediationsdk.model.l f5392d;

    /* renamed from: e  reason: collision with root package name */
    private BANNER_SMASH_STATE f5393e = BANNER_SMASH_STATE.NO_INIT;

    /* renamed from: f  reason: collision with root package name */
    private com.ironsource.mediationsdk.n0.b f5394f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5395g;

    /* renamed from: h  reason: collision with root package name */
    private IronSourceBannerLayout f5396h;

    /* renamed from: i  reason: collision with root package name */
    private int f5397i;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum BANNER_SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            if (BannerSmash.this.f5393e == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
                BannerSmash.this.w(BANNER_SMASH_STATE.NO_INIT);
                BannerSmash.this.p("init timed out");
                BannerSmash.this.f5394f.c(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_PATHMOTION_ARC, "Timed out"), BannerSmash.this, false);
            } else if (BannerSmash.this.f5393e == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
                BannerSmash.this.w(BANNER_SMASH_STATE.LOAD_FAILED);
                BannerSmash.this.p("load timed out");
                BannerSmash.this.f5394f.c(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_DRAW_PATH, "Timed out"), BannerSmash.this, false);
            } else if (BannerSmash.this.f5393e == BANNER_SMASH_STATE.LOADED) {
                BannerSmash.this.w(BANNER_SMASH_STATE.LOAD_FAILED);
                BannerSmash.this.p("reload timed out");
                BannerSmash.this.f5394f.g(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_POLAR_RELATIVETO, "Timed out"), BannerSmash.this, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BannerSmash(com.ironsource.mediationsdk.n0.b bVar, com.ironsource.mediationsdk.model.l lVar, b bVar2, long j2, int i2) {
        this.f5397i = i2;
        this.f5394f = bVar;
        this.a = bVar2;
        this.f5392d = lVar;
        this.c = j2;
        bVar2.addBannerListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
        i2.d(ironSourceTag, "BannerSmash " + h() + " " + str, 1);
    }

    private void s(String str, String str2) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, str + " Banner exception: " + h() + " | " + str2, 3);
    }

    private void u() {
        if (this.a == null) {
            return;
        }
        try {
            String w = IronSourceObject.getInstance().w();
            if (!TextUtils.isEmpty(w)) {
                this.a.setMediationSegment(w);
            }
            String c = com.ironsource.mediationsdk.k0.a.a().c();
            if (TextUtils.isEmpty(c)) {
                return;
            }
            this.a.setPluginData(c, com.ironsource.mediationsdk.k0.a.a().b());
        } catch (Exception e2) {
            p(":setCustomParams():" + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(BANNER_SMASH_STATE banner_smash_state) {
        this.f5393e = banner_smash_state;
        p("state=" + banner_smash_state.name());
    }

    private void x() {
        try {
            y();
            Timer timer = new Timer();
            this.b = timer;
            timer.schedule(new a(), this.c);
        } catch (Exception e2) {
            s("startLoadTimer", e2.getLocalizedMessage());
        }
    }

    private void y() {
        try {
            try {
                Timer timer = this.b;
                if (timer != null) {
                    timer.cancel();
                }
            } catch (Exception e2) {
                s("stopLoadTimer", e2.getLocalizedMessage());
            }
        } finally {
            this.b = null;
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void C() {
        com.ironsource.mediationsdk.n0.b bVar = this.f5394f;
        if (bVar != null) {
            bVar.h(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void b(com.ironsource.mediationsdk.logger.b bVar) {
        p("onBannerAdLoadFailed()");
        y();
        boolean z = bVar.a() == 606;
        BANNER_SMASH_STATE banner_smash_state = this.f5393e;
        if (banner_smash_state == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
            w(BANNER_SMASH_STATE.LOAD_FAILED);
            this.f5394f.c(bVar, this, z);
        } else if (banner_smash_state == BANNER_SMASH_STATE.LOADED) {
            this.f5394f.g(bVar, this, z);
        }
    }

    public String f() {
        if (!TextUtils.isEmpty(this.f5392d.a())) {
            return this.f5392d.a();
        }
        return h();
    }

    public b g() {
        return this.a;
    }

    public String h() {
        if (this.f5392d.t()) {
            return this.f5392d.m();
        }
        return this.f5392d.l();
    }

    public int i() {
        return this.f5397i;
    }

    public String j() {
        return this.f5392d.p();
    }

    public boolean k() {
        return this.f5395g;
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void l() {
        com.ironsource.mediationsdk.n0.b bVar = this.f5394f;
        if (bVar != null) {
            bVar.f(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void m() {
        com.ironsource.mediationsdk.n0.b bVar = this.f5394f;
        if (bVar != null) {
            bVar.e(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void n() {
        com.ironsource.mediationsdk.n0.b bVar = this.f5394f;
        if (bVar != null) {
            bVar.d(this);
        }
    }

    public void o(IronSourceBannerLayout ironSourceBannerLayout, String str, String str2) {
        p("loadBanner");
        this.f5395g = false;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.h()) {
            if (this.a == null) {
                p("loadBanner - mAdapter is null");
                this.f5394f.c(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, "adapter==null"), this, false);
                return;
            }
            this.f5396h = ironSourceBannerLayout;
            x();
            if (this.f5393e == BANNER_SMASH_STATE.NO_INIT) {
                w(BANNER_SMASH_STATE.INIT_IN_PROGRESS);
                u();
                this.a.initBanners(str, str2, this.f5392d.d(), this);
                return;
            }
            w(BANNER_SMASH_STATE.LOAD_IN_PROGRESS);
            this.a.loadBanner(ironSourceBannerLayout, this.f5392d.d(), this);
            return;
        }
        p("loadBanner - bannerLayout is null or destroyed");
        this.f5394f.c(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed"), this, false);
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void onBannerInitSuccess() {
        y();
        if (this.f5393e == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
            IronSourceBannerLayout ironSourceBannerLayout = this.f5396h;
            if (ironSourceBannerLayout != null && !ironSourceBannerLayout.h()) {
                x();
                w(BANNER_SMASH_STATE.LOAD_IN_PROGRESS);
                this.a.loadBanner(this.f5396h, this.f5392d.d(), this);
                return;
            }
            this.f5394f.c(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, this.f5396h == null ? "banner is null" : "banner is destroyed"), this, false);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void q(com.ironsource.mediationsdk.logger.b bVar) {
        y();
        if (this.f5393e == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
            this.f5394f.c(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, "Banner init failed"), this, false);
            w(BANNER_SMASH_STATE.NO_INIT);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void r(View view, FrameLayout.LayoutParams layoutParams) {
        p("onBannerAdLoaded()");
        y();
        BANNER_SMASH_STATE banner_smash_state = this.f5393e;
        if (banner_smash_state == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
            w(BANNER_SMASH_STATE.LOADED);
            this.f5394f.a(this, view, layoutParams);
        } else if (banner_smash_state == BANNER_SMASH_STATE.LOADED) {
            this.f5394f.b(this, view, layoutParams, this.a.shouldBindBannerViewOnReload());
        }
    }

    public void t() {
        p("reloadBanner()");
        IronSourceBannerLayout ironSourceBannerLayout = this.f5396h;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.h()) {
            x();
            w(BANNER_SMASH_STATE.LOADED);
            this.a.reloadBanner(this.f5396h, this.f5392d.d(), this);
            return;
        }
        this.f5394f.c(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, this.f5396h == null ? "banner is null" : "banner is destroyed"), this, false);
    }

    public void v(boolean z) {
        this.f5395g = z;
    }
}
