package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Zr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1359Zr implements InterfaceC06356k {
    public static byte[] A01;
    public final /* synthetic */ C1350Zi A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 112);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{25, 30, 11, 30, 31, 25};
    }

    public C1359Zr(C1350Zi c1350Zi) {
        this.A00 = c1350Zi;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        return this.A00.A0A(A00(0, 6, 26), 1);
    }
}
