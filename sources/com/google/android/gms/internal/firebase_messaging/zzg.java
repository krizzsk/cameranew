package com.google.android.gms.internal.firebase_messaging;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes2.dex */
public final class zzg {
    private static final OutputStream zza = new zze();

    public static byte[] zza(InputStream inputStream) throws IOException {
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
                    return zzc(arrayDeque, i3);
                }
                i4 += read;
                i3 += read;
            }
            long j2 = i2;
            long j3 = j2 + j2;
            i2 = j3 > 2147483647L ? Integer.MAX_VALUE : j3 < -2147483648L ? Integer.MIN_VALUE : (int) j3;
        }
        if (inputStream.read() == -1) {
            return zzc(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static InputStream zzb(InputStream inputStream, long j2) {
        return new zzf(inputStream, 1048577L);
    }

    private static byte[] zzc(Queue<byte[]> queue, int i2) {
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
