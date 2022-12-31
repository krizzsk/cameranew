package us.pinguo.common.pgdownloader.core;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.s;
/* compiled from: InputStreamWithLength.kt */
/* loaded from: classes4.dex */
public final class InputStreamWithLength extends InputStream {
    private final int length;
    private final InputStream stream;

    public InputStreamWithLength(InputStream stream, int i2) {
        s.h(stream, "stream");
        this.stream = stream;
        this.length = i2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    public final int getLength() {
        return this.length;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.stream.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.stream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.stream.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.stream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        return this.stream.skip(j2);
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer) throws IOException {
        s.h(buffer, "buffer");
        return this.stream.read(buffer);
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer, int i2, int i3) throws IOException {
        s.h(buffer, "buffer");
        return this.stream.read(buffer, i2, i3);
    }
}
