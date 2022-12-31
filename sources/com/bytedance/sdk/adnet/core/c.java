package com.bytedance.sdk.adnet.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* compiled from: ByteArrayPoolOutputStream.java */
/* loaded from: classes.dex */
class c extends ByteArrayOutputStream {
    private final b a;

    public c(b bVar, int i2) {
        this.a = bVar;
        ((ByteArrayOutputStream) this).buf = bVar.a(Math.max(i2, 256));
    }

    private void a(int i2) {
        int i3 = ((ByteArrayOutputStream) this).count;
        if (i3 + i2 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] a = this.a.a((i3 + i2) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a, 0, ((ByteArrayOutputStream) this).count);
        this.a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = a;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.a.a(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) {
        a(i3);
        super.write(bArr, i2, i3);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i2) {
        a(1);
        super.write(i2);
    }
}
