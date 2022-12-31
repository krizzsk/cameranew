package com.facebook.common.memory;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: PooledByteStreams.java */
/* loaded from: classes.dex */
public class i {
    private final int a;
    private final a b;

    public i(a aVar) {
        this(aVar, 16384);
    }

    public long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = this.b.get(this.a);
        long j2 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.a);
                if (read == -1) {
                    return j2;
                }
                outputStream.write(bArr, 0, read);
                j2 += read;
            } finally {
                this.b.release(bArr);
            }
        }
    }

    @VisibleForTesting
    public i(a aVar, int i2) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 > 0));
        this.a = i2;
        this.b = aVar;
    }
}
