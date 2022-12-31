package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public class S5 implements P1 {
    public final /* synthetic */ C1072On A00;

    public S5(C1072On c1072On) {
        this.A00 = c1072On;
    }

    @Override // com.facebook.ads.redexgen.X.P1
    public final void AAg(String str) {
        AtomicReference atomicReference;
        atomicReference = this.A00.A0J;
        atomicReference.set(str);
    }
}
