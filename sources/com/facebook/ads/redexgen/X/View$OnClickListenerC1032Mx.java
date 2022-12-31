package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Mx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC1032Mx implements View.OnClickListener {
    public final /* synthetic */ N0 A00;

    public View$OnClickListenerC1032Mx(N0 n0) {
        this.A00 = n0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        N3 n3;
        N3 n32;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            z = this.A00.A04;
            if (z) {
                n32 = this.A00.A03;
                n32.A40();
                return;
            }
            n3 = this.A00.A03;
            n3.A41();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
