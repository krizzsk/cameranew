package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class IY extends IOException {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 51);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{33, 45, 101, 100, 106, 101, 104, 126, 121, 48, 61, 31, 4, 2, 31, 4, 25, 20, 77, 25, 2, 2, 77, 1, 2, 26, 77, 54, 29, 31, 4, 2, 31, 4, 25, 20, 80, 65};
    }

    public IY(int i2, int i3) {
        super(A00(10, 27, 94) + i2 + A00(0, 10, 62) + i3 + A00(37, 1, 47));
    }
}
