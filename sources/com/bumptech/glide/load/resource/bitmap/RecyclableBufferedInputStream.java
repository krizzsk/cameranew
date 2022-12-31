package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f775d;

    /* renamed from: e  reason: collision with root package name */
    private int f776e;

    /* loaded from: classes.dex */
    public static class InvalidMarkException extends RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f775d = -1;
        if (bArr != null && bArr.length != 0) {
            this.a = bArr;
            return;
        }
        throw new IllegalArgumentException("buffer is null or empty");
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f775d;
        if (i2 != -1) {
            int i3 = this.f776e - i2;
            int i4 = this.c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    if (Log.isLoggable("BufferedIs", 3)) {
                        Log.d("BufferedIs", "allocate buffer of length: " + i4);
                    }
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                    bArr = bArr2;
                } else if (i2 > 0) {
                    System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
                }
                int i5 = this.f776e - this.f775d;
                this.f776e = i5;
                this.f775d = 0;
                this.b = 0;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.f776e;
                if (read > 0) {
                    i6 += read;
                }
                this.b = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f775d = -1;
            this.f776e = 0;
            this.b = read2;
        }
        return read2;
    }

    private static IOException t() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.a != null && inputStream != null) {
        } else {
            t();
            throw null;
        }
        return (this.b - this.f776e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a = null;
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void d() {
        this.c = this.a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.c = Math.max(this.c, i2);
        this.f775d = this.f776e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f776e < this.b || a(inputStream, bArr) != -1) {
                if (bArr != this.a && (bArr = this.a) == null) {
                    t();
                    throw null;
                }
                int i2 = this.b;
                int i3 = this.f776e;
                if (i2 - i3 > 0) {
                    this.f776e = i3 + 1;
                    return bArr[i3] & Draft_75.END_OF_FRAME;
                }
                return -1;
            }
            return -1;
        }
        t();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.a != null) {
            int i2 = this.f775d;
            if (-1 != i2) {
                this.f776e = i2;
            } else {
                throw new InvalidMarkException("Mark has been invalidated");
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null) {
            t();
            throw null;
        } else if (j2 < 1) {
            return 0L;
        } else {
            if (inputStream != null) {
                int i2 = this.b;
                int i3 = this.f776e;
                if (i2 - i3 >= j2) {
                    this.f776e = (int) (i3 + j2);
                    return j2;
                }
                long j3 = i2 - i3;
                this.f776e = i2;
                if (this.f775d != -1 && j2 <= this.c) {
                    if (a(inputStream, bArr) == -1) {
                        return j3;
                    }
                    int i4 = this.b;
                    int i5 = this.f776e;
                    long j4 = j2 - j3;
                    if (i4 - i5 >= j4) {
                        this.f776e = (int) (i5 + j4);
                        return j2;
                    }
                    long j5 = (j3 + i4) - i5;
                    this.f776e = i4;
                    return j5;
                }
                return j3 + inputStream.skip(j2 - j3);
            }
            t();
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            t();
            throw null;
        } else if (i3 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i6 = this.f776e;
                int i7 = this.b;
                if (i6 < i7) {
                    int i8 = i7 - i6 >= i3 ? i3 : i7 - i6;
                    System.arraycopy(bArr2, i6, bArr, i2, i8);
                    this.f776e += i8;
                    if (i8 == i3 || inputStream.available() == 0) {
                        return i8;
                    }
                    i2 += i8;
                    i4 = i3 - i8;
                } else {
                    i4 = i3;
                }
                while (true) {
                    if (this.f775d == -1 && i4 >= bArr2.length) {
                        i5 = inputStream.read(bArr, i2, i4);
                        if (i5 == -1) {
                            return i4 != i3 ? i3 - i4 : -1;
                        }
                    } else if (a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    } else {
                        if (bArr2 != this.a && (bArr2 = this.a) == null) {
                            t();
                            throw null;
                        }
                        int i9 = this.b;
                        int i10 = this.f776e;
                        i5 = i9 - i10 >= i4 ? i4 : i9 - i10;
                        System.arraycopy(bArr2, i10, bArr, i2, i5);
                        this.f776e += i5;
                    }
                    i4 -= i5;
                    if (i4 == 0) {
                        return i3;
                    }
                    if (inputStream.available() == 0) {
                        return i3 - i4;
                    }
                    i2 += i5;
                }
            } else {
                t();
                throw null;
            }
        }
    }
}
