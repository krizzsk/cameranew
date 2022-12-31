package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ug  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1221Ug implements HJ {
    public static byte[] A08;
    public static String[] A09 = {"4ve0RWyhYyl9xCQBcFEHHb6J5", "0", "sHlJnKRUCXWWG8DJxhYmJcdBG87KccAz", "Y1hOWn5yAZG8wtugOKE5SlkzB9Lmm", "ccLKzhNJONN8hN3GMkJFYY9R9j4tosDy", "kB2MLz2Qt2VhBov62BdjLbPbFvH", "HEcEuygojM8kHr", "TVH0enYaQUtbllarZb7wcHSuDyXsicXL"};
    public int A00;
    public int A01;
    public int A02;
    public HI[] A03;
    public final int A04;
    public final boolean A05;
    public final byte[] A06;
    public final HI[] A07;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 123);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-69, -81, -2, 23, 14, 33, 25, 14, 12, 29, 14, Draft_75.CR, -55, 10, 21, 21, 24, 12, 10, 29, 18, 24, 23, -29, -55};
    }

    static {
        A01();
    }

    public C1221Ug(boolean z, int i2) {
        this(z, i2, 0);
    }

    public C1221Ug(boolean z, int i2, int i3) {
        I6.A03(i2 > 0);
        I6.A03(i3 >= 0);
        this.A05 = z;
        this.A04 = i2;
        this.A01 = i3;
        this.A03 = new HI[i3 + 100];
        if (i3 > 0) {
            this.A06 = new byte[i3 * i2];
            for (int i4 = 0; i4 < i3; i4++) {
                this.A03[i4] = new HI(this.A06, i4 * i2);
            }
        } else {
            this.A06 = null;
        }
        this.A07 = new HI[1];
    }

    public final synchronized int A02() {
        int i2;
        i2 = this.A00 * this.A04;
        String[] strArr = A09;
        if (strArr[3].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[0] = "5S97W7P0mYMCYwMDzMcet6TY3";
        strArr2[1] = "7";
        return i2;
    }

    public final synchronized void A03() {
        if (this.A05) {
            A04(0);
        }
    }

    public final synchronized void A04(int i2) {
        boolean z = i2 < this.A02;
        this.A02 = i2;
        if (z) {
            AF2();
        }
    }

    @Override // com.facebook.ads.redexgen.X.HJ
    public final synchronized HI A3K() {
        HI hi;
        this.A00++;
        if (this.A01 > 0) {
            HI[] hiArr = this.A03;
            int i2 = this.A01 - 1;
            this.A01 = i2;
            hi = hiArr[i2];
            this.A03[this.A01] = null;
        } else {
            hi = new HI(new byte[this.A04], 0);
        }
        return hi;
    }

    @Override // com.facebook.ads.redexgen.X.HJ
    public final int A6k() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.HJ
    public final synchronized void ADT(HI hi) {
        this.A07[0] = hi;
        ADU(this.A07);
        String[] strArr = A09;
        if (strArr[0].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        A09[2] = "vTQnHDwqIVvtvGKS6QPwZVkZoK1Lgm5f";
    }

    @Override // com.facebook.ads.redexgen.X.HJ
    public final synchronized void ADU(HI[] hiArr) {
        if (this.A01 + hiArr.length >= this.A03.length) {
            this.A03 = (HI[]) Arrays.copyOf(this.A03, Math.max(this.A03.length * 2, this.A01 + hiArr.length));
        }
        for (HI hi : hiArr) {
            if (hi.A01 != this.A06 && hi.A01.length != this.A04) {
                throw new IllegalArgumentException(A00(2, 23, 46) + System.identityHashCode(hi.A01) + A00(0, 2, 20) + System.identityHashCode(this.A06) + A00(0, 2, 20) + hi.A01.length + A00(0, 2, 20) + this.A04);
            }
            HI[] hiArr2 = this.A03;
            int i2 = this.A01;
            this.A01 = i2 + 1;
            hiArr2[i2] = hi;
        }
        this.A00 -= hiArr.length;
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.X.HJ
    public final synchronized void AF2() {
        int lowIndex = Math.max(0, C0923Il.A04(this.A02, this.A04) - this.A00);
        if (lowIndex >= this.A01) {
            return;
        }
        if (this.A06 != null) {
            int i2 = 0;
            int i3 = this.A01 - 1;
            while (i2 <= i3) {
                HI hi = this.A03[i2];
                if (hi.A01 == this.A06) {
                    i2++;
                } else {
                    HI hi2 = this.A03[i3];
                    if (hi2.A01 != this.A06) {
                        i3--;
                    } else {
                        int highIndex = i2 + 1;
                        this.A03[i2] = hi2;
                        this.A03[i3] = hi;
                        i3--;
                        i2 = highIndex;
                    }
                }
            }
            lowIndex = Math.max(lowIndex, i2);
            if (lowIndex >= this.A01) {
                return;
            }
        }
        Arrays.fill(this.A03, lowIndex, this.A01, (Object) null);
        this.A01 = lowIndex;
    }
}
