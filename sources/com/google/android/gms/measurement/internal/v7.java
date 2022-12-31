package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class v7 implements Runnable {
    final /* synthetic */ zzp a;
    final /* synthetic */ boolean b;
    final /* synthetic */ zzaa c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ g8 f3953d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v7(g8 g8Var, boolean z, zzp zzpVar, boolean z2, zzaa zzaaVar, zzaa zzaaVar2) {
        this.f3953d = g8Var;
        this.a = zzpVar;
        this.b = z2;
        this.c = zzaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a3 a3Var;
        a3Var = this.f3953d.f3807d;
        if (a3Var == null) {
            this.f3953d.a.a().m().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        com.google.android.gms.common.internal.q.j(this.a);
        this.f3953d.I(a3Var, this.b ? null : this.c, this.a);
        this.f3953d.B();
    }
}
