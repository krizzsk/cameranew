package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class T1 implements P4 {
    public final /* synthetic */ C1185Sw A00;

    public T1(C1185Sw c1185Sw) {
        this.A00 = c1185Sw;
    }

    @Override // com.facebook.ads.redexgen.X.P4
    public final void AAv() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.A00.A0R;
        atomicBoolean.set(true);
        this.A00.A0N();
    }
}
