package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p0.c;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ProgBannerSmash extends c0 implements com.ironsource.mediationsdk.n0.c, c.a {

    /* renamed from: g  reason: collision with root package name */
    private g f5456g;

    /* renamed from: h  reason: collision with root package name */
    private com.ironsource.mediationsdk.p0.c f5457h;

    /* renamed from: i  reason: collision with root package name */
    private BannerSmashState f5458i;

    /* renamed from: j  reason: collision with root package name */
    private z f5459j;

    /* renamed from: k  reason: collision with root package name */
    private IronSourceBannerLayout f5460k;

    /* renamed from: l  reason: collision with root package name */
    private String f5461l;
    private JSONObject m;
    private int n;
    private String o;
    private com.ironsource.mediationsdk.model.h p;
    private final Object q;
    private com.ironsource.mediationsdk.utils.e r;
    private boolean s;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum BannerSmashState {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgBannerSmash(g gVar, z zVar, com.ironsource.mediationsdk.model.l lVar, b bVar, int i2, boolean z) {
        this(gVar, zVar, lVar, bVar, i2, "", null, 0, "", z);
    }

    private void O(Map<String, Object> map, r rVar) {
        try {
            String a = rVar.a();
            char c = 65535;
            switch (a.hashCode()) {
                case -387072689:
                    if (a.equals("RECTANGLE")) {
                        c = 2;
                        break;
                    }
                    break;
                case 72205083:
                    if (a.equals("LARGE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 79011241:
                    if (a.equals("SMART")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1951953708:
                    if (a.equals("BANNER")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1999208305:
                    if (a.equals("CUSTOM")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                map.put("bannerAdSize", 1);
            } else if (c == 1) {
                map.put("bannerAdSize", 2);
            } else if (c == 2) {
                map.put("bannerAdSize", 3);
            } else if (c == 3) {
                map.put("bannerAdSize", 5);
            } else if (c != 4) {
            } else {
                map.put("bannerAdSize", 6);
                map.put("custom_banner_size", rVar.c() + "x" + rVar.b());
            }
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
    }

    private boolean P(BannerSmashState bannerSmashState, BannerSmashState bannerSmashState2) {
        boolean z;
        synchronized (this.q) {
            if (this.f5458i == bannerSmashState) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(R() + "set state from '" + this.f5458i + "' to '" + bannerSmashState2 + "'");
                z = true;
                this.f5458i = bannerSmashState2;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void S(com.ironsource.mediationsdk.logger.b bVar) {
        boolean z = bVar.a() == 606;
        if (z) {
            Y(this.s ? 3307 : 3306, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.r))}});
        } else {
            Y(this.s ? 3301 : 3300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.r))}});
        }
        z zVar = this.f5459j;
        if (zVar != null) {
            zVar.C(bVar, this, z);
        }
    }

    private void T() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(R() + "isBidder = " + L());
        a0(BannerSmashState.INIT_IN_PROGRESS);
        Z();
        try {
            if (L()) {
                this.a.initBannerForBidding(this.f5456g.a(), this.f5456g.g(), this.f5538d, this);
            } else {
                this.a.initBanners(this.f5456g.a(), this.f5456g.g(), this.f5538d, this);
            }
        } catch (Throwable th) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("exception = " + th.getLocalizedMessage());
            q(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, th.getLocalizedMessage()));
        }
    }

    private boolean U() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f5460k;
        return ironSourceBannerLayout == null || ironSourceBannerLayout.h();
    }

    private void W(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(D());
        if (P(BannerSmashState.READY_TO_LOAD, BannerSmashState.LOADING)) {
            this.r = new com.ironsource.mediationsdk.utils.e();
            X(this.s ? 3012 : 3002);
            if (L()) {
                this.a.loadBannerForBidding(this.f5460k, this.f5538d, this, str);
                return;
            } else {
                this.a.loadBanner(this.f5460k, this.f5538d, this);
                return;
            }
        }
        ironLog.error("wrong state - state = " + this.f5458i);
    }

    private void Y(int i2, Object[][] objArr) {
        Map<String, Object> J = J();
        if (U()) {
            J.put("reason", "banner is destroyed");
        } else {
            O(J, this.f5460k.g());
        }
        if (!TextUtils.isEmpty(this.f5461l)) {
            J.put("auctionId", this.f5461l);
        }
        JSONObject jSONObject = this.m;
        if (jSONObject != null && jSONObject.length() > 0) {
            J.put("genericParams", this.m);
        }
        com.ironsource.mediationsdk.model.h hVar = this.p;
        if (hVar != null) {
            J.put("placement", hVar.c());
        }
        if (b0(i2)) {
            InterstitialEventsManager.getInstance().W(J, this.n, this.o);
        }
        J.put("sessionDepth", Integer.valueOf(this.f5540f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    J.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                IronLog.INTERNAL.error(x() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e2));
            }
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(J)));
    }

    private void Z() {
        if (this.a == null) {
            return;
        }
        try {
            String w = IronSourceObject.getInstance().w();
            if (!TextUtils.isEmpty(w)) {
                this.a.setMediationSegment(w);
            }
            String c = com.ironsource.mediationsdk.k0.a.a().c();
            if (TextUtils.isEmpty(c)) {
                return;
            }
            this.a.setPluginData(c, com.ironsource.mediationsdk.k0.a.a().b());
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("exception - " + e2.toString());
        }
    }

    private void a0(BannerSmashState bannerSmashState) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(R() + "state = " + bannerSmashState.name());
        synchronized (this.q) {
            this.f5458i = bannerSmashState;
        }
    }

    private boolean b0(int i2) {
        return i2 == 3005 || i2 == 3002 || i2 == 3012 || i2 == 3015 || i2 == 3008 || i2 == 3305 || i2 == 3300 || i2 == 3306 || i2 == 3307 || i2 == 3302 || i2 == 3303 || i2 == 3304 || i2 == 3009;
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void C() {
        IronLog.INTERNAL.verbose(D());
        X(3009);
        z zVar = this.f5459j;
        if (zVar != null) {
            zVar.a(this);
        }
    }

    public Map<String, Object> Q() {
        try {
            if (L()) {
                return this.a.getBannerBiddingData(this.f5538d);
            }
            return null;
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            return null;
        }
    }

    public String R() {
        return String.format("%s - ", D());
    }

    public void V(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.model.h hVar, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(D());
        this.p = hVar;
        if (!h.c(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            ironLog.verbose(str2);
            this.f5459j.C(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, str2), this, false);
        } else if (this.a == null) {
            ironLog.verbose("mAdapter is null");
            this.f5459j.C(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, "mAdapter is null"), this, false);
        } else {
            this.f5460k = ironSourceBannerLayout;
            this.f5457h.e(this);
            try {
                if (L()) {
                    W(str);
                } else {
                    T();
                }
            } catch (Throwable th) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.error("exception = " + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
    }

    public void X(int i2) {
        Y(i2, null);
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void b(com.ironsource.mediationsdk.logger.b bVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(R() + "error = " + bVar);
        this.f5457h.f();
        if (P(BannerSmashState.LOADING, BannerSmashState.LOAD_FAILED)) {
            S(bVar);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void l() {
        IronLog.INTERNAL.verbose(D());
        X(3008);
        z zVar = this.f5459j;
        if (zVar != null) {
            zVar.j(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void m() {
        IronLog.INTERNAL.verbose(D());
        X(3303);
        z zVar = this.f5459j;
        if (zVar != null) {
            zVar.g(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void n() {
        IronLog.INTERNAL.verbose(D());
        X(3302);
        z zVar = this.f5459j;
        if (zVar != null) {
            zVar.o(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(D());
        if (!P(BannerSmashState.INIT_IN_PROGRESS, BannerSmashState.READY_TO_LOAD) || L()) {
            return;
        }
        if (!h.c(this.f5460k)) {
            this.f5459j.C(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, this.f5460k == null ? "banner is null" : "banner is destroyed"), this, false);
        } else {
            W(null);
        }
    }

    @Override // com.ironsource.mediationsdk.p0.c.a
    public void onTimeout() {
        com.ironsource.mediationsdk.logger.b bVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(D());
        BannerSmashState bannerSmashState = BannerSmashState.INIT_IN_PROGRESS;
        BannerSmashState bannerSmashState2 = BannerSmashState.LOAD_FAILED;
        if (P(bannerSmashState, bannerSmashState2)) {
            ironLog.verbose("init timed out");
            bVar = new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_PATHMOTION_ARC, "Timed out");
        } else if (P(BannerSmashState.LOADING, bannerSmashState2)) {
            ironLog.verbose("load timed out");
            bVar = new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_DRAW_PATH, "Timed out");
        } else {
            ironLog.error("unexpected state - " + this.f5458i);
            return;
        }
        S(bVar);
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void q(com.ironsource.mediationsdk.logger.b bVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(R() + "error = " + bVar);
        this.f5457h.f();
        if (P(BannerSmashState.INIT_IN_PROGRESS, BannerSmashState.NONE)) {
            z zVar = this.f5459j;
            if (zVar != null) {
                zVar.C(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, "Banner init failed"), this, false);
                return;
            }
            return;
        }
        ironLog.warning("wrong state - mState = " + this.f5458i);
    }

    @Override // com.ironsource.mediationsdk.n0.c
    public void r(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(D());
        this.f5457h.f();
        if (P(BannerSmashState.LOADING, BannerSmashState.LOADED)) {
            Y(this.s ? 3015 : 3005, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.r))}});
            z zVar = this.f5459j;
            if (zVar != null) {
                zVar.M(this, view, layoutParams);
                return;
            }
            return;
        }
        X(this.s ? 3017 : 3007);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgBannerSmash(g gVar, z zVar, com.ironsource.mediationsdk.model.l lVar, b bVar, int i2, String str, JSONObject jSONObject, int i3, String str2, boolean z) {
        super(new com.ironsource.mediationsdk.model.a(lVar, lVar.d()), bVar);
        this.q = new Object();
        this.f5458i = BannerSmashState.NONE;
        this.f5456g = gVar;
        this.f5457h = new com.ironsource.mediationsdk.p0.c(gVar.d());
        this.f5459j = zVar;
        this.f5540f = i2;
        this.f5461l = str;
        this.n = i3;
        this.o = str2;
        this.m = jSONObject;
        this.s = z;
        this.a.addBannerListener(this);
        if (L()) {
            T();
        }
    }
}
