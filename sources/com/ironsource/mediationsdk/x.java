package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.ErrorType;
import com.ironsource.mediationsdk.adunit.events.AdUnitEventsWrapper;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Map;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* compiled from: NetworkAdapterBridge.java */
/* loaded from: classes2.dex */
public class x extends com.ironsource.mediationsdk.j0.a.c.d<x> implements com.ironsource.mediationsdk.j0.a.c.a, com.ironsource.mediationsdk.j0.a.c.c, Object, com.ironsource.mediationsdk.j0.a.a {
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private com.ironsource.mediationsdk.j0.a.d.b f5675d;

    /* renamed from: e  reason: collision with root package name */
    private com.ironsource.mediationsdk.j0.a.d.a f5676e;

    /* renamed from: f  reason: collision with root package name */
    private com.ironsource.mediationsdk.model.l f5677f;

    /* renamed from: g  reason: collision with root package name */
    private IronSource.AD_UNIT f5678g;

    /* renamed from: h  reason: collision with root package name */
    protected AdUnitEventsWrapper f5679h;

    public x(b bVar, com.ironsource.mediationsdk.model.l lVar, IronSource.AD_UNIT ad_unit) {
        super(ad_unit, lVar);
        this.c = bVar;
        this.f5677f = lVar;
        this.f5678g = ad_unit;
        this.f5679h = new AdUnitEventsWrapper(ad_unit, AdUnitEventsWrapper.Level.PROVIDER, null);
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.c.addInterstitialListener(this);
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error(r("ad unit not supported - " + this.f5678g));
    }

    private String r(String str) {
        String str2 = this.f5678g + ", " + this.f5677f.k();
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + " - " + str;
    }

