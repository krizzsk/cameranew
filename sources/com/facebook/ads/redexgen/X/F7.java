package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class F7 extends AbstractC1511cS {
    public F7(XT xt, C05111o c05111o) {
        super(xt, c05111o);
    }

    private InterfaceC04940x A00(Runnable runnable) {
        return new C1509cQ(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1511cS
    public final void A0J() {
        ((C1545d0) this.A01).A0B();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1511cS
    public final void A0L(InterfaceC04840n interfaceC04840n, AnonymousClass94 anonymousClass94, AnonymousClass92 anonymousClass92, C05121p c05121p) {
        C1545d0 c1545d0 = (C1545d0) interfaceC04840n;
        C1510cR c1510cR = new C1510cR(this, c05121p, c1545d0);
        A0C().postDelayed(c1510cR, anonymousClass94.A05().A05());
        c1545d0.A0A(this.A0B, A00(c1510cR), c05121p, this.A07.A09, this.A07.A03, this.A07.A04, this.A07.A01);
    }

    public final AnonymousClass16 A0T() {
        return ((C1545d0) this.A01).A09();
    }
}
