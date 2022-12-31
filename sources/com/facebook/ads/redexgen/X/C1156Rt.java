package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Rt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1156Rt implements InterfaceC1054Nt {
    public final /* synthetic */ C06838p A00;

    public C1156Rt(C06838p c06838p) {
        this.A00 = c06838p;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1054Nt
    public final void AAi(boolean z) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.A00.A04;
        atomicBoolean.set(z);
        this.A00.A05();
    }
}
