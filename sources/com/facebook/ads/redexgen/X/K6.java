package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum K6 {
    A06,
    A02,
    A03,
    A04,
    A05;
    
    public static byte[] A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{14, Draft_75.CR, 26, 26, 17, 30, 8, Draft_75.CR, 19, 4, 17, 18, 19, 8, 19, 8, 0, 11, -58, -71, -52, -63, -50, -67, -18, -31, -13, -35, -18, -32, -31, -32, -5, -14, -27, -32, -31, -21, -34, -41, -44, -41, -40, -32, -41};
    }

    static {
        A02();
    }

    public static K6 A00(K9 k9) {
        switch (k9) {
            case A05:
                return A04;
            case A09:
            case A0A:
            case A0B:
            case A08:
                return A02;
            case A0C:
            case A0F:
            case A0D:
            case A0E:
                return A03;
            case A06:
                return A05;
            default:
                return A06;
        }
    }

    public final AdPlacementType A03() {
        int i2 = K5.A00[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return AdPlacementType.UNKNOWN;
                    }
                    return AdPlacementType.REWARDED_VIDEO;
                }
                return AdPlacementType.NATIVE;
            }
            return AdPlacementType.BANNER;
        }
        return AdPlacementType.INTERSTITIAL;
    }
}
