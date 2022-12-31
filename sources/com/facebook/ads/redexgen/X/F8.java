package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class F8 extends AbstractC1511cS {
    @Nullable
    public View A00;
    public C0803Dr A01;

    public F8(C0803Dr c0803Dr, C05111o c05111o) {
        super(c0803Dr, c05111o);
        this.A01 = c0803Dr;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1511cS
    public final void A0J() {
        if (this.A00 != null) {
            this.A01.A0D().A3l();
            this.A06.A0E(this.A00);
            return;
        }
        this.A01.A0D().A3m();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1511cS
    public final void A0L(InterfaceC04840n interfaceC04840n, AnonymousClass94 anonymousClass94, AnonymousClass92 anonymousClass92, C05121p c05121p) {
        this.A01.A0D().A3f();
        C1546d1 c1546d1 = (C1546d1) interfaceC04840n;
        C1514cV c1514cV = new C1514cV(this, c05121p, c1546d1);
        A0C().postDelayed(c1514cV, anonymousClass94.A05().A05());
        c1546d1.A0C(this.A01, this.A08, this.A07.A06, new C1513cU(this, c1514cV), c05121p);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1511cS
    public final void A0O(String str) {
        this.A01.A0D().A3k(str != null);
        super.A0O(str);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1511cS
    public final void A0R(boolean z) {
        super.A0R(z);
        this.A00 = null;
    }
}
