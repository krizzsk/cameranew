package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InterstitialManager.java */
/* loaded from: classes2.dex */
public class t extends a implements com.ironsource.mediationsdk.n0.m, com.ironsource.mediationsdk.utils.j, com.ironsource.mediationsdk.utils.c {
    private final String m = t.class.getName();
    private com.ironsource.mediationsdk.n0.o n;
    private boolean o;
    private boolean p;
    private boolean q;
    private com.ironsource.mediationsdk.model.k r;
    private CallbackThrottler s;
    private boolean t;
    private long u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t() {
        new CopyOnWriteArraySet();
        new ConcurrentHashMap();
        this.s = CallbackThrottler.getInstance();
        this.t = false;
        this.p = false;
        this.o = false;
        this.a = new com.ironsource.mediationsdk.utils.d("interstitial", this);
        this.v = false;
    }

    private synchronized void H() {
        Iterator<AbstractSmash> it = this.c.iterator();
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            if (next.D() == AbstractSmash.MEDIATION_STATE.AVAILABLE || next.D() == AbstractSmash.MEDIATION_STATE.LOAD_PENDING || next.D() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                next.P(AbstractSmash.MEDIATION_STATE.INITIATED);
            }
        }
    }

    private void I(AbstractSmash abstractSmash) {
        if (!abstractSmash.K()) {
            f0();
            J();
            return;
        }
        abstractSmash.P(AbstractSmash.MEDIATION_STATE.INITIATED);
    }

    private void J() {
        if (M()) {
            this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            Iterator<AbstractSmash> it = this.c.iterator();
            while (it.hasNext()) {
                AbstractSmash next = it.next();
                if (next.D() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                    next.b();
                }
            }
            this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean M() {
        /*
            r4 = this;
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.AbstractSmash> r0 = r4.c
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3c
            java.lang.Object r1 = r0.next()
            com.ironsource.mediationsdk.AbstractSmash r1 = (com.ironsource.mediationsdk.AbstractSmash) r1
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.NOT_INITIATED
            if (r2 == r3) goto L3a
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INIT_PENDING
            if (r2 == r3) goto L3a
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INITIATED
            if (r2 == r3) goto L3a
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.D()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.LOAD_PENDING
            if (r2 == r3) goto L3a
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r1 = r1.D()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.AVAILABLE
            if (r1 != r2) goto L6
        L3a:
            r0 = 0
            return r0
        L3c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.t.M():boolean");
    }

    private synchronized void N(u uVar) {
        U(AdError.CACHE_ERROR_CODE, uVar, null);
        uVar.Y();
    }

    private void P(int i2) {
        Q(i2, null);
    }

    private void Q(int i2, Object[][] objArr) {
        R(i2, objArr, false);
    }

    private void R(int i2, Object[][] objArr, boolean z) {
        JSONObject D = IronSourceUtils.D(false);
        if (z) {
            try {
                com.ironsource.mediationsdk.model.k kVar = this.r;
                if (kVar != null && !TextUtils.isEmpty(kVar.c())) {
                    D.put("placement", this.r.c());
                }
            } catch (Exception e2) {
                this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "InterstitialManager logMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        if (objArr != null) {
            for (Object[] objArr2 : objArr) {
                D.put(objArr2[0].toString(), objArr2[1]);
            }
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, D));
    }

    private void S(int i2, Object[][] objArr) {
        R(i2, objArr, true);
    }

    private void T(int i2, AbstractSmash abstractSmash) {
        U(i2, abstractSmash, null);
    }

    private void U(int i2, AbstractSmash abstractSmash, Object[][] objArr) {
        V(i2, abstractSmash, objArr, false);
    }

    private void V(int i2, AbstractSmash abstractSmash, Object[][] objArr, boolean z) {
        JSONObject G = IronSourceUtils.G(abstractSmash);
        if (z) {
            try {
                com.ironsource.mediationsdk.model.k kVar = this.r;
                if (kVar != null && !TextUtils.isEmpty(kVar.c())) {
                    G.put("placement", this.r.c());
                }
            } catch (Exception e2) {
                this.f5496h.d(IronSourceLogger.IronSourceTag.INTERNAL, "InterstitialManager logProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        if (objArr != null) {
            for (Object[] objArr2 : objArr) {
                G.put(objArr2[0].toString(), objArr2[1]);
            }
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, G));
    }

    private void W(int i2, AbstractSmash abstractSmash, Object[][] objArr) {
        V(i2, abstractSmash, objArr, true);
    }

    private void X() {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            String m = this.c.get(i2).c.m();
            if (m.equalsIgnoreCase("IronSource") || m.equalsIgnoreCase("SupersonicAds")) {
                AdapterRepository.getInstance().f(this.c.get(i2).c, this.c.get(i2).c.h(), false, false);
                return;
            }
        }
    }

    private int d0(AbstractSmash.MEDIATION_STATE... mediation_stateArr) {
        Iterator<AbstractSmash> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            for (AbstractSmash.MEDIATION_STATE mediation_state : mediation_stateArr) {
                if (next.D() == mediation_state) {
                    i2++;
                }
            }
        }
        return i2;
    }

    private synchronized b e0(u uVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        cVar.d(ironSourceTag, this.m + ":startAdapter(" + uVar.E() + ")", 1);
        AdapterRepository adapterRepository = AdapterRepository.getInstance();
        com.ironsource.mediationsdk.model.l lVar = uVar.c;
        b f2 = adapterRepository.f(lVar, lVar.h(), false, false);
        if (f2 == null) {
            com.ironsource.mediationsdk.logger.c cVar2 = this.f5496h;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
            cVar2.d(ironSourceTag2, uVar.r() + " is configured in IronSource's platform, but the adapter is not integrated", 2);
            return null;
        }
        uVar.N(f2);
        uVar.P(AbstractSmash.MEDIATION_STATE.INIT_PENDING);
        E(uVar);
        uVar.W(this.f5495g, this.f5494f);
        return f2;
    }

    private b f0() {
        b bVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < this.c.size() && bVar == null; i3++) {
            if (this.c.get(i3).D() != AbstractSmash.MEDIATION_STATE.AVAILABLE && this.c.get(i3).D() != AbstractSmash.MEDIATION_STATE.INITIATED && this.c.get(i3).D() != AbstractSmash.MEDIATION_STATE.INIT_PENDING && this.c.get(i3).D() != AbstractSmash.MEDIATION_STATE.LOAD_PENDING) {
                if (this.c.get(i3).D() == AbstractSmash.MEDIATION_STATE.NOT_INITIATED && (bVar = e0((u) this.c.get(i3))) == null) {
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

    public synchronized void K(String str, String str2) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        cVar.d(ironSourceTag, this.m + ":initInterstitial(appKey: " + str + ", userId: " + str2 + ")", 1);
        long time = new Date().getTime();
        P(82312);
        this.f5495g = str;
        this.f5494f = str2;
        Iterator<AbstractSmash> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            if (this.a.p(next)) {
                U(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, next, new Object[][]{new Object[]{"status", "false"}});
            }
            if (this.a.l(next)) {
                next.P(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                i2++;
            }
        }
        if (i2 == this.c.size()) {
            this.q = true;
        }
        X();
        for (int i3 = 0; i3 < this.b && f0() != null; i3++) {
        }
        Q(82313, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - time)}});
    }

    public synchronized boolean L() {
        if (!this.f5497i || IronSourceUtils.S(ContextProvider.getInstance().b())) {
            Iterator<AbstractSmash> it = this.c.iterator();
            while (it.hasNext()) {
                AbstractSmash next = it.next();
                if (next.D() == AbstractSmash.MEDIATION_STATE.AVAILABLE && ((u) next).X()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public synchronized void O() {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            com.ironsource.mediationsdk.logger.b e3 = com.ironsource.mediationsdk.utils.f.e("loadInterstitial exception " + e2.getMessage());
            this.f5496h.d(IronSourceLogger.IronSourceTag.API, e3.b(), 3);
            this.s.f(e3);
            if (this.t) {
                this.t = false;
                Q(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(e3.a())}, new Object[]{"reason", e2.getMessage()}});
            }
        }
        if (this.v) {
            this.f5496h.d(IronSourceLogger.IronSourceTag.API, "loadInterstitial cannot be invoked while showing an ad", 3);
            ISListenerWrapper.getInstance().f(new com.ironsource.mediationsdk.logger.b(1037, "loadInterstitial cannot be invoked while showing an ad"));
            return;
        }
        this.r = null;
        this.n.E(null);
        if (!this.p && !this.s.c()) {
            MediationInitializer.EInitStatus D = MediationInitializer.getInstance().D();
            if (D == MediationInitializer.EInitStatus.NOT_INIT) {
                this.f5496h.d(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
                return;
            } else if (D == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                if (MediationInitializer.getInstance().G()) {
                    this.f5496h.d(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    this.s.f(com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial"));
                } else {
                    this.u = new Date().getTime();
                    Q(AdError.INTERNAL_ERROR_CODE, null);
                    this.o = true;
                    this.t = true;
                }
                return;
            } else if (D == MediationInitializer.EInitStatus.INIT_FAILED) {
                this.f5496h.d(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                this.s.f(com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial"));
                return;
            } else if (this.c.size() == 0) {
                this.f5496h.d(IronSourceLogger.IronSourceTag.API, "the server response does not contain interstitial data", 3);
                this.s.f(com.ironsource.mediationsdk.utils.f.c("the server response does not contain interstitial data", "Interstitial"));
                return;
            } else {
                this.u = new Date().getTime();
                Q(AdError.INTERNAL_ERROR_CODE, null);
                this.t = true;
                H();
                if (d0(AbstractSmash.MEDIATION_STATE.INITIATED) == 0) {
                    if (!this.q) {
                        this.o = true;
                        return;
                    }
                    com.ironsource.mediationsdk.logger.b b = com.ironsource.mediationsdk.utils.f.b("no ads to load");
                    this.f5496h.d(IronSourceLogger.IronSourceTag.API, b.b(), 1);
                    this.s.f(b);
                    Q(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(b.a())}});
                    this.t = false;
                    return;
                }
                this.o = true;
                this.p = true;
                Iterator<AbstractSmash> it = this.c.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    AbstractSmash next = it.next();
                    if (next.D() == AbstractSmash.MEDIATION_STATE.INITIATED) {
                        next.P(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                        N((u) next);
                        i2++;
                        if (i2 >= this.b) {
                            return;
                        }
                    }
                }
                return;
            }
        }
        this.f5496h.d(IronSourceLogger.IronSourceTag.API, "Load Interstitial is already in progress", 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(com.ironsource.mediationsdk.model.k kVar) {
        this.r = kVar;
        this.n.E(kVar);
    }

    public void Z(int i2) {
        this.s.h(i2);
    }

    @Override // com.ironsource.mediationsdk.utils.j
    public void a(String str) {
        if (this.o) {
            this.s.f(com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial"));
            this.o = false;
            this.p = false;
        }
    }

    public void a0(com.ironsource.mediationsdk.n0.o oVar) {
        this.n = oVar;
        this.s.i(oVar);
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public synchronized void b(u uVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + " :onInterstitialInitSuccess()", 1);
        T(2205, uVar);
        this.q = true;
        if (this.o) {
            AbstractSmash.MEDIATION_STATE mediation_state = AbstractSmash.MEDIATION_STATE.LOAD_PENDING;
            if (d0(AbstractSmash.MEDIATION_STATE.AVAILABLE, mediation_state) < this.b) {
                uVar.P(mediation_state);
                N(uVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(Context context, boolean z) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, this.m + " Should Track Network State: " + z, 0);
        this.f5497i = z;
    }

    public void c0(String str) {
        if (this.v) {
            this.f5496h.d(IronSourceLogger.IronSourceTag.API, "showInterstitial error: can't show ad while an ad is already showing", 3);
            this.n.e(new com.ironsource.mediationsdk.logger.b(1036, "showInterstitial error: can't show ad while an ad is already showing"));
        } else if (!this.o) {
            this.f5496h.d(IronSourceLogger.IronSourceTag.API, "showInterstitial failed - You need to load interstitial before showing it", 3);
            this.n.e(com.ironsource.mediationsdk.utils.f.i("Interstitial", "showInterstitial failed - You need to load interstitial before showing it"));
        } else if (this.f5497i && !IronSourceUtils.S(ContextProvider.getInstance().b())) {
            this.f5496h.d(IronSourceLogger.IronSourceTag.API, "showInterstitial error: can't show ad when there's no internet connection", 3);
            this.n.e(com.ironsource.mediationsdk.utils.f.g("Interstitial"));
        } else {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                AbstractSmash abstractSmash = this.c.get(i2);
                if (abstractSmash.D() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                    CappingManager.i(ContextProvider.getInstance().b(), this.r);
                    if (CappingManager.o(ContextProvider.getInstance().b(), this.r) != CappingManager.ECappingStatus.NOT_CAPPED) {
                        S(2400, null);
                    }
                    W(2201, abstractSmash, null);
                    this.v = true;
                    ((u) abstractSmash).a0();
                    if (abstractSmash.I()) {
                        T(2401, abstractSmash);
                    }
                    this.a.k(abstractSmash);
                    if (this.a.l(abstractSmash)) {
                        abstractSmash.P(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                        U(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, abstractSmash, new Object[][]{new Object[]{"status", "true"}});
                    }
                    this.o = false;
                    if (abstractSmash.K()) {
                        return;
                    }
                    f0();
                    return;
                }
            }
            this.n.e(com.ironsource.mediationsdk.utils.f.i("Interstitial", "showInterstitial failed - No adapters ready to show"));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public void e(u uVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + ":onInterstitialAdShowSucceeded()", 1);
        W(2202, uVar, null);
        Iterator<AbstractSmash> it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            if (next.D() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                I(next);
                z = true;
            }
        }
        if (!z && (uVar.D() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION || uVar.D() == AbstractSmash.MEDIATION_STATE.EXHAUSTED || uVar.D() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY)) {
            J();
        }
        H();
        this.n.j();
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public void g(u uVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + ":onInterstitialAdClicked()", 1);
        W(AdError.INTERNAL_ERROR_2006, uVar, null);
        this.n.g();
    }

    @Override // com.ironsource.mediationsdk.utils.c
    public void h() {
        CopyOnWriteArrayList<AbstractSmash> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<AbstractSmash> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                AbstractSmash next = it.next();
                if (next.D() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) {
                    U(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, next, new Object[][]{new Object[]{"status", "false"}});
                    if (next.I()) {
                        next.P(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                    } else if (next.J()) {
                        next.P(AbstractSmash.MEDIATION_STATE.EXHAUSTED);
                    } else {
                        next.P(AbstractSmash.MEDIATION_STATE.INITIATED);
                    }
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public void i(com.ironsource.mediationsdk.logger.b bVar, u uVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + ":onInterstitialAdShowFailed(" + bVar + ")", 1);
        W(2203, uVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}});
        this.v = false;
        I(uVar);
        Iterator<AbstractSmash> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().D() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                this.o = true;
                com.ironsource.mediationsdk.model.k kVar = this.r;
                c0(kVar != null ? kVar.c() : "");
                return;
            }
        }
        this.n.e(bVar);
    }

    @Override // com.ironsource.mediationsdk.utils.j
    public void k(List<IronSource.AD_UNIT> list, boolean z, com.ironsource.mediationsdk.model.i iVar) {
    }

    @Override // com.ironsource.mediationsdk.utils.j
    public void l() {
        if (this.o) {
            com.ironsource.mediationsdk.logger.b c = com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial");
            this.s.f(c);
            this.o = false;
            this.p = false;
            if (this.t) {
                Q(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(c.a())}});
                this.t = false;
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public void o(u uVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + ":onInterstitialAdVisible()", 1);
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public synchronized void q(com.ironsource.mediationsdk.logger.b bVar, u uVar, long j2) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + ":onInterstitialAdLoadFailed(" + bVar + ")", 1);
        IronSourceUtils.j0(uVar.r() + ":onInterstitialAdLoadFailed(" + bVar + ")");
        if (bVar.a() == 1158) {
            U(2213, uVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        } else {
            U(2200, uVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        }
        uVar.P(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
        int d0 = d0(AbstractSmash.MEDIATION_STATE.AVAILABLE, AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
        if (d0 >= this.b) {
            return;
        }
        Iterator<AbstractSmash> it = this.c.iterator();
        while (it.hasNext()) {
            AbstractSmash next = it.next();
            if (next.D() == AbstractSmash.MEDIATION_STATE.INITIATED) {
                next.P(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                N((u) next);
                return;
            }
        }
        if (f0() != null) {
            return;
        }
        if (this.o && d0 + d0(AbstractSmash.MEDIATION_STATE.INIT_PENDING) == 0) {
            J();
            this.p = false;
            this.s.f(new com.ironsource.mediationsdk.logger.b(509, "No ads to show"));
            Q(2110, new Object[][]{new Object[]{"errorCode", 509}});
        }
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public void s(u uVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + ":onInterstitialAdClosed()", 1);
        this.v = false;
        W(2204, uVar, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(SessionDepthManager.getInstance().b(2))}});
        SessionDepthManager.getInstance().d(2);
        this.n.f();
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public synchronized void v(com.ironsource.mediationsdk.logger.b bVar, u uVar) {
        try {
            com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
            cVar.d(ironSourceTag, uVar.r() + ":onInterstitialInitFailed(" + bVar + ")", 1);
            U(2206, uVar, new Object[][]{new Object[]{"reason", bVar.b()}});
            AbstractSmash.MEDIATION_STATE mediation_state = AbstractSmash.MEDIATION_STATE.INIT_FAILED;
            if (d0(mediation_state) >= this.c.size()) {
                com.ironsource.mediationsdk.logger.c cVar2 = this.f5496h;
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NATIVE;
                cVar2.d(ironSourceTag2, "Smart Loading - initialization failed - no adapters are initiated and no more left to init, error: " + bVar.b(), 2);
                if (this.o) {
                    this.s.f(com.ironsource.mediationsdk.utils.f.b("no ads to show"));
                    Q(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) TypedValues.PositionType.TYPE_POSITION_TYPE)}});
                    this.t = false;
                }
                this.q = true;
            } else {
                if (f0() == null && this.o && d0(mediation_state, AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY, AbstractSmash.MEDIATION_STATE.EXHAUSTED) >= this.c.size()) {
                    this.s.f(new com.ironsource.mediationsdk.logger.b(509, "No ads to show"));
                    Q(2110, new Object[][]{new Object[]{"errorCode", 509}});
                    this.t = false;
                }
                J();
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c cVar3 = this.f5496h;
            IronSourceLogger.IronSourceTag ironSourceTag3 = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
            cVar3.e(ironSourceTag3, "onInterstitialInitFailed(error:" + bVar + ", provider:" + uVar.E() + ")", e2);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public void w(u uVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + ":onInterstitialAdOpened()", 1);
        W(2005, uVar, null);
        this.n.h();
    }

    @Override // com.ironsource.mediationsdk.n0.m
    public synchronized void x(u uVar, long j2) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5496h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, uVar.r() + ":onInterstitialAdReady()", 1);
        U(AdError.INTERNAL_ERROR_2003, uVar, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        long time = new Date().getTime() - this.u;
        uVar.P(AbstractSmash.MEDIATION_STATE.AVAILABLE);
        this.p = false;
        if (this.t) {
            this.t = false;
            this.n.c();
            Q(AdError.INTERNAL_ERROR_2004, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(time)}});
        }
    }
}
