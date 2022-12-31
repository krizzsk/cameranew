package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.EnumSet;
/* renamed from: com.facebook.ads.redexgen.X.5B  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5B implements InterstitialAdApi, Repairable {
    public static byte[] A05;
    public static String[] A06 = {"S822El9zG6GuADGrtluuLX363osWhxiG", "ZFI3hp6NIHNPBZ8p7tKJKM6DxTur89gU", "rKe2xKovfMLHVnc2kJBHIfRtW7KI2joW", "CTsEdbmp9bu3ZhSS7yZH02ALmjP1FNtP", "mPYAOoIIU9PuPwOlU3lFT13mhy9mIxzC", "", "", "HqZNdyzgU2LJRhG9zHJvoyCPzWSUAGCn"};
    public boolean A00;
    public final InterstitialAd A01;
    public final C05201x A02;
    public final F3 A03;
    public final XT A04;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = copyOfRange[i5] - i4;
            if (A06[0].charAt(22) != '3') {
                throw new RuntimeException();
            }
            A06[4] = "dLq0XFJawohP2A9uDPm8W8ZKhW9iXRhW";
            copyOfRange[i5] = (byte) (i6 - 126);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-32, 17, 16, -29, -29, -30, -25, -25, -72, -74, -26, -25, -72, -23, -24, -68, 38, 36, 32, 32, 40, 33, 39, 84, -49, -12, -6, -21, -8, -12, -25, -14, -90, -21, -8, -8, -11, -8, -76, -112, -29, 8, 14, -1, 12, Draft_75.CR, 14, 3, 14, 3, -5, 6, -70, -5, -2, -70, -2, -1, Draft_75.CR, 14, 12, 9, 19, -1, -2, -56, -19, -13, -28, -15, -14, -13, -24, -13, -24, -32, -21, -97, -32, -29, -97, -21, -18, -32, -29, -97, -15, -28, -16, -12, -28, -14, -13, -28, -29, -18, 19, 25, 10, 23, 24, 25, 14, 25, 14, 6, 17, -59, 6, 9, -59, 24, Draft_75.CR, 20, 28, -59, 8, 6, 17, 17, 10, 9, -10, -9, 5, 6, 4, 1, 11, -28, -17, -52, -17, -31, -28, -63, -28, 49, 38, 45, 53};
    }

    static {
        A01();
    }

    public C5B(Context context, String str, InterstitialAd interstitialAd) {
        this.A01 = interstitialAd;
        this.A04 = AnonymousClass59.A03(context);
        this.A04.A0D().A2g(AdPlacementType.INTERSTITIAL.toString(), str);
        this.A02 = new C05201x(this.A04, interstitialAd, str);
        this.A04.A0G(this);
        this.A03 = new F3(this.A02);
    }

    public final void A02(InterstitialAdListener interstitialAdListener) {
        this.A04.A0D().A2Z(interstitialAdListener != null);
        this.A02.A0D(interstitialAdListener);
        if (A06[0].charAt(22) != '3') {
            throw new RuntimeException();
        }
        A06[4] = "rYQ6gTbtajntBm3fXVm84HcfyQ9ACN8J";
    }

    public final void A03(RewardData rewardData) {
        this.A02.A0E(rewardData);
    }

    public final void A04(RewardedAdListener rewardedAdListener) {
        this.A02.A0F(rewardedAdListener);
    }

    public final void A05(EnumSet<CacheFlag> enumSet, @Nullable String str, boolean z) {
        KI.A05(A00(129, 8, 2), A00(65, 30, 1), A00(0, 8, 49));
        if (str == null) {
            this.A04.A0D().A2d();
        } else {
            this.A04.A0D().A2c();
        }
        this.A00 = z;
        this.A03.A09(this.A01, enumSet, str);
        this.A04.A0D().A2b();
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi, com.facebook.ads.FullScreenAd
    public final InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return new C5C(this);
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi, com.facebook.ads.FullScreenAd
    public final InterstitialAd.InterstitialAdShowConfigBuilder buildShowAdConfig() {
        return new C5D();
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        KI.A05(A00(122, 7, 20), A00(40, 25, 28), A00(16, 8, 113));
        if (JD.A1S(this.A04)) {
            return;
        }
        this.A03.A05();
        this.A04.A0D().A2h();
    }

    public final void finalize() {
        this.A03.A04();
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A02.A09();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean A0A = this.A03.A0A();
        this.A04.A0D().A4W(A0A);
        return A0A;
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi
    public final boolean isAdLoaded() {
        return this.A03.A0B();
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        A05(CacheFlag.ALL, null, false);
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi
    public final void loadAd(InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig) {
        ((C5C) interstitialLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi
    public final void registerAdCompanionView(AdCompanionView adCompanionView) {
        if (this.A00 && this.A03.A07() != null) {
            this.A03.A07().A0E(adCompanionView);
        }
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        if (this.A02.A02() != null) {
            InterstitialAdListener A02 = this.A02.A02();
            InterstitialAd interstitialAd = this.A01;
            A02.onError(interstitialAd, new AdError(AdError.INTERNAL_ERROR_CODE, A00(24, 16, 8) + C0999Lp.A03(this.A04, th)));
        }
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi, com.facebook.ads.Ad
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A02.A0H(extraHints.getHints());
        this.A02.A0I(extraHints.getMediationData());
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi, com.facebook.ads.FullScreenAd
    public final boolean show() {
        KI.A05(A00(137, 4, 64), A00(95, 27, 39), A00(8, 8, 7));
        this.A04.A0D().A2m();
        boolean A0C = this.A03.A0C(this.A01, new C5D());
        this.A04.A0D().A2l(A0C);
        return A0C;
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi
    public final boolean show(InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        this.A04.A0D().A2m();
        boolean A0C = this.A03.A0C(this.A01, interstitialShowAdConfig);
        this.A04.A0D().A2l(A0C);
        return A0C;
    }

    @Override // com.facebook.ads.internal.api.InterstitialAdApi
    public final void unregisterAdCompanionView() {
        if (this.A00 && this.A03.A07() != null) {
            this.A03.A07().A0D();
        }
    }
}
