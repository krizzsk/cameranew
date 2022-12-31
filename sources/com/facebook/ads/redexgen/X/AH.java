package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class AH {
    public int A00;
    public int A01;
    public AT A02;
    public boolean A03;

    public AH() {
    }

    public /* synthetic */ AH(AE ae) {
        this();
    }

    public static /* synthetic */ int A00(AH ah) {
        return ah.A01;
    }

    public static /* synthetic */ int A01(AH ah) {
        return ah.A00;
    }

    public static /* synthetic */ boolean A02(AH ah) {
        return ah.A03;
    }

    public final void A03(int i2) {
        this.A01 += i2;
    }

    public final void A04(int i2) {
        if (this.A03 && this.A00 != 4) {
            I6.A03(i2 == 4);
            return;
        }
        this.A03 = true;
        this.A00 = i2;
    }

    public final void A05(AT at) {
        this.A02 = at;
        this.A01 = 0;
        this.A03 = false;
    }

    public final boolean A06(AT at) {
        return at != this.A02 || this.A01 > 0 || this.A03;
    }
}
