package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.6l  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC06366l {
    A04(0),
    A07(1024),
    A05(2048),
    A06(4096);
    
    public static byte[] A01;
    public static final Map<Integer, EnumC06366l> A02;
    public int A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 24);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-104, -101, -92, -97, -99, -92, -75, -97, -99, -92, -91, -88, -101, 120, 105, 122, 105, 118, 119, 113, 108, Byte.MAX_VALUE, 110, 123, 113, 124, 122, -116, Byte.MIN_VALUE, 110, 122, 125, 121, 114, -91, -89, -91, -94, -101, -107, -101, -95, -89, -91};
    }

    static {
        EnumC06366l[] values;
        A02();
        A02 = new HashMap();
        for (EnumC06366l enumC06366l : values()) {
            A02.put(Integer.valueOf(enumC06366l.A00), enumC06366l);
        }
    }

    EnumC06366l(int i2) {
        this.A00 = i2;
    }

    public static EnumC06366l A00(int i2) {
        EnumC06366l enumC06366l = A02.get(Integer.valueOf(i2));
        return enumC06366l == null ? A04 : enumC06366l;
    }

    public final int A03() {
        return this.A00;
    }
}
