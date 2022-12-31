package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Cr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0777Cr {
    public static byte[] A09;
    public static String[] A0A = {"fT4", "9XJ", "BdT8ugCih1Mpz00LrHVoF8KqNvgOr8AQ", "ItU4Mc5lT2NsoQYD", "XQJ1SNvFfokPp3KD", "IGCc23FH28N7ANBVj9k1dGnz4ha0U", "1lzK38hIt0", "A8GyDlY1o0KAgmQELzlat0ZxMGcgz"};
    public int A00;
    public int A01;
    public long A02;
    public int A03;
    public int A04;
    public final int A05;
    public final IV A06;
    public final IV A07;
    public final boolean A08;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 81);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{27, 20, 15, 14, 9, 34, 30, 21, 8, 19, 22, 93, 16, 8, 14, 9, 93, 31, 24, 93, 76};
    }

    static {
        A01();
    }

    public C0777Cr(IV iv, IV iv2, boolean z) {
        this.A07 = iv;
        this.A06 = iv2;
        this.A08 = z;
        iv2.A0Y(12);
        this.A05 = iv2.A0H();
        iv.A0Y(12);
        this.A04 = iv.A0H();
        I6.A06(iv.A08() == 1, A00(0, 21, 44));
        this.A00 = -1;
    }

    public final boolean A02() {
        long A0M;
        int i2;
        int i3 = this.A00 + 1;
        this.A00 = i3;
        if (i3 == this.A05) {
            if (A0A[6].length() != 19) {
                A0A[2] = "dfpT2dt5bGn60gbEA6wBElGJneIfVZr3";
                return false;
            }
            throw new RuntimeException();
        }
        if (this.A08) {
            A0M = this.A06.A0N();
        } else {
            A0M = this.A06.A0M();
        }
        this.A02 = A0M;
        if (this.A00 == this.A03) {
            this.A01 = this.A07.A0H();
            this.A07.A0Z(4);
            int i4 = this.A04 - 1;
            this.A04 = i4;
            if (i4 > 0) {
                IV iv = this.A07;
                String[] strArr = A0A;
                if (strArr[0].length() != strArr[1].length()) {
                    i2 = iv.A0H() - 1;
                } else {
                    A0A[2] = "DxoiDv7jb7q87sjQbqIMGefCzqS86q5Y";
                    i2 = iv.A0H() - 1;
                }
            } else {
                i2 = -1;
            }
            this.A03 = i2;
        }
        return true;
    }
}
