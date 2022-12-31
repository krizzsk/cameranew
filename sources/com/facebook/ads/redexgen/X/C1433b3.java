package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.b3  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1433b3 extends AbstractRunnableC0969Ki {
    public final /* synthetic */ C1432b2 A00;

    public C1433b3(C1432b2 c1432b2) {
        this.A00 = c1432b2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0969Ki
    public final void A01() {
        C5J c5j;
        C5J c5j2;
        c5j = this.A00.A01.A00;
        if (c5j.A02() != null) {
            c5j2 = this.A00.A01.A00;
            c5j2.A02().onAdsLoaded();
        }
    }
}
