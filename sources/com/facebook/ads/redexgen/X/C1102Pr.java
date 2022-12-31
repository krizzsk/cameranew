package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.Pr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1102Pr extends AbstractRunnableC0981Kv {
    public static String[] A04 = {"pUIboC8CwdUMtM1tPR8iEtPz8p", "ladzvmq", "gZiIZXhhpFNWaRiPv", "vQtAVDGFp8M", "7j30UYRlUEXcM4Kd2wK", "XchzO9Mtzl1GyvdPdWlZd1J0iwZmFx3H", "VTwPVxpRcW0", "YPnzN72MuP4y3lnuBhqZ0NoSyY"};
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C1099Po A02;
    public final /* synthetic */ QW A03;

    public C1102Pr(C1099Po c1099Po, QW qw, int i2, int i3) {
        this.A02 = c1099Po;
        this.A03 = qw;
        this.A00 = i2;
        this.A01 = i3;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        XT xt;
        Handler handler;
        C9O c9o;
        XT xt2;
        C9O c9o2;
        KQ kq;
        Handler handler2;
        XT xt3;
        C9O c9o3;
        Handler handler3;
        XT xt4;
        XT xt5;
        C9O c9o4;
        C0977Kr c0977Kr;
        Handler handler4;
        XT xt6;
        XT xt7;
        Handler handler5;
        C9O c9o5;
        C9O c9o6;
        C1017Mh c1017Mh;
        XT xt8;
        C9O c9o7;
        if (this.A03 == QW.A07) {
            this.A02.A0L(EnumC0936Ja.A0o);
            xt8 = this.A02.A09;
            xt8.A0D().A2v();
            c9o7 = this.A02.A0A;
            c9o7.A02(C1099Po.A0C());
        } else if (this.A03 == QW.A03) {
            this.A02.A0L(EnumC0936Ja.A0j);
            this.A02.A03 = true;
            c9o6 = this.A02.A0A;
            c1017Mh = C1099Po.A0F;
            c9o6.A02(c1017Mh);
            this.A02.A0K(this.A00);
        } else {
            QW qw = this.A03;
            QW qw2 = QW.A06;
            String[] strArr = A04;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A04[5] = "Wlqb3PCyph61UkVVxo7ng7VZa1hYfmo4";
            if (qw == qw2) {
                this.A02.A0L(EnumC0936Ja.A0i);
                xt7 = this.A02.A09;
                xt7.A0D().A2n();
                this.A02.A03 = true;
                handler5 = this.A02.A06;
                handler5.removeCallbacksAndMessages(null);
                c9o5 = this.A02.A0A;
                int i2 = this.A01;
                c9o5.A02(new C06687v(i2, i2));
                this.A02.A0K(this.A01);
            } else if (this.A03 == QW.A0A) {
                xt4 = this.A02.A09;
                if (JD.A1D(xt4)) {
                    xt6 = this.A02.A09;
                    xt6.A09().ACa();
                }
                this.A02.A0L(EnumC0936Ja.A0m);
                xt5 = this.A02.A09;
                xt5.A0D().A32();
                c9o4 = this.A02.A0A;
                c0977Kr = C1099Po.A0G;
                c9o4.A02(c0977Kr);
                handler4 = this.A02.A06;
                handler4.removeCallbacksAndMessages(null);
                this.A02.A0H();
            } else if (this.A03 == QW.A05) {
                this.A02.A0L(EnumC0936Ja.A0l);
                xt3 = this.A02.A09;
                xt3.A0D().A2r();
                c9o3 = this.A02.A0A;
                final int i3 = this.A00;
                c9o3.A02(new AbstractC1019Mj(i3) { // from class: com.facebook.ads.redexgen.X.7u
                });
                handler3 = this.A02.A06;
                handler3.removeCallbacksAndMessages(null);
                this.A02.A0K(this.A00);
            } else if (this.A03 == QW.A04) {
                this.A02.A0L(EnumC0936Ja.A0k);
                xt2 = this.A02.A09;
                xt2.A0D().A2o();
                c9o2 = this.A02.A0A;
                kq = C1099Po.A0J;
                c9o2.A02(kq);
                handler2 = this.A02.A06;
                handler2.removeCallbacksAndMessages(null);
            } else if (this.A03 == QW.A09) {
                this.A02.A0L(EnumC0936Ja.A0i);
                xt = this.A02.A09;
                xt.A0D().A2x();
                this.A02.A03 = true;
                handler = this.A02.A06;
                handler.removeCallbacksAndMessages(null);
                c9o = this.A02.A0A;
                c9o.A02(new C06687v(this.A00, this.A01));
                this.A02.A0K(this.A00);
            }
        }
    }
}
