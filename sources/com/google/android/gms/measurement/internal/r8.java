package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class r8 extends l {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ s8 f3937e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r8(s8 s8Var, k5 k5Var) {
        super(k5Var);
        this.f3937e = s8Var;
    }

    @Override // com.google.android.gms.measurement.internal.l
    @WorkerThread
    public final void a() {
        s8 s8Var = this.f3937e;
        s8Var.f3939d.f();
        s8Var.d(false, false, s8Var.f3939d.a.zzax().a());
        s8Var.f3939d.a.e().i(s8Var.f3939d.a.zzax().a());
    }
}
