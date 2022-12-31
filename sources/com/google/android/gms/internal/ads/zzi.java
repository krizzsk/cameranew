package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> zza(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> zza = zza(randomAccessFile, 0);
        return zza != null ? zza : zza(randomAccessFile, 65535);
    }

    private static long zzb(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getInt(i2) & 4294967295L;
    }

    public static long zzc(ByteBuffer byteBuffer) {
        zze(byteBuffer);
        return zzb(byteBuffer, byteBuffer.position() + 16);
    }

    public static long zzd(ByteBuffer byteBuffer) {
        zze(byteBuffer);
        return zzb(byteBuffer, byteBuffer.position() + 12);
    }

    private static void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static Pair<ByteBuffer, Long> zza(RandomAccessFile randomAccessFile, int i2) throws IOException {
        int i3;
        if (i2 >= 0 && i2 <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            zze(allocate);
            int capacity2 = allocate.capacity();
            if (capacity2 >= 22) {
                int i4 = capacity2 - 22;
                int min = Math.min(i4, 65535);
                for (int i5 = 0; i5 < min; i5++) {
                    i3 = i4 - i5;
                    if (allocate.getInt(i3) == 101010256 && (allocate.getShort(i3 + 20) & 65535) == i5) {
                        break;
                    }
                }
            }
            i3 = -1;
            if (i3 == -1) {
                return null;
            }
            allocate.position(i3);
            ByteBuffer slice = allocate.slice();
            slice.order(ByteOrder.LITTLE_ENDIAN);
            return Pair.create(slice, Long.valueOf(capacity + i3));
        }
        StringBuilder sb = new StringBuilder(27);
        sb.append("maxCommentSize: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void zza(ByteBuffer byteBuffer, long j2) {
        zze(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j2 >= 0 && j2 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + position, (int) j2);
            return;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("uint32 value of out range: ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }
}
