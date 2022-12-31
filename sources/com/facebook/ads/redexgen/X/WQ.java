package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.reflect.Constructor;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class WQ implements CS {
    public static byte[] A06;
    public static final Constructor<? extends CP> A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05 = 1;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 75);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{4, 51, 51, 46, 51, 97, 40, 47, 50, 53, 32, 47, 53, 40, 32, 53, 40, 47, 38, 97, 7, Draft_75.CR, 0, 2, 97, 36, 57, 53, 36, 47, 50, 40, 46, 47, 37, 30, 21, 8, 0, 21, 19, 4, 21, 20, 80, 21, 2, 2, 31, 2, 80, 19, 2, 21, 17, 4, 25, 30, 23, 80, 54, 60, 49, 51, 80, 21, 8, 4, 2, 17, 19, 4, 31, 2, 98, 110, 108, 47, 103, 96, 98, 100, 99, 110, 110, 106, 47, 96, 101, 114, 47, 104, 111, 117, 100, 115, 111, 96, 109, 47, 100, 121, 110, 113, 109, 96, 120, 100, 115, 51, 47, 100, 121, 117, 47, 103, 109, 96, 98, 47, 71, 109, 96, 98, 68, 121, 117, 115, 96, 98, 117, 110, 115};
    }

    static {
        A01();
        Constructor<? extends CP> constructor = null;
        try {
            constructor = Class.forName(A00(74, 59, 74)).asSubclass(CP.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException(A00(0, 34, 10), e2);
        }
        A07 = constructor;
    }

    @Override // com.facebook.ads.redexgen.X.CS
    public final synchronized CP[] A4G() {
        CP[] cpArr;
        cpArr = new CP[A07 == null ? 12 : 13];
        cpArr[0] = new WB(this.A01);
        cpArr[1] = new W1(this.A00);
        cpArr[2] = new C1263Vz(this.A03);
        cpArr[3] = new W8(this.A02);
        cpArr[4] = new C1249Vl();
        cpArr[5] = new C1252Vo();
        cpArr[6] = new VS(this.A05, this.A04);
        cpArr[7] = new WI();
        cpArr[8] = new C1257Vt();
        cpArr[9] = new VY();
        cpArr[10] = new VQ();
        cpArr[11] = new WL();
        if (A07 != null) {
            try {
                cpArr[12] = A07.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException(A00(34, 40, 59), e2);
            }
        }
        return cpArr;
    }
}
