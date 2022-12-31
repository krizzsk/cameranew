package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzki {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzb(byte b) {
        return b < -32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(byte b, byte b2, char[] cArr, int i2) throws zzic {
        if (b < -62 || zzg(b2)) {
            throw zzic.zzf();
        }
        cArr[i2] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzd(byte b) {
        return b < -16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(byte b, byte b2, byte b3, char[] cArr, int i2) throws zzic {
        if (!zzg(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zzg(b3)) {
                cArr[i2] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
                return;
            }
        }
        throw zzic.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(byte b, byte b2, byte b3, byte b4, char[] cArr, int i2) throws zzic {
        if (zzg(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || zzg(b3) || zzg(b4)) {
            throw zzic.zzf();
        }
        int i3 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i2] = (char) ((i3 >>> 10) + 55232);
        cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
    }

    private static boolean zzg(byte b) {
        return b > -65;
    }
}
