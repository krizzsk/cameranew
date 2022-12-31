package com.google.android.gms.measurement.internal;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class p8 implements Runnable {
    final long a;
    final long b;
    final /* synthetic */ q8 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p8(q8 q8Var, long j2, long j3) {
        this.c = q8Var;
        this.a = j2;
        this.b = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.b.a.c().p(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.o8
            private final p8 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p8 p8Var = this.a;
                q8 q8Var = p8Var.c;
                long j2 = p8Var.a;
                long j3 = p8Var.b;
                q8Var.b.f();
                q8Var.b.a.a().t().a("Application going to the background");
                boolean z = true;
                if (q8Var.b.a.x().u(null, x2.u0)) {
                    q8Var.b.a.y().v.b(true);
                }
                Bundle bundle = new Bundle();
                if (!q8Var.b.a.x().A()) {
                    q8Var.b.f3949e.b(j3);
                    if (q8Var.b.a.x().u(null, x2.l0)) {
                        s8 s8Var = q8Var.b.f3949e;
                        long j4 = s8Var.b;
                        s8Var.b = j3;
                        bundle.putLong("_et", j3 - j4);
                        g7.v(q8Var.b.a.O().q(true), bundle, true);
                    } else {
                        z = false;
                    }
                    q8Var.b.f3949e.d(false, z, j3);
                }
                q8Var.b.a.D().W("auto", "_ab", j2, bundle);
            }
        });
    }
}
