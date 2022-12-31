package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzlc;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class k7 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ zzp b;
    final /* synthetic */ g8 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k7(g8 g8Var, AtomicReference atomicReference, zzp zzpVar) {
        this.c = g8Var;
        this.a = atomicReference;
        this.b = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        a3 a3Var;
        synchronized (this.a) {
            try {
                zzlc.zzb();
            } catch (RemoteException e2) {
                this.c.a.a().m().b("Failed to get app instance id", e2);
                atomicReference = this.a;
            }
            if (this.c.a.x().u(null, x2.w0) && !this.c.a.y().r().h()) {
                this.c.a.a().r().a("Analytics storage consent denied; will not get app instance id");
                this.c.a.D().p(null);
                this.c.a.y().f4009l.b(null);
                this.a.set(null);
                this.a.notify();
                return;
            }
            a3Var = this.c.f3807d;
            if (a3Var == null) {
                this.c.a.a().m().a("Failed to get app instance id");
                this.a.notify();
                return;
            }
            com.google.android.gms.common.internal.q.j(this.b);
            this.a.set(a3Var.m(this.b));
            String str = (String) this.a.get();
            if (str != null) {
                this.c.a.D().p(str);
                this.c.a.y().f4009l.b(str);
            }
            this.c.B();
            atomicReference = this.a;
            atomicReference.notify();
        }
    }
}
