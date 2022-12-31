package com.google.android.gms.internal.measurement;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzgf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i2, zzge zzgeVar) {
        int i3 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzgeVar.zza = b;
            return i3;
        }
        return zzb(b, bArr, i3, zzgeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i2, byte[] bArr, int i3, zzge zzgeVar) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b = bArr[i3];
        if (b >= 0) {
            zzgeVar.zza = i4 | (b << 7);
            return i5;
        }
        int i6 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b2 = bArr[i5];
        if (b2 >= 0) {
            zzgeVar.zza = i6 | (b2 << 14);
            return i7;
        }
        int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b3 = bArr[i7];
        if (b3 >= 0) {
            zzgeVar.zza = i8 | (b3 << 21);
            return i9;
        }
        int i10 = i8 | ((b3 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b4 = bArr[i9];
        if (b4 >= 0) {
            zzgeVar.zza = i10 | (b4 << 28);
            return i11;
        }
        int i12 = i10 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzgeVar.zza = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i2, zzge zzgeVar) {
        byte b;
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            zzgeVar.zzb = j2;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (b & Byte.MAX_VALUE) << i5;
            b2 = bArr[i4];
            i4 = i6;
        }
        zzgeVar.zzb = j3;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & Draft_75.END_OF_FRAME) << 24) | (bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | ((bArr[i2 + 2] & Draft_75.END_OF_FRAME) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zze(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i2, zzge zzgeVar) throws zzic {
        int zza = zza(bArr, i2, zzgeVar);
        int i3 = zzgeVar.zza;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzgeVar.zzc = "";
                return zza;
            }
            zzgeVar.zzc = new String(bArr, zza, i3, zzia.zza);
            return zza + i3;
        }
        throw zzic.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i2, zzge zzgeVar) throws zzic {
        int zza = zza(bArr, i2, zzgeVar);
        int i3 = zzgeVar.zza;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzgeVar.zzc = "";
                return zza;
            }
            zzgeVar.zzc = zzkn.zze(bArr, zza, i3);
            return zza + i3;
        }
        throw zzic.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i2, zzge zzgeVar) throws zzic {
        int zza = zza(bArr, i2, zzgeVar);
        int i3 = zzgeVar.zza;
        if (i3 >= 0) {
            if (i3 <= bArr.length - zza) {
                if (i3 == 0) {
                    zzgeVar.zzc = zzgs.zzb;
                    return zza;
                }
                zzgeVar.zzc = zzgs.zzj(bArr, zza, i3);
                return zza + i3;
            }
            throw zzic.zza();
        }
        throw zzic.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(zzji zzjiVar, byte[] bArr, int i2, int i3, zzge zzgeVar) throws IOException {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = zzb(i5, bArr, i4, zzgeVar);
            i5 = zzgeVar.zza;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            Object zza = zzjiVar.zza();
            int i7 = i5 + i6;
            zzjiVar.zzh(zza, bArr, i6, i7, zzgeVar);
            zzjiVar.zzi(zza);
            zzgeVar.zzc = zza;
            return i7;
        }
        throw zzic.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(zzji zzjiVar, byte[] bArr, int i2, int i3, int i4, zzge zzgeVar) throws IOException {
        zzja zzjaVar = (zzja) zzjiVar;
        Object zza = zzjaVar.zza();
        int zzg = zzjaVar.zzg(zza, bArr, i2, i3, i4, zzgeVar);
        zzjaVar.zzi(zza);
        zzgeVar.zzc = zza;
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i2, byte[] bArr, int i3, int i4, zzhz<?> zzhzVar, zzge zzgeVar) {
        zzht zzhtVar = (zzht) zzhzVar;
        int zza = zza(bArr, i3, zzgeVar);
        zzhtVar.zzh(zzgeVar.zza);
        while (zza < i4) {
            int zza2 = zza(bArr, zza, zzgeVar);
            if (i2 != zzgeVar.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzgeVar);
            zzhtVar.zzh(zzgeVar.zza);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(byte[] bArr, int i2, zzhz<?> zzhzVar, zzge zzgeVar) throws IOException {
        zzht zzhtVar = (zzht) zzhzVar;
        int zza = zza(bArr, i2, zzgeVar);
        int i3 = zzgeVar.zza + zza;
        while (zza < i3) {
            zza = zza(bArr, zza, zzgeVar);
            zzhtVar.zzh(zzgeVar.zza);
        }
        if (zza == i3) {
            return zza;
        }
        throw zzic.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(zzji<?> zzjiVar, int i2, byte[] bArr, int i3, int i4, zzhz<?> zzhzVar, zzge zzgeVar) throws IOException {
        int zzi = zzi(zzjiVar, bArr, i3, i4, zzgeVar);
        zzhzVar.add(zzgeVar.zzc);
        while (zzi < i4) {
            int zza = zza(bArr, zzi, zzgeVar);
            if (i2 != zzgeVar.zza) {
                break;
            }
            zzi = zzi(zzjiVar, bArr, zza, i4, zzgeVar);
            zzhzVar.add(zzgeVar.zzc);
        }
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(int i2, byte[] bArr, int i3, int i4, zzjx zzjxVar, zzge zzgeVar) throws zzic {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int zzc = zzc(bArr, i3, zzgeVar);
                zzjxVar.zzh(i2, Long.valueOf(zzgeVar.zzb));
                return zzc;
            } else if (i5 == 1) {
                zzjxVar.zzh(i2, Long.valueOf(zze(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int zza = zza(bArr, i3, zzgeVar);
                int i6 = zzgeVar.zza;
                if (i6 >= 0) {
                    if (i6 <= bArr.length - zza) {
                        if (i6 == 0) {
                            zzjxVar.zzh(i2, zzgs.zzb);
                        } else {
                            zzjxVar.zzh(i2, zzgs.zzj(bArr, zza, i6));
                        }
                        return zza + i6;
                    }
                    throw zzic.zza();
                }
                throw zzic.zzb();
            } else if (i5 != 3) {
                if (i5 == 5) {
                    zzjxVar.zzh(i2, Integer.valueOf(zzd(bArr, i3)));
                    return i3 + 4;
                }
                throw zzic.zzc();
            } else {
                int i7 = (i2 & (-8)) | 4;
                zzjx zzb = zzjx.zzb();
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int zza2 = zza(bArr, i3, zzgeVar);
                    int i9 = zzgeVar.zza;
                    if (i9 == i7) {
                        i8 = i9;
                        i3 = zza2;
                        break;
                    }
                    i8 = i9;
                    i3 = zzn(i9, bArr, zza2, i4, zzb, zzgeVar);
                }
                if (i3 <= i4 && i8 == i7) {
                    zzjxVar.zzh(i2, zzb);
                    return i3;
                }
                throw zzic.zze();
            }
        }
        throw zzic.zzc();
    }
}
