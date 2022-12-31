package com.ironsource.mediationsdk;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* compiled from: RewardedVideoSmash.java */
/* loaded from: classes2.dex */
public class e0 extends AbstractSmash implements com.ironsource.mediationsdk.n0.u {
    private JSONObject s;
    private com.ironsource.mediationsdk.n0.t t;
    private AtomicBoolean u;
    private long v;
    private int w;
    public int x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RewardedVideoSmash.java */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (e0.this) {
                cancel();
                if (e0.this.t != null) {
                    String str = "Timeout for " + e0.this.r();
                    e0.this.r.d(IronSourceLogger.IronSourceTag.INTERNAL, str, 0);
                    e0.this.P(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                    long time = new Date().getTime() - e0.this.v;
                    if (e0.this.u.compareAndSet(true, false)) {
                        e0.this.c0(1200, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) InputDeviceCompat.SOURCE_GAMEPAD)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(time)}});
                        e0.this.c0(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) InputDeviceCompat.SOURCE_GAMEPAD)}, new Object[]{"reason", str}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(time)}});
                    } else {
                        e0.this.c0(1208, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) InputDeviceCompat.SOURCE_GAMEPAD)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(time)}});
                    }
                    e0.this.t.m(false, e0.this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(com.ironsource.mediationsdk.model.l lVar, int i2) {
        super(lVar);
        JSONObject o = lVar.o();
        this.s = o;
        this.m = o.optInt("maxAdsPerIteration", 99);
        this.n = this.s.optInt("maxAdsPerSession", 99);
        this.o = this.s.optInt("maxAdsPerDay", 99);
        this.s.optString("requestUrl");
        this.u = new AtomicBoolean(false);
        this.w = i2;
    }

    private void b0(int i2) {
        c0(i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(int i2, Object[][] objArr) {
        JSONObject G = IronSourceUtils.G(this);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    G.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                this.r.d(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoSmash logProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, G));
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void A() {
    }

    public void Y() {
        if (this.b != null) {
            if (D() != AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY && D() != AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION) {
                this.u.set(true);
                this.v = new Date().getTime();
            }
            com.ironsource.mediationsdk.logger.c cVar = this.r;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, r() + ":fetchRewardedVideoForAutomaticLoad()", 1);
            this.b.fetchRewardedVideoForAutomaticLoad(this.s, this);
        }
    }

    public void Z(String str, String str2) {
        e0();
        if (this.b != null) {
            this.u.set(true);
            this.v = new Date().getTime();
            this.b.addRewardedVideoListener(this);
            com.ironsource.mediationsdk.logger.c cVar = this.r;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, r() + ":initRewardedVideo()", 1);
            this.b.initRewardedVideo(str, str2, this.s, this);
        }
    }

    public boolean a0() {
        if (this.b != null) {
            com.ironsource.mediationsdk.logger.c cVar = this.r;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, r() + ":isRewardedVideoAvailable()", 1);
            return this.b.isRewardedVideoAvailable(this.s);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public void b() {
        this.f5369j = 0;
        P(a0() ? AbstractSmash.MEDIATION_STATE.AVAILABLE : AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void d() {
        com.ironsource.mediationsdk.n0.t tVar = this.t;
        if (tVar != null) {
            tVar.p(this);
        }
    }

    public void d0(com.ironsource.mediationsdk.n0.t tVar) {
        this.t = tVar;
    }

    void e0() {
        try {
            S();
            Timer timer = new Timer();
            this.f5370k = timer;
            timer.schedule(new a(), this.w * 1000);
        } catch (Exception e2) {
            L("startInitTimer", e2.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public synchronized void i(boolean z) {
        S();
        if (this.u.compareAndSet(true, false)) {
            c0(z ? 1002 : 1200, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - this.v)}});
        } else {
            b0(z ? 1207 : 1208);
        }
        if (K()) {
            if ((z && this.a != AbstractSmash.MEDIATION_STATE.AVAILABLE) || (!z && this.a != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE)) {
                P(z ? AbstractSmash.MEDIATION_STATE.AVAILABLE : AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                if (z) {
                    this.q = Long.valueOf(System.currentTimeMillis());
                }
                com.ironsource.mediationsdk.n0.t tVar = this.t;
                if (tVar != null) {
                    tVar.m(z, this);
                }
            } else {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.info(this.f5364e + ": state remains " + z + " in smash, mediation remains unchanged");
            }
        } else {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.info(this.f5364e + ": is capped or exhausted");
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void k(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.n0.t tVar = this.t;
        if (tVar != null) {
            tVar.r(bVar, this);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractSmash
    protected String n() {
        return "rewardedvideo";
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void o() {
        com.ironsource.mediationsdk.n0.t tVar = this.t;
        if (tVar != null) {
            tVar.j(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void onRewardedVideoAdClosed() {
        com.ironsource.mediationsdk.n0.t tVar = this.t;
        if (tVar != null) {
            tVar.u(this);
        }
        Y();
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void onRewardedVideoAdOpened() {
        com.ironsource.mediationsdk.n0.t tVar = this.t;
        if (tVar != null) {
            tVar.n(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void s(com.ironsource.mediationsdk.logger.b bVar) {
        long time = new Date().getTime() - this.v;
        if (bVar.a() == 1058) {
            c0(1213, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(time)}});
            return;
        }
        if (bVar.a() == 1057) {
            System.currentTimeMillis();
        }
        c0(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(time)}});
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void t(com.ironsource.mediationsdk.logger.b bVar) {
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void u() {
        com.ironsource.mediationsdk.n0.t tVar = this.t;
        if (tVar != null) {
            tVar.t(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void v() {
        com.ironsource.mediationsdk.n0.t tVar = this.t;
        if (tVar != null) {
            tVar.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void y() {
        com.ironsource.mediationsdk.n0.t tVar = this.t;
        if (tVar != null) {
            tVar.f(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void z() {
    }
}
