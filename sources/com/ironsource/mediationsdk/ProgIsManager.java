package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.AdError;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ProgIsManager extends i implements a0, d {
    private com.ironsource.mediationsdk.utils.m b;
    private MEDIATION_STATE c;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentHashMap<String, ProgIsSmash> f5462d;

    /* renamed from: e  reason: collision with root package name */
    private CopyOnWriteArrayList<ProgIsSmash> f5463e;

    /* renamed from: f  reason: collision with root package name */
    private ConcurrentHashMap<String, f> f5464f;

    /* renamed from: g  reason: collision with root package name */
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> f5465g;

    /* renamed from: h  reason: collision with root package name */
    private f f5466h;

    /* renamed from: i  reason: collision with root package name */
    private String f5467i;

    /* renamed from: j  reason: collision with root package name */
    private String f5468j;

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f5469k;

    /* renamed from: l  reason: collision with root package name */
    private int f5470l;
    private boolean m;
    private boolean n;
    private e o;
    private AuctionHistory p;
    private long q;
    private long r;
    private long s;
    private int t;
    private String u;
    boolean v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum MEDIATION_STATE {
        STATE_NOT_INITIALIZED,
        STATE_READY_TO_LOAD,
        STATE_AUCTION,
        STATE_LOADING_SMASHES,
        STATE_READY_TO_SHOW,
        STATE_SHOWING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: com.ironsource.mediationsdk.ProgIsManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0206a implements Runnable {
            RunnableC0206a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ProgIsManager.this.m0();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgIsManager.this.f5468j = "";
            ProgIsManager.this.f5469k = null;
            StringBuilder sb = new StringBuilder();
            long time = ProgIsManager.this.r - (new Date().getTime() - ProgIsManager.this.q);
            if (time <= 0) {
                ProgIsManager.this.o0(2000, null);
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (ProgIsSmash progIsSmash : ProgIsManager.this.f5462d.values()) {
                    if (!ProgIsManager.this.b.c(progIsSmash)) {
                        if (progIsSmash.L()) {
                            Map<String, Object> T = progIsSmash.T();
                            if (T != null) {
                                hashMap.put(progIsSmash.x(), T);
                                sb.append(progIsSmash.E() + progIsSmash.x() + ",");
                            }
                        } else {
                            arrayList.add(progIsSmash.x());
                            sb.append(progIsSmash.E() + progIsSmash.x() + ",");
                        }
                    }
                }
                if (hashMap.size() != 0 || arrayList.size() != 0) {
                    ProgIsManager.this.o0(2310, new Object[][]{new Object[]{"ext1", sb.toString()}});
                    int b = SessionDepthManager.getInstance().b(2);
                    if (ProgIsManager.this.o != null) {
                        ProgIsManager.this.o.a(ContextProvider.getInstance().a(), hashMap, arrayList, ProgIsManager.this.p, b);
                        return;
                    }
                    return;
                }
                ProgIsManager.this.o0(2300, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) CloseFrame.NOCODE)}, new Object[]{TypedValues.TransitionType.S_DURATION, 0}});
                ProgIsManager.this.k0("makeAuction() failed - No candidates available for auctioning");
                CallbackThrottler.getInstance().f(new com.ironsource.mediationsdk.logger.b(CloseFrame.NOCODE, "No candidates available for auctioning"));
                ProgIsManager.this.o0(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) CloseFrame.NOCODE)}});
                ProgIsManager.this.x0(MEDIATION_STATE.STATE_READY_TO_LOAD);
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0206a(), time);
        }
    }

    public ProgIsManager(List<com.ironsource.mediationsdk.model.l> list, com.ironsource.mediationsdk.model.j jVar, String str, String str2, int i2, HashSet<com.ironsource.mediationsdk.l0.c> hashSet) {
        super(hashSet);
        this.u = "";
        this.v = false;
        long time = new Date().getTime();
        n0(82312);
        x0(MEDIATION_STATE.STATE_NOT_INITIALIZED);
        this.f5462d = new ConcurrentHashMap<>();
        this.f5463e = new CopyOnWriteArrayList<>();
        this.f5464f = new ConcurrentHashMap<>();
        this.f5465g = new ConcurrentHashMap<>();
        this.f5467i = "";
        this.f5468j = "";
        this.f5469k = null;
        this.f5470l = jVar.e();
        this.m = jVar.g();
        CallbackThrottler.getInstance().h(i2);
        com.ironsource.mediationsdk.utils.b h2 = jVar.h();
        this.r = h2.m();
        boolean z = h2.i() > 0;
        this.n = z;
        if (z) {
            this.o = new e("interstitial", h2, this);
        }
        ArrayList arrayList = new ArrayList();
        for (com.ironsource.mediationsdk.model.l lVar : list) {
            b f2 = AdapterRepository.getInstance().f(lVar, lVar.h(), false, false);
            if (f2 != null && AdaptersCompatibilityHandler.getInstance().b(f2)) {
                ProgIsSmash progIsSmash = new ProgIsSmash(str, str2, lVar, this, jVar.f(), f2);
                String x = progIsSmash.x();
                this.f5462d.put(x, progIsSmash);
                arrayList.add(x);
            }
        }
        this.p = new AuctionHistory(arrayList, h2.d());
        this.b = new com.ironsource.mediationsdk.utils.m(new ArrayList(this.f5462d.values()));
        for (ProgIsSmash progIsSmash2 : this.f5462d.values()) {
            if (progIsSmash2.L()) {
                progIsSmash2.U();
            }
        }
        this.q = new Date().getTime();
        x0(MEDIATION_STATE.STATE_READY_TO_LOAD);
        o0(82313, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - time)}});
    }

    private void B0(List<f> list) {
        this.f5463e.clear();
        this.f5464f.clear();
        this.f5465g.clear();
        StringBuilder sb = new StringBuilder();
        for (f fVar : list) {
            sb.append(e0(fVar) + ",");
            ProgIsSmash progIsSmash = this.f5462d.get(fVar.c());
            if (progIsSmash != null) {
                progIsSmash.N(true);
                this.f5463e.add(progIsSmash);
                this.f5464f.put(progIsSmash.x(), fVar);
                this.f5465g.put(fVar.c(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
            } else {
                k0("updateWaterfall() - could not find matching smash for auction response item " + fVar.c());
            }
        }
        String str = "updateWaterfall() - next waterfall is " + sb.toString();
        k0(str);
        IronSourceUtils.j0("IS: " + str);
        if (sb.length() == 0) {
            k0("Updated waterfall is empty");
        }
        o0(2311, new Object[][]{new Object[]{"ext1", sb.toString()}});
    }

    private void C0() {
        List<f> d0 = d0();
        this.f5468j = P();
        B0(d0);
    }

    private List<f> d0() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (ProgIsSmash progIsSmash : this.f5462d.values()) {
            if (!progIsSmash.L() && !this.b.c(progIsSmash)) {
                copyOnWriteArrayList.add(new f(progIsSmash.x()));
            }
        }
        return copyOnWriteArrayList;
    }

    private String e0(f fVar) {
        String str;
        ProgIsSmash progIsSmash = this.f5462d.get(fVar.c());
        if (progIsSmash != null) {
            str = Integer.toString(progIsSmash.E());
        } else {
            str = TextUtils.isEmpty(fVar.g()) ? "1" : "2";
        }
        return str + fVar.c();
    }

    private void h0(ProgIsSmash progIsSmash) {
        String g2 = this.f5464f.get(progIsSmash.x()).g();
        progIsSmash.M(g2);
        s0(AdError.CACHE_ERROR_CODE, progIsSmash);
        progIsSmash.X(g2);
    }

    private void i0() {
        if (this.f5463e.isEmpty()) {
            x0(MEDIATION_STATE.STATE_READY_TO_LOAD);
            o0(2110, new Object[][]{new Object[]{"errorCode", 1035}, new Object[]{"reason", "Empty waterfall"}});
            CallbackThrottler.getInstance().f(new com.ironsource.mediationsdk.logger.b(1035, "Empty waterfall"));
            return;
        }
        x0(MEDIATION_STATE.STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5463e.size() && i2 < this.f5470l; i3++) {
            ProgIsSmash progIsSmash = this.f5463e.get(i3);
            if (progIsSmash.F()) {
                if (this.m && progIsSmash.L()) {
                    if (i2 == 0) {
                        String str = "Advanced Loading: Starting to load bidder " + progIsSmash.x() + ". No other instances will be loaded at the same time.";
                        k0(str);
                        IronSourceUtils.j0(str);
                        h0(progIsSmash);
                        return;
                    }
                    String str2 = "Advanced Loading: Won't start loading bidder " + progIsSmash.x() + " as a non bidder is being loaded";
                    k0(str2);
                    IronSourceUtils.j0(str2);
                    return;
                }
                h0(progIsSmash);
                i2++;
            }
        }
    }

    private void j0(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "ProgIsManager " + str, 0);
    }

    private void l0(ProgIsSmash progIsSmash, String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsManager " + progIsSmash.x() + " : " + str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        x0(MEDIATION_STATE.STATE_AUCTION);
        AsyncTask.execute(new a());
    }

    private void n0(int i2) {
        p0(i2, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i2, Object[][] objArr) {
        p0(i2, objArr, false);
    }

    private void p0(int i2, Object[][] objArr, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("provider", "Mediation");
        hashMap.put("programmatic", 1);
        if (!TextUtils.isEmpty(this.f5468j)) {
            hashMap.put("auctionId", this.f5468j);
        }
        JSONObject jSONObject = this.f5469k;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.f5469k);
        }
        if (z && !TextUtils.isEmpty(this.f5467i)) {
            hashMap.put("placement", this.f5467i);
        }
        if (y0(i2)) {
            InterstitialEventsManager.getInstance().W(hashMap, this.t, this.u);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    hashMap.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                k0("sendMediationEvent " + e2.getMessage());
            }
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(hashMap)));
    }

    private void q0(int i2) {
        p0(i2, null, true);
    }

    private void r0(int i2, Object[][] objArr) {
        p0(i2, objArr, true);
    }

    private void s0(int i2, ProgIsSmash progIsSmash) {
        u0(i2, progIsSmash, null, false);
    }

    private void t0(int i2, ProgIsSmash progIsSmash, Object[][] objArr) {
        u0(i2, progIsSmash, objArr, false);
    }

    private void u0(int i2, ProgIsSmash progIsSmash, Object[][] objArr, boolean z) {
        Map<String, Object> J = progIsSmash.J();
        if (!TextUtils.isEmpty(this.f5468j)) {
            J.put("auctionId", this.f5468j);
        }
        JSONObject jSONObject = this.f5469k;
        if (jSONObject != null && jSONObject.length() > 0) {
            J.put("genericParams", this.f5469k);
        }
        if (z && !TextUtils.isEmpty(this.f5467i)) {
            J.put("placement", this.f5467i);
        }
        if (y0(i2)) {
            InterstitialEventsManager.getInstance().W(J, this.t, this.u);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    J.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "IS sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(J)));
    }

    private void v0(int i2, ProgIsSmash progIsSmash) {
        u0(i2, progIsSmash, null, true);
    }

    private void w0(int i2, ProgIsSmash progIsSmash, Object[][] objArr) {
        u0(i2, progIsSmash, objArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(MEDIATION_STATE mediation_state) {
        this.c = mediation_state;
        k0("state=" + mediation_state);
    }

    private boolean y0(int i2) {
        return i2 == 2002 || i2 == 2003 || i2 == 2200 || i2 == 2213 || i2 == 2005 || i2 == 2204 || i2 == 2201 || i2 == 2203 || i2 == 2006 || i2 == 2004 || i2 == 2110 || i2 == 2301 || i2 == 2300;
    }

    private void z0(ProgIsSmash progIsSmash, String str) {
        x0(MEDIATION_STATE.STATE_SHOWING);
        progIsSmash.e0();
        v0(2201, progIsSmash);
        this.b.b(progIsSmash);
        if (this.b.c(progIsSmash)) {
            progIsSmash.b0();
            s0(2401, progIsSmash);
            IronSourceUtils.j0(progIsSmash.x() + " was session capped");
        }
        CappingManager.h(ContextProvider.getInstance().a(), str);
        if (CappingManager.n(ContextProvider.getInstance().a(), str)) {
            q0(2400);
        }
    }

    public synchronized void A0(String str) {
        MEDIATION_STATE mediation_state = this.c;
        if (mediation_state == MEDIATION_STATE.STATE_SHOWING) {
            j0("showInterstitial error: can't show ad while an ad is already showing");
            ISListenerWrapper.getInstance().i(new com.ironsource.mediationsdk.logger.b(1036, "showInterstitial error: can't show ad while an ad is already showing"));
            o0(2111, new Object[][]{new Object[]{"errorCode", 1036}, new Object[]{"reason", "showInterstitial error: can't show ad while an ad is already showing"}});
        } else if (mediation_state != MEDIATION_STATE.STATE_READY_TO_SHOW) {
            k0("showInterstitial() error state=" + this.c.toString());
            j0("showInterstitial error: show called while no ads are available");
            ISListenerWrapper.getInstance().i(new com.ironsource.mediationsdk.logger.b(509, "showInterstitial error: show called while no ads are available"));
            o0(2111, new Object[][]{new Object[]{"errorCode", 509}, new Object[]{"reason", "showInterstitial error: show called while no ads are available"}});
        } else if (str == null) {
            j0("showInterstitial error: empty default placement");
            ISListenerWrapper.getInstance().i(new com.ironsource.mediationsdk.logger.b(PointerIconCompat.TYPE_GRAB, "showInterstitial error: empty default placement"));
            o0(2111, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) PointerIconCompat.TYPE_GRAB)}, new Object[]{"reason", "showInterstitial error: empty default placement"}});
        } else {
            this.f5467i = str;
            q0(AdError.BROKEN_MEDIA_ERROR_CODE);
            if (CappingManager.n(ContextProvider.getInstance().a(), this.f5467i)) {
                String str2 = "placement " + this.f5467i + " is capped";
                j0(str2);
                ISListenerWrapper.getInstance().i(new com.ironsource.mediationsdk.logger.b(524, str2));
                r0(2111, new Object[][]{new Object[]{"errorCode", 524}, new Object[]{"reason", str2}});
                return;
            }
            Iterator<ProgIsSmash> it = this.f5463e.iterator();
            while (it.hasNext()) {
                ProgIsSmash next = it.next();
                if (next.W()) {
                    z0(next, this.f5467i);
                    return;
                }
                k0("showInterstitial " + next.x() + " isReadyToShow() == false");
            }
            ISListenerWrapper.getInstance().i(com.ironsource.mediationsdk.utils.f.f("Interstitial"));
            r0(2111, new Object[][]{new Object[]{"errorCode", 509}, new Object[]{"reason", "Show Fail - No ads to show"}});
        }
    }

    @Override // com.ironsource.mediationsdk.a0
    public void D(ProgIsSmash progIsSmash) {
        synchronized (this) {
            l0(progIsSmash, "onInterstitialAdOpened");
            ISListenerWrapper.getInstance().g();
            v0(2005, progIsSmash);
            if (this.n) {
                f fVar = this.f5464f.get(progIsSmash.x());
                if (fVar != null) {
                    this.o.f(fVar, progIsSmash.E(), this.f5466h, this.f5467i);
                    this.f5465g.put(progIsSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
                    Q(fVar, this.f5467i);
                } else {
                    String x = progIsSmash != null ? progIsSmash.x() : "Smash is null";
                    k0("onInterstitialAdOpened showing instance " + x + " missing from waterfall");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Showing missing ");
                    sb.append(this.c);
                    o0(82317, new Object[][]{new Object[]{"errorCode", 1011}, new Object[]{"reason", sb.toString()}, new Object[]{"ext1", x}});
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.a0
    public void F(ProgIsSmash progIsSmash) {
        synchronized (this) {
            l0(progIsSmash, "onInterstitialAdClosed");
            w0(2204, progIsSmash, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(SessionDepthManager.getInstance().b(2))}});
            SessionDepthManager.getInstance().d(2);
            ISListenerWrapper.getInstance().e();
            x0(MEDIATION_STATE.STATE_READY_TO_LOAD);
        }
    }

    @Override // com.ironsource.mediationsdk.a0
    public void G(ProgIsSmash progIsSmash) {
        l0(progIsSmash, "onInterstitialAdClicked");
        ISListenerWrapper.getInstance().d();
        v0(AdError.INTERNAL_ERROR_2006, progIsSmash);
    }

    @Override // com.ironsource.mediationsdk.d
    public void I(List<f> list, String str, f fVar, JSONObject jSONObject, int i2, long j2) {
        this.f5468j = str;
        this.f5466h = fVar;
        this.f5469k = jSONObject;
        this.t = i2;
        this.u = "";
        o0(2301, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        B0(list);
        i0();
    }

    @Override // com.ironsource.mediationsdk.a0
    public void K(com.ironsource.mediationsdk.logger.b bVar, ProgIsSmash progIsSmash) {
        t0(2206, progIsSmash, new Object[][]{new Object[]{"reason", bVar.b()}});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(Context context, boolean z) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "Should Track Network State: " + z, 0);
        this.v = z;
    }

    @Override // com.ironsource.mediationsdk.a0
    public void N(ProgIsSmash progIsSmash) {
        l0(progIsSmash, "onInterstitialAdShowSucceeded");
        ISListenerWrapper.getInstance().j();
        v0(2202, progIsSmash);
    }

    @Override // com.ironsource.mediationsdk.a0
    public void d(ProgIsSmash progIsSmash) {
        s0(2205, progIsSmash);
    }

    @Override // com.ironsource.mediationsdk.d
    public void f(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        k0(str3);
        IronSourceUtils.j0("IS: " + str3);
        this.t = i3;
        this.u = str2;
        this.f5469k = null;
        C0();
        if (TextUtils.isEmpty(str)) {
            o0(2300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        } else {
            o0(2300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        }
        i0();
    }

    public synchronized boolean f0() {
        if ((!this.v || IronSourceUtils.S(ContextProvider.getInstance().a())) && this.c == MEDIATION_STATE.STATE_READY_TO_SHOW) {
            Iterator<ProgIsSmash> it = this.f5463e.iterator();
            while (it.hasNext()) {
                if (it.next().W()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public synchronized void g0() {
        MEDIATION_STATE mediation_state = this.c;
        if (mediation_state == MEDIATION_STATE.STATE_SHOWING) {
            com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.API, "loadInterstitial: load cannot be invoked while showing an ad", 3);
            ISListenerWrapper.getInstance().f(new com.ironsource.mediationsdk.logger.b(1037, "loadInterstitial: load cannot be invoked while showing an ad"));
        } else if ((mediation_state != MEDIATION_STATE.STATE_READY_TO_LOAD && mediation_state != MEDIATION_STATE.STATE_READY_TO_SHOW) || CallbackThrottler.getInstance().c()) {
            k0("loadInterstitial: load is already in progress");
        } else {
            this.f5468j = "";
            this.f5467i = "";
            this.f5469k = null;
            n0(AdError.INTERNAL_ERROR_CODE);
            this.s = new Date().getTime();
            if (this.n) {
                if (!this.f5465g.isEmpty()) {
                    this.p.b(this.f5465g);
                    this.f5465g.clear();
                }
                m0();
            } else {
                C0();
                i0();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.a0
    public void i(com.ironsource.mediationsdk.logger.b bVar, ProgIsSmash progIsSmash) {
        synchronized (this) {
            l0(progIsSmash, "onInterstitialAdShowFailed error=" + bVar.b());
            ISListenerWrapper.getInstance().i(bVar);
            w0(2203, progIsSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
            this.f5465g.put(progIsSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToShow);
            x0(MEDIATION_STATE.STATE_READY_TO_LOAD);
        }
    }

    @Override // com.ironsource.mediationsdk.a0
    public void p(ProgIsSmash progIsSmash, long j2) {
        synchronized (this) {
            l0(progIsSmash, "onInterstitialAdReady");
            t0(AdError.INTERNAL_ERROR_2003, progIsSmash, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
            if (progIsSmash != null && this.f5465g.containsKey(progIsSmash.x())) {
                this.f5465g.put(progIsSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceLoadedSuccessfully);
            }
            if (this.c == MEDIATION_STATE.STATE_LOADING_SMASHES) {
                x0(MEDIATION_STATE.STATE_READY_TO_SHOW);
                ISListenerWrapper.getInstance().h();
                o0(AdError.INTERNAL_ERROR_2004, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - this.s)}});
                if (this.n) {
                    f fVar = this.f5464f.get(progIsSmash.x());
                    if (fVar != null) {
                        this.o.g(fVar, progIsSmash.E(), this.f5466h);
                        this.o.e(this.f5463e, this.f5464f, progIsSmash.E(), this.f5466h, fVar);
                    } else {
                        String x = progIsSmash != null ? progIsSmash.x() : "Smash is null";
                        k0("onInterstitialAdReady winner instance " + x + " missing from waterfall");
                        o0(82317, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{"ext1", x}});
                    }
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.a0
    public void u(com.ironsource.mediationsdk.logger.b bVar, ProgIsSmash progIsSmash, long j2) {
        CopyOnWriteArrayList<ProgIsSmash> copyOnWriteArrayList = new CopyOnWriteArrayList();
        synchronized (this) {
            l0(progIsSmash, "onInterstitialAdLoadFailed error=" + bVar.b() + " state=" + this.c.name());
            if (bVar.a() == 1158) {
                t0(2213, progIsSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
            } else {
                t0(2200, progIsSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
            }
            if (progIsSmash != null && this.f5465g.containsKey(progIsSmash.x())) {
                this.f5465g.put(progIsSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
            }
            Iterator<ProgIsSmash> it = this.f5463e.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                ProgIsSmash next = it.next();
                if (next.F()) {
                    if (this.m && next.L()) {
                        if (!z && !z2) {
                            String str = "Advanced Loading: Starting to load bidder " + next.x() + ". No other instances will be loaded at the same time.";
                            k0(str);
                            IronSourceUtils.j0(str);
                        }
                        String str2 = "Advanced Loading: Won't start loading bidder " + next.x() + " as " + (z ? "a non bidder is being loaded" : "a non bidder was already loaded successfully");
                        k0(str2);
                        IronSourceUtils.j0(str2);
                    }
                    copyOnWriteArrayList.add(next);
                    if (this.m) {
                        if (progIsSmash.L()) {
                            if (next.L()) {
                                break;
                            } else if (copyOnWriteArrayList.size() >= this.f5470l) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else if (!next.V()) {
                    if (next.W()) {
                        z2 = true;
                    }
                }
                z = true;
            }
            if (copyOnWriteArrayList.size() == 0 && this.c == MEDIATION_STATE.STATE_LOADING_SMASHES && !z) {
                CallbackThrottler.getInstance().f(new com.ironsource.mediationsdk.logger.b(509, "No ads to show"));
                o0(2110, new Object[][]{new Object[]{"errorCode", 509}});
                x0(MEDIATION_STATE.STATE_READY_TO_LOAD);
            }
        }
        IronLog.INTERNAL.verbose("smashesToLoad.size() = " + copyOnWriteArrayList.size());
        for (ProgIsSmash progIsSmash2 : copyOnWriteArrayList) {
            h0(progIsSmash2);
        }
    }

    @Override // com.ironsource.mediationsdk.a0
    public void y(ProgIsSmash progIsSmash) {
        l0(progIsSmash, "onInterstitialAdVisible");
    }
}
