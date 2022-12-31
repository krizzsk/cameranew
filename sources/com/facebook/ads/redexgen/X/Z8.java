package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
/* loaded from: assets/audience_network.dex */
public class Z8 implements InterfaceC06356k {
    public final /* synthetic */ Z3 A00;

    public Z8(Z3 z3) {
        this.A00 = z3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        return this.A00.A0C(new HashMap<String, Integer>() { // from class: com.facebook.ads.redexgen.X.6d
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 15);
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{123, -13};
            }

            {
                put(A00(1, 1, 109), Integer.valueOf(Z8.this.A00.A01.widthPixels));
                put(A00(0, 1, 4), Integer.valueOf(Z8.this.A00.A01.heightPixels));
            }
        });
    }
}
