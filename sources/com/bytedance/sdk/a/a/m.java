package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSink.java */
/* loaded from: classes.dex */
public final class m implements d {
    public final c a = new c();
    public final r b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        Objects.requireNonNull(rVar, "sink == null");
        this.b = rVar;
    }

    @Override // com.bytedance.sdk.a.a.r
    public t a() {
        return this.b.a();
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a_(c cVar, long j2) throws IOException {
        if (!this.c) {
            this.a.a_(cVar, j2);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d b(String str) throws IOException {
        if (!this.c) {
            this.a.b(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c c() {
        return this.a;
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            c cVar = this.a;
            long j2 = cVar.b;
            if (j2 > 0) {
                this.b.a_(cVar, j2);
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
            u.a(th);
        }
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        if (!this.c) {
            c cVar = this.a;
            long j2 = cVar.b;
            if (j2 > 0) {
                this.b.a_(cVar, j2);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d g(int i2) throws IOException {
        if (!this.c) {
            this.a.g(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d h(int i2) throws IOException {
        if (!this.c) {
            this.a.h(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d i(int i2) throws IOException {
        if (!this.c) {
            this.a.i(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.bytedance.sdk.a.a.d
    public d k(long j2) throws IOException {
        if (!this.c) {
            this.a.k(j2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d l(long j2) throws IOException {
        if (!this.c) {
            this.a.l(j2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // com.bytedance.sdk.a.a.d
    public d u() throws IOException {
        if (!this.c) {
            long g2 = this.a.g();
            if (g2 > 0) {
                this.b.a_(this.a, g2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.c) {
            int write = this.a.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.c) {
            this.a.c(bArr);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d c(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.c) {
            this.a.c(bArr, i2, i3);
            return u();
        }
        throw new IllegalStateException("closed");
    }
}
