package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Mp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC1024Mp implements View.OnClickListener {
    public final /* synthetic */ C1183Su A00;

    public View$OnClickListenerC1024Mp(C1183Su c1183Su) {
        this.A00 = c1183Su;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1026Mr interfaceC1026Mr;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            interfaceC1026Mr = this.A00.A05;
            interfaceC1026Mr.AAb();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
