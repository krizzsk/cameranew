package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.0h  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC04790h {
    A03,
    A02,
    A04;
    
    public static byte[] A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 43);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{37, 34, 63, 56, 45, 32, 32, 41, 40, 37, 36, 37, 46, 101, 100, Byte.MAX_VALUE, 116, 98, 101, 120, Byte.MAX_VALUE, 106, 103, 103, 110, 111};
    }

    static {
        A02();
    }

    public static EnumC04790h A00(String str) {
        if (TextUtils.isEmpty(str)) {
            return A03;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException unused) {
            return A03;
        }
    }
}
