package com.google.android.gms.common.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class k {
    public static void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @Deprecated
    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        return e(inputStream, outputStream, false);
    }

    @Deprecated
    public static long c(InputStream inputStream, OutputStream outputStream, boolean z, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        long j2 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i2);
                if (read == -1) {
                    break;
                }
                j2 += read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    a(inputStream);
                    a(outputStream);
                }
            }
        }
        return j2;
    }

    @Deprecated
    public static byte[] d(InputStream inputStream, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    @Deprecated
    private static long e(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return c(inputStream, outputStream, z, 1024);
    }
}
