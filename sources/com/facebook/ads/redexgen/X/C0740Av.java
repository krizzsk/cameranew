package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
/* renamed from: com.facebook.ads.redexgen.X.Av  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0740Av implements InterfaceC1197Ti {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C0740Av(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0943Jh
    public final void A9h() {
        C0973Km.A00(new C1193Te(this));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0943Jh
    public final void A9k() {
        C0973Km.A00(new C1194Tf(this));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0943Jh
    public final void AAW(K3 k3) {
        C0973Km.A00(new C1196Th(this, k3));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0943Jh
    public final void AB9() {
        C0973Km.A00(new C1192Td(this));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1197Ti
    public final void ABE() {
        C0973Km.A00(new C1195Tg(this));
    }
}
