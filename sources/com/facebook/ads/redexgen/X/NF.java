package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NF implements View.OnClickListener {
    public final /* synthetic */ C2D A00;
    public final /* synthetic */ N5 A01;
    public final /* synthetic */ C1178Sp A02;

    public NF(C1178Sp c1178Sp, N5 n5, C2D c2d) {
        this.A02 = c1178Sp;
        this.A01 = n5;
        this.A00 = c2d;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A0A.ABQ(this.A00);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
