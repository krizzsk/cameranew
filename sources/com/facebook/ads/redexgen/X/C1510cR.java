package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
/* renamed from: com.facebook.ads.redexgen.X.cR  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1510cR extends AbstractRunnableC0981Kv {
    public final /* synthetic */ C1545d0 A00;
    public final /* synthetic */ C05121p A01;
    public final /* synthetic */ F7 A02;

    public C1510cR(F7 f7, C05121p c05121p, C1545d0 c1545d0) {
        this.A02 = f7;
        this.A01 = c05121p;
        this.A00 = c1545d0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        this.A02.A0N(this.A01);
        this.A02.A0K(this.A00);
        this.A02.A00 = null;
        K3 A00 = K3.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0D().A4X(A00.A03().getErrorCode(), A00.A04());
        this.A02.A06.A0G(A00);
    }
}
