package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class I1 {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 88);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-40, -21, -30, -46, -33, -40, -31, -10, 9, 0, -16, 3, -10, -11, -6, 3};
    }

    public static long A00(I0 i0) {
        return i0.A5U(A02(0, 7, 27), -1L);
    }

    @Nullable
    public static Uri A01(I0 i0) {
        String A5W = i0.A5W(A02(7, 9, 57), null);
        if (A5W == null) {
            return null;
        }
        return Uri.parse(A5W);
    }

    public static void A04(I2 i2) {
        i2.A01(A02(7, 9, 57));
    }

    public static void A05(I2 i2, long j2) {
        i2.A02(A02(0, 7, 27), j2);
    }

    public static void A06(I2 i2, Uri uri) {
        i2.A03(A02(7, 9, 57), uri.toString());
    }
}
