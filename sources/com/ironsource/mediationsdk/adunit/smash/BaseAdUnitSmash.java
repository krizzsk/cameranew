package com.ironsource.mediationsdk.adunit.smash;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.adunit.adapter.utility.ErrorType;
import com.ironsource.mediationsdk.adunit.events.AdUnitEvents;
import com.ironsource.mediationsdk.adunit.events.AdUnitEventsWrapper;
import com.ironsource.mediationsdk.adunit.events.g;
import com.ironsource.mediationsdk.j0.a.c.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p0.c;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.e;
import com.ironsource.mediationsdk.utils.f;
import com.ironsource.mediationsdk.utils.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes2.dex */
public abstract class BaseAdUnitSmash implements com.ironsource.mediationsdk.j0.a.d.a, com.ironsource.mediationsdk.j0.a.d.b, c.a, com.ironsource.mediationsdk.adunit.events.b, m.a {
    protected a a;
    protected com.ironsource.mediationsdk.adunit.manager.c b;
    protected d<?> c;

    /* renamed from: d  reason: collision with root package name */
    protected AdUnitEventsWrapper f5523d;

    /* renamed from: e  reason: collision with root package name */
    protected SmashState f5524e;

    /* renamed from: f  reason: collision with root package name */
    protected String f5525f;

    /* renamed from: g  reason: collision with root package name */
    protected com.ironsource.mediationsdk.model.a f5526g;

    /* renamed from: h  reason: collision with root package name */
    protected JSONObject f5527h;

    /* renamed from: i  reason: collision with root package name */
    protected String f5528i;

    /* renamed from: j  reason: collision with root package name */
    private e f5529j;

    /* renamed from: k  reason: collision with root package name */
    private c f5530k;

    /* renamed from: l  reason: collision with root package name */
    private com.ironsource.mediationsdk.adunit.adapter.utility.a f5531l;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum SmashState {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        FAILED
    }

    public BaseAdUnitSmash(a aVar, d<?> dVar, com.ironsource.mediationsdk.model.a aVar2, com.ironsource.mediationsdk.adunit.manager.c cVar) {
        this.a = aVar;
        this.b = cVar;
        this.f5523d = new AdUnitEventsWrapper(aVar.a(), AdUnitEventsWrapper.Level.PROVIDER, this);
        this.f5526g = aVar2;
        this.f5527h = aVar2.b();
        this.c = dVar;
        this.f5530k = new c(this.a.f() * 1000);
        w(SmashState.NONE);
    }

