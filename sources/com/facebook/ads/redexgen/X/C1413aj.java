package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.aj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1413aj extends AbstractRunnableC0981Kv {
    public static byte[] A03;
    public final /* synthetic */ AnonymousClass62 A00;
    public final /* synthetic */ XS A01;
    public final /* synthetic */ String A02;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 80);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{53, 55, 60, 55, 32, 59, 49};
    }

    public C1413aj(AnonymousClass62 anonymousClass62, String str, XS xs) {
        this.A00 = anonymousClass62;
        this.A02 = str;
        this.A01 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        try {
            this.A00.A06(this.A02);
        } catch (Throwable th) {
            this.A01.A06().A8q(A00(0, 7, 2), C06808m.A14, new C06818n(th));
        }
    }
}
