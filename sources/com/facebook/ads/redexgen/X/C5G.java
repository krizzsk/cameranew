package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5G  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5G implements NativeAdScrollViewApi {
    public static byte[] A07;
    public final int A00;
    @Nullable
    public final NativeAdScrollView.AdViewProvider A01;
    @Nullable
    public final NativeAdView.Type A02;
    public final NativeAdViewAttributes A03;
    public final NativeAdsManager A04;
    public final C1435b5 A05;
    public final XT A06;

    static {
        A07();
    }

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 33);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-61, -21, -23, -22, -106, -26, -24, -27, -20, -33, -38, -37, -106, -41, -106, -60, -41, -22, -33, -20, -37, -73, -38, -52, -33, -37, -19, -92, -54, -17, -26, -37, -94, -106, -73, -38, -52, -33, -37, -19, -58, -24, -27, -20, -33, -38, -37, -24, -106, -27, -24, -106, -41, -106, -28, -41, -22, -33, -20, -37, -73, -38, -52, -33, -37, -19, -66, -37, -33, -35, -34, -22, -70, -26, -106, -87, -68, -79, -66, -83, -119, -84, -69, -107, -87, -74, -87, -81, -83, -70, 104, -74, -73, -68, 104, -76, -73, -87, -84, -83, -84};
    }

    public C5G(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, @Nullable NativeAdScrollView.AdViewProvider adViewProvider, int i2, @Nullable NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i3) {
        if (nativeAdsManager.isLoaded()) {
            if (type != null || adViewProvider != null || i2 > 0) {
                this.A06 = AnonymousClass59.A02(context);
                this.A04 = nativeAdsManager;
                this.A03 = nativeAdViewAttributes;
                this.A01 = adViewProvider;
                this.A02 = type;
                this.A00 = i3;
                C1436b6 c1436b6 = new C1436b6(this);
                this.A05 = new C1435b5(context);
                if (this.A02 == null) {
                    if (i2 > 0) {
                        this.A05.A00(((int) LY.A00) * i2);
                    }
                } else {
                    this.A05.A00((int) (LY.A00 * this.A02.getHeight()));
                }
                this.A05.setAdapter(c1436b6);
                setInset(20);
                c1436b6.A0D();
                nativeAdScrollView.addView(this.A05);
                return;
            }
            throw new IllegalArgumentException(A06(0, 74, 85));
        }
        throw new IllegalStateException(A06(74, 27, 39));
    }

    @Override // com.facebook.ads.internal.api.NativeAdScrollViewApi
    public final void setInset(int insetDp) {
        if (insetDp > 0) {
            float f2 = LY.A00;
            int round = Math.round(insetDp * f2);
            this.A05.setPadding(round, 0, round, 0);
            this.A05.setPageMargin(Math.round((insetDp / 2) * f2));
            this.A05.setClipToPadding(false);
        }
    }
}
