package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class OT extends C9P<C06667t> {
    public final /* synthetic */ C7x A00;

    public OT(C7x c7x) {
        this.A00 = c7x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A00 */
    public final void A03(C06667t c06667t) {
        C1099Po c1099Po;
        C1099Po c1099Po2;
        int A00 = c06667t.A00();
        if (this.A00.A00 > 0) {
            c1099Po = this.A00.A0B;
            if (A00 == c1099Po.getDuration()) {
                c1099Po2 = this.A00.A0B;
                if (c1099Po2.getDuration() > this.A00.A00) {
                    return;
                }
            }
        }
        this.A00.A0c(A00);
    }

    @Override // com.facebook.ads.redexgen.X.C9P
    public final Class<C06667t> A01() {
        return C06667t.class;
    }
}
