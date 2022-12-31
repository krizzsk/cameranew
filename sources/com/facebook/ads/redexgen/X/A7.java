package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class A7 extends AbstractC0976Kq {
    public static byte[] A01;
    public static String[] A02 = {"AyjpfVMH4abbuU", "C4f54F5689i8nguXYuZVyawidNrV99tP", "", "kvcj7JPhLleA0fC5", "qT9ER7mxQyIS", "DVCseFxiIzNfwa", "yADVvB6XdmuuqrvB", "b9AAn0hyeOBCYK5qzyR18"};
    public final /* synthetic */ C1183Su A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[1].charAt(16) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[7] = "MNhPeHQbaIIJpJ20hNozP";
            strArr[2] = "";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 60);
            i5++;
        }
    }

    public static void A01() {
        A01 = new byte[]{35, 22, 17, 18, 28, -10, 27, 33, 18, 31, 32, 33, 22, 33, 14, 25, -14, 35, 18, 27, 33};
    }

    static {
        A01();
    }

    public A7(C1183Su c1183Su) {
        this.A00 = c1183Su;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A02 */
    public final void A03(C0977Kr c0977Kr) {
        MU mu;
        mu = this.A00.A04;
        mu.A3r(A00(0, 21, 113), c0977Kr);
    }
}
