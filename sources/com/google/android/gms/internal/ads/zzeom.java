package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeom {
    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b, char[] cArr, int i2) {
        cArr[i2] = (char) b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(byte b) {
        return b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzf(byte b) {
        return b < -32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzg(byte b) {
        return b < -16;
    }

    private static boolean zzh(byte b) {
        return b > -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b, byte b2, char[] cArr, int i2) throws zzelo {
        if (b >= -62 && !zzh(b2)) {
            cArr[i2] = (char) (((b & 31) << 6) | (b2 & 63));
            return;
        }
        throw zzelo.zzbji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b, byte b2, byte b3, char[] cArr, int i2) throws zzelo {
        if (!zzh(b2) && ((b != -32 || b2 >= -96) && ((b != -19 || b2 < -96) && !zzh(b3)))) {
            cArr[i2] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
            return;
        }
        throw zzelo.zzbji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i2) throws zzelo {
        if (!zzh(b2) && (((b << 28) + (b2 + 112)) >> 30) == 0 && !zzh(b3) && !zzh(b4)) {
            int i3 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
            cArr[i2] = (char) ((i3 >>> 10) + 55232);
            cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
            return;
        }
        throw zzelo.zzbji();
    }
}
