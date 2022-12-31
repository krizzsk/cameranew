package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class m6 implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ long b;
    final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f3874d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f3875e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ r6 f3876f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m6(r6 r6Var, f fVar, long j2, int i2, long j3, boolean z) {
        this.f3876f = r6Var;
        this.a = fVar;
        this.b = j2;
        this.c = i2;
        this.f3874d = j3;
        this.f3875e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3876f.U(this.a);
        this.f3876f.r(this.b, false);
        r6.H(this.f3876f, this.a, this.c, this.f3874d, true, this.f3875e);
    }
}
