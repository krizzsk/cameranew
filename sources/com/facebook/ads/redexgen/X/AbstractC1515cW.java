package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.cW  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1515cW implements C7B {
    public final boolean A00;

    public abstract void A00();

    public abstract void A01(boolean z);

    public AbstractC1515cW(boolean z) {
        this.A00 = z;
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AA5() {
        if (this.A00) {
            A00();
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AAC() {
        A01(true);
    }
}
