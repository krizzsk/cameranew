package com.facebook.ads.redexgen.X;

import com.facebook.ads.VideoAutoplayBehavior;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Jw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0958Jw {
    A03,
    A05,
    A04;
    
    public static byte[] A00;
    public static String[] A01 = {"Gjwy6cOcQ9K2s9TECvKSb1UBI6p92tWs", "MkJKTqDYMAzsSL3ogCclj8aQMOEn3Zaf", "eTpSOjZOB", "ux", "6lFNHDDwy35cZQ5ctUwn46ZPa5FkYtAF", "2ZxEJa2ax0wS4G", "Utm", "f4eG1TG9uZ10lRPR3hza"};

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 116);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-57, -56, -55, -60, -40, -49, -41, -11, -20, -20, 22, 21};
    }

    static {
        A02();
    }

    public static VideoAutoplayBehavior A00(EnumC0958Jw enumC0958Jw) {
        if (enumC0958Jw == null) {
            return VideoAutoplayBehavior.DEFAULT;
        }
        int i2 = C0957Jv.A00[enumC0958Jw.ordinal()];
        if (i2 != 1) {
            if (A01[1].charAt(9) != 'M') {
                A01[5] = "KWBYg9gUO";
                if (i2 != 2) {
                    if (i2 != 3) {
                        VideoAutoplayBehavior videoAutoplayBehavior = VideoAutoplayBehavior.DEFAULT;
                        String[] strArr = A01;
                        if (strArr[0].charAt(5) == strArr[4].charAt(5)) {
                            A01[2] = "D4DDJWMfk";
                            return videoAutoplayBehavior;
                        }
                        String[] strArr2 = A01;
                        strArr2[0] = "jNXTJSXFaHaCK7i5lqJo4GmnkgAhCocQ";
                        strArr2[4] = "apiAoBnIaWOp8nG5E1dZaMbzfZqR1u59";
                        return videoAutoplayBehavior;
                    }
                    return VideoAutoplayBehavior.OFF;
                }
                return VideoAutoplayBehavior.ON;
            }
            throw new RuntimeException();
        }
        return VideoAutoplayBehavior.DEFAULT;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static EnumC0958Jw[] valuesCustom() {
        EnumC0958Jw[] valuesCustom = values();
        if (A01[1].charAt(9) != 'M') {
            String[] strArr = A01;
            strArr[6] = "qrA";
            strArr[3] = "mB";
            return (EnumC0958Jw[]) valuesCustom.clone();
        }
        throw new RuntimeException();
    }
}
