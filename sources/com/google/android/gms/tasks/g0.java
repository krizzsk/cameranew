package com.google.android.gms.tasks;

import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public final class g0 implements Runnable {
    private final /* synthetic */ c0 a;
    private final /* synthetic */ Callable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(c0 c0Var, Callable callable) {
        this.a = c0Var;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.r(this.b.call());
        } catch (Exception e2) {
            this.a.q(e2);
        }
    }
}
