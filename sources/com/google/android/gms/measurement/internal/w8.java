package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class w8 extends l {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ x8 f3963e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w8(x8 x8Var, k5 k5Var) {
        super(k5Var);
        this.f3963e = x8Var;
    }

    @Override // com.google.android.gms.measurement.internal.l
    public final void a() {
        this.f3963e.l();
        this.f3963e.a.a().u().a("Starting upload from DelayedRunnable");
        this.f3963e.b.i();
    }
}
