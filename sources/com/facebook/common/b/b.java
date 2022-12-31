package com.facebook.common.b;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
/* compiled from: TailAppendingInputStream.java */
/* loaded from: classes.dex */
public class b extends FilterInputStream {
    private final byte[] a;
    private int b;
    private int c;

    public b(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        Objects.requireNonNull(inputStream);
        Objects.requireNonNull(bArr);
        this.a = bArr;
    }

    private int d() {
        int i2 = this.b;
        byte[] bArr = this.a;
        if (i2 >= bArr.length) {
            return -1;
        }
        this.b = i2 + 1;
        return bArr[i2] & Draft_75.END_OF_FRAME;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        if (((FilterInputStream) this).in.markSupported()) {
            super.mark(i2);
            this.c = this.b;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        return read != -1 ? read : d();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported()) {
            ((FilterInputStream) this).in.reset();
            this.b = this.c;
            return;
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i2, i3);
        if (read != -1) {
            return read;
        }
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        while (i4 < i3) {
            int d2 = d();
            if (d2 == -1) {
                break;
            }
            bArr[i2 + i4] = (byte) d2;
            i4++;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }
}
