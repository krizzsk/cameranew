package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class f implements DialogInterface.OnClickListener {
    public static f a(Activity activity, Intent intent, int i2) {
        return new v(intent, activity, i2);
    }

    protected abstract void b();

    @Override // android.content.DialogInterface.OnClickListener
    @Instrumented
    public void onClick(DialogInterface dialogInterface, int i2) {
        VdsAgent.onClick(this, dialogInterface, i2);
        try {
            b();
        } catch (ActivityNotFoundException e2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
