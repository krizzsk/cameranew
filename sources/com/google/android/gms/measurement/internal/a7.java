package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class a7 implements Runnable {
    final /* synthetic */ y6 a;
    final /* synthetic */ y6 b;
    final /* synthetic */ long c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f3748d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g7 f3749e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a7(g7 g7Var, y6 y6Var, y6 y6Var2, long j2, boolean z) {
        this.f3749e = g7Var;
        this.a = y6Var;
        this.b = y6Var2;
        this.c = j2;
        this.f3748d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3749e.n(this.a, this.b, this.c, this.f3748d, null);
    }
}
