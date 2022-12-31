package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class o7 implements Runnable {
    final /* synthetic */ zzp a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ g8 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o7(g8 g8Var, zzp zzpVar, Bundle bundle) {
        this.c = g8Var;
        this.a = zzpVar;
        this.b = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a3 a3Var;
        a3Var = this.c.f3807d;
        if (a3Var == null) {
            this.c.a.a().m().a("Failed to send default event parameters to service");
            return;
        }
        try {
            com.google.android.gms.common.internal.q.j(this.a);
            a3Var.c0(this.b, this.a);
        } catch (RemoteException e2) {
            this.c.a.a().m().b("Failed to send default event parameters to service", e2);
        }
    }
}
