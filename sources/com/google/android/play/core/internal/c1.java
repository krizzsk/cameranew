package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class c1 extends b1 {
    private final b1 a;
    private final long b;
    private final long c;

    public c1(b1 b1Var, long j2, long j3) {
        this.a = b1Var;
        long u = u(j2);
        this.b = u;
        this.c = u(u + j3);
    }

    private final long u(long j2) {
        if (j2 < 0) {
            return 0L;
        }
        return j2 > this.a.d() ? this.a.d() : j2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.play.core.internal.b1
    public final long d() {
        return this.c - this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.b1
    public final InputStream e(long j2, long j3) throws IOException {
        long u = u(this.b);
        return this.a.e(u, u(j3 + u) - u);
    }
}
