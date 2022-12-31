package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class XD implements InterfaceC1114Qd {
    public static byte[] A01;
    public final XS A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 127);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-2, -45, -20, -24, -45, -10, 21, 21, 18, -45, -8, 21, 27, 26, 15, 20, Draft_75.CR, -45, -6, 21, 17, 11, 20, 102, 100, 86, 99, 30, 82, 88, 86, 95, 101};
    }

    public XD(XS xs) {
        this.A00 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1114Qd
    public final Map<String, String> A5T(boolean z) {
        HashMap hashMap = new HashMap();
        if (!C06075h.A00().A04()) {
            hashMap.put(A00(0, 23, 39), C9H.A00().A01(this.A00, true).A7S());
        }
        hashMap.put(A00(23, 10, 114), C9L.A06(new C06908w(this.A00), this.A00, z));
        return hashMap;
    }
}
