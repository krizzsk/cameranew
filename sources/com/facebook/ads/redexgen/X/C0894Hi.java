package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Hi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0894Hi extends IOException {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 46);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-79, -105, -47, -22, -31, -12, -20, -31, -33, -16, -31, -32, -100};
    }

    public C0894Hi(Throwable th) {
        super(A00(2, 11, 78) + th.getClass().getSimpleName() + A00(0, 2, 73) + th.getMessage(), th);
    }
}
