package com.tapjoy.internal;

import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class cc implements Runnable {
    private final ca a;
    @Nullable
    private final cf b;

    /* JADX INFO: Access modifiers changed from: protected */
    public cc(ca caVar, @Nullable cf cfVar) {
        this.a = caVar;
        this.b = cfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object f2 = this.a.f();
            cf cfVar = this.b;
            if (cfVar == null || (cfVar instanceof cg)) {
                return;
            }
            cfVar.a(this.a, f2);
        } catch (Throwable unused) {
            cf cfVar2 = this.b;
            if (cfVar2 == null || (cfVar2 instanceof cg)) {
                return;
            }
            cfVar2.a(this.a);
        }
    }
}
