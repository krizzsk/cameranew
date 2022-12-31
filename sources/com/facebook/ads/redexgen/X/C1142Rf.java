package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Rf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1142Rf extends QY {
    public final /* synthetic */ AnonymousClass85 A00;

    public C1142Rf(AnonymousClass85 anonymousClass85) {
        this.A00 = anonymousClass85;
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
        c1009Lz = this.A00.A0H;
        if (!c1009Lz.A07()) {
            AnonymousClass85 anonymousClass85 = this.A00;
            c1009Lz2 = anonymousClass85.A0H;
            anonymousClass85.setImpressionRecordingFlag(c1009Lz2);
            str = this.A00.A0C;
            if (!TextUtils.isEmpty(str)) {
                C1055Nu c1055Nu = new C1055Nu();
                qz = this.A00.A0B;
                C1055Nu A03 = c1055Nu.A03(qz);
                c1009Lz3 = this.A00.A0H;
                C1055Nu A02 = A03.A02(c1009Lz3);
                c1528cj = ((T4) this.A00).A08;
                Map<String, String> A05 = A02.A04(c1528cj.A0T()).A05();
                jt = ((T4) this.A00).A0A;
                str2 = this.A00.A0C;
                jt.A8v(str2, A05);
                xt = this.A00.A0G;
                xt.A0D().A2Y();
                c1528cj2 = this.A00.A04;
                AnonymousClass26.A00(c1528cj2.A0S());
            }
        }
    }
}
