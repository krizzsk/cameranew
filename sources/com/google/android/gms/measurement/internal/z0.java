package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class z0 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ a2 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(a2 a2Var, long j2) {
        this.b = a2Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.o(this.a);
    }
}
