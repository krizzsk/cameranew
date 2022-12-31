package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum JL {
    A02,
    A03,
    A04;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 14);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{98, 101, 92, 90, 92, 97, 84, 95, -49, -47, -66, -49, -63, -51, -47, -63, -54, -48, 122, 109, 105, 123, 101, 102, 109, 112, 109, 120, 125};
    }

    static {
        A01();
    }
}
