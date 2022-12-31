package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
/* renamed from: com.facebook.ads.redexgen.X.cL  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1504cL extends AbstractRunnableC0981Kv {
    public final /* synthetic */ FB A00;
    public final /* synthetic */ C05121p A01;
    public final /* synthetic */ F4 A02;

    public C1504cL(F4 f4, C05121p c05121p, FB fb) {
        this.A02 = f4;
        this.A01 = c05121p;
        this.A00 = fb;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        this.A02.A0N(this.A01);
        this.A02.A0K(this.A00);
        this.A02.A00 = null;
        AdErrorType adErrorType = AdErrorType.RV_AD_TIMEOUT;
        this.A02.A0B.A0D().A4X(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
        this.A02.A06.A0G(new K3(adErrorType, ""));
    }
}
