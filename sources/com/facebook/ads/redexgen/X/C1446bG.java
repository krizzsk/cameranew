package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdListener;
/* renamed from: com.facebook.ads.redexgen.X.bG  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1446bG extends AbstractRunnableC0969Ki {
    public final /* synthetic */ C1445bF A00;

    public C1446bG(C1445bF c1445bF) {
        this.A00 = c1445bF;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0969Ki
    public final void A01() {
        C05974x c05974x;
        C05974x c05974x2;
        C05974x c05974x3;
        c05974x = this.A00.A01;
        if (c05974x.A06() != null) {
            c05974x2 = this.A00.A01;
            AdListener A06 = c05974x2.A06();
            c05974x3 = this.A00.A01;
            A06.onLoggingImpression(c05974x3.A07());
        }
    }
}
