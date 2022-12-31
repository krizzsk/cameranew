package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class PH implements View.OnClickListener {
    public final /* synthetic */ PK A00;

    public PH(PK pk) {
        this.A00 = pk;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PJ pj;
        PI pi;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            pj = this.A00.A02;
            pi = this.A00.A01;
            pj.ACD(pi);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
