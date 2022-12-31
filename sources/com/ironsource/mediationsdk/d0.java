package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RewardedVideoManager.java */
/* loaded from: classes2.dex */
public class d0 extends com.ironsource.mediationsdk.a implements com.ironsource.mediationsdk.n0.t, com.ironsource.environment.i, com.ironsource.mediationsdk.utils.c, q {
    private com.ironsource.mediationsdk.n0.o n;
    private NetworkStateReceiver p;
    private com.ironsource.mediationsdk.model.o q;
    private int s;
    private final String m = d0.class.getSimpleName();
    private Timer r = null;
    private boolean o = false;
    private boolean u = false;
    private long v = new Date().getTime();
    private List<AbstractSmash.MEDIATION_STATE> t = Arrays.asList(AbstractSmash.MEDIATION_STATE.INIT_FAILED, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.EXHAUSTED, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RewardedVideoManager.java */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            d0.this.T();
            d0.this.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0() {
        this.a = new com.ironsource.mediationsdk.utils.d("rewarded_video", this);
    }

    private synchronized void J() {
        if (Q()) {
            this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            Iterator<AbstractSmash> it = this.c.iterator();
            boolean z = false;
            while (it.hasNext()) {
                AbstractSmash next = it.next();
                if (next.D() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                    next.b();
                }
                if (next.D() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                    z = true;
                }
            }
            this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
            if (f0(z, false)) {
                this.n.i(this.f5498j.booleanValue());
            }
        }
    }

    private String K() {
        com.ironsource.mediationsdk.model.o oVar = this.q;
        return oVar == null ? "" : oVar.c();
    }

    private synchronized boolean L() {
        boolean z;
        z = false;
        Iterator<AbstractSmash> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().D() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                z = true;
                break;
            }
        }
        return z;
    }

    private synchronized boolean N() {
        int i2;
        Iterator<AbstractSmash> it = this.c.iterator();
        i2 = 0;
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            if (next.D() == AbstractSmash.MEDIATION_STATE.INIT_FAILED || next.D() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY || next.D() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION || next.D() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE || next.D() == AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD || next.D() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                i2++;
            }
        }
        return this.c.size() == i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0007, B:6:0x000d, B:8:0x001b, B:10:0x0023, B:12:0x002b, B:14:0x0033, B:16:0x003b), top: B:27:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean O() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.AbstractSmash> r0 = r4.c     // Catch: java.lang.Throwable -> L49
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L49
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L46
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L49
            com.ironsource.mediationsdk.AbstractSmash r1 = (com.ironsource.mediationsdk.AbstractSmash) r1     // Catch: java.lang.Throwable -> L49
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()     // Catch: java.lang.Throwable -> L49
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE     // Catch: java.lang.Throwable -> L49
            if (r2 == r3) goto L43
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()     // Catch: java.lang.Throwable -> L49
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD     // Catch: java.lang.Throwable -> L49
            if (r2 == r3) goto L43
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()     // Catch: java.lang.Throwable -> L49
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.AVAILABLE     // Catch: java.lang.Throwable -> L49
            if (r2 == r3) goto L43
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()     // Catch: java.lang.Throwable -> L49
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INITIATED     // Catch: java.lang.Throwable -> L49
            if (r2 == r3) goto L43
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()     // Catch: java.lang.Throwable -> L49
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INIT_PENDING     // Catch: java.lang.Throwable -> L49
            if (r2 == r3) goto L43
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r1 = r1.D()     // Catch: java.lang.Throwable -> L49
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.LOAD_PENDING     // Catch: java.lang.Throwable -> L49
            if (r1 != r2) goto L7
        L43:
            r0 = 1
            monitor-exit(r4)
            return r0
        L46:
            r0 = 0
            monitor-exit(r4)
            return r0
        L49:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.d0.O():boolean");
    }

    private synchronized boolean P() {
        if (B() != null) {
            return ((e0) B()).a0();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[Catch: all -> 0x0031, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0007, B:6:0x000d, B:8:0x001b, B:10:0x0023), top: B:21:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean Q() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.AbstractSmash> r0 = r4.c     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L31
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L2e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L31
            com.ironsource.mediationsdk.AbstractSmash r1 = (com.ironsource.mediationsdk.AbstractSmash) r1     // Catch: java.lang.Throwable -> L31
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()     // Catch: java.lang.Throwable -> L31
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.NOT_INITIATED     // Catch: java.lang.Throwable -> L31
            if (r2 == r3) goto L2b
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()     // Catch: java.lang.Throwable -> L31
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INITIATED     // Catch: java.lang.Throwable -> L31
            if (r2 == r3) goto L2b
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r1 = r1.D()     // Catch: java.lang.Throwable -> L31
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.AVAILABLE     // Catch: java.lang.Throwable -> L31
            if (r1 != r2) goto L7
        L2b:
            r0 = 0
            monitor-exit(r4)
            return r0
        L2e:
            r0 = 1
            monitor-exit(r4)
            return r0
        L31:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.d0.Q():boolean");
    }

    private b S() {
        b bVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < this.c.size() && bVar == null; i3++) {
            if (this.c.get(i3).D() != AbstractSmash.MEDIATION_STATE.AVAILABLE && this.c.get(i3).D() != AbstractSmash.MEDIATION_STATE.INITIATED) {
                if (this.c.get(i3).D() == AbstractSmash.MEDIATION_STATE.NOT_INITIATED && (bVar = i0((e0) this.c.get(i3))) == null) {
                    this.c.get(i3).P(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                }
            } else {
                i2++;
                if (i2 >= this.b) {
                    break;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void T() {
        Boolean bool;
        if (IronSourceUtils.S(ContextProvider.getInstance().b()) && (bool = this.f5498j) != null) {
            if (!bool.booleanValue()) {
                U(102);
                U(1000);
                this.u = true;
                Iterator<AbstractSmash> it = this.c.iterator();
                while (it.hasNext()) {
                    AbstractSmash next = it.next();
                    if (next.D() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
                        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                        cVar.d(ironSourceTag, "Fetch from timer: " + next.r() + ":reload smash", 1);
                        W(1001, next, null);
                        ((e0) next).Y();
                    }
                }
            }
        }
    }

    private void U(int i2) {
        V(i2, null);
    }

    private void V(int i2, Object[][] objArr) {
        JSONObject D = IronSourceUtils.D(false);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    D.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoManager logMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, D));
    }

    private void W(int i2, AbstractSmash abstractSmash, Object[][] objArr) {
        JSONObject G = IronSourceUtils.G(abstractSmash);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    G.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoManager logProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, G));
    }

    private synchronized void X(Map<String, Object> map) {
        if (B() != null && !this.f5499k) {
            this.f5499k = true;
            if (i0((e0) B()) == null) {
                this.n.i(this.f5498j.booleanValue());
            }
        } else if (P()) {
            if (f0(true, false)) {
                this.n.i(this.f5498j.booleanValue());
            }
        } else {
            this.n.B(this.f5498j.booleanValue(), map);
        }
    }

    private void Y() {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            String m = this.c.get(i2).c.m();
            if (m.equalsIgnoreCase("IronSource") || m.equalsIgnoreCase("SupersonicAds")) {
                AdapterRepository.getInstance().f(this.c.get(i2).c, this.c.get(i2).c.o(), false, false);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.s <= 0) {
            this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "load interval is not set, ignoring", 1);
            return;
        }
        Timer timer = this.r;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.r = timer2;
        timer2.schedule(new a(), this.s * 1000);
    }

    private void a0(boolean z) {
        if (!z && R()) {
            U(1000);
            V(1003, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, 0}});
            this.u = false;
        } else if (O()) {
            U(1000);
            this.u = true;
            this.v = new Date().getTime();
        }
    }

    private synchronized boolean f0(boolean z, boolean z2) {
        boolean z3;
        z3 = false;
        Boolean bool = this.f5498j;
        if (bool == null) {
            Z();
            if (z) {
                this.f5498j = Boolean.TRUE;
            } else if (!P() && N()) {
                this.f5498j = Boolean.FALSE;
            }
            z3 = true;
        } else {
            if (z && !bool.booleanValue()) {
                this.f5498j = Boolean.TRUE;
            } else if (!z && this.f5498j.booleanValue() && ((!L() || z2) && !P())) {
                this.f5498j = Boolean.FALSE;
            }
            z3 = true;
        }
        return z3;
    }

    private boolean g0(boolean z) {
        Boolean bool = this.f5498j;
        if (bool == null) {
            return false;
        }
        if (z && !bool.booleanValue() && L()) {
            this.f5498j = Boolean.TRUE;
        } else if (z || !this.f5498j.booleanValue()) {
            return false;
        } else {
            this.f5498j = Boolean.FALSE;
        }
        return true;
    }

    private synchronized b i0(e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        cVar.d(ironSourceTag, this.m + ":startAdapter(" + e0Var.r() + ")", 1);
        AdapterRepository adapterRepository = AdapterRepository.getInstance();
        com.ironsource.mediationsdk.model.l lVar = e0Var.c;
        b f2 = adapterRepository.f(lVar, lVar.o(), false, false);
        if (f2 == null) {
            com.ironsource.mediationsdk.logger.c cVar2 = this.f5496h;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
            cVar2.d(ironSourceTag2, e0Var.r() + " is configured in IronSource's platform, but the adapter is not integrated", 2);
            return null;
        }
        e0Var.N(f2);
        e0Var.P(AbstractSmash.MEDIATION_STATE.INITIATED);
        E(e0Var);
        W(1001, e0Var, null);
        e0Var.Z(this.f5495g, this.f5494f);
        return f2;
    }

    private void j0() {
        Iterator<AbstractSmash> it = this.c.iterator();
        long j2 = Long.MAX_VALUE;
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            if (next.D() == AbstractSmash.MEDIATION_STATE.AVAILABLE && next.l() != null && next.l().longValue() < j2) {
                j2 = next.l().longValue();
            }
        }
        if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
            n.c().e(System.currentTimeMillis() - j2);
        }
    }

    @Override // com.ironsource.mediationsdk.q
    public void A() {
        if (IronSourceUtils.S(ContextProvider.getInstance().a()) && this.f5498j != null) {
            if (f0(false, true)) {
                X(com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 1057}, new Object[]{"reason", "loaded ads are expired"}}));
            }
            a0(true);
            Iterator<AbstractSmash> it = this.c.iterator();
            while (it.hasNext()) {
                AbstractSmash next = it.next();
                if (next.D() == AbstractSmash.MEDIATION_STATE.AVAILABLE || next.D() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                    next.P(AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD);
                }
            }
            Iterator<AbstractSmash> it2 = this.c.iterator();
            while (it2.hasNext()) {
                AbstractSmash next2 = it2.next();
                if (next2.D() == AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD) {
                    try {
                        IronLog ironLog = IronLog.INTERNAL;
                        ironLog.info(next2.r() + ":reload smash");
                        W(1001, next2, null);
                        ((e0) next2).Y();
                    } catch (Throwable th) {
                        IronLog ironLog2 = IronLog.INTERNAL;
                        ironLog2.error(next2.r() + " Failed to call fetchVideo(), " + th.getLocalizedMessage());
                    }
                }
            }
            return;
        }
        IronLog.INTERNAL.info("while reloading mediation due to expiration, internet loss occurred");
        U(81319);
    }

    public synchronized void M(String str, String str2) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        cVar.d(ironSourceTag, this.m + ":initRewardedVideo(appKey: " + str + ", userId: " + str2 + ")", 1);
        long time = new Date().getTime();
        U(81312);
        this.f5495g = str;
        this.f5494f = str2;
        Iterator<AbstractSmash> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            if (this.a.p(next)) {
                W(150, next, new Object[][]{new Object[]{"status", "false"}});
            }
            if (this.a.l(next)) {
                next.P(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                i2++;
            }
        }
        if (i2 == this.c.size()) {
            this.n.i(false);
            return;
        }
        U(1000);
        this.n.F(null);
        this.u = true;
        this.v = new Date().getTime();
        V(81313, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - time)}});
        Y();
        for (int i3 = 0; i3 < this.b && i3 < this.c.size() && S() != null; i3++) {
        }
    }

    public synchronized boolean R() {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        cVar.d(ironSourceTag, this.m + ":isRewardedVideoAvailable()", 1);
        if (!this.f5497i || IronSourceUtils.S(ContextProvider.getInstance().b())) {
            Iterator<AbstractSmash> it = this.c.iterator();
            while (it.hasNext()) {
                AbstractSmash next = it.next();
                if (next.K() && ((e0) next).a0()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void b0(int i2) {
        n.c().d(this, i2);
    }

    @Override // com.ironsource.environment.i
    public void c(boolean z) {
        if (this.f5497i) {
            com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, "Network Availability Changed To: " + z, 0);
            if (g0(z)) {
                this.o = !z;
                this.n.i(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(boolean z) {
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public void d(e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, e0Var.r() + ":onRewardedVideoAdClicked()", 1);
        if (this.q == null) {
            this.q = IronSourceObject.getInstance().o().b().e().c();
        }
        if (this.q == null) {
            this.f5496h.d(ironSourceTag, "mCurrentPlacement is null", 3);
            return;
        }
        W(1006, e0Var, new Object[][]{new Object[]{"placement", K()}, new Object[]{"sessionDepth", Integer.valueOf(e0Var.x)}});
        this.n.t(this.q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(int i2) {
        this.s = i2;
    }

    public void e0(com.ironsource.mediationsdk.n0.o oVar) {
        this.n = oVar;
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public void f(e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, e0Var.r() + ":onRewardedVideoAdRewarded()", 1);
        if (this.q == null) {
            this.q = IronSourceObject.getInstance().o().b().e().c();
        }
        JSONObject G = IronSourceUtils.G(e0Var);
        try {
            G.put("sessionDepth", e0Var.x);
            if (this.q != null) {
                G.put("placement", K());
                G.put("rewardName", this.q.e());
                G.put("rewardAmount", this.q.d());
            } else {
                this.f5496h.d(ironSourceTag, "mCurrentPlacement is null", 3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.e.b.b bVar = new d.e.b.b(1010, G);
        if (!TextUtils.isEmpty(this.f5495g)) {
            bVar.a("transId", IronSourceUtils.O("" + Long.toString(bVar.e()) + this.f5495g + e0Var.E()));
            if (!TextUtils.isEmpty(IronSourceObject.getInstance().q())) {
                bVar.a("dynamicUserId", IronSourceObject.getInstance().q());
            }
            Map<String, String> z = IronSourceObject.getInstance().z();
            if (z != null) {
                for (String str : z.keySet()) {
                    bVar.a("custom_" + str, z.get(str));
                }
            }
        }
        RewardedVideoEventsManager.getInstance().P(bVar);
        com.ironsource.mediationsdk.model.o oVar = this.q;
        if (oVar != null) {
            this.n.p(oVar);
        } else {
            this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        }
    }

    @Override // com.ironsource.mediationsdk.utils.c
    public void h() {
        Iterator<AbstractSmash> it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            if (next.D() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) {
                W(150, next, new Object[][]{new Object[]{"status", "false"}});
                next.P(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                if (((e0) next).a0() && next.K()) {
                    next.P(AbstractSmash.MEDIATION_STATE.AVAILABLE);
                    z = true;
                }
            }
        }
        if (z && f0(true, false)) {
            this.n.i(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(Context context, boolean z) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, this.m + " Should Track Network State: " + z, 0);
        this.f5497i = z;
        if (z) {
            if (this.p == null) {
                this.p = new NetworkStateReceiver(context, this);
            }
            context.getApplicationContext().registerReceiver(this.p, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else if (this.p != null) {
            context.getApplicationContext().unregisterReceiver(this.p);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public void j(e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, e0Var.r() + ":onRewardedVideoAdStarted()", 1);
        W(1204, e0Var, new Object[][]{new Object[]{"placement", K()}, new Object[]{"sessionDepth", Integer.valueOf(e0Var.x)}});
        this.n.o();
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public synchronized void m(boolean z, e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, e0Var.r() + ": onRewardedVideoAvailabilityChanged(available:" + z + ")", 1);
        if (this.o) {
            return;
        }
        if (z && this.u) {
            this.u = false;
            V(1003, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - this.v)}});
            j0();
        }
        if (e0Var.equals(B())) {
            if (f0(z, false)) {
                this.n.i(this.f5498j.booleanValue());
            }
            return;
        }
        if (e0Var.equals(C())) {
            com.ironsource.mediationsdk.logger.c cVar2 = this.f5496h;
            cVar2.d(ironSourceTag, e0Var.r() + " is a premium adapter, canShowPremium: " + z(), 1);
            if (!z()) {
                e0Var.P(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                if (f0(false, false)) {
                    this.n.i(this.f5498j.booleanValue());
                }
                return;
            }
        }
        if (!this.a.l(e0Var)) {
            if (z && e0Var.K()) {
                if (f0(true, false)) {
                    this.n.i(this.f5498j.booleanValue());
                }
            } else {
                if (f0(false, false)) {
                    X(null);
                }
                S();
                J();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public void n(e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, e0Var.r() + ":onRewardedVideoAdOpened()", 1);
        W(CloseFrame.NOCODE, e0Var, new Object[][]{new Object[]{"placement", K()}, new Object[]{"sessionDepth", Integer.valueOf(e0Var.x)}});
        this.n.onRewardedVideoAdOpened();
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public void p(e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, e0Var.r() + ":onRewardedVideoAdEnded()", 1);
        W(1205, e0Var, new Object[][]{new Object[]{"placement", K()}, new Object[]{"sessionDepth", Integer.valueOf(e0Var.x)}});
        this.n.d();
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public void r(com.ironsource.mediationsdk.logger.b bVar, e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, e0Var.r() + ":onRewardedVideoAdShowFailed(" + bVar + ")", 1);
        W(1202, e0Var, new Object[][]{new Object[]{"placement", K()}, new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"sessionDepth", Integer.valueOf(e0Var != null ? e0Var.x : SessionDepthManager.getInstance().b(1))}});
        a0(false);
        this.n.k(bVar);
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public void t(e0 e0Var) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, e0Var.r() + ":onRewardedVideoAdVisible()", 1);
        if (this.q != null) {
            W(1206, e0Var, new Object[][]{new Object[]{"placement", K()}, new Object[]{"sessionDepth", Integer.valueOf(e0Var.x)}});
        } else {
            this.f5496h.d(ironSourceTag, "mCurrentPlacement is null", 3);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.t
    public void u(e0 e0Var) {
        String str;
        AbstractSmash next;
        this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, e0Var.r() + ":onRewardedVideoAdClosed()", 1);
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<AbstractSmash> it = this.c.iterator();
            while (it.hasNext()) {
                if (((e0) it.next()).a0()) {
                    sb.append(next.r() + ";");
                }
            }
        } catch (Throwable unused) {
            this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "Failed to check RV availability", 0);
        }
        Object[][] objArr = new Object[3];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "placement";
        objArr2[1] = K();
        objArr[0] = objArr2;
        Object[] objArr3 = new Object[2];
        objArr3[0] = "ext1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("otherRVAvailable = ");
        if (sb.length() > 0) {
            str = "true|" + ((Object) sb);
        } else {
            str = "false";
        }
        sb2.append(str);
        objArr3[1] = sb2.toString();
        objArr[1] = objArr3;
        Object[] objArr4 = new Object[2];
        objArr4[0] = "sessionDepth";
        objArr4[1] = Integer.valueOf(e0Var.x);
        objArr[2] = objArr4;
        W(1203, e0Var, objArr);
        SessionDepthManager.getInstance().d(1);
        if (!e0Var.I() && !this.a.l(e0Var)) {
            W(1001, e0Var, null);
        }
        a0(false);
        this.n.onRewardedVideoAdClosed();
        j0();
        Iterator<AbstractSmash> it2 = this.c.iterator();
        while (it2.hasNext()) {
            AbstractSmash next2 = it2.next();
            com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, "Fetch on ad closed, iterating on: " + next2.r() + ", Status: " + next2.D(), 0);
            if (next2.D() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE || next2.D() == AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD) {
                try {
                    if (!next2.r().equals(e0Var.r())) {
                        this.f5496h.d(ironSourceTag, next2.r() + ":reload smash", 1);
                        ((e0) next2).Y();
                        W(1001, next2, null);
                    }
                } catch (Throwable th) {
                    this.f5496h.d(IronSourceLogger.IronSourceTag.NATIVE, next2.r() + " Failed to call fetchVideo(), " + th.getLocalizedMessage(), 1);
                }
            }
        }
    }
}
