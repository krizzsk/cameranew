package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.dZ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC1579dZ {
    A02,
    A04,
    A03;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 49);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-54, -45, -39, -54, -41, -38, -19, -34, -23, -15, -20, -32, -35, -16, -31};
    }

    static {
        A01();
    }
}
