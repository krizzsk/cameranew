package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class UV extends C0886Ha {
    public static byte[] A02;
    public final int A00;
    public final Map<String, List<String>> A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 114);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{101, 82, 68, 71, 88, 89, 68, 82, 23, 84, 88, 83, 82, Draft_75.CR, 23};
    }

    public UV(int i2, Map<String, List<String>> map, HV hv) {
        super(A00(0, 15, 69) + i2, hv, 1);
        this.A00 = i2;
        this.A01 = map;
    }
}
