package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Rl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1148Rl extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass87 A00;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{100, 91, 86, 87, 93, 18, 69, 83, 65, 18, 92, 87, 68, 87, 64, 18, 66, 64, 87, 66, 83, 64, 87, 86};
    }

    public C1148Rl(AnonymousClass87 anonymousClass87) {
        this.A00 = anonymousClass87;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        boolean z;
        z = this.A00.A07;
        if (!z) {
            this.A00.A0G(A00(0, 24, 76));
        }
    }
}
