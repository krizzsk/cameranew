package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.paylibcenter.bean.PayResult;
/* renamed from: com.facebook.ads.redexgen.X.Qm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1123Qm {
    public static byte[] A07;
    public InterfaceC1114Qd A05;
    public int A04 = 60000;
    public int A03 = 100;
    public int A00 = 10000;
    public int A02 = PayResult.PAY_RESULT_ALIPAY_CHECK_IN;
    public int A01 = 3;
    public Map<String, String> A06 = new HashMap();

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{49, 29, 4, 21, 17, 9, 17, 92, 14, 25, 8, 14, 21, 25, 15, 92, 17, 9, 15, 8, 92, 30, 25, 92, 30, 25, 8, 11, 25, 25, 18, 92, 77, 92, 29, 18, 24, 92, 77, 68};
    }

    public final C1123Qm A02(int i2) {
        this.A00 = i2;
        return this;
    }

    public final C1123Qm A03(int i2) {
        if (i2 >= 1 && i2 <= 18) {
            this.A01 = i2;
            return this;
        }
        throw new IllegalArgumentException(A00(0, 40, 56));
    }

    public final C1123Qm A04(int i2) {
        this.A02 = i2;
        return this;
    }

    public final C1123Qm A05(int i2) {
        this.A03 = i2;
        return this;
    }

    public final C1123Qm A06(int i2) {
        this.A04 = i2;
        return this;
    }

    public final C1123Qm A07(InterfaceC1114Qd interfaceC1114Qd) {
        this.A05 = interfaceC1114Qd;
        return this;
    }

    public final C1123Qm A08(Map<String, String> requestHeaders) {
        this.A06 = requestHeaders;
        return this;
    }

    public final C1124Qn A09() {
        return new C1124Qn(this.A04, this.A00, this.A02, this.A03, this.A01, this.A06, this.A05);
    }
}
