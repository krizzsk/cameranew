package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class SL extends AbstractRunnableC0981Kv {
    public final /* synthetic */ SK A00;
    public final /* synthetic */ boolean A01;

    public SL(SK sk, boolean z) {
        this.A00 = sk;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        ON on;
        on = this.A00.A0E;
        MT A08 = on.A08();
        if (A08 == null) {
            return;
        }
        A08.setPageDetailsVisible((this.A01 || A08.A05()) ? false : true);
        A08.setToolbarActionMode(this.A00.getCloseButtonStyle());
    }
}
