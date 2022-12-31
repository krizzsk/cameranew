package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.b4  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1434b4 extends AbstractRunnableC0969Ki {
    public final /* synthetic */ C1431b1 A00;
    public final /* synthetic */ K3 A01;

    public C1434b4(C1431b1 c1431b1, K3 k3) {
        this.A00 = c1431b1;
        this.A01 = k3;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0969Ki
    public final void A01() {
        C5J c5j;
        C5J c5j2;
        c5j = this.A00.A00;
        if (c5j.A02() != null) {
            c5j2 = this.A00.A00;
            c5j2.A02().onAdError(LK.A00(this.A01));
        }
    }
}
