package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class XM extends AbstractRunnableC0981Kv {
    public final /* synthetic */ XS A00;

    public XM(XS xs) {
        this.A00 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        for (C06758h event : C8g.A02()) {
            C8g.A0A(this.A00, event.A02(), event.A00(), event.A01(), false);
        }
        C8g.A02().clear();
    }
}
