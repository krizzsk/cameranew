package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class S7 extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public final /* synthetic */ C1066Oh A00;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 80);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-78, -59, -64, -63, -53, 124, -45, -67, -49, 124, -54, -63, -46, -63, -50, 124, -52, -50, -63, -52, -67, -50, -63, -64};
    }

    public S7(C1066Oh c1066Oh) {
        this.A00 = c1066Oh;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        boolean z;
        z = this.A00.A03;
        if (!z) {
            this.A00.A0I(A00(0, 24, 12));
        }
    }
}
