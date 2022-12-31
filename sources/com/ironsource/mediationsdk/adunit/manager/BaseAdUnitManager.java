package com.ironsource.mediationsdk.adunit.manager;

import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.ironsource.mediationsdk.AdapterRepository;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.CallbackThrottler;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.events.AdUnitEvents;
import com.ironsource.mediationsdk.adunit.events.AdUnitEventsWrapper;
import com.ironsource.mediationsdk.adunit.events.g;
import com.ironsource.mediationsdk.adunit.smash.BaseAdUnitSmash;
import com.ironsource.mediationsdk.e;
import com.ironsource.mediationsdk.f;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.l;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import com.ironsource.mediationsdk.utils.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes2.dex */
public abstract class BaseAdUnitManager<Smash extends BaseAdUnitSmash> implements c, com.ironsource.mediationsdk.d, com.ironsource.mediationsdk.adunit.events.b {
    protected CopyOnWriteArrayList<Smash> a;
    protected ConcurrentHashMap<String, f> b;
    protected ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> c;

    /* renamed from: d  reason: collision with root package name */
    protected e f5508d;

    /* renamed from: e  reason: collision with root package name */
    protected AuctionHistory f5509e;

    /* renamed from: f  reason: collision with root package name */
    protected String f5510f;

    /* renamed from: g  reason: collision with root package name */
    protected int f5511g;

    /* renamed from: i  reason: collision with root package name */
    protected JSONObject f5513i;

    /* renamed from: j  reason: collision with root package name */
    protected f f5514j;

    /* renamed from: k  reason: collision with root package name */
    protected String f5515k;
    protected m m;
    protected com.ironsource.mediationsdk.utils.e n;
    protected com.ironsource.mediationsdk.utils.e o;
    protected com.ironsource.mediationsdk.adunit.manager.a p;
    protected ManagerState q;
    protected AdUnitEventsWrapper r;
    protected com.ironsource.mediationsdk.adunit.manager.b s;
    private Set<com.ironsource.mediationsdk.l0.c> u;

    /* renamed from: h  reason: collision with root package name */
    protected String f5512h = "";

