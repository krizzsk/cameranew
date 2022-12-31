package com.google.android.gms.internal.ads;

import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzsa {
    public static void zza(String[] strArr, int i2, int i3, PriorityQueue<zzsd> priorityQueue) {
        if (strArr.length < i3) {
            zza(i2, zzb(strArr, 0, strArr.length), zza(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long zzb = zzb(strArr, 0, i3);
        zza(i2, zzb, zza(strArr, 0, i3), i3, priorityQueue);
        long zza = zza(16785407L, i3 - 1);
        for (int i4 = 1; i4 < (strArr.length - i3) + 1; i4++) {
            long j2 = zzb + 1073807359;
            zzb = (((((j2 - ((((zzrz.zzbr(strArr[i4 - 1]) + 2147483647L) % 1073807359) * zza) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((zzrz.zzbr(strArr[(i4 + i3) - 1]) + 2147483647L) % 1073807359)) % 1073807359;
            zza(i2, zzb, zza(strArr, i4, i3), strArr.length, priorityQueue);
        }
    }

    private static long zzb(String[] strArr, int i2, int i3) {
        long zzbr = (zzrz.zzbr(strArr[0]) + 2147483647L) % 1073807359;
        for (int i4 = 1; i4 < i3; i4++) {
            zzbr = (((zzbr * 16785407) % 1073807359) + ((zzrz.zzbr(strArr[i4]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzbr;
    }

    private static void zza(int i2, long j2, String str, int i3, PriorityQueue<zzsd> priorityQueue) {
        zzsd zzsdVar = new zzsd(j2, str, i3);
        if ((priorityQueue.size() != i2 || (priorityQueue.peek().zzbuc <= zzsdVar.zzbuc && priorityQueue.peek().value <= zzsdVar.value)) && !priorityQueue.contains(zzsdVar)) {
            priorityQueue.add(zzsdVar);
            if (priorityQueue.size() > i2) {
                priorityQueue.poll();
            }
        }
    }

    private static String zza(String[] strArr, int i2, int i3) {
        int i4 = i3 + i2;
        if (strArr.length < i4) {
            zzazk.zzev("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i5 = i4 - 1;
            if (i2 < i5) {
                sb.append(strArr[i2]);
                sb.append(' ');
                i2++;
            } else {
                sb.append(strArr[i5]);
                return sb.toString();
            }
        }
    }

    private static long zza(long j2, int i2) {
        if (i2 == 0) {
            return 1L;
        }
        if (i2 == 1) {
            return j2;
        }
        if (i2 % 2 == 0) {
            return zza((j2 * j2) % 1073807359, i2 / 2) % 1073807359;
        }
        return (j2 * (zza((j2 * j2) % 1073807359, i2 / 2) % 1073807359)) % 1073807359;
    }
}
