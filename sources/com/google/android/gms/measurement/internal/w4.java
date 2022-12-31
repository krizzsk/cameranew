package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class w4 implements Runnable {
    final /* synthetic */ zzp a;
    final /* synthetic */ h5 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w4(h5 h5Var, zzp zzpVar) {
        this.b = h5Var;
        this.a = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9 i9Var;
        i9 i9Var2;
        i9Var = this.b.a;
        i9Var.n();
        i9Var2 = this.b.a;
        i9Var2.p(this.a);
    }
}
