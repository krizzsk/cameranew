package com.tapjoy.internal;

import com.tapjoy.internal.ew;
import java.util.Map;
/* loaded from: classes3.dex */
public final class ik extends ii {
    private final ew.a c = new ew.a();

    /* renamed from: d  reason: collision with root package name */
    private ey f7709d = null;

    public final boolean a(ev evVar) {
        ey eyVar = this.f7709d;
        if (eyVar == null) {
            this.f7709d = evVar.n;
        } else if (evVar.n != eyVar) {
            return false;
        }
        this.c.c.add(evVar);
        return true;
    }

    @Override // com.tapjoy.internal.ca
    public final String c() {
        return this.f7709d == ey.USAGES ? "api/v1/usages" : "api/v1/cevs";
    }

    @Override // com.tapjoy.internal.ii, com.tapjoy.internal.ca
    public final Map e() {
        Map e2 = super.e();
        e2.put("events", new bm(hp.a(this.c.b())));
        return e2;
    }

    public final int g() {
        return this.c.c.size();
    }
}
