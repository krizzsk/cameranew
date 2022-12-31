package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class RY extends QY {
    public final /* synthetic */ AnonymousClass84 A00;

    public RY(AnonymousClass84 anonymousClass84) {
        this.A00 = anonymousClass84;
    }

    @Override // com.facebook.ads.redexgen.X.QY
    public final void A03() {
        C1009Lz c1009Lz;
        C1009Lz c1009Lz2;
        String str;
        QZ qz;
        C1009Lz c1009Lz3;
        C1528cj c1528cj;
        JT jt;
        String str2;
        XT xt;
        C1528cj c1528cj2;
        c1009Lz = this.A00.A0D;
        if (!c1009Lz.A07()) {
            AnonymousClass84 anonymousClass84 = this.A00;
            c1009Lz2 = anonymousClass84.A0D;
            anonymousClass84.setImpressionRecordingFlag(c1009Lz2);
            str = this.A00.A0A;
            if (!TextUtils.isEmpty(str)) {
                C1055Nu c1055Nu = new C1055Nu();
                qz = this.A00.A09;
                C1055Nu A03 = c1055Nu.A03(qz);
                c1009Lz3 = this.A00.A0D;
                C1055Nu A02 = A03.A02(c1009Lz3);
                c1528cj = ((T4) this.A00).A08;
                Map<String, String> A05 = A02.A04(c1528cj.A0T()).A05();
                jt = ((T4) this.A00).A0A;
                str2 = this.A00.A0A;
                jt.A8v(str2, A05);
                xt = this.A00.A0C;
                xt.A0D().A2Y();
                c1528cj2 = this.A00.A03;
                AnonymousClass26.A00(c1528cj2.A0S());
            }
        }
    }
}
