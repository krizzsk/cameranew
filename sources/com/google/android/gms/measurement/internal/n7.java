package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class n7 implements Runnable {
    final /* synthetic */ y6 a;
    final /* synthetic */ g8 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n7(g8 g8Var, y6 y6Var) {
        this.b = g8Var;
        this.a = y6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a3 a3Var;
        a3Var = this.b.f3807d;
        if (a3Var == null) {
            this.b.a.a().m().a("Failed to send current screen to service");
            return;
        }
        try {
            y6 y6Var = this.a;
            if (y6Var == null) {
                a3Var.S(0L, null, null, this.b.a.zzaw().getPackageName());
            } else {
                a3Var.S(y6Var.c, y6Var.a, y6Var.b, this.b.a.zzaw().getPackageName());
            }
            this.b.B();
        } catch (RemoteException e2) {
            this.b.a.a().m().b("Failed to send current screen to the service", e2);
        }
    }
}
