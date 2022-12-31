package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzs;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class l7 implements Runnable {
    final /* synthetic */ zzp a;
    final /* synthetic */ zzs b;
    final /* synthetic */ g8 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l7(g8 g8Var, zzp zzpVar, zzs zzsVar) {
        this.c = g8Var;
        this.a = zzpVar;
        this.b = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o4 o4Var;
        a3 a3Var;
        String str = null;
        try {
            try {
                zzlc.zzb();
                if (!this.c.a.x().u(null, x2.w0) || this.c.a.y().r().h()) {
                    a3Var = this.c.f3807d;
                    if (a3Var == null) {
                        this.c.a.a().m().a("Failed to get app instance id");
                        o4Var = this.c.a;
                    } else {
                        com.google.android.gms.common.internal.q.j(this.a);
                        str = a3Var.m(this.a);
                        if (str != null) {
                            this.c.a.D().p(str);
                            this.c.a.y().f4009l.b(str);
                        }
                        this.c.B();
                        o4Var = this.c.a;
                    }
                } else {
                    this.c.a.a().r().a("Analytics storage consent denied; will not get app instance id");
                    this.c.a.D().p(null);
                    this.c.a.y().f4009l.b(null);
                    o4Var = this.c.a;
                }
            } catch (RemoteException e2) {
                this.c.a.a().m().b("Failed to get app instance id", e2);
                o4Var = this.c.a;
            }
            o4Var.E().P(this.b, str);
        } catch (Throwable th) {
            this.c.a.E().P(this.b, null);
            throw th;
        }
    }
}
