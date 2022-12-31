package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public class SI implements InterfaceC1054Nt {
    public final WeakReference<AbstractC07069m> A00;

    public SI(AbstractC07069m abstractC07069m) {
        this.A00 = new WeakReference<>(abstractC07069m);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1054Nt
    public final void AAi(boolean z) {
        AbstractC07069m abstractC07069m = this.A00.get();
        if (abstractC07069m != null) {
            abstractC07069m.A06 = z;
            abstractC07069m.A01();
        }
    }
}
