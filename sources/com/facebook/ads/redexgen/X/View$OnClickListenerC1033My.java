package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.My  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC1033My implements View.OnClickListener {
    public final /* synthetic */ N0 A00;

    public View$OnClickListenerC1033My(N0 n0) {
        this.A00 = n0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        N3 n3;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            n3 = this.A00.A03;
            n3.A8b();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
