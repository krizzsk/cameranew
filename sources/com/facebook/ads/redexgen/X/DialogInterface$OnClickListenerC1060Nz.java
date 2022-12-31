package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Nz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class DialogInterface$OnClickListenerC1060Nz implements DialogInterface.OnClickListener {
    public final /* synthetic */ O1 A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ Map A02;

    public DialogInterface$OnClickListenerC1060Nz(O1 o1, String str, Map map) {
        this.A00 = o1;
        this.A01 = str;
        this.A02 = map;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        JT jt;
        jt = this.A00.A04;
        jt.A9D(this.A01, this.A02);
    }
}
