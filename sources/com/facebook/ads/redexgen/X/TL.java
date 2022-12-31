package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class TL implements InterfaceC0997Ln {
    public final C0996Lm A00;
    public final InterfaceC0997Ln A01;

    public TL(InterfaceC0997Ln interfaceC0997Ln, int i2, int i3) {
        this.A01 = interfaceC0997Ln;
        this.A00 = new C0996Lm(i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0997Ln
    public final void AD2(String str) {
        boolean A08;
        this.A00.A04(str);
        if (this.A00.A02() != null) {
            A08 = C0999Lp.A08(this.A00);
            if (A08) {
                this.A01.AD2(this.A00.A02());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0997Ln
    public final void flush() {
        boolean A08;
        this.A00.A03();
        while (this.A00.A02() != null) {
            A08 = C0999Lp.A08(this.A00);
            if (A08) {
                this.A01.AD2(this.A00.A02());
            }
            this.A00.A03();
        }
    }
}
