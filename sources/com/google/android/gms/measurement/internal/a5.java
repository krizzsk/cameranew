package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class a5 implements Runnable {
    final /* synthetic */ zzas a;
    final /* synthetic */ String b;
    final /* synthetic */ h5 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a5(h5 h5Var, zzas zzasVar, String str) {
        this.c = h5Var;
        this.a = zzasVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9 i9Var;
        i9 i9Var2;
        i9Var = this.c.a;
        i9Var.n();
        i9Var2 = this.c.a;
        i9Var2.l0(this.a, this.b);
    }
}
