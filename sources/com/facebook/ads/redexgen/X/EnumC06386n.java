package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.6n  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC06386n {
    A03,
    A02;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 38);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-53, -36, -53, -44, -38, -111, -106, -100, -115, -102, -98, -119, -108};
    }

    static {
        A01();
    }
}
