package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class i7 implements Runnable {
    final /* synthetic */ zzp a;
    final /* synthetic */ boolean b;
    final /* synthetic */ zzkg c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ g8 f3834d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i7(g8 g8Var, zzp zzpVar, boolean z, zzkg zzkgVar) {
        this.f3834d = g8Var;
        this.a = zzpVar;
        this.b = z;
        this.c = zzkgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a3 a3Var;
        a3Var = this.f3834d.f3807d;
        if (a3Var == null) {
            this.f3834d.a.a().m().a("Discarding data. Failed to set user property");
            return;
        }
        com.google.android.gms.common.internal.q.j(this.a);
        this.f3834d.I(a3Var, this.b ? null : this.c, this.a);
        this.f3834d.B();
    }
}
