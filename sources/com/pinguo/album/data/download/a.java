package com.pinguo.album.data.download;

import java.io.IOException;
import java.io.InputStream;
/* compiled from: ContentInputStream.java */
/* loaded from: classes3.dex */
public class a extends InputStream {
    private final InputStream a;
    private final int b;

    public a(InputStream inputStream, int i2) {
        this.a = inputStream;
        this.b = i2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.a.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.a.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        return this.a.skip(j2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.a.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.a.read(bArr, i2, i3);
    }
}
