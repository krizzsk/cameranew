package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Rp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1152Rp extends AbstractRunnableC0981Kv {
    public static byte[] A02;
    public final /* synthetic */ AnonymousClass87 A00;
    public final /* synthetic */ C06667t A01;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-126, -75, -90, -90, -91, -78, -87, -82, -89, 96, -87, -82, -92, -91, -90, -87, -82, -87, -76, -91, -84, -71};
    }

    public C1152Rp(AnonymousClass87 anonymousClass87, C06667t c06667t) {
        this.A00 = anonymousClass87;
        this.A01 = c06667t;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        C1099Po c1099Po;
        C1099Po c1099Po2;
        c1099Po = this.A00.A0A;
        if (c1099Po.getState() == QW.A02) {
            c1099Po2 = this.A00.A0A;
            if (c1099Po2.getCurrentPositionInMillis() == A00()) {
                this.A00.A0G(A00(0, 22, 11));
            }
        }
    }
}
