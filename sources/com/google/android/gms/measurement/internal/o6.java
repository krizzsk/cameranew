package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class o6 implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ int b;
    final /* synthetic */ long c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f3909d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ r6 f3910e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o6(r6 r6Var, f fVar, int i2, long j2, boolean z) {
        this.f3910e = r6Var;
        this.a = fVar;
        this.b = i2;
        this.c = j2;
        this.f3909d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3910e.U(this.a);
        r6.H(this.f3910e, this.a, this.b, this.c, false, this.f3909d);
    }
}
