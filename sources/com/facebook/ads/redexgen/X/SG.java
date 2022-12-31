package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class SG extends QY {
    public static byte[] A01;
    public final /* synthetic */ C06999f A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 65);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-30, -15, -22, -35, -26, -15};
    }

    public SG(C06999f c06999f) {
        this.A00 = c06999f;
    }

    @Override // com.facebook.ads.redexgen.X.QY
    public final void A03() {
        C1009Lz c1009Lz;
        C1009Lz c1009Lz2;
        QZ qz;
        C1009Lz c1009Lz3;
        C1072On c1072On;
        JT jt;
        AnonymousClass16 anonymousClass16;
        XT xt;
        AnonymousClass16 anonymousClass162;
        MU mu;
        MU mu2;
        InterfaceC1031Mw interfaceC1031Mw;
        c1009Lz = this.A00.A0B;
        if (!c1009Lz.A07()) {
            c1009Lz2 = this.A00.A0B;
            c1009Lz2.A05();
            C1055Nu c1055Nu = new C1055Nu();
            qz = this.A00.A0H;
            C1055Nu A03 = c1055Nu.A03(qz);
            c1009Lz3 = this.A00.A0B;
            Map<String, String> A05 = A03.A02(c1009Lz3).A05();
            c1072On = this.A00.A0F;
            String A0O = c1072On.A0O();
            if (!TextUtils.isEmpty(A0O)) {
                String htmlHashSum = A00(0, 6, 61);
                A05.put(htmlHashSum, A0O);
            }
            jt = this.A00.A08;
            anonymousClass16 = this.A00.A06;
            String htmlHashSum2 = anonymousClass16.A0Q();
            jt.A8v(htmlHashSum2, A05);
            xt = this.A00.A07;
            xt.A0D().A2Y();
            anonymousClass162 = this.A00.A06;
            String htmlHashSum3 = anonymousClass162.A0S();
            AnonymousClass26.A00(htmlHashSum3);
            mu = this.A00.A0C;
            if (mu != null) {
                mu2 = this.A00.A0C;
                interfaceC1031Mw = this.A00.A0D;
                String htmlHashSum4 = interfaceC1031Mw.A6i();
                mu2.A3q(htmlHashSum4);
            }
        }
    }
}
