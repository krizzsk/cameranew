package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class V6 implements InterfaceC0844Fi {
    public final int A00;
    public final /* synthetic */ C0755Bk A01;

    public V6(C0755Bk c0755Bk, int i2) {
        this.A01 = c0755Bk;
        this.A00 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0844Fi
    public final boolean A8U() {
        return this.A01.A0S(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0844Fi
    public final void A9N() throws IOException {
        this.A01.A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0844Fi
    public final int ADG(AM am, WZ wz, boolean z) {
        return this.A01.A0P(this.A00, am, wz, z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0844Fi
    public final int AEg(long j2) {
        return this.A01.A0O(this.A00, j2);
    }
}
