package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class W4 implements InterfaceC0778Cs {
    public int A00;
    public int A01;
    public final int A02;
    public final int A03;
    public final IV A04;

    public W4(W6 w6) {
        this.A04 = w6.A00;
        this.A04.A0Y(12);
        this.A02 = this.A04.A0H() & 255;
        this.A03 = this.A04.A0H();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0778Cs
    public final int A7D() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0778Cs
    public final boolean A8M() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0778Cs
    public final int ADJ() {
        int i2 = this.A02;
        if (i2 == 8) {
            return this.A04.A0E();
        }
        if (i2 == 16) {
            return this.A04.A0I();
        }
        int i3 = this.A01;
        this.A01 = i3 + 1;
        if (i3 % 2 == 0) {
            this.A00 = this.A04.A0E();
            return (this.A00 & 240) >> 4;
        }
        return this.A00 & 15;
    }
}
