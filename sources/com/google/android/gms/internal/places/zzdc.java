package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzdc {
    private static final Class<?> zzlv = zzdc();
    private static final zzds<?, ?> zzlw = zzf(false);
    private static final zzds<?, ?> zzlx = zzf(true);
    private static final zzds<?, ?> zzly = new zzdu();

    public static void zzb(int i2, List<Double> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzh(i2, list, z);
    }

    public static void zzc(int i2, List<Float> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzg(i2, list, z);
    }

    public static zzds<?, ?> zzcz() {
        return zzlw;
    }

    public static void zzd(int i2, List<Long> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzd(i2, list, z);
    }

    public static zzds<?, ?> zzda() {
        return zzlx;
    }

    public static zzds<?, ?> zzdb() {
        return zzly;
    }

    private static Class<?> zzdc() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzdd() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zze(int i2, List<Long> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zze(i2, list, z);
    }

    public static void zzf(int i2, List<Long> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzo(i2, list, z);
    }

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzbc.class.isAssignableFrom(cls) && (cls2 = zzlv) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzh(int i2, List<Long> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzm(i2, list, z);
    }

    public static void zzi(int i2, List<Integer> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzb(i2, list, z);
    }

    public static void zzj(int i2, List<Integer> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzk(i2, list, z);
    }

    public static void zzk(int i2, List<Integer> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzn(i2, list, z);
    }

    public static void zzl(int i2, List<Integer> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzc(i2, list, z);
    }

    public static void zzm(int i2, List<Integer> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzl(i2, list, z);
    }

    public static void zzn(int i2, List<Integer> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzi(i2, list, z);
    }

    public static void zzo(int i2, List<Boolean> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzj(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zze(list) + (list.size() * zzaj.zzr(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzaj.zzr(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzaj.zzr(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzaj.zzr(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzaj.zzr(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzaj.zzr(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzaj.zzr(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzk(i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzh(i2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzd(i2, true);
    }

    public static void zzb(int i2, List<String> list, zzel zzelVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzb(i2, list);
    }

    public static void zzc(int i2, List<zzw> list, zzel zzelVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzc(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i2, List<?> list) {
        int zzk;
        int zzk2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int zzr = zzaj.zzr(i2) * size;
        if (list instanceof zzbr) {
            zzbr zzbrVar = (zzbr) list;
            while (i3 < size) {
                Object zzae = zzbrVar.zzae(i3);
                if (zzae instanceof zzw) {
                    zzk2 = zzaj.zzc((zzw) zzae);
                } else {
                    zzk2 = zzaj.zzk((String) zzae);
                }
                zzr += zzk2;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzw) {
                    zzk = zzaj.zzc((zzw) obj);
                } else {
                    zzk = zzaj.zzk((String) obj);
                }
                zzr += zzk;
                i3++;
            }
        }
        return zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzbyVar = (zzby) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzf(zzbyVar.getLong(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzf(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzbyVar = (zzby) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzg(zzbyVar.getLong(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzg(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbeVar = (zzbe) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzx(zzbeVar.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzx(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbeVar = (zzbe) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzs(zzbeVar.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzs(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbeVar = (zzbe) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzt(zzbeVar.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzt(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbeVar = (zzbe) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzu(zzbeVar.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzu(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(List<?> list) {
        return list.size();
    }

    public static void zzg(int i2, List<Long> list, zzel zzelVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzf(i2, list, z);
    }

    public static void zzb(int i2, List<?> list, zzel zzelVar, zzda zzdaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzb(i2, list, zzdaVar);
    }

    public static void zzc(int i2, List<?> list, zzel zzelVar, zzda zzdaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzelVar.zzc(i2, list, zzdaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzbyVar = (zzby) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzh(zzbyVar.getLong(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzaj.zzh(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zzb(zzcd zzcdVar, T t, T t2, long j2) {
        zzdy.zzb(t, j2, zzcdVar.zzc(zzdy.zzp(t, j2), zzdy.zzp(t2, j2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i2, List<zzw> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = size * zzaj.zzr(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzr += zzaj.zzc(list.get(i3));
        }
        return zzr;
    }

    private static zzds<?, ?> zzf(boolean z) {
        try {
            Class<?> zzdd = zzdd();
            if (zzdd == null) {
                return null;
            }
            return (zzds) zzdd.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzax<FT>> void zzb(zzar<FT> zzarVar, T t, T t2) {
        zzav<FT> zzb = zzarVar.zzb(t2);
        if (zzb.zzfj.isEmpty()) {
            return;
        }
        zzarVar.zzc(t).zzb(zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i2, List<zzck> list, zzda zzdaVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzaj.zzd(i2, list.get(i4), zzdaVar);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zzb(zzds<UT, UB> zzdsVar, T t, T t2) {
        zzdsVar.zzf(t, zzdsVar.zzh(zzdsVar.zzr(t), zzdsVar.zzr(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i2, Object obj, zzda zzdaVar) {
        if (obj instanceof zzbp) {
            return zzaj.zzb(i2, (zzbp) obj);
        }
        return zzaj.zzc(i2, (zzck) obj, zzdaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zzb(int i2, List<Integer> list, zzbf zzbfVar, UB ub, zzds<UT, UB> zzdsVar) {
        if (zzbfVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (zzbfVar.zzad(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) zzb(i2, intValue, ub, zzdsVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzbfVar.zzad(intValue2)) {
                    ub = (UB) zzb(i2, intValue2, ub, zzdsVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i2, List<?> list, zzda zzdaVar) {
        int zzb;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = zzaj.zzr(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzbp) {
                zzb = zzaj.zzb((zzbp) obj);
            } else {
                zzb = zzaj.zzb((zzck) obj, zzdaVar);
            }
            zzr += zzb;
        }
        return zzr;
    }

    private static <UT, UB> UB zzb(int i2, int i3, UB ub, zzds<UT, UB> zzdsVar) {
        if (ub == null) {
            ub = zzdsVar.zzdk();
        }
        zzdsVar.zzb((zzds<UT, UB>) ub, i2, i3);
        return ub;
    }
}
