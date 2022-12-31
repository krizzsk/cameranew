package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class S8 extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public final /* synthetic */ C1066Oh A00;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 41);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{5, 58, 55, 54, 60, 115, 61, 54, 37, 54, 33, 115, 32, 39, 50, 33, 39, 54, 55, 115, 35, 63, 50, 42, 58, 61, 52};
    }

    public S8(C1066Oh c1066Oh) {
        this.A00 = c1066Oh;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        boolean z;
        z = this.A00.A04;
        if (!z) {
            this.A00.A0I(A00(0, 27, 122));
        }
    }
}
