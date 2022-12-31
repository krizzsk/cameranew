package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
/* loaded from: assets/audience_network.dex */
public class LW implements DialogInterface.OnClickListener {
    public final /* synthetic */ DialogInterface.OnClickListener A00;

    public LW(DialogInterface.OnClickListener onClickListener) {
        this.A00 = onClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.A00.onClick(dialogInterface, i2);
    }
}
