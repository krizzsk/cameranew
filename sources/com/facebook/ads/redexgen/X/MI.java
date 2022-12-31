package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import android.widget.EditText;
import java.util.concurrent.Executor;
/* loaded from: assets/audience_network.dex */
public class MI implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText A00;
    public final /* synthetic */ TF A01;

    public MI(TF tf, EditText editText) {
        this.A01 = tf;
        this.A00 = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Executor executor;
        executor = this.A01.A03;
        executor.execute(new TG(this, dialogInterface));
    }
}
