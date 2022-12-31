package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.0e  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC04760e {
    A02,
    A03;
    
    public static byte[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 101);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-25, -27, -14, -14, -13, -8, 3, -13, -12, -23, -14, -6, -8, 5, 5, 6, 11, 22, 11, 9, -8, -6, 2};
    }

    static {
        A01();
    }

    public static boolean A02(@Nullable EnumC04760e enumC04760e) {
        return A02.equals(enumC04760e) || A03.equals(enumC04760e);
    }
}
