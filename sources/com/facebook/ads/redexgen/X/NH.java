package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NH implements View.OnClickListener {
    public final /* synthetic */ NJ A00;

    public NH(NJ nj) {
        this.A00 = nj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        N3 n3;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            n3 = this.A00.A02;
            n3.A7k();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
