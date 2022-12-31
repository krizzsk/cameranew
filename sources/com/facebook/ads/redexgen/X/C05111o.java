package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.AdSettings;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;
/* renamed from: com.facebook.ads.redexgen.X.1o  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05111o {
    public static String[] A0C = {"erlsxJKV5RGKo0fyhsjft4C8myFkBTFD", "xxCOSS58nTJL4g358MAx2boWparhVsnt", "50HA7KO7TX73z1", "kwTSvTyvqMkAeNvnsZNufhK8xoNKpC5A", "CvvJJ5wn5WoPjh", "PJeUG8MSArG13FCqdbuWaTyquTMQa3YW", "KbVXHt7uQSAfPtAdYM2eE220TAgmiqZ3", "QWgxf2msfb1fWKXeTjGnwNJbVHOPLzwf"};
    public int A00;
    @Nullable
    public RewardData A01;
    @Nullable
    public EnumC0947Jl A02;
    @Nullable
    public String A03;
    @Nullable
    public String A04;
    public boolean A05;
    public final K8 A06;
    public final K9 A07;
    public final String A08;
    @Nullable
    public final EnumSet<CacheFlag> A09;
    public final int A0A;
    public final AdPlacementType A0B;

    public C05111o(String str, K9 k9, AdPlacementType adPlacementType, K8 k8, int i2) {
        this(str, k9, adPlacementType, k8, i2, EnumSet.of(CacheFlag.NONE));
    }

    public C05111o(String str, K9 k9, AdPlacementType adPlacementType, K8 k8, int i2, @Nullable EnumSet<CacheFlag> enumSet) {
        this.A08 = str;
        this.A0B = adPlacementType;
        this.A06 = k8;
        this.A0A = i2;
        this.A09 = enumSet;
        this.A07 = k9;
        this.A00 = -1;
    }

    public final AdPlacementType A00() {
        AdPlacementType adPlacementType = this.A0B;
        if (adPlacementType != null) {
            return adPlacementType;
        }
        K8 k8 = this.A06;
        if (k8 == null) {
            return AdPlacementType.NATIVE;
        }
        if (k8 == K8.A07) {
            return AdPlacementType.INTERSTITIAL;
        }
        return AdPlacementType.BANNER;
    }

    public final KU A01(XT xt, KE ke, @Nullable AdExperienceType adExperienceType) {
        C0993Lj c0993Lj;
        String str;
        String str2 = this.A08;
        K8 k8 = this.A06;
        if (k8 != null) {
            c0993Lj = new C0993Lj(k8.A02(), this.A06.A03());
        } else {
            c0993Lj = null;
        }
        K9 k9 = this.A07;
        if (AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT) {
            str = AdSettings.getTestAdType().getAdTypeString();
        } else {
            str = null;
        }
        KU ku = new KU(xt, str2, c0993Lj, k9, str, this.A0A, AdSettings.isTestMode(xt), AdSettings.isMixedAudience(), ke, C0999Lp.A01(JD.A0H(xt)), this.A03, adExperienceType != null ? adExperienceType.getAdExperienceType() : null);
        String[] strArr = A0C;
        if (strArr[2].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[0] = "1YKhexqCB6oyofjWexJTrFb8PReFz0lW";
        strArr2[3] = "PDYLpd11u8hpbIrKg4rw9QV8MRNrtAlX";
        return ku;
    }

    public final void A02(int i2) {
        this.A00 = i2;
    }

    public final void A03(@Nullable RewardData rewardData) {
        this.A01 = rewardData;
    }

    public final void A04(@Nullable EnumC0947Jl enumC0947Jl) {
        this.A02 = enumC0947Jl;
    }

    public final void A05(@Nullable String str) {
        this.A03 = str;
    }

    public final void A06(@Nullable String str) {
        this.A04 = str;
    }

    public final void A07(boolean z) {
        this.A05 = z;
    }
}
