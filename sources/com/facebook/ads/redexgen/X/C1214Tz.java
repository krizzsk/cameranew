package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
/* renamed from: com.facebook.ads.redexgen.X.Tz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1214Tz implements InterfaceC0948Jm {
    public final /* synthetic */ MediaViewVideoRendererApi A00;
    public final /* synthetic */ C1209Tu A01;

    public C1214Tz(C1209Tu c1209Tu, MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        this.A01 = c1209Tu;
        this.A00 = mediaViewVideoRendererApi;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0948Jm
    public final void AEO() {
        this.A00.setVolume(1.0f);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0948Jm
    public final void AER(NativeAd nativeAd) {
        this.A01.A0I(C1198Tj.A0J(nativeAd.getInternalNativeAd()), new C1210Tv(C1198Tj.A0J(nativeAd.getInternalNativeAd())));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0948Jm
    public final void AF6() {
        this.A01.A0D();
    }
}
