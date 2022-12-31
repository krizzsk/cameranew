package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class LWSProgRvManager extends i implements w, g0, d, p, q, com.ironsource.environment.i {
    private i0 b;
    private ConcurrentHashMap<String, f> c;

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> f5422d;

    /* renamed from: e  reason: collision with root package name */
    private f f5423e;

    /* renamed from: f  reason: collision with root package name */
    private AuctionHistory f5424f;

    /* renamed from: g  reason: collision with root package name */
    private e f5425g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f5426h;

    /* renamed from: i  reason: collision with root package name */
    private f0 f5427i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5428j;

    /* renamed from: k  reason: collision with root package name */
    private long f5429k;

    /* renamed from: l  reason: collision with root package name */
    private String f5430l;
    private int m;
    private NetworkStateReceiver n;
    private boolean o;
    private final ConcurrentHashMap<String, LWSProgRvSmash> p;
    private com.ironsource.mediationsdk.utils.m q;
    private int r;
    private String s;
    private int t;
    private boolean u;
    private boolean v;
    private RV_MEDIATION_STATE w;
    private long x;
    private Boolean y;
    private final Object z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum RV_MEDIATION_STATE {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LWSProgRvManager.this.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LWSProgRvManager.this.n0("makeAuction()");
            LWSProgRvManager.this.f5429k = new Date().getTime();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            for (LWSProgRvSmash lWSProgRvSmash : LWSProgRvManager.this.p.values()) {
                if (!LWSProgRvManager.this.q.c(lWSProgRvSmash) && LWSProgRvManager.this.b.h(lWSProgRvSmash)) {
                    if (lWSProgRvSmash.L()) {
                        Map<String, Object> U = lWSProgRvSmash.U();
                        if (U != null) {
                            hashMap.put(lWSProgRvSmash.x(), U);
                            sb.append(lWSProgRvSmash.E() + lWSProgRvSmash.x() + ",");
                        }
                    } else {
                        arrayList.add(lWSProgRvSmash.x());
                        sb.append(lWSProgRvSmash.E() + lWSProgRvSmash.x() + ",");
                    }
                }
            }
            if (hashMap.keySet().size() == 0 && arrayList.size() == 0) {
                LWSProgRvManager.this.q0(1301, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) CloseFrame.NOCODE)}, new Object[]{TypedValues.TransitionType.S_DURATION, 0}}));
                LWSProgRvManager.this.n0("makeAuction() failed - No candidates available for auctioning");
                LWSProgRvManager.this.g0();
                return;
            }
            LWSProgRvManager lWSProgRvManager = LWSProgRvManager.this;
            lWSProgRvManager.n0("makeAuction() - request waterfall is: " + ((Object) sb));
            LWSProgRvManager.this.t0(1000);
            LWSProgRvManager.this.t0(1300);
            LWSProgRvManager.this.u0(1310, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"ext1", sb.toString()}}));
            LWSProgRvManager.this.f5425g.a(ContextProvider.getInstance().a(), hashMap, arrayList, LWSProgRvManager.this.f5424f, LWSProgRvManager.this.r);
        }
    }

    public LWSProgRvManager(List<com.ironsource.mediationsdk.model.l> list, com.ironsource.mediationsdk.model.s sVar, String str, String str2, HashSet<com.ironsource.mediationsdk.l0.c> hashSet) {
        super(hashSet);
        this.f5430l = "";
        this.o = false;
        this.r = 1;
        this.z = new Object();
        long time = new Date().getTime();
        t0(81312);
        v0(RV_MEDIATION_STATE.RV_STATE_INITIATING);
        this.y = null;
        this.t = sVar.g();
        this.u = sVar.i();
        this.s = "";
        this.f5426h = null;
        com.ironsource.mediationsdk.utils.b j2 = sVar.j();
        this.v = false;
        this.b = new i0(sVar.j().h(), sVar.j().k());
        this.c = new ConcurrentHashMap<>();
        this.f5422d = new ConcurrentHashMap<>();
        this.x = new Date().getTime();
        boolean z = j2.i() > 0;
        this.f5428j = z;
        if (z) {
            this.f5425g = new e("rewardedVideo", j2, this);
        }
        this.f5427i = new f0(j2, this);
        this.p = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        for (com.ironsource.mediationsdk.model.l lVar : list) {
            com.ironsource.mediationsdk.b f2 = AdapterRepository.getInstance().f(lVar, lVar.o(), false, false);
            if (f2 != null) {
                LWSProgRvSmash lWSProgRvSmash = new LWSProgRvSmash(str, str2, lVar, this, sVar.h(), f2, this.r);
                String x = lWSProgRvSmash.x();
                this.p.put(x, lWSProgRvSmash);
                arrayList.add(x);
            }
        }
        this.f5424f = new AuctionHistory(arrayList, j2.d());
        this.q = new com.ironsource.mediationsdk.utils.m(new ArrayList(this.p.values()));
        u0(81313, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - time)}}));
        i0(j2.m());
        n.c().d(this, sVar.d());
    }

    private List<f> e0() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (LWSProgRvSmash lWSProgRvSmash : this.p.values()) {
            if (!lWSProgRvSmash.L() && !this.q.c(lWSProgRvSmash) && this.b.h(lWSProgRvSmash)) {
                copyOnWriteArrayList.add(new f(lWSProgRvSmash.x()));
            }
        }
        return copyOnWriteArrayList;
    }

    private String f0(f fVar) {
        String str;
        LWSProgRvSmash lWSProgRvSmash = this.p.get(fVar.c());
        if (lWSProgRvSmash != null) {
            str = Integer.toString(lWSProgRvSmash.E());
        } else {
            str = TextUtils.isEmpty(fVar.g()) ? "1" : "2";
        }
        return str + fVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        v0(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
        if (!this.v) {
            p0(false, null);
        }
        this.f5427i.b();
    }

    private void i0(long j2) {
        if (this.q.a()) {
            n0("all smashes are capped");
            q0(81001, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 80001}, new Object[]{"reason", "all smashes are capped"}}));
            g0();
        } else if (this.f5428j) {
            if (!this.f5422d.isEmpty()) {
                this.f5424f.b(this.f5422d);
                this.f5422d.clear();
            }
            new Timer().schedule(new a(), j2);
        } else {
            n0("auction fallback flow starting");
            z0();
            if (this.b.b().isEmpty()) {
                n0("loadSmashes -  waterfall is empty");
                q0(81001, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}}));
                g0();
                return;
            }
            t0(1000);
            k0();
        }
    }

    private void j0(LWSProgRvSmash lWSProgRvSmash) {
        String g2 = this.c.get(lWSProgRvSmash.x()).g();
        lWSProgRvSmash.M(g2);
        lWSProgRvSmash.c0(g2);
    }

    private void k0() {
        if (this.b.b().isEmpty()) {
            n0("loadSmashes -  waterfall is empty");
            q0(81001, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}}));
            g0();
            return;
        }
        v0(RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.b.b().size() && i2 < this.t; i3++) {
            LWSProgRvSmash lWSProgRvSmash = this.b.b().get(i3);
            if (lWSProgRvSmash.F()) {
                if (this.u && lWSProgRvSmash.L()) {
                    if (i2 == 0) {
                        String str = "Advanced Loading: Starting to load bidder " + lWSProgRvSmash.x() + ". No other instances will be loaded at the same time.";
                        n0(str);
                        IronSourceUtils.j0(str);
                        j0(lWSProgRvSmash);
                        return;
                    }
                    String str2 = "Advanced Loading: Won't start loading bidder " + lWSProgRvSmash.x() + " as a non bidder is being loaded";
                    n0(str2);
                    IronSourceUtils.j0(str2);
                    return;
                }
                j0(lWSProgRvSmash);
                i2++;
            }
        }
    }

    private void l0(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "LWSProgRvManager: " + str, 3);
    }

    private void m0(LWSProgRvSmash lWSProgRvSmash, String str) {
        String str2 = lWSProgRvSmash.x() + " : " + str;
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + str2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "LWSProgRvManager: " + str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        synchronized (this.z) {
            RV_MEDIATION_STATE rv_mediation_state = this.w;
            RV_MEDIATION_STATE rv_mediation_state2 = RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS;
            if (rv_mediation_state != rv_mediation_state2) {
                v0(rv_mediation_state2);
                AsyncTask.execute(new b());
            }
        }
    }

    private void p0(boolean z, Map<String, Object> map) {
        synchronized (this.z) {
            Boolean bool = this.y;
            if (bool == null || bool.booleanValue() != z) {
                this.y = Boolean.valueOf(z);
                long time = new Date().getTime() - this.x;
                this.x = new Date().getTime();
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(time));
                q0(z ? 1111 : 1112, map);
                RVListenerWrapper.getInstance().k(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i2, Map<String, Object> map) {
        r0(i2, map, false, true);
    }

    private void r0(int i2, Map<String, Object> map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("provider", "Mediation");
        hashMap.put("programmatic", 2);
        if (z2 && !TextUtils.isEmpty(this.b.c())) {
            hashMap.put("auctionId", this.b.c());
        }
        JSONObject jSONObject = this.f5426h;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.f5426h);
        }
        if (z && !TextUtils.isEmpty(this.s)) {
            hashMap.put("placement", this.s);
        }
        if (w0(i2)) {
            RewardedVideoEventsManager.getInstance().W(hashMap, this.m, this.f5430l);
        }
        hashMap.put("sessionDepth", Integer.valueOf(this.r));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    hashMap.putAll(map);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i3 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                i3.d(ironSourceTag, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(hashMap)));
    }

    private void s0(int i2, Map<String, Object> map) {
        r0(i2, map, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(int i2) {
        r0(i2, null, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i2, Map<String, Object> map) {
        r0(i2, map, false, false);
    }

    private void v0(RV_MEDIATION_STATE rv_mediation_state) {
        n0("current state=" + this.w + ", new state=" + rv_mediation_state);
        this.w = rv_mediation_state;
    }

    private boolean w0(int i2) {
        return i2 == 1003 || i2 == 1302 || i2 == 1301;
    }

    private boolean x0(boolean z) {
        Boolean bool = this.y;
        if (bool == null) {
            return false;
        }
        return (z && !bool.booleanValue() && h0()) || (!z && this.y.booleanValue());
    }

    private void y0(List<f> list, String str, JSONObject jSONObject) {
        this.c.clear();
        this.f5422d.clear();
        CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (f fVar : list) {
            sb.append(f0(fVar) + ",");
            LWSProgRvSmash lWSProgRvSmash = this.p.get(fVar.c());
            if (lWSProgRvSmash != null) {
                com.ironsource.mediationsdk.b c = AdapterRepository.getInstance().c(lWSProgRvSmash.b.g());
                if (c != null) {
                    LWSProgRvSmash lWSProgRvSmash2 = new LWSProgRvSmash(lWSProgRvSmash, this, c, this.r, str, jSONObject, this.m, this.f5430l);
                    lWSProgRvSmash2.N(true);
                    copyOnWriteArrayList.add(lWSProgRvSmash2);
                    this.c.put(lWSProgRvSmash2.x(), fVar);
                    this.f5422d.put(fVar.c(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                n0("updateWaterfall() - could not find matching smash for auction response item " + fVar.c());
            }
        }
        this.b.i(copyOnWriteArrayList, str);
        if (this.b.a()) {
            q0(81318, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"reason", "waterfalls hold too many with size=" + this.b.d()}}));
        }
        String str2 = "updateWaterfall() - next waterfall is " + sb.toString();
        n0(str2);
        IronSourceUtils.j0("RV: " + str2);
        if (sb.length() == 0) {
            n0("Updated waterfall is empty");
        }
        q0(1311, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"ext1", sb.toString()}}));
    }

    private void z0() {
        List<f> e0 = e0();
        y0(e0, "fallback_" + System.currentTimeMillis(), this.f5426h);
    }

    @Override // com.ironsource.mediationsdk.q
    public void A() {
        v0(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
        p0(false, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 1057}, new Object[]{"reason", "loaded ads are expired"}}));
        i0(0L);
    }

    @Override // com.ironsource.mediationsdk.w
    public void B(LWSProgRvSmash lWSProgRvSmash) {
        m0(lWSProgRvSmash, "onRewardedVideoAdEnded");
        RVListenerWrapper.getInstance().f();
    }

    @Override // com.ironsource.mediationsdk.g0
    public void E() {
        n0("onLoadTriggered: RV load was triggered in " + this.w + " state");
        i0(0L);
    }

    @Override // com.ironsource.mediationsdk.d
    public void I(List<f> list, String str, f fVar, JSONObject jSONObject, int i2, long j2) {
        n0("makeAuction(): success");
        this.f5423e = fVar;
        this.m = i2;
        this.f5426h = jSONObject;
        this.f5430l = "";
        y0(list, str, jSONObject);
        q0(1302, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}}));
        k0();
    }

    @Override // com.ironsource.mediationsdk.p
    public void L(Context context, boolean z) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "LWSProgRvManager Should Track Network State: " + z, 0);
        this.o = z;
        if (z) {
            if (this.n == null) {
                this.n = new NetworkStateReceiver(context, this);
            }
            context.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else if (this.n != null) {
            context.getApplicationContext().unregisterReceiver(this.n);
        }
    }

    @Override // com.ironsource.mediationsdk.w
    public void b(LWSProgRvSmash lWSProgRvSmash) {
        m0(lWSProgRvSmash, "onRewardedVideoAdStarted");
        RVListenerWrapper.getInstance().j();
    }

    @Override // com.ironsource.environment.i
    public void c(boolean z) {
        if (this.o) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            i2.d(ironSourceTag, "Network Availability Changed To: " + z, 1);
            if (x0(z)) {
                p0(z, null);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.w
    public void e(LWSProgRvSmash lWSProgRvSmash) {
        CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList = new CopyOnWriteArrayList();
        synchronized (this.z) {
            m0(lWSProgRvSmash, "onLoadError mState=" + this.w);
            if (lWSProgRvSmash.T() == this.b.c() && this.w != RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS) {
                this.f5422d.put(lWSProgRvSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
                RV_MEDIATION_STATE rv_mediation_state = this.w;
                if (rv_mediation_state == RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES || rv_mediation_state == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                    Iterator<LWSProgRvSmash> it = this.b.b().iterator();
                    boolean z = false;
                    boolean z2 = false;
                    while (it.hasNext()) {
                        LWSProgRvSmash next = it.next();
                        if (next.F()) {
                            if (this.u && next.L()) {
                                if (!z && !z2) {
                                    String str = "Advanced Loading: Starting to load bidder " + next.x() + ". No other instances will be loaded at the same time.";
                                    n0(str);
                                    IronSourceUtils.j0(str);
                                }
                                String str2 = "Advanced Loading: Won't start loading bidder " + next.x() + " as " + (z ? "a non bidder is being loaded" : "a non bidder was already loaded successfully");
                                n0(str2);
                                IronSourceUtils.j0(str2);
                            }
                            if (this.c.get(next.x()) != null) {
                                copyOnWriteArrayList.add(next);
                                if (!this.u) {
                                    break;
                                } else if (!lWSProgRvSmash.L()) {
                                    break;
                                } else if (next.L()) {
                                    break;
                                } else {
                                    if (copyOnWriteArrayList.size() >= this.t) {
                                        break;
                                    }
                                    z = true;
                                }
                            } else {
                                continue;
                            }
                        } else if (next.Z()) {
                            z = true;
                        } else if (next.a0()) {
                            z2 = true;
                        }
                    }
                    if (copyOnWriteArrayList.size() == 0 && !z2 && !z) {
                        n0("onLoadError(): No other available smashes");
                        if (!this.v) {
                            p0(false, null);
                        }
                        v0(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
                        this.f5427i.b();
                    }
                    for (LWSProgRvSmash lWSProgRvSmash2 : copyOnWriteArrayList) {
                        j0(lWSProgRvSmash2);
                    }
                    return;
                }
                return;
            }
            n0("onLoadError was invoked with auctionId:" + lWSProgRvSmash.T() + " and the current id is " + this.b.c());
            StringBuilder sb = new StringBuilder();
            sb.append("loadError wrong auction ID ");
            sb.append(this.w);
            lWSProgRvSmash.g0(81315, new Object[][]{new Object[]{"errorCode", 4}, new Object[]{"reason", sb.toString()}});
        }
    }

    @Override // com.ironsource.mediationsdk.d
    public void f(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        n0(str3);
        IronSourceUtils.j0("RV: " + str3);
        this.m = i3;
        this.f5430l = str2;
        this.f5426h = null;
        z0();
        if (TextUtils.isEmpty(str)) {
            q0(1301, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}}));
        } else {
            q0(1301, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}}));
        }
        k0();
    }

    public boolean h0() {
        if ((!this.o || IronSourceUtils.S(ContextProvider.getInstance().a())) && this.w == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW && !this.v) {
            Iterator<LWSProgRvSmash> it = this.b.b().iterator();
            while (it.hasNext()) {
                if (it.next().a0()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.w
    public void s(com.ironsource.mediationsdk.logger.b bVar, LWSProgRvSmash lWSProgRvSmash) {
        m0(lWSProgRvSmash, "onRewardedVideoAdShowFailed error=" + bVar.b());
        this.v = false;
        s0(1113, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}}));
        RVListenerWrapper.getInstance().i(bVar);
        this.f5422d.put(lWSProgRvSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToShow);
        if (this.w != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
            p0(false, null);
        }
        this.f5427i.d();
    }

    @Override // com.ironsource.mediationsdk.w
    public void t(LWSProgRvSmash lWSProgRvSmash, com.ironsource.mediationsdk.model.o oVar) {
        m0(lWSProgRvSmash, "onRewardedVideoAdClicked");
        RVListenerWrapper.getInstance().d(oVar);
    }

    @Override // com.ironsource.mediationsdk.w
    public void v(LWSProgRvSmash lWSProgRvSmash, com.ironsource.mediationsdk.model.o oVar) {
        m0(lWSProgRvSmash, "onRewardedVideoAdRewarded");
        RVListenerWrapper.getInstance().h(oVar);
    }

    @Override // com.ironsource.mediationsdk.w
    public void w(LWSProgRvSmash lWSProgRvSmash) {
        String str;
        LWSProgRvSmash next;
        m0(lWSProgRvSmash, "onRewardedVideoAdClosed, mediation state: " + this.w.name());
        RVListenerWrapper.getInstance().e();
        this.v = false;
        boolean z = this.w == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z) {
            Iterator<LWSProgRvSmash> it = this.b.b().iterator();
            while (it.hasNext()) {
                if (it.next().Y()) {
                    sb.append(next.x() + ";");
                }
            }
        }
        Object[][] objArr = new Object[1];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "ext1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("otherRVAvailable = ");
        if (sb.length() > 0) {
            str = "true|" + ((Object) sb);
        } else {
            str = "false";
        }
        sb2.append(str);
        objArr2[1] = sb2.toString();
        objArr[0] = objArr2;
        lWSProgRvSmash.j0(1203, objArr);
        if (lWSProgRvSmash.equals(this.b.e())) {
            this.b.g(null);
            if (this.w != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                p0(false, null);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.w
    public void x(LWSProgRvSmash lWSProgRvSmash) {
        this.b.g(lWSProgRvSmash);
        this.r++;
        m0(lWSProgRvSmash, "onRewardedVideoAdOpened");
        RVListenerWrapper.getInstance().g();
        if (this.f5428j) {
            f fVar = this.c.get(lWSProgRvSmash.x());
            if (fVar != null) {
                this.f5425g.f(fVar, lWSProgRvSmash.E(), this.f5423e, this.s);
                this.f5422d.put(lWSProgRvSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
                Q(fVar, this.s);
            } else {
                String x = lWSProgRvSmash != null ? lWSProgRvSmash.x() : "Smash is null";
                l0("onRewardedVideoAdOpened showing instance " + x + " missing from waterfall");
                StringBuilder sb = new StringBuilder();
                sb.append("Showing missing ");
                sb.append(this.w);
                q0(81317, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 1011}, new Object[]{"reason", sb.toString()}, new Object[]{"ext1", x}}));
            }
        }
        this.f5427i.e();
    }

    @Override // com.ironsource.mediationsdk.w
    public void z(LWSProgRvSmash lWSProgRvSmash) {
        synchronized (this.z) {
            m0(lWSProgRvSmash, "onLoadSuccess mState=" + this.w);
            if (lWSProgRvSmash.T() == this.b.c() && this.w != RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS) {
                this.f5422d.put(lWSProgRvSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceLoadedSuccessfully);
                RV_MEDIATION_STATE rv_mediation_state = this.w;
                RV_MEDIATION_STATE rv_mediation_state2 = RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES;
                if (rv_mediation_state == rv_mediation_state2) {
                    p0(true, null);
                    v0(RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW);
                    q0(1003, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - this.f5429k)}}));
                    n.c().e(0L);
                    if (this.f5428j) {
                        f fVar = this.c.get(lWSProgRvSmash.x());
                        if (fVar != null) {
                            this.f5425g.g(fVar, lWSProgRvSmash.E(), this.f5423e);
                            this.f5425g.e(this.b.b(), this.c, lWSProgRvSmash.E(), this.f5423e, fVar);
                        } else {
                            String x = lWSProgRvSmash != null ? lWSProgRvSmash.x() : "Smash is null";
                            l0("onLoadSuccess winner instance " + x + " missing from waterfall. auctionId: " + lWSProgRvSmash.T() + " and the current id is " + this.b.c());
                            StringBuilder sb = new StringBuilder();
                            sb.append("Loaded missing ");
                            sb.append(rv_mediation_state2);
                            q0(81317, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", sb.toString()}, new Object[]{"ext1", x}}));
                        }
                    }
                }
                return;
            }
            n0("onLoadSuccess was invoked with auctionId: " + lWSProgRvSmash.T() + " and the current id is " + this.b.c());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLoadSuccess wrong auction ID ");
            sb2.append(this.w);
            lWSProgRvSmash.g0(81315, new Object[][]{new Object[]{"errorCode", 2}, new Object[]{"reason", sb2.toString()}});
        }
    }
}
