package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class TM implements InterfaceC0997Ln {
    public int A00;
    public final InterfaceC0997Ln A01;

    public TM(InterfaceC0997Ln interfaceC0997Ln, int i2) {
        this.A01 = interfaceC0997Ln;
        this.A00 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0997Ln
    public final void AD2(String str) {
        if (this.A00 > 0) {
            this.A01.AD2(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0997Ln
    public final void flush() {
        this.A01.flush();
    }
}
