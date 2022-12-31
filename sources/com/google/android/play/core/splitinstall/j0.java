package com.google.android.play.core.splitinstall;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j0 implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ k0 f4881d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(k0 k0Var, d dVar, int i2, int i3) {
        this.f4881d = k0Var;
        this.a = dVar;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k0 k0Var = this.f4881d;
        d dVar = this.a;
        k0Var.c(new f(dVar.l(), this.b, this.c, dVar.d(), dVar.n(), dVar.b(), dVar.c(), dVar.k(), dVar.e()));
    }
}
