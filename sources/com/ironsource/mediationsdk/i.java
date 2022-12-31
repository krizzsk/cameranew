package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: BaseProgManager.java */
/* loaded from: classes2.dex */
public abstract class i {
    private HashSet<com.ironsource.mediationsdk.l0.c> a;

    public i(HashSet<com.ironsource.mediationsdk.l0.c> hashSet) {
        this.a = new HashSet<>();
        this.a = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P() {
        return "fallback_" + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q(f fVar, String str) {
        if (fVar != null) {
            com.ironsource.mediationsdk.l0.b b = fVar.b(str);
            if (b != null) {
                Iterator<com.ironsource.mediationsdk.l0.c> it = this.a.iterator();
                while (it.hasNext()) {
                    com.ironsource.mediationsdk.l0.c next = it.next();
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info("onImpressionSuccess " + next.getClass().getSimpleName() + ": " + b);
                    next.a(b);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
    }
}
