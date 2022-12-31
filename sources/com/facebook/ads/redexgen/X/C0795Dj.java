package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Dj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0795Dj {
    public static byte[] A05;
    public static String[] A06 = {"hf", "fOoriazt21jMrEohCjgF", "5pcoEA2RjzUYGp3c284hSml", "TDP", "TcQd4J", "ZwoZidoyZmTAcsLq2C7si8ur9pchlilA", "7hPC8H2GAKGtNA9zFTazBVyLF62gr8nx", "ieTwdaevFDJCiR6re3Kj0HKQAP"};
    public int A00;
    public String A01;
    public final int A02;
    public final int A03;
    public final String A04;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A06[5].charAt(20) == 'G') {
                throw new RuntimeException();
            }
            A06[4] = "YiGkkE";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 120);
            i5++;
        }
    }

    public static void A02() {
        A05 = new byte[]{-36, -28, -30, -21, -30, -17, -34, -15, -30, -53, -30, -12, -58, -31, -91, -90, -99, -22, -14, -16, -15, -99, -33, -30, -99, -32, -34, -23, -23, -30, -31, -99, -33, -30, -29, -20, -17, -30, -99, -17, -30, -15, -17, -26, -30, -13, -26, -21, -28, -99, -26, -31, -16, -85};
        if (A06[4].length() != 6) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[2] = "5MBv7mTxajKZGjnLiZcpayO";
        strArr[7] = "aQlXijXiZ5lh58yhOcnj5z1LQA";
    }

    static {
        A02();
    }

    public C0795Dj(int i2, int i3) {
        this(Integer.MIN_VALUE, i2, i3);
    }

    public C0795Dj(int i2, int i3, int i4) {
        String A00;
        if (i2 != Integer.MIN_VALUE) {
            A00 = i2 + A00(0, 1, 53);
        } else {
            A00 = A00(0, 0, 109);
        }
        this.A04 = A00;
        this.A02 = i3;
        this.A03 = i4;
        this.A00 = Integer.MIN_VALUE;
    }

    private void A01() {
        if (this.A00 != Integer.MIN_VALUE) {
            return;
        }
        throw new IllegalStateException(A00(1, 53, 5));
    }

    public final int A03() {
        A01();
        return this.A00;
    }

    public final String A04() {
        A01();
        return this.A01;
    }

    public final void A05() {
        int i2;
        int i3 = this.A00;
        if (i3 == Integer.MIN_VALUE) {
            i2 = this.A02;
        } else {
            int i4 = this.A03;
            if (A06[5].charAt(20) == 'G') {
                throw new RuntimeException();
            }
            A06[6] = "B9l3YaSVbsV15snZmiMng8FLUGONco5l";
            i2 = i3 + i4;
        }
        this.A00 = i2;
        this.A01 = this.A04 + this.A00;
    }
}
