package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public class SW implements InterfaceC1054Nt {
    public final WeakReference<C07159v> A00;

    public SW(C07159v c07159v) {
        this.A00 = new WeakReference<>(c07159v);
    }

    public /* synthetic */ SW(C07159v c07159v, A0 a0) {
        this(c07159v);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1054Nt
    public final void AAi(boolean z) {
        C07159v c07159v = this.A00.get();
        if (c07159v != null) {
            c07159v.A04 = z;
            c07159v.A02();
        }
    }
}
