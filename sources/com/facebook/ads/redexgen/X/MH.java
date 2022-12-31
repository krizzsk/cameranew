package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
/* loaded from: assets/audience_network.dex */
public class MH implements DialogInterface.OnClickListener {
    public final /* synthetic */ TF A00;

    public MH(TF tf) {
        this.A00 = tf;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
    }
}
