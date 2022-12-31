package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class r4 implements Runnable {
    final /* synthetic */ zzaa a;
    final /* synthetic */ h5 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r4(h5 h5Var, zzaa zzaaVar) {
        this.b = h5Var;
        this.a = zzaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9 i9Var;
        i9 i9Var2;
        i9 i9Var3;
        i9Var = this.b.a;
        i9Var.n();
        if (this.a.zzc.Q() == null) {
            i9Var3 = this.b.a;
            i9Var3.y(this.a);
            return;
        }
        i9Var2 = this.b.a;
        i9Var2.w(this.a);
    }
}
