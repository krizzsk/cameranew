package com.facebook.common.memory;

import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
/* compiled from: PooledByteBufferInputStream.java */
@NotThreadSafe
/* loaded from: classes.dex */
public class g extends InputStream {
    @VisibleForTesting
    final PooledByteBuffer a;
    @VisibleForTesting
    int b;
    @VisibleForTesting
    int c;

    public g(PooledByteBuffer pooledByteBuffer) {
        com.facebook.common.internal.h.b(Boolean.valueOf(!pooledByteBuffer.isClosed()));
        com.facebook.common.internal.h.g(pooledByteBuffer);
        this.a = pooledByteBuffer;
        this.b = 0;
        this.c = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.size() - this.b;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.c = this.b;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        return pooledByteBuffer.D(i2) & Draft_75.END_OF_FRAME;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.b = this.c;
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        com.facebook.common.internal.h.b(Boolean.valueOf(j2 >= 0));
        int min = Math.min((int) j2, available());
        this.b += min;
        return min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length) {
            int available = available();
            if (available <= 0) {
                return -1;
            }
            if (i3 <= 0) {
                return 0;
            }
            int min = Math.min(available, i3);
            this.a.b(this.b, bArr, i2, min);
            this.b += min;
            return min;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i2 + "; regionLength=" + i3);
    }
}
