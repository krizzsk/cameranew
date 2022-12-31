package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum R7 {
    A02,
    A03;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 40);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-124, -115, -118, -122, -113, -107, -96, -112, -104, -113, -122, -123, -112, -126, -113, -109, -126, -113, -100, -116, -108, -117, -126, -127};
    }

    static {
        A01();
    }
}
