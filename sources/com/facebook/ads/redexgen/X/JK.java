package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum JK {
    A02,
    A03;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 84);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-75, -72, -86, -83, -78, -73, -80, -50, -63, -67, -64, -43};
    }

    static {
        A01();
    }
}
