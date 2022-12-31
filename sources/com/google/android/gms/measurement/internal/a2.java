package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class a2 extends b3 {
    private final Map<String, Long> b;
    private final Map<String, Integer> c;

    /* renamed from: d  reason: collision with root package name */
    private long f3747d;

    public a2(o4 o4Var) {
        super(o4Var);
        this.c = new ArrayMap();
        this.b = new ArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(a2 a2Var, String str, long j2) {
        a2Var.f();
        com.google.android.gms.common.internal.q.f(str);
        if (a2Var.c.isEmpty()) {
            a2Var.f3747d = j2;
        }
        Integer num = a2Var.c.get(str);
        if (num != null) {
            a2Var.c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (a2Var.c.size() >= 100) {
            a2Var.a.a().p().a("Too many ads visible");
        } else {
            a2Var.c.put(str, 1);
            a2Var.b.put(str, Long.valueOf(j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(a2 a2Var, String str, long j2) {
        a2Var.f();
        com.google.android.gms.common.internal.q.f(str);
        Integer num = a2Var.c.get(str);
        if (num == null) {
            a2Var.a.a().m().b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        y6 q = a2Var.a.O().q(false);
        int intValue = num.intValue() - 1;
        if (intValue != 0) {
            a2Var.c.put(str, Integer.valueOf(intValue));
            return;
        }
        a2Var.c.remove(str);
        Long l2 = a2Var.b.get(str);
        if (l2 == null) {
            a2Var.a.a().m().a("First ad unit exposure time was never set");
        } else {
            long longValue = l2.longValue();
            a2Var.b.remove(str);
            a2Var.n(str, j2 - longValue, q);
        }
        if (a2Var.c.isEmpty()) {
            long j3 = a2Var.f3747d;
            if (j3 == 0) {
                a2Var.a.a().m().a("First ad exposure time was never set");
                return;
            }
            a2Var.m(j2 - j3, q);
            a2Var.f3747d = 0L;
        }
    }

    @WorkerThread
    private final void m(long j2, y6 y6Var) {
        if (y6Var == null) {
            this.a.a().u().a("Not logging ad exposure. No active activity");
        } else if (j2 < 1000) {
            this.a.a().u().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j2);
            g7.v(y6Var, bundle, true);
            this.a.D().V("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void n(String str, long j2, y6 y6Var) {
        if (y6Var == null) {
            this.a.a().u().a("Not logging ad unit exposure. No active activity");
        } else if (j2 < 1000) {
            this.a.a().u().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j2);
            g7.v(y6Var, bundle, true);
            this.a.D().V("am", "_xu", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void o(long j2) {
        for (String str : this.b.keySet()) {
            this.b.put(str, Long.valueOf(j2));
        }
        if (this.b.isEmpty()) {
            return;
        }
        this.f3747d = j2;
    }

    public final void g(String str, long j2) {
        if (str != null && str.length() != 0) {
            this.a.c().p(new a(this, str, j2));
        } else {
            this.a.a().m().a("Ad unit id must be a non-empty string");
        }
    }

    public final void h(String str, long j2) {
        if (str != null && str.length() != 0) {
            this.a.c().p(new y(this, str, j2));
        } else {
            this.a.a().m().a("Ad unit id must be a non-empty string");
        }
    }

    @WorkerThread
    public final void i(long j2) {
        y6 q = this.a.O().q(false);
        for (String str : this.b.keySet()) {
            n(str, j2 - this.b.get(str).longValue(), q);
        }
        if (!this.b.isEmpty()) {
            m(j2 - this.f3747d, q);
        }
        o(j2);
    }
}
