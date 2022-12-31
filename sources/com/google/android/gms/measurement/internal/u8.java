package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzl;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class u8 extends c4 {
    private Handler c;

    /* renamed from: d  reason: collision with root package name */
    protected final t8 f3948d;

    /* renamed from: e  reason: collision with root package name */
    protected final s8 f3949e;

    /* renamed from: f  reason: collision with root package name */
    protected final q8 f3950f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u8(o4 o4Var) {
        super(o4Var);
        this.f3948d = new t8(this);
        this.f3949e = new s8(this);
        this.f3950f = new q8(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m(u8 u8Var, long j2) {
        u8Var.f();
        u8Var.q();
        u8Var.a.a().u().b("Activity resumed, time", Long.valueOf(j2));
        e x = u8Var.a.x();
        w2<Boolean> w2Var = x2.u0;
        if (x.u(null, w2Var)) {
            if (u8Var.a.x().A() || u8Var.a.y().v.a()) {
                u8Var.f3949e.a(j2);
            }
            u8Var.f3950f.a();
        } else {
            u8Var.f3950f.a();
            if (u8Var.a.x().A()) {
                u8Var.f3949e.a(j2);
            }
        }
        t8 t8Var = u8Var.f3948d;
        t8Var.a.f();
        if (t8Var.a.a.i()) {
            if (!t8Var.a.a.x().u(null, w2Var)) {
                t8Var.a.a.y().v.b(false);
            }
            t8Var.b(t8Var.a.a.zzax().currentTimeMillis(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(u8 u8Var, long j2) {
        u8Var.f();
        u8Var.q();
        u8Var.a.a().u().b("Activity paused, time", Long.valueOf(j2));
        u8Var.f3950f.b(j2);
        if (u8Var.a.x().A()) {
            u8Var.f3949e.b(j2);
        }
        t8 t8Var = u8Var.f3948d;
        if (t8Var.a.a.x().u(null, x2.u0)) {
            return;
        }
        t8Var.a.a.y().v.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void q() {
        f();
        if (this.c == null) {
            this.c = new zzl(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.c4
    protected final boolean k() {
        return false;
    }
}
