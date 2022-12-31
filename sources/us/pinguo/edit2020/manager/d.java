package us.pinguo.edit2020.manager;

import us.pinguo.performance.manager.PerformanceLevelManager;
/* compiled from: EditPerformanceManager.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public final boolean a() {
        Integer g2 = PerformanceLevelManager.a.g();
        return (g2 == null ? 0 : g2.intValue()) >= 110;
    }
}
