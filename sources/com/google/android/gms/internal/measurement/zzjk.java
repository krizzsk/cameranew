package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzjk {
    private static final Class<?> zza;
    private static final zzjw<?, ?> zzb;
    private static final zzjw<?, ?> zzc;
    private static final zzjw<?, ?> zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzjy();
    }

    public static zzjw<?, ?> zzA() {
        return zzb;
    }

    public static zzjw<?, ?> zzB() {
        return zzc;
    }

    public static zzjw<?, ?> zzC() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzhi<FT>> void zzE(zzhf<FT> zzhfVar, T t, T t2) {
        zzhfVar.zzb(t2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zzF(zzjw<UT, UB> zzjwVar, T t, T t2) {
        zzjwVar.zzc(t, zzjwVar.zzf(zzjwVar.zzd(t), zzjwVar.zzd(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zzG(int i2, List<Integer> list, zzhw zzhwVar, UB ub, zzjw<UT, UB> zzjwVar) {
        if (zzhwVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (zzhwVar.zza(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) zzH(i2, intValue, ub, zzjwVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzhwVar.zza(intValue2)) {
                    ub = (UB) zzH(i2, intValue2, ub, zzjwVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zzH(int i2, int i3, UB ub, zzjw<UT, UB> zzjwVar) {
        if (ub == null) {
            ub = zzjwVar.zzb();
        }
        zzjwVar.zza(ub, i2, i3);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zzI(zzis zzisVar, T t, T t2, long j2) {
        zzkh.zzo(t, j2, zzis.zzb(zzkh.zzn(t, j2), zzkh.zzn(t2, j2)));
    }

    public static void zzJ(int i2, List<Double> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzB(i2, list, z);
    }

    public static void zzK(int i2, List<Float> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzA(i2, list, z);
    }

    public static void zzL(int i2, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzx(i2, list, z);
    }

    public static void zzM(int i2, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzy(i2, list, z);
    }

    public static void zzN(int i2, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzK(i2, list, z);
    }

    public static void zzO(int i2, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzz(i2, list, z);
    }

    public static void zzP(int i2, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzI(i2, list, z);
    }

    public static void zzQ(int i2, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzv(i2, list, z);
    }

    public static void zzR(int i2, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzG(i2, list, z);
    }

    public static void zzS(int i2, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzJ(i2, list, z);
    }

    public static void zzT(int i2, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzw(i2, list, z);
    }

    public static void zzU(int i2, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzH(i2, list, z);
    }

    public static void zzV(int i2, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzC(i2, list, z);
    }

    public static void zzW(int i2, List<Boolean> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzD(i2, list, z);
    }

    public static void zzX(int i2, List<String> list, zzha zzhaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzE(i2, list);
    }

    public static void zzY(int i2, List<zzgs> list, zzha zzhaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzF(i2, list);
    }

    public static void zzZ(int i2, List<?> list, zzha zzhaVar, zzji zzjiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzhaVar.zzr(i2, list.get(i3), zzjiVar);
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzhs.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i2, List<?> list, zzha zzhaVar, zzji zzjiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzhaVar.zzs(i2, list.get(i3), zzjiVar);
        }
    }

    private static zzjw<?, ?> zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzjw) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzim) {
            zzim zzimVar = (zzim) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzx(zzimVar.zzc(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzx(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzgz.zzu(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzim) {
            zzim zzimVar = (zzim) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzx(zzimVar.zzc(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzx(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzgz.zzu(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzim) {
            zzim zzimVar = (zzim) list;
            i2 = 0;
            while (i3 < size) {
                long zzc2 = zzimVar.zzc(i3);
                i2 += zzgz.zzx((zzc2 >> 63) ^ (zzc2 + zzc2));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                long longValue = list.get(i3).longValue();
                i2 += zzgz.zzx((longValue >> 63) ^ (longValue + longValue));
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzgz.zzu(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzhtVar = (zzht) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzv(zzhtVar.zzg(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzv(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzgz.zzu(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzhtVar = (zzht) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzv(zzhtVar.zzg(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzv(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzgz.zzu(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzhtVar = (zzht) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzw(zzhtVar.zzg(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzgz.zzw(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzgz.zzu(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzhtVar = (zzht) list;
            i2 = 0;
            while (i3 < size) {
                int zzg = zzhtVar.zzg(i3);
                i2 += zzgz.zzw((zzg >> 31) ^ (zzg + zzg));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                int intValue = list.get(i3).intValue();
                i2 += zzgz.zzw((intValue >> 31) ^ (intValue + intValue));
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzgz.zzu(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(List<?> list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i2 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(List<?> list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i2 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i2 << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i2, List<?> list) {
        int zzy;
        int zzy2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int zzu = zzgz.zzu(i2) * size;
        if (list instanceof zzih) {
            zzih zzihVar = (zzih) list;
            while (i3 < size) {
                Object zzg = zzihVar.zzg(i3);
                if (zzg instanceof zzgs) {
                    zzy2 = zzgz.zzA((zzgs) zzg);
                } else {
                    zzy2 = zzgz.zzy((String) zzg);
                }
                zzu += zzy2;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzgs) {
                    zzy = zzgz.zzA((zzgs) obj);
                } else {
                    zzy = zzgz.zzy((String) obj);
                }
                zzu += zzy;
                i3++;
            }
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i2, Object obj, zzji zzjiVar) {
        if (obj instanceof zzif) {
            int zzw = zzgz.zzw(i2 << 3);
            int zza2 = ((zzif) obj).zza();
            return zzw + zzgz.zzw(zza2) + zza2;
        }
        return zzgz.zzw(i2 << 3) + zzgz.zzB((zzix) obj, zzjiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i2, List<?> list, zzji zzjiVar) {
        int zzB;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzgz.zzu(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzif) {
                zzB = zzgz.zzz((zzif) obj);
            } else {
                zzB = zzgz.zzB((zzix) obj, zzjiVar);
            }
            zzu += zzB;
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(int i2, List<zzgs> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = size * zzgz.zzu(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzu += zzgz.zzA(list.get(i3));
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(int i2, List<zzix> list, zzji zzjiVar) {
        int size = list.size();
        if (size != 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                i3 += zzgz.zzE(i2, list.get(i4), zzjiVar);
            }
            return i3;
        }
        return 0;
    }
}
