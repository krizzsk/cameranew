package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class m7 implements Runnable {
    final /* synthetic */ zzp a;
    final /* synthetic */ g8 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m7(g8 g8Var, zzp zzpVar) {
        this.b = g8Var;
        this.a = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a3 a3Var;
        a3Var = this.b.f3807d;
        if (a3Var == null) {
            this.b.a.a().m().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            com.google.android.gms.common.internal.q.j(this.a);
            a3Var.t0(this.a);
            this.b.a.G().s();
            this.b.I(a3Var, null, this.a);
            this.b.B();
        } catch (RemoteException e2) {
            this.b.a.a().m().b("Failed to send app launch to the service", e2);
        }
    }
}
