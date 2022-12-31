package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class BK extends Exception {
    public static byte[] A01;
    public final int A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 76);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{88, 108, 125, 112, 118, 77, 107, 120, 122, 114, 57, 110, 107, 112, 109, 124, 57, Byte.MAX_VALUE, 120, 112, 117, 124, 125, 35, 57};
    }

    public BK(int i2) {
        super(A00(0, 25, 85) + i2);
        this.A00 = i2;
    }
}
