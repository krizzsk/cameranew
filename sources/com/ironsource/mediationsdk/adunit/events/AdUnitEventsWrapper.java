package com.ironsource.mediationsdk.adunit.events;

import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdUnitEventsWrapper {
    private IronSource.AD_UNIT a;
    private Level b;
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private com.ironsource.mediationsdk.events.b f5501d;

    /* renamed from: e  reason: collision with root package name */
    public e f5502e;

    /* renamed from: f  reason: collision with root package name */
    public f f5503f;

    /* renamed from: g  reason: collision with root package name */
    public c f5504g;

    /* renamed from: h  reason: collision with root package name */
    public com.ironsource.mediationsdk.adunit.events.a f5505h;

    /* renamed from: i  reason: collision with root package name */
    public g f5506i;

    /* renamed from: j  reason: collision with root package name */
    private Map<AdUnitEvents, a> f5507j;

    /* loaded from: classes2.dex */
    public enum Level {
        MEDIATION,
        PROVIDER
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        private int a;
        private int b;

        public a(AdUnitEventsWrapper adUnitEventsWrapper, int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        int a(Level level) {
            return Level.MEDIATION.equals(level) ? this.a : this.b;
        }
    }

    public AdUnitEventsWrapper(IronSource.AD_UNIT ad_unit, Level level, b bVar) {
        this.a = ad_unit;
        this.b = level;
        this.c = bVar;
        a(ad_unit);
        b();
        this.f5502e = new e(this);
        this.f5503f = new f(this);
        this.f5504g = new c(this);
        this.f5505h = new com.ironsource.mediationsdk.adunit.events.a(this);
        this.f5506i = new g(this);
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        if (!ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) && !ad_unit.equals(IronSource.AD_UNIT.OFFERWALL)) {
            this.f5501d = InterstitialEventsManager.getInstance();
        } else {
            this.f5501d = RewardedVideoEventsManager.getInstance();
        }
    }

    private int d(AdUnitEvents adUnitEvents) {
        try {
            if (IronSource.AD_UNIT.INTERSTITIAL.equals(this.a)) {
                return this.f5507j.get(adUnitEvents).a(this.b);
            }
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    void b() {
        c();
    }

    void c() {
        HashMap hashMap = new HashMap();
        this.f5507j = hashMap;
        hashMap.put(AdUnitEvents.INIT_STARTED, new a(this, 82312, -1));
        this.f5507j.put(AdUnitEvents.INIT_ENDED, new a(this, 82313, -1));
        this.f5507j.put(AdUnitEvents.SESSION_CAPPED, new a(this, -1, 2401));
        this.f5507j.put(AdUnitEvents.PLACEMENT_CAPPED, new a(this, 2400, -1));
        this.f5507j.put(AdUnitEvents.AUCTION_REQUEST, new a(this, 2000, -1));
        this.f5507j.put(AdUnitEvents.AUCTION_SUCCESS, new a(this, 2301, -1));
        this.f5507j.put(AdUnitEvents.AUCTION_FAILED, new a(this, 2300, -1));
        this.f5507j.put(AdUnitEvents.AUCTION_REQUEST_WATERFALL, new a(this, 2310, -1));
        this.f5507j.put(AdUnitEvents.AUCTION_RESULT_WATERFALL, new a(this, 2311, -1));
        this.f5507j.put(AdUnitEvents.INIT_SUCCESS, new a(this, -1, 2205));
        this.f5507j.put(AdUnitEvents.INIT_FAILED, new a(this, -1, 2206));
        this.f5507j.put(AdUnitEvents.SHOW_AD_SUCCESS, new a(this, -1, 2202));
        this.f5507j.put(AdUnitEvents.AD_OPENED, new a(this, -1, 2005));
        this.f5507j.put(AdUnitEvents.AD_CLOSED, new a(this, -1, 2204));
        this.f5507j.put(AdUnitEvents.AD_CLICKED, new a(this, -1, AdError.INTERNAL_ERROR_2006));
        this.f5507j.put(AdUnitEvents.LOAD_AD, new a(this, AdError.INTERNAL_ERROR_CODE, AdError.CACHE_ERROR_CODE));
        this.f5507j.put(AdUnitEvents.LOAD_AD_SUCCESS, new a(this, AdError.INTERNAL_ERROR_2004, AdError.INTERNAL_ERROR_2003));
        this.f5507j.put(AdUnitEvents.LOAD_AD_FAILED, new a(this, 2110, 2200));
        this.f5507j.put(AdUnitEvents.LOAD_AD_NO_FILL, new a(this, -1, 2213));
        this.f5507j.put(AdUnitEvents.SHOW_AD, new a(this, AdError.BROKEN_MEDIA_ERROR_CODE, 2201));
        this.f5507j.put(AdUnitEvents.SHOW_AD_FAILED, new a(this, 2111, 2203));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_NETWORK_ADAPTER_NOT_AVAILABLE, new a(this, 82010, 82010));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_AD_ADAPTER_NOT_AVAILABLE, new a(this, 82011, 82011));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(this, 82040, 82040));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(this, 82041, 82041));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(this, 82050, 82050));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(this, 82051, 82051));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(this, 82060, 82060));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(this, 82061, 82061));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(this, 82070, 82070));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(this, 82071, 82071));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_INTERNAL_ERROR, new a(this, 82072, 82072));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_ADAPTER_BRIDGE_INTERNAL_ERROR, new a(this, 88000, 88000));
        this.f5507j.put(AdUnitEvents.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(this, 88001, 88001));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(AdUnitEvents adUnitEvents, Map<String, Object> map) {
        int d2 = d(adUnitEvents);
        if (-1 == d2) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        b bVar = this.c;
        if (bVar != null) {
            map.putAll(bVar.d(adUnitEvents));
        }
        this.f5501d.P(new d.e.b.b(d2, new JSONObject(map)));
    }
}
