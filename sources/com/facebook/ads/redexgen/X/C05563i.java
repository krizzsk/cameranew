package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.3i  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C05563i {
    public static byte[] A02;
    public static String[] A03 = {"bULQ32o9JJN83aCucFVWf9xMaMFfdsau", "BEVDZxUetTHXZyMQk8onv0fPj1ZBZ1Qa", "0vYpub5LBkfCpAgXclsnPo1", "vVWBcEJQjEsfNalmzVe1r7miASaPIW1B", "LFkzDQh", "g5RhG8eWHWtWI7ENz9qYtKd", "50dEOoYhOQRa91fvkd77j3svvS12NHRj", "eQbNRdF"};
    public long A00 = 0;
    public C05563i A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 5);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-34, -34};
    }

    static {
        A02();
    }

    private void A01() {
        if (this.A01 == null) {
            this.A01 = new C05563i();
        }
    }

    public final int A03(int i2) {
        C05563i c05563i = this.A01;
        if (c05563i == null) {
            if (i2 >= 64) {
                return Long.bitCount(this.A00);
            }
            return Long.bitCount(this.A00 & ((1 << i2) - 1));
        } else if (i2 < 64) {
            return Long.bitCount(this.A00 & ((1 << i2) - 1));
        } else {
            return c05563i.A03(i2 - 64) + Long.bitCount(this.A00);
        }
    }

    public final void A04() {
        this.A00 = 0L;
        C05563i c05563i = this.A01;
        if (c05563i != null) {
            c05563i.A04();
        }
    }

    public final void A05(int i2) {
        if (i2 >= 64) {
            C05563i c05563i = this.A01;
            if (c05563i != null) {
                c05563i.A05(i2 - 64);
                return;
            }
            return;
        }
        long j2 = this.A00 & ((1 << i2) ^ (-1));
        if (A03[1].charAt(31) != 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[6] = "FQtQPqX5zshXn4VmNwTVsnzPJS3Krcw4";
        strArr[3] = "mEVd87EgPvtBoIzzDeJnjIPIOSUL2jIs";
        this.A00 = j2;
    }

    public final void A06(int i2) {
        if (i2 >= 64) {
            A01();
            this.A01.A06(i2 - 64);
            return;
        }
        this.A00 |= 1 << i2;
    }

    public final void A07(int i2, boolean z) {
        if (i2 >= 64) {
            A01();
            this.A01.A07(i2 - 64, z);
            return;
        }
        boolean z2 = (this.A00 & Long.MIN_VALUE) != 0;
        long j2 = (1 << i2) - 1;
        long j3 = this.A00;
        this.A00 = (j3 & j2) | ((j3 & ((-1) ^ j2)) << 1);
        if (z) {
            A06(i2);
        } else {
            A05(i2);
        }
        if (!z2 && this.A01 == null) {
            return;
        }
        A01();
        this.A01.A07(0, z2);
    }

    public final boolean A08(int i2) {
        if (i2 < 64) {
            return (this.A00 & (1 << i2)) != 0;
        }
        A01();
        return this.A01.A08(i2 - 64);
    }

    public final boolean A09(int i2) {
        if (i2 >= 64) {
            A01();
            return this.A01.A09(i2 - 64);
        }
        long j2 = 1 << i2;
        boolean z = (this.A00 & j2) != 0;
        this.A00 &= j2 ^ (-1);
        long j3 = j2 - 1;
        long before = this.A00;
        this.A00 = (before & j3) | Long.rotateRight(before & ((-1) ^ j3), 1);
        C05563i c05563i = this.A01;
        if (c05563i != null) {
            if (c05563i.A08(0)) {
                A06(63);
            }
            this.A01.A09(0);
        }
        return z;
    }

    public final String toString() {
        if (this.A01 != null) {
            return this.A01.toString() + A00(0, 2, 97) + Long.toBinaryString(this.A00);
        }
        long j2 = this.A00;
        if (A03[1].charAt(31) != 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[2] = "hJ9KUEYMHtIt6rT1Ez0KfdL";
        strArr[5] = "B6CHA8tZa8vt0H5l4hWvu9Y";
        return Long.toBinaryString(j2);
    }
}
