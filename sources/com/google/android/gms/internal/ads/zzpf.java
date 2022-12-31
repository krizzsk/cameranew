package com.google.android.gms.internal.ads;

import android.util.Pair;
import us.pinguo.paylibcenter.bean.PayResult;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzpf {
    private static final byte[] zzbjt = {0, 0, 0, 1};
    private static final int[] zzbju = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, PayResult.PAY_RESULT_ALIPAY_CHECK_IN, 7350};
    private static final int[] zzbjv = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int zza(zzpo zzpoVar) {
        int zzbl = zzpoVar.zzbl(5);
        return zzbl == 31 ? zzpoVar.zzbl(6) + 32 : zzbl;
    }

    private static int zzb(zzpo zzpoVar) {
        int zzbl = zzpoVar.zzbl(4);
        if (zzbl == 15) {
            return zzpoVar.zzbl(24);
        }
        zzpg.checkArgument(zzbl < 13);
        return zzbju[zzbl];
    }

    public static byte[] zzc(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = zzbjt;
        byte[] bArr3 = new byte[bArr2.length + i3];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    public static Pair<Integer, Integer> zze(byte[] bArr) {
        zzpo zzpoVar = new zzpo(bArr);
        int zza = zza(zzpoVar);
        int zzb = zzb(zzpoVar);
        int zzbl = zzpoVar.zzbl(4);
        if (zza == 5 || zza == 29) {
            zzb = zzb(zzpoVar);
            if (zza(zzpoVar) == 22) {
                zzbl = zzpoVar.zzbl(4);
            }
        }
        int i2 = zzbjv[zzbl];
        zzpg.checkArgument(i2 != -1);
        return Pair.create(Integer.valueOf(zzb), Integer.valueOf(i2));
    }
}
