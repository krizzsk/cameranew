package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.ConnectionResult;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DemandOnlyRvManager.java */
/* loaded from: classes2.dex */
public class l implements com.ironsource.mediationsdk.n0.e {
    private ConcurrentHashMap<String, m> a = new ConcurrentHashMap<>();
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(List<com.ironsource.mediationsdk.model.l> list, com.ironsource.mediationsdk.model.s sVar, String str, String str2) {
        this.b = str;
        sVar.j();
        for (com.ironsource.mediationsdk.model.l lVar : list) {
            if (lVar.m().equalsIgnoreCase("SupersonicAds") || lVar.m().equalsIgnoreCase("IronSource")) {
                b f2 = AdapterRepository.getInstance().f(lVar, lVar.o(), true, false);
                if (f2 != null) {
                    this.a.put(lVar.p(), new m(str, str2, lVar, this, sVar.h(), f2));
                }
            } else {
                j("cannot load " + lVar.m());
            }
        }
    }

    private void j(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "DemandOnlyRvManager " + str, 0);
    }

    private void k(m mVar, String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRvManager " + mVar.m() + " : " + str, 0);
    }

    private void l(int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("provider", "Mediation");
        hashMap.put("isDemandOnly", 1);
        if (str == null) {
            str = "";
        }
        hashMap.put("spId", str);
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(hashMap)));
    }

    private void m(int i2, m mVar) {
        n(i2, mVar, null);
    }

    private void n(int i2, m mVar, Object[][] objArr) {
        Map<String, Object> q = mVar.q();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    q.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "RV sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(q)));
    }

    @Override // com.ironsource.mediationsdk.n0.e
    public void a(m mVar) {
        k(mVar, "onRewardedVideoAdClosed");
        n(1203, mVar, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(SessionDepthManager.getInstance().b(1))}});
        SessionDepthManager.getInstance().d(1);
        RVDemandOnlyListenerWrapper.getInstance().e(mVar.x());
    }

    @Override // com.ironsource.mediationsdk.n0.e
    public void b(m mVar) {
        k(mVar, "onRewardedVideoAdClicked");
        m(1006, mVar);
        RVDemandOnlyListenerWrapper.getInstance().d(mVar.x());
    }

    @Override // com.ironsource.mediationsdk.n0.e
    public void c(m mVar) {
        k(mVar, "onRewardedVideoAdRewarded");
        Map<String, Object> q = mVar.q();
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().q())) {
            q.put("dynamicUserId", IronSourceObject.getInstance().q());
        }
        if (IronSourceObject.getInstance().z() != null) {
            for (String str : IronSourceObject.getInstance().z().keySet()) {
                q.put("custom_" + str, IronSourceObject.getInstance().z().get(str));
            }
        }
        com.ironsource.mediationsdk.model.o c = IronSourceObject.getInstance().o().b().e().c();
        if (c != null) {
            q.put("placement", c.c());
            q.put("rewardName", c.e());
            q.put("rewardAmount", Integer.valueOf(c.d()));
        } else {
            com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "defaultPlacement is null", 3);
        }
        d.e.b.b bVar = new d.e.b.b(1010, new JSONObject(q));
        bVar.a("transId", IronSourceUtils.O("" + Long.toString(bVar.e()) + this.b + mVar.m()));
        RewardedVideoEventsManager.getInstance().P(bVar);
        RVDemandOnlyListenerWrapper.getInstance().h(mVar.x());
    }

    @Override // com.ironsource.mediationsdk.n0.e
    public void d(com.ironsource.mediationsdk.logger.b bVar, m mVar) {
        k(mVar, "onRewardedVideoAdShowFailed error=" + bVar);
        n(1202, mVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}});
        RVDemandOnlyListenerWrapper.getInstance().i(mVar.x(), bVar);
    }

    @Override // com.ironsource.mediationsdk.n0.e
    public void e(m mVar, long j2) {
        k(mVar, "onRewardedVideoLoadSuccess");
        n(1002, mVar, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        RVDemandOnlyListenerWrapper.getInstance().j(mVar.x());
    }

    @Override // com.ironsource.mediationsdk.n0.e
    public void f(com.ironsource.mediationsdk.logger.b bVar, m mVar, long j2) {
        k(mVar, "onRewardedVideoAdLoadFailed error=" + bVar);
        n(1200, mVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        if (bVar.a() == 1058) {
            n(1213, mVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        } else {
            n(1212, mVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(j2)}});
        }
        RVDemandOnlyListenerWrapper.getInstance().f(mVar.x(), bVar);
    }

    @Override // com.ironsource.mediationsdk.n0.e
    public void g(m mVar) {
        k(mVar, "onRewardedVideoAdVisible");
        m(1206, mVar);
    }

    @Override // com.ironsource.mediationsdk.n0.e
    public void h(m mVar) {
        k(mVar, "onRewardedVideoAdOpened");
        m(CloseFrame.NOCODE, mVar);
        RVDemandOnlyListenerWrapper.getInstance().g(mVar.x());
        if (mVar.B()) {
            for (String str : mVar.f5405i) {
                AuctionDataUtils.getInstance().m("onRewardedVideoAdOpened", mVar.m(), AuctionDataUtils.getInstance().c(str, mVar.m(), mVar.n(), mVar.f5406j, "", "", "", ""));
            }
        }
    }

    public void i(String str, String str2, boolean z) {
        try {
            if (!this.a.containsKey(str)) {
                l(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, str);
                RVDemandOnlyListenerWrapper.getInstance().f(str, com.ironsource.mediationsdk.utils.f.h("Rewarded Video"));
                return;
            }
            m mVar = this.a.get(str);
            if (z) {
                if (!mVar.B()) {
                    com.ironsource.mediationsdk.logger.b e2 = com.ironsource.mediationsdk.utils.f.e("loadRewardedVideoWithAdm in IAB flow must be called by bidder instances");
                    j(e2.b());
                    m(1200, mVar);
                    RVDemandOnlyListenerWrapper.getInstance().f(str, e2);
                    return;
                }
                AuctionDataUtils.a f2 = AuctionDataUtils.getInstance().f(AuctionDataUtils.getInstance().a(str2));
                f g2 = AuctionDataUtils.getInstance().g(mVar.m(), f2.m());
                if (g2 != null) {
                    mVar.D(g2.g());
                    mVar.C(f2.h());
                    mVar.E(f2.l());
                    m(1001, mVar);
                    mVar.L(g2.g(), f2.h(), f2.l(), g2.a());
                    return;
                }
                com.ironsource.mediationsdk.logger.b e3 = com.ironsource.mediationsdk.utils.f.e("loadRewardedVideoWithAdm invalid enriched adm");
                j(e3.b());
                m(1200, mVar);
                RVDemandOnlyListenerWrapper.getInstance().f(str, e3);
            } else if (!mVar.B()) {
                m(1001, mVar);
                mVar.L("", "", null, null);
            } else {
                com.ironsource.mediationsdk.logger.b e4 = com.ironsource.mediationsdk.utils.f.e("loadRewardedVideoWithAdm in non IAB flow must be called by non bidder instances");
                j(e4.b());
                m(1200, mVar);
                RVDemandOnlyListenerWrapper.getInstance().f(str, e4);
            }
        } catch (Exception e5) {
            j("loadRewardedVideoWithAdm exception " + e5.getMessage());
            RVDemandOnlyListenerWrapper.getInstance().f(str, com.ironsource.mediationsdk.utils.f.e("loadRewardedVideoWithAdm exception"));
        }
    }
}
