package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class RW implements AnonymousClass50 {
    public final /* synthetic */ AnonymousClass52 A00;
    public final /* synthetic */ AnonymousClass84 A01;

    public RW(AnonymousClass84 anonymousClass84, AnonymousClass52 anonymousClass52) {
        this.A01 = anonymousClass84;
        this.A00 = anonymousClass52;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final boolean A8E() {
        boolean A0Y;
        boolean A0Z;
        if (!this.A01.A0X()) {
            A0Y = this.A01.A0Y();
            if (A0Y) {
                return true;
            }
            A0Z = this.A01.A0Z();
            return A0Z;
        }
        this.A01.A0W(this.A00);
        return true;
    }
}
