package com.tapjoy.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class iw implements is {
    public final ir a = new ir();
    public final jb b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public iw(jb jbVar) {
        if (jbVar != null) {
            this.b = jbVar;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.tapjoy.internal.jb
    public final void a(ir irVar, long j2) {
        if (!this.c) {
            this.a.a(irVar, j2);
            b();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is b(iu iuVar) {
        if (!this.c) {
            this.a.b(iuVar);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.jb, java.io.Closeable, java.lang.AutoCloseable, com.tapjoy.internal.jc
    public final void close() {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            ir irVar = this.a;
            long j2 = irVar.b;
            if (j2 > 0) {
                this.b.a(irVar, j2);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            je.a(th);
        }
    }

    @Override // com.tapjoy.internal.is
    public final is d(int i2) {
        if (!this.c) {
            this.a.d(i2);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is e(int i2) {
        if (!this.c) {
            this.a.e(i2);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is f(long j2) {
        if (!this.c) {
            this.a.f(j2);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.jb, java.io.Flushable
    public final void flush() {
        if (!this.c) {
            ir irVar = this.a;
            long j2 = irVar.b;
            if (j2 > 0) {
                this.b.a(irVar, j2);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // com.tapjoy.internal.is
    public final is a() {
        if (!this.c) {
            ir irVar = this.a;
            long j2 = irVar.b;
            if (j2 > 0) {
                this.b.a(irVar, j2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is b(String str) {
        if (!this.c) {
            this.a.b(str);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    private is b() {
        int i2;
        if (!this.c) {
            ir irVar = this.a;
            long j2 = irVar.b;
            if (j2 == 0) {
                j2 = 0;
            } else {
                iy iyVar = irVar.a.f7736g;
                if (iyVar.c < 8192 && iyVar.f7734e) {
                    j2 -= i2 - iyVar.b;
                }
            }
            if (j2 > 0) {
                this.b.a(irVar, j2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
