package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class T5 implements LR {
    public final /* synthetic */ int A00;
    public final /* synthetic */ T4 A01;

    public T5(T4 t4, int i2) {
        this.A01 = t4;
        this.A00 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.LR
    public final void AAB() {
        this.A01.A03 = false;
        this.A01.A0S();
        this.A01.A0C.setToolbarActionMode(this.A01.getCloseButtonStyle());
    }

    @Override // com.facebook.ads.redexgen.X.LR
    public final void ABj(float f2) {
        this.A01.A0C.setProgress(100.0f * (1.0f - (f2 / this.A00)));
    }
}
