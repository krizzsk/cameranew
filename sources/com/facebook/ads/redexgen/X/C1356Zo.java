package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Zo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1356Zo implements InterfaceC06356k {
    public static byte[] A01;
    public final /* synthetic */ C1350Zi A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 98);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{74, 59, 67, 70, 59, 72, 55, 74, 75, 72, 59};
    }

    public C1356Zo(C1350Zi c1350Zi) {
        this.A00 = c1350Zi;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        return this.A00.A0A(A00(0, 11, 116), Integer.MIN_VALUE);
    }
}
