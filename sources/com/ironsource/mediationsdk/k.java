package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.DemandOnlySmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONObject;
/* compiled from: DemandOnlyIsSmash.java */
/* loaded from: classes2.dex */
public class k extends DemandOnlySmash implements com.ironsource.mediationsdk.n0.n {
    private com.ironsource.mediationsdk.n0.d m;
    private long n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DemandOnlyIsSmash.java */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            k kVar = k.this;
            kVar.N("load timed out state=" + k.this.r());
            if (k.this.l(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
                k.this.m.g(new com.ironsource.mediationsdk.logger.b(1052, "load timed out"), k.this, new Date().getTime() - k.this.n);
            }
        }
    }

    public k(String str, String str2, com.ironsource.mediationsdk.model.l lVar, com.ironsource.mediationsdk.n0.d dVar, int i2, b bVar) {
        super(new com.ironsource.mediationsdk.model.a(lVar, lVar.h()), bVar);
        this.m = dVar;
        this.f5402f = i2;
        this.a.initInterstitial(str, str2, this.c, this);
    }

    private void M(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "DemandOnlyInterstitialSmash " + this.b.e() + " : " + str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyInterstitialSmash " + this.b.e() + " : " + str, 0);
    }

    private void O() {
        N("start timer");
        G(new a());
    }

    public void L(String str, String str2, JSONObject jSONObject, List<String> list) {
        N("loadInterstitial state=" + r());
        DemandOnlySmash.SMASH_STATE smash_state = DemandOnlySmash.SMASH_STATE.NOT_LOADED;
        DemandOnlySmash.SMASH_STATE smash_state2 = DemandOnlySmash.SMASH_STATE.LOADED;
        DemandOnlySmash.SMASH_STATE smash_state3 = DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS;
        DemandOnlySmash.SMASH_STATE b = b(new DemandOnlySmash.SMASH_STATE[]{smash_state, smash_state2}, smash_state3);
        if (b != smash_state && b != smash_state2) {
            if (b == smash_state3) {
                this.m.g(new com.ironsource.mediationsdk.logger.b(1050, "load already in progress"), this, 0L);
                return;
            } else {
                this.m.g(new com.ironsource.mediationsdk.logger.b(1050, "cannot load because show is in progress"), this, 0L);
                return;
            }
        }
        this.n = new Date().getTime();
        O();
        if (B()) {
            this.f5403g = str2;
            this.f5404h = jSONObject;
            this.f5405i = list;
            this.a.loadInterstitialForBidding(this.c, this, str);
            return;
        }
        this.a.loadInterstitial(this.c, this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        M("onInterstitialAdLoadFailed error=" + bVar.b() + " state=" + r());
        H();
        if (l(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
            this.m.g(bVar, this, new Date().getTime() - this.n);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void c() {
        M("onInterstitialAdReady state=" + r());
        H();
        if (l(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.LOADED)) {
            this.m.e(this, new Date().getTime() - this.n);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        F(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        M("onInterstitialAdShowFailed error=" + bVar.b());
        this.m.a(bVar, this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void f() {
        F(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        M("onInterstitialAdClosed");
        this.m.c(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void g() {
        M("onInterstitialAdClicked");
        this.m.d(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void h() {
        M("onInterstitialAdOpened");
        this.m.b(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void j() {
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void onInterstitialInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void p() {
        M("onInterstitialAdVisible");
        this.m.f(this);
    }

    @Override // com.ironsource.mediationsdk.n0.n
    public void w(com.ironsource.mediationsdk.logger.b bVar) {
    }
}
