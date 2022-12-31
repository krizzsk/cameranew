package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdyc {
    private static final OutputStream zzhyt = new zzdyf();

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        zzdwl.checkNotNull(inputStream);
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int i2 = 8192;
        int i3 = 0;
        while (i3 < 2147483639) {
            int min = Math.min(i2, 2147483639 - i3);
            byte[] bArr = new byte[min];
            arrayDeque.add(bArr);
            int i4 = 0;
            while (i4 < min) {
                int read = inputStream.read(bArr, i4, min - i4);
                if (read == -1) {
                    return zza(arrayDeque, i3);
                }
                i4 += read;
                i3 += read;
            }
            i2 = zzdyh.zzy(i2, 2);
        }
        if (inputStream.read() == -1) {
            return zza(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] zza(Queue<byte[]> queue, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = i2;
        while (i3 > 0) {
            byte[] remove = queue.remove();
            int min = Math.min(i3, remove.length);
            System.arraycopy(remove, 0, bArr, i2 - i3, min);
            i3 -= min;
        }
        return bArr;
    }
}
