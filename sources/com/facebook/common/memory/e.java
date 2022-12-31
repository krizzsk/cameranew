package com.facebook.common.memory;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
/* compiled from: PooledByteArrayBufferedInputStream.java */
@NotThreadSafe
/* loaded from: classes.dex */
public class e extends InputStream {
    private final InputStream a;
    private final byte[] b;
    private final com.facebook.common.references.h<byte[]> c;

    /* renamed from: d  reason: collision with root package name */
    private int f2405d;

    /* renamed from: e  reason: collision with root package name */
    private int f2406e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2407f;

    public e(InputStream inputStream, byte[] bArr, com.facebook.common.references.h<byte[]> hVar) {
        com.facebook.common.internal.h.g(inputStream);
        this.a = inputStream;
        com.facebook.common.internal.h.g(bArr);
        this.b = bArr;
        com.facebook.common.internal.h.g(hVar);
        this.c = hVar;
        this.f2405d = 0;
        this.f2406e = 0;
        this.f2407f = false;
    }

    private boolean d() throws IOException {
        if (this.f2406e < this.f2405d) {
            return true;
        }
        int read = this.a.read(this.b);
        if (read <= 0) {
            return false;
        }
        this.f2405d = read;
        this.f2406e = 0;
        return true;
    }

    private void t() throws IOException {
        if (this.f2407f) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.h.i(this.f2406e <= this.f2405d);
        t();
        return (this.f2405d - this.f2406e) + this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f2407f) {
            return;
        }
        this.f2407f = true;
        this.c.release(this.b);
        super.close();
    }

    protected void finalize() throws Throwable {
        if (!this.f2407f) {
            com.facebook.common.logging.a.h("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.h.i(this.f2406e <= this.f2405d);
        t();
        if (d()) {
            byte[] bArr = this.b;
            int i2 = this.f2406e;
            this.f2406e = i2 + 1;
            return bArr[i2] & Draft_75.END_OF_FRAME;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        com.facebook.common.internal.h.i(this.f2406e <= this.f2405d);
        t();
        int i2 = this.f2405d;
        int i3 = this.f2406e;
        long j3 = i2 - i3;
        if (j3 >= j2) {
            this.f2406e = (int) (i3 + j2);
            return j2;
        }
        this.f2406e = i2;
        return j3 + this.a.skip(j2 - j3);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        com.facebook.common.internal.h.i(this.f2406e <= this.f2405d);
        t();
        if (d()) {
            int min = Math.min(this.f2405d - this.f2406e, i3);
            System.arraycopy(this.b, this.f2406e, bArr, i2, min);
            this.f2406e += min;
            return min;
        }
        return -1;
    }
}
