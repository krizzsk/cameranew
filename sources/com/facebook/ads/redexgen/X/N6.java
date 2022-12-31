package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class N6 implements View.OnClickListener {
    public final /* synthetic */ C1179Sq A00;

    public N6(C1179Sq c1179Sq) {
        this.A00 = c1179Sq;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A0A.A41();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
