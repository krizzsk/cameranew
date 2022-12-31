package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class w5 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ r6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w5(r6 r6Var, long j2) {
        this.b = r6Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.y().p.b(this.a);
        this.b.a.a().t().b("Session timeout duration set", Long.valueOf(this.a));
    }
}
