package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class DE {
    public final int A00;
    public final int A01;
    public final long A02;
    public final DB A03;
    public final int[] A04;
    public final int[] A05;
    public final long[] A06;
    public final long[] A07;

    public DE(DB db, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        I6.A03(iArr.length == jArr2.length);
        I6.A03(jArr.length == jArr2.length);
        I6.A03(iArr2.length == jArr2.length);
        this.A03 = db;
        this.A06 = jArr;
        this.A05 = iArr;
        this.A00 = i2;
        this.A07 = jArr2;
        this.A04 = iArr2;
        this.A02 = j2;
        this.A01 = jArr.length;
    }

    public final int A00(long j2) {
        for (int A0B = C0923Il.A0B(this.A07, j2, true, false); A0B >= 0; A0B--) {
            if ((this.A04[A0B] & 1) != 0) {
                return A0B;
            }
        }
        return -1;
    }

    public final int A01(long j2) {
        for (int A0A = C0923Il.A0A(this.A07, j2, true, false); A0A < this.A07.length; A0A++) {
            if ((this.A04[A0A] & 1) != 0) {
                return A0A;
            }
        }
        return -1;
    }
}
