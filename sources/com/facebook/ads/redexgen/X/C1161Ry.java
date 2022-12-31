package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ry  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1161Ry implements LR {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractRunnableC0981Kv A01;
    public final /* synthetic */ AbstractC1158Rv A02;

    public C1161Ry(AbstractC1158Rv abstractC1158Rv, int i2, AbstractRunnableC0981Kv abstractRunnableC0981Kv) {
        this.A02 = abstractC1158Rv;
        this.A00 = i2;
        this.A01 = abstractRunnableC0981Kv;
    }

    @Override // com.facebook.ads.redexgen.X.LR
    public final void AAB() {
        this.A01.run();
    }

    @Override // com.facebook.ads.redexgen.X.LR
    public final void ABj(float f2) {
        this.A02.A07.setProgress(100.0f * (1.0f - (f2 / this.A00)));
    }
}
