package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.9R  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9R {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 51);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-2, -15, -17, -5, -2, -16, -21, -16, -19, 0, -19, -18, -19, -1, -15};
    }

    public static C9T A00(XS xs) {
        try {
            return new C1285Wv(xs);
        } catch (IOException e2) {
            xs.A06().A8q(A02(0, 15, 89), C06808m.A26, new C06818n(e2));
            return new C1288Wy();
        }
    }

    public static C0800Do A01(XS xs) {
        return new C0800Do(xs);
    }
}
