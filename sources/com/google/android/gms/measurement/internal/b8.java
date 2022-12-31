package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class b8 implements Runnable {
    final /* synthetic */ a3 a;
    final /* synthetic */ f8 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b8(f8 f8Var, a3 a3Var) {
        this.b = f8Var;
        this.a = a3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            this.b.a = false;
            if (!this.b.c.F()) {
                this.b.c.a.a().t().a("Connected to remote service");
                this.b.c.q(this.a);
            }
        }
    }
}
