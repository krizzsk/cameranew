package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import androidx.annotation.MainThread;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class f4 {
    private final e4 a;

    public f4(e4 e4Var) {
        com.google.android.gms.common.internal.q.j(e4Var);
        this.a = e4Var;
    }

    public static boolean a(Context context) {
        ActivityInfo receiverInfo;
        com.google.android.gms.common.internal.q.j(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @MainThread
    public final void b(Context context, Intent intent) {
        o4 f2 = o4.f(context, null, null);
        k3 a = f2.a();
        if (intent == null) {
            a.p().a("Receiver called with null intent");
            return;
        }
        f2.d();
        String action = intent.getAction();
        a.u().b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            a.u().a("Starting wakeful intent.");
            this.a.a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            a.p().a("Install Referrer Broadcasts are deprecated");
        }
    }
}
