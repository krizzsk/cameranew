package com.google.android.play.core.internal;

import java.util.Objects;
/* loaded from: classes2.dex */
final class g1 extends d1 {
    private final f1 a = new f1();

    @Override // com.google.android.play.core.internal.d1
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
        this.a.a(th).add(th2);
    }
}
