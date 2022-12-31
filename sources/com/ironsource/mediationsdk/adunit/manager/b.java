package com.ironsource.mediationsdk.adunit.manager;

import com.ironsource.mediationsdk.ISListenerWrapper;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdUnitListenerWrapper.java */
/* loaded from: classes2.dex */
public class b {
    private IronSource.AD_UNIT a;

    public b(IronSource.AD_UNIT ad_unit) {
        this.a = ad_unit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
            ISListenerWrapper.getInstance().d();
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
            ISListenerWrapper.getInstance().e();
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
            ISListenerWrapper.getInstance().f(bVar);
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
            ISListenerWrapper.getInstance().h();
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
            ISListenerWrapper.getInstance().g();
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
            ISListenerWrapper.getInstance().i(bVar);
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
            ISListenerWrapper.getInstance().j();
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + this.a);
    }
}
