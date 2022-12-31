package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Nv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC1056Nv {
    A06(0),
    A05(1),
    A04(2);
    
    public static byte[] A01;
    public static String[] A02 = {"rZGvvZMI6I", "wpdicw5jfWUP9Cs9nncu65zzvPXSjTXh", "qXEMgnv7Ct425l7In8PWxhOPFYVbEYpB", "dTodKdBY68fO6HNBSU3LN7qZJ4nOCEpk", "Hkjhu", "mY7TKQYFYXm3BBS2pDypGTbdY20sKsEk", "u0FGaDIimXxXG0l3UqPLAtx16Sc8Y059", "GEphX9PDUn8ir5euMIdeMTZrm9gVIFzw"};
    public int A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 67);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{46, 35, 44, 38, 49, 33, 35, 50, 39, 77, 82, 79, 73, 79, 92, 84, 73, 102, 125, 96, 99, 118, 112, 122, 117, 122, 118, 119};
    }

    static {
        A02();
    }

    EnumC1056Nv(int i2) {
        this.A00 = i2;
    }

    public static EnumC1056Nv A00(int i2) {
        EnumC1056Nv[] valuesCustom;
        for (EnumC1056Nv enumC1056Nv : valuesCustom()) {
            if (enumC1056Nv.A00 == i2) {
                return enumC1056Nv;
            }
        }
        return A05;
    }

    public final int A03() {
        return this.A00;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static EnumC1056Nv[] valuesCustom() {
        Object clone = values().clone();
        if (A02[4].length() != 18) {
            A02[4] = "9YF3oPenjmVnddjujEMQmJq4m";
            return (EnumC1056Nv[]) clone;
        }
        throw new RuntimeException();
    }
}
