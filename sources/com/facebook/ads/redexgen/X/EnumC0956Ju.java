package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* renamed from: com.facebook.ads.redexgen.X.Ju  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0956Ju {
    A06(-1, 100, 1, 0),
    A07(-1, 120, 2, 1),
    A08(-1, IjkMediaCodecInfo.RANK_SECURE, 3, 2),
    A09(-1, 400, 4, 3),
    A0A(-1, 50, 5, 4),
    A0B(-1, -1, 6, 5);
    
    public static byte[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 57);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-110, -113, -109, -111, -110, -98, -87, 123, 122, 122, -63, -66, -62, -64, -63, -51, -40, -86, -85, -87, -65, -68, -64, -66, -65, -53, -42, -86, -89, -89, -47, -50, -46, -48, -47, -35, -24, -67, -71, -71, -121, -124, -120, -122, -121, -109, -98, 116, 111, -72, -85, -87, -70, -59, -86, -65, -76, -89, -77, -81, -87};
    }

    static {
        A02();
    }

    EnumC0956Ju(int i2, int i3, int i4, int i5) {
        this.A03 = i2;
        this.A01 = i3;
        this.A02 = i4;
        this.A00 = i5;
    }

    public static EnumC0956Ju A00(int i2) {
        EnumC0956Ju[] values;
        for (EnumC0956Ju enumC0956Ju : values()) {
            if (enumC0956Ju.A00 == i2) {
                return enumC0956Ju;
            }
        }
        return null;
    }

    public final int A03() {
        return this.A01;
    }

    public final int A04() {
        return this.A02;
    }

    public final int A05() {
        return this.A03;
    }
}
