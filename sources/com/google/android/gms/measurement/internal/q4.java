package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class q4 implements Runnable {
    final /* synthetic */ zzaa a;
    final /* synthetic */ zzp b;
    final /* synthetic */ h5 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q4(h5 h5Var, zzaa zzaaVar, zzp zzpVar) {
        this.c = h5Var;
        this.a = zzaaVar;
        this.b = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9 i9Var;
        i9 i9Var2;
        i9 i9Var3;
        i9Var = this.c.a;
        i9Var.n();
        if (this.a.zzc.Q() == null) {
            i9Var3 = this.c.a;
            i9Var3.z(this.a, this.b);
            return;
        }
        i9Var2 = this.c.a;
        i9Var2.x(this.a, this.b);
    }
}
