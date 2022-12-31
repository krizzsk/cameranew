package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class IL {
    public static byte[] A02;
    public int A00;
    public long[] A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 45);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{61, 49, 98, 120, 107, 116, 49, 120, 98, 49, 89, 126, 102, 113, 124, 121, 116, 48, 121, 126, 116, 117, 104, 48};
    }

    public IL() {
        this(32);
    }

    public IL(int i2) {
        this.A01 = new long[i2];
    }

    public final int A02() {
        return this.A00;
    }

    public final long A03(int i2) {
        if (i2 >= 0 && i2 < this.A00) {
            return this.A01[i2];
        }
        throw new IndexOutOfBoundsException(A00(10, 14, 61) + i2 + A00(0, 10, 60) + this.A00);
    }

    public final void A04(long j2) {
        int i2 = this.A00;
        long[] jArr = this.A01;
        if (i2 == jArr.length) {
            this.A01 = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.A01;
        int i3 = this.A00;
        this.A00 = i3 + 1;
        jArr2[i3] = j2;
    }

    public final long[] A05() {
        return Arrays.copyOf(this.A01, this.A00);
    }
}
