package com.tapjoy.internal;

import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public final class jx {
    public static long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
    }
}
