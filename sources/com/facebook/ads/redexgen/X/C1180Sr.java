package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Sr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1180Sr implements N3 {
    public static byte[] A01;
    public static String[] A02 = {"nV", "0i4Wqrqqd8V", "SjjlSsHq4luZ", "UY2G1G5tdkkQRCLDawUW8PMELrtkam", "x8YzSsjyce", "sMLSYBAewXVAxhh2DbXf8YHA5QSbjC", "Z41BjwW", "WlPnbv1jMaDivlCQdRIz8mOz1GWjjHLQ"};
    public final /* synthetic */ N1 A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-29, -17, -19, -82, -26, -31, -29, -27, -30, -17, -17, -21, -82, -31, -28, -13, -82, -31, -28, -14, -27, -16, -17, -14, -12, -23, -18, -25, -82, -58, -55, -50, -55, -45, -56, -33, -63, -60, -33, -46, -59, -48, -49, -46, -44, -55, -50, -57, -33, -58, -52, -49, -41};
        String[] strArr = A02;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        A02[7] = "41BFLxMtpa8zSeOoPh8lyezFWRN0z1Os";
    }

    static {
        A01();
    }

    public C1180Sr(N1 n1) {
        this.A00 = n1;
    }

    @Override // com.facebook.ads.redexgen.X.N3
    public final void A40() {
        MU mu;
        MU mu2;
        mu = this.A00.A06;
        if (mu != null) {
            mu2 = this.A00.A06;
            mu2.A3q(A00(0, 53, 17));
        }
    }

    @Override // com.facebook.ads.redexgen.X.N3
    public final void A41() {
        MV mv;
        MV mv2;
        this.A00.A0L();
        mv = this.A00.A07;
        if (mv != null) {
            mv2 = this.A00.A07;
            mv2.ABt(true);
        }
        this.A00.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.N3
    public final void A7k() {
        C2D c2d;
        C2D c2d2;
        C2D c2d3;
        XT xt;
        c2d = this.A00.A03;
        if (c2d == null) {
            A41();
            return;
        }
        N1.A01(this.A00);
        c2d2 = this.A00.A03;
        if (c2d2.A02() == null) {
            N1 n1 = this.A00;
            if (A02[6].length() != 7) {
                throw new RuntimeException();
            }
            A02[7] = "M7aB9yPR9altU9X1FYnvgfaKEANBwcUB";
            n1.A0B();
        } else {
            N1 n12 = this.A00;
            c2d3 = n12.A03;
            n12.A0D(c2d3.A02());
        }
        if (Build.VERSION.SDK_INT >= 16) {
            xt = this.A00.A04;
            if (JD.A1a(xt)) {
                this.A00.performAccessibilityAction(128, null);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.N3
    public final void A8b() {
        XT xt;
        C2C c2c;
        XT xt2;
        XT xt3;
        String str;
        xt = this.A00.A04;
        if (!TextUtils.isEmpty(C2A.A0C(xt.A00()))) {
            LI li = new LI();
            xt2 = this.A00.A04;
            xt3 = this.A00.A04;
            Uri parse = Uri.parse(C2A.A0C(xt3.A00()));
            str = this.A00.A08;
            LI.A08(li, xt2, parse, str);
        }
        c2c = this.A00.A02;
        c2c.A04();
    }

    @Override // com.facebook.ads.redexgen.X.N3
    public final void A8c() {
        MV mv;
        XT xt;
        C2C c2c;
        XT xt2;
        XT xt3;
        String str;
        MV mv2;
        this.A00.A0L();
        mv = this.A00.A07;
        if (mv != null) {
            mv2 = this.A00.A07;
            mv2.ABt(true);
        }
        xt = this.A00.A04;
        if (!TextUtils.isEmpty(C2A.A06(xt.A00()))) {
            LI li = new LI();
            xt2 = this.A00.A04;
            xt3 = this.A00.A04;
            Uri parse = Uri.parse(C2A.A06(xt3.A00()));
            str = this.A00.A08;
            LI.A08(li, xt2, parse, str);
        }
        c2c = this.A00.A02;
        c2c.A06();
        this.A00.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.N3
    public final void ABH(C2B c2b) {
        C2B c2b2;
        XT xt;
        C2D A04;
        XT xt2;
        N1.A00(this.A00);
        this.A00.A01 = c2b;
        c2b2 = this.A00.A01;
        if (c2b2 == C2B.A03) {
            xt2 = this.A00.A04;
            A04 = C2A.A03(xt2.A00());
        } else {
            xt = this.A00.A04;
            A04 = C2A.A04(xt.A00());
        }
        this.A00.A0D(A04);
    }

    @Override // com.facebook.ads.redexgen.X.N3
    public final void ABQ(C2D c2d) {
        C2C c2c;
        N1.A00(this.A00);
        c2c = this.A00.A02;
        c2c.A07(c2d.A01());
        if (!c2d.A05().isEmpty()) {
            this.A00.A0D(c2d);
        } else {
            this.A00.A0C(c2d);
        }
    }
}
