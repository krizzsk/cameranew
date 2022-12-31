package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: CountingOutputStream.java */
/* loaded from: classes.dex */
public class c extends FilterOutputStream {
    private long a;

    public c(OutputStream outputStream) {
        super(outputStream);
        this.a = 0L;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    public long d() {
        return this.a;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
        this.a += i3;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2);
        this.a++;
    }
}
