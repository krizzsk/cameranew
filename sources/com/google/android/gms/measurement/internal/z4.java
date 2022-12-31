package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class z4 implements Runnable {
    final /* synthetic */ zzas a;
    final /* synthetic */ zzp b;
    final /* synthetic */ h5 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z4(h5 h5Var, zzas zzasVar, zzp zzpVar) {
        this.c = h5Var;
        this.a = zzasVar;
        this.b = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9 i9Var;
        i9 i9Var2;
        zzas x0 = this.c.x0(this.a, this.b);
        i9Var = this.c.a;
        i9Var.n();
        i9Var2 = this.c.a;
        i9Var2.e(x0, this.b);
    }
}
