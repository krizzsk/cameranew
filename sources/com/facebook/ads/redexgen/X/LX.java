package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class LX {
    public static void A00(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, @Nullable Context context) {
        if (context == null || !(context instanceof Activity)) {
            onClickListener.onClick(null, 0);
        } else {
            new AlertDialog.Builder(context).setTitle(JD.A0V(context)).setMessage(JD.A0T(context)).setPositiveButton(JD.A0U(context), new LW(onClickListener)).setNegativeButton(JD.A0S(context), new LV(onClickListener2)).show();
        }
    }
}
