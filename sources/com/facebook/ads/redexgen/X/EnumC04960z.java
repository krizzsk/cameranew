package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.0z  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC04960z {
    A03(A00(13, 3, 1)),
    A05(A00(22, 4, 3)),
    A04(A00(16, 6, 82));
    
    public static byte[] A01;
    public final String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{126, -119, -119, -38, -50, -37, -30, -50, -39, -71, -70, -71, -80, -105, -94, -94, -12, -24, -11, -4, -24, -13, -90, -89, -90, -99};
    }

    static {
        A01();
    }

    EnumC04960z(String str) {
        this.A00 = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.A00;
    }
}
