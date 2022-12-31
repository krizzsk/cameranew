package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
/* renamed from: com.facebook.ads.redexgen.X.ca  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1519ca implements InterfaceC05061j {
    public final /* synthetic */ C04981b A00;

    public C1519ca(C04981b c04981b) {
        this.A00 = c04981b;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05061j
    public final void ABX(AdError adError) {
        InterfaceC04971a interfaceC04971a;
        interfaceC04971a = this.A00.A04;
        interfaceC04971a.A9i(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05061j
    public final void ABY() {
        InterfaceC04971a interfaceC04971a;
        interfaceC04971a = this.A00.A04;
        interfaceC04971a.A9j();
    }
}
