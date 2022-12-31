package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.9X  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum C9X {
    A02,
    A04,
    A03;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 19);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{58, 57, 40, 63, 52, 57, 56, 35, 46, 57, 63, 51, 46, 56, 47, 67, 64, 81, 70, 77, 90, 71, 80, 67, 67, 64, 87, 90, 81, 74, 74, 90, 86, 72, 68, 73, 73, 77, 76, 92, 81, 70, 64, 76, 81, 71, 80, 92, 87, 76, 92, 69, 70, 87, 64, 75};
    }

    static {
        A01();
    }
}
