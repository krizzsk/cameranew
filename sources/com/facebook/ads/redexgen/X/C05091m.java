package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.1m  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05091m {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 18);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{25, 95, 67, 90, 91, 124, 107, 121, 111, 124, 106, 107, 106, 81, 120, 103, 106, 107, 97};
    }

    public static void A02(XT xt, C7J c7j, C1524cf c1524cf) {
        c7j.A0W(new C7G(c1524cf.A0N().A01(), PD.A04, PD.A04, c1524cf.A0V(), A00(5, 14, 28)));
        boolean A0l = c1524cf.A0l();
        if (A0l) {
            C7I c7i = new C7I(c1524cf.A0R(), c1524cf.A0V(), A00(5, 14, 28));
            c7i.A04 = true;
            c7i.A03 = A00(0, 5, 37);
            c7j.A0X(c7i);
        }
        boolean A1x = JD.A1x(xt, QJ.A03());
        C7I c7i2 = new C7I(c1524cf.A0K().A0D().A08(), c1524cf.A0V(), A00(5, 14, 28), c1524cf.A0K().A0D().A05());
        if (A0l && !A1x) {
            c7j.A0X(c7i2);
        } else {
            c7j.A0a(c7i2);
        }
        c7j.A0W(new C7G(c1524cf.A0K().A0D().A07(), C05041h.A00(c1524cf.A0K().A0D()), C05041h.A01(c1524cf.A0K().A0D()), c1524cf.A0V(), A00(5, 14, 28)));
        for (String str : c1524cf.A0K().A0G().A00()) {
            c7j.A0W(new C7G(str, -1, -1, c1524cf.A0V(), A00(5, 14, 28)));
        }
    }
}
