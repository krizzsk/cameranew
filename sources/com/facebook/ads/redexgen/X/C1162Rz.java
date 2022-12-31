package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
/* renamed from: com.facebook.ads.redexgen.X.Rz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1162Rz extends QY {
    public final /* synthetic */ AbstractC1158Rv A00;

    public C1162Rz(AbstractC1158Rv abstractC1158Rv) {
        this.A00 = abstractC1158Rv;
    }

    @Override // com.facebook.ads.redexgen.X.QY
    public final void A03() {
        if (!this.A00.A06.A07()) {
            this.A00.A06.A05();
            if (!TextUtils.isEmpty(this.A00.A01.A0Q())) {
                this.A00.A04.A8v(this.A00.A01.A0Q(), new C1055Nu().A03(this.A00.A0A).A02(this.A00.A06).A04(this.A00.A01.A0T()).A05());
                this.A00.A03.A0D().A2Y();
                AnonymousClass26.A00(this.A00.A01.A0S());
                this.A00.A08.A3q(this.A00.A09.A6i());
            }
        }
    }
}
