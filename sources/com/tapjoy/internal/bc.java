package com.tapjoy.internal;

import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class bc extends FilterInputStream {
    public bc(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int read = super.read(bArr, i2 + i4, i3 - i4);
            if (read == -1) {
                if (i4 != 0) {
                    return i4;
                }
                return -1;
            }
            i4 += read;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) {
        long j3 = 0;
        while (j3 < j2) {
            long skip = super.skip(j2 - j3);
            if (skip == 0) {
                if (super.read() < 0) {
                    break;
                }
                skip++;
            }
            j3 += skip;
        }
        return j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = super.read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                if (i2 != 0) {
                    return i2;
                }
                return -1;
            }
            i2 += read;
        }
        return i2;
    }
}
