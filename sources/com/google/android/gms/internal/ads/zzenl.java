package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzenl {
    private static final Class<?> zziui = zzbko();
    private static final zzeob<?, ?> zziuj = zzbu(false);
    private static final zzeob<?, ?> zziuk = zzbu(true);
    private static final zzeob<?, ?> zziul = new zzeod();

    public static void zza(int i2, List<Double> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzg(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzac(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzemc) {
            zzemc zzemcVar = (zzemc) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzfk(zzemcVar.getLong(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzfk(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzad(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzemc) {
            zzemc zzemcVar = (zzemc) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzfl(zzemcVar.getLong(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzfl(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzae(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzemc) {
            zzemc zzemcVar = (zzemc) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzfm(zzemcVar.getLong(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzfm(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzaf(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzhb(zzeleVar.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzhb(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzag(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzgw(zzeleVar.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzgw(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzah(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzgx(zzeleVar.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzgx(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzai(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzgy(zzeleVar.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzekl.zzgy(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzaj(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzak(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzal(List<?> list) {
        return list.size();
    }

    public static void zzb(int i2, List<Float> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzf(i2, list, z);
    }

    public static zzeob<?, ?> zzbkl() {
        return zziuj;
    }

    public static zzeob<?, ?> zzbkm() {
        return zziuk;
    }

    public static zzeob<?, ?> zzbkn() {
        return zziul;
    }

    private static Class<?> zzbko() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbkp() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static zzeob<?, ?> zzbu(boolean z) {
        try {
            Class<?> zzbkp = zzbkp();
            if (zzbkp == null) {
                return null;
            }
            return (zzeob) zzbkp.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzc(int i2, List<Long> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzc(i2, list, z);
    }

    public static void zzd(int i2, List<Long> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzd(i2, list, z);
    }

    public static void zze(int i2, List<Long> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzn(i2, list, z);
    }

    public static void zzf(int i2, List<Long> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zze(i2, list, z);
    }

    public static void zzg(int i2, List<Long> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzl(i2, list, z);
    }

    public static void zzh(int i2, List<Integer> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zza(i2, list, z);
    }

    public static void zzi(Class<?> cls) {
        Class<?> cls2;
        if (!zzelb.class.isAssignableFrom(cls) && (cls2 = zziui) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzj(int i2, List<Integer> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzm(i2, list, z);
    }

    public static void zzk(int i2, List<Integer> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzb(i2, list, z);
    }

    public static void zzl(int i2, List<Integer> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzk(i2, list, z);
    }

    public static void zzm(int i2, List<Integer> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzh(i2, list, z);
    }

    public static void zzn(int i2, List<Boolean> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzi(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzac(list) + (list.size() * zzekl.zzgv(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zzekl.zzgv(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zzekl.zzgv(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaf(list) + (size * zzekl.zzgv(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzag(list) + (size * zzekl.zzgv(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzah(list) + (size * zzekl.zzgv(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzai(list) + (size * zzekl.zzgv(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzekl.zzaj(i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzekl.zzo(i2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzekl.zzi(i2, true);
    }

    public static void zza(int i2, List<String> list, zzeoy zzeoyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zza(i2, list);
    }

    public static void zzb(int i2, List<zzejr> list, zzeoy zzeoyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzb(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i2, List<?> list) {
        int zzia;
        int zzia2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int zzgv = zzekl.zzgv(i2) * size;
        if (list instanceof zzelv) {
            zzelv zzelvVar = (zzelv) list;
            while (i3 < size) {
                Object zzhj = zzelvVar.zzhj(i3);
                if (zzhj instanceof zzejr) {
                    zzia2 = zzekl.zzaj((zzejr) zzhj);
                } else {
                    zzia2 = zzekl.zzia((String) zzhj);
                }
                zzgv += zzia2;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzejr) {
                    zzia = zzekl.zzaj((zzejr) obj);
                } else {
                    zzia = zzekl.zzia((String) obj);
                }
                zzgv += zzia;
                i3++;
            }
        }
        return zzgv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i2, List<zzejr> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgv = size * zzekl.zzgv(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzgv += zzekl.zzaj(list.get(i3));
        }
        return zzgv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzi(int i2, List<Integer> list, zzeoy zzeoyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzj(i2, list, z);
    }

    public static void zza(int i2, List<?> list, zzeoy zzeoyVar, zzenj zzenjVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zza(i2, list, zzenjVar);
    }

    public static void zzb(int i2, List<?> list, zzeoy zzeoyVar, zzenj zzenjVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeoyVar.zzb(i2, list, zzenjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzemh zzemhVar, T t, T t2, long j2) {
        zzeoh.zza(t, j2, zzemhVar.zzf(zzeoh.zzp(t, j2), zzeoh.zzp(t2, j2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i2, List<zzemo> list, zzenj zzenjVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzekl.zzc(i2, list.get(i4), zzenjVar);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzekw<FT>> void zza(zzekq<FT> zzekqVar, T t, T t2) {
        zzeku<FT> zzai = zzekqVar.zzai(t2);
        if (zzai.zzinp.isEmpty()) {
            return;
        }
        zzekqVar.zzaj(t).zza(zzai);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzeob<UT, UB> zzeobVar, T t, T t2) {
        zzeobVar.zzi(t, zzeobVar.zzk(zzeobVar.zzay(t), zzeobVar.zzay(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i2, Object obj, zzenj zzenjVar) {
        if (obj instanceof zzelt) {
            return zzekl.zza(i2, (zzelt) obj);
        }
        return zzekl.zzb(i2, (zzemo) obj, zzenjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i2, List<Integer> list, zzeli zzeliVar, UB ub, zzeob<UT, UB> zzeobVar) {
        if (zzeliVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (zzeliVar.zzi(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) zza(i2, intValue, ub, zzeobVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzeliVar.zzi(intValue2)) {
                    ub = (UB) zza(i2, intValue2, ub, zzeobVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i2, List<?> list, zzenj zzenjVar) {
        int zza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgv = zzekl.zzgv(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzelt) {
                zza = zzekl.zza((zzelt) obj);
            } else {
                zza = zzekl.zza((zzemo) obj, zzenjVar);
            }
            zzgv += zza;
        }
        return zzgv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i2, int i3, UB ub, zzeob<UT, UB> zzeobVar) {
        if (ub == null) {
            ub = zzeobVar.zzbky();
        }
        zzeobVar.zza((zzeob<UT, UB>) ub, i2, i3);
        return ub;
    }
}
