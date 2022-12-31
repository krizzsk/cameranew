package com.ironsource.mediationsdk;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DemandOnlyIsManager.java */
/* loaded from: classes2.dex */
public class j implements com.ironsource.mediationsdk.n0.d {
    private ConcurrentHashMap<String, k> a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(List<com.ironsource.mediationsdk.model.l> list, com.ironsource.mediationsdk.model.j jVar, String str, String str2) {
        jVar.h();
        for (com.ironsource.mediationsdk.model.l lVar : list) {
            if (lVar.m().equalsIgnoreCase("SupersonicAds") || lVar.m().equalsIgnoreCase("IronSource")) {
                b f2 = AdapterRepository.getInstance().f(lVar, lVar.o(), true, false);
                if (f2 != null) {
                    this.a.put(lVar.p(), new k(str, str2, lVar, this, jVar.f(), f2));
                }
            } else {
                i("cannot load " + lVar.m());
            }
        }
    }

    private void i(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "DemandOnlyIsManager " + str, 0);
    }

    private void j(k kVar, String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyIsManager " + kVar.m() + " : " + str, 0);
    }

    private void k(int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("provider", "Mediation");
        hashMap.put("isDemandOnly", 1);
        if (str == null) {
            str = "";
        }
        hashMap.put("spId", str);
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(hashMap)));
    }

    private void l(int i2, k kVar) {
        m(i2, kVar, null);
    }

    private void m(int i2, k kVar, Object[][] objArr) {
        Map<String, Object> q = kVar.q();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    q.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "IS sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(q)));
    }

    @Override // com.ironsource.mediationsdk.n0.d
    public void a(com.ironsource.mediationsdk.logger.b bVar, k kVar) {
        j(kVar, "onInterstitialAdShowFailed error=" + bVar.toString());
        m(2203, kVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
        ISDemandOnlyListenerWrapper.getInstance().i(kVar.x(), bVar);
    }

    @Override // com.ironsource.mediationsdk.n0.d
    public void b(k kVar) {
        j(kVar, "onInterstitialAdOpened");
        l(2005, kVar);
        ISDemandOnlyListenerWrapper.getInstance().g(kVar.x());
        if (kVar.B()) {
            for (String str : kVar.f5405i) {
                AuctionDataUtils.getInstance().m("onInterstitialAdOpened", kVar.m(), AuctionDataUtils.getInstance().c(str, kVar.m(), kVar.n(), kVar.f5406j, "", "", "", ""));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.d
    public void c(k kVar) {
        j(kVar, "onInterstitialAdClosed");
        m(2204, kVar, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(SessionDepthManager.getInstance().b(2))}});
        SessionDepthManager.getInstance().d(2);
        ISDemandOnlyListenerWrapper.getInstance().e(kVar.x());
    }

    @Override // com.ironsource.mediationsdk.n0.d
    public void d(k kVar) {
        j(kVar, "onInterstitialAdClicked");
        l(AdError.INTERNAL_ERROR_2006, kVar);
        ISDemandOnlyListenerWrapper.getInstance().d(kVar.x());
    }

    @Override // com.ironsource.mediationsdk.n0.d
    public void e(k kVar, long j2) {
        j(kVar, "onInterstitialAdReady");
        m(AdError.INTERNAL_ERROR_2003, kVar, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        ISDemandOnlyListenerWrapper.getInstance().h(kVar.x());
    }

    @Override // com.ironsource.mediationsdk.n0.d
    public void f(k kVar) {
        l(2210, kVar);
        j(kVar, "onInterstitialAdVisible");
    }

    @Override // com.ironsource.mediationsdk.n0.d
    public void g(com.ironsource.mediationsdk.logger.b bVar, k kVar, long j2) {
        j(kVar, "onInterstitialAdLoadFailed error=" + bVar.toString());
        if (bVar.a() == 1158) {
            m(2213, kVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        } else {
            m(2200, kVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        }
        ISDemandOnlyListenerWrapper.getInstance().f(kVar.x(), bVar);
    }

    public void h(String str, String str2, boolean z) {
        try {
            if (!this.a.containsKey(str)) {
                k(2500, str);
                ISDemandOnlyListenerWrapper.getInstance().f(str, com.ironsource.mediationsdk.utils.f.h("Interstitial"));
                return;
            }
            k kVar = this.a.get(str);
            if (z) {
                if (!kVar.B()) {
                    com.ironsource.mediationsdk.logger.b e2 = com.ironsource.mediationsdk.utils.f.e("loadInterstitialWithAdm in IAB flow must be called by bidder instances");
                    i(e2.b());
                    l(2200, kVar);
                    ISDemandOnlyListenerWrapper.getInstance().f(str, e2);
                    return;
                }
                AuctionDataUtils.a f2 = AuctionDataUtils.getInstance().f(AuctionDataUtils.getInstance().a(str2));
                f g2 = AuctionDataUtils.getInstance().g(kVar.m(), f2.m());
                if (g2 != null) {
                    kVar.D(g2.g());
                    kVar.C(f2.h());
                    kVar.E(f2.l());
                    l(AdError.CACHE_ERROR_CODE, kVar);
                    kVar.L(g2.g(), f2.h(), f2.l(), g2.a());
                    return;
                }
                com.ironsource.mediationsdk.logger.b e3 = com.ironsource.mediationsdk.utils.f.e("loadInterstitialWithAdm invalid enriched adm");
                i(e3.b());
                l(2200, kVar);
                ISDemandOnlyListenerWrapper.getInstance().f(str, e3);
            } else if (!kVar.B()) {
                l(AdError.CACHE_ERROR_CODE, kVar);
                kVar.L("", "", null, null);
            } else {
                com.ironsource.mediationsdk.logger.b e4 = com.ironsource.mediationsdk.utils.f.e("loadInterstitialWithAdm in non IAB flow must be called by non bidder instances");
                i(e4.b());
                l(2200, kVar);
                ISDemandOnlyListenerWrapper.getInstance().f(str, e4);
            }
        } catch (Exception unused) {
            com.ironsource.mediationsdk.logger.b e5 = com.ironsource.mediationsdk.utils.f.e("loadInterstitialWithAdm exception");
            i(e5.b());
            ISDemandOnlyListenerWrapper.getInstance().f(str, e5);
        }
    }
}
