package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Mf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC1015Mf implements View.OnClickListener {
    public final /* synthetic */ C1185Sw A00;

    public View$OnClickListenerC1015Mf(C1185Sw c1185Sw) {
        this.A00 = c1185Sw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A0X(false);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
