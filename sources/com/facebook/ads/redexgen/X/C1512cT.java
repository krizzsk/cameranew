package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.cT  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1512cT extends AbstractRunnableC0981Kv {
    public final /* synthetic */ AbstractC1511cS A00;
    public final /* synthetic */ K3 A01;

    public C1512cT(AbstractC1511cS abstractC1511cS, K3 k3) {
        this.A00 = abstractC1511cS;
        this.A01 = k3;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        this.A00.A0B.A0D().A4X(this.A01.A03().getErrorCode(), this.A01.A04());
        this.A00.A06.A0G(this.A01);
    }
}
