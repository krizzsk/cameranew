package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class c7 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ g7 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c7(g7 g7Var, long j2) {
        this.b = g7Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.e().i(this.a);
        this.b.f3799e = null;
    }
}
