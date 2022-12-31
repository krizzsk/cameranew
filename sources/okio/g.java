package okio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: classes3.dex */
public final class g implements d {
    public final b a = new b();
    public final j b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(j jVar) {
        Objects.requireNonNull(jVar, "source == null");
        this.b = jVar;
    }

    @Override // okio.d
    public b F() {
        return this.a;
    }

    @Override // okio.d
    public long H(ByteString byteString) throws IOException {
        return d(byteString, 0L);
    }

    @Override // okio.d
    public int P(f fVar) throws IOException {
        if (!this.c) {
            do {
                int W = this.a.W(fVar, true);
                if (W == -1) {
                    return -1;
                }
                if (W != -2) {
                    this.a.X(fVar.a[W].size());
                    return W;
                }
            } while (this.b.r(this.a, 8192L) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public long a(ByteString byteString, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long x = this.a.x(byteString, j2);
            if (x != -1) {
                return x;
            }
            b bVar = this.a;
            long j3 = bVar.b;
            if (this.b.r(bVar, 8192L) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (j3 - byteString.size()) + 1);
        }
    }

    @Override // okio.j, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.d();
    }

    public long d(ByteString byteString, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long y = this.a.y(byteString, j2);
            if (y != -1) {
                return y;
            }
            b bVar = this.a;
            long j3 = bVar.b;
            if (this.b.r(bVar, 8192L) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, j3);
        }
    }

    @Override // okio.d
    public long g(ByteString byteString) throws IOException {
        return a(byteString, 0L);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // okio.j
    public long r(b bVar, long j2) throws IOException {
        if (bVar != null) {
            if (j2 >= 0) {
                if (!this.c) {
                    b bVar2 = this.a;
                    if (bVar2.b == 0 && this.b.r(bVar2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.a.r(bVar, Math.min(j2, this.a.b));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        b bVar = this.a;
        if (bVar.b == 0 && this.b.r(bVar, 8192L) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    @Override // okio.d
    public boolean request(long j2) throws IOException {
        b bVar;
        if (j2 >= 0) {
            if (!this.c) {
                do {
                    bVar = this.a;
                    if (bVar.b >= j2) {
                        return true;
                    }
                } while (this.b.r(bVar, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j2);
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
