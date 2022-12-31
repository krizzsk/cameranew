package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.Sf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1168Sf extends AbstractRunnableC0981Kv {
    public final WeakReference<QZ> A00;

    public C1168Sf(QZ qz) {
        this.A00 = new WeakReference<>(qz);
    }

    public C1168Sf(WeakReference<QZ> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        QZ qz = this.A00.get();
        if (qz != null) {
            qz.A0U();
        }
    }
}
