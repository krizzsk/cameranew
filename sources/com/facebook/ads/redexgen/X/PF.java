package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class PF implements View.OnClickListener {
    public final /* synthetic */ PG A00;

    public PF(PG pg) {
        this.A00 = pg;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C06296e c06296e;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            c06296e = this.A00.A04;
            c06296e.performClick();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
