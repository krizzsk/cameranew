package com.bumptech.glide.l;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class f extends FilterInputStream {
    private int a;

    public f(InputStream inputStream) {
        super(inputStream);
        this.a = Integer.MIN_VALUE;
    }

    private long i(long j2) {
        int i2 = this.a;
        if (i2 == 0) {
            return -1L;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : i2;
    }

    private void j(long j2) {
        int i2 = this.a;
        if (i2 == Integer.MIN_VALUE || j2 == -1) {
            return;
        }
        this.a = (int) (i2 - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i2 = this.a;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        super.mark(i2);
        this.a = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (i(1L) == -1) {
            return -1;
        }
        int read = super.read();
        j(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long i2 = i(j2);
        if (i2 == -1) {
            return -1L;
        }
        long skip = super.skip(i2);
        j(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = (int) i(i3);
        if (i4 == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, i4);
        j(read);
        return read;
    }
}
