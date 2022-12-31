package com.google.android.gms.measurement.internal;

import android.os.Handler;
import androidx.annotation.WorkerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class q8 {
    private p8 a;
    final /* synthetic */ u8 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q8(u8 u8Var) {
        this.b = u8Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a() {
        Handler handler;
        this.b.f();
        if (this.a != null) {
            handler = this.b.c;
            handler.removeCallbacks(this.a);
        }
        if (this.b.a.x().u(null, x2.u0)) {
            this.b.a.y().v.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(long j2) {
        Handler handler;
        this.a = new p8(this, this.b.a.zzax().currentTimeMillis(), j2);
        handler = this.b.c;
        handler.postDelayed(this.a, 2000L);
    }
}
