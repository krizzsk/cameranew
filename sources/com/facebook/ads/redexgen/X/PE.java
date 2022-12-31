package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class PE {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final AnonymousClass19 A02;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 75);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-27, -29, -12, -26, -27, -16, -10, 12, 10, 27, Draft_75.CR, 18, 23, Draft_75.CR};
    }

    public PE(int i2, int i3, AnonymousClass19 anonymousClass19) {
        this.A01 = i2;
        this.A00 = i3;
        this.A02 = anonymousClass19;
    }

    public final int A02() {
        return this.A01;
    }

    public final AnonymousClass19 A03() {
        return this.A02;
    }

    public final Map<String, String> A04() {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(this.A01);
        String A00 = A00(0, 0, 12);
        sb.append(A00);
        hashMap.put(A00(7, 7, 94), sb.toString());
        hashMap.put(A00(0, 7, 55), this.A00 + A00);
        return hashMap;
    }
}
