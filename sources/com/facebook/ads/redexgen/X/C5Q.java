package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5Q  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5Q implements RewardedVideoAdApi, Repairable {
    public static byte[] A05;
    public boolean A00;
    public final RewardedVideoAd A01;
    public final AnonymousClass21 A02;
    public final F2 A03;
    public final XT A04;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{116, 114, 122, 119, 115, -89, 119, -92, -93, -95, -87, -46, -92, -42, -46, -93, -126, -125, -77, 126, -125, -122, -121, 74, 75, 119, 74, 75, 74, 75, 75, 82, 119, 125, 110, 123, 119, 106, 117, 41, 110, 123, 123, 120, 123, 55, 19, -51, -32, -14, -36, -19, -33, -32, -33, -101, -15, -28, -33, -32, -22, -101, -36, -33, -101, -33, -32, -18, -17, -19, -22, -12, -32, -33, -81, -62, -44, -66, -49, -63, -62, -63, 125, -45, -58, -63, -62, -52, 125, -66, -63, 125, -55, -52, -66, -63, 125, -49, -62, -50, -46, -62, -48, -47, -62, -63, -63, -44, -26, -48, -31, -45, -44, -45, -113, -27, -40, -45, -44, -34, -113, -48, -45, -113, -30, -41, -34, -26, -113, -46, -48, -37, -37, -44, -45, -86, -85, -71, -70, -72, -75, -65, -84, -81, -95, -92, -127, -92, -43, -54, -47, -39};
    }

    public C5Q(Context context, String str, RewardedVideoAd rewardedVideoAd) {
        this.A01 = rewardedVideoAd;
        this.A04 = AnonymousClass59.A05(context);
        this.A04.A0D().A2g(AdPlacementType.REWARDED_VIDEO.toString(), str);
        this.A02 = new AnonymousClass21(this.A04, str, this.A01);
        this.A04.A0G(this);
        this.A03 = new F2(this.A02);
    }

    public final void A02(RewardData rewardData) {
        this.A03.A09(rewardData);
    }

    public final void A03(RewardedVideoAdListener rewardedVideoAdListener) {
        this.A02.A04 = rewardedVideoAdListener;
        this.A04.A0D().A2Z(rewardedVideoAdListener != null);
    }

    public final void A04(@Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z, boolean z2) {
        if (this.A02.A06 != null && C05101n.A02(this.A02.A06)) {
            this.A04.A0D().ADz();
        }
        if (str == null) {
            this.A04.A0D().A2d();
        } else {
            this.A04.A0D().A2c();
        }
        this.A00 = z2;
        this.A03.A0A(this.A01, str, adExperienceType, z);
        this.A04.A0D().A2b();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.FullScreenAd
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return new C5R(this);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.FullScreenAd
    public final RewardedVideoAd.RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return new C5S();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final void destroy() {
        KI.A05(A00(135, 7, 66), A00(47, 27, 119), A00(0, 8, 62));
        if (JD.A1S(this.A04)) {
            return;
        }
        this.A03.A05();
        this.A04.A0D().A2h();
    }

    public final void finalize() {
        this.A03.A04();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A02.A0C;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final int getVideoDuration() {
        return this.A02.A00;
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean A0B = this.A03.A0B();
        this.A04.A0D().A4W(A0B);
        return A0B;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean isAdLoaded() {
        return this.A03.A0C();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final void loadAd() {
        KI.A05(A00(142, 6, 60), A00(74, 32, 89), A00(23, 8, 17));
        A04(null, null, true, false);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void loadAd(RewardedVideoAd.RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        ((C5R) rewardedVideoLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void registerAdCompanionView(AdCompanionView adCompanionView) {
        if (this.A00 && this.A03.A07() != null) {
            this.A03.A07().A0H(adCompanionView);
        }
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        if (this.A02.A04 != null) {
            RewardedVideoAdListener rewardedVideoAdListener = this.A02.A04;
            RewardedVideoAd rewardedVideoAd = this.A01;
            rewardedVideoAdListener.onError(rewardedVideoAd, new AdError(AdError.INTERNAL_ERROR_CODE, A00(31, 16, 5) + C0999Lp.A03(this.A02.A0B, th)));
        }
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A02.A06 = extraHints.getHints();
        this.A02.A07 = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.FullScreenAd
    public final boolean show() {
        KI.A05(A00(148, 4, 94), A00(106, 29, 107), A00(16, 7, 74));
        this.A04.A0D().A2m();
        boolean A0D = this.A03.A0D(this.A01, new C5S().withAppOrientation(-1).build());
        this.A04.A0D().A2l(A0D);
        return A0D;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean show(RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        KI.A05(A00(148, 4, 94), A00(106, 29, 107), A00(8, 8, 108));
        this.A04.A0D().A2m();
        boolean A0D = this.A03.A0D(this.A01, rewardedVideoShowAdConfig);
        this.A04.A0D().A2l(A0D);
        return A0D;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void unregisterAdCompanionView() {
        if (this.A00 && this.A03.A07() != null) {
            this.A03.A07().A0F();
        }
    }
}
