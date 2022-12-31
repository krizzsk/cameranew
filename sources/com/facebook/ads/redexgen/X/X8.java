package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.bridge.gms.AdvertisingId;
/* loaded from: assets/audience_network.dex */
public class X8 implements C8N {
    public final /* synthetic */ AdvertisingId A00;
    public final /* synthetic */ X7 A01;

    public X8(X7 x7, AdvertisingId advertisingId) {
        this.A01 = x7;
        this.A00 = advertisingId;
    }

    @Override // com.facebook.ads.redexgen.X.C8N
    public final boolean A8Q() {
        return this.A00.isLimitAdTracking();
    }

    @Override // com.facebook.ads.redexgen.X.C8N
    public final String getId() {
        return this.A00.getId();
    }
}
