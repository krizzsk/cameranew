package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.21  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass21 {
    public static String[] A0D = {"pQFQWrff5apwgeDCfICDjWO2FINXUEGY", "Zrlf7mbphLj9aknW7PcFFQ", "n3KJlhWP5Ju2JP4ez23sn5JFnk3TGtqs", "LKe9A2", "QZ6oU5eByjCJaazPOJhmSAWWHc", "bIzEhjdis4s2Gtu6NLj44xIWpvJeHb48", "cSwbeF06gtlZkK5ZI0p5Ev", "223A19fPLhE6SS6l"};
    public int A00 = -1;
    public long A01 = -1;
    @Nullable
    public AdExperienceType A02;
    @Nullable
    public RewardData A03;
    @Nullable
    public RewardedVideoAdListener A04;
    @Nullable
    public String A05;
    @Nullable
    public String A06;
    @Nullable
    public String A07;
    public boolean A08;
    @Nullable
    public RewardedVideoAd A09;
    public WeakReference<RewardedVideoAd> A0A;
    public final XT A0B;
    public final String A0C;

    public AnonymousClass21(XT xt, String str, @Nullable RewardedVideoAd rewardedVideoAd) {
        this.A0B = xt;
        this.A0C = str;
        this.A09 = rewardedVideoAd;
        this.A0A = new WeakReference<>(rewardedVideoAd);
    }

    public final RewardedVideoAd A00() {
        RewardedVideoAd rewardedVideoAd = this.A09;
        return rewardedVideoAd != null ? rewardedVideoAd : this.A0A.get();
    }

    public final void A01(@Nullable RewardedVideoAd rewardedVideoAd) {
        if (rewardedVideoAd == null && !JD.A0n(this.A0B)) {
            return;
        }
        this.A09 = rewardedVideoAd;
        if (A0D[4].length() != 26) {
            throw new RuntimeException();
        }
        A0D[4] = "GeKQzqug1NPR8FJ6Rbw1ueQ35y";
    }
}
