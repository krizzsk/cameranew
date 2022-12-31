package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
/* loaded from: assets/audience_network.dex */
public final class F2 extends AbstractC1500cG {
    @Nullable
    public C1493c8 A00;
    public final AnonymousClass21 A01;

    public F2(AnonymousClass21 anonymousClass21) {
        super(anonymousClass21.A0B, A00(anonymousClass21));
        this.A01 = anonymousClass21;
    }

    public static AnonymousClass20 A00(AnonymousClass21 anonymousClass21) {
        return new C1491c3(anonymousClass21);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1500cG
    public final void A05() {
        C1493c8 c1493c8 = this.A00;
        if (c1493c8 != null) {
            c1493c8.A0E();
        }
        super.A00.AEJ(EnumC05161t.A04);
    }

    @Nullable
    public final C1493c8 A07() {
        return this.A00;
    }

    public final void A08() {
        this.A00 = new C1493c8(this.A01, this, this.A02);
        this.A00.A0I(this.A01.A05, this.A01.A02, this.A01.A08);
    }

    public final void A09(RewardData rewardData) {
        this.A01.A03 = rewardData;
        C1493c8 c1493c8 = this.A00;
        if (c1493c8 != null) {
            c1493c8.A0G(rewardData);
        }
    }

    public final void A0A(RewardedVideoAd rewardedVideoAd, @Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        if (super.A00.A5H()) {
            return;
        }
        this.A01.A01(rewardedVideoAd);
        C1493c8 c1493c8 = this.A00;
        if (c1493c8 != null) {
            c1493c8.A0I(str, adExperienceType, z);
            return;
        }
        AnonymousClass21 anonymousClass21 = this.A01;
        anonymousClass21.A05 = str;
        anonymousClass21.A02 = adExperienceType;
        anonymousClass21.A08 = z;
        A08();
    }

    public final boolean A0B() {
        C1493c8 c1493c8 = this.A00;
        if (c1493c8 != null) {
            return c1493c8.A0J();
        }
        return this.A01.A01 > 0 && C1008Ly.A00() > this.A01.A01;
    }

    public final boolean A0C() {
        C1493c8 c1493c8 = this.A00;
        if (c1493c8 != null) {
            return c1493c8.A0K();
        }
        return super.A00.A5a() == EnumC05161t.A06;
    }

    public final boolean A0D(RewardedVideoAd rewardedVideoAd, RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        int A00 = ((C5S) rewardedVideoShowAdConfig).A00();
        if (super.A00.A5I()) {
            return false;
        }
        this.A01.A01(rewardedVideoAd);
        C1493c8 c1493c8 = this.A00;
        if (c1493c8 != null) {
            return c1493c8.A0L(A00);
        }
        this.A00 = new C1493c8(this.A01, this, this.A02);
        this.A00.A0L(A00);
        return false;
    }
}
