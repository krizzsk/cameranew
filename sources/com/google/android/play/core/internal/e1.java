package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
final class e1 extends WeakReference<Throwable> {
    private final int a;

    public e1(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == e1.class) {
            if (this == obj) {
                return true;
            }
            e1 e1Var = (e1) obj;
            if (this.a == e1Var.a && get() == e1Var.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
