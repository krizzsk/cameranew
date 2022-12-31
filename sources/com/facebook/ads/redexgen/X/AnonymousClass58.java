package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
/* renamed from: com.facebook.ads.redexgen.X.58  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass58 implements BidderTokenProviderApi {
    public final C06215w A00 = new C06215w();

    public final C06215w A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.BidderTokenProviderApi
    public final String getBidderToken(Context context) {
        return this.A00.A06(AnonymousClass59.A07(context));
    }
}
