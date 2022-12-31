package com.facebook.ads.redexgen.X;

import com.facebook.ads.VideoStartReason;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Pj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC1094Pj {
    A04(VideoStartReason.NOT_STARTED),
    A05(VideoStartReason.USER_STARTED),
    A03(VideoStartReason.AUTO_STARTED);
    
    public static byte[] A01;
    public final VideoStartReason A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 116);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{10, 30, 31, 4, 20, 24, 31, 10, 25, 31, 14, 15, 66, 67, 88, 83, 95, 88, 77, 94, 88, 73, 72, 18, 20, 2, 21, 24, 20, 19, 6, 21, 19, 2, 3};
    }

    static {
        A02();
    }

    EnumC1094Pj(VideoStartReason videoStartReason) {
        this.A00 = videoStartReason;
    }

    public static EnumC1094Pj A00(VideoStartReason videoStartReason) {
        EnumC1094Pj[] values;
        for (EnumC1094Pj enumC1094Pj : values()) {
            if (enumC1094Pj.A00 == videoStartReason) {
                return enumC1094Pj;
            }
        }
        return A04;
    }
}
