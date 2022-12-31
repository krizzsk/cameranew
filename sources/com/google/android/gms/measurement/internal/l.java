package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.internal.measurement.zzl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class l {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Handler f3856d;
    private final k5 a;
    private final Runnable b;
    private volatile long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k5 k5Var) {
        com.google.android.gms.common.internal.q.j(k5Var);
        this.a = k5Var;
        this.b = new k(this, k5Var);
    }

    private final Handler f() {
        Handler handler;
        if (f3856d != null) {
            return f3856d;
        }
        synchronized (l.class) {
            if (f3856d == null) {
                f3856d = new zzl(this.a.zzaw().getMainLooper());
            }
            handler = f3856d;
        }
        return handler;
    }

    public abstract void a();

    public final void b(long j2) {
        d();
        if (j2 >= 0) {
            this.c = this.a.zzax().currentTimeMillis();
            if (f().postDelayed(this.b, j2)) {
                return;
            }
            this.a.a().m().b("Failed to schedule delayed post. time", Long.valueOf(j2));
        }
    }

    public final boolean c() {
        return this.c != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        this.c = 0L;
        f().removeCallbacks(this.b);
    }
}
