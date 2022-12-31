package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class k implements Runnable {
    final /* synthetic */ k5 a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l lVar, k5 k5Var) {
        this.b = lVar;
        this.a = k5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
        if (da.a()) {
            this.a.c().p(this);
            return;
        }
        boolean c = this.b.c();
        this.b.c = 0L;
        if (c) {
            this.b.a();
        }
    }
}