    private boolean t(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f5678g == IronSource.AD_UNIT.INTERSTITIAL) {
            return bVar.a() == 1158;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error(r("ad unit not supported - " + this.f5678g));
        return false;
    }

    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(r("error = " + bVar));
        com.ironsource.mediationsdk.j0.a.d.a aVar = this.f5676e;
        if (aVar != null) {
            aVar.e(t(bVar) ? ErrorType.NO_FILL : ErrorType.INTERNAL, bVar.a(), bVar.b());
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.a
    public String b() {
        return this.c.getCoreSDKVersion();
    }

    public void c() {
        IronLog.ADAPTER_CALLBACK.verbose(r(""));
        com.ironsource.mediationsdk.j0.a.d.a aVar = this.f5676e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.a
    public void d(boolean z) {
        this.c.setAdapterDebug(Boolean.valueOf(z));
    }

    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(r("error = " + bVar));
        com.ironsource.mediationsdk.j0.a.d.a aVar = this.f5676e;
        if (aVar != null) {
            aVar.b(bVar.a(), bVar.b());
        }
    }

    public void f() {
        IronLog.ADAPTER_CALLBACK.verbose(r(""));
        com.ironsource.mediationsdk.j0.a.d.a aVar = this.f5676e;
        if (aVar != null) {
            aVar.onAdClosed();
        }
    }

    public void g() {
        IronLog.ADAPTER_CALLBACK.verbose(r(""));
        com.ironsource.mediationsdk.j0.a.d.a aVar = this.f5676e;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public void h() {
        IronLog.ADAPTER_CALLBACK.verbose(r(""));
        com.ironsource.mediationsdk.j0.a.d.a aVar = this.f5676e;
        if (aVar != null) {
            aVar.onAdOpened();
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.a
    public String i() {
        return this.c.getVersion();
    }

    public void j() {
        IronLog.ADAPTER_CALLBACK.verbose(r(""));
        com.ironsource.mediationsdk.j0.a.d.a aVar = this.f5676e;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.c
    public Map<String, Object> k(Context context) {
        try {
            if (this.f5678g == IronSource.AD_UNIT.INTERSTITIAL) {
                return this.c.getInterstitialBiddingData(this.f5677f.h());
            }
            IronLog.INTERNAL.error(r("ad unit not supported - " + this.f5678g));
            return null;
        } catch (Throwable th) {
            String str = "getBiddingData exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(r(str));
            this.f5679h.f5506i.d(str);
            return null;
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.a
    public void l(com.ironsource.mediationsdk.adunit.adapter.utility.a aVar, Context context, com.ironsource.mediationsdk.j0.a.d.b bVar) {
        this.f5675d = bVar;
        String b = aVar.b(GuestProfileFragment.USER_ID);
        u();
        try {
            if (this.f5678g == IronSource.AD_UNIT.INTERSTITIAL) {
                if (TextUtils.isEmpty(aVar.a())) {
                    this.c.initInterstitial("", b, this.f5677f.h(), this);
                } else {
                    this.c.initInterstitialForBidding("", b, this.f5677f.h(), this);
                }
            } else {
                IronLog.INTERNAL.error("ad unit not supported - " + this.f5678g);
            }
        } catch (Throwable th) {
            String str = "init failed - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(r(str));
            this.f5679h.f5506i.d(str);
            w(new com.ironsource.mediationsdk.logger.b(1041, str));
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.d
    public /* bridge */ /* synthetic */ x m() {
        s();
        return this;
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.d
    public boolean n(com.ironsource.mediationsdk.adunit.adapter.utility.a aVar) {
        try {
            if (this.f5678g == IronSource.AD_UNIT.INTERSTITIAL) {
                return this.c.isInterstitialReady(this.f5677f.h());
            }
            IronLog.INTERNAL.error(r("ad unit not supported - " + this.f5678g));
            return false;
        } catch (Throwable th) {
            String str = "isAdAvailable exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(r(str));
            this.f5679h.f5506i.d(str);
            return false;
        }
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.d
    public void o(com.ironsource.mediationsdk.adunit.adapter.utility.a aVar, Activity activity, com.ironsource.mediationsdk.j0.a.d.a aVar2) {
        this.f5676e = aVar2;
        try {
            if (this.f5678g == IronSource.AD_UNIT.INTERSTITIAL) {
                if (TextUtils.isEmpty(aVar.a())) {
                    this.c.loadInterstitial(this.f5677f.h(), this);
                } else {
                    this.c.loadInterstitialForBidding(this.f5677f.h(), this, aVar.a());
                }
            } else {
                IronLog.INTERNAL.error(r("ad unit not supported - " + this.f5678g));
            }
        } catch (Throwable th) {
            String str = "loadAd exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(r(str));
            this.f5679h.f5506i.d(str);
            a(new com.ironsource.mediationsdk.logger.b(TypedValues.PositionType.TYPE_POSITION_TYPE, str));
        }
    }

    public void onInterstitialInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(r(""));
        com.ironsource.mediationsdk.j0.a.d.b bVar = this.f5675d;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void p() {
    }

    @Override // com.ironsource.mediationsdk.j0.a.c.d
    public void q(com.ironsource.mediationsdk.adunit.adapter.utility.a aVar, com.ironsource.mediationsdk.j0.a.d.a aVar2) {
        this.f5676e = aVar2;
        try {
            if (this.f5678g == IronSource.AD_UNIT.INTERSTITIAL) {
                this.c.showInterstitial(this.f5677f.h(), this);
            } else {
                IronLog.INTERNAL.error(r("ad unit not supported - " + this.f5678g));
            }
        } catch (Throwable th) {
            String str = "showAd exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(r(str));
            this.f5679h.f5506i.d(str);
            e(new com.ironsource.mediationsdk.logger.b(TypedValues.PositionType.TYPE_POSITION_TYPE, str));
        }
    }

    public x s() {
        return this;
    }

    void u() {
        try {
            String w = IronSourceObject.getInstance().w();
            if (!TextUtils.isEmpty(w)) {
                this.c.setMediationSegment(w);
            }
            String c = com.ironsource.mediationsdk.k0.a.a().c();
            if (TextUtils.isEmpty(c)) {
                return;
            }
            this.c.setPluginData(c, com.ironsource.mediationsdk.k0.a.a().b());
        } catch (Throwable th) {
            String str = "setCustomParams exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(r(str));
            this.f5679h.f5506i.d(str);
        }
    }

    public void w(com.ironsource.mediationsdk.logger.b bVar) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(r("error = " + bVar));
        com.ironsource.mediationsdk.j0.a.d.b bVar2 = this.f5675d;
        if (bVar2 != null) {
            bVar2.c(bVar.a(), bVar.b());
        }
    }
}
