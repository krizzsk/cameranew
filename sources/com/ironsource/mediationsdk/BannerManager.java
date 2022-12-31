package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BannerManager implements com.ironsource.mediationsdk.n0.b {
    private BannerSmash a;
    private IronSourceBannerLayout b;
    private com.ironsource.mediationsdk.model.h c;

    /* renamed from: f  reason: collision with root package name */
    private String f5385f;

    /* renamed from: g  reason: collision with root package name */
    private String f5386g;

    /* renamed from: i  reason: collision with root package name */
    private long f5388i;

    /* renamed from: j  reason: collision with root package name */
    private Timer f5389j;

    /* renamed from: l  reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.e f5391l;
    private com.ironsource.mediationsdk.utils.e m;
    private int n;
    private int o;

    /* renamed from: h  reason: collision with root package name */
    private final CopyOnWriteArrayList<BannerSmash> f5387h = new CopyOnWriteArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.c f5384e = com.ironsource.mediationsdk.logger.c.i();

    /* renamed from: d  reason: collision with root package name */
    private BANNER_STATE f5383d = BANNER_STATE.NOT_INITIATED;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f5390k = Boolean.TRUE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum BANNER_STATE {
        NOT_INITIATED,
        READY_TO_LOAD,
        FIRST_LOAD_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        RELOAD_IN_PROGRESS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BannerManager.this.q();
        }
    }

    public BannerManager(List<com.ironsource.mediationsdk.model.l> list, String str, String str2, long j2, int i2, int i3) {
        new AtomicBoolean();
        new AtomicBoolean();
        this.f5385f = str;
        this.f5386g = str2;
        this.f5388i = i2;
        BannerCallbackThrottler.getInstance().e(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            com.ironsource.mediationsdk.model.l lVar = list.get(i4);
            b f2 = AdapterRepository.getInstance().f(lVar, lVar.d(), false, false);
            if (f2 != null && AdaptersCompatibilityHandler.getInstance().d(f2)) {
                this.f5387h.add(new BannerSmash(this, lVar, f2, j2, i4 + 1));
            } else {
                m(lVar.k() + " can't load adapter or wrong version");
            }
        }
        this.c = null;
        y(BANNER_STATE.READY_TO_LOAD);
    }

    private void A() {
        Timer timer = this.f5389j;
        if (timer != null) {
            timer.cancel();
            this.f5389j = null;
        }
    }

    private void j(JSONObject jSONObject, r rVar) {
        try {
            String a2 = rVar.a();
            char c = 65535;
            switch (a2.hashCode()) {
                case -387072689:
                    if (a2.equals("RECTANGLE")) {
                        c = 2;
                        break;
                    }
                    break;
                case 72205083:
                    if (a2.equals("LARGE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 79011241:
                    if (a2.equals("SMART")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1951953708:
                    if (a2.equals("BANNER")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1999208305:
                    if (a2.equals("CUSTOM")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                jSONObject.put("bannerAdSize", 1);
            } else if (c == 1) {
                jSONObject.put("bannerAdSize", 2);
            } else if (c == 2) {
                jSONObject.put("bannerAdSize", 3);
            } else if (c == 3) {
                jSONObject.put("bannerAdSize", 5);
            } else if (c != 4) {
            } else {
                jSONObject.put("bannerAdSize", 6);
                jSONObject.put("custom_banner_size", rVar.c() + "x" + rVar.b());
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c cVar = this.f5384e;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, "sendProviderEvent " + Log.getStackTraceString(e2), 3);
        }
    }

    private void k(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        this.a = bannerSmash;
        this.b.e(view, layoutParams);
    }

    private boolean l() {
        IronSourceBannerLayout ironSourceBannerLayout = this.b;
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.h()) ? false : true;
    }

    private void m(String str) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5384e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, "BannerManager " + str, 0);
    }

    private boolean o() {
        Iterator<BannerSmash> it = this.f5387h.iterator();
        while (it.hasNext()) {
            BannerSmash next = it.next();
            if (next.k() && this.a != next) {
                if (this.f5383d == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
                    v(3002, next);
                } else {
                    v(3012, next);
                }
                this.m = new com.ironsource.mediationsdk.utils.e();
                next.o(this.b.i(), this.f5385f, this.f5386g);
                return true;
            }
        }
        return false;
    }

    private void p(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("bindView = " + z + " smash - " + bannerSmash.h());
        w(3015, bannerSmash, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.m))}});
        t(3116, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.f5391l))}});
        this.n = SessionDepthManager.getInstance().b(3);
        SessionDepthManager.getInstance().d(3);
        if (z) {
            k(bannerSmash, view, layoutParams);
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f5383d != BANNER_STATE.RELOAD_IN_PROGRESS) {
            m("onReloadTimer wrong state=" + this.f5383d.name());
        } else if (this.f5390k.booleanValue()) {
            this.o = SessionDepthManager.getInstance().b(3);
            s(3011);
            v(3012, this.a);
            this.f5391l = new com.ironsource.mediationsdk.utils.e();
            this.m = new com.ironsource.mediationsdk.utils.e();
            this.a.t();
        } else {
            t(3200, new Object[][]{new Object[]{"errorCode", 614}});
            z();
        }
    }

    private void r() {
        Iterator<BannerSmash> it = this.f5387h.iterator();
        while (it.hasNext()) {
            it.next().v(true);
        }
    }

    private void s(int i2) {
        t(i2, null);
    }

    private void t(int i2, Object[][] objArr) {
        u(i2, objArr, this.o);
    }

    private void u(int i2, Object[][] objArr, int i3) {
        JSONObject D = IronSourceUtils.D(false);
        try {
            IronSourceBannerLayout ironSourceBannerLayout = this.b;
            if (ironSourceBannerLayout != null) {
                j(D, ironSourceBannerLayout.g());
            }
            com.ironsource.mediationsdk.model.h hVar = this.c;
            if (hVar != null) {
                D.put("placement", hVar.c());
            }
            D.put("sessionDepth", i3);
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    D.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            this.f5384e.d(IronSourceLogger.IronSourceTag.INTERNAL, "sendMediationEvent " + Log.getStackTraceString(e2), 3);
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, D));
    }

    private void v(int i2, BannerSmash bannerSmash) {
        w(i2, bannerSmash, null);
    }

    private void w(int i2, BannerSmash bannerSmash, Object[][] objArr) {
        x(i2, bannerSmash, objArr, this.o);
    }

    private void x(int i2, BannerSmash bannerSmash, Object[][] objArr, int i3) {
        JSONObject H = IronSourceUtils.H(bannerSmash);
        try {
            IronSourceBannerLayout ironSourceBannerLayout = this.b;
            if (ironSourceBannerLayout != null) {
                j(H, ironSourceBannerLayout.g());
            }
            com.ironsource.mediationsdk.model.h hVar = this.c;
            if (hVar != null) {
                H.put("placement", hVar.c());
            }
            H.put("sessionDepth", i3);
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    H.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            this.f5384e.d(IronSourceLogger.IronSourceTag.INTERNAL, "sendProviderEvent " + Log.getStackTraceString(e2), 3);
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, H));
    }

    private void y(BANNER_STATE banner_state) {
        this.f5383d = banner_state;
        m("state=" + banner_state.name());
    }

    private void z() {
        try {
            A();
            if (this.f5388i > 0) {
                Timer timer = new Timer();
                this.f5389j = timer;
                timer.schedule(new a(), this.f5388i * 1000);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.n0.b
    public void a(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.h());
        BANNER_STATE banner_state = this.f5383d;
        if (banner_state == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
            w(3005, bannerSmash, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.m))}});
            k(bannerSmash, view, layoutParams);
            com.ironsource.mediationsdk.model.h hVar = this.c;
            String c = hVar != null ? hVar.c() : "";
            CappingManager.g(ContextProvider.getInstance().b(), c);
            if (CappingManager.m(ContextProvider.getInstance().b(), c)) {
                s(3400);
            }
            t(3110, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.f5391l))}});
            this.b.l(bannerSmash.h());
            this.n = SessionDepthManager.getInstance().b(3);
            SessionDepthManager.getInstance().d(3);
            y(BANNER_STATE.RELOAD_IN_PROGRESS);
            z();
        } else if (banner_state == BANNER_STATE.LOAD_IN_PROGRESS) {
            y(BANNER_STATE.RELOAD_IN_PROGRESS);
            p(bannerSmash, view, layoutParams, true);
        } else {
            v(3007, bannerSmash);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.b
    public void b(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.h());
        if (this.f5383d != BANNER_STATE.RELOAD_IN_PROGRESS) {
            m("onBannerAdReloaded " + bannerSmash.h() + " wrong state=" + this.f5383d.name());
            v(3017, bannerSmash);
            return;
        }
        IronSourceUtils.j0("bannerReloadSucceeded");
        p(bannerSmash, view, layoutParams, z);
    }

    @Override // com.ironsource.mediationsdk.n0.b
    public void c(com.ironsource.mediationsdk.logger.b bVar, BannerSmash bannerSmash, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("error = " + bVar.b() + " smash - " + bannerSmash.h());
        BANNER_STATE banner_state = this.f5383d;
        BANNER_STATE banner_state2 = BANNER_STATE.FIRST_LOAD_IN_PROGRESS;
        if (banner_state != banner_state2 && banner_state != BANNER_STATE.LOAD_IN_PROGRESS) {
            m("onBannerAdLoadFailed " + bannerSmash.h() + " wrong state=" + this.f5383d.name());
            return;
        }
        if (z) {
            w(3306, bannerSmash, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.m))}});
        } else {
            w(3300, bannerSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.m))}});
        }
        if (o()) {
            return;
        }
        if (this.f5383d == banner_state2) {
            BannerCallbackThrottler.getInstance().d(this.b, new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, "No ads to show"));
            t(3111, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.f5391l))}});
            y(BANNER_STATE.READY_TO_LOAD);
            return;
        }
        t(3201, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.f5391l))}});
        y(BANNER_STATE.RELOAD_IN_PROGRESS);
        z();
    }

    @Override // com.ironsource.mediationsdk.n0.b
    public void d(BannerSmash bannerSmash) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.h());
        if (l()) {
            this.b.n();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        u(3113, objArr, this.n);
        x(3302, bannerSmash, objArr, this.n);
    }

    @Override // com.ironsource.mediationsdk.n0.b
    public void e(BannerSmash bannerSmash) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.h());
        if (l()) {
            this.b.m();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        u(3114, objArr, this.n);
        x(3303, bannerSmash, objArr, this.n);
    }

    @Override // com.ironsource.mediationsdk.n0.b
    public void f(BannerSmash bannerSmash) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.h());
        if (l()) {
            this.b.j();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        u(3112, objArr, this.n);
        x(3008, bannerSmash, objArr, this.n);
    }

    @Override // com.ironsource.mediationsdk.n0.b
    public void g(com.ironsource.mediationsdk.logger.b bVar, BannerSmash bannerSmash, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("error = " + bVar.b() + " smash - " + bannerSmash.h());
        if (this.f5383d != BANNER_STATE.RELOAD_IN_PROGRESS) {
            m("onBannerAdReloadFailed " + bannerSmash.h() + " wrong state=" + this.f5383d.name());
            return;
        }
        if (z) {
            w(3307, bannerSmash, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.m))}});
        } else {
            w(3301, bannerSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.m))}});
        }
        if (this.f5387h.size() == 1) {
            t(3201, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.e.a(this.f5391l))}});
            z();
            return;
        }
        y(BANNER_STATE.LOAD_IN_PROGRESS);
        r();
        o();
    }

    @Override // com.ironsource.mediationsdk.n0.b
    public void h(BannerSmash bannerSmash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.h());
        s(3119);
        v(3009, bannerSmash);
    }

    public synchronized void n(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.model.h hVar) {
        if (ironSourceBannerLayout != null) {
            try {
            } catch (Exception e2) {
                BannerCallbackThrottler bannerCallbackThrottler = BannerCallbackThrottler.getInstance();
                bannerCallbackThrottler.d(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, "loadBanner() failed " + e2.getMessage()));
                t(3111, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO)}, new Object[]{"reason", e2.getMessage()}});
                y(BANNER_STATE.READY_TO_LOAD);
            }
            if (!ironSourceBannerLayout.h()) {
                if (hVar != null && !TextUtils.isEmpty(hVar.c())) {
                    BANNER_STATE banner_state = this.f5383d;
                    BANNER_STATE banner_state2 = BANNER_STATE.READY_TO_LOAD;
                    if (banner_state == banner_state2 && !BannerCallbackThrottler.getInstance().b()) {
                        this.o = SessionDepthManager.getInstance().b(3);
                        y(BANNER_STATE.FIRST_LOAD_IN_PROGRESS);
                        this.b = ironSourceBannerLayout;
                        this.c = hVar;
                        s(AdError.MEDIATION_ERROR_CODE);
                        if (CappingManager.m(ContextProvider.getInstance().b(), hVar.c())) {
                            BannerCallbackThrottler bannerCallbackThrottler2 = BannerCallbackThrottler.getInstance();
                            bannerCallbackThrottler2.d(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR, "placement " + hVar.c() + " is capped"));
                            t(3111, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR)}});
                            y(banner_state2);
                            return;
                        }
                        this.f5391l = new com.ironsource.mediationsdk.utils.e();
                        Iterator<BannerSmash> it = this.f5387h.iterator();
                        while (it.hasNext()) {
                            it.next().v(true);
                        }
                        this.m = new com.ironsource.mediationsdk.utils.e();
                        BannerSmash bannerSmash = this.f5387h.get(0);
                        v(3002, bannerSmash);
                        bannerSmash.o(ironSourceBannerLayout.i(), this.f5385f, this.f5386g);
                        return;
                    }
                    this.f5384e.d(IronSourceLogger.IronSourceTag.API, "A banner is already loaded", 3);
                    return;
                }
                Object[] objArr = new Object[1];
                objArr[0] = hVar == null ? "placement is null" : "placement name is empty";
                this.f5384e.d(IronSourceLogger.IronSourceTag.API, String.format("can't load banner - %s", objArr), 3);
                return;
            }
        }
        Object[] objArr2 = new Object[1];
        objArr2[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
        this.f5384e.d(IronSourceLogger.IronSourceTag.API, String.format("can't load banner - %s", objArr2), 3);
    }
}
