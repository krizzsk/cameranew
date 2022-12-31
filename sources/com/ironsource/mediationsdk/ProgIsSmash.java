package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class ProgIsSmash extends c0 implements com.ironsource.mediationsdk.n0.n {

    /* renamed from: g  reason: collision with root package name */
    private SMASH_STATE f5471g;

    /* renamed from: h  reason: collision with root package name */
    private a0 f5472h;

    /* renamed from: i  reason: collision with root package name */
    private Timer f5473i;

    /* renamed from: j  reason: collision with root package name */
    private int f5474j;

    /* renamed from: k  reason: collision with root package name */
    private String f5475k;

    /* renamed from: l  reason: collision with root package name */
    private String f5476l;
    private long m;
    private final Object n;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        INIT_SUCCESS,
        LOAD_IN_PROGRESS,
        LOADED,
        LOAD_FAILED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ProgIsSmash progIsSmash = ProgIsSmash.this;
            progIsSmash.Z("timed out state=" + ProgIsSmash.this.f5471g.name() + " isBidder=" + ProgIsSmash.this.L());
            if (ProgIsSmash.this.f5471g != SMASH_STATE.INIT_IN_PROGRESS || !ProgIsSmash.this.L()) {
                ProgIsSmash.this.d0(SMASH_STATE.LOAD_FAILED);
                ProgIsSmash.this.f5472h.u(com.ironsource.mediationsdk.utils.f.e("timed out"), ProgIsSmash.this, new Date().getTime() - ProgIsSmash.this.m);
                return;
            }
            ProgIsSmash.this.d0(SMASH_STATE.NO_INIT);
        }
    }

    public ProgIsSmash(String str, String str2, com.ironsource.mediationsdk.model.l lVar, a0 a0Var, int i2, b bVar) {
        super(new com.ironsource.mediationsdk.model.a(lVar, lVar.h()), bVar);
        this.n = new Object();
        this.f5471g = SMASH_STATE.NO_INIT;
        this.f5475k = str;
        this.f5476l = str2;
        this.f5472h = a0Var;
        this.f5473i = null;
        this.f5474j = i2;
        this.a.addInterstitialListener(this);
    }

    private void Y(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "ProgIsSmash " + x() + " : " + str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsSmash " + x() + " : " + str, 0);
    }

    private void a0(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsSmash " + x() + " : " + str, 3);
    }

    private void c0() {
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
            Z("setCustomParams() " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(SMASH_STATE smash_state) {
        Z("current state=" + this.f5471g + ", new state=" + smash_state);
        this.f5471g = smash_state;
    }

    private void f0() {
        synchronized (this.n) {
            Z("start timer");
            g0();
            Timer timer = new Timer();
            this.f5473i = timer;
            timer.schedule(new a(), this.f5474j * 1000);
        }
    }

    private void g0() {
        synchronized (this.n) {
            Timer timer = this.f5473i;
            if (timer != null) {
                timer.cancel();
                this.f5473i = null;
            }
        }
    }

    public Map<String, Object> T() {
        try {
            if (L()) {
                return this.a.getInterstitialBiddingData(this.f5538d);
            }
            return null;
        } catch (Throwable th) {
            a0("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            return null;
        }
    }

    public void U() {
        Z("initForBidding()");
        d0(SMASH_STATE.INIT_IN_PROGRESS);
        c0();
        try {
            this.a.initInterstitialForBidding(this.f5475k, this.f5476l, this.f5538d, this);
        } catch (Throwable th) {
            a0(x() + "loadInterstitial exception : " + th.getLocalizedMessage());
            th.printStackTrace();
            w(new com.ironsource.mediationsdk.logger.b(1041, th.getLocalizedMessage()));
        }
    }

    public boolean V() {
        SMASH_STATE smash_state = this.f5471g;
        return smash_state == SMASH_STATE.INIT_IN_PROGRESS || smash_state == SMASH_STATE.LOAD_IN_PROGRESS;
    }

    public boolean W() {
        try {
            return this.a.isInterstitialReady(this.f5538d);
        } catch (Throwable th) {
            a0("isReadyToShow exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            return false;
        }
    }

    public void X(String str) {
        try {
            this.m = new Date().getTime();
            Z("loadInterstitial");
            N(false);
            if (L()) {
                f0();
                d0(SMASH_STATE.LOAD_IN_PROGRESS);
                this.a.loadInterstitialForBidding(this.f5538d, this, str);
            } else if (this.f5471g == SMASH_STATE.NO_INIT) {
                f0();
                d0(SMASH_STATE.INIT_IN_PROGRESS);
                c0();
                this.a.initInterstitial(this.f5475k, this.f5476l, this.f5538d, this);
            } else {
                f0();
                d0(SMASH_STATE.LOAD_IN_PROGRESS);
                this.a.loadInterstitial(this.f5538d, this);
            }
        } catch (Throwable th) {
            a0("loadInterstitial exception: " + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        Y("onInterstitialAdLoadFailed error=" + bVar.b() + " state=" + this.f5471g.name());
        g0();
        if (this.f5471g != SMASH_STATE.LOAD_IN_PROGRESS) {
            return;
        }
        d0(SMASH_STATE.LOAD_FAILED);
        this.f5472h.u(bVar, this, new Date().getTime() - this.m);
    }

    public void b0() {
        this.a.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, "interstitial");
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void c() {
        Y("onInterstitialAdReady state=" + this.f5471g.name());
        g0();
        if (this.f5471g != SMASH_STATE.LOAD_IN_PROGRESS) {
            return;
        }
        d0(SMASH_STATE.LOADED);
        this.f5472h.p(this, new Date().getTime() - this.m);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        Y("onInterstitialAdShowFailed error=" + bVar.b());
        this.f5472h.i(bVar, this);
    }

    public void e0() {
        try {
            this.a.showInterstitial(this.f5538d, this);
        } catch (Throwable th) {
            a0(x() + "showInterstitial exception : " + th.getLocalizedMessage());
            th.printStackTrace();
            this.f5472h.i(new com.ironsource.mediationsdk.logger.b(1039, th.getLocalizedMessage()), this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void f() {
        Y("onInterstitialAdClosed");
        this.f5472h.F(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void g() {
        Y("onInterstitialAdClicked");
        this.f5472h.G(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void h() {
        Y("onInterstitialAdOpened");
        this.f5472h.D(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void j() {
        Y("onInterstitialAdShowSucceeded");
        this.f5472h.N(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void onInterstitialInitSuccess() {
        Y("onInterstitialInitSuccess state=" + this.f5471g.name());
        if (this.f5471g != SMASH_STATE.INIT_IN_PROGRESS) {
            return;
        }
        g0();
        if (L()) {
            d0(SMASH_STATE.INIT_SUCCESS);
        } else {
            d0(SMASH_STATE.LOAD_IN_PROGRESS);
            f0();
            try {
                this.a.loadInterstitial(this.f5538d, this);
            } catch (Throwable th) {
                a0("onInterstitialInitSuccess exception: " + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
        this.f5472h.d(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void p() {
        Y("onInterstitialAdVisible");
        this.f5472h.y(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void w(com.ironsource.mediationsdk.logger.b bVar) {
        Y("onInterstitialInitFailed error" + bVar.b() + " state=" + this.f5471g.name());
        if (this.f5471g != SMASH_STATE.INIT_IN_PROGRESS) {
            return;
        }
        g0();
        d0(SMASH_STATE.NO_INIT);
        this.f5472h.K(bVar, this);
        if (L()) {
            return;
        }
        this.f5472h.u(bVar, this, new Date().getTime() - this.m);
    }
}
