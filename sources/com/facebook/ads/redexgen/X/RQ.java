package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum RQ {
    A03(A00(10, 4, 24)),
    A04(A00(14, 6, 108));
    
    public static byte[] A01;
    public String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 95);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-22, -19, -16, -16, -70, -75, -87, -90, -71, -86, -35, -32, -29, -29, 64, 59, 47, 44, 63, 48};
    }

    static {
        A01();
    }

    RQ(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
