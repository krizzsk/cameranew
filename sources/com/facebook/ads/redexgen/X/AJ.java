package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashSet;
/* loaded from: assets/audience_network.dex */
public final class AJ {
    public static String A00;
    public static byte[] A01;
    public static final HashSet<String> A02;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-11, -3, -3, -11, -68, -13, 6, -3, -68, -15, -3, 0, -13};
    }

    static {
        A02();
        A02 = new HashSet<>();
        A00 = A01(0, 13, 125);
    }

    public static synchronized String A00() {
        String str;
        synchronized (AJ.class) {
            str = A00;
        }
        return str;
    }
}
