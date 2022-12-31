package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
/* compiled from: InterstitialSmash.java */
/* loaded from: classes2.dex */
public class u extends AbstractSmash implements com.ironsource.mediationsdk.n0.n {
    private JSONObject s;
    private com.ironsource.mediationsdk.n0.m t;
    private long u;
    private int v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InterstitialSmash.java */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            u uVar = u.this;
            if (uVar.a != AbstractSmash.MEDIATION_STATE.INIT_PENDING || uVar.t == null) {
                return;
            }
            u.this.P(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            u.this.t.v(com.ironsource.mediationsdk.utils.f.c("Timeout", "Interstitial"), u.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InterstitialSmash.java */
    /* loaded from: classes2.dex */
    public class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            u uVar = u.this;
            if (uVar.a != AbstractSmash.MEDIATION_STATE.LOAD_PENDING || uVar.t == null) {
                return;
            }
            u.this.P(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
            u.this.t.q(com.ironsource.mediationsdk.utils.f.e("Timeout"), u.this, new Date().getTime() - u.this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(com.ironsource.mediationsdk.model.l lVar, int i2) {
        super(lVar);
        JSONObject h2 = lVar.h();
        this.s = h2;
        this.m = h2.optInt("maxAdsPerIteration", 99);
        this.n = this.s.optInt("maxAdsPerSession", 99);
        this.o = this.s.optInt("maxAdsPerDay", 99);
        this.f5365f = lVar.t();
        this.f5366g = lVar.p();
        this.v = i2;
    }

    public void W(String str, String str2) {
        b0();
        com.ironsource.mediationsdk.b bVar = this.b;
        if (bVar != null) {
            bVar.addInterstitialListener(this);
            com.ironsource.mediationsdk.logger.c cVar = this.r;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            cVar.d(ironSourceTag, r() + ":initInterstitial()", 1);
            this.b.initInterstitial(str, str2, this.s, this);
        }
    }

    public boolean X() {
        if (this.b != null) {
            com.ironsource.mediationsdk.logger.c cVar = this.r;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            cVar.d(ironSourceTag, r() + ":isInterstitialReady()", 1);
            return this.b.isInterstitialReady(this.s);
        }
        return false;
    }

    public void Y() {
        c0();
        if (this.b != null) {
            com.ironsource.mediationsdk.logger.c cVar = this.r;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            cVar.d(ironSourceTag, r() + ":loadInterstitial()", 1);
            this.u = new Date().getTime();
            this.b.loadInterstitial(this.s, this);
        }
    }

    public void Z(com.ironsource.mediationsdk.n0.m mVar) {
        this.t = mVar;
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        T();
        if (this.a != AbstractSmash.MEDIATION_STATE.LOAD_PENDING || this.t == null) {
            return;
        }
        this.t.q(bVar, this, new Date().getTime() - this.u);
    }

    public void a0() {
        if (this.b != null) {
            com.ironsource.mediationsdk.logger.c cVar = this.r;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            cVar.d(ironSourceTag, r() + ":showInterstitial()", 1);
            M();
            this.b.showInterstitial(this.s, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public void b() {
        this.f5369j = 0;
        P(AbstractSmash.MEDIATION_STATE.INITIATED);
    }

    void b0() {
        try {
            S();
            Timer timer = new Timer();
            this.f5370k = timer;
            timer.schedule(new a(), this.v * 1000);
        } catch (Exception e2) {
            L("startInitTimer", e2.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void c() {
        T();
        if (this.a != AbstractSmash.MEDIATION_STATE.LOAD_PENDING || this.t == null) {
            return;
        }
        this.t.x(this, new Date().getTime() - this.u);
    }

    void c0() {
        try {
            T();
            Timer timer = new Timer();
            this.f5371l = timer;
            timer.schedule(new b(), this.v * 1000);
        } catch (Exception e2) {
            L("startLoadTimer", e2.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.n0.m mVar = this.t;
        if (mVar != null) {
            mVar.i(bVar, this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void f() {
        com.ironsource.mediationsdk.n0.m mVar = this.t;
        if (mVar != null) {
            mVar.s(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void g() {
        com.ironsource.mediationsdk.n0.m mVar = this.t;
        if (mVar != null) {
            mVar.g(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void h() {
        com.ironsource.mediationsdk.n0.m mVar = this.t;
        if (mVar != null) {
            mVar.w(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void j() {
        com.ironsource.mediationsdk.n0.m mVar = this.t;
        if (mVar != null) {
            mVar.e(this);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractSmash
    protected String n() {
        return "interstitial";
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void onInterstitialInitSuccess() {
        S();
        if (this.a == AbstractSmash.MEDIATION_STATE.INIT_PENDING) {
            P(AbstractSmash.MEDIATION_STATE.INITIATED);
            com.ironsource.mediationsdk.n0.m mVar = this.t;
            if (mVar != null) {
                mVar.b(this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void p() {
        com.ironsource.mediationsdk.n0.m mVar = this.t;
        if (mVar != null) {
            mVar.o(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void w(com.ironsource.mediationsdk.logger.b bVar) {
        S();
        if (this.a == AbstractSmash.MEDIATION_STATE.INIT_PENDING) {
            P(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            com.ironsource.mediationsdk.n0.m mVar = this.t;
            if (mVar != null) {
                mVar.v(bVar, this);
            }
        }
    }
}
