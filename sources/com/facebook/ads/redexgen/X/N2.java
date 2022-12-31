package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdLayout;
/* loaded from: assets/audience_network.dex */
public final class N2 {
    public static String[] A00 = {"Mh7OQPY25mJ4xZdJdnJU4lIWxnSb2W80", "uMvQGqYS2R9kLiwAhxbB5gyg9uPLoFmG", "JD8RnvPxGeaTxsc34jN0O6vhnDfoaLvm", "v", "yiVoJ6", "bh6EDcFJy1WMlrC6ew5uNV", "HsXTYL", "k"};
    public static final int A01 = (int) (LY.A00 * 200.0f);
    public static final int A03 = (int) (LY.A00 * 200.0f);
    public static final int A02 = (int) (LY.A00 * 50.0f);

    public static AnonymousClass10 A00(@Nullable NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return AnonymousClass10.A05;
        }
        if (A03(nativeAdLayout)) {
            return AnonymousClass10.A06;
        }
        return AnonymousClass10.A04;
    }

    @Nullable
    public static N1 A01(XT xt, JT jt, String str, @Nullable NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return null;
        }
        int width = nativeAdLayout.getWidth();
        int height = nativeAdLayout.getHeight();
        int i2 = A01;
        if (width >= i2 && height >= i2) {
            return new C1177So(xt, jt, str);
        }
        if (width < A03 || height < A02) {
            return null;
        }
        return new C1178Sp(xt, jt, str);
    }

    public static N1 A02(XT xt, JT jt, String str, C1S c1s, MV mv, MU mu) {
        return new C1179Sq(xt, jt, str, c1s, mv, mu);
    }

    public static boolean A03(NativeAdLayout nativeAdLayout) {
        int h2 = nativeAdLayout.getWidth();
        int w = nativeAdLayout.getHeight();
        int i2 = A01;
        if (h2 < i2 || w < i2) {
            if (h2 >= A03) {
                int i3 = A02;
                if (A00[5].length() != 22) {
                    throw new RuntimeException();
                }
                A00[5] = "hhrIY4o6fKEkU42z4UVpb3";
                if (w < i3) {
                }
            }
            return true;
        }
        return false;
    }
}
