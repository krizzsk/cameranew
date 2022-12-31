package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.Tv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1210Tv implements InterfaceC0946Jk {
    public WeakReference<C1198Tj> A00;

    public C1210Tv(C1198Tj c1198Tj) {
        this.A00 = new WeakReference<>(c1198Tj);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0946Jk
    public final void ABV(boolean z) {
        if (this.A00.get() != null) {
            this.A00.get().A1a(z, false);
        }
    }
}
