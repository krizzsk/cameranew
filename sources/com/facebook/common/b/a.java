package com.facebook.common.b;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
/* compiled from: LimitedInputStream.java */
/* loaded from: classes.dex */
public class a extends FilterInputStream {
    private int a;
    private int b;

    public a(InputStream inputStream, int i2) {
        super(inputStream);
        Objects.requireNonNull(inputStream);
        if (i2 >= 0) {
            this.a = i2;
            this.b = -1;
            return;
        }
        throw new IllegalArgumentException("limit must be >= 0");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(((FilterInputStream) this).in.available(), this.a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        if (((FilterInputStream) this).in.markSupported()) {
            ((FilterInputStream) this).in.mark(i2);
            this.b = this.a;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.a == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.a--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported()) {
            if (this.b != -1) {
                ((FilterInputStream) this).in.reset();
                this.a = this.b;
                return;
            }
            throw new IOException("mark not set");
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long skip = ((FilterInputStream) this).in.skip(Math.min(j2, this.a));
        this.a = (int) (this.a - skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.a;
        if (i4 == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i2, Math.min(i3, i4));
        if (read > 0) {
            this.a -= read;
        }
        return read;
    }
}
