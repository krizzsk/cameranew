package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class O6 implements View.OnClickListener {
    public final /* synthetic */ O8 A00;

    public O6(O8 o8) {
        this.A00 = o8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A04();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
