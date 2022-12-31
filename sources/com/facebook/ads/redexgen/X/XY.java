package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class XY extends AbstractRunnableC0981Kv {
    public static byte[] A02;
    public final /* synthetic */ XX A00;
    public final /* synthetic */ AtomicBoolean A01;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 31);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{117, 87, 85, 94, 83, 22, 80, 87, 95, 90, 24, 77, 111, 109, 102, 107, 46, 125, 123, 109, 109, 107, 125, 125, 32};
    }

    public XY(XX xx, AtomicBoolean atomicBoolean) {
        this.A00 = xx;
        this.A01 = atomicBoolean;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        C8J c8j;
        long j2;
        C8J c8j2;
        long j3;
        if (this.A00.A00 != null) {
            if (this.A01.get()) {
                this.A00.A02.A0G(EnumC0936Ja.A0H);
                c8j2 = this.A00.A02.A04;
                C7C c7c = this.A00.A01;
                int i2 = C7M.A00;
                j3 = this.A00.A02.A00;
                C7M.A02(c8j2, c7c, i2, A00(11, 14, 17), j3);
                this.A00.A02.A0R();
                this.A00.A00.AAC();
                return;
            }
            this.A00.A02.A0G(EnumC0936Ja.A0G);
            c8j = this.A00.A02.A04;
            C7C c7c2 = this.A00.A01;
            int i3 = C7M.A04;
            j2 = this.A00.A02.A00;
            C7M.A02(c8j, c7c2, i3, A00(0, 11, 41), j2);
            this.A00.A02.A0S();
            this.A00.A00.AA5();
        }
    }
}
