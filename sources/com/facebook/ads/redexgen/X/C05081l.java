package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.1l  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05081l {
    public static byte[] A00;
    public static String[] A01 = {"kdNZsDbIr2FjUgQ6", "G4tbE8YXKkBHtbRzjHgF1iVs8BhQX3ki", "rgsd1nh14jUfY0oEDkCzVbJlkUwrdBXO", "6d8i19T6TQ9xRiUYh6SOmARBfT83lkdi", "2FsjHYpAfMpiihTdUse", "xtyrzkpFCSmXtl0pVvZtRxgukiiALNOU", "PnjWz3Ubzat8tEiN6RTB47L4MZQANY1H", "IONaBzwOxfylvpW8Ch"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[6].charAt(12) != strArr[5].charAt(12)) {
                break;
            }
            A01[2] = "wyIfRhN1EoOdsBbK5VRzuRP5Lc7uqmgb";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            byte b = (byte) ((copyOfRange[i5] - i4) - 100);
            if (A01[0].length() == 15) {
                break;
            }
            String[] strArr2 = A01;
            strArr2[3] = "fUzr4JaNgjTtoWHz8k6HkVts9HpSP1Qi";
            strArr2[1] = "zuQx1GaumRIGoFj6MrcQJkCLkICnzrhi";
            copyOfRange[i5] = b;
            i5++;
        }
        throw new RuntimeException();
    }

    public static void A01() {
        A00 = new byte[]{-88, -30, -18, -25, -26};
    }

    static {
        A01();
    }

    public static void A02(XT xt, AnonymousClass16 anonymousClass16, boolean z, InterfaceC05061j interfaceC05061j) {
        if (!JD.A1L(xt)) {
            C7J c7j = new C7J(xt);
            C1U A06 = anonymousClass16.A0K().A0D().A06();
            c7j.A0b(new C0937Jb(anonymousClass16.A0Q(), xt.A08()));
            if (A06 == null) {
                interfaceC05061j.ABX(AdError.CACHE_ERROR);
                return;
            } else if (A06.A0J()) {
                interfaceC05061j.ABY();
                if (A01[2].charAt(7) != '1') {
                    throw new RuntimeException();
                }
                A01[0] = "84TqyqDRqUmJCVM8";
                return;
            } else {
                C7I c7i = new C7I(A06.A0E(), anonymousClass16.A0V(), anonymousClass16.A0U());
                c7i.A04 = true;
                if (JD.A1F(xt)) {
                    c7i.A03 = A00(0, 5, 22);
                }
                int i2 = C05051i.A00[A06.A09().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    c7j.A0X(c7i);
                }
                c7j.A0V(new C7G(anonymousClass16.A0N().A01(), -1, -1, anonymousClass16.A0V(), anonymousClass16.A0U()));
                c7j.A0V(new C7G(A06.A0D(), -1, -1, anonymousClass16.A0V(), anonymousClass16.A0U()));
                c7j.A0U(new C1517cY(xt, interfaceC05061j, c7j, A06, z), new C7C(anonymousClass16.A0V(), anonymousClass16.A0U()));
                return;
            }
        }
        interfaceC05061j.ABY();
    }
}
