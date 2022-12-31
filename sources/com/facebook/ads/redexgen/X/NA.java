package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NA implements View.OnClickListener {
    public final /* synthetic */ C1178Sp A00;

    public NA(C1178Sp c1178Sp) {
        this.A00 = c1178Sp;
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
