package com.facebook.ads.redexgen.X;

import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: assets/audience_network.dex */
public enum RE {
    A04(A01(37, 3, 86)),
    A05(A01(40, 7, 117));
    
    public static byte[] A01;
    public static String[] A02 = {"kIaQKGqX2ZTqEjvfJkZOl1WwOBoH9uFY", "x", "Fa9eXDyIy4elyWfec912IKE0nqoR5HQV", "", "DfNaQJeOEpNPwVx", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "0vF5Kqqkw0y14nBhXHX4F0aBgr7OScbz", ""};
    public String A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 102);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{21, 23, 31, -34, 3, 11, -10, 1, -2, -7, -75, 8, -6, 7, 11, -6, 7, -75, 7, -6, 8, 5, 4, 3, 8, -6, -49, -75, -70, 8, -6, -13, -16, -13, -12, -4, -13, 29, 31, 39, 80, 73, 70, 73, 74, 82, 73};
    }

    static {
        A02();
    }

    RE(String str) {
        this.A00 = str;
    }

    public static RE A00(String str) {
        RE[] valuesCustom;
        for (RE re : valuesCustom()) {
            if (re.A00.equals(str)) {
                return re;
            }
        }
        throw new IllegalArgumentException(String.format(Locale.US, A01(3, 27, 47), str));
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static RE[] valuesCustom() {
        RE[] reArr = (RE[]) values().clone();
        String[] strArr = A02;
        if (strArr[7].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[7] = "";
        strArr2[3] = "";
        return reArr;
    }
}
