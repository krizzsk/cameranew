package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzein {
    private static void zza(byte[] bArr, long j2, int i2) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i2 + i3] = (byte) (255 & j2);
            i3++;
            j2 >>= 8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zze(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long zzg = zzg(bArr, 0, 0) & 67108863;
            int i2 = 3;
            long zzg2 = zzg(bArr, 3, 2) & 67108611;
            long zzg3 = zzg(bArr, 6, 4) & 67092735;
            long zzg4 = zzg(bArr, 9, 6) & 66076671;
            long zzg5 = zzg(bArr, 12, 8) & 1048575;
            long j2 = zzg2 * 5;
            long j3 = zzg3 * 5;
            long j4 = zzg4 * 5;
            long j5 = zzg5 * 5;
            int i3 = 17;
            byte[] bArr3 = new byte[17];
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            long j10 = 0;
            int i4 = 0;
            while (i4 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i4);
                System.arraycopy(bArr2, i4, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i3, (byte) 0);
                }
                long zzg6 = j10 + zzg(bArr3, 0, 0);
                long zzg7 = j6 + zzg(bArr3, i2, 2);
                long zzg8 = j7 + zzg(bArr3, 6, 4);
                long zzg9 = j8 + zzg(bArr3, 9, 6);
                long zzg10 = j9 + (zzg(bArr3, 12, 8) | (bArr3[16] << 24));
                long j11 = (zzg6 * zzg) + (zzg7 * j5) + (zzg8 * j4) + (zzg9 * j3) + (zzg10 * j2);
                long j12 = (zzg6 * zzg2) + (zzg7 * zzg) + (zzg8 * j5) + (zzg9 * j4) + (zzg10 * j3) + (j11 >> 26);
                long j13 = (zzg6 * zzg3) + (zzg7 * zzg2) + (zzg8 * zzg) + (zzg9 * j5) + (zzg10 * j4) + (j12 >> 26);
                long j14 = (zzg6 * zzg4) + (zzg7 * zzg3) + (zzg8 * zzg2) + (zzg9 * zzg) + (zzg10 * j5) + (j13 >> 26);
                long j15 = (zzg6 * zzg5) + (zzg7 * zzg4) + (zzg8 * zzg3) + (zzg9 * zzg2) + (zzg10 * zzg) + (j14 >> 26);
                long j16 = (j11 & 67108863) + ((j15 >> 26) * 5);
                j6 = (j12 & 67108863) + (j16 >> 26);
                i4 += 16;
                j7 = j13 & 67108863;
                j8 = j14 & 67108863;
                j9 = j15 & 67108863;
                i3 = 17;
                i2 = 3;
                j10 = j16 & 67108863;
            }
            long j17 = j7 + (j6 >> 26);
            long j18 = j17 & 67108863;
            long j19 = j8 + (j17 >> 26);
            long j20 = j19 & 67108863;
            long j21 = j9 + (j19 >> 26);
            long j22 = j21 & 67108863;
            long j23 = j10 + ((j21 >> 26) * 5);
            long j24 = j23 & 67108863;
            long j25 = (j6 & 67108863) + (j23 >> 26);
            long j26 = j24 + 5;
            long j27 = j26 & 67108863;
            long j28 = (j26 >> 26) + j25;
            long j29 = j18 + (j28 >> 26);
            long j30 = j20 + (j29 >> 26);
            long j31 = (j22 + (j30 >> 26)) - 67108864;
            long j32 = j31 >> 63;
            long j33 = ~j32;
            long j34 = (j24 & j32) | (j27 & j33);
            long j35 = (j25 & j32) | (j28 & 67108863 & j33);
            long j36 = (j18 & j32) | (j29 & 67108863 & j33);
            long j37 = (j20 & j32) | (j30 & 67108863 & j33);
            long j38 = ((j31 & j33) | (j22 & j32)) << 8;
            long zzg11 = (((j35 << 26) | j34) & 4294967295L) + zzg(bArr, 16);
            long j39 = zzg11 & 4294967295L;
            long zzg12 = (((j35 >> 6) | (j36 << 20)) & 4294967295L) + zzg(bArr, 20) + (zzg11 >> 32);
            long zzg13 = (((j36 >> 12) | (j37 << 14)) & 4294967295L) + zzg(bArr, 24) + (zzg12 >> 32);
            byte[] bArr4 = new byte[16];
            zza(bArr4, j39, 0);
            zza(bArr4, zzg12 & 4294967295L, 4);
            zza(bArr4, zzg13 & 4294967295L, 8);
            zza(bArr4, (((j38 | (j37 >> 18)) & 4294967295L) + zzg(bArr, 28) + (zzg13 >> 32)) & 4294967295L, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    private static long zzg(byte[] bArr, int i2) {
        return (((bArr[i2 + 3] & Draft_75.END_OF_FRAME) << 24) | (bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | ((bArr[i2 + 2] & Draft_75.END_OF_FRAME) << 16)) & 4294967295L;
    }

    private static long zzg(byte[] bArr, int i2, int i3) {
        return (zzg(bArr, i2) >> i3) & 67108863;
    }
}
