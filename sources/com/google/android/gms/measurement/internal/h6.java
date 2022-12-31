package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class h6 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ r6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h6(r6 r6Var, AtomicReference atomicReference) {
        this.b = r6Var;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            this.a.set(this.b.a.x().p(this.b.a.b().n(), x2.L));
            this.a.notify();
        }
    }
}
