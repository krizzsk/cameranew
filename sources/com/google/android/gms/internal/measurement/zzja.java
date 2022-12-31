package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzja<T> implements zzji<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkh.zzr();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzix zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzil zzm;
    private final zzjw<?, ?> zzn;
    private final zzhf<?> zzo;
    private final zzjc zzp;
    private final zzis zzq;

    /* JADX WARN: Multi-variable type inference failed */
    private zzja(int[] iArr, int[] iArr2, Object[] objArr, int i2, int i3, zzix zzixVar, boolean z, boolean z2, int[] iArr3, int i4, int i5, zzjc zzjcVar, zzil zzilVar, zzjw<?, ?> zzjwVar, zzhf<?> zzhfVar, zzis zzisVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zze = objArr;
        this.zzf = i2;
        this.zzi = zzixVar;
        boolean z3 = false;
        if (zzjwVar != 0 && zzjwVar.zza(i3)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = z2;
        this.zzk = iArr3;
        this.zzl = i4;
        this.zzp = i5;
        this.zzm = zzjcVar;
        this.zzn = zzilVar;
        this.zzo = zzjwVar;
        this.zzg = i3;
        this.zzq = zzhfVar;
    }

    private final int zzA(int i2) {
        return this.zzc[i2 + 1];
    }

    private final int zzB(int i2) {
        return this.zzc[i2 + 2];
    }

    private static int zzC(int i2) {
        return (i2 >>> 20) & 255;
    }

    private static <T> double zzD(T t, long j2) {
        return ((Double) zzkh.zzn(t, j2)).doubleValue();
    }

    private static <T> float zzE(T t, long j2) {
        return ((Float) zzkh.zzn(t, j2)).floatValue();
    }

    private static <T> int zzF(T t, long j2) {
        return ((Integer) zzkh.zzn(t, j2)).intValue();
    }

    private static <T> long zzG(T t, long j2) {
        return ((Long) zzkh.zzn(t, j2)).longValue();
    }

    private static <T> boolean zzH(T t, long j2) {
        return ((Boolean) zzkh.zzn(t, j2)).booleanValue();
    }

    private final boolean zzI(T t, T t2, int i2) {
        return zzK(t, i2) == zzK(t2, i2);
    }

    private final boolean zzJ(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return zzK(t, i2);
        }
        return (i4 & i5) != 0;
    }

    private final boolean zzK(T t, int i2) {
        int zzB = zzB(i2);
        long j2 = zzB & 1048575;
        if (j2 != 1048575) {
            return (zzkh.zzd(t, j2) & (1 << (zzB >>> 20))) != 0;
        }
        int zzA = zzA(i2);
        long j3 = zzA & 1048575;
        switch (zzC(zzA)) {
            case 0:
                return zzkh.zzl(t, j3) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            case 1:
                return zzkh.zzj(t, j3) != 0.0f;
            case 2:
                return zzkh.zzf(t, j3) != 0;
            case 3:
                return zzkh.zzf(t, j3) != 0;
            case 4:
                return zzkh.zzd(t, j3) != 0;
            case 5:
                return zzkh.zzf(t, j3) != 0;
            case 6:
                return zzkh.zzd(t, j3) != 0;
            case 7:
                return zzkh.zzh(t, j3);
            case 8:
                Object zzn = zzkh.zzn(t, j3);
                if (zzn instanceof String) {
                    return !((String) zzn).isEmpty();
                } else if (zzn instanceof zzgs) {
                    return !zzgs.zzb.equals(zzn);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzkh.zzn(t, j3) != null;
            case 10:
                return !zzgs.zzb.equals(zzkh.zzn(t, j3));
            case 11:
                return zzkh.zzd(t, j3) != 0;
            case 12:
                return zzkh.zzd(t, j3) != 0;
            case 13:
                return zzkh.zzd(t, j3) != 0;
            case 14:
                return zzkh.zzf(t, j3) != 0;
            case 15:
                return zzkh.zzd(t, j3) != 0;
            case 16:
                return zzkh.zzf(t, j3) != 0;
            case 17:
                return zzkh.zzn(t, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzL(T t, int i2) {
        int zzB = zzB(i2);
        long j2 = 1048575 & zzB;
        if (j2 == 1048575) {
            return;
        }
        zzkh.zze(t, j2, (1 << (zzB >>> 20)) | zzkh.zzd(t, j2));
    }

    private final boolean zzM(T t, int i2, int i3) {
        return zzkh.zzd(t, (long) (zzB(i3) & 1048575)) == i2;
    }

    private final void zzN(T t, int i2, int i3) {
        zzkh.zze(t, zzB(i3) & 1048575, i2);
    }

    private final int zzO(int i2) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzQ(i2, 0);
    }

    private final int zzP(int i2, int i3) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzQ(i2, i3);
    }

    private final int zzQ(int i2, int i3) {
        int length = (this.zzc.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzc[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private final void zzR(T t, zzha zzhaVar) throws IOException {
        int i2;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i3 = 1048575;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1048575;
            while (i4 < length) {
                int zzA = zzA(i4);
                int i7 = this.zzc[i4];
                int zzC = zzC(zzA);
                if (zzC <= 17) {
                    int i8 = this.zzc[i4 + 2];
                    int i9 = i8 & i3;
                    if (i9 != i6) {
                        i5 = unsafe.getInt(t, i9);
                        i6 = i9;
                    }
                    i2 = 1 << (i8 >>> 20);
                } else {
                    i2 = 0;
                }
                long j2 = zzA & i3;
                switch (zzC) {
                    case 0:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzf(i7, zzkh.zzl(t, j2));
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 1:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zze(i7, zzkh.zzj(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 2:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzc(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 3:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzh(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 4:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzi(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 5:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzj(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 6:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzk(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 7:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzl(i7, zzkh.zzh(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 8:
                        if ((i5 & i2) != 0) {
                            zzT(i7, unsafe.getObject(t, j2), zzhaVar);
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 9:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzr(i7, unsafe.getObject(t, j2), zzv(i4));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 10:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzn(i7, (zzgs) unsafe.getObject(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 11:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzo(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 12:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzg(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 13:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzb(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 14:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzd(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 15:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzp(i7, unsafe.getInt(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 16:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzq(i7, unsafe.getLong(t, j2));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 17:
                        if ((i5 & i2) != 0) {
                            zzhaVar.zzs(i7, unsafe.getObject(t, j2), zzv(i4));
                        } else {
                            continue;
                        }
                        i4 += 3;
                        i3 = 1048575;
                    case 18:
                        zzjk.zzJ(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 19:
                        zzjk.zzK(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 20:
                        zzjk.zzL(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 21:
                        zzjk.zzM(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 22:
                        zzjk.zzQ(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 23:
                        zzjk.zzO(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 24:
                        zzjk.zzT(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 25:
                        zzjk.zzW(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        continue;
                        i4 += 3;
                        i3 = 1048575;
                    case 26:
                        zzjk.zzX(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar);
                        break;
                    case 27:
                        zzjk.zzZ(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, zzv(i4));
                        break;
                    case 28:
                        zzjk.zzY(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar);
                        break;
                    case 29:
                        zzjk.zzR(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        break;
                    case 30:
                        zzjk.zzV(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        break;
                    case 31:
                        zzjk.zzU(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        break;
                    case 32:
                        zzjk.zzP(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        break;
                    case 33:
                        zzjk.zzS(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        break;
                    case 34:
                        zzjk.zzN(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, false);
                        break;
                    case 35:
                        zzjk.zzJ(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 36:
                        zzjk.zzK(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 37:
                        zzjk.zzL(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 38:
                        zzjk.zzM(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 39:
                        zzjk.zzQ(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 40:
                        zzjk.zzO(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 41:
                        zzjk.zzT(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 42:
                        zzjk.zzW(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 43:
                        zzjk.zzR(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 44:
                        zzjk.zzV(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 45:
                        zzjk.zzU(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 46:
                        zzjk.zzP(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 47:
                        zzjk.zzS(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 48:
                        zzjk.zzN(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, true);
                        break;
                    case 49:
                        zzjk.zzaa(this.zzc[i4], (List) unsafe.getObject(t, j2), zzhaVar, zzv(i4));
                        break;
                    case 50:
                        zzS(zzhaVar, i7, unsafe.getObject(t, j2), i4);
                        break;
                    case 51:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzf(i7, zzD(t, j2));
                            break;
                        }
                        break;
                    case 52:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zze(i7, zzE(t, j2));
                            break;
                        }
                        break;
                    case 53:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzc(i7, zzG(t, j2));
                            break;
                        }
                        break;
                    case 54:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzh(i7, zzG(t, j2));
                            break;
                        }
                        break;
                    case 55:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzi(i7, zzF(t, j2));
                            break;
                        }
                        break;
                    case 56:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzj(i7, zzG(t, j2));
                            break;
                        }
                        break;
                    case 57:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzk(i7, zzF(t, j2));
                            break;
                        }
                        break;
                    case 58:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzl(i7, zzH(t, j2));
                            break;
                        }
                        break;
                    case 59:
                        if (zzM(t, i7, i4)) {
                            zzT(i7, unsafe.getObject(t, j2), zzhaVar);
                            break;
                        }
                        break;
                    case 60:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzr(i7, unsafe.getObject(t, j2), zzv(i4));
                            break;
                        }
                        break;
                    case 61:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzn(i7, (zzgs) unsafe.getObject(t, j2));
                            break;
                        }
                        break;
                    case 62:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzo(i7, zzF(t, j2));
                            break;
                        }
                        break;
                    case 63:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzg(i7, zzF(t, j2));
                            break;
                        }
                        break;
                    case 64:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzb(i7, zzF(t, j2));
                            break;
                        }
                        break;
                    case 65:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzd(i7, zzG(t, j2));
                            break;
                        }
                        break;
                    case 66:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzp(i7, zzF(t, j2));
                            break;
                        }
                        break;
                    case 67:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzq(i7, zzG(t, j2));
                            break;
                        }
                        break;
                    case 68:
                        if (zzM(t, i7, i4)) {
                            zzhaVar.zzs(i7, unsafe.getObject(t, j2), zzv(i4));
                            break;
                        }
                        break;
                }
                i4 += 3;
                i3 = 1048575;
            }
            zzjw<?, ?> zzjwVar = this.zzn;
            zzjwVar.zzi(zzjwVar.zzd(t), zzhaVar);
            return;
        }
        this.zzo.zzb(t);
        throw null;
    }

    private final <K, V> void zzS(zzha zzhaVar, int i2, Object obj, int i3) throws IOException {
        if (obj == null) {
            return;
        }
        zziq zziqVar = (zziq) zzw(i3);
        throw null;
    }

    private static final void zzT(int i2, Object obj, zzha zzhaVar) throws IOException {
        if (obj instanceof String) {
            zzhaVar.zzm(i2, (String) obj);
        } else {
            zzhaVar.zzn(i2, (zzgs) obj);
        }
    }

    static zzjx zzf(Object obj) {
        zzhs zzhsVar = (zzhs) obj;
        zzjx zzjxVar = zzhsVar.zzc;
        if (zzjxVar == zzjx.zza()) {
            zzjx zzb2 = zzjx.zzb();
            zzhsVar.zzc = zzb2;
            return zzb2;
        }
        return zzjxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzja<T> zzk(Class<T> cls, zziu zziuVar, zzjc zzjcVar, zzil zzilVar, zzjw<?, ?> zzjwVar, zzhf<?> zzhfVar, zzis zzisVar) {
        if (zziuVar instanceof zzjh) {
            return zzl((zzjh) zziuVar, zzjcVar, zzilVar, zzjwVar, zzhfVar, zzisVar);
        }
        zzjt zzjtVar = (zzjt) zziuVar;
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0385  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.android.gms.internal.measurement.zzja<T> zzl(com.google.android.gms.internal.measurement.zzjh r34, com.google.android.gms.internal.measurement.zzjc r35, com.google.android.gms.internal.measurement.zzil r36, com.google.android.gms.internal.measurement.zzjw<?, ?> r37, com.google.android.gms.internal.measurement.zzhf<?> r38, com.google.android.gms.internal.measurement.zzis r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzja.zzl(com.google.android.gms.internal.measurement.zzjh, com.google.android.gms.internal.measurement.zzjc, com.google.android.gms.internal.measurement.zzil, com.google.android.gms.internal.measurement.zzjw, com.google.android.gms.internal.measurement.zzhf, com.google.android.gms.internal.measurement.zzis):com.google.android.gms.internal.measurement.zzja");
    }

    private static Field zzn(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzo(T t, T t2, int i2) {
        long zzA = zzA(i2) & 1048575;
        if (zzK(t2, i2)) {
            Object zzn = zzkh.zzn(t, zzA);
            Object zzn2 = zzkh.zzn(t2, zzA);
            if (zzn != null && zzn2 != null) {
                zzkh.zzo(t, zzA, zzia.zzi(zzn, zzn2));
                zzL(t, i2);
            } else if (zzn2 != null) {
                zzkh.zzo(t, zzA, zzn2);
                zzL(t, i2);
            }
        }
    }

    private final void zzp(T t, T t2, int i2) {
        int zzA = zzA(i2);
        int i3 = this.zzc[i2];
        long j2 = zzA & 1048575;
        if (zzM(t2, i3, i2)) {
            Object zzn = zzM(t, i3, i2) ? zzkh.zzn(t, j2) : null;
            Object zzn2 = zzkh.zzn(t2, j2);
            if (zzn != null && zzn2 != null) {
                zzkh.zzo(t, j2, zzia.zzi(zzn, zzn2));
                zzN(t, i3, i2);
            } else if (zzn2 != null) {
                zzkh.zzo(t, j2, zzn2);
                zzN(t, i3, i2);
            }
        }
    }

    private final int zzq(T t) {
        int i2;
        int zzw;
        int zzw2;
        int zzw3;
        int zzx;
        int zzw4;
        int zzv;
        int zzw5;
        int zzw6;
        int zzc;
        int zzw7;
        int zzw8;
        int zzu;
        int zzw9;
        int i3;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        for (int i7 = 0; i7 < this.zzc.length; i7 += 3) {
            int zzA = zzA(i7);
            int i8 = this.zzc[i7];
            int zzC = zzC(zzA);
            if (zzC <= 17) {
                int i9 = this.zzc[i7 + 2];
                int i10 = i9 & 1048575;
                i2 = 1 << (i9 >>> 20);
                if (i10 != i6) {
                    i5 = unsafe.getInt(t, i10);
                    i6 = i10;
                }
            } else {
                i2 = 0;
            }
            long j2 = zzA & 1048575;
            switch (zzC) {
                case 0:
                    if ((i5 & i2) != 0) {
                        zzw = zzgz.zzw(i8 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if ((i5 & i2) != 0) {
                        zzw2 = zzgz.zzw(i8 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if ((i5 & i2) != 0) {
                        long j3 = unsafe.getLong(t, j2);
                        zzw3 = zzgz.zzw(i8 << 3);
                        zzx = zzgz.zzx(j3);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if ((i5 & i2) != 0) {
                        long j4 = unsafe.getLong(t, j2);
                        zzw3 = zzgz.zzw(i8 << 3);
                        zzx = zzgz.zzx(j4);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if ((i5 & i2) != 0) {
                        int i11 = unsafe.getInt(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzv(i11);
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 5:
                    if ((i5 & i2) != 0) {
                        zzw = zzgz.zzw(i8 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if ((i5 & i2) != 0) {
                        zzw2 = zzgz.zzw(i8 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if ((i5 & i2) != 0) {
                        zzw5 = zzgz.zzw(i8 << 3);
                        zzw8 = zzw5 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if ((i5 & i2) != 0) {
                        Object object = unsafe.getObject(t, j2);
                        if (object instanceof zzgs) {
                            zzw6 = zzgz.zzw(i8 << 3);
                            zzc = ((zzgs) object).zzc();
                            zzw7 = zzgz.zzw(zzc);
                            i3 = zzw6 + zzw7 + zzc;
                            i4 += i3;
                        } else {
                            zzw4 = zzgz.zzw(i8 << 3);
                            zzv = zzgz.zzy((String) object);
                            i3 = zzw4 + zzv;
                            i4 += i3;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if ((i5 & i2) != 0) {
                        zzw8 = zzjk.zzw(i8, unsafe.getObject(t, j2), zzv(i7));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if ((i5 & i2) != 0) {
                        zzw6 = zzgz.zzw(i8 << 3);
                        zzc = ((zzgs) unsafe.getObject(t, j2)).zzc();
                        zzw7 = zzgz.zzw(zzc);
                        i3 = zzw6 + zzw7 + zzc;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 11:
                    if ((i5 & i2) != 0) {
                        int i12 = unsafe.getInt(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzw(i12);
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 12:
                    if ((i5 & i2) != 0) {
                        int i13 = unsafe.getInt(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzv(i13);
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 13:
                    if ((i5 & i2) != 0) {
                        zzw2 = zzgz.zzw(i8 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if ((i5 & i2) != 0) {
                        zzw = zzgz.zzw(i8 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if ((i5 & i2) != 0) {
                        int i14 = unsafe.getInt(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzw((i14 >> 31) ^ (i14 + i14));
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 16:
                    if ((i5 & i2) != 0) {
                        long j5 = unsafe.getLong(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzx((j5 >> 63) ^ (j5 + j5));
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 17:
                    if ((i5 & i2) != 0) {
                        zzw8 = zzgz.zzE(i8, (zzix) unsafe.getObject(t, j2), zzv(i7));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    zzw8 = zzjk.zzs(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 19:
                    zzw8 = zzjk.zzq(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 20:
                    zzw8 = zzjk.zzc(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 21:
                    zzw8 = zzjk.zze(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 22:
                    zzw8 = zzjk.zzk(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 23:
                    zzw8 = zzjk.zzs(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 24:
                    zzw8 = zzjk.zzq(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 25:
                    zzw8 = zzjk.zzu(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 26:
                    zzw8 = zzjk.zzv(i8, (List) unsafe.getObject(t, j2));
                    break;
                case 27:
                    zzw8 = zzjk.zzx(i8, (List) unsafe.getObject(t, j2), zzv(i7));
                    break;
                case 28:
                    zzw8 = zzjk.zzy(i8, (List) unsafe.getObject(t, j2));
                    break;
                case 29:
                    zzw8 = zzjk.zzm(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 30:
                    zzw8 = zzjk.zzi(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 31:
                    zzw8 = zzjk.zzq(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 32:
                    zzw8 = zzjk.zzs(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 33:
                    zzw8 = zzjk.zzo(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 34:
                    zzw8 = zzjk.zzg(i8, (List) unsafe.getObject(t, j2), false);
                    break;
                case 35:
                    zzv = zzjk.zzr((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 36:
                    zzv = zzjk.zzp((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 37:
                    zzv = zzjk.zzb((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 38:
                    zzv = zzjk.zzd((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 39:
                    zzv = zzjk.zzj((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 40:
                    zzv = zzjk.zzr((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 41:
                    zzv = zzjk.zzp((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 42:
                    zzv = zzjk.zzt((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 43:
                    zzv = zzjk.zzl((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 44:
                    zzv = zzjk.zzh((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 45:
                    zzv = zzjk.zzp((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 46:
                    zzv = zzjk.zzr((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 47:
                    zzv = zzjk.zzn((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 48:
                    zzv = zzjk.zzf((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i8);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 49:
                    zzw8 = zzjk.zzz(i8, (List) unsafe.getObject(t, j2), zzv(i7));
                    break;
                case 50:
                    zzis.zza(i8, unsafe.getObject(t, j2), zzw(i7));
                    continue;
                case 51:
                    if (zzM(t, i8, i7)) {
                        zzw = zzgz.zzw(i8 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (zzM(t, i8, i7)) {
                        zzw2 = zzgz.zzw(i8 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (zzM(t, i8, i7)) {
                        long zzG = zzG(t, j2);
                        zzw3 = zzgz.zzw(i8 << 3);
                        zzx = zzgz.zzx(zzG);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (zzM(t, i8, i7)) {
                        long zzG2 = zzG(t, j2);
                        zzw3 = zzgz.zzw(i8 << 3);
                        zzx = zzgz.zzx(zzG2);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (zzM(t, i8, i7)) {
                        int zzF = zzF(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzv(zzF);
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 56:
                    if (zzM(t, i8, i7)) {
                        zzw = zzgz.zzw(i8 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (zzM(t, i8, i7)) {
                        zzw2 = zzgz.zzw(i8 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (zzM(t, i8, i7)) {
                        zzw5 = zzgz.zzw(i8 << 3);
                        zzw8 = zzw5 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (zzM(t, i8, i7)) {
                        Object object2 = unsafe.getObject(t, j2);
                        if (object2 instanceof zzgs) {
                            zzw6 = zzgz.zzw(i8 << 3);
                            zzc = ((zzgs) object2).zzc();
                            zzw7 = zzgz.zzw(zzc);
                            i3 = zzw6 + zzw7 + zzc;
                            i4 += i3;
                        } else {
                            zzw4 = zzgz.zzw(i8 << 3);
                            zzv = zzgz.zzy((String) object2);
                            i3 = zzw4 + zzv;
                            i4 += i3;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (zzM(t, i8, i7)) {
                        zzw8 = zzjk.zzw(i8, unsafe.getObject(t, j2), zzv(i7));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (zzM(t, i8, i7)) {
                        zzw6 = zzgz.zzw(i8 << 3);
                        zzc = ((zzgs) unsafe.getObject(t, j2)).zzc();
                        zzw7 = zzgz.zzw(zzc);
                        i3 = zzw6 + zzw7 + zzc;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 62:
                    if (zzM(t, i8, i7)) {
                        int zzF2 = zzF(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzw(zzF2);
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 63:
                    if (zzM(t, i8, i7)) {
                        int zzF3 = zzF(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzv(zzF3);
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 64:
                    if (zzM(t, i8, i7)) {
                        zzw2 = zzgz.zzw(i8 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (zzM(t, i8, i7)) {
                        zzw = zzgz.zzw(i8 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (zzM(t, i8, i7)) {
                        int zzF4 = zzF(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzw((zzF4 >> 31) ^ (zzF4 + zzF4));
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 67:
                    if (zzM(t, i8, i7)) {
                        long zzG3 = zzG(t, j2);
                        zzw4 = zzgz.zzw(i8 << 3);
                        zzv = zzgz.zzx((zzG3 >> 63) ^ (zzG3 + zzG3));
                        i3 = zzw4 + zzv;
                        i4 += i3;
                    } else {
                        continue;
                    }
                case 68:
                    if (zzM(t, i8, i7)) {
                        zzw8 = zzgz.zzE(i8, (zzix) unsafe.getObject(t, j2), zzv(i7));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i4 += zzw8;
        }
        zzjw<?, ?> zzjwVar = this.zzn;
        int zzh = i4 + zzjwVar.zzh(zzjwVar.zzd(t));
        if (this.zzh) {
            this.zzo.zzb(t);
            throw null;
        }
        return zzh;
    }

    private final int zzr(T t) {
        int zzw;
        int zzw2;
        int zzw3;
        int zzx;
        int zzw4;
        int zzv;
        int zzw5;
        int zzw6;
        int zzc;
        int zzw7;
        int zzw8;
        int zzu;
        int zzw9;
        int i2;
        Unsafe unsafe = zzb;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzA = zzA(i4);
            int zzC = zzC(zzA);
            int i5 = this.zzc[i4];
            long j2 = zzA & 1048575;
            if (zzC >= zzhk.zzJ.zza() && zzC <= zzhk.zzW.zza()) {
                int i6 = this.zzc[i4 + 2];
            }
            switch (zzC) {
                case 0:
                    if (zzK(t, i4)) {
                        zzw = zzgz.zzw(i5 << 3);
                        zzw8 = zzw + 8;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzK(t, i4)) {
                        zzw2 = zzgz.zzw(i5 << 3);
                        zzw8 = zzw2 + 4;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzK(t, i4)) {
                        long zzf = zzkh.zzf(t, j2);
                        zzw3 = zzgz.zzw(i5 << 3);
                        zzx = zzgz.zzx(zzf);
                        i3 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzK(t, i4)) {
                        long zzf2 = zzkh.zzf(t, j2);
                        zzw3 = zzgz.zzw(i5 << 3);
                        zzx = zzgz.zzx(zzf2);
                        i3 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzK(t, i4)) {
                        int zzd = zzkh.zzd(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzv(zzd);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzK(t, i4)) {
                        zzw = zzgz.zzw(i5 << 3);
                        zzw8 = zzw + 8;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzK(t, i4)) {
                        zzw2 = zzgz.zzw(i5 << 3);
                        zzw8 = zzw2 + 4;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzK(t, i4)) {
                        zzw5 = zzgz.zzw(i5 << 3);
                        zzw8 = zzw5 + 1;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzK(t, i4)) {
                        break;
                    } else {
                        Object zzn = zzkh.zzn(t, j2);
                        if (zzn instanceof zzgs) {
                            zzw6 = zzgz.zzw(i5 << 3);
                            zzc = ((zzgs) zzn).zzc();
                            zzw7 = zzgz.zzw(zzc);
                            i2 = zzw6 + zzw7 + zzc;
                            i3 += i2;
                            break;
                        } else {
                            zzw4 = zzgz.zzw(i5 << 3);
                            zzv = zzgz.zzy((String) zzn);
                            i2 = zzw4 + zzv;
                            i3 += i2;
                        }
                    }
                case 9:
                    if (zzK(t, i4)) {
                        zzw8 = zzjk.zzw(i5, zzkh.zzn(t, j2), zzv(i4));
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzK(t, i4)) {
                        zzw6 = zzgz.zzw(i5 << 3);
                        zzc = ((zzgs) zzkh.zzn(t, j2)).zzc();
                        zzw7 = zzgz.zzw(zzc);
                        i2 = zzw6 + zzw7 + zzc;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzK(t, i4)) {
                        int zzd2 = zzkh.zzd(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzw(zzd2);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzK(t, i4)) {
                        int zzd3 = zzkh.zzd(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzv(zzd3);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzK(t, i4)) {
                        zzw2 = zzgz.zzw(i5 << 3);
                        zzw8 = zzw2 + 4;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzK(t, i4)) {
                        zzw = zzgz.zzw(i5 << 3);
                        zzw8 = zzw + 8;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzK(t, i4)) {
                        int zzd4 = zzkh.zzd(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzw((zzd4 >> 31) ^ (zzd4 + zzd4));
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzK(t, i4)) {
                        long zzf3 = zzkh.zzf(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzx((zzf3 >> 63) ^ (zzf3 + zzf3));
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzK(t, i4)) {
                        zzw8 = zzgz.zzE(i5, (zzix) zzkh.zzn(t, j2), zzv(i4));
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzw8 = zzjk.zzs(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 19:
                    zzw8 = zzjk.zzq(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 20:
                    zzw8 = zzjk.zzc(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 21:
                    zzw8 = zzjk.zze(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 22:
                    zzw8 = zzjk.zzk(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 23:
                    zzw8 = zzjk.zzs(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 24:
                    zzw8 = zzjk.zzq(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 25:
                    zzw8 = zzjk.zzu(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 26:
                    zzw8 = zzjk.zzv(i5, (List) zzkh.zzn(t, j2));
                    i3 += zzw8;
                    break;
                case 27:
                    zzw8 = zzjk.zzx(i5, (List) zzkh.zzn(t, j2), zzv(i4));
                    i3 += zzw8;
                    break;
                case 28:
                    zzw8 = zzjk.zzy(i5, (List) zzkh.zzn(t, j2));
                    i3 += zzw8;
                    break;
                case 29:
                    zzw8 = zzjk.zzm(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 30:
                    zzw8 = zzjk.zzi(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 31:
                    zzw8 = zzjk.zzq(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 32:
                    zzw8 = zzjk.zzs(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 33:
                    zzw8 = zzjk.zzo(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 34:
                    zzw8 = zzjk.zzg(i5, (List) zzkh.zzn(t, j2), false);
                    i3 += zzw8;
                    break;
                case 35:
                    zzv = zzjk.zzr((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzjk.zzp((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzjk.zzb((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzjk.zzd((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzjk.zzj((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzjk.zzr((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzjk.zzp((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzjk.zzt((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzjk.zzl((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzjk.zzh((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzjk.zzp((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzjk.zzr((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzjk.zzn((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzjk.zzf((List) unsafe.getObject(t, j2));
                    if (zzv > 0) {
                        zzu = zzgz.zzu(i5);
                        zzw9 = zzgz.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzw8 = zzjk.zzz(i5, (List) zzkh.zzn(t, j2), zzv(i4));
                    i3 += zzw8;
                    break;
                case 50:
                    zzis.zza(i5, zzkh.zzn(t, j2), zzw(i4));
                    break;
                case 51:
                    if (zzM(t, i5, i4)) {
                        zzw = zzgz.zzw(i5 << 3);
                        zzw8 = zzw + 8;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(t, i5, i4)) {
                        zzw2 = zzgz.zzw(i5 << 3);
                        zzw8 = zzw2 + 4;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(t, i5, i4)) {
                        long zzG = zzG(t, j2);
                        zzw3 = zzgz.zzw(i5 << 3);
                        zzx = zzgz.zzx(zzG);
                        i3 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(t, i5, i4)) {
                        long zzG2 = zzG(t, j2);
                        zzw3 = zzgz.zzw(i5 << 3);
                        zzx = zzgz.zzx(zzG2);
                        i3 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(t, i5, i4)) {
                        int zzF = zzF(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzv(zzF);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(t, i5, i4)) {
                        zzw = zzgz.zzw(i5 << 3);
                        zzw8 = zzw + 8;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(t, i5, i4)) {
                        zzw2 = zzgz.zzw(i5 << 3);
                        zzw8 = zzw2 + 4;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(t, i5, i4)) {
                        zzw5 = zzgz.zzw(i5 << 3);
                        zzw8 = zzw5 + 1;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzM(t, i5, i4)) {
                        break;
                    } else {
                        Object zzn2 = zzkh.zzn(t, j2);
                        if (zzn2 instanceof zzgs) {
                            zzw6 = zzgz.zzw(i5 << 3);
                            zzc = ((zzgs) zzn2).zzc();
                            zzw7 = zzgz.zzw(zzc);
                            i2 = zzw6 + zzw7 + zzc;
                            i3 += i2;
                            break;
                        } else {
                            zzw4 = zzgz.zzw(i5 << 3);
                            zzv = zzgz.zzy((String) zzn2);
                            i2 = zzw4 + zzv;
                            i3 += i2;
                        }
                    }
                case 60:
                    if (zzM(t, i5, i4)) {
                        zzw8 = zzjk.zzw(i5, zzkh.zzn(t, j2), zzv(i4));
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(t, i5, i4)) {
                        zzw6 = zzgz.zzw(i5 << 3);
                        zzc = ((zzgs) zzkh.zzn(t, j2)).zzc();
                        zzw7 = zzgz.zzw(zzc);
                        i2 = zzw6 + zzw7 + zzc;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(t, i5, i4)) {
                        int zzF2 = zzF(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzw(zzF2);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(t, i5, i4)) {
                        int zzF3 = zzF(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzv(zzF3);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(t, i5, i4)) {
                        zzw2 = zzgz.zzw(i5 << 3);
                        zzw8 = zzw2 + 4;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(t, i5, i4)) {
                        zzw = zzgz.zzw(i5 << 3);
                        zzw8 = zzw + 8;
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(t, i5, i4)) {
                        int zzF4 = zzF(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzw((zzF4 >> 31) ^ (zzF4 + zzF4));
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(t, i5, i4)) {
                        long zzG3 = zzG(t, j2);
                        zzw4 = zzgz.zzw(i5 << 3);
                        zzv = zzgz.zzx((zzG3 >> 63) ^ (zzG3 + zzG3));
                        i2 = zzw4 + zzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(t, i5, i4)) {
                        zzw8 = zzgz.zzE(i5, (zzix) zzkh.zzn(t, j2), zzv(i4));
                        i3 += zzw8;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzjw<?, ?> zzjwVar = this.zzn;
        return i3 + zzjwVar.zzh(zzjwVar.zzd(t));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x021a -> B:120:0x021b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x014f -> B:67:0x0150). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01cc -> B:100:0x01cd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzs(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzge r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzja.zzs(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzge):int");
    }

    private final <K, V> int zzt(T t, byte[] bArr, int i2, int i3, int i4, long j2, zzge zzgeVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzw = zzw(i4);
        Object object = unsafe.getObject(t, j2);
        if (!((zzir) object).zze()) {
            zzir<K, V> zzc = zzir.zza().zzc();
            zzis.zzb(zzc, object);
            unsafe.putObject(t, j2, zzc);
        }
        zziq zziqVar = (zziq) zzw;
        throw null;
    }

    private final int zzu(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, zzge zzgeVar) throws IOException {
        Unsafe unsafe = zzb;
        long j3 = this.zzc[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(Double.longBitsToDouble(zzgf.zze(bArr, i2))));
                    unsafe.putInt(t, j3, i5);
                    return i2 + 8;
                }
                break;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(Float.intBitsToFloat(zzgf.zzd(bArr, i2))));
                    unsafe.putInt(t, j3, i5);
                    return i2 + 4;
                }
                break;
            case 53:
            case 54:
                if (i6 == 0) {
                    int zzc = zzgf.zzc(bArr, i2, zzgeVar);
                    unsafe.putObject(t, j2, Long.valueOf(zzgeVar.zzb));
                    unsafe.putInt(t, j3, i5);
                    return zzc;
                }
                break;
            case 55:
            case 62:
                if (i6 == 0) {
                    int zza2 = zzgf.zza(bArr, i2, zzgeVar);
                    unsafe.putObject(t, j2, Integer.valueOf(zzgeVar.zza));
                    unsafe.putInt(t, j3, i5);
                    return zza2;
                }
                break;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(zzgf.zze(bArr, i2)));
                    unsafe.putInt(t, j3, i5);
                    return i2 + 8;
                }
                break;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(zzgf.zzd(bArr, i2)));
                    unsafe.putInt(t, j3, i5);
                    return i2 + 4;
                }
                break;
            case 58:
                if (i6 == 0) {
                    int zzc2 = zzgf.zzc(bArr, i2, zzgeVar);
                    unsafe.putObject(t, j2, Boolean.valueOf(zzgeVar.zzb != 0));
                    unsafe.putInt(t, j3, i5);
                    return zzc2;
                }
                break;
            case 59:
                if (i6 == 2) {
                    int zza3 = zzgf.zza(bArr, i2, zzgeVar);
                    int i10 = zzgeVar.zza;
                    if (i10 == 0) {
                        unsafe.putObject(t, j2, "");
                    } else if ((i7 & 536870912) != 0 && !zzkn.zzb(bArr, zza3, zza3 + i10)) {
                        throw zzic.zzf();
                    } else {
                        unsafe.putObject(t, j2, new String(bArr, zza3, i10, zzia.zza));
                        zza3 += i10;
                    }
                    unsafe.putInt(t, j3, i5);
                    return zza3;
                }
                break;
            case 60:
                if (i6 == 2) {
                    int zzi = zzgf.zzi(zzv(i9), bArr, i2, i3, zzgeVar);
                    Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, zzgeVar.zzc);
                    } else {
                        unsafe.putObject(t, j2, zzia.zzi(object, zzgeVar.zzc));
                    }
                    unsafe.putInt(t, j3, i5);
                    return zzi;
                }
                break;
            case 61:
                if (i6 == 2) {
                    int zzh = zzgf.zzh(bArr, i2, zzgeVar);
                    unsafe.putObject(t, j2, zzgeVar.zzc);
                    unsafe.putInt(t, j3, i5);
                    return zzh;
                }
                break;
            case 63:
                if (i6 == 0) {
                    int zza4 = zzgf.zza(bArr, i2, zzgeVar);
                    int i11 = zzgeVar.zza;
                    zzhw zzx = zzx(i9);
                    if (zzx != null && !zzx.zza(i11)) {
                        zzf(t).zzh(i4, Long.valueOf(i11));
                    } else {
                        unsafe.putObject(t, j2, Integer.valueOf(i11));
                        unsafe.putInt(t, j3, i5);
                    }
                    return zza4;
                }
                break;
            case 66:
                if (i6 == 0) {
                    int zza5 = zzgf.zza(bArr, i2, zzgeVar);
                    unsafe.putObject(t, j2, Integer.valueOf(zzgv.zzb(zzgeVar.zza)));
                    unsafe.putInt(t, j3, i5);
                    return zza5;
                }
                break;
            case 67:
                if (i6 == 0) {
                    int zzc3 = zzgf.zzc(bArr, i2, zzgeVar);
                    unsafe.putObject(t, j2, Long.valueOf(zzgv.zzc(zzgeVar.zzb)));
                    unsafe.putInt(t, j3, i5);
                    return zzc3;
                }
                break;
            case 68:
                if (i6 == 3) {
                    int zzj = zzgf.zzj(zzv(i9), bArr, i2, i3, (i4 & (-8)) | 4, zzgeVar);
                    Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, zzgeVar.zzc);
                    } else {
                        unsafe.putObject(t, j2, zzia.zzi(object2, zzgeVar.zzc));
                    }
                    unsafe.putInt(t, j3, i5);
                    return zzj;
                }
                break;
        }
        return i2;
    }

    private final zzji zzv(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        zzji zzjiVar = (zzji) this.zzd[i4];
        if (zzjiVar != null) {
            return zzjiVar;
        }
        zzji<T> zzb2 = zzjf.zza().zzb((Class) this.zzd[i4 + 1]);
        this.zzd[i4] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i2) {
        int i3 = i2 / 3;
        return this.zzd[i3 + i3];
    }

    private final zzhw zzx(int i2) {
        int i3 = i2 / 3;
        return (zzhw) this.zzd[i3 + i3 + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a8, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02aa, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r19;
        r1 = r20;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02be, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02f1, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0314, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzy(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzge r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzja.zzy(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzge):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzz(Object obj, int i2, zzji zzjiVar) {
        return zzjiVar.zzj(zzkh.zzn(obj, i2 & 1048575));
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final T zza() {
        return (T) ((zzhs) this.zzg).zzl(4, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final boolean zzb(T t, T t2) {
        boolean zzD;
        int length = this.zzc.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzA = zzA(i2);
            long j2 = zzA & 1048575;
            switch (zzC(zzA)) {
                case 0:
                    if (zzI(t, t2, i2) && Double.doubleToLongBits(zzkh.zzl(t, j2)) == Double.doubleToLongBits(zzkh.zzl(t2, j2))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzI(t, t2, i2) && Float.floatToIntBits(zzkh.zzj(t, j2)) == Float.floatToIntBits(zzkh.zzj(t2, j2))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzI(t, t2, i2) && zzkh.zzf(t, j2) == zzkh.zzf(t2, j2)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzI(t, t2, i2) && zzkh.zzf(t, j2) == zzkh.zzf(t2, j2)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzI(t, t2, i2) && zzkh.zzd(t, j2) == zzkh.zzd(t2, j2)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzI(t, t2, i2) && zzkh.zzf(t, j2) == zzkh.zzf(t2, j2)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzI(t, t2, i2) && zzkh.zzd(t, j2) == zzkh.zzd(t2, j2)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzI(t, t2, i2) && zzkh.zzh(t, j2) == zzkh.zzh(t2, j2)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzI(t, t2, i2) && zzjk.zzD(zzkh.zzn(t, j2), zzkh.zzn(t2, j2))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzI(t, t2, i2) && zzjk.zzD(zzkh.zzn(t, j2), zzkh.zzn(t2, j2))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzI(t, t2, i2) && zzjk.zzD(zzkh.zzn(t, j2), zzkh.zzn(t2, j2))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzI(t, t2, i2) && zzkh.zzd(t, j2) == zzkh.zzd(t2, j2)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzI(t, t2, i2) && zzkh.zzd(t, j2) == zzkh.zzd(t2, j2)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzI(t, t2, i2) && zzkh.zzd(t, j2) == zzkh.zzd(t2, j2)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzI(t, t2, i2) && zzkh.zzf(t, j2) == zzkh.zzf(t2, j2)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzI(t, t2, i2) && zzkh.zzd(t, j2) == zzkh.zzd(t2, j2)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzI(t, t2, i2) && zzkh.zzf(t, j2) == zzkh.zzf(t2, j2)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzI(t, t2, i2) && zzjk.zzD(zzkh.zzn(t, j2), zzkh.zzn(t2, j2))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzD = zzjk.zzD(zzkh.zzn(t, j2), zzkh.zzn(t2, j2));
                    break;
                case 50:
                    zzD = zzjk.zzD(zzkh.zzn(t, j2), zzkh.zzn(t2, j2));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzB = zzB(i2) & 1048575;
                    if (zzkh.zzd(t, zzB) == zzkh.zzd(t2, zzB) && zzjk.zzD(zzkh.zzn(t, j2), zzkh.zzn(t2, j2))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzD) {
                return false;
            }
        }
        if (this.zzn.zzd(t).equals(this.zzn.zzd(t2))) {
            if (this.zzh) {
                this.zzo.zzb(t);
                this.zzo.zzb(t2);
                throw null;
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final int zzc(T t) {
        int i2;
        int zze;
        int length = this.zzc.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzA = zzA(i4);
            int i5 = this.zzc[i4];
            long j2 = 1048575 & zzA;
            int i6 = 37;
            switch (zzC(zzA)) {
                case 0:
                    i2 = i3 * 53;
                    zze = zzia.zze(Double.doubleToLongBits(zzkh.zzl(t, j2)));
                    i3 = i2 + zze;
                    break;
                case 1:
                    i2 = i3 * 53;
                    zze = Float.floatToIntBits(zzkh.zzj(t, j2));
                    i3 = i2 + zze;
                    break;
                case 2:
                    i2 = i3 * 53;
                    zze = zzia.zze(zzkh.zzf(t, j2));
                    i3 = i2 + zze;
                    break;
                case 3:
                    i2 = i3 * 53;
                    zze = zzia.zze(zzkh.zzf(t, j2));
                    i3 = i2 + zze;
                    break;
                case 4:
                    i2 = i3 * 53;
                    zze = zzkh.zzd(t, j2);
                    i3 = i2 + zze;
                    break;
                case 5:
                    i2 = i3 * 53;
                    zze = zzia.zze(zzkh.zzf(t, j2));
                    i3 = i2 + zze;
                    break;
                case 6:
                    i2 = i3 * 53;
                    zze = zzkh.zzd(t, j2);
                    i3 = i2 + zze;
                    break;
                case 7:
                    i2 = i3 * 53;
                    zze = zzia.zzf(zzkh.zzh(t, j2));
                    i3 = i2 + zze;
                    break;
                case 8:
                    i2 = i3 * 53;
                    zze = ((String) zzkh.zzn(t, j2)).hashCode();
                    i3 = i2 + zze;
                    break;
                case 9:
                    Object zzn = zzkh.zzn(t, j2);
                    if (zzn != null) {
                        i6 = zzn.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    zze = zzkh.zzn(t, j2).hashCode();
                    i3 = i2 + zze;
                    break;
                case 11:
                    i2 = i3 * 53;
                    zze = zzkh.zzd(t, j2);
                    i3 = i2 + zze;
                    break;
                case 12:
                    i2 = i3 * 53;
                    zze = zzkh.zzd(t, j2);
                    i3 = i2 + zze;
                    break;
                case 13:
                    i2 = i3 * 53;
                    zze = zzkh.zzd(t, j2);
                    i3 = i2 + zze;
                    break;
                case 14:
                    i2 = i3 * 53;
                    zze = zzia.zze(zzkh.zzf(t, j2));
                    i3 = i2 + zze;
                    break;
                case 15:
                    i2 = i3 * 53;
                    zze = zzkh.zzd(t, j2);
                    i3 = i2 + zze;
                    break;
                case 16:
                    i2 = i3 * 53;
                    zze = zzia.zze(zzkh.zzf(t, j2));
                    i3 = i2 + zze;
                    break;
                case 17:
                    Object zzn2 = zzkh.zzn(t, j2);
                    if (zzn2 != null) {
                        i6 = zzn2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    zze = zzkh.zzn(t, j2).hashCode();
                    i3 = i2 + zze;
                    break;
                case 50:
                    i2 = i3 * 53;
                    zze = zzkh.zzn(t, j2).hashCode();
                    i3 = i2 + zze;
                    break;
                case 51:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzia.zze(Double.doubleToLongBits(zzD(t, j2)));
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = Float.floatToIntBits(zzE(t, j2));
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzia.zze(zzG(t, j2));
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzia.zze(zzG(t, j2));
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzF(t, j2);
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzia.zze(zzG(t, j2));
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzF(t, j2);
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzia.zzf(zzH(t, j2));
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = ((String) zzkh.zzn(t, j2)).hashCode();
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzkh.zzn(t, j2).hashCode();
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzkh.zzn(t, j2).hashCode();
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzF(t, j2);
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzF(t, j2);
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzF(t, j2);
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzia.zze(zzG(t, j2));
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzF(t, j2);
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzia.zze(zzG(t, j2));
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(t, i5, i4)) {
                        i2 = i3 * 53;
                        zze = zzkh.zzn(t, j2).hashCode();
                        i3 = i2 + zze;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzn.zzd(t).hashCode();
        if (this.zzh) {
            this.zzo.zzb(t);
            throw null;
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final void zzd(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
            int zzA = zzA(i2);
            long j2 = 1048575 & zzA;
            int i3 = this.zzc[i2];
            switch (zzC(zzA)) {
                case 0:
                    if (zzK(t2, i2)) {
                        zzkh.zzm(t, j2, zzkh.zzl(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzK(t2, i2)) {
                        zzkh.zzk(t, j2, zzkh.zzj(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzK(t2, i2)) {
                        zzkh.zzg(t, j2, zzkh.zzf(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzK(t2, i2)) {
                        zzkh.zzg(t, j2, zzkh.zzf(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzK(t2, i2)) {
                        zzkh.zze(t, j2, zzkh.zzd(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzK(t2, i2)) {
                        zzkh.zzg(t, j2, zzkh.zzf(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzK(t2, i2)) {
                        zzkh.zze(t, j2, zzkh.zzd(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzK(t2, i2)) {
                        zzkh.zzi(t, j2, zzkh.zzh(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzK(t2, i2)) {
                        zzkh.zzo(t, j2, zzkh.zzn(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzo(t, t2, i2);
                    break;
                case 10:
                    if (zzK(t2, i2)) {
                        zzkh.zzo(t, j2, zzkh.zzn(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzK(t2, i2)) {
                        zzkh.zze(t, j2, zzkh.zzd(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzK(t2, i2)) {
                        zzkh.zze(t, j2, zzkh.zzd(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzK(t2, i2)) {
                        zzkh.zze(t, j2, zzkh.zzd(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzK(t2, i2)) {
                        zzkh.zzg(t, j2, zzkh.zzf(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzK(t2, i2)) {
                        zzkh.zze(t, j2, zzkh.zzd(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzK(t2, i2)) {
                        zzkh.zzg(t, j2, zzkh.zzf(t2, j2));
                        zzL(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzo(t, t2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(t, t2, j2);
                    break;
                case 50:
                    zzjk.zzI(this.zzq, t, t2, j2);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(t2, i3, i2)) {
                        zzkh.zzo(t, j2, zzkh.zzn(t2, j2));
                        zzN(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzp(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(t2, i3, i2)) {
                        zzkh.zzo(t, j2, zzkh.zzn(t2, j2));
                        zzN(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzp(t, t2, i2);
                    break;
            }
        }
        zzjk.zzF(this.zzn, t, t2);
        if (this.zzh) {
            zzjk.zzE(this.zzo, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final int zze(T t) {
        return this.zzi ? zzr(t) : zzq(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0417, code lost:
        if (r6 == 1048575) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0419, code lost:
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x041f, code lost:
        r3 = r9.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0423, code lost:
        if (r3 >= r9.zzl) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0425, code lost:
        r4 = r9.zzj[r3];
        r5 = r9.zzc[r4];
        r5 = com.google.android.gms.internal.measurement.zzkh.zzn(r12, r9.zzA(r4) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0437, code lost:
        if (r5 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x043e, code lost:
        if (r9.zzx(r4) != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0440, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0443, code lost:
        r5 = (com.google.android.gms.internal.measurement.zzir) r5;
        r0 = (com.google.android.gms.internal.measurement.zziq) r9.zzw(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x044b, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x044c, code lost:
        if (r7 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0450, code lost:
        if (r0 != r32) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0457, code lost:
        throw com.google.android.gms.internal.measurement.zzic.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x045a, code lost:
        if (r0 > r32) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x045c, code lost:
        if (r1 != r7) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x045e, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0463, code lost:
        throw com.google.android.gms.internal.measurement.zzic.zze();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzg(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.zzge r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzja.zzg(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzge):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final void zzh(T t, byte[] bArr, int i2, int i3, zzge zzgeVar) throws IOException {
        if (this.zzi) {
            zzy(t, bArr, i2, i3, zzgeVar);
        } else {
            zzg(t, bArr, i2, i3, 0, zzgeVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final void zzi(T t) {
        int i2;
        int i3 = this.zzk;
        while (true) {
            i2 = this.zzl;
            if (i3 >= i2) {
                break;
            }
            long zzA = zzA(this.zzj[i3]) & 1048575;
            Object zzn = zzkh.zzn(t, zzA);
            if (zzn != null) {
                ((zzir) zzn).zzd();
                zzkh.zzo(t, zzA, zzn);
            }
            i3++;
        }
        int length = this.zzj.length;
        while (i2 < length) {
            this.zzm.zza(t, this.zzj[i2]);
            i2++;
        }
        this.zzn.zze(t);
        if (this.zzh) {
            this.zzo.zzc(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzji
    public final boolean zzj(T t) {
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzk) {
            int i7 = this.zzj[i6];
            int i8 = this.zzc[i7];
            int zzA = zzA(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(t, i10);
                }
                i3 = i5;
                i2 = i10;
            } else {
                i2 = i4;
                i3 = i5;
            }
            if ((268435456 & zzA) != 0 && !zzJ(t, i7, i2, i3, i11)) {
                return false;
            }
            int zzC = zzC(zzA);
            if (zzC != 9 && zzC != 17) {
                if (zzC != 27) {
                    if (zzC == 60 || zzC == 68) {
                        if (zzM(t, i8, i7) && !zzz(t, zzA, zzv(i7))) {
                            return false;
                        }
                    } else if (zzC != 49) {
                        if (zzC == 50 && !((zzir) zzkh.zzn(t, zzA & 1048575)).isEmpty()) {
                            zziq zziqVar = (zziq) zzw(i7);
                            throw null;
                        }
                    }
                }
                List list = (List) zzkh.zzn(t, zzA & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzji zzv = zzv(i7);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zzv.zzj(list.get(i12))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzJ(t, i7, i2, i3, i11) && !zzz(t, zzA, zzv(i7))) {
                return false;
            }
            i6++;
            i4 = i2;
            i5 = i3;
        }
        if (this.zzh) {
            this.zzo.zzb(t);
            throw null;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final void zzm(T t, zzha zzhaVar) throws IOException {
        if (!this.zzi) {
            zzR(t, zzhaVar);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i2 = 0; i2 < length; i2 += 3) {
                int zzA = zzA(i2);
                int i3 = this.zzc[i2];
                switch (zzC(zzA)) {
                    case 0:
                        if (zzK(t, i2)) {
                            zzhaVar.zzf(i3, zzkh.zzl(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzK(t, i2)) {
                            zzhaVar.zze(i3, zzkh.zzj(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzK(t, i2)) {
                            zzhaVar.zzc(i3, zzkh.zzf(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzK(t, i2)) {
                            zzhaVar.zzh(i3, zzkh.zzf(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzK(t, i2)) {
                            zzhaVar.zzi(i3, zzkh.zzd(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzK(t, i2)) {
                            zzhaVar.zzj(i3, zzkh.zzf(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzK(t, i2)) {
                            zzhaVar.zzk(i3, zzkh.zzd(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzK(t, i2)) {
                            zzhaVar.zzl(i3, zzkh.zzh(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzK(t, i2)) {
                            zzT(i3, zzkh.zzn(t, zzA & 1048575), zzhaVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zzK(t, i2)) {
                            zzhaVar.zzr(i3, zzkh.zzn(t, zzA & 1048575), zzv(i2));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzK(t, i2)) {
                            zzhaVar.zzn(i3, (zzgs) zzkh.zzn(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzK(t, i2)) {
                            zzhaVar.zzo(i3, zzkh.zzd(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzK(t, i2)) {
                            zzhaVar.zzg(i3, zzkh.zzd(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzK(t, i2)) {
                            zzhaVar.zzb(i3, zzkh.zzd(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzK(t, i2)) {
                            zzhaVar.zzd(i3, zzkh.zzf(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzK(t, i2)) {
                            zzhaVar.zzp(i3, zzkh.zzd(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzK(t, i2)) {
                            zzhaVar.zzq(i3, zzkh.zzf(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzK(t, i2)) {
                            zzhaVar.zzs(i3, zzkh.zzn(t, zzA & 1048575), zzv(i2));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzjk.zzJ(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 19:
                        zzjk.zzK(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 20:
                        zzjk.zzL(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 21:
                        zzjk.zzM(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 22:
                        zzjk.zzQ(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 23:
                        zzjk.zzO(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 24:
                        zzjk.zzT(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 25:
                        zzjk.zzW(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 26:
                        zzjk.zzX(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar);
                        break;
                    case 27:
                        zzjk.zzZ(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, zzv(i2));
                        break;
                    case 28:
                        zzjk.zzY(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar);
                        break;
                    case 29:
                        zzjk.zzR(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 30:
                        zzjk.zzV(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 31:
                        zzjk.zzU(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 32:
                        zzjk.zzP(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 33:
                        zzjk.zzS(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 34:
                        zzjk.zzN(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, false);
                        break;
                    case 35:
                        zzjk.zzJ(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 36:
                        zzjk.zzK(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 37:
                        zzjk.zzL(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 38:
                        zzjk.zzM(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 39:
                        zzjk.zzQ(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 40:
                        zzjk.zzO(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 41:
                        zzjk.zzT(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 42:
                        zzjk.zzW(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 43:
                        zzjk.zzR(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 44:
                        zzjk.zzV(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 45:
                        zzjk.zzU(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 46:
                        zzjk.zzP(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 47:
                        zzjk.zzS(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 48:
                        zzjk.zzN(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, true);
                        break;
                    case 49:
                        zzjk.zzaa(this.zzc[i2], (List) zzkh.zzn(t, zzA & 1048575), zzhaVar, zzv(i2));
                        break;
                    case 50:
                        zzS(zzhaVar, i3, zzkh.zzn(t, zzA & 1048575), i2);
                        break;
                    case 51:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzf(i3, zzD(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zze(i3, zzE(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzc(i3, zzG(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzh(i3, zzG(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzi(i3, zzF(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzj(i3, zzG(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzk(i3, zzF(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzl(i3, zzH(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzM(t, i3, i2)) {
                            zzT(i3, zzkh.zzn(t, zzA & 1048575), zzhaVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzr(i3, zzkh.zzn(t, zzA & 1048575), zzv(i2));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzn(i3, (zzgs) zzkh.zzn(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzo(i3, zzF(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzg(i3, zzF(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzb(i3, zzF(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzd(i3, zzG(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzp(i3, zzF(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzq(i3, zzG(t, zzA & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzM(t, i3, i2)) {
                            zzhaVar.zzs(i3, zzkh.zzn(t, zzA & 1048575), zzv(i2));
                            break;
                        } else {
                            break;
                        }
                }
            }
            zzjw<?, ?> zzjwVar = this.zzn;
            zzjwVar.zzi(zzjwVar.zzd(t), zzhaVar);
        } else {
            this.zzo.zzb(t);
            throw null;
        }
    }
}
