package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.6p  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC06406p {
    A04(0),
    A05(100);
    
    public static byte[] A01;
    public static final Map<Integer, EnumC06406p> A02;
    public int A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-98, -97, -96, -101, -81, -90, -82, -104, -103, -105, -104};
    }

    static {
        EnumC06406p[] values;
        A02();
        A02 = new HashMap();
        for (EnumC06406p enumC06406p : values()) {
            A02.put(Integer.valueOf(enumC06406p.A00), enumC06406p);
        }
    }

    EnumC06406p(int i2) {
        this.A00 = i2;
    }

    public static EnumC06406p A00(int i2) {
        EnumC06406p enumC06406p = A02.get(Integer.valueOf(i2));
        return enumC06406p == null ? A04 : enumC06406p;
    }
}
