package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NB implements View.OnClickListener {
    public final /* synthetic */ N5 A00;
    public final /* synthetic */ C1178Sp A01;

    public NB(C1178Sp c1178Sp, N5 n5) {
        this.A01 = c1178Sp;
        this.A00 = n5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0A.ABH(C2B.A03);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
