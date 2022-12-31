package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Jl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0947Jl {
    A05(0, NativeAdBase.MediaCacheFlag.NONE),
    A04(1, NativeAdBase.MediaCacheFlag.ALL);
    
    public static byte[] A02;
    public final long A00;
    public final NativeAdBase.MediaCacheFlag A01;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 111);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 75, 75, 34, 35, 34, 41};
    }

    static {
        A02();
    }

    EnumC0947Jl(long j2, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = j2;
        this.A01 = mediaCacheFlag;
    }

    public static EnumC0947Jl A00(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        EnumC0947Jl[] values;
        for (EnumC0947Jl enumC0947Jl : values()) {
            if (enumC0947Jl.A01 == mediaCacheFlag) {
                return enumC0947Jl;
            }
        }
        return null;
    }
}
