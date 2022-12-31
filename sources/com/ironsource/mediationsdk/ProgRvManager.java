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
import com.ironsource.mediationsdk.logger.IronLog;
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
public class ProgRvManager extends i implements b0, g0, d, p, q, com.ironsource.environment.i {
    private int A;
    private String B;
    private boolean C;
    private NetworkStateReceiver D;
    private final ConcurrentHashMap<String, ProgRvSmash> b;
    private CopyOnWriteArrayList<ProgRvSmash> c;

    /* renamed from: d  reason: collision with root package name */
    private List<f> f5477d;

    /* renamed from: e  reason: collision with root package name */
    private ConcurrentHashMap<String, f> f5478e;

    /* renamed from: f  reason: collision with root package name */
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> f5479f;

    /* renamed from: g  reason: collision with root package name */
    private f f5480g;

    /* renamed from: h  reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.m f5481h;

    /* renamed from: i  reason: collision with root package name */
    private f0 f5482i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5483j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5484k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5485l;
    private e m;
    private AuctionHistory n;
    private String o;
    private String p;
    private JSONObject q;
    private int r;
    private long s;
    private long t;
    private long u;
    private int v;
    private boolean w;
    private boolean x;
    private Boolean y;
    private RV_MEDIATION_STATE z;

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
            ProgRvManager.this.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgRvManager.this.q0("makeAuction()");
            ProgRvManager.this.p = "";
            ProgRvManager.this.q = null;
            ProgRvManager.this.s = new Date().getTime();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            for (ProgRvSmash progRvSmash : ProgRvManager.this.b.values()) {
                progRvSmash.p0();
                if (!ProgRvManager.this.f5481h.c(progRvSmash)) {
                    if (progRvSmash.L()) {
                        Map<String, Object> V = progRvSmash.V();
                        if (V != null) {
                            hashMap.put(progRvSmash.x(), V);
                            sb.append(progRvSmash.E() + progRvSmash.x() + ",");
                        }
                    } else {
                        arrayList.add(progRvSmash.x());
                        sb.append(progRvSmash.E() + progRvSmash.x() + ",");
                    }
                }
            }
            if (hashMap.keySet().size() == 0 && arrayList.size() == 0) {
                ProgRvManager.this.u0(1301, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) CloseFrame.NOCODE)}, new Object[]{TypedValues.TransitionType.S_DURATION, 0}}));
                ProgRvManager.this.q0("makeAuction() failed - No candidates available for auctioning");
                ProgRvManager.this.i0();
                return;
            }
            ProgRvManager progRvManager = ProgRvManager.this;
            progRvManager.q0("makeAuction() - request waterfall is: " + ((Object) sb));
            ProgRvManager.this.x0(1000);
            ProgRvManager.this.x0(1300);
            ProgRvManager.this.y0(1310, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"ext1", sb.toString()}}));
            ProgRvManager.this.m.a(ContextProvider.getInstance().a(), hashMap, arrayList, ProgRvManager.this.n, ProgRvManager.this.r);
        }
    }

    /* loaded from: classes2.dex */
    class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ProgRvManager.this.n0();
        }
    }

    public ProgRvManager(List<com.ironsource.mediationsdk.model.l> list, com.ironsource.mediationsdk.model.s sVar, String str, String str2, HashSet<com.ironsource.mediationsdk.l0.c> hashSet) {
        super(hashSet);
        this.r = 1;
        this.B = "";
        this.C = false;
        long time = new Date().getTime();
        x0(81312);
        z0(RV_MEDIATION_STATE.RV_STATE_INITIATING);
        this.y = null;
        this.v = sVar.g();
        this.w = sVar.i();
        this.o = "";
        com.ironsource.mediationsdk.utils.b j2 = sVar.j();
        this.x = false;
        this.c = new CopyOnWriteArrayList<>();
        this.f5477d = new ArrayList();
        this.f5478e = new ConcurrentHashMap<>();
        this.f5479f = new ConcurrentHashMap<>();
        this.u = new Date().getTime();
        this.f5483j = j2.i() > 0;
        this.f5484k = j2.e();
        this.f5485l = !j2.f();
        this.t = j2.n();
        if (this.f5483j) {
            this.m = new e("rewardedVideo", j2, this);
        }
        this.f5482i = new f0(j2, this);
        this.b = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        for (com.ironsource.mediationsdk.model.l lVar : list) {
            com.ironsource.mediationsdk.b f2 = AdapterRepository.getInstance().f(lVar, lVar.o(), false, false);
            if (f2 != null && AdaptersCompatibilityHandler.getInstance().c(f2)) {
                ProgRvSmash progRvSmash = new ProgRvSmash(str, str2, lVar, this, sVar.h(), f2);
                String x = progRvSmash.x();
                this.b.put(x, progRvSmash);
                arrayList.add(x);
            }
        }
        this.n = new AuctionHistory(arrayList, j2.d());
        this.f5481h = new com.ironsource.mediationsdk.utils.m(new ArrayList(this.b.values()));
        for (ProgRvSmash progRvSmash2 : this.b.values()) {
            if (progRvSmash2.L()) {
                progRvSmash2.X();
            }
        }
        y0(81313, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - time)}}));
        n.c().d(this, sVar.d());
        k0(j2.m());
    }

    private boolean A0(int i2) {
        return i2 == 1003 || i2 == 1302 || i2 == 1301;
    }

    private boolean B0(boolean z) {
        Boolean bool = this.y;
        if (bool == null) {
            return false;
        }
        return (z && !bool.booleanValue() && j0()) || (!z && this.y.booleanValue());
    }

    private void C0(List<f> list) {
        this.f5477d = list;
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = list.iterator();
        while (it.hasNext()) {
            sb.append(h0(it.next()) + ",");
        }
        String str = "updateNextWaterfallToLoad() - next waterfall is " + sb.toString();
        q0(str);
        IronSourceUtils.j0("RV: " + str);
        if (sb.length() == 0) {
            q0("Updated waterfall is empty");
        }
        u0(1311, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"ext1", sb.toString()}}));
    }

    private void D0(List<f> list) {
        this.c.clear();
        this.f5478e.clear();
        this.f5479f.clear();
        for (f fVar : list) {
            ProgRvSmash progRvSmash = this.b.get(fVar.c());
            if (progRvSmash != null) {
                progRvSmash.N(true);
                this.c.add(progRvSmash);
                this.f5478e.put(progRvSmash.x(), fVar);
                this.f5479f.put(fVar.c(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
            } else {
                q0("updateWaterfall() - could not find matching smash for auction response item " + fVar.c());
            }
        }
        this.f5477d.clear();
    }

    private void E0() {
        this.p = P();
        C0(g0());
    }

    private List<f> g0() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (ProgRvSmash progRvSmash : this.b.values()) {
            if (!progRvSmash.L() && !this.f5481h.c(progRvSmash)) {
                copyOnWriteArrayList.add(new f(progRvSmash.x()));
            }
        }
        return copyOnWriteArrayList;
    }

    private String h0(f fVar) {
        String str;
        ProgRvSmash progRvSmash = this.b.get(fVar.c());
        if (progRvSmash != null) {
            str = Integer.toString(progRvSmash.E());
        } else {
            str = TextUtils.isEmpty(fVar.g()) ? "1" : "2";
        }
        return str + fVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        z0(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
        s0(false);
        this.f5482i.b();
    }

    private void k0(long j2) {
        if (this.f5481h.a()) {
            u0(81001, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 80001}, new Object[]{"reason", "all smashes are capped"}}));
            i0();
        } else if (this.f5483j) {
            if (!this.f5479f.isEmpty()) {
                this.n.b(this.f5479f);
                this.f5479f.clear();
            }
            new Timer().schedule(new a(), j2);
        } else {
            IronLog.INTERNAL.info("auction is disabled, fallback flow will occur");
            E0();
            if (this.f5477d.isEmpty()) {
                u0(81001, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 80002}, new Object[]{"reason", "waterfall is empty"}}));
                i0();
                return;
            }
            x0(1000);
            if (this.f5485l && this.x) {
                return;
            }
            n0();
        }
    }

    private void l0(ProgRvSmash progRvSmash) {
        String g2 = this.f5478e.get(progRvSmash.x()).g();
        progRvSmash.b0(g2, this.p, this.q, this.A, this.B, this.r, AuctionDataUtils.getInstance().l(g2));
    }

    private void m0() {
        if (this.c.isEmpty()) {
            u0(81001, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}}));
            i0();
            return;
        }
        z0(RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.c.size() && i2 < this.v; i3++) {
            ProgRvSmash progRvSmash = this.c.get(i3);
            if (progRvSmash.F()) {
                if (this.w && progRvSmash.L()) {
                    if (i2 == 0) {
                        String str = "Advanced Loading: Starting to load bidder " + progRvSmash.x() + ". No other instances will be loaded at the same time.";
                        q0(str);
                        IronSourceUtils.j0(str);
                        l0(progRvSmash);
                        return;
                    }
                    String str2 = "Advanced Loading: Won't start loading bidder " + progRvSmash.x() + " as a non bidder is being loaded";
                    q0(str2);
                    IronSourceUtils.j0(str2);
                    return;
                }
                l0(progRvSmash);
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        D0(this.f5477d);
        m0();
    }

    private void o0(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "ProgRvManager: " + str, 3);
    }

    private void p0(ProgRvSmash progRvSmash, String str) {
        String str2 = progRvSmash.x() + " : " + str;
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvManager: " + str2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "ProgRvManager: " + str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        z0(RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS);
        AsyncTask.execute(new b());
    }

    private void s0(boolean z) {
        t0(z, new HashMap());
    }

    private void t0(boolean z, Map<String, Object> map) {
        Boolean bool = this.y;
        if (bool == null || bool.booleanValue() != z) {
            this.y = Boolean.valueOf(z);
            long time = new Date().getTime() - this.u;
            this.u = new Date().getTime();
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(time));
            u0(z ? 1111 : 1112, map);
            RVListenerWrapper.getInstance().k(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i2, Map<String, Object> map) {
        v0(i2, map, false, true);
    }

    private void v0(int i2, Map<String, Object> map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("provider", "Mediation");
        hashMap.put("programmatic", 1);
        if (z2 && !TextUtils.isEmpty(this.p)) {
            hashMap.put("auctionId", this.p);
        }
        JSONObject jSONObject = this.q;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.q);
        }
        if (z && !TextUtils.isEmpty(this.o)) {
            hashMap.put("placement", this.o);
        }
        if (A0(i2)) {
            RewardedVideoEventsManager.getInstance().W(hashMap, this.A, this.B);
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
                i3.d(ironSourceTag, "ProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(hashMap)));
    }

    private void w0(int i2, Map<String, Object> map) {
        v0(i2, map, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(int i2) {
        v0(i2, new HashMap(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i2, Map<String, Object> map) {
        v0(i2, map, false, false);
    }

    private void z0(RV_MEDIATION_STATE rv_mediation_state) {
        q0("current state=" + this.z + ", new state=" + rv_mediation_state);
        this.z = rv_mediation_state;
    }

    @Override // com.ironsource.mediationsdk.q
    public void A() {
        z0(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
        t0(false, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 1057}, new Object[]{"reason", "loaded ads are expired"}}));
        k0(0L);
    }

    @Override // com.ironsource.mediationsdk.g0
    public synchronized void E() {
        q0("onLoadTriggered: RV load was triggered in " + this.z + " state");
        k0(0L);
    }

    @Override // com.ironsource.mediationsdk.b0
    public synchronized void H(ProgRvSmash progRvSmash, String str) {
        p0(progRvSmash, "onLoadSuccess ");
        String str2 = this.p;
        if (str2 != null && !str.equalsIgnoreCase(str2)) {
            q0("onLoadSuccess was invoked with auctionId: " + str + " and the current id is " + this.p);
            StringBuilder sb = new StringBuilder();
            sb.append("onLoadSuccess wrong auction ID ");
            sb.append(this.z);
            progRvSmash.g0(81315, new Object[][]{new Object[]{"errorCode", 2}, new Object[]{"reason", sb.toString()}});
            return;
        }
        RV_MEDIATION_STATE rv_mediation_state = this.z;
        this.f5479f.put(progRvSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceLoadedSuccessfully);
        if (this.z == RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES) {
            s0(true);
            z0(RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW);
            u0(1003, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(new Date().getTime() - this.s)}}));
            n.c().e(0L);
            if (this.f5483j) {
                f fVar = this.f5478e.get(progRvSmash.x());
                if (fVar != null) {
                    this.m.g(fVar, progRvSmash.E(), this.f5480g);
                    this.m.e(this.c, this.f5478e, progRvSmash.E(), this.f5480g, fVar);
                } else {
                    String x = progRvSmash != null ? progRvSmash.x() : "Smash is null";
                    o0("onLoadSuccess winner instance " + x + " missing from waterfall. auctionId: " + str + " and the current id is " + this.p);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Loaded missing ");
                    sb2.append(rv_mediation_state);
                    u0(81317, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", sb2.toString()}, new Object[]{"ext1", x}}));
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.d
    public void I(List<f> list, String str, f fVar, JSONObject jSONObject, int i2, long j2) {
        q0("makeAuction(): success");
        this.p = str;
        this.f5480g = fVar;
        this.q = jSONObject;
        this.A = i2;
        this.B = "";
        u0(1302, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}}));
        C0(list);
        if (this.f5485l && this.x) {
            return;
        }
        n0();
    }

    @Override // com.ironsource.mediationsdk.b0
    public void J(ProgRvSmash progRvSmash, String str) {
        CopyOnWriteArrayList<ProgRvSmash> copyOnWriteArrayList = new CopyOnWriteArrayList();
        synchronized (this) {
            p0(progRvSmash, "onLoadError state=" + this.z);
            if (!str.equalsIgnoreCase(this.p)) {
                q0("onLoadError was invoked with auctionId:" + str + " and the current id is " + this.p);
                StringBuilder sb = new StringBuilder();
                sb.append("loadError wrong auction ID ");
                sb.append(this.z);
                progRvSmash.g0(81315, new Object[][]{new Object[]{"errorCode", 4}, new Object[]{"reason", sb.toString()}});
                return;
            }
            this.f5479f.put(progRvSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
            RV_MEDIATION_STATE rv_mediation_state = this.z;
            if (rv_mediation_state == RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES || rv_mediation_state == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                Iterator<ProgRvSmash> it = this.c.iterator();
                boolean z = false;
                boolean z2 = false;
                while (it.hasNext()) {
                    ProgRvSmash next = it.next();
                    if (next.F()) {
                        if (this.w && next.L()) {
                            if (!z && !z2) {
                                String str2 = "Advanced Loading: Starting to load bidder " + next.x() + ". No other instances will be loaded at the same time.";
                                q0(str2);
                                IronSourceUtils.j0(str2);
                            }
                            String str3 = "Advanced Loading: Won't start loading bidder " + next.x() + " as " + (z ? "a non bidder is being loaded" : "a non bidder was already loaded successfully");
                            q0(str3);
                            IronSourceUtils.j0(str3);
                        }
                        if (this.f5478e.get(next.x()) != null) {
                            copyOnWriteArrayList.add(next);
                            if (!this.w) {
                                break;
                            } else if (!progRvSmash.L()) {
                                break;
                            } else if (next.L()) {
                                break;
                            } else {
                                if (copyOnWriteArrayList.size() >= this.v) {
                                    break;
                                }
                                z = true;
                            }
                        } else {
                            continue;
                        }
                    } else if (next.Y()) {
                        z = true;
                    } else if (next.Z()) {
                        z2 = true;
                    }
                }
                if (copyOnWriteArrayList.size() == 0 && !z2 && !z) {
                    q0("onLoadError(): No other available smashes");
                    s0(false);
                    z0(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
                    this.f5482i.b();
                }
                for (ProgRvSmash progRvSmash2 : copyOnWriteArrayList) {
                    l0(progRvSmash2);
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.p
    public void L(Context context, boolean z) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "ProgRvManager Should Track Network State: " + z, 0);
        this.C = z;
        if (z) {
            if (this.D == null) {
                this.D = new NetworkStateReceiver(context, this);
            }
            context.getApplicationContext().registerReceiver(this.D, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else if (this.D != null) {
            context.getApplicationContext().unregisterReceiver(this.D);
        }
    }

    @Override // com.ironsource.mediationsdk.b0
    public void O(ProgRvSmash progRvSmash) {
        p0(progRvSmash, "onRewardedVideoAdStarted");
        RVListenerWrapper.getInstance().j();
    }

    @Override // com.ironsource.environment.i
    public void c(boolean z) {
        if (this.C) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            i2.d(ironSourceTag, "Network Availability Changed To: " + z, 1);
            if (B0(z)) {
                s0(z);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.d
    public void f(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        q0(str3);
        IronSourceUtils.j0("RV: " + str3);
        this.A = i3;
        this.B = str2;
        this.q = null;
        E0();
        if (TextUtils.isEmpty(str)) {
            u0(1301, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}}));
        } else {
            u0(1301, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}}));
        }
        if (this.f5485l && this.x) {
            return;
        }
        n0();
    }

    @Override // com.ironsource.mediationsdk.b0
    public void h(ProgRvSmash progRvSmash, com.ironsource.mediationsdk.model.o oVar) {
        p0(progRvSmash, "onRewardedVideoAdRewarded");
        RVListenerWrapper.getInstance().h(oVar);
    }

    public synchronized boolean j0() {
        if (!this.C || IronSourceUtils.S(ContextProvider.getInstance().a())) {
            if (this.z == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW && !this.x) {
                Iterator<ProgRvSmash> it = this.c.iterator();
                while (it.hasNext()) {
                    if (it.next().Z()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.b0
    public void k(ProgRvSmash progRvSmash) {
        synchronized (this) {
            this.r++;
            p0(progRvSmash, "onRewardedVideoAdOpened");
            RVListenerWrapper.getInstance().g();
            if (this.f5483j) {
                f fVar = this.f5478e.get(progRvSmash.x());
                if (fVar != null) {
                    this.m.f(fVar, progRvSmash.E(), this.f5480g, this.o);
                    this.f5479f.put(progRvSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
                    Q(fVar, this.o);
                } else {
                    String x = progRvSmash != null ? progRvSmash.x() : "Smash is null";
                    o0("onRewardedVideoAdOpened showing instance " + x + " missing from waterfall");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Showing missing ");
                    sb.append(this.z);
                    u0(81317, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", 1011}, new Object[]{"reason", sb.toString()}, new Object[]{"ext1", x}}));
                }
            }
            this.f5482i.e();
        }
    }

    @Override // com.ironsource.mediationsdk.b0
    public void l(ProgRvSmash progRvSmash) {
        synchronized (this) {
            progRvSmash.j0(1203, new Object[][]{new Object[]{"ext1", "otherRVAvailable = false"}});
            p0(progRvSmash, "onRewardedVideoAdClosed, mediation state: " + this.z.name());
            RVListenerWrapper.getInstance().e();
            this.x = false;
            if (this.z != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                s0(false);
            }
            if (this.f5484k) {
                List<f> list = this.f5477d;
                if (list != null && list.size() > 0) {
                    new Timer().schedule(new c(), this.t);
                }
            } else {
                this.f5482i.c();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.b0
    public void m(ProgRvSmash progRvSmash) {
        p0(progRvSmash, "onRewardedVideoAdEnded");
        RVListenerWrapper.getInstance().f();
    }

    @Override // com.ironsource.mediationsdk.b0
    public void n(com.ironsource.mediationsdk.logger.b bVar, ProgRvSmash progRvSmash) {
        synchronized (this) {
            p0(progRvSmash, "onRewardedVideoAdShowFailed error=" + bVar.b());
            w0(1113, com.ironsource.mediationsdk.q0.b.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}}));
            RVListenerWrapper.getInstance().i(bVar);
            this.x = false;
            this.f5479f.put(progRvSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToShow);
            if (this.z != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                s0(false);
            }
            this.f5482i.d();
        }
    }

    @Override // com.ironsource.mediationsdk.b0
    public void q(ProgRvSmash progRvSmash, com.ironsource.mediationsdk.model.o oVar) {
        p0(progRvSmash, "onRewardedVideoAdClicked");
        RVListenerWrapper.getInstance().d(oVar);
    }
}
