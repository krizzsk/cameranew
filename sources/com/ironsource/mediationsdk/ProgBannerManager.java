package com.ironsource.mediationsdk;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.AdError;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p0.b;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ProgBannerManager extends i implements z, d, b.a, ContextProvider.a {
    private g b;
    private BannerManagerState c;

    /* renamed from: d  reason: collision with root package name */
    private com.ironsource.mediationsdk.p0.b f5447d;

    /* renamed from: e  reason: collision with root package name */
    private IronSourceBannerLayout f5448e;

    /* renamed from: f  reason: collision with root package name */
    private com.ironsource.mediationsdk.model.h f5449f;

    /* renamed from: g  reason: collision with root package name */
    private int f5450g;

    /* renamed from: h  reason: collision with root package name */
    private int f5451h;

    /* renamed from: i  reason: collision with root package name */
    private final ConcurrentHashMap<String, ProgBannerSmash> f5452i;

    /* renamed from: j  reason: collision with root package name */
    private CopyOnWriteArrayList<ProgBannerSmash> f5453j;

    /* renamed from: k  reason: collision with root package name */
    private String f5454k;

    /* renamed from: l  reason: collision with root package name */
    private JSONObject f5455l;
    private String m;
    private int n;
    private e o;
    private f p;
    private AuctionHistory q;
    private ConcurrentHashMap<String, f> r;
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> s;
    private long t;
    private final Object u;
    private AtomicBoolean v;
    private com.ironsource.mediationsdk.utils.e w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum BannerManagerState {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements h.b {
        final /* synthetic */ com.ironsource.mediationsdk.model.h a;
        final /* synthetic */ IronSourceBannerLayout b;

        a(com.ironsource.mediationsdk.model.h hVar, IronSourceBannerLayout ironSourceBannerLayout) {
            this.a = hVar;
            this.b = ironSourceBannerLayout;
        }

        @Override // com.ironsource.mediationsdk.h.b
        public void a(String str) {
            IronLog ironLog = IronLog.API;
            ironLog.error("can't load banner - errorMessage = " + str);
        }

        @Override // com.ironsource.mediationsdk.h.b
        public void b() {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("placement = " + this.a.c());
            ProgBannerManager.this.f5448e = this.b;
            ProgBannerManager.this.f5449f = this.a;
            if (!CappingManager.m(ContextProvider.getInstance().b(), this.a.c())) {
                ProgBannerManager.this.J0(false);
                return;
            }
            ironLog.verbose("placement is capped");
            BannerCallbackThrottler bannerCallbackThrottler = BannerCallbackThrottler.getInstance();
            IronSourceBannerLayout ironSourceBannerLayout = this.b;
            bannerCallbackThrottler.d(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR, "placement " + this.a.c() + " is capped"));
            ProgBannerManager.this.E0(3111, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR)}});
            ProgBannerManager.this.H0(BannerManagerState.READY_TO_LOAD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* loaded from: classes2.dex */
        class a implements h.a {
            a() {
            }

            @Override // com.ironsource.mediationsdk.h.a
            public void a(Map<String, Object> map, List<String> list, StringBuilder sb) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("auction waterfallString = " + ((Object) sb));
                if (map.size() != 0 || list.size() != 0) {
                    ProgBannerManager.this.E0(3510, new Object[][]{new Object[]{"ext1", sb.toString()}});
                    if (ProgBannerManager.this.o != null) {
                        ProgBannerManager.this.o.b(ContextProvider.getInstance().a(), map, list, ProgBannerManager.this.q, ProgBannerManager.this.f5451h, ProgBannerManager.this.q0());
                        return;
                    } else {
                        ironLog.error("mAuctionHandler is null");
                        return;
                    }
                }
                ProgBannerManager.this.E0(3501, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) CloseFrame.NOCODE)}, new Object[]{TypedValues.TransitionType.S_DURATION, 0}});
                if (ProgBannerManager.this.n0(BannerManagerState.AUCTION, BannerManagerState.LOADED)) {
                    ProgBannerManager.this.f5447d.e(ProgBannerManager.this);
                    return;
                }
                BannerCallbackThrottler.getInstance().d(ProgBannerManager.this.f5448e, new com.ironsource.mediationsdk.logger.b(CloseFrame.NOCODE, "No candidates available for auctioning"));
                ProgBannerManager.this.E0(3111, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) CloseFrame.NOCODE)}});
                ProgBannerManager.this.H0(BannerManagerState.READY_TO_LOAD);
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgBannerManager.this.K0();
            if (ProgBannerManager.this.N0()) {
                return;
            }
            ProgBannerManager.this.D0(3500);
            h.a(ProgBannerManager.this.s0(), ProgBannerManager.this.f5452i, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ProgBannerManager.this.C0();
        }
    }

    public ProgBannerManager(List<com.ironsource.mediationsdk.model.l> list, g gVar, HashSet<com.ironsource.mediationsdk.l0.c> hashSet) {
        super(hashSet);
        this.c = BannerManagerState.NONE;
        this.m = "";
        this.u = new Object();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("isAuctionEnabled = " + gVar.h());
        this.b = gVar;
        this.f5447d = new com.ironsource.mediationsdk.p0.b(gVar.e());
        this.f5452i = new ConcurrentHashMap<>();
        this.f5453j = new CopyOnWriteArrayList<>();
        this.r = new ConcurrentHashMap<>();
        this.s = new ConcurrentHashMap<>();
        this.f5451h = SessionDepthManager.getInstance().b(3);
        BannerCallbackThrottler.getInstance().e(this.b.c());
        if (this.b.h()) {
            this.o = new e("banner", this.b.b(), this);
        }
        v0(list);
        G0(list);
        this.v = new AtomicBoolean(true);
        ContextProvider.getInstance().d(this);
        this.t = new Date().getTime();
        H0(BannerManagerState.READY_TO_LOAD);
    }

    private void A0() {
        for (int i2 = this.f5450g; i2 < this.f5453j.size(); i2++) {
            ProgBannerSmash progBannerSmash = this.f5453j.get(i2);
            if (progBannerSmash.F()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("loading smash - " + progBannerSmash.D());
                this.f5450g = i2 + 1;
                B0(progBannerSmash);
                return;
            }
        }
        t0();
    }

    private void B0(ProgBannerSmash progBannerSmash) {
        String str;
        if (progBannerSmash.L()) {
            str = this.r.get(progBannerSmash.x()).g();
            progBannerSmash.M(str);
        } else {
            str = null;
        }
        progBannerSmash.V(this.f5448e.i(), this.f5449f, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        IronLog.INTERNAL.verbose("");
        AsyncTask.execute(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i2) {
        E0(i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i2, Object[][] objArr) {
        F0(i2, objArr, this.f5451h);
    }

    private void F0(int i2, Object[][] objArr, int i3) {
        JSONObject E = IronSourceUtils.E(false, true, 1);
        try {
            r r0 = r0();
            if (r0 != null) {
                j0(E, r0);
            }
            if (this.f5449f != null) {
                E.put("placement", s0());
            }
            E.put("sessionDepth", i3);
            if (!TextUtils.isEmpty(this.f5454k)) {
                E.put("auctionId", this.f5454k);
            }
            JSONObject jSONObject = this.f5455l;
            if (jSONObject != null && jSONObject.length() > 0) {
                E.put("genericParams", this.f5455l);
            }
            if (I0(i2)) {
                E.put("auctionTrials", this.n);
                if (!TextUtils.isEmpty(this.m)) {
                    E.put("auctionFallback", this.m);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    E.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, E));
    }

    private void G0(List<com.ironsource.mediationsdk.model.l> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.ironsource.mediationsdk.model.l lVar = list.get(i2);
            com.ironsource.mediationsdk.b f2 = AdapterRepository.getInstance().f(lVar, lVar.d(), false, false);
            if (f2 != null) {
                ProgBannerSmash progBannerSmash = new ProgBannerSmash(this.b, this, lVar, f2, this.f5451h, w0());
                this.f5452i.put(progBannerSmash.x(), progBannerSmash);
            } else {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(lVar.k() + " can't load adapter");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(BannerManagerState bannerManagerState) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("from '" + this.c + "' to '" + bannerManagerState + "'");
        synchronized (this.u) {
            this.c = bannerManagerState;
        }
    }

    private boolean I0(int i2) {
        return i2 == 3201 || i2 == 3110 || i2 == 3111 || i2 == 3116 || i2 == 3119 || i2 == 3112 || i2 == 3115 || i2 == 3501 || i2 == 3502;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(boolean z) {
        BannerManagerState bannerManagerState;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("current state = " + this.c);
        if (this.b.h()) {
            bannerManagerState = z ? BannerManagerState.AUCTION : BannerManagerState.FIRST_AUCTION;
        } else {
            bannerManagerState = z ? BannerManagerState.RELOADING : BannerManagerState.LOADING;
        }
        if (n0(BannerManagerState.STARTED_LOADING, bannerManagerState)) {
            this.w = new com.ironsource.mediationsdk.utils.e();
            this.f5454k = "";
            this.f5455l = null;
            this.f5450g = 0;
            this.f5451h = SessionDepthManager.getInstance().b(3);
            if (z) {
                D0(3011);
            } else {
                D0(AdError.MEDIATION_ERROR_CODE);
            }
            if (this.b.h()) {
                C0();
                return;
            }
            M0();
            A0();
            return;
        }
        ironLog.error("wrong state - " + this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        if (this.s.isEmpty()) {
            return;
        }
        this.q.b(this.s);
        this.s.clear();
    }

    private String L0(List<f> list) {
        IronLog.INTERNAL.verbose("waterfall.size() = " + list.size());
        this.f5453j.clear();
        this.r.clear();
        this.s.clear();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            f fVar = list.get(i2);
            k0(fVar);
            sb.append(o0(fVar));
            if (i2 != list.size() - 1) {
                sb.append(",");
            }
        }
        String str = "updateWaterfall() - next waterfall is " + sb.toString();
        IronLog.INTERNAL.verbose(str);
        IronSourceUtils.j0("BN: " + str);
        return sb.toString();
    }

    private void M0() {
        List<f> p0 = p0();
        this.f5454k = P();
        L0(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N0() {
        long b2 = h.b(this.t, this.b.f());
        if (b2 > 0) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("waiting before auction - timeToWaitBeforeAuction = " + b2);
            new Timer().schedule(new c(), b2);
            return true;
        }
        return false;
    }

    private static void j0(JSONObject jSONObject, r rVar) {
        try {
            String a2 = rVar.a();
            char c2 = 65535;
            switch (a2.hashCode()) {
                case -387072689:
                    if (a2.equals("RECTANGLE")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 72205083:
                    if (a2.equals("LARGE")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 79011241:
                    if (a2.equals("SMART")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1951953708:
                    if (a2.equals("BANNER")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1999208305:
                    if (a2.equals("CUSTOM")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                jSONObject.put("bannerAdSize", 1);
            } else if (c2 == 1) {
                jSONObject.put("bannerAdSize", 2);
            } else if (c2 == 2) {
                jSONObject.put("bannerAdSize", 3);
            } else if (c2 == 3) {
                jSONObject.put("bannerAdSize", 5);
            } else if (c2 != 4) {
            } else {
                jSONObject.put("bannerAdSize", 6);
                jSONObject.put("custom_banner_size", rVar.c() + "x" + rVar.b());
            }
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
    }

    private void k0(f fVar) {
        ProgBannerSmash progBannerSmash = this.f5452i.get(fVar.c());
        if (progBannerSmash != null) {
            com.ironsource.mediationsdk.b c2 = AdapterRepository.getInstance().c(progBannerSmash.b.g());
            if (c2 != null) {
                ProgBannerSmash progBannerSmash2 = new ProgBannerSmash(this.b, this, progBannerSmash.b.g(), c2, this.f5451h, this.f5454k, this.f5455l, this.n, this.m, w0());
                progBannerSmash2.N(true);
                this.f5453j.add(progBannerSmash2);
                this.r.put(progBannerSmash2.x(), fVar);
                this.s.put(fVar.c(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
                return;
            }
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error("could not find matching smash for auction response item - item = " + fVar.c());
    }

    private void l0(View view, FrameLayout.LayoutParams layoutParams) {
        this.f5448e.e(view, layoutParams);
    }

    private boolean m0() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f5448e;
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.h()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n0(BannerManagerState bannerManagerState, BannerManagerState bannerManagerState2) {
        boolean z;
        synchronized (this.u) {
            if (this.c == bannerManagerState) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("set state from '" + this.c + "' to '" + bannerManagerState2 + "'");
                z = true;
                this.c = bannerManagerState2;
            } else {
                z = false;
            }
        }
        return z;
    }

    private String o0(f fVar) {
        ProgBannerSmash progBannerSmash = this.f5452i.get(fVar.c());
        String str = "1";
        if (progBannerSmash == null ? !TextUtils.isEmpty(fVar.g()) : progBannerSmash.L()) {
            str = "2";
        }
        return str + fVar.c();
    }

    private List<f> p0() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (ProgBannerSmash progBannerSmash : this.f5452i.values()) {
            if (!progBannerSmash.L() && !CappingManager.m(ContextProvider.getInstance().b(), s0())) {
                copyOnWriteArrayList.add(new f(progBannerSmash.x()));
            }
        }
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r q0() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f5448e;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.g() == null) {
            return null;
        }
        if (this.f5448e.g().d()) {
            if (com.ironsource.mediationsdk.c.b(ContextProvider.getInstance().b())) {
                return r.f5646e;
            }
            return r.f5645d;
        }
        return this.f5448e.g();
    }

    private r r0() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f5448e;
        if (ironSourceBannerLayout != null) {
            return ironSourceBannerLayout.g();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s0() {
        com.ironsource.mediationsdk.model.h hVar = this.f5449f;
        return hVar != null ? hVar.c() : "";
    }

    private void t0() {
        String str = this.f5453j.isEmpty() ? "Empty waterfall" : "Mediation No fill";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("errorReason = " + str);
        BannerManagerState bannerManagerState = BannerManagerState.LOADING;
        BannerManagerState bannerManagerState2 = BannerManagerState.READY_TO_LOAD;
        if (n0(bannerManagerState, bannerManagerState2)) {
            E0(3111, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO)}, new Object[]{"reason", str}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.w))}});
            BannerCallbackThrottler.getInstance().d(this.f5448e, new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, str));
        } else if (n0(BannerManagerState.RELOADING, BannerManagerState.LOADED)) {
            E0(3201, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.w))}});
            this.f5447d.e(this);
        } else {
            H0(bannerManagerState2);
            ironLog.error("wrong state = " + this.c);
        }
    }

    private void u0() {
        String s0 = s0();
        CappingManager.g(ContextProvider.getInstance().b(), s0);
        if (CappingManager.m(ContextProvider.getInstance().b(), s0)) {
            D0(3400);
        }
    }

    private void v0(List<com.ironsource.mediationsdk.model.l> list) {
        ArrayList arrayList = new ArrayList();
        for (com.ironsource.mediationsdk.model.l lVar : list) {
            arrayList.add(lVar.l());
        }
        this.q = new AuctionHistory(arrayList, this.b.b().d());
    }

    private boolean w0() {
        BannerManagerState bannerManagerState = this.c;
        return bannerManagerState == BannerManagerState.RELOADING || bannerManagerState == BannerManagerState.AUCTION;
    }

    private boolean x0() {
        boolean z;
        synchronized (this.u) {
            BannerManagerState bannerManagerState = this.c;
            z = bannerManagerState == BannerManagerState.FIRST_AUCTION || bannerManagerState == BannerManagerState.AUCTION;
        }
        return z;
    }

    private boolean y0() {
        boolean z;
        synchronized (this.u) {
            BannerManagerState bannerManagerState = this.c;
            z = bannerManagerState == BannerManagerState.LOADING || bannerManagerState == BannerManagerState.RELOADING;
        }
        return z;
    }

    @Override // com.ironsource.mediationsdk.z
    public void C(com.ironsource.mediationsdk.logger.b bVar, ProgBannerSmash progBannerSmash, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + bVar);
        if (y0()) {
            this.s.put(progBannerSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
            A0();
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.c);
    }

    @Override // com.ironsource.mediationsdk.d
    public void I(List<f> list, String str, f fVar, JSONObject jSONObject, int i2, long j2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auctionId = " + str);
        if (x0()) {
            this.m = "";
            this.f5454k = str;
            this.n = i2;
            this.p = fVar;
            this.f5455l = jSONObject;
            E0(3502, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
            H0(this.c == BannerManagerState.FIRST_AUCTION ? BannerManagerState.LOADING : BannerManagerState.RELOADING);
            E0(3511, new Object[][]{new Object[]{"ext1", L0(list)}});
            A0();
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.c);
    }

    @Override // com.ironsource.mediationsdk.z
    public void M(ProgBannerSmash progBannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + progBannerSmash.D());
        if (y0()) {
            l0(view, layoutParams);
            this.s.put(progBannerSmash.x(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
            if (this.b.h()) {
                f fVar = this.r.get(progBannerSmash.x());
                if (fVar != null) {
                    this.o.g(fVar, progBannerSmash.E(), this.p);
                    this.o.e(this.f5453j, this.r, progBannerSmash.E(), this.p, fVar);
                    this.o.f(fVar, progBannerSmash.E(), this.p, s0());
                    Q(this.r.get(progBannerSmash.x()), s0());
                } else {
                    String x = progBannerSmash.x();
                    ironLog.error("onLoadSuccess winner instance " + x + " missing from waterfall. auctionId = " + this.f5454k);
                    E0(83317, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{"ext1", x}});
                }
            }
            if (this.c == BannerManagerState.LOADING) {
                this.f5448e.l(progBannerSmash.x());
                E0(3110, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.w))}});
            } else {
                IronSourceUtils.j0("bannerReloadSucceeded");
                E0(3116, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.w))}});
            }
            u0();
            SessionDepthManager.getInstance().d(3);
            H0(BannerManagerState.LOADED);
            this.f5447d.e(this);
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.c);
    }

    @Override // com.ironsource.mediationsdk.z
    public void a(ProgBannerSmash progBannerSmash) {
        IronLog.INTERNAL.verbose(progBannerSmash.D());
        D0(3119);
    }

    @Override // com.ironsource.mediationsdk.d
    public void f(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(str3);
        IronSourceUtils.j0("BN: " + str3);
        if (x0()) {
            this.m = str2;
            this.n = i3;
            this.f5455l = null;
            M0();
            E0(3501, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}, new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}});
            H0(this.c == BannerManagerState.FIRST_AUCTION ? BannerManagerState.LOADING : BannerManagerState.RELOADING);
            A0();
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.c);
    }

    @Override // com.ironsource.mediationsdk.z
    public void g(ProgBannerSmash progBannerSmash) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(progBannerSmash.D());
        if (m0()) {
            this.f5448e.m();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        F0(3114, objArr, progBannerSmash.K());
    }

    @Override // com.ironsource.mediationsdk.z
    public void j(ProgBannerSmash progBannerSmash) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(progBannerSmash.D());
        if (m0()) {
            this.f5448e.j();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        F0(3112, objArr, progBannerSmash.K());
    }

    @Override // com.ironsource.mediationsdk.z
    public void o(ProgBannerSmash progBannerSmash) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(progBannerSmash.D());
        if (m0()) {
            this.f5448e.n();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        F0(3113, objArr, progBannerSmash.K());
    }

    @Override // com.ironsource.mediationsdk.p0.b.a
    public void r() {
        if (this.v.get()) {
            if (n0(BannerManagerState.LOADED, BannerManagerState.STARTED_LOADING)) {
                IronLog.INTERNAL.verbose("start loading");
                J0(true);
                return;
            }
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("wrong state = " + this.c);
            return;
        }
        IronLog.INTERNAL.verbose("app in background - start reload timer");
        E0(3200, new Object[][]{new Object[]{"errorCode", 614}});
        this.f5447d.e(this);
    }

    public void z0(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.model.h hVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("");
        if (n0(BannerManagerState.READY_TO_LOAD, BannerManagerState.STARTED_LOADING)) {
            if (!BannerCallbackThrottler.getInstance().b()) {
                h.d(ironSourceBannerLayout, hVar, new a(hVar, ironSourceBannerLayout));
                return;
            } else {
                ironLog.verbose("can't load banner - already has pending invocation");
                return;
            }
        }
        IronLog.API.error("can't load banner - loadBanner already called and still in progress");
    }
}
