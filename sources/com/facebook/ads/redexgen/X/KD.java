package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum KD {
    A02,
    A03;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{18, Draft_75.CR, -95, -94, -95, -104};
    }

    static {
        A01();
    }
}
