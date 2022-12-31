package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class d7 implements Runnable {
    final /* synthetic */ y6 a;
    final /* synthetic */ long b;
    final /* synthetic */ g7 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d7(g7 g7Var, y6 y6Var, long j2) {
        this.c = g7Var;
        this.a = y6Var;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.o(this.a, false, this.b);
        g7 g7Var = this.c;
        g7Var.f3799e = null;
        g7Var.a.P().U(null);
    }
}
