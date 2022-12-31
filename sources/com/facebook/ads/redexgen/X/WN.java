package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class WN implements CY {
    public final long A00;
    public final CX A01;

    public WN(long j2) {
        this(j2, 0L);
    }

    public WN(long j2, long j3) {
        this.A00 = j2;
        this.A01 = new CX(j3 == 0 ? CZ.A04 : new CZ(0L, j3));
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final long A6O() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final CX A7I(long j2) {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final boolean A8Y() {
        return false;
    }
}
