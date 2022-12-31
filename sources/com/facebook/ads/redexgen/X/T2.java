package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class T2 implements O7 {
    public final /* synthetic */ C1185Sw A00;

    public T2(C1185Sw c1185Sw) {
        this.A00 = c1185Sw;
    }

    @Override // com.facebook.ads.redexgen.X.O7
    public final void A9l() {
        boolean A0Y;
        A0Y = this.A00.A0Y();
        if (A0Y) {
            this.A00.A0M();
            this.A00.A0V.setToolbarActionMessage("");
            this.A00.A0V.setToolbarActionMode(0);
        }
    }

    @Override // com.facebook.ads.redexgen.X.O7
    public final void ABA() {
        LS ls;
        this.A00.A0A = false;
        ls = this.A00.A0J;
        ls.A07();
    }

    @Override // com.facebook.ads.redexgen.X.O7
    public final void ABB() {
        LS ls;
        this.A00.A0A = true;
        ls = this.A00.A0J;
        ls.A06();
    }
}
