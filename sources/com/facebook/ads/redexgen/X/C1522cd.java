package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
/* renamed from: com.facebook.ads.redexgen.X.cd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1522cd implements C5U {
    public final /* synthetic */ C04981b A00;
    public final /* synthetic */ XT A01;
    public final /* synthetic */ boolean A02;

    public C1522cd(C04981b c04981b, XT xt, boolean z) {
        this.A00 = c04981b;
        this.A01 = xt;
        this.A02 = z;
    }

    @Override // com.facebook.ads.redexgen.X.C5U
    public final void A9p() {
        InterfaceC04971a interfaceC04971a;
        C1528cj c1528cj;
        if (!JD.A17(this.A01) || !this.A02) {
            interfaceC04971a = this.A00.A04;
            interfaceC04971a.A9j();
            return;
        }
        C04981b c04981b = this.A00;
        XT xt = this.A01;
        c1528cj = c04981b.A03;
        c04981b.A02 = C1073Oo.A01(xt, c1528cj, 1, new C1523ce(this));
    }

    @Override // com.facebook.ads.redexgen.X.C5U
    public final void A9q() {
        InterfaceC04971a interfaceC04971a;
        interfaceC04971a = this.A00.A04;
        interfaceC04971a.A9i(AdError.CACHE_ERROR);
    }
}
