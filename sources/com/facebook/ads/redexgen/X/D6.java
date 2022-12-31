package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class D6 implements W9 {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final long A04;

    public D6(long j2, long j3, CV cv) {
        this.A04 = j3;
        this.A01 = cv.A02;
        this.A00 = cv.A00;
        if (j2 == -1) {
            this.A02 = -1L;
            this.A03 = -9223372036854775807L;
            return;
        }
        this.A02 = j2 - j3;
        this.A03 = A7X(j2);
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final long A6O() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final CX A7I(long positionOffset) {
        long j2 = this.A02;
        if (j2 == -1) {
            return new CX(new CZ(0L, this.A04));
        }
        int i2 = this.A01;
        long A0E = C0923Il.A0E((((this.A00 * positionOffset) / 8000000) / i2) * i2, 0L, j2 - i2);
        long j3 = this.A04 + A0E;
        long A7X = A7X(j3);
        CZ seekPoint = new CZ(A7X, j3);
        if (A7X < positionOffset) {
            long j4 = this.A02;
            int i3 = this.A01;
            if (A0E != j4 - i3) {
                long j5 = i3 + j3;
                return new CX(seekPoint, new CZ(A7X(j5), j5));
            }
        }
        return new CX(seekPoint);
    }

    @Override // com.facebook.ads.redexgen.X.W9
    public final long A7X(long j2) {
        return ((Math.max(0L, j2 - this.A04) * 1000000) * 8) / this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final boolean A8Y() {
        return this.A02 != -1;
    }
}
