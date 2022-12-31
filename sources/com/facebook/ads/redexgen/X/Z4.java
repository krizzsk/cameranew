package com.facebook.ads.redexgen.X;

import android.provider.Settings;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class Z4 implements InterfaceC06356k {
    public static byte[] A01;
    public final /* synthetic */ Z3 A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 2);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-77, -93, -78, -91, -91, -82, -97, -94, -78, -87, -89, -88, -76, -82, -91, -77, -77};
    }

    public Z4(Z3 z3) {
        this.A00 = z3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        Z3 z3 = this.A00;
        return z3.A03(Settings.System.getInt(z3.A00, A00(0, 17, 62), -1) / 255.0f);
    }
}
