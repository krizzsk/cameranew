package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Py  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC1109Py implements View.OnClickListener {
    public final /* synthetic */ C0921Ij A00;

    public View$OnClickListenerC1109Py(C0921Ij c0921Ij) {
        this.A00 = c0921Ij;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0937Jb c0937Jb;
        XT xt;
        C1099Po c1099Po;
        boolean A07;
        C1099Po c1099Po2;
        C1099Po c1099Po3;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            c0937Jb = this.A00.A03;
            c0937Jb.A02(EnumC0936Ja.A0b, null);
            xt = this.A00.A02;
            xt.A0D().A2y();
            c1099Po = this.A00.A00;
            if (c1099Po != null) {
                A07 = this.A00.A07();
                if (A07) {
                    c1099Po3 = this.A00.A00;
                    c1099Po3.setVolume(1.0f);
                } else {
                    c1099Po2 = this.A00.A00;
                    c1099Po2.setVolume(0.0f);
                }
                this.A00.A09();
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
