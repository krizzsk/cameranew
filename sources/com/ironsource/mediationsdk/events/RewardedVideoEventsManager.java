package com.ironsource.mediationsdk.events;

import com.ironsource.mediationsdk.utils.SessionDepthManager;
/* loaded from: classes2.dex */
public class RewardedVideoEventsManager extends b {
    private static RewardedVideoEventsManager D;
    private String C;

    private RewardedVideoEventsManager() {
        this.u = "outcome";
        this.t = 3;
        this.v = "RV";
        this.C = "";
    }

    public static synchronized RewardedVideoEventsManager getInstance() {
        RewardedVideoEventsManager rewardedVideoEventsManager;
        synchronized (RewardedVideoEventsManager.class) {
            if (D == null) {
                RewardedVideoEventsManager rewardedVideoEventsManager2 = new RewardedVideoEventsManager();
                D = rewardedVideoEventsManager2;
                rewardedVideoEventsManager2.I();
            }
            rewardedVideoEventsManager = D;
        }
        return rewardedVideoEventsManager;
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected String D(int i2) {
        return (i2 == 15 || (i2 >= 300 && i2 < 400)) ? this.C : "";
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected int F(d.e.b.b bVar) {
        if (bVar.d() != 15 && (bVar.d() < 300 || bVar.d() >= 400)) {
            return SessionDepthManager.getInstance().b(1);
        }
        return SessionDepthManager.getInstance().b(0);
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected void H() {
        this.w.add(1000);
        this.w.add(1001);
        this.w.add(1002);
        this.w.add(1003);
        this.w.add(1200);
        this.w.add(1209);
        this.w.add(1210);
        this.w.add(1211);
        this.w.add(1212);
        this.w.add(1213);
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected boolean M(d.e.b.b bVar) {
        int d2 = bVar.d();
        return d2 == 14 || d2 == 514 || d2 == 305 || d2 == 1003 || d2 == 1005 || d2 == 1203 || d2 == 1010 || d2 == 1301 || d2 == 1302;
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected void V(d.e.b.b bVar) {
        if (bVar.d() == 15 || (bVar.d() >= 300 && bVar.d() < 400)) {
            this.C = bVar.c().optString("placement");
        }
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected boolean n0(d.e.b.b bVar) {
        return false;
    }

    @Override // com.ironsource.mediationsdk.events.b
    protected boolean o0(d.e.b.b bVar) {
        return bVar.d() == 305;
    }
}
