package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.cV  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1514cV extends AbstractRunnableC0981Kv {
    public static byte[] A03;
    public final /* synthetic */ C1546d1 A00;
    public final /* synthetic */ C05121p A01;
    public final /* synthetic */ F8 A02;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 74);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{32, 5, 0, 17, 21, 4, 19, 65, 21, 8, 12, 4, 14, 20, 21, 79};
    }

    public C1514cV(F8 f8, C05121p c05121p, C1546d1 c1546d1) {
        this.A02 = f8;
        this.A01 = c05121p;
        this.A00 = c1546d1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        this.A02.A0N(this.A01);
        this.A02.A0K(this.A00);
        this.A02.AAW(new K3(AdErrorType.NETWORK_ERROR, A00(0, 16, 43)));
    }
}
