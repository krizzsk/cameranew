package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class p7 extends l {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g8 f3916e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p7(g8 g8Var, k5 k5Var) {
        super(k5Var);
        this.f3916e = g8Var;
    }

    @Override // com.google.android.gms.measurement.internal.l
    public final void a() {
        g8 g8Var = this.f3916e;
        g8Var.f();
        if (g8Var.F()) {
            g8Var.a.a().u().a("Inactivity, disconnecting from the service");
            g8Var.r();
        }
    }
}
