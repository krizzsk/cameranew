package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class z5 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ r6 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z5(r6 r6Var, long j2) {
        this.b = r6Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.r(this.a, true);
        this.b.a.P().R(new AtomicReference<>());
    }
}
