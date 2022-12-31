package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class XE implements L1 {
    public static byte[] A01;
    public final /* synthetic */ XS A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 15);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{68, 64, 67, 119, 102, 107, 103, 108, 97, 103, 76, 103, 118, 117, 109, 112, 105, 15, 52, 63, 34, 42, 63, 57, 46, 63, 62, 122, 63, 40, 40, 53, 40, 116, 121, 104, 123, 105, 114, 69, 105, 114, 115, Byte.MAX_VALUE, 118, 126};
    }

    public XE(XS xs) {
        this.A00 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.L1
    public final void A8g(int i2, Throwable th) {
        Log.e(A00(0, 17, 13), A00(17, 17, 85), th);
        this.A00.A06().A8q(A00(34, 12, 21), i2, new C06818n(th));
    }
}
