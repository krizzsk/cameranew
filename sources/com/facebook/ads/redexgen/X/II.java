package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class II {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final long A07;

    public II(byte[] bArr, int i2) {
        IU iu = new IU(bArr);
        iu.A07(i2 * 8);
        this.A04 = iu.A04(16);
        this.A02 = iu.A04(16);
        this.A05 = iu.A04(24);
        this.A03 = iu.A04(24);
        this.A06 = iu.A04(20);
        this.A01 = iu.A04(3) + 1;
        this.A00 = iu.A04(5) + 1;
        this.A07 = ((iu.A04(4) & 15) << 32) | (iu.A04(32) & 4294967295L);
    }

    public final int A00() {
        return this.A00 * this.A06;
    }

    public final long A01() {
        return (this.A07 * 1000000) / this.A06;
    }
}
