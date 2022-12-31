package com.facebook.common.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: ByteStreams.java */
/* loaded from: classes.dex */
public final class a {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        h.g(inputStream);
        h.g(outputStream);
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

    public static int b(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        h.g(inputStream);
        h.g(bArr);
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                int read = inputStream.read(bArr, i2 + i4, i3 - i4);
                if (read == -1) {
                    break;
                }
                i4 += read;
            }
            return i4;
        }
        throw new IndexOutOfBoundsException("len is negative");
    }
}
