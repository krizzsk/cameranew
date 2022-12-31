package com.google.android.gms.internal.places;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i2, zzr zzrVar) {
        int i3 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzrVar.zzdz = b;
            return i3;
        }
        return zzb(b, bArr, i3, zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i2, zzr zzrVar) {
        byte b;
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            zzrVar.zzea = j2;
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
        zzrVar.zzea = j3;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzd(byte[] bArr, int i2) {
        return Double.longBitsToDouble(zzc(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zze(byte[] bArr, int i2) {
        return Float.intBitsToFloat(zzb(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i2, zzr zzrVar) throws zzbk {
        int zzb = zzb(bArr, i2, zzrVar);
        int i3 = zzrVar.zzdz;
        if (i3 >= 0) {
            if (i3 <= bArr.length - zzb) {
                if (i3 == 0) {
                    zzrVar.zzeb = zzw.zzeg;
                    return zzb;
                }
                zzrVar.zzeb = zzw.zzc(bArr, zzb, i3);
                return zzb + i3;
            }
            throw zzbk.zzbp();
        }
        throw zzbk.zzbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i2, zzr zzrVar) throws zzbk {
        int zzb = zzb(bArr, i2, zzrVar);
        int i3 = zzrVar.zzdz;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzrVar.zzeb = "";
                return zzb;
            }
            zzrVar.zzeb = new String(bArr, zzb, i3, zzbd.UTF_8);
            return zzb + i3;
        }
        throw zzbk.zzbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(byte[] bArr, int i2, zzr zzrVar) throws zzbk {
        int zzb = zzb(bArr, i2, zzrVar);
        int i3 = zzrVar.zzdz;
        if (i3 >= 0) {
            if (i3 == 0) {
                zzrVar.zzeb = "";
                return zzb;
            }
            zzrVar.zzeb = zzea.zzh(bArr, zzb, i3);
            return zzb + i3;
        }
        throw zzbk.zzbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i2, byte[] bArr, int i3, zzr zzrVar) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b = bArr[i3];
        if (b >= 0) {
            zzrVar.zzdz = i4 | (b << 7);
            return i5;
        }
        int i6 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b2 = bArr[i5];
        if (b2 >= 0) {
            zzrVar.zzdz = i6 | (b2 << 14);
            return i7;
        }
        int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b3 = bArr[i7];
        if (b3 >= 0) {
            zzrVar.zzdz = i8 | (b3 << 21);
            return i9;
        }
        int i10 = i8 | ((b3 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b4 = bArr[i9];
        if (b4 >= 0) {
            zzrVar.zzdz = i10 | (b4 << 28);
            return i11;
        }
        int i12 = i10 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                zzrVar.zzdz = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzc(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & Draft_75.END_OF_FRAME) << 24) | (bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | ((bArr[i2 + 2] & Draft_75.END_OF_FRAME) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzda zzdaVar, byte[] bArr, int i2, int i3, zzr zzrVar) throws IOException {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = zzb(i5, bArr, i4, zzrVar);
            i5 = zzrVar.zzdz;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            Object newInstance = zzdaVar.newInstance();
            int i7 = i5 + i6;
            zzdaVar.zzb(newInstance, bArr, i6, i7, zzrVar);
            zzdaVar.zzd(newInstance);
            zzrVar.zzeb = newInstance;
            return i7;
        }
        throw zzbk.zzbp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzda zzdaVar, byte[] bArr, int i2, int i3, int i4, zzr zzrVar) throws IOException {
        zzco zzcoVar = (zzco) zzdaVar;
        Object newInstance = zzcoVar.newInstance();
        int zzb = zzcoVar.zzb((zzco) newInstance, bArr, i2, i3, i4, zzrVar);
        zzcoVar.zzd(newInstance);
        zzrVar.zzeb = newInstance;
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i2, byte[] bArr, int i3, int i4, zzbh<?> zzbhVar, zzr zzrVar) {
        zzbe zzbeVar = (zzbe) zzbhVar;
        int zzb = zzb(bArr, i3, zzrVar);
        zzbeVar.zzac(zzrVar.zzdz);
        while (zzb < i4) {
            int zzb2 = zzb(bArr, zzb, zzrVar);
            if (i2 != zzrVar.zzdz) {
                break;
            }
            zzb = zzb(bArr, zzb2, zzrVar);
            zzbeVar.zzac(zzrVar.zzdz);
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i2, zzbh<?> zzbhVar, zzr zzrVar) throws IOException {
        zzbe zzbeVar = (zzbe) zzbhVar;
        int zzb = zzb(bArr, i2, zzrVar);
        int i3 = zzrVar.zzdz + zzb;
        while (zzb < i3) {
            zzb = zzb(bArr, zzb, zzrVar);
            zzbeVar.zzac(zzrVar.zzdz);
        }
        if (zzb == i3) {
            return zzb;
        }
        throw zzbk.zzbp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzda<?> zzdaVar, int i2, byte[] bArr, int i3, int i4, zzbh<?> zzbhVar, zzr zzrVar) throws IOException {
        int zzb = zzb(zzdaVar, bArr, i3, i4, zzrVar);
        zzbhVar.add(zzrVar.zzeb);
        while (zzb < i4) {
            int zzb2 = zzb(bArr, zzb, zzrVar);
            if (i2 != zzrVar.zzdz) {
                break;
            }
            zzb = zzb(zzdaVar, bArr, zzb2, i4, zzrVar);
            zzbhVar.add(zzrVar.zzeb);
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i2, byte[] bArr, int i3, int i4, zzdr zzdrVar, zzr zzrVar) throws zzbk {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int zzc = zzc(bArr, i3, zzrVar);
                zzdrVar.zzc(i2, Long.valueOf(zzrVar.zzea));
                return zzc;
            } else if (i5 == 1) {
                zzdrVar.zzc(i2, Long.valueOf(zzc(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int zzb = zzb(bArr, i3, zzrVar);
                int i6 = zzrVar.zzdz;
                if (i6 >= 0) {
                    if (i6 <= bArr.length - zzb) {
                        if (i6 == 0) {
                            zzdrVar.zzc(i2, zzw.zzeg);
                        } else {
                            zzdrVar.zzc(i2, zzw.zzc(bArr, zzb, i6));
                        }
                        return zzb + i6;
                    }
                    throw zzbk.zzbp();
                }
                throw zzbk.zzbq();
            } else if (i5 != 3) {
                if (i5 == 5) {
                    zzdrVar.zzc(i2, Integer.valueOf(zzb(bArr, i3)));
                    return i3 + 4;
                }
                throw zzbk.zzbr();
            } else {
                zzdr zzdi = zzdr.zzdi();
                int i7 = (i2 & (-8)) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int zzb2 = zzb(bArr, i3, zzrVar);
                    int i9 = zzrVar.zzdz;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = zzb2;
                        break;
                    }
                    int zzb3 = zzb(i8, bArr, zzb2, i4, zzdi, zzrVar);
                    i8 = i9;
                    i3 = zzb3;
                }
                if (i3 <= i4 && i8 == i7) {
                    zzdrVar.zzc(i2, zzdi);
                    return i3;
                }
                throw zzbk.zzbt();
            }
        }
        throw zzbk.zzbr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i2, byte[] bArr, int i3, int i4, zzr zzrVar) throws zzbk {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 5) {
                                return i3 + 4;
                            }
                            throw zzbk.zzbr();
                        }
                        int i6 = (i2 & (-8)) | 4;
                        int i7 = 0;
                        while (i3 < i4) {
                            i3 = zzb(bArr, i3, zzrVar);
                            i7 = zzrVar.zzdz;
                            if (i7 == i6) {
                                break;
                            }
                            i3 = zzb(i7, bArr, i3, i4, zzrVar);
                        }
                        if (i3 > i4 || i7 != i6) {
                            throw zzbk.zzbt();
                        }
                        return i3;
                    }
                    return zzb(bArr, i3, zzrVar) + zzrVar.zzdz;
                }
                return i3 + 8;
            }
            return zzc(bArr, i3, zzrVar);
        }
        throw zzbk.zzbr();
    }
}
