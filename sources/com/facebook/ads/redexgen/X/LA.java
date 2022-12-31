package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class LA implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ XT A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{97, 122, 125, 98, 97, 99, 104, 99, 116, 111, 101};
    }

    public LA(XT xt) {
        this.A00 = xt;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            C06818n c06818n = new C06818n(A00(0, 4, 88));
            c06818n.A03(1);
            c06818n.A04(1);
            c06818n.A08(false);
            this.A00.A06().A8r(A00(4, 7, 112), C06808m.A1M, c06818n);
        } catch (Throwable otsl) {
            C0974Kn.A00(otsl, this);
        }
    }
}
