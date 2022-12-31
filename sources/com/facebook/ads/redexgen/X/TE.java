package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class TE implements AnonymousClass50 {
    public final /* synthetic */ TB A00;

    public TE(TB tb) {
        this.A00 = tb;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final boolean A8E() {
        C1175Sm c1175Sm;
        C1175Sm c1175Sm2;
        c1175Sm = this.A00.A0B;
        if (c1175Sm.canGoBack()) {
            c1175Sm2 = this.A00.A0B;
            c1175Sm2.goBack();
            return true;
        }
        return false;
    }
}
