package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class O5 implements View.OnClickListener {
    public final /* synthetic */ O8 A00;

    public O5(O8 o8) {
        this.A00 = o8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        O7 o7;
        View v;
        View[] viewArr;
        C1099Po c1099Po;
        C1099Po c1099Po2;
        C1099Po c1099Po3;
        View v2;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            o7 = this.A00.A04;
            o7.ABA();
            v = this.A00.A00;
            if (v != null) {
                v2 = this.A00.A00;
                M5.A0L(v2);
            }
            viewArr = this.A00.A06;
            for (View v3 : viewArr) {
                M5.A0N(v3, 0);
            }
            M5.A0J(this.A00);
            c1099Po = this.A00.A05;
            if (c1099Po == null) {
                return;
            }
            c1099Po2 = this.A00.A05;
            M5.A0N(c1099Po2, 0);
            c1099Po3 = this.A00.A05;
            c1099Po3.A0b(EnumC1094Pj.A03, 14);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