    /* renamed from: l  reason: collision with root package name */
    protected boolean f5516l = false;
    private final Object t = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum ManagerState {
        NONE,
        READY_TO_LOAD,
        AUCTION,
        LOADING,
        READY_TO_SHOW,
        SHOWING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BaseAdUnitManager.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseAdUnitManager baseAdUnitManager = BaseAdUnitManager.this;
            baseAdUnitManager.f5510f = "";
            baseAdUnitManager.f5513i = new JSONObject();
            BaseAdUnitManager.this.r.f5504g.d();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            for (l lVar : BaseAdUnitManager.this.p.g()) {
                if (!BaseAdUnitManager.this.m.c(new com.ironsource.mediationsdk.utils.l(lVar.k(), lVar.i(BaseAdUnitManager.this.p.a())))) {
                    if (lVar.q(BaseAdUnitManager.this.p.a())) {
                        com.ironsource.mediationsdk.j0.a.c.a j2 = AdapterRepository.getInstance().j(lVar, BaseAdUnitManager.this.p.a());
                        if (j2 instanceof com.ironsource.mediationsdk.j0.a.c.c) {
                            try {
                                Map<String, Object> k2 = ((com.ironsource.mediationsdk.j0.a.c.c) j2).k(ContextProvider.getInstance().a());
                                if (k2 != null) {
                                    hashMap.put(lVar.k(), k2);
                                    sb.append(lVar.f(BaseAdUnitManager.this.p.a()) + lVar.k() + ",");
                                } else {
                                    g gVar = BaseAdUnitManager.this.r.f5506i;
                                    gVar.e("missing bidding data for " + lVar.k());
                                }
                            } catch (Exception e2) {
                                g gVar2 = BaseAdUnitManager.this.r.f5506i;
                                gVar2.g("exception while calling networkAdapter.getBiddingData - " + e2);
                            }
                        } else {
                            BaseAdUnitManager.this.r.f5506i.g(j2 == null ? "could not load network adapter" : "network adapter does not implementing AdapterBidderInterface");
                        }
                    } else {
                        arrayList.add(lVar.k());
                        sb.append(lVar.f(BaseAdUnitManager.this.p.a()) + lVar.k() + ",");
                    }
                }
            }
            IronLog ironLog = IronLog.INTERNAL;
            BaseAdUnitManager baseAdUnitManager2 = BaseAdUnitManager.this;
            ironLog.verbose(baseAdUnitManager2.o("auction waterfallString = " + ((Object) sb)));
            if (hashMap.size() == 0 && arrayList.size() == 0) {
                ironLog.verbose(BaseAdUnitManager.this.o("auction failed - no candidates"));
                BaseAdUnitManager.this.r.f5504g.c(0L, CloseFrame.NOCODE, "No candidates available for auctioning");
                CallbackThrottler.getInstance().f(new com.ironsource.mediationsdk.logger.b(CloseFrame.NOCODE, "No candidates available for auctioning"));
                BaseAdUnitManager.this.r.f5503f.c(0L, CloseFrame.NOCODE, "No candidates available for auctioning");
                BaseAdUnitManager.this.J(ManagerState.READY_TO_LOAD);
                return;
            }
            BaseAdUnitManager.this.r.f5504g.e(sb.toString());
            BaseAdUnitManager baseAdUnitManager3 = BaseAdUnitManager.this;
            if (baseAdUnitManager3.f5508d != null) {
                BaseAdUnitManager.this.f5508d.a(ContextProvider.getInstance().a(), hashMap, arrayList, BaseAdUnitManager.this.f5509e, SessionDepthManager.getInstance().c(BaseAdUnitManager.this.p.a()));
            } else {
                ironLog.error(baseAdUnitManager3.o("mAuctionHandler is null"));
            }
        }
    }

    public BaseAdUnitManager(com.ironsource.mediationsdk.adunit.manager.a aVar, Set<com.ironsource.mediationsdk.l0.c> set) {
        this.u = new HashSet();
        com.ironsource.mediationsdk.utils.e eVar = new com.ironsource.mediationsdk.utils.e();
        this.p = aVar;
        this.r = new AdUnitEventsWrapper(aVar.a(), AdUnitEventsWrapper.Level.MEDIATION, this);
        this.s = new com.ironsource.mediationsdk.adunit.manager.b(this.p.a());
        J(ManagerState.NONE);
        this.u = set;
        this.r.f5502e.d();
        this.a = new CopyOnWriteArrayList<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.f5515k = "";
        CallbackThrottler.getInstance().h(this.p.e());
        this.f5510f = "";
        this.f5513i = new JSONObject();
        if (this.p.k()) {
            this.f5508d = new e(this.p.a().toString(), this.p.d(), this);
        }
        w(this.p.g(), this.p.d().d());
        y();
        x();
        this.n = new com.ironsource.mediationsdk.utils.e();
        J(ManagerState.READY_TO_LOAD);
        this.r.f5502e.c(com.ironsource.mediationsdk.utils.e.a(eVar));
    }

    private boolean A() {
        boolean z;
        synchronized (this.t) {
            z = this.q == ManagerState.AUCTION;
        }
        return z;
    }

    private boolean B() {
        boolean z;
        synchronized (this.t) {
            z = this.q == ManagerState.LOADING;
        }
        return z;
    }

    private void D(Smash smash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o("smash = " + smash.j()));
        String g2 = this.b.get(smash.x()).g();
        smash.v(g2);
        smash.r(g2);
    }

    private void E() {
        IronLog.INTERNAL.verbose(o("mWaterfall.size() = " + this.a.size()));
        J(ManagerState.LOADING);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= this.a.size() || i3 >= this.p.f()) {
                break;
            }
            Smash smash = this.a.get(i2);
            if (smash.o()) {
                if (!smash.n() && !smash.p()) {
                    if (!this.p.b() || !smash.m()) {
                        D(smash);
                    } else if (i3 == 0) {
                        String str = "Advanced Loading: Starting to load bidder " + smash.x() + ". No other instances will be loaded at the same time.";
                        IronLog.INTERNAL.verbose(o(str));
                        IronSourceUtils.j0(str);
                        D(smash);
                        i3++;
                    } else {
                        String str2 = "Advanced Loading: Won't start loading bidder " + smash.x() + " as a non bidder is being loaded";
                        IronLog.INTERNAL.verbose(o(str2));
                        IronSourceUtils.j0(str2);
                    }
                } else {
                    IronLog.INTERNAL.verbose("smash = " + smash.j());
                }
                i3++;
            }
            i2++;
        }
        if (i3 == 0) {
            u();
        }
    }

    private void F() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o(""));
        J(ManagerState.AUCTION);
        long m = this.p.d().m() - com.ironsource.mediationsdk.utils.e.a(this.n);
        if (m > 0) {
            ironLog.verbose(o("waiting before auction - timeToWaitBeforeAuction = " + m));
            new Timer().schedule(new a(), m);
            return;
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        IronLog.INTERNAL.verbose(o(""));
        AsyncTask.execute(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(ManagerState managerState) {
        synchronized (this.t) {
            this.q = managerState;
        }
    }

    private boolean K(AdUnitEvents adUnitEvents) {
        return adUnitEvents == AdUnitEvents.LOAD_AD_SUCCESS || adUnitEvents == AdUnitEvents.LOAD_AD_FAILED || adUnitEvents == AdUnitEvents.AUCTION_SUCCESS || adUnitEvents == AdUnitEvents.AUCTION_FAILED;
    }

    private void N(Smash smash, String str) {
        J(ManagerState.SHOWING);
        smash.z(str);
    }

    private String O(List<f> list) {
        IronLog.INTERNAL.verbose(o("waterfall.size() = " + list.size()));
        m();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            f fVar = list.get(i2);
            l(fVar);
            sb.append(q(fVar));
            if (i2 != list.size() - 1) {
                sb.append(",");
            }
        }
        String str = "updateWaterfall() - next waterfall is " + sb.toString();
        IronLog.INTERNAL.verbose(o(str));
        IronSourceUtils.j0(s(this.p.a()) + ": " + str);
        return sb.toString();
    }

    private void P() {
        IronLog.INTERNAL.verbose(o(""));
        List<f> r = r();
        this.f5510f = t();
        O(r);
    }

    private void l(f fVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o("item = " + fVar.c()));
        l h2 = this.p.h(fVar.c());
        if (h2 != null) {
            com.ironsource.mediationsdk.j0.a.c.d<?> a2 = AdapterRepository.getInstance().a(h2, this.p.a());
            if (a2 != null) {
                Smash p = p(h2, a2, SessionDepthManager.getInstance().c(this.p.a()));
                this.a.add(p);
                this.b.put(p.x(), fVar);
                this.c.put(fVar.c(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
                return;
            }
            String str = "addSmashToWaterfall - could not load ad adapter for " + h2.k();
            ironLog.error(o(str));
            this.r.f5506i.c(str);
            return;
        }
        String str2 = "could not find matching provider settings for auction response item - item = " + fVar.c();
        ironLog.error(o(str2));
        this.r.f5506i.i(str2);
    }

    private void m() {
        Iterator<Smash> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().t();
        }
        this.a.clear();
    }

    private boolean n(ManagerState managerState, ManagerState managerState2) {
        boolean z;
        synchronized (this.t) {
            if (this.q == managerState) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(o("set state from '" + this.q + "' to '" + managerState2 + "'"));
                z = true;
                this.q = managerState2;
            } else {
                z = false;
            }
        }
        return z;
    }

    private List<f> r() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (l lVar : this.p.g()) {
            com.ironsource.mediationsdk.utils.l lVar2 = new com.ironsource.mediationsdk.utils.l(lVar.k(), lVar.i(this.p.a()));
            if (!lVar.q(this.p.a()) && !this.m.c(lVar2)) {
                copyOnWriteArrayList.add(new f(lVar2.x()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void u() {
        String str;
        int i2;
        J(ManagerState.READY_TO_LOAD);
        if (this.a.isEmpty()) {
            i2 = 1035;
            str = "Empty waterfall";
        } else {
            str = "Mediation No fill";
            i2 = 509;
        }
        this.r.f5503f.c(0L, i2, str);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o("errorCode = " + i2 + ", errorReason = " + str));
        CallbackThrottler.getInstance().f(new com.ironsource.mediationsdk.logger.b(i2, str));
    }

    private void v(com.ironsource.mediationsdk.logger.b bVar) {
        this.r.f5505h.i(this.f5515k, bVar.a(), bVar.b());
        this.s.f(bVar);
    }

    private void w(List<l> list, int i2) {
        ArrayList arrayList = new ArrayList();
        for (l lVar : list) {
            arrayList.add(lVar.l());
        }
        this.f5509e = new AuctionHistory(arrayList, i2);
    }

    private void x() {
        for (l lVar : this.p.g()) {
            if (lVar.s() || lVar.q(this.p.a())) {
                HashMap hashMap = new HashMap();
                hashMap.put(GuestProfileFragment.USER_ID, this.p.j());
                hashMap.putAll(com.ironsource.mediationsdk.q0.a.b(lVar.h()));
                com.ironsource.mediationsdk.adunit.adapter.utility.a aVar = new com.ironsource.mediationsdk.adunit.adapter.utility.a(null, hashMap);
                com.ironsource.mediationsdk.j0.a.c.a j2 = AdapterRepository.getInstance().j(lVar, this.p.a());
                if (j2 != null) {
                    try {
                        j2.l(aVar, ContextProvider.getInstance().a(), null);
                    } catch (Exception e2) {
                        g gVar = this.r.f5506i;
                        gVar.g("initNetworks - exception while calling networkAdapter.init - " + e2);
                    }
                } else {
                    this.r.f5506i.g("initNetworks - could not load network adapter");
                }
            }
        }
    }

    private void y() {
        ArrayList arrayList = new ArrayList();
        for (l lVar : this.p.g()) {
            arrayList.add(new com.ironsource.mediationsdk.utils.l(lVar.k(), lVar.i(this.p.a())));
        }
        this.m = new m(arrayList);
    }

    public void C() {
        IronLog.INTERNAL.verbose(o(""));
        ManagerState managerState = this.q;
        if (managerState == ManagerState.SHOWING) {
            IronLog.API.error(o("load cannot be invoked while showing an ad"));
            this.s.c(new com.ironsource.mediationsdk.logger.b(1037, "load cannot be invoked while showing an ad"));
        } else if ((managerState != ManagerState.READY_TO_LOAD && managerState != ManagerState.READY_TO_SHOW) || CallbackThrottler.getInstance().c()) {
            IronLog.API.error(o("load is already in progress"));
        } else {
            this.f5510f = "";
            this.f5515k = "";
            this.f5513i = new JSONObject();
            this.r.f5503f.d();
            this.o = new com.ironsource.mediationsdk.utils.e();
            if (this.p.k()) {
                if (!this.c.isEmpty()) {
                    this.f5509e.b(this.c);
                    this.c.clear();
                }
                F();
                return;
            }
            P();
            E();
        }
    }

    protected void H(f fVar, String str) {
        if (fVar != null) {
            com.ironsource.mediationsdk.l0.b b2 = fVar.b(str);
            if (b2 != null) {
                for (com.ironsource.mediationsdk.l0.c cVar : this.u) {
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info(o("onImpressionSuccess " + cVar.getClass().getSimpleName() + ": " + b2));
                    cVar.a(b2);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose(o("no auctionResponseItem or listener"));
    }

    @Override // com.ironsource.mediationsdk.d
    public void I(List<f> list, String str, f fVar, JSONObject jSONObject, int i2, long j2) {
        IronLog.INTERNAL.verbose(o(""));
        if (A()) {
            this.f5512h = "";
            this.f5510f = str;
            this.f5511g = i2;
            this.f5514j = fVar;
            this.f5513i = jSONObject;
            this.r.f5504g.g(j2);
            this.r.f5504g.f(O(list));
            E();
            return;
        }
        g gVar = this.r.f5506i;
        gVar.k("unexpected auction success for auctionId - " + str);
    }

    public void L(boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o("track = " + z));
        this.f5516l = z;
    }

    public void M(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o("state = " + this.q));
        this.f5515k = str;
        this.r.f5505h.h(str);
        ManagerState managerState = this.q;
        com.ironsource.mediationsdk.logger.b bVar = managerState == ManagerState.SHOWING ? new com.ironsource.mediationsdk.logger.b(1036, "can't show ad while an ad is already showing") : null;
        if (managerState != ManagerState.READY_TO_SHOW) {
            bVar = new com.ironsource.mediationsdk.logger.b(509, "show called while no ads are available");
        }
        if (str == null) {
            bVar = new com.ironsource.mediationsdk.logger.b(PointerIconCompat.TYPE_GRAB, "empty default placement");
        }
        if (CappingManager.q(ContextProvider.getInstance().a(), str, this.p.a())) {
            bVar = new com.ironsource.mediationsdk.logger.b(524, "placement " + str + " is capped");
        }
        if (bVar != null) {
            IronLog.API.error(o(bVar.b()));
            v(bVar);
            return;
        }
        Iterator<Smash> it = this.a.iterator();
        while (it.hasNext()) {
            Smash next = it.next();
            if (next.p()) {
                N(next, this.f5515k);
                return;
            }
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose(o(next.j() + " - not ready to show"));
        }
        v(com.ironsource.mediationsdk.utils.f.f(this.p.a().toString()));
    }

    @Override // com.ironsource.mediationsdk.adunit.manager.c
    public void a(BaseAdUnitSmash baseAdUnitSmash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o(baseAdUnitSmash.j()));
        this.m.b(baseAdUnitSmash);
        if (this.m.c(baseAdUnitSmash)) {
            ironLog.verbose(o(baseAdUnitSmash.x() + " was session capped"));
            baseAdUnitSmash.u();
            IronSourceUtils.j0(baseAdUnitSmash.x() + " was session capped");
        }
        CappingManager.j(ContextProvider.getInstance().a(), this.f5515k, this.p.a());
        if (CappingManager.q(ContextProvider.getInstance().a(), this.f5515k, this.p.a())) {
            ironLog.verbose(o("placement " + this.f5515k + " is capped"));
            this.r.f5505h.f(this.f5515k);
        }
        this.s.e();
        SessionDepthManager.getInstance().e(this.p.a());
        if (this.p.k()) {
            f fVar = this.b.get(baseAdUnitSmash.x());
            if (fVar != null) {
                this.f5508d.f(fVar, baseAdUnitSmash.k(), this.f5514j, this.f5515k);
                this.c.put(baseAdUnitSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
                H(fVar, this.f5515k);
                return;
            }
            String str = "showing instance missing from waterfall - " + (baseAdUnitSmash != null ? baseAdUnitSmash.x() : "Smash is null");
            ironLog.verbose(o(str));
            this.r.f5506i.h(1011, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.manager.c
    public void b(BaseAdUnitSmash baseAdUnitSmash) {
        IronLog.INTERNAL.verbose(o(baseAdUnitSmash.j()));
        J(ManagerState.READY_TO_LOAD);
        this.s.b();
    }

    @Override // com.ironsource.mediationsdk.adunit.manager.c
    public void c(BaseAdUnitSmash baseAdUnitSmash) {
        IronLog.INTERNAL.verbose(o(baseAdUnitSmash.j()));
        this.s.g();
    }

    @Override // com.ironsource.mediationsdk.adunit.events.b
    public Map<String, Object> d(AdUnitEvents adUnitEvents) {
        HashMap hashMap = new HashMap();
        hashMap.put("provider", "Mediation");
        hashMap.put("programmatic", 1);
        if (!TextUtils.isEmpty(this.f5510f)) {
            hashMap.put("auctionId", this.f5510f);
        }
        JSONObject jSONObject = this.f5513i;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.f5513i);
        }
        hashMap.put("sessionDepth", Integer.valueOf(SessionDepthManager.getInstance().c(this.p.a())));
        if (K(adUnitEvents)) {
            hashMap.put("auctionTrials", Integer.valueOf(this.f5511g));
            if (!TextUtils.isEmpty(this.f5512h)) {
                hashMap.put("auctionFallback", this.f5512h);
            }
        }
        return hashMap;
    }

    @Override // com.ironsource.mediationsdk.adunit.manager.c
    public void e(com.ironsource.mediationsdk.logger.b bVar, BaseAdUnitSmash baseAdUnitSmash, long j2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o(baseAdUnitSmash.j() + " - error = " + bVar));
        this.c.put(baseAdUnitSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
        if (B()) {
            E();
            return;
        }
        g gVar = this.r.f5506i;
        gVar.n("unexpected load failed for smash - " + baseAdUnitSmash.j() + ", error - " + bVar);
    }

    @Override // com.ironsource.mediationsdk.d
    public void f(int i2, String str, int i3, String str2, long j2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o(""));
        if (A()) {
            String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
            ironLog.verbose(o(str3));
            IronSourceUtils.j0(s(this.p.a()) + ": " + str3);
            this.f5511g = i3;
            this.f5512h = str2;
            this.f5513i = new JSONObject();
            P();
            this.r.f5504g.c(j2, i2, str);
            E();
            return;
        }
        this.r.f5506i.j("unexpected auction fail - error = " + i2 + ", " + str);
    }

    @Override // com.ironsource.mediationsdk.adunit.manager.c
    public void g(com.ironsource.mediationsdk.logger.b bVar, BaseAdUnitSmash baseAdUnitSmash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o(baseAdUnitSmash.j() + " - error = " + bVar));
        this.c.put(baseAdUnitSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToShow);
        J(ManagerState.READY_TO_LOAD);
        v(bVar);
    }

    @Override // com.ironsource.mediationsdk.adunit.manager.c
    public void h(BaseAdUnitSmash baseAdUnitSmash) {
        IronLog.INTERNAL.verbose(o(baseAdUnitSmash.j()));
        this.s.a();
    }

    @Override // com.ironsource.mediationsdk.adunit.manager.c
    public void i(BaseAdUnitSmash baseAdUnitSmash, long j2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(o(baseAdUnitSmash.j()));
        this.c.put(baseAdUnitSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceLoadedSuccessfully);
        if (n(ManagerState.LOADING, ManagerState.READY_TO_SHOW)) {
            this.s.d();
            this.r.f5503f.f(com.ironsource.mediationsdk.utils.e.a(this.o));
            if (this.p.k()) {
                f fVar = this.b.get(baseAdUnitSmash.x());
                if (fVar != null) {
                    this.f5508d.g(fVar, baseAdUnitSmash.k(), this.f5514j);
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<Smash> it = this.a.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().x());
                    }
                    this.f5508d.d(arrayList, this.b, baseAdUnitSmash.k(), this.f5514j, fVar);
                    return;
                }
                String str = "winner instance missing from waterfall - " + (baseAdUnitSmash != null ? baseAdUnitSmash.x() : "Smash is null");
                ironLog.verbose(o(str));
                this.r.f5506i.h(1010, str);
                return;
            }
            return;
        }
        this.r.f5506i.o("unexpected load success for smash - " + baseAdUnitSmash.j());
    }

    protected String o(String str) {
        String name = this.p.a().name();
        if (TextUtils.isEmpty(str)) {
            return name;
        }
        return name + " - " + str;
    }

    protected abstract Smash p(l lVar, com.ironsource.mediationsdk.j0.a.c.d<?> dVar, int i2);

    protected String q(f fVar) {
        Object[] objArr = new Object[2];
        objArr[0] = TextUtils.isEmpty(fVar.g()) ? "1" : "2";
        objArr[1] = fVar.c();
        return String.format("%s%s", objArr);
    }

    protected String s(IronSource.AD_UNIT ad_unit) {
        return ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) ? "RV" : ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL) ? "IS" : ad_unit.equals(IronSource.AD_UNIT.BANNER) ? "BN" : "";
    }

    protected String t() {
        return "fallback_" + System.currentTimeMillis();
    }

    public boolean z() {
        synchronized (this.t) {
            if (this.q != ManagerState.READY_TO_SHOW) {
                return false;
            }
            if (!this.f5516l || IronSourceUtils.S(ContextProvider.getInstance().a())) {
                Iterator<Smash> it = this.a.iterator();
                while (it.hasNext()) {
                    if (it.next().p()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }
}
