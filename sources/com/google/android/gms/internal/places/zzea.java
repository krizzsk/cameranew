package com.google.android.gms.internal.places;

import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzea {
    private static final zzec zzni;

    static {
        zzec zzebVar;
        if ((zzdy.zzdl() && zzdy.zzdm()) && !zzp.zzy()) {
            zzebVar = new zzed();
        } else {
            zzebVar = new zzeb();
        }
        zzni = zzebVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzao(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new zzee(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        long j2 = i4 + IjkMediaMeta.AV_CH_WIDE_RIGHT;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    public static boolean zze(byte[] bArr) {
        return zzni.zzf(bArr, 0, bArr.length);
    }

    public static boolean zzf(byte[] bArr, int i2, int i3) {
        return zzni.zzf(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzg(byte[] bArr, int i2, int i3) {
        byte b = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return zzd(b, bArr[i2], bArr[i2 + 1]);
                }
                throw new AssertionError();
            }
            return zzs(b, bArr[i2]);
        }
        return zzao(b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzh(byte[] bArr, int i2, int i3) throws zzbk {
        return zzni.zzh(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzs(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return zzni.zzc(charSequence, bArr, i2, i3);
    }
}
