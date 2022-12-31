package com.tapjoy.internal;

import android.app.Dialog;
import android.content.Context;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public final class c extends Dialog {
    private boolean a;

    public c(Context context) {
        super(context, 16973835);
        this.a = false;
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(17170445);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        this.a = true;
        super.cancel();
    }

    @Override // android.app.Dialog
    public final void show() {
        this.a = false;
        super.show();
        VdsAgent.showDialog(this);
    }
}
