package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.8Q  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8Q {
    public static byte[] A03;
    public final int A00;
    public final String A01;
    public final String A02;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 117);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{2};
    }

    public C8Q(int i2, String str, String str2) {
        this.A00 = i2;
        this.A01 = str;
        this.A02 = str2;
    }

    public final String A02() {
        return this.A01 + A00(0, 1, 109) + this.A02;
    }
}
