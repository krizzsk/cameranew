package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Pe  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC1089Pe {
    A06(0),
    A08(1),
    A09(2),
    A03(3),
    A05(4),
    A07(5),
    A04(6),
    A0A(7),
    A0B(10);
    
    public static byte[] A01;
    public final int A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 11);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-85, -80, -95, 113, 121, 120, 105, -47, -62, -42, -44, -58, -46, -50, -61, -37, 119, 106, 120, 122, 114, 106, -82, -90, -92, -85, -63, -74, -70, -78, -93, -100, -101, -93, -94, -109, -63, -76, -80, -62, -84, -83, -73, -80, -54, -76, -72, -69, -67, -80, -66, -66, -76, -70, -71};
    }

    static {
        A01();
    }

    EnumC1089Pe(int i2) {
        this.A00 = i2;
    }
}
