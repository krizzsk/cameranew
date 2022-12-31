package com.bumptech.glide.g;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
class b implements Closeable {
    private final InputStream a;
    private final Charset b;
    private byte[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f652d;

    /* renamed from: e  reason: collision with root package name */
    private int f653e;

    /* compiled from: StrictLineReader.java */
    /* loaded from: classes.dex */
    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
                i2--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void d() throws IOException {
        InputStream inputStream = this.a;
        byte[] bArr = this.c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f652d = 0;
            this.f653e = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.a) {
            if (this.c != null) {
                this.c = null;
                this.a.close();
            }
        }
    }

    public boolean t() {
        return this.f653e == -1;
    }

    public String v() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.a) {
            if (this.c != null) {
                if (this.f652d >= this.f653e) {
                    d();
                }
                for (int i4 = this.f652d; i4 != this.f653e; i4++) {
                    byte[] bArr2 = this.c;
                    if (bArr2[i4] == 10) {
                        if (i4 != this.f652d) {
                            i3 = i4 - 1;
                            if (bArr2[i3] == 13) {
                                byte[] bArr3 = this.c;
                                int i5 = this.f652d;
                                String str = new String(bArr3, i5, i3 - i5, this.b.name());
                                this.f652d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        byte[] bArr32 = this.c;
                        int i52 = this.f652d;
                        String str2 = new String(bArr32, i52, i3 - i52, this.b.name());
                        this.f652d = i4 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f653e - this.f652d) + 80);
                loop1: while (true) {
                    byte[] bArr4 = this.c;
                    int i6 = this.f652d;
                    aVar.write(bArr4, i6, this.f653e - i6);
                    this.f653e = -1;
                    d();
                    i2 = this.f652d;
                    while (i2 != this.f653e) {
                        bArr = this.c;
                        if (bArr[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                int i7 = this.f652d;
                if (i2 != i7) {
                    aVar.write(bArr, i7, i2 - i7);
                }
                this.f652d = i2 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 >= 0) {
            if (charset.equals(c.a)) {
                this.a = inputStream;
                this.b = charset;
                this.c = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
