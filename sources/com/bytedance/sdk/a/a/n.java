package com.bytedance.sdk.a.a;

import androidx.core.location.LocationRequestCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
public final class n implements e {
    public final c a = new c();
    public final s b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s sVar) {
        Objects.requireNonNull(sVar, "source == null");
        this.b = sVar;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j2) throws IOException {
        if (cVar != null) {
            if (j2 >= 0) {
                if (!this.c) {
                    c cVar2 = this.a;
                    if (cVar2.b == 0 && this.b.a(cVar2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.a.a(cVar, Math.min(j2, this.a.b));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public boolean b(long j2) throws IOException {
        c cVar;
        if (j2 >= 0) {
            if (!this.c) {
                do {
                    cVar = this.a;
                    if (cVar.b >= j2) {
                        return true;
                    }
                } while (this.b.a(cVar, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j2);
    }

    @Override // com.bytedance.sdk.a.a.e
    public c c() {
        return this.a;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.r();
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.a.e() && this.b.a(this.a, 8192L) == -1;
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream f() {
        return new InputStream() { // from class: com.bytedance.sdk.a.a.n.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                n nVar = n.this;
                if (!nVar.c) {
                    return (int) Math.min(nVar.a.b, 2147483647L);
                }
                throw new IOException("closed");
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                n.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                n nVar = n.this;
                if (!nVar.c) {
                    c cVar = nVar.a;
                    if (cVar.b == 0 && nVar.b.a(cVar, 8192L) == -1) {
                        return -1;
                    }
                    return n.this.a.h() & Draft_75.END_OF_FRAME;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return n.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (!n.this.c) {
                    u.a(bArr.length, i2, i3);
                    n nVar = n.this;
                    c cVar = nVar.a;
                    if (cVar.b == 0 && nVar.b.a(cVar, 8192L) == -1) {
                        return -1;
                    }
                    return n.this.a.a(bArr, i2, i3);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] g(long j2) throws IOException {
        a(j2);
        return this.a.g(j2);
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte h() throws IOException {
        a(1L);
        return this.a.h();
    }

    @Override // com.bytedance.sdk.a.a.e
    public short i() throws IOException {
        a(2L);
        return this.a.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() throws IOException {
        a(4L);
        return this.a.j();
    }

    @Override // com.bytedance.sdk.a.a.e
    public short k() throws IOException {
        a(2L);
        return this.a.k();
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() throws IOException {
        a(4L);
        return this.a.l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // com.bytedance.sdk.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long m() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.a(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.b(r3)
            if (r3 == 0) goto L4a
            com.bytedance.sdk.a.a.c r3 = r6.a
            long r4 = (long) r1
            byte r3 = r3.b(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            com.bytedance.sdk.a.a.c r0 = r6.a
            long r0 = r0.m()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.a.n.m():long");
    }

    @Override // com.bytedance.sdk.a.a.e
    public String p() throws IOException {
        return e(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.a;
        if (cVar.b == 0 && this.b.a(cVar, 8192L) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // com.bytedance.sdk.a.a.e
    public f c(long j2) throws IOException {
        a(j2);
        return this.a.c(j2);
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j2 > 0) {
            c cVar = this.a;
            if (cVar.b == 0 && this.b.a(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, this.a.b());
            this.a.h(min);
            j2 -= min;
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public String e(long j2) throws IOException {
        if (j2 >= 0) {
            long j3 = j2 == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j2 + 1;
            long a = a((byte) 10, 0L, j3);
            if (a != -1) {
                return this.a.f(a);
            }
            if (j3 < LocationRequestCompat.PASSIVE_INTERVAL && b(j3) && this.a.b(j3 - 1) == 13 && b(1 + j3) && this.a.b(j3) == 10) {
                return this.a.f(j3);
            }
            c cVar = new c();
            c cVar2 = this.a;
            cVar2.a(cVar, 0L, Math.min(32L, cVar2.b()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.a.b(), j2) + " content=" + cVar.n().e() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j2);
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j2) throws IOException {
        if (!b(j2)) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.a.a(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.a;
                long j2 = cVar.b;
                if (j2 > 0) {
                    int a = cVar.a(bArr, i2, (int) j2);
                    if (a == -1) {
                        throw new AssertionError();
                    }
                    i2 += a;
                } else {
                    throw e2;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public long a(byte b) throws IOException {
        return a(b, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long a(byte b, long j2, long j3) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j2), Long.valueOf(j3)));
        }
        while (j2 < j3) {
            long a = this.a.a(b, j2, j3);
            if (a == -1) {
                c cVar = this.a;
                long j4 = cVar.b;
                if (j4 >= j3 || this.b.a(cVar, 8192L) == -1) {
                    break;
                }
                j2 = Math.max(j2, j4);
            } else {
                return a;
            }
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.b.a();
    }
}
