package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.bY  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1463bY implements InterfaceC05543g {
    public final /* synthetic */ C0828Eq A00;

    public C1463bY(C0828Eq c0828Eq) {
        this.A00 = c0828Eq;
    }

    private final void A00(C05553h c05553h) {
        int i2 = c05553h.A00;
        if (i2 == 1) {
            this.A00.A06.A1Q(this.A00, c05553h.A02, c05553h.A01);
        } else if (i2 == 2) {
            this.A00.A06.A1R(this.A00, c05553h.A02, c05553h.A01);
        } else if (i2 == 4) {
            this.A00.A06.A1T(this.A00, c05553h.A02, c05553h.A01, c05553h.A03);
        } else if (i2 != 8) {
        } else {
            this.A00.A06.A1S(this.A00, c05553h.A02, c05553h.A01, 1);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05543g
    public final AbstractC05784e A5N(int i2) {
        AbstractC05784e A1G = this.A00.A1G(i2, true);
        if (A1G == null || this.A00.A01.A0K(A1G.A0H)) {
            return null;
        }
        return A1G;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05543g
    public final void A9K(int i2, int i3, Object obj) {
        this.A00.A1f(i2, i3, obj);
        this.A00.A0H = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05543g
    public final void A9d(int i2, int i3) {
        this.A00.A1c(i2, i3);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05543g
    public final void A9e(int i2, int i3) {
        this.A00.A1d(i2, i3);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05543g
    public final void A9f(int i2, int i3) {
        this.A00.A1g(i2, i3, true);
        C0828Eq c0828Eq = this.A00;
        c0828Eq.A0G = true;
        c0828Eq.A0s.A00 += i3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05543g
    public final void A9g(int i2, int i3) {
        this.A00.A1g(i2, i3, false);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05543g
    public final void AAJ(C05553h c05553h) {
        A00(c05553h);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05543g
    public final void AAL(C05553h c05553h) {
        A00(c05553h);
    }
}
