package com.ironsource.mediationsdk.events;

import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
/* loaded from: classes2.dex */
public class InterstitialEventsManager extends b {
    private static InterstitialEventsManager D;
    private String C;

    private InterstitialEventsManager() {
        this.u = "ironbeast";
        this.t = 2;
        this.v = "IS";
        this.C = "";
    }

    public static synchronized InterstitialEventsManager getInstance() {
        InterstitialEventsManager interstitialEventsManager;
        synchronized (InterstitialEventsManager.class) {
            if (D == null) {
                InterstitialEventsManager interstitialEventsManager2 = new InterstitialEventsManager();
                D = interstitialEventsManager2;
                interstitialEventsManager2.I();
            }
            interstitialEventsManager = D;
        }
        return interstitialEventsManager;
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected String D(int i2) {
        return this.C;
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected int F(d.e.b.b bVar) {
        return SessionDepthManager.getInstance().b(bVar.d() >= 3000 && bVar.d() < 4000 ? 3 : 2);
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected void H() {
        this.w.add(Integer.valueOf((int) AdError.INTERNAL_ERROR_CODE));
        this.w.add(Integer.valueOf((int) AdError.CACHE_ERROR_CODE));
        this.w.add(Integer.valueOf((int) AdError.INTERNAL_ERROR_2003));
        this.w.add(Integer.valueOf((int) AdError.INTERNAL_ERROR_2004));
        this.w.add(2200);
        this.w.add(2213);
        this.w.add(2211);
        this.w.add(2212);
        this.w.add(Integer.valueOf((int) AdError.MEDIATION_ERROR_CODE));
        this.w.add(3111);
        this.w.add(3011);
        this.w.add(3201);
        this.w.add(3116);
        this.w.add(3002);
        this.w.add(3012);
        this.w.add(3005);
        this.w.add(3300);
        this.w.add(3015);
        this.w.add(3301);
        this.w.add(3007);
        this.w.add(3017);
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected boolean M(d.e.b.b bVar) {
        int d2 = bVar.d();
        return d2 == 2204 || d2 == 2004 || d2 == 2005 || d2 == 2301 || d2 == 2300 || d2 == 3005 || d2 == 3015;
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected void V(d.e.b.b bVar) {
        this.C = bVar.c().optString("placement");
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected boolean n0(d.e.b.b bVar) {
        return false;
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected boolean o0(d.e.b.b bVar) {
        return false;
    }
}
