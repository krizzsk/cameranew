package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
/* renamed from: com.facebook.ads.redexgen.X.Ff  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0841Ff {
    public static String[] A0I = {"CqT0KuE1AFfImBFy4ik", "hGcHjrCi226kocD9vKzS9HyQAF0ZqssA", "ZD81yrpYsqeXe4L", "XJx", "nsm5GlP1XQIMmswL2BtDEyl4JYnPccJt", "OHNFP06lkToQsW2YsoX4lx0", "UGSwurzNNOniPMx0TIQOqAAX3osRvTJh", "YaODE33QO8vEeLZGxHQ5TNBfWhqIAS5S"};
    public int A00;
    public int A01 = 1000;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public long A06;
    public long A07;
    public Format A08;
    public boolean A09;
    public boolean A0A;
    public int[] A0B;
    public int[] A0C;
    public int[] A0D;
    public long[] A0E;
    public long[] A0F;
    public Format[] A0G;
    public C0770Ca[] A0H;

    public C0841Ff() {
        int i2 = this.A01;
        this.A0D = new int[i2];
        this.A0E = new long[i2];
        this.A0F = new long[i2];
        this.A0B = new int[i2];
        this.A0C = new int[i2];
        this.A0H = new C0770Ca[i2];
        this.A0G = new Format[i2];
        this.A06 = Long.MIN_VALUE;
        this.A07 = Long.MIN_VALUE;
        this.A09 = true;
        this.A0A = true;
    }

    private int A00(int i2) {
        int i3 = this.A04 + i2;
        int i4 = this.A01;
        return i3 < i4 ? i3 : i3 - i4;
    }

    private int A01(int searchIndex, int i2, long j2, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j3 = this.A0F[searchIndex];
            String[] strArr = A0I;
            if (strArr[3].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[3] = "JFV";
            strArr2[5] = "8A9T2ZHBGF6P3L1HGcqfomX";
            if (j3 > j2) {
                break;
            }
            if (!z || (this.A0B[searchIndex] & 1) != 0) {
                i3 = i4;
            }
            searchIndex++;
            if (searchIndex == this.A01) {
                searchIndex = 0;
            }
        }
        return i3;
    }

    private long A02(int i2) {
        int i3;
        this.A06 = Math.max(this.A06, A03(i2));
        this.A02 -= i2;
        this.A00 += i2;
        this.A04 += i2;
        int i4 = this.A04;
        int i5 = this.A01;
        if (i4 >= i5) {
            int i6 = i4 - i5;
            String[] strArr = A0I;
            if (strArr[7].charAt(18) != strArr[6].charAt(18)) {
                throw new RuntimeException();
            }
            A0I[2] = "rmPQqkiHfMf";
            this.A04 = i6;
        }
        this.A03 -= i2;
        if (this.A03 < 0) {
            if (A0I[2].length() == 8) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[4] = "rGNm6jdFTVK86xam60qdwwsNjuy3SfLS";
            strArr2[1] = "zCUBtEUnOSv2Jph2uhLKbu226T4aXBY5";
            this.A03 = 0;
        }
        if (this.A02 == 0) {
            int i7 = this.A04;
            if (i7 == 0) {
                i7 = this.A01;
            }
            return this.A0E[i7 - 1] + this.A0C[i3];
        }
        return this.A0E[this.A04];
    }

    private long A03(int i2) {
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        long j2 = Long.MIN_VALUE;
        int relativeSampleIndex = A00(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.A0F[relativeSampleIndex]);
            int i4 = this.A0B[relativeSampleIndex];
            if ((i4 & 1) != 0) {
                break;
            }
            relativeSampleIndex--;
            if (relativeSampleIndex == -1) {
                int i5 = this.A01;
                String[] strArr = A0I;
                String str = strArr[4];
                String str2 = strArr[1];
                int charAt = str.charAt(25);
                int relativeSampleIndex2 = str2.charAt(25);
                if (charAt == relativeSampleIndex2) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0I;
                strArr2[3] = "3tp";
                strArr2[5] = "Z0W9OfGRhIfCW820bOQ6uFB";
                relativeSampleIndex = i5 - 1;
            }
        }
        return j2;
    }

    private final synchronized void A04(long j2) {
        this.A07 = Math.max(this.A07, j2);
    }

    public final int A05() {
        return this.A00 + this.A03;
    }

    public final int A06() {
        return this.A00 + this.A02;
    }

    public final synchronized int A07() {
        int i2;
        i2 = this.A02 - this.A03;
        this.A03 = this.A02;
        if (A0I[2].length() != 8) {
            A0I[2] = "bxSWiBZCbHOohSqaWh";
            return i2;
        }
        throw new RuntimeException();
    }

    public final synchronized int A08(long j2, boolean z, boolean z2) {
        int A00 = A00(this.A03);
        if (!A0I() || j2 < this.A0F[A00] || (j2 > this.A07 && !z2)) {
            return -1;
        }
        int A01 = A01(A00, this.A02 - this.A03, j2, z);
        if (A01 == -1) {
            return -1;
        }
        this.A03 += A01;
        return A01;
    }

    public final synchronized int A09(AM am, WZ wz, boolean z, boolean z2, Format format, C0840Fe c0840Fe) {
        if (!A0I()) {
            if (z2) {
                wz.A02(4);
                return -4;
            } else if (this.A08 == null || (!z && this.A08 == format)) {
                return -3;
            } else {
                am.A00 = this.A08;
                return -5;
            }
        }
        int A00 = A00(this.A03);
        if (z || this.A0G[A00] != format) {
            am.A00 = this.A0G[A00];
            return -5;
        } else if (wz.A0B()) {
            return -3;
        } else {
            wz.A00 = this.A0F[A00];
            wz.A02(this.A0B[A00]);
            c0840Fe.A00 = this.A0C[A00];
            c0840Fe.A01 = this.A0E[A00];
            c0840Fe.A02 = this.A0H[A00];
            this.A03++;
            return -4;
        }
    }

    public final synchronized long A0A() {
        if (this.A02 == 0) {
            return -1L;
        }
        return A02(this.A02);
    }

    public final synchronized long A0B() {
        return this.A07;
    }

    public final long A0C(int i2) {
        int A00;
        int A06 = A06() - i2;
        I6.A03(A06 >= 0 && A06 <= this.A02 - this.A03);
        this.A02 -= A06;
        this.A07 = Math.max(this.A06, A03(this.A02));
        int i3 = this.A02;
        if (i3 == 0) {
            return 0L;
        }
        return this.A0E[A00(i3 - 1)] + this.A0C[A00];
    }

    public final synchronized long A0D(long j2, boolean z, boolean z2) {
        if (this.A02 != 0 && j2 >= this.A0F[this.A04]) {
            int A01 = A01(this.A04, (!z2 || this.A03 == this.A02) ? this.A02 : this.A03 + 1, j2, z);
            if (A01 == -1) {
                return -1L;
            }
            return A02(A01);
        }
        return -1L;
    }

    public final synchronized Format A0E() {
        return this.A09 ? null : this.A08;
    }

    public final synchronized void A0F() {
        this.A03 = 0;
    }

    public final synchronized void A0G(long j2, int i2, long j3, int i3, C0770Ca c0770Ca) {
        if (this.A0A) {
            if ((i2 & 1) == 0) {
                return;
            }
            this.A0A = false;
        }
        I6.A04(!this.A09);
        A04(j2);
        int A00 = A00(this.A02);
        this.A0F[A00] = j2;
        this.A0E[A00] = j3;
        this.A0C[A00] = i3;
        this.A0B[A00] = i2;
        this.A0H[A00] = c0770Ca;
        this.A0G[A00] = this.A08;
        this.A0D[A00] = this.A05;
        this.A02++;
        if (this.A02 == this.A01) {
            int i4 = this.A01 + 1000;
            int[] iArr = new int[i4];
            long[] jArr = new long[i4];
            long[] jArr2 = new long[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            C0770Ca[] c0770CaArr = new C0770Ca[i4];
            Format[] formatArr = new Format[i4];
            int i5 = this.A01 - this.A04;
            long[] jArr3 = this.A0E;
            int beforeWrap = this.A04;
            System.arraycopy(jArr3, beforeWrap, jArr, 0, i5);
            long[] jArr4 = this.A0F;
            int beforeWrap2 = this.A04;
            System.arraycopy(jArr4, beforeWrap2, jArr2, 0, i5);
            int[] iArr4 = this.A0B;
            int beforeWrap3 = this.A04;
            System.arraycopy(iArr4, beforeWrap3, iArr2, 0, i5);
            int[] iArr5 = this.A0C;
            int beforeWrap4 = this.A04;
            System.arraycopy(iArr5, beforeWrap4, iArr3, 0, i5);
            C0770Ca[] c0770CaArr2 = this.A0H;
            int beforeWrap5 = this.A04;
            System.arraycopy(c0770CaArr2, beforeWrap5, c0770CaArr, 0, i5);
            Format[] formatArr2 = this.A0G;
            int beforeWrap6 = this.A04;
            System.arraycopy(formatArr2, beforeWrap6, formatArr, 0, i5);
            int[] iArr6 = this.A0D;
            int beforeWrap7 = this.A04;
            System.arraycopy(iArr6, beforeWrap7, iArr, 0, i5);
            int i6 = this.A04;
            System.arraycopy(this.A0E, 0, jArr, i5, i6);
            System.arraycopy(this.A0F, 0, jArr2, i5, i6);
            System.arraycopy(this.A0B, 0, iArr2, i5, i6);
            System.arraycopy(this.A0C, 0, iArr3, i5, i6);
            System.arraycopy(this.A0H, 0, c0770CaArr, i5, i6);
            System.arraycopy(this.A0G, 0, formatArr, i5, i6);
            System.arraycopy(this.A0D, 0, iArr, i5, i6);
            this.A0E = jArr;
            this.A0F = jArr2;
            this.A0B = iArr2;
            this.A0C = iArr3;
            this.A0H = c0770CaArr;
            this.A0G = formatArr;
            this.A0D = iArr;
            this.A04 = 0;
            int afterWrap = this.A01;
            this.A02 = afterWrap;
            this.A01 = i4;
        }
    }

    public final void A0H(boolean z) {
        this.A02 = 0;
        this.A00 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A0A = true;
        this.A06 = Long.MIN_VALUE;
        this.A07 = Long.MIN_VALUE;
        if (z) {
            this.A08 = null;
            this.A09 = true;
        }
    }

    public final synchronized boolean A0I() {
        return this.A03 != this.A02;
    }

    public final synchronized boolean A0J(long j2) {
        if (this.A02 == 0) {
            return j2 > this.A06;
        } else if (Math.max(this.A06, A03(this.A03)) >= j2) {
            return false;
        } else {
            int i2 = this.A02;
            int A00 = A00(this.A02 - 1);
            while (i2 > this.A03 && this.A0F[A00] >= j2) {
                i2--;
                A00--;
                if (A00 == -1) {
                    A00 = this.A01 - 1;
                }
            }
            A0C(this.A00 + i2);
            if (A0I[0].length() != 29) {
                String[] strArr = A0I;
                strArr[3] = "Ebt";
                strArr[5] = "bsxl34mHntOvTAOjuXwEPt2";
                return true;
            }
            throw new RuntimeException();
        }
    }

    public final synchronized boolean A0K(Format format) {
        if (format == null) {
            this.A09 = true;
            return false;
        }
        this.A09 = false;
        if (C0923Il.A0g(format, this.A08)) {
            return false;
        }
        this.A08 = format;
        return true;
    }
}
