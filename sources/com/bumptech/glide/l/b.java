package com.bumptech.glide.l;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class b extends FilterInputStream {
    private final long a;
    private int b;

    b(InputStream inputStream, long j2) {
        super(inputStream);
        this.a = j2;
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.b += i2;
        } else if (this.a - this.b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
        }
        return i2;
    }

    public static InputStream d(InputStream inputStream, long j2) {
        return new b(inputStream, j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.a - this.b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int read;
        read = super.read(bArr, i2, i3);
        a(read);
        return read;
    }
}
