package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Jo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class DialogInterface$OnClickListenerC0950Jo implements DialogInterface.OnClickListener {
    public final /* synthetic */ View$OnClickListenerC1200Tl A00;

    public DialogInterface$OnClickListenerC0950Jo(View$OnClickListenerC1200Tl view$OnClickListenerC1200Tl) {
        this.A00 = view$OnClickListenerC1200Tl;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Map<String, String> A01;
        if (this.A00.A01.A0a != null) {
            C1543cy c1543cy = this.A00.A01.A0a;
            A01 = this.A00.A01();
            c1543cy.A0d(A01);
        }
    }
}
