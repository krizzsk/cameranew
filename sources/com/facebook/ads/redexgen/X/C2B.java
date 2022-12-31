package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.2B  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum C2B {
    A05(A00(22, 6, 6)),
    A03(A00(14, 4, 124)),
    A04(A00(18, 4, 24));
    
    public static byte[] A01;
    public final String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 99);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{66, 67, 78, 79, 15, 14, 15, 4, 91, 76, 89, 70, 91, 93, 119, 118, 123, 122, 21, 20, 21, 30, 23, 0, 21, 10, 23, 17};
    }

    static {
        A01();
    }

    C2B(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
