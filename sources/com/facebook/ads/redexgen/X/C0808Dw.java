package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Dw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0808Dw extends Exception {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 101);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{36, 63, 71, 74, 67, 66, -2, 82, 77, -2, 79, 83, 67, 80, 87, -2, 83, 76, 66, 67, 80, 74, 87, 71, 76, 69, -2, 75, 67, 66, 71, 63, -2, 65, 77, 66, 67, 65, 81};
    }

    public C0808Dw(Throwable th) {
        super(A00(0, 39, 121), th);
    }
}
