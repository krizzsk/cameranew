package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.ba  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1465ba implements InterfaceC05854l {
    public final /* synthetic */ C0828Eq A00;

    public C1465ba(C0828Eq c0828Eq) {
        this.A00 = c0828Eq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05854l
    public final void AD3(AbstractC05784e abstractC05784e, C4H c4h, C4H c4h2) {
        this.A00.A1n(abstractC05784e, c4h, c4h2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05854l
    public final void AD5(AbstractC05784e abstractC05784e, @NonNull C4H c4h, @Nullable C4H c4h2) {
        this.A00.A0r.A0c(abstractC05784e);
        this.A00.A1o(abstractC05784e, c4h, c4h2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05854l
    public final void AD7(AbstractC05784e abstractC05784e, @NonNull C4H c4h, @NonNull C4H c4h2) {
        abstractC05784e.A0Z(false);
        if (this.A00.A0C) {
            if (this.A00.A05.A0H(abstractC05784e, abstractC05784e, c4h, c4h2)) {
                this.A00.A1N();
            }
        } else if (!this.A00.A05.A0G(abstractC05784e, c4h, c4h2)) {
        } else {
            this.A00.A1N();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05854l
    public final void AF7(AbstractC05784e abstractC05784e) {
        this.A00.A06.A1D(abstractC05784e.A0H, this.A00.A0r);
    }
}
