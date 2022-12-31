package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzlx;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class s8 {
    protected long a;
    protected long b;
    private final l c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ u8 f3939d;

    public s8(u8 u8Var) {
        this.f3939d = u8Var;
        this.c = new r8(this, u8Var.a);
        long a = u8Var.a.zzax().a();
        this.a = a;
        this.b = a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(long j2) {
        this.f3939d.f();
        this.c.d();
        this.a = j2;
        this.b = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(long j2) {
        this.c.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.c.d();
        this.a = 0L;
        this.b = 0L;
    }

    @WorkerThread
    public final boolean d(boolean z, boolean z2, long j2) {
        this.f3939d.f();
        this.f3939d.h();
        zzlx.zzb();
        if (this.f3939d.a.x().u(null, x2.p0)) {
            if (this.f3939d.a.i()) {
                this.f3939d.a.y().t.b(this.f3939d.a.zzax().currentTimeMillis());
            }
        } else {
            this.f3939d.a.y().t.b(this.f3939d.a.zzax().currentTimeMillis());
        }
        long j3 = j2 - this.a;
        if (!z && j3 < 1000) {
            this.f3939d.a.a().u().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j3));
            return false;
        }
        if (!z2) {
            j3 = j2 - this.b;
            this.b = j2;
        }
        this.f3939d.a.a().u().b("Recording user engagement, ms", Long.valueOf(j3));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j3);
        g7.v(this.f3939d.a.O().q(!this.f3939d.a.x().A()), bundle, true);
        e x = this.f3939d.a.x();
        w2<Boolean> w2Var = x2.U;
        if (!x.u(null, w2Var) && z2) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.f3939d.a.x().u(null, w2Var) || !z2) {
            this.f3939d.a.D().V("auto", "_e", bundle);
        }
        this.a = j2;
        this.c.d();
        this.c.b(3600000L);
        return true;
    }
}
