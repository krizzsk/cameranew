package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfferwallManager.java */
/* loaded from: classes2.dex */
public class y implements com.ironsource.mediationsdk.n0.j {
    private com.ironsource.mediationsdk.n0.p b;
    private com.ironsource.mediationsdk.n0.j c;

    /* renamed from: g  reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.k f5683g;

    /* renamed from: h  reason: collision with root package name */
    private com.ironsource.mediationsdk.model.l f5684h;

    /* renamed from: i  reason: collision with root package name */
    private String f5685i;
    private final String a = y.class.getName();

    /* renamed from: e  reason: collision with root package name */
    private AtomicBoolean f5681e = new AtomicBoolean(true);

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f5682f = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.c f5680d = com.ironsource.mediationsdk.logger.c.i();

    private String a(com.ironsource.mediationsdk.utils.k kVar) {
        return (kVar == null || kVar.b() == null || kVar.b().d() == null || kVar.b().d().b() == null) ? "SupersonicAds" : kVar.b().d().b();
    }

    private synchronized void c(com.ironsource.mediationsdk.logger.b bVar) {
        AtomicBoolean atomicBoolean = this.f5682f;
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        AtomicBoolean atomicBoolean2 = this.f5681e;
        if (atomicBoolean2 != null) {
            atomicBoolean2.set(true);
        }
        com.ironsource.mediationsdk.n0.j jVar = this.c;
        if (jVar != null) {
            jVar.q(false, bVar);
        }
    }

    private void d(b bVar) {
        try {
            String w = IronSourceObject.getInstance().w();
            if (w != null) {
                bVar.setMediationSegment(w);
            }
            Boolean n = IronSourceObject.getInstance().n();
            if (n != null) {
                com.ironsource.mediationsdk.logger.c cVar = this.f5680d;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
                cVar.d(ironSourceTag, "Offerwall | setConsent(consent:" + n + ")", 1);
                bVar.setConsent(n.booleanValue());
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c cVar2 = this.f5680d;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar2.d(ironSourceTag2, ":setCustomParams():" + e2.toString(), 3);
        }
    }

    private b f(String str) {
        try {
            IronSourceObject ironSourceObject = IronSourceObject.getInstance();
            b y = ironSourceObject.y(str);
            if (y == null) {
                Class<?> cls = Class.forName("com.ironsource.adapters." + com.ironsource.environment.j.a(str) + "." + str + "Adapter");
                y = (b) cls.getMethod("startAdapter", String.class).invoke(cls, str);
                if (y == null) {
                    return null;
                }
            }
            ironSourceObject.b(y);
            return y;
        } catch (Throwable th) {
            com.ironsource.mediationsdk.logger.c cVar = this.f5680d;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            cVar.d(ironSourceTag, str + " initialization failed - please verify that required dependencies are in you build path.", 2);
            com.ironsource.mediationsdk.logger.c cVar2 = this.f5680d;
            cVar2.e(ironSourceTag, this.a + ":startOfferwallAdapter", th);
            return null;
        }
    }

    public synchronized void b(String str, String str2) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5680d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        cVar.d(ironSourceTag, this.a + ":initOfferwall(appKey: " + str + ", userId: " + str2 + ")", 1);
        com.ironsource.mediationsdk.utils.k o = IronSourceObject.getInstance().o();
        this.f5683g = o;
        String a = a(o);
        com.ironsource.mediationsdk.utils.k kVar = this.f5683g;
        if (kVar == null) {
            c(com.ironsource.mediationsdk.utils.f.c("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        com.ironsource.mediationsdk.model.l d2 = kVar.i().d(a);
        this.f5684h = d2;
        if (d2 == null) {
            c(com.ironsource.mediationsdk.utils.f.c("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        b f2 = f(a);
        if (f2 == null) {
            c(com.ironsource.mediationsdk.utils.f.c("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        d(f2);
        f2.setLogListener(this.f5680d);
        com.ironsource.mediationsdk.n0.p pVar = (com.ironsource.mediationsdk.n0.p) f2;
        this.b = pVar;
        pVar.setInternalOfferwallListener(this);
        this.b.initOfferwall(str, str2, this.f5684h.o());
    }

    public void e(com.ironsource.mediationsdk.n0.j jVar) {
        this.c = jVar;
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void l() {
        this.f5680d.d(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallOpened()", 1);
        int b = SessionDepthManager.getInstance().b(0);
        JSONObject D = IronSourceUtils.D(false);
        try {
            if (!TextUtils.isEmpty(this.f5685i)) {
                D.put("placement", this.f5685i);
            }
            D.put("sessionDepth", b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(305, D));
        SessionDepthManager.getInstance().d(0);
        com.ironsource.mediationsdk.n0.j jVar = this.c;
        if (jVar != null) {
            jVar.l();
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void m(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5680d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, "onGetOfferwallCreditsFailed(" + bVar + ")", 1);
        com.ironsource.mediationsdk.n0.j jVar = this.c;
        if (jVar != null) {
            jVar.m(bVar);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void n(boolean z) {
        q(z, null);
    }

    @Override // com.ironsource.mediationsdk.n0.j
    public void q(boolean z, com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5680d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, "onOfferwallAvailable(isAvailable: " + z + ")", 1);
        if (z) {
            this.f5682f.set(true);
            com.ironsource.mediationsdk.n0.j jVar = this.c;
            if (jVar != null) {
                jVar.n(true);
                return;
            }
            return;
        }
        c(bVar);
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void r(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c cVar = this.f5680d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        cVar.d(ironSourceTag, "onOfferwallShowFailed(" + bVar + ")", 1);
        com.ironsource.mediationsdk.n0.j jVar = this.c;
        if (jVar != null) {
            jVar.r(bVar);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void s() {
        this.f5680d.d(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallClosed()", 1);
        com.ironsource.mediationsdk.n0.j jVar = this.c;
        if (jVar != null) {
            jVar.s();
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public boolean u(int i2, int i3, boolean z) {
        this.f5680d.d(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallAdCredited()", 1);
        com.ironsource.mediationsdk.n0.j jVar = this.c;
        if (jVar != null) {
            return jVar.u(i2, i3, z);
        }
        return false;
    }
}
