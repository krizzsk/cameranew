package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.ct  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1538ct implements InterfaceC05061j {
    public final /* synthetic */ FB A00;

    public C1538ct(FB fb) {
        this.A00 = fb;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05061j
    public final void ABX(AdError adError) {
        AnonymousClass12 anonymousClass12;
        anonymousClass12 = this.A00.A01;
        anonymousClass12.AC0(this.A00, adError);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05061j
    public final void ABY() {
        AtomicBoolean atomicBoolean;
        AnonymousClass12 anonymousClass12;
        atomicBoolean = this.A00.A0D;
        atomicBoolean.set(true);
        anonymousClass12 = this.A00.A01;
        anonymousClass12.ABx(this.A00);
    }
}
