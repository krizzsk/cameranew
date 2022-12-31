package com.tapjoy.internal;

import java.io.EOFException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ix implements it {
    public final ir a = new ir();
    public final jc b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ix(jc jcVar) {
        if (jcVar != null) {
            this.b = jcVar;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.tapjoy.internal.it
    public final void a(long j2) {
        boolean z;
        if (j2 >= 0) {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            while (true) {
                ir irVar = this.a;
                if (irVar.b >= j2) {
                    z = true;
                    break;
                } else if (this.b.b(irVar, 8192L) == -1) {
                    z = false;
                    break;
                }
            }
            if (!z) {
                throw new EOFException();
            }
            return;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j2);
    }

    @Override // com.tapjoy.internal.jc
    public final long b(ir irVar, long j2) {
        if (irVar != null) {
            if (j2 >= 0) {
                if (!this.c) {
                    ir irVar2 = this.a;
                    if (irVar2.b == 0 && this.b.b(irVar2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.a.b(irVar, Math.min(j2, this.a.b));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.tapjoy.internal.it
    public final byte c() {
        a(1L);
        return this.a.c();
    }

    @Override // com.tapjoy.internal.jc, java.lang.AutoCloseable
    public final void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        ir irVar = this.a;
        try {
            irVar.d(irVar.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.tapjoy.internal.it
    public final void d(long j2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j2 > 0) {
            ir irVar = this.a;
            if (irVar.b == 0 && this.b.b(irVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, this.a.b);
            this.a.d(min);
            j2 -= min;
        }
    }

    @Override // com.tapjoy.internal.it
    public final int e() {
        a(4L);
        return je.a(this.a.d());
    }

    @Override // com.tapjoy.internal.it
    public final long f() {
        a(8L);
        return this.a.f();
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // com.tapjoy.internal.it
    public final String c(long j2) {
        a(j2);
        return this.a.c(j2);
    }

    @Override // com.tapjoy.internal.it
    public final boolean b() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.a.b() && this.b.b(this.a, 8192L) == -1;
    }

    @Override // com.tapjoy.internal.it
    public final iu b(long j2) {
        a(j2);
        return this.a.b(j2);
    }
}
