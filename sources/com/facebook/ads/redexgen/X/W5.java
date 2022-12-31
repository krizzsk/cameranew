package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class W5 implements InterfaceC0778Cs {
    public final int A00;
    public final int A01;
    public final IV A02;

    public W5(W6 w6) {
        this.A02 = w6.A00;
        this.A02.A0Y(12);
        this.A00 = this.A02.A0H();
        this.A01 = this.A02.A0H();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0778Cs
    public final int A7D() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0778Cs
    public final boolean A8M() {
        return this.A00 != 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0778Cs
    public final int ADJ() {
        int i2 = this.A00;
        return i2 == 0 ? this.A02.A0H() : i2;
    }
}
