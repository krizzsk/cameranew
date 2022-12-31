package com.facebook.ads.redexgen.X;

import com.facebook.common.callercontext.ContextChain;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum LT {
    A05(0),
    A06(1),
    A04(2);
    
    public static byte[] A01;
    public static String[] A02 = {"D", "C", "8vWlkexf09f1piT", "bgKjpA4PjvHZdywoorD", "7PPvca8DkKgRdh14PD5p9M98ffpM", "UMv18", "Efwwh", "kVnW00famwT2UvCG2iLw1Nw0GuoWmmQs"};
    public final int A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 85);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        if (A02[2].length() == 27) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[1] = ContextChain.TAG_INFRA;
        strArr[0] = "v";
        A01 = new byte[]{117, 104, 104, 115, 98, 99, 122, 97, 100, 97, 96, 120, 97, 68, 95, 67, 94, 94, 69, 84, 85};
    }

    static {
        A01();
    }

    LT(int i2) {
        this.A00 = i2;
    }
}
