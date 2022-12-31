package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class c6 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ r6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c6(r6 r6Var, AtomicReference atomicReference) {
        this.b = r6Var;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            this.a.set(Boolean.valueOf(this.b.a.x().u(this.b.a.b().n(), x2.K)));
            this.a.notify();
        }
    }
}
