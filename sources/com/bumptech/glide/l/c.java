package com.bumptech.glide.l;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class c extends InputStream {
    private static final Queue<c> c = h.c(0);
    private InputStream a;
    private IOException b;

    c() {
    }

    public static c e(InputStream inputStream) {
        c poll;
        Queue<c> queue = c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.u(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public IOException d() {
        return this.b;
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
    public int read(byte[] bArr) throws IOException {
        try {
            return this.a.read(bArr);
        } catch (IOException e2) {
            this.b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        try {
            return this.a.skip(j2);
        } catch (IOException e2) {
            this.b = e2;
            return 0L;
        }
    }

    public void t() {
        this.b = null;
        this.a = null;
        Queue<c> queue = c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    void u(InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.a.read();
        } catch (IOException e2) {
            this.b = e2;
            return -1;
        }
    }
}
