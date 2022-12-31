package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class AQ {
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final FL A04;
    public final boolean A05;
    public final boolean A06;

    public AQ(FL fl, long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this.A04 = fl;
        this.A03 = j2;
        this.A02 = j3;
        this.A00 = j4;
        this.A01 = j5;
        this.A06 = z;
        this.A05 = z2;
    }

    public final AQ A00(int i2) {
        return new AQ(this.A04.A00(i2), this.A03, this.A02, this.A00, this.A01, this.A06, this.A05);
    }

    public final AQ A01(long j2) {
        return new AQ(this.A04, j2, this.A02, this.A00, this.A01, this.A06, this.A05);
    }
}
