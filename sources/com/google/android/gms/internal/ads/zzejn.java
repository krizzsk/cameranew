package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzejn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i2, zzejm zzejmVar) {
        int i3 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzejmVar.zzils = b;
            return i3;
        }
        return zza(b, bArr, i3, zzejmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i2, zzejm zzejmVar) {
        byte b;
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            zzejmVar.zzilt = j2;
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
        zzejmVar.zzilt = j3;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i2, zzejm zzejmVar) throws zzelo {
        int zza = zza(bArr, i2, zzejmVar);
        int i3 = zzejmVar.zzils;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzejmVar.zzilu = "";
                return zza;
            }
            zzejmVar.zzilu = new String(bArr, zza, i3, zzeld.UTF_8);
            return zza + i3;
        }
        throw zzelo.zzbjb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i2, zzejm zzejmVar) throws zzelo {
        int zza = zza(bArr, i2, zzejmVar);
        int i3 = zzejmVar.zzils;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzejmVar.zzilu = "";
                return zza;
            }
            zzejmVar.zzilu = zzeok.zzo(bArr, zza, i3);
            return zza + i3;
        }
        throw zzelo.zzbjb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(byte[] bArr, int i2, zzejm zzejmVar) throws zzelo {
        int zza = zza(bArr, i2, zzejmVar);
        int i3 = zzejmVar.zzils;
        if (i3 >= 0) {
            if (i3 <= bArr.length - zza) {
                if (i3 == 0) {
                    zzejmVar.zzilu = zzejr.zzilz;
                    return zza;
                }
                zzejmVar.zzilu = zzejr.zzi(bArr, zza, i3);
                return zza + i3;
            }
            throw zzelo.zzbja();
        }
        throw zzelo.zzbjb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & Draft_75.END_OF_FRAME) << 24) | (bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | ((bArr[i2 + 2] & Draft_75.END_OF_FRAME) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzi(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzj(byte[] bArr, int i2) {
        return Double.longBitsToDouble(zzi(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzk(byte[] bArr, int i2) {
        return Float.intBitsToFloat(zzh(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i2, byte[] bArr, int i3, zzejm zzejmVar) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b = bArr[i3];
        if (b >= 0) {
            zzejmVar.zzils = i4 | (b << 7);
            return i5;
        }
        int i6 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b2 = bArr[i5];
        if (b2 >= 0) {
            zzejmVar.zzils = i6 | (b2 << 14);
            return i7;
        }
        int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b3 = bArr[i7];
        if (b3 >= 0) {
            zzejmVar.zzils = i8 | (b3 << 21);
            return i9;
        }
        int i10 = i8 | ((b3 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b4 = bArr[i9];
        if (b4 >= 0) {
            zzejmVar.zzils = i10 | (b4 << 28);
            return i11;
        }
        int i12 = i10 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzejmVar.zzils = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzenj zzenjVar, byte[] bArr, int i2, int i3, zzejm zzejmVar) throws IOException {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = zza(i5, bArr, i4, zzejmVar);
            i5 = zzejmVar.zzils;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            Object newInstance = zzenjVar.newInstance();
            int i7 = i5 + i6;
            zzenjVar.zza(newInstance, bArr, i6, i7, zzejmVar);
            zzenjVar.zzak(newInstance);
            zzejmVar.zzilu = newInstance;
            return i7;
        }
        throw zzelo.zzbja();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzenj zzenjVar, byte[] bArr, int i2, int i3, int i4, zzejm zzejmVar) throws IOException {
        zzems zzemsVar = (zzems) zzenjVar;
        Object newInstance = zzemsVar.newInstance();
        int zza = zzemsVar.zza((zzems) newInstance, bArr, i2, i3, i4, zzejmVar);
        zzemsVar.zzak(newInstance);
        zzejmVar.zzilu = newInstance;
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i2, byte[] bArr, int i3, int i4, zzell<?> zzellVar, zzejm zzejmVar) {
        zzele zzeleVar = (zzele) zzellVar;
        int zza = zza(bArr, i3, zzejmVar);
        zzeleVar.zzhh(zzejmVar.zzils);
        while (zza < i4) {
            int zza2 = zza(bArr, zza, zzejmVar);
            if (i2 != zzejmVar.zzils) {
                break;
            }
            zza = zza(bArr, zza2, zzejmVar);
            zzeleVar.zzhh(zzejmVar.zzils);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i2, zzell<?> zzellVar, zzejm zzejmVar) throws IOException {
        zzele zzeleVar = (zzele) zzellVar;
        int zza = zza(bArr, i2, zzejmVar);
        int i3 = zzejmVar.zzils + zza;
        while (zza < i3) {
            zza = zza(bArr, zza, zzejmVar);
            zzeleVar.zzhh(zzejmVar.zzils);
        }
        if (zza == i3) {
            return zza;
        }
        throw zzelo.zzbja();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzenj<?> zzenjVar, int i2, byte[] bArr, int i3, int i4, zzell<?> zzellVar, zzejm zzejmVar) throws IOException {
        int zza = zza(zzenjVar, bArr, i3, i4, zzejmVar);
        zzellVar.add(zzejmVar.zzilu);
        while (zza < i4) {
            int zza2 = zza(bArr, zza, zzejmVar);
            if (i2 != zzejmVar.zzils) {
                break;
            }
            zza = zza(zzenjVar, bArr, zza2, i4, zzejmVar);
            zzellVar.add(zzejmVar.zzilu);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i2, byte[] bArr, int i3, int i4, zzeoe zzeoeVar, zzejm zzejmVar) throws zzelo {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int zzb = zzb(bArr, i3, zzejmVar);
                zzeoeVar.zzd(i2, Long.valueOf(zzejmVar.zzilt));
                return zzb;
            } else if (i5 == 1) {
                zzeoeVar.zzd(i2, Long.valueOf(zzi(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int zza = zza(bArr, i3, zzejmVar);
                int i6 = zzejmVar.zzils;
                if (i6 >= 0) {
                    if (i6 <= bArr.length - zza) {
                        if (i6 == 0) {
                            zzeoeVar.zzd(i2, zzejr.zzilz);
                        } else {
                            zzeoeVar.zzd(i2, zzejr.zzi(bArr, zza, i6));
                        }
                        return zza + i6;
                    }
                    throw zzelo.zzbja();
                }
                throw zzelo.zzbjb();
            } else if (i5 != 3) {
                if (i5 == 5) {
                    zzeoeVar.zzd(i2, Integer.valueOf(zzh(bArr, i3)));
                    return i3 + 4;
                }
                throw zzelo.zzbjd();
            } else {
                zzeoe zzbla = zzeoe.zzbla();
                int i7 = (i2 & (-8)) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int zza2 = zza(bArr, i3, zzejmVar);
                    int i9 = zzejmVar.zzils;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = zza2;
                        break;
                    }
                    int zza3 = zza(i8, bArr, zza2, i4, zzbla, zzejmVar);
                    i8 = i9;
                    i3 = zza3;
                }
                if (i3 <= i4 && i8 == i7) {
                    zzeoeVar.zzd(i2, zzbla);
                    return i3;
                }
                throw zzelo.zzbjh();
            }
        }
        throw zzelo.zzbjd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i2, byte[] bArr, int i3, int i4, zzejm zzejmVar) throws zzelo {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 5) {
                                return i3 + 4;
                            }
                            throw zzelo.zzbjd();
                        }
                        int i6 = (i2 & (-8)) | 4;
                        int i7 = 0;
                        while (i3 < i4) {
                            i3 = zza(bArr, i3, zzejmVar);
                            i7 = zzejmVar.zzils;
                            if (i7 == i6) {
                                break;
                            }
                            i3 = zza(i7, bArr, i3, i4, zzejmVar);
                        }
                        if (i3 > i4 || i7 != i6) {
                            throw zzelo.zzbjh();
                        }
                        return i3;
                    }
                    return zza(bArr, i3, zzejmVar) + zzejmVar.zzils;
                }
                return i3 + 8;
            }
            return zzb(bArr, i3, zzejmVar);
        }
        throw zzelo.zzbjd();
    }
}
