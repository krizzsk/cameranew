package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum KZ {
    A04,
    A03,
    A02;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-6, -3, 12, -95, -82, -82, -85, -82, -77, -84, -87, -84, -83, -75, -84};
    }

    static {
        A01();
    }
}
