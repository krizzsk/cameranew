package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class S6 extends AbstractRunnableC0981Kv {
    public static byte[] A02;
    public final /* synthetic */ C1066Oh A00;
    public final /* synthetic */ C06667t A01;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 46);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{93, 106, 121, 121, 122, 109, 118, 113, 120, 63, 118, 113, 123, 122, 121, 118, 113, 118, 107, 122, 115, 102};
    }

    public S6(C1066Oh c1066Oh, C06667t c06667t) {
        this.A00 = c1066Oh;
        this.A01 = c06667t;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        C1099Po c1099Po;
        C1099Po c1099Po2;
        c1099Po = this.A00.A0C;
        if (c1099Po.getState() == QW.A02) {
            c1099Po2 = this.A00.A0C;
            if (c1099Po2.getCurrentPositionInMillis() == A00()) {
                this.A00.A0I(A00(0, 22, 49));
            }
        }
    }
}
