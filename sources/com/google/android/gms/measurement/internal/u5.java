package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class u5 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ r6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u5(r6 r6Var, boolean z) {
        this.b = r6Var;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean i2 = this.b.a.i();
        boolean h2 = this.b.a.h();
        this.b.a.g(this.a);
        if (h2 == this.a) {
            this.b.a.a().u().b("Default data collection state already set to", Boolean.valueOf(this.a));
        }
        if (this.b.a.i() == i2 || this.b.a.i() != this.b.a.h()) {
            this.b.a.a().r().c("Default data collection is different than actual status", Boolean.valueOf(this.a), Boolean.valueOf(i2));
        }
        this.b.K();
    }
}
