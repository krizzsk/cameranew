package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.bridge.fbsdk.FBLoginASID;
import com.facebook.ads.internal.bridge.gms.AdvertisingId;
import com.facebook.ads.internal.settings.AdInternalSettings;
/* loaded from: assets/audience_network.dex */
public final class X7 implements C8O {
    public final C8J A00;

    public X7(C8J c8j) {
        this.A00 = c8j;
    }

    @Override // com.facebook.ads.redexgen.X.C8O
    public final String A6a() {
        return C0963Kb.A02(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C8O
    @Nullable
    public final String A6b() {
        return FBLoginASID.getFBLoginASID();
    }

    @Override // com.facebook.ads.redexgen.X.C8O
    @Nullable
    public final String A6u() {
        return AdInternalSettings.getMediationService();
    }

    @Override // com.facebook.ads.redexgen.X.C8O
    @Nullable
    public final C8N A7E() {
        AdvertisingId advertisingIdInfoDirectly = AdvertisingId.getAdvertisingIdInfoDirectly(this.A00);
        if (advertisingIdInfoDirectly == null) {
            return null;
        }
        return new X8(this, advertisingIdInfoDirectly);
    }

    @Override // com.facebook.ads.redexgen.X.C8O
    @Nullable
    public final String A7e() {
        return AdInternalSettings.getUrlPrefix();
    }

    @Override // com.facebook.ads.redexgen.X.C8O
    public final String A7f() {
        return BuildConfigApi.getVersionName(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C8O
    public final boolean A8H() {
        return BuildConfigApi.isDebug();
    }
}
