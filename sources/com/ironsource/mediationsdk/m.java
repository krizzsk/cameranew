package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.DemandOnlySmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONObject;
/* compiled from: DemandOnlyRvSmash.java */
/* loaded from: classes2.dex */
public class m extends DemandOnlySmash implements com.ironsource.mediationsdk.n0.u {
    private com.ironsource.mediationsdk.n0.e m;
    private long n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DemandOnlyRvSmash.java */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            m mVar = m.this;
            mVar.N("load timed out state=" + m.this.r());
            if (m.this.l(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
                m.this.m.f(new com.ironsource.mediationsdk.logger.b(1055, "load timed out"), m.this, new Date().getTime() - m.this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(String str, String str2, com.ironsource.mediationsdk.model.l lVar, com.ironsource.mediationsdk.n0.e eVar, int i2, b bVar) {
        super(new com.ironsource.mediationsdk.model.a(lVar, lVar.h()), bVar);
        com.ironsource.mediationsdk.model.a aVar = new com.ironsource.mediationsdk.model.a(lVar, lVar.o());
        this.b = aVar;
        JSONObject b = aVar.b();
        this.c = b;
        this.a = bVar;
        this.m = eVar;
        this.f5402f = i2;
        bVar.initRewardedVideoForDemandOnly(str, str2, b, this);
    }

    private void M(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "DemandOnlyRewardedVideoSmash " + this.b.e() + " : " + str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRewardedVideoSmash " + this.b.e() + " : " + str, 0);
    }

    private void O() {
        N("start timer");
        G(new a());
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void A() {
        M("onRewardedVideoLoadSuccess state=" + r());
        H();
        if (l(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.LOADED)) {
            this.m.e(this, new Date().getTime() - this.n);
        }
    }

    public void L(String str, String str2, JSONObject jSONObject, List<String> list) {
        N("loadRewardedVideo state=" + r());
        DemandOnlySmash.SMASH_STATE smash_state = DemandOnlySmash.SMASH_STATE.NOT_LOADED;
        DemandOnlySmash.SMASH_STATE smash_state2 = DemandOnlySmash.SMASH_STATE.LOADED;
        DemandOnlySmash.SMASH_STATE smash_state3 = DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS;
        DemandOnlySmash.SMASH_STATE b = b(new DemandOnlySmash.SMASH_STATE[]{smash_state, smash_state2}, smash_state3);
        if (b != smash_state && b != smash_state2) {
            if (b == smash_state3) {
                this.m.f(new com.ironsource.mediationsdk.logger.b(1053, "load already in progress"), this, 0L);
                return;
            } else {
                this.m.f(new com.ironsource.mediationsdk.logger.b(1056, "cannot load because show is in progress"), this, 0L);
                return;
            }
        }
        this.n = new Date().getTime();
        O();
        if (B()) {
            this.f5403g = str2;
            this.f5404h = jSONObject;
            this.f5405i = list;
            this.a.loadRewardedVideoForDemandOnlyForBidding(this.c, this, str);
            return;
        }
        this.a.loadRewardedVideoForDemandOnly(this.c, this);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void d() {
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void i(boolean z) {
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void k(com.ironsource.mediationsdk.logger.b bVar) {
        F(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        M("onRewardedVideoAdClosed error=" + bVar);
        this.m.d(bVar, this);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void o() {
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void onRewardedVideoAdClosed() {
        F(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        M("onRewardedVideoAdClosed");
        this.m.a(this);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void onRewardedVideoAdOpened() {
        M("onRewardedVideoAdOpened");
        this.m.h(this);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void s(com.ironsource.mediationsdk.logger.b bVar) {
        M("onRewardedVideoLoadFailed error=" + bVar.b() + " state=" + r());
        H();
        if (l(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
            this.m.f(bVar, this, new Date().getTime() - this.n);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void t(com.ironsource.mediationsdk.logger.b bVar) {
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void u() {
        M("onRewardedVideoAdVisible");
        this.m.g(this);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void v() {
        M("onRewardedVideoAdClicked");
        this.m.b(this);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void y() {
        M("onRewardedVideoAdRewarded");
        this.m.c(this);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void z() {
    }
}
