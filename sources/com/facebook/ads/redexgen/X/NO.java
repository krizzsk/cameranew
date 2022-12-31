package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NO implements View.OnClickListener {
    public final /* synthetic */ C1177So A00;

    public NO(C1177So c1177So) {
        this.A00 = c1177So;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A0A.A7k();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
