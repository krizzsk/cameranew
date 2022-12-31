package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Lv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC1005Lv {
    A08(0),
    A07(0),
    A06(1),
    A03(2),
    A04(3),
    A05(4);
    
    public static byte[] A01;
    public final int A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 61);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-85, -83, -96, -89, -86, -93, -67, -112, -91, -36, -34, -47, -40, -37, -44, -18, -62, -42, -45, -43, -56, -49, -46, -53, -27, -70, -51, -26, -24, -37, -30, -27, -34, -8, -30, -25, -19, -34, -21, -25, -34, -19, -90, -89, -90, -99, -34, -41, -44, -41, -40, -32, -41};
    }

    static {
        A01();
    }

    EnumC1005Lv(int i2) {
        this.A00 = i2;
    }
}
