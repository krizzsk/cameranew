package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.Arrays;
@TargetApi(21)
/* loaded from: assets/audience_network.dex */
public final class VM implements InterfaceC0809Dx {
    public static byte[] A02;
    public MediaCodecInfo[] A00;
    public final int A01;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 39);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{10, 28, 26, 12, 11, 28, 84, 9, 21, 24, 0, 27, 24, 26, 18};
    }

    public VM(boolean z) {
        this.A01 = z ? 1 : 0;
    }

    private void A01() {
        if (this.A00 == null) {
            this.A00 = new MediaCodecList(this.A01).getCodecInfos();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0809Dx
    public final int A62() {
        A01();
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0809Dx
    public final MediaCodecInfo A63(int i2) {
        A01();
        return this.A00[i2];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0809Dx
    public final boolean A8X(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A00(0, 15, 94));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0809Dx
    public final boolean AE7() {
        return true;
    }
}
