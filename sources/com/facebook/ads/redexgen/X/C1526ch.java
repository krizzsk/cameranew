package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.ch  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1526ch extends AnonymousClass16 {
    public static byte[] A00 = null;
    public static String[] A01 = {"jMc", "F9KJU5nWCxEJfH1MtrJPQ98rlg2xhqhb", "7jNlYgKw34wypv3TsOCVRM97qni1IFkS", "W5gvHzH3tQhCbbf1Q7sr07NWbFeRHxz0", "QDsxhdyObZs2LD8uuSUlwesP8VUImdt4", "RqkZZA1TQwwc7Sj8gFRGBwQRvCLKOG1p", "3", "FXFS7BhAGvbRYPXLgdilxhgSLH2Ol13Z"};
    public static final long serialVersionUID = 5751287062553772012L;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[0].length() == 16) {
                throw new RuntimeException();
            }
            A01[0] = "basKOcZiobbMvO07tra14WeVIAzrAzDF";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 105);
            i5++;
        }
    }

    public static void A04() {
        A00 = new byte[]{5, -8, 11, 0, Draft_75.CR, -4};
    }

    static {
        A04();
    }

    public C1526ch(List<AnonymousClass19> list) {
        super(list);
    }

    public static C1526ch A02(JSONObject jSONObject, XT xt) {
        C1526ch c1526ch = new C1526ch(AnonymousClass16.A01(jSONObject, xt, new C1527ci()));
        c1526ch.A0f(jSONObject);
        c1526ch.A0d(A03(0, 6, 46));
        return c1526ch;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final int A0G() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final int A0H() {
        return 0;
    }
}
