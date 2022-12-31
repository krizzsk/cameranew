package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class FC extends AbstractC1515cW {
    public final /* synthetic */ FB A00;
    public final /* synthetic */ AbstractC1533co A01;
    public final /* synthetic */ C1524cf A02;
    public final /* synthetic */ boolean A03;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FC(FB fb, boolean z, boolean z2, C1524cf c1524cf, AbstractC1533co abstractC1533co) {
        super(z);
        this.A00 = fb;
        this.A03 = z2;
        this.A02 = c1524cf;
        this.A01 = abstractC1533co;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1515cW
    public final void A00() {
        AnonymousClass12 anonymousClass12;
        anonymousClass12 = this.A00.A01;
        anonymousClass12.AC0(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1515cW
    public final void A01(boolean z) {
        XT xt;
        AtomicBoolean atomicBoolean;
        AnonymousClass12 anonymousClass12;
        XT xt2;
        xt = this.A00.A04;
        if (!JD.A19(xt) || !this.A03) {
            atomicBoolean = this.A00.A0D;
            atomicBoolean.set(true);
            anonymousClass12 = this.A00.A01;
            anonymousClass12.ABx(this.A01);
            return;
        }
        FB fb = this.A00;
        xt2 = fb.A04;
        fb.A07 = C1073Oo.A01(xt2, this.A02, 0, new C1540cv(this));
    }
}