    private com.ironsource.mediationsdk.adunit.adapter.utility.a h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(GuestProfileFragment.USER_ID, this.a.i());
        hashMap.putAll(com.ironsource.mediationsdk.q0.a.b(this.f5527h));
        return new com.ironsource.mediationsdk.adunit.adapter.utility.a(str, hashMap);
    }

    private String i(String str) {
        String str2 = this.a.a().name() + " - " + j() + " - state = " + this.f5524e;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + " - " + str;
    }

    private int l() {
        return 1;
    }

    private boolean q() {
        return this.f5524e == SmashState.INIT_IN_PROGRESS;
    }

    private void s() {
        IronLog.INTERNAL.verbose(i("serverData = " + this.f5531l.a()));
        w(SmashState.LOADING);
        this.f5530k.e(this);
        try {
            this.c.o(this.f5531l, ContextProvider.getInstance().b(), this);
        } catch (Throwable th) {
            String str = "unexpected error while calling adapter.loadAd() - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(i(str));
            this.f5523d.f5506i.f(str);
            e(ErrorType.INTERNAL, TypedValues.PositionType.TYPE_POSITION_TYPE, str);
        }
    }

    private void w(SmashState smashState) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i("to " + smashState));
        this.f5524e = smashState;
    }

    private boolean y(AdUnitEvents adUnitEvents) {
        return adUnitEvents == AdUnitEvents.LOAD_AD || adUnitEvents == AdUnitEvents.LOAD_AD_SUCCESS || adUnitEvents == AdUnitEvents.LOAD_AD_FAILED || adUnitEvents == AdUnitEvents.AD_OPENED || adUnitEvents == AdUnitEvents.AD_CLOSED || adUnitEvents == AdUnitEvents.SHOW_AD || adUnitEvents == AdUnitEvents.SHOW_AD_FAILED || adUnitEvents == AdUnitEvents.AD_CLICKED;
    }

    @Override // com.ironsource.mediationsdk.utils.m.a
    public int B() {
        return this.f5526g.d();
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.e.a
    public void a() {
        IronLog.INTERNAL.verbose(i(""));
        this.f5530k.f();
        SmashState smashState = this.f5524e;
        if (smashState == SmashState.LOADING) {
            long a = e.a(this.f5529j);
            this.f5523d.f5503f.f(a);
            w(SmashState.LOADED);
            this.b.i(this, a);
        } else if (smashState == SmashState.FAILED) {
        } else {
            g gVar = this.f5523d.f5506i;
            gVar.o("unexpected load success for " + j());
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.e.a
    public void b(int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i("error = " + i2 + ", " + str));
        this.f5523d.f5505h.i(this.f5525f, i2, str);
        this.b.g(new com.ironsource.mediationsdk.logger.b(i2, str), this);
    }

    @Override // com.ironsource.mediationsdk.j0.a.d.b
    public void c(int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i("error = " + i2 + ", " + str));
        if (q()) {
            this.f5530k.f();
            w(SmashState.FAILED);
            this.b.e(new com.ironsource.mediationsdk.logger.b(i2, str), this, e.a(this.f5529j));
        } else if (this.f5524e == SmashState.FAILED) {
        } else {
            g gVar = this.f5523d.f5506i;
            gVar.l("unexpected init failed for " + j() + ", error - " + i2 + ", " + str);
        }
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [com.ironsource.mediationsdk.j0.a.c.a] */
    /* JADX WARN: Type inference failed for: r2v18, types: [com.ironsource.mediationsdk.j0.a.c.a] */
    @Override // com.ironsource.mediationsdk.adunit.events.b
    public Map<String, Object> d(AdUnitEvents adUnitEvents) {
        HashMap hashMap = new HashMap();
        try {
            d<?> dVar = this.c;
            hashMap.put("providerAdapterVersion", dVar != null ? dVar.m().i() : "");
            d<?> dVar2 = this.c;
            hashMap.put("providerSDKVersion", dVar2 != null ? dVar2.m().b() : "");
        } catch (Exception unused) {
            String str = "could not get adapter version for event data" + j();
            IronLog.INTERNAL.error(i(str));
            this.f5523d.f5506i.g(str);
        }
        hashMap.put("spId", this.f5526g.h());
        hashMap.put("provider", this.f5526g.a());
        hashMap.put("instanceType", Integer.valueOf(m() ? 2 : 1));
        hashMap.put("programmatic", Integer.valueOf(l()));
        if (!TextUtils.isEmpty(this.f5528i)) {
            hashMap.put("dynamicDemandSource", this.f5528i);
        }
        hashMap.put("sessionDepth", Integer.valueOf(this.a.h()));
        if (this.a.e() != null && this.a.e().length() > 0) {
            hashMap.put("genericParams", this.a.e());
        }
        if (!TextUtils.isEmpty(this.a.c())) {
            hashMap.put("auctionId", this.a.c());
        }
        if (y(adUnitEvents)) {
            hashMap.put("auctionTrials", Integer.valueOf(this.a.d()));
            if (!TextUtils.isEmpty(this.a.b())) {
                hashMap.put("auctionFallback", this.a.b());
            }
        }
        return hashMap;
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.e.a
    public void e(ErrorType errorType, int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i("error = " + i2 + ", " + str));
        this.f5530k.f();
        SmashState smashState = this.f5524e;
        if (smashState == SmashState.LOADING) {
            long a = e.a(this.f5529j);
            if (errorType == ErrorType.NO_FILL) {
                this.f5523d.f5503f.e(a, i2);
            } else {
                this.f5523d.f5503f.c(a, i2, str);
            }
            w(SmashState.FAILED);
            this.b.e(new com.ironsource.mediationsdk.logger.b(i2, str), this, a);
        } else if (smashState == SmashState.FAILED) {
        } else {
            g gVar = this.f5523d.f5506i;
            gVar.n("unexpected load failed for " + j() + ", error - " + i2 + ", " + str);
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.e.a
    public void f() {
        IronLog.INTERNAL.verbose(i(""));
        this.f5523d.f5505h.j(this.f5525f);
        this.b.c(this);
    }

    @Override // com.ironsource.mediationsdk.j0.a.d.b
    public void g() {
        IronLog.INTERNAL.verbose(i(""));
        if (q()) {
            this.f5530k.f();
            w(SmashState.READY_TO_LOAD);
            s();
        } else if (this.f5524e == SmashState.FAILED) {
        } else {
            g gVar = this.f5523d.f5506i;
            gVar.m("unexpected init success for " + j());
        }
    }

    public String j() {
        return String.format("%s %s", x(), Integer.valueOf(hashCode()));
    }

    public int k() {
        return this.f5526g.c();
    }

    public boolean m() {
        return this.f5526g.i();
    }

    public boolean n() {
        SmashState smashState = this.f5524e;
        return smashState == SmashState.INIT_IN_PROGRESS || smashState == SmashState.LOADING;
    }

    public boolean o() {
        return this.f5524e != SmashState.FAILED;
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.e.a
    public void onAdClicked() {
        IronLog.INTERNAL.verbose(i(""));
        this.f5523d.f5505h.c(this.f5525f);
        this.b.h(this);
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.e.a
    public void onAdClosed() {
        IronLog.INTERNAL.verbose(i(""));
        this.f5523d.f5505h.d(this.f5525f);
        this.b.b(this);
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.e.a
    public void onAdOpened() {
        IronLog.INTERNAL.verbose(i(""));
        this.f5523d.f5505h.e(this.f5525f);
        this.b.a(this);
    }

    @Override // com.ironsource.mediationsdk.p0.c.a
    public void onTimeout() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i("state = " + this.f5524e + ", isBidder = " + m()));
        w(SmashState.FAILED);
        this.f5523d.f5503f.c(e.a(this.f5529j), TypedValues.PositionType.TYPE_POSITION_TYPE, "time out");
        this.b.e(f.e("timed out"), this, e.a(this.f5529j));
    }

    public boolean p() {
        com.ironsource.mediationsdk.adunit.adapter.utility.a aVar = this.f5531l;
        if (aVar != null) {
            try {
                return this.c.n(aVar);
            } catch (Throwable th) {
                String str = "isReadyToShow - exception = " + th.getLocalizedMessage();
                IronLog.INTERNAL.error(i(str));
                this.f5523d.f5506i.f(str);
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r4v8, types: [com.ironsource.mediationsdk.j0.a.c.a] */
    public void r(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i(""));
        try {
            this.f5523d.f5503f.d();
            this.f5529j = new e();
            this.f5531l = h(str);
            w(SmashState.INIT_IN_PROGRESS);
            this.f5530k.e(this);
            ?? m = this.c.m();
            if (m != 0) {
                m.l(this.f5531l, ContextProvider.getInstance().a(), this);
            } else {
                String str2 = "loadAd - network adapter not available " + j();
                ironLog.error(i(str2));
                this.f5523d.f5506i.g(str2);
                c(TypedValues.PositionType.TYPE_POSITION_TYPE, str2);
            }
        } catch (Throwable th) {
            String str3 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(i(str3));
            this.f5523d.f5506i.f(str3);
            c(TypedValues.PositionType.TYPE_POSITION_TYPE, str3);
        }
    }

    public void t() {
        this.c = null;
    }

    public void u() {
        IronLog.INTERNAL.verbose(i(""));
        this.f5523d.f5505h.g();
    }

    public void v(String str) {
        this.f5528i = AuctionDataUtils.getInstance().l(str);
    }

    @Override // com.ironsource.mediationsdk.utils.m.a
    public String x() {
        return this.f5526g.e();
    }

    public void z(String str) {
        try {
            this.f5525f = str;
            this.f5523d.f5505h.h(str);
            this.c.q(this.f5531l, this);
        } catch (Throwable th) {
            String str2 = "showAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(i(str2));
            this.f5523d.f5506i.f(str2);
            b(1039, str2);
        }
    }
}
