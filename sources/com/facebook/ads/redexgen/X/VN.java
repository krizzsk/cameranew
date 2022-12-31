package com.facebook.ads.redexgen.X;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class VN implements InterfaceC0809Dx {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 13);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{72, 87, 90, 91, 81, 17, 95, 72, 93};
    }

    public VN() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0809Dx
    public final int A62() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0809Dx
    public final MediaCodecInfo A63(int i2) {
        return MediaCodecList.getCodecInfoAt(i2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0809Dx
    public final boolean A8X(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return A00(0, 9, 51).equals(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0809Dx
    public final boolean AE7() {
        return false;
    }
}
