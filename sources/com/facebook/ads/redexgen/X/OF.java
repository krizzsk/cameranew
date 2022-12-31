package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class OF extends C9P<C06687v> {
    public final /* synthetic */ C7x A00;

    public OF(C7x c7x) {
        this.A00 = c7x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A00 */
    public final void A03(C06687v c06687v) {
        int A00 = c06687v.A00();
        int A01 = c06687v.A01();
        if (this.A00.A00 > 0 && A00 == A01 && A01 > this.A00.A00) {
            return;
        }
        if (A01 < A00 + 500) {
            if (A01 == 0) {
                C7x c7x = this.A00;
                c7x.A0d(c7x.A00);
                return;
            }
            this.A00.A0d(A01);
            return;
        }
        this.A00.A0d(A00);
    }

    @Override // com.facebook.ads.redexgen.X.C9P
    public final Class<C06687v> A01() {
        return C06687v.class;
    }
}
