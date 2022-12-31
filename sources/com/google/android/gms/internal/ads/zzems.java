package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzems<T> implements zzenj<T> {
    private final int[] zzisr;
    private final Object[] zziss;
    private final int zzist;
    private final int zzisu;
    private final zzemo zzisv;
    private final boolean zzisw;
    private final boolean zzisx;
    private final boolean zzisy;
    private final boolean zzisz;
    private final int[] zzita;
    private final int zzitb;
    private final int zzitc;
    private final zzemw zzitd;
    private final zzely zzite;
    private final zzeob<?, ?> zzitf;
    private final zzekq<?> zzitg;
    private final zzemh zzith;
    private static final int[] zzisq = new int[0];
    private static final Unsafe zzhzj = zzeoh.zzble();

    private zzems(int[] iArr, Object[] objArr, int i2, int i3, zzemo zzemoVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, zzemw zzemwVar, zzely zzelyVar, zzeob<?, ?> zzeobVar, zzekq<?> zzekqVar, zzemh zzemhVar) {
        this.zzisr = iArr;
        this.zziss = objArr;
        this.zzist = i2;
        this.zzisu = i3;
        this.zzisx = zzemoVar instanceof zzelb;
        this.zzisy = z;
        this.zzisw = zzekqVar != null && zzekqVar.zzj(zzemoVar);
        this.zzisz = false;
        this.zzita = iArr2;
        this.zzitb = i4;
        this.zzitc = i5;
        this.zzitd = zzemwVar;
        this.zzite = zzelyVar;
        this.zzitf = zzeobVar;
        this.zzitg = zzekqVar;
        this.zzisv = zzemoVar;
        this.zzith = zzemhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.android.gms.internal.ads.zzems<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.ads.zzemm r34, com.google.android.gms.internal.ads.zzemw r35, com.google.android.gms.internal.ads.zzely r36, com.google.android.gms.internal.ads.zzeob<?, ?> r37, com.google.android.gms.internal.ads.zzekq<?> r38, com.google.android.gms.internal.ads.zzemh r39) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zza(java.lang.Class, com.google.android.gms.internal.ads.zzemm, com.google.android.gms.internal.ads.zzemw, com.google.android.gms.internal.ads.zzely, com.google.android.gms.internal.ads.zzeob, com.google.android.gms.internal.ads.zzekq, com.google.android.gms.internal.ads.zzemh):com.google.android.gms.internal.ads.zzems");
    }

    private final int zzao(int i2, int i3) {
        if (i2 < this.zzist || i2 > this.zzisu) {
            return -1;
        }
        return zzap(i2, i3);
    }

    private final int zzap(int i2, int i3) {
        int length = (this.zzisr.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzisr[i5];
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

    private static zzeoe zzav(Object obj) {
        zzelb zzelbVar = (zzelb) obj;
        zzeoe zzeoeVar = zzelbVar.zziqk;
        if (zzeoeVar == zzeoe.zzbkz()) {
            zzeoe zzbla = zzeoe.zzbla();
            zzelbVar.zziqk = zzbla;
            return zzbla;
        }
        return zzeoeVar;
    }

    private final void zzb(T t, T t2, int i2) {
        int zzhn = zzhn(i2);
        int i3 = this.zzisr[i2];
        long j2 = zzhn & 1048575;
        if (zza((zzems<T>) t2, i3, i2)) {
            Object zzp = zza((zzems<T>) t, i3, i2) ? zzeoh.zzp(t, j2) : null;
            Object zzp2 = zzeoh.zzp(t2, j2);
            if (zzp != null && zzp2 != null) {
                zzeoh.zza(t, j2, zzeld.zze(zzp, zzp2));
                zzb((zzems<T>) t, i3, i2);
            } else if (zzp2 != null) {
                zzeoh.zza(t, j2, zzp2);
                zzb((zzems<T>) t, i3, i2);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i2) {
        return zze((zzems<T>) t, i2) == zze((zzems<T>) t2, i2);
    }

    private static List<?> zze(Object obj, long j2) {
        return (List) zzeoh.zzp(obj, j2);
    }

    private static <T> double zzf(T t, long j2) {
        return ((Double) zzeoh.zzp(t, j2)).doubleValue();
    }

    private static <T> int zzh(T t, long j2) {
        return ((Integer) zzeoh.zzp(t, j2)).intValue();
    }

    private final zzenj zzhk(int i2) {
        int i3 = (i2 / 3) << 1;
        zzenj zzenjVar = (zzenj) this.zziss[i3];
        if (zzenjVar != null) {
            return zzenjVar;
        }
        zzenj<T> zzh = zzenc.zzbkf().zzh((Class) this.zziss[i3 + 1]);
        this.zziss[i3] = zzh;
        return zzh;
    }

    private final Object zzhl(int i2) {
        return this.zziss[(i2 / 3) << 1];
    }

    private final zzeli zzhm(int i2) {
        return (zzeli) this.zziss[((i2 / 3) << 1) + 1];
    }

    private final int zzhn(int i2) {
        return this.zzisr[i2 + 1];
    }

    private final int zzho(int i2) {
        return this.zzisr[i2 + 2];
    }

    private static boolean zzhp(int i2) {
        return (i2 & 536870912) != 0;
    }

    private final int zzhq(int i2) {
        if (i2 < this.zzist || i2 > this.zzisu) {
            return -1;
        }
        return zzap(i2, 0);
    }

    private static <T> long zzi(T t, long j2) {
        return ((Long) zzeoh.zzp(t, j2)).longValue();
    }

    private static <T> boolean zzj(T t, long j2) {
        return ((Boolean) zzeoh.zzp(t, j2)).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzeoh.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzeoh.zzo(r11, r6))) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.ads.zzenl.zzh(com.google.android.gms.internal.ads.zzeoh.zzp(r10, r6), com.google.android.gms.internal.ads.zzeoh.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (com.google.android.gms.internal.ads.zzenl.zzh(com.google.android.gms.internal.ads.zzeoh.zzp(r10, r6), com.google.android.gms.internal.ads.zzeoh.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (com.google.android.gms.internal.ads.zzenl.zzh(com.google.android.gms.internal.ads.zzeoh.zzp(r10, r6), com.google.android.gms.internal.ads.zzeoh.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (com.google.android.gms.internal.ads.zzenl.zzh(com.google.android.gms.internal.ads.zzeoh.zzp(r10, r6), com.google.android.gms.internal.ads.zzeoh.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (com.google.android.gms.internal.ads.zzenl.zzh(com.google.android.gms.internal.ads.zzeoh.zzp(r10, r6), com.google.android.gms.internal.ads.zzeoh.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzm(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzm(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0165, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018b, code lost:
        if (com.google.android.gms.internal.ads.zzeoh.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeoh.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzeoh.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzeoh.zzn(r11, r6))) goto L85;
     */
    @Override // com.google.android.gms.internal.ads.zzenj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.equals(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final int hashCode(T t) {
        int i2;
        int zzfq;
        int length = this.zzisr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzhn = zzhn(i4);
            int i5 = this.zzisr[i4];
            long j2 = 1048575 & zzhn;
            int i6 = 37;
            switch ((zzhn & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    zzfq = zzeld.zzfq(Double.doubleToLongBits(zzeoh.zzo(t, j2)));
                    i3 = i2 + zzfq;
                    break;
                case 1:
                    i2 = i3 * 53;
                    zzfq = Float.floatToIntBits(zzeoh.zzn(t, j2));
                    i3 = i2 + zzfq;
                    break;
                case 2:
                    i2 = i3 * 53;
                    zzfq = zzeld.zzfq(zzeoh.zzl(t, j2));
                    i3 = i2 + zzfq;
                    break;
                case 3:
                    i2 = i3 * 53;
                    zzfq = zzeld.zzfq(zzeoh.zzl(t, j2));
                    i3 = i2 + zzfq;
                    break;
                case 4:
                    i2 = i3 * 53;
                    zzfq = zzeoh.zzk(t, j2);
                    i3 = i2 + zzfq;
                    break;
                case 5:
                    i2 = i3 * 53;
                    zzfq = zzeld.zzfq(zzeoh.zzl(t, j2));
                    i3 = i2 + zzfq;
                    break;
                case 6:
                    i2 = i3 * 53;
                    zzfq = zzeoh.zzk(t, j2);
                    i3 = i2 + zzfq;
                    break;
                case 7:
                    i2 = i3 * 53;
                    zzfq = zzeld.zzbt(zzeoh.zzm(t, j2));
                    i3 = i2 + zzfq;
                    break;
                case 8:
                    i2 = i3 * 53;
                    zzfq = ((String) zzeoh.zzp(t, j2)).hashCode();
                    i3 = i2 + zzfq;
                    break;
                case 9:
                    Object zzp = zzeoh.zzp(t, j2);
                    if (zzp != null) {
                        i6 = zzp.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    zzfq = zzeoh.zzp(t, j2).hashCode();
                    i3 = i2 + zzfq;
                    break;
                case 11:
                    i2 = i3 * 53;
                    zzfq = zzeoh.zzk(t, j2);
                    i3 = i2 + zzfq;
                    break;
                case 12:
                    i2 = i3 * 53;
                    zzfq = zzeoh.zzk(t, j2);
                    i3 = i2 + zzfq;
                    break;
                case 13:
                    i2 = i3 * 53;
                    zzfq = zzeoh.zzk(t, j2);
                    i3 = i2 + zzfq;
                    break;
                case 14:
                    i2 = i3 * 53;
                    zzfq = zzeld.zzfq(zzeoh.zzl(t, j2));
                    i3 = i2 + zzfq;
                    break;
                case 15:
                    i2 = i3 * 53;
                    zzfq = zzeoh.zzk(t, j2);
                    i3 = i2 + zzfq;
                    break;
                case 16:
                    i2 = i3 * 53;
                    zzfq = zzeld.zzfq(zzeoh.zzl(t, j2));
                    i3 = i2 + zzfq;
                    break;
                case 17:
                    Object zzp2 = zzeoh.zzp(t, j2);
                    if (zzp2 != null) {
                        i6 = zzp2.hashCode();
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
                    zzfq = zzeoh.zzp(t, j2).hashCode();
                    i3 = i2 + zzfq;
                    break;
                case 50:
                    i2 = i3 * 53;
                    zzfq = zzeoh.zzp(t, j2).hashCode();
                    i3 = i2 + zzfq;
                    break;
                case 51:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeld.zzfq(Double.doubleToLongBits(zzf(t, j2)));
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = Float.floatToIntBits(zzg(t, j2));
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeld.zzfq(zzi(t, j2));
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeld.zzfq(zzi(t, j2));
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzh(t, j2);
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeld.zzfq(zzi(t, j2));
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzh(t, j2);
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeld.zzbt(zzj(t, j2));
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = ((String) zzeoh.zzp(t, j2)).hashCode();
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeoh.zzp(t, j2).hashCode();
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeoh.zzp(t, j2).hashCode();
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzh(t, j2);
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzh(t, j2);
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzh(t, j2);
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeld.zzfq(zzi(t, j2));
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzh(t, j2);
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeld.zzfq(zzi(t, j2));
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza((zzems<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        zzfq = zzeoh.zzp(t, j2).hashCode();
                        i3 = i2 + zzfq;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzitf.zzay(t).hashCode();
        return this.zzisw ? (hashCode * 53) + this.zzitg.zzai(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final T newInstance() {
        return (T) this.zzitd.newInstance(this.zzisv);
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final void zzak(T t) {
        int i2;
        int i3 = this.zzitb;
        while (true) {
            i2 = this.zzitc;
            if (i3 >= i2) {
                break;
            }
            long zzhn = zzhn(this.zzita[i3]) & 1048575;
            Object zzp = zzeoh.zzp(t, zzhn);
            if (zzp != null) {
                zzeoh.zza(t, zzhn, this.zzith.zzaq(zzp));
            }
            i3++;
        }
        int length = this.zzita.length;
        while (i2 < length) {
            this.zzite.zzb(t, this.zzita[i2]);
            i2++;
        }
        this.zzitf.zzak(t);
        if (this.zzisw) {
            this.zzitg.zzak(t);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzenj
    public final int zzau(T t) {
        int i2;
        long j2;
        int zzl;
        int zzj;
        int zzak;
        int zzv;
        int zzak2;
        int zzgv;
        int zzgx;
        int zzc;
        int zzak3;
        int zzgv2;
        int zzgx2;
        int i3 = 267386880;
        int i4 = 1048575;
        int i5 = 1;
        if (this.zzisy) {
            Unsafe unsafe = zzhzj;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.zzisr.length) {
                int zzhn = zzhn(i6);
                int i8 = (zzhn & i3) >>> 20;
                int i9 = this.zzisr[i6];
                long j3 = zzhn & 1048575;
                if (i8 >= zzekv.zzipc.id() && i8 <= zzekv.zzipp.id()) {
                    int i10 = this.zzisr[i6 + 2];
                }
                switch (i8) {
                    case 0:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzc(i9, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 1:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzb(i9, 0.0f);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 2:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzl(i9, zzeoh.zzl(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 3:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzm(i9, zzeoh.zzl(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 4:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzag(i9, zzeoh.zzk(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 5:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzo(i9, 0L);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 6:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzaj(i9, 0);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 7:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzi(i9, true);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 8:
                        if (zze((zzems<T>) t, i6)) {
                            Object zzp = zzeoh.zzp(t, j3);
                            if (zzp instanceof zzejr) {
                                zzc = zzekl.zzc(i9, (zzejr) zzp);
                                break;
                            } else {
                                zzc = zzekl.zzj(i9, (String) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 9:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzenl.zzc(i9, zzeoh.zzp(t, j3), zzhk(i6));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 10:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzc(i9, (zzejr) zzeoh.zzp(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 11:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzah(i9, zzeoh.zzk(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 12:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzal(i9, zzeoh.zzk(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 13:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzak(i9, 0);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 14:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzp(i9, 0L);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 15:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzai(i9, zzeoh.zzk(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 16:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzn(i9, zzeoh.zzl(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 17:
                        if (zze((zzems<T>) t, i6)) {
                            zzc = zzekl.zzc(i9, (zzemo) zzeoh.zzp(t, j3), zzhk(i6));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 18:
                        zzc = zzenl.zzw(i9, zze(t, j3), false);
                        break;
                    case 19:
                        zzc = zzenl.zzv(i9, zze(t, j3), false);
                        break;
                    case 20:
                        zzc = zzenl.zzo(i9, zze(t, j3), false);
                        break;
                    case 21:
                        zzc = zzenl.zzp(i9, zze(t, j3), false);
                        break;
                    case 22:
                        zzc = zzenl.zzs(i9, zze(t, j3), false);
                        break;
                    case 23:
                        zzc = zzenl.zzw(i9, zze(t, j3), false);
                        break;
                    case 24:
                        zzc = zzenl.zzv(i9, zze(t, j3), false);
                        break;
                    case 25:
                        zzc = zzenl.zzx(i9, zze(t, j3), false);
                        break;
                    case 26:
                        zzc = zzenl.zzc(i9, zze(t, j3));
                        break;
                    case 27:
                        zzc = zzenl.zzc(i9, zze(t, j3), zzhk(i6));
                        break;
                    case 28:
                        zzc = zzenl.zzd(i9, zze(t, j3));
                        break;
                    case 29:
                        zzc = zzenl.zzt(i9, zze(t, j3), false);
                        break;
                    case 30:
                        zzc = zzenl.zzr(i9, zze(t, j3), false);
                        break;
                    case 31:
                        zzc = zzenl.zzv(i9, zze(t, j3), false);
                        break;
                    case 32:
                        zzc = zzenl.zzw(i9, zze(t, j3), false);
                        break;
                    case 33:
                        zzc = zzenl.zzu(i9, zze(t, j3), false);
                        break;
                    case 34:
                        zzc = zzenl.zzq(i9, zze(t, j3), false);
                        break;
                    case 35:
                        zzak3 = zzenl.zzak((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 36:
                        zzak3 = zzenl.zzaj((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 37:
                        zzak3 = zzenl.zzac((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 38:
                        zzak3 = zzenl.zzad((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 39:
                        zzak3 = zzenl.zzag((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 40:
                        zzak3 = zzenl.zzak((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 41:
                        zzak3 = zzenl.zzaj((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 42:
                        zzak3 = zzenl.zzal((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 43:
                        zzak3 = zzenl.zzah((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 44:
                        zzak3 = zzenl.zzaf((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 45:
                        zzak3 = zzenl.zzaj((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 46:
                        zzak3 = zzenl.zzak((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 47:
                        zzak3 = zzenl.zzai((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 48:
                        zzak3 = zzenl.zzae((List) unsafe.getObject(t, j3));
                        if (zzak3 > 0) {
                            zzgv2 = zzekl.zzgv(i9);
                            zzgx2 = zzekl.zzgx(zzak3);
                            zzc = zzgv2 + zzgx2 + zzak3;
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 49:
                        zzc = zzenl.zzd(i9, zze(t, j3), zzhk(i6));
                        break;
                    case 50:
                        zzc = this.zzith.zzb(i9, zzeoh.zzp(t, j3), zzhl(i6));
                        break;
                    case 51:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzc(i9, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 52:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzb(i9, 0.0f);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 53:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzl(i9, zzi(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 54:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzm(i9, zzi(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 55:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzag(i9, zzh(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 56:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzo(i9, 0L);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 57:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzaj(i9, 0);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 58:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzi(i9, true);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 59:
                        if (zza((zzems<T>) t, i9, i6)) {
                            Object zzp2 = zzeoh.zzp(t, j3);
                            if (zzp2 instanceof zzejr) {
                                zzc = zzekl.zzc(i9, (zzejr) zzp2);
                                break;
                            } else {
                                zzc = zzekl.zzj(i9, (String) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 60:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzenl.zzc(i9, zzeoh.zzp(t, j3), zzhk(i6));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 61:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzc(i9, (zzejr) zzeoh.zzp(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 62:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzah(i9, zzh(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 63:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzal(i9, zzh(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 64:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzak(i9, 0);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 65:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzp(i9, 0L);
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 66:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzai(i9, zzh(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 67:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzn(i9, zzi(t, j3));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    case 68:
                        if (zza((zzems<T>) t, i9, i6)) {
                            zzc = zzekl.zzc(i9, (zzemo) zzeoh.zzp(t, j3), zzhk(i6));
                            break;
                        } else {
                            continue;
                            i6 += 3;
                            i3 = 267386880;
                        }
                    default:
                        i6 += 3;
                        i3 = 267386880;
                }
                i7 += zzc;
                i6 += 3;
                i3 = 267386880;
            }
            return i7 + zza(this.zzitf, t);
        }
        Unsafe unsafe2 = zzhzj;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1048575;
        int i14 = 0;
        while (i11 < this.zzisr.length) {
            int zzhn2 = zzhn(i11);
            int[] iArr = this.zzisr;
            int i15 = iArr[i11];
            int i16 = (zzhn2 & 267386880) >>> 20;
            if (i16 <= 17) {
                int i17 = iArr[i11 + 2];
                int i18 = i17 & i4;
                i2 = i5 << (i17 >>> 20);
                if (i18 != i13) {
                    i14 = unsafe2.getInt(t, i18);
                    i13 = i18;
                }
            } else {
                i2 = 0;
            }
            long j4 = zzhn2 & i4;
            switch (i16) {
                case 0:
                    j2 = 0;
                    if ((i14 & i2) != 0) {
                        i12 += zzekl.zzc(i15, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        continue;
                        i11 += 3;
                        i4 = 1048575;
                        i5 = 1;
                    }
                    break;
                case 1:
                    j2 = 0;
                    if ((i14 & i2) != 0) {
                        i12 += zzekl.zzb(i15, 0.0f);
                        break;
                    }
                    break;
                case 2:
                    j2 = 0;
                    if ((i2 & i14) != 0) {
                        zzl = zzekl.zzl(i15, unsafe2.getLong(t, j4));
                        i12 += zzl;
                        break;
                    }
                    break;
                case 3:
                    j2 = 0;
                    if ((i2 & i14) != 0) {
                        zzl = zzekl.zzm(i15, unsafe2.getLong(t, j4));
                        i12 += zzl;
                        break;
                    }
                    break;
                case 4:
                    j2 = 0;
                    if ((i2 & i14) != 0) {
                        zzl = zzekl.zzag(i15, unsafe2.getInt(t, j4));
                        i12 += zzl;
                        break;
                    }
                    break;
                case 5:
                    j2 = 0;
                    if ((i14 & i2) != 0) {
                        zzl = zzekl.zzo(i15, 0L);
                        i12 += zzl;
                        break;
                    }
                    break;
                case 6:
                    if ((i14 & i2) != 0) {
                        i12 += zzekl.zzaj(i15, 0);
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 7:
                    if ((i14 & i2) != 0) {
                        i12 += zzekl.zzi(i15, true);
                        j2 = 0;
                        i11 += 3;
                        i4 = 1048575;
                        i5 = 1;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 8:
                    if ((i14 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof zzejr) {
                            zzj = zzekl.zzc(i15, (zzejr) object);
                        } else {
                            zzj = zzekl.zzj(i15, (String) object);
                        }
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 9:
                    if ((i14 & i2) != 0) {
                        zzj = zzenl.zzc(i15, unsafe2.getObject(t, j4), zzhk(i11));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 10:
                    if ((i14 & i2) != 0) {
                        zzj = zzekl.zzc(i15, (zzejr) unsafe2.getObject(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 11:
                    if ((i14 & i2) != 0) {
                        zzj = zzekl.zzah(i15, unsafe2.getInt(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 12:
                    if ((i14 & i2) != 0) {
                        zzj = zzekl.zzal(i15, unsafe2.getInt(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 13:
                    if ((i14 & i2) != 0) {
                        zzak = zzekl.zzak(i15, 0);
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 14:
                    if ((i14 & i2) != 0) {
                        zzj = zzekl.zzp(i15, 0L);
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 15:
                    if ((i14 & i2) != 0) {
                        zzj = zzekl.zzai(i15, unsafe2.getInt(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 16:
                    if ((i14 & i2) != 0) {
                        zzj = zzekl.zzn(i15, unsafe2.getLong(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 17:
                    if ((i14 & i2) != 0) {
                        zzj = zzekl.zzc(i15, (zzemo) unsafe2.getObject(t, j4), zzhk(i11));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 18:
                    zzj = zzenl.zzw(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzj;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 19:
                    zzv = zzenl.zzv(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 20:
                    zzv = zzenl.zzo(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 21:
                    zzv = zzenl.zzp(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 22:
                    zzv = zzenl.zzs(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 23:
                    zzv = zzenl.zzw(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 24:
                    zzv = zzenl.zzv(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 25:
                    zzv = zzenl.zzx(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 26:
                    zzj = zzenl.zzc(i15, (List) unsafe2.getObject(t, j4));
                    i12 += zzj;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 27:
                    zzj = zzenl.zzc(i15, (List<?>) unsafe2.getObject(t, j4), zzhk(i11));
                    i12 += zzj;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 28:
                    zzj = zzenl.zzd(i15, (List) unsafe2.getObject(t, j4));
                    i12 += zzj;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 29:
                    zzj = zzenl.zzt(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzj;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 30:
                    zzv = zzenl.zzr(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 31:
                    zzv = zzenl.zzv(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 32:
                    zzv = zzenl.zzw(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 33:
                    zzv = zzenl.zzu(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 34:
                    zzv = zzenl.zzq(i15, (List) unsafe2.getObject(t, j4), false);
                    i12 += zzv;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 35:
                    zzak2 = zzenl.zzak((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 36:
                    zzak2 = zzenl.zzaj((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 37:
                    zzak2 = zzenl.zzac((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 38:
                    zzak2 = zzenl.zzad((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 39:
                    zzak2 = zzenl.zzag((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 40:
                    zzak2 = zzenl.zzak((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 41:
                    zzak2 = zzenl.zzaj((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 42:
                    zzak2 = zzenl.zzal((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 43:
                    zzak2 = zzenl.zzah((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 44:
                    zzak2 = zzenl.zzaf((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 45:
                    zzak2 = zzenl.zzaj((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 46:
                    zzak2 = zzenl.zzak((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 47:
                    zzak2 = zzenl.zzai((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 48:
                    zzak2 = zzenl.zzae((List) unsafe2.getObject(t, j4));
                    if (zzak2 > 0) {
                        zzgv = zzekl.zzgv(i15);
                        zzgx = zzekl.zzgx(zzak2);
                        zzak = zzgv + zzgx + zzak2;
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 49:
                    zzj = zzenl.zzd(i15, (List) unsafe2.getObject(t, j4), zzhk(i11));
                    i12 += zzj;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 50:
                    zzj = this.zzith.zzb(i15, unsafe2.getObject(t, j4), zzhl(i11));
                    i12 += zzj;
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 51:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzc(i15, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 52:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzak = zzekl.zzb(i15, 0.0f);
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 53:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzl(i15, zzi(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 54:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzm(i15, zzi(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 55:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzag(i15, zzh(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 56:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzo(i15, 0L);
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 57:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzak = zzekl.zzaj(i15, 0);
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 58:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzak = zzekl.zzi(i15, true);
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 59:
                    if (zza((zzems<T>) t, i15, i11)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof zzejr) {
                            zzj = zzekl.zzc(i15, (zzejr) object2);
                        } else {
                            zzj = zzekl.zzj(i15, (String) object2);
                        }
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 60:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzenl.zzc(i15, unsafe2.getObject(t, j4), zzhk(i11));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 61:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzc(i15, (zzejr) unsafe2.getObject(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 62:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzah(i15, zzh(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 63:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzal(i15, zzh(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 64:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzak = zzekl.zzak(i15, 0);
                        i12 += zzak;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 65:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzp(i15, 0L);
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 66:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzai(i15, zzh(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 67:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzn(i15, zzi(t, j4));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                case 68:
                    if (zza((zzems<T>) t, i15, i11)) {
                        zzj = zzekl.zzc(i15, (zzemo) unsafe2.getObject(t, j4), zzhk(i11));
                        i12 += zzj;
                    }
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
                default:
                    j2 = 0;
                    i11 += 3;
                    i4 = 1048575;
                    i5 = 1;
            }
            i11 += 3;
            i4 = 1048575;
            i5 = 1;
        }
        int i19 = 0;
        int zza = i12 + zza(this.zzitf, t);
        if (this.zzisw) {
            zzeku<?> zzai = this.zzitg.zzai(t);
            for (int i20 = 0; i20 < zzai.zzinp.zzbkq(); i20++) {
                Map.Entry<?, Object> zzhu = zzai.zzinp.zzhu(i20);
                i19 += zzeku.zzb((zzekw) zzhu.getKey(), zzhu.getValue());
            }
            for (Map.Entry<?, Object> entry : zzai.zzinp.zzbkr()) {
                i19 += zzeku.zzb((zzekw) entry.getKey(), entry.getValue());
            }
            return zza + i19;
        }
        return zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.ads.zzenj] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.zzenj] */
    @Override // com.google.android.gms.internal.ads.zzenj
    public final boolean zzaw(T t) {
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i6 >= this.zzitb) {
                return !this.zzisw || this.zzitg.zzai(t).isInitialized();
            }
            int i7 = this.zzita[i6];
            int i8 = this.zzisr[i7];
            int zzhn = zzhn(i7);
            int i9 = this.zzisr[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzhzj.getInt(t, i10);
                }
                i3 = i5;
                i2 = i10;
            } else {
                i2 = i4;
                i3 = i5;
            }
            if (((268435456 & zzhn) != 0) && !zza((zzems<T>) t, i7, i2, i3, i11)) {
                return false;
            }
            int i12 = (267386880 & zzhn) >>> 20;
            if (i12 != 9 && i12 != 17) {
                if (i12 != 27) {
                    if (i12 == 60 || i12 == 68) {
                        if (zza((zzems<T>) t, i8, i7) && !zza(t, zzhn, zzhk(i7))) {
                            return false;
                        }
                    } else if (i12 != 49) {
                        if (i12 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzao = this.zzith.zzao(zzeoh.zzp(t, zzhn & 1048575));
                            if (!zzao.isEmpty()) {
                                if (this.zzith.zzas(zzhl(i7)).zzism.zzbli() == zzeov.MESSAGE) {
                                    zzenj<T> zzenjVar = 0;
                                    Iterator<?> it = zzao.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzenjVar == null) {
                                            zzenjVar = zzenc.zzbkf().zzh(next.getClass());
                                        }
                                        boolean zzaw = zzenjVar.zzaw(next);
                                        zzenjVar = zzenjVar;
                                        if (!zzaw) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzeoh.zzp(t, zzhn & 1048575);
                if (!list.isEmpty()) {
                    ?? zzhk = zzhk(i7);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= list.size()) {
                            break;
                        } else if (!zzhk.zzaw(list.get(i13))) {
                            z = false;
                            break;
                        } else {
                            i13++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza((zzems<T>) t, i7, i2, i3, i11) && !zza(t, zzhn, zzhk(i7))) {
                return false;
            }
            i6++;
            i4 = i2;
            i5 = i3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final void zzg(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.zzisr.length; i2 += 3) {
            int zzhn = zzhn(i2);
            long j2 = 1048575 & zzhn;
            int i3 = this.zzisr[i2];
            switch ((zzhn & 267386880) >>> 20) {
                case 0:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza(t, j2, zzeoh.zzo(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza((Object) t, j2, zzeoh.zzn(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza((Object) t, j2, zzeoh.zzl(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza((Object) t, j2, zzeoh.zzl(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zzb(t, j2, zzeoh.zzk(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza((Object) t, j2, zzeoh.zzl(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zzb(t, j2, zzeoh.zzk(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza(t, j2, zzeoh.zzm(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza(t, j2, zzeoh.zzp(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i2);
                    break;
                case 10:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza(t, j2, zzeoh.zzp(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zzb(t, j2, zzeoh.zzk(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zzb(t, j2, zzeoh.zzk(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zzb(t, j2, zzeoh.zzk(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza((Object) t, j2, zzeoh.zzl(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zzb(t, j2, zzeoh.zzk(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zze((zzems<T>) t2, i2)) {
                        zzeoh.zza((Object) t, j2, zzeoh.zzl(t2, j2));
                        zzf((zzems<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i2);
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
                    this.zzite.zza(t, t2, j2);
                    break;
                case 50:
                    zzenl.zza(this.zzith, t, t2, j2);
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
                    if (zza((zzems<T>) t2, i3, i2)) {
                        zzeoh.zza(t, j2, zzeoh.zzp(t2, j2));
                        zzb((zzems<T>) t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza((zzems<T>) t2, i3, i2)) {
                        zzeoh.zza(t, j2, zzeoh.zzp(t2, j2));
                        zzb((zzems<T>) t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i2);
                    break;
            }
        }
        zzenl.zza(this.zzitf, t, t2);
        if (this.zzisw) {
            zzenl.zza(this.zzitg, t, t2);
        }
    }

    private final boolean zze(T t, int i2) {
        int zzho = zzho(i2);
        long j2 = zzho & 1048575;
        if (j2 != 1048575) {
            return (zzeoh.zzk(t, j2) & (1 << (zzho >>> 20))) != 0;
        }
        int zzhn = zzhn(i2);
        long j3 = zzhn & 1048575;
        switch ((zzhn & 267386880) >>> 20) {
            case 0:
                return zzeoh.zzo(t, j3) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            case 1:
                return zzeoh.zzn(t, j3) != 0.0f;
            case 2:
                return zzeoh.zzl(t, j3) != 0;
            case 3:
                return zzeoh.zzl(t, j3) != 0;
            case 4:
                return zzeoh.zzk(t, j3) != 0;
            case 5:
                return zzeoh.zzl(t, j3) != 0;
            case 6:
                return zzeoh.zzk(t, j3) != 0;
            case 7:
                return zzeoh.zzm(t, j3);
            case 8:
                Object zzp = zzeoh.zzp(t, j3);
                if (zzp instanceof String) {
                    return !((String) zzp).isEmpty();
                } else if (zzp instanceof zzejr) {
                    return !zzejr.zzilz.equals(zzp);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzeoh.zzp(t, j3) != null;
            case 10:
                return !zzejr.zzilz.equals(zzeoh.zzp(t, j3));
            case 11:
                return zzeoh.zzk(t, j3) != 0;
            case 12:
                return zzeoh.zzk(t, j3) != 0;
            case 13:
                return zzeoh.zzk(t, j3) != 0;
            case 14:
                return zzeoh.zzl(t, j3) != 0;
            case 15:
                return zzeoh.zzk(t, j3) != 0;
            case 16:
                return zzeoh.zzl(t, j3) != 0;
            case 17:
                return zzeoh.zzp(t, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzf(T t, int i2) {
        int zzho = zzho(i2);
        long j2 = 1048575 & zzho;
        if (j2 == 1048575) {
            return;
        }
        zzeoh.zzb(t, j2, (1 << (zzho >>> 20)) | zzeoh.zzk(t, j2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0491  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzb(T r18, com.google.android.gms.internal.ads.zzeoy r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zzb(java.lang.Object, com.google.android.gms.internal.ads.zzeoy):void");
    }

    private static <T> float zzg(T t, long j2) {
        return ((Float) zzeoh.zzp(t, j2)).floatValue();
    }

    private static Field zza(Class<?> cls, String str) {
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

    private final void zza(T t, T t2, int i2) {
        long zzhn = zzhn(i2) & 1048575;
        if (zze((zzems<T>) t2, i2)) {
            Object zzp = zzeoh.zzp(t, zzhn);
            Object zzp2 = zzeoh.zzp(t2, zzhn);
            if (zzp != null && zzp2 != null) {
                zzeoh.zza(t, zzhn, zzeld.zze(zzp, zzp2));
                zzf((zzems<T>) t, i2);
            } else if (zzp2 != null) {
                zzeoh.zza(t, zzhn, zzp2);
                zzf((zzems<T>) t, i2);
            }
        }
    }

    private static <UT, UB> int zza(zzeob<UT, UB> zzeobVar, T t) {
        return zzeobVar.zzau(zzeobVar.zzay(t));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0a2a  */
    @Override // com.google.android.gms.internal.ads.zzenj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r14, com.google.android.gms.internal.ads.zzeoy r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zza(java.lang.Object, com.google.android.gms.internal.ads.zzeoy):void");
    }

    private final void zzb(T t, int i2, int i3) {
        zzeoh.zzb(t, zzho(i3) & 1048575, i2);
    }

    private final <K, V> void zza(zzeoy zzeoyVar, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            zzeoyVar.zza(i2, this.zzith.zzas(zzhl(i3)), this.zzith.zzao(obj));
        }
    }

    private static <UT, UB> void zza(zzeob<UT, UB> zzeobVar, T t, zzeoy zzeoyVar) throws IOException {
        zzeobVar.zza((zzeob<UT, UB>) zzeobVar.zzay(t), zzeoyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final void zza(T t, zzend zzendVar, zzeko zzekoVar) throws IOException {
        Objects.requireNonNull(zzekoVar);
        zzeob zzeobVar = this.zzitf;
        zzekq<?> zzekqVar = this.zzitg;
        zzeku<?> zzekuVar = null;
        Object obj = null;
        while (true) {
            try {
                int zzbhq = zzendVar.zzbhq();
                int zzhq = zzhq(zzbhq);
                if (zzhq >= 0) {
                    int zzhn = zzhn(zzhq);
                    switch ((267386880 & zzhn) >>> 20) {
                        case 0:
                            zzeoh.zza(t, zzhn & 1048575, zzendVar.readDouble());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 1:
                            zzeoh.zza((Object) t, zzhn & 1048575, zzendVar.readFloat());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 2:
                            zzeoh.zza((Object) t, zzhn & 1048575, zzendVar.zzbgu());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 3:
                            zzeoh.zza((Object) t, zzhn & 1048575, zzendVar.zzbgt());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 4:
                            zzeoh.zzb(t, zzhn & 1048575, zzendVar.zzbgv());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 5:
                            zzeoh.zza((Object) t, zzhn & 1048575, zzendVar.zzbgw());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 6:
                            zzeoh.zzb(t, zzhn & 1048575, zzendVar.zzbgx());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 7:
                            zzeoh.zza(t, zzhn & 1048575, zzendVar.zzbgy());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 8:
                            zza(t, zzhn, zzendVar);
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 9:
                            if (zze((zzems<T>) t, zzhq)) {
                                long j2 = zzhn & 1048575;
                                zzeoh.zza(t, j2, zzeld.zze(zzeoh.zzp(t, j2), zzendVar.zza(zzhk(zzhq), zzekoVar)));
                                break;
                            } else {
                                zzeoh.zza(t, zzhn & 1048575, zzendVar.zza(zzhk(zzhq), zzekoVar));
                                zzf((zzems<T>) t, zzhq);
                                continue;
                            }
                        case 10:
                            zzeoh.zza(t, zzhn & 1048575, zzendVar.zzbha());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 11:
                            zzeoh.zzb(t, zzhn & 1048575, zzendVar.zzbhb());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 12:
                            int zzbhc = zzendVar.zzbhc();
                            zzeli zzhm = zzhm(zzhq);
                            if (zzhm != null && !zzhm.zzi(zzbhc)) {
                                obj = zzenl.zza(zzbhq, zzbhc, obj, zzeobVar);
                                break;
                            }
                            zzeoh.zzb(t, zzhn & 1048575, zzbhc);
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 13:
                            zzeoh.zzb(t, zzhn & 1048575, zzendVar.zzbhd());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 14:
                            zzeoh.zza((Object) t, zzhn & 1048575, zzendVar.zzbhe());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 15:
                            zzeoh.zzb(t, zzhn & 1048575, zzendVar.zzbhf());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 16:
                            zzeoh.zza((Object) t, zzhn & 1048575, zzendVar.zzbhg());
                            zzf((zzems<T>) t, zzhq);
                            continue;
                        case 17:
                            if (zze((zzems<T>) t, zzhq)) {
                                long j3 = zzhn & 1048575;
                                zzeoh.zza(t, j3, zzeld.zze(zzeoh.zzp(t, j3), zzendVar.zzb(zzhk(zzhq), zzekoVar)));
                                break;
                            } else {
                                zzeoh.zza(t, zzhn & 1048575, zzendVar.zzb(zzhk(zzhq), zzekoVar));
                                zzf((zzems<T>) t, zzhq);
                                continue;
                            }
                        case 18:
                            zzendVar.zzm(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 19:
                            zzendVar.zzn(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 20:
                            zzendVar.zzp(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 21:
                            zzendVar.zzo(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 22:
                            zzendVar.zzq(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 23:
                            zzendVar.zzr(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 24:
                            zzendVar.zzs(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 25:
                            zzendVar.zzt(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 26:
                            if (zzhp(zzhn)) {
                                zzendVar.zzu(this.zzite.zza(t, zzhn & 1048575));
                                break;
                            } else {
                                zzendVar.readStringList(this.zzite.zza(t, zzhn & 1048575));
                                continue;
                            }
                        case 27:
                            zzendVar.zza(this.zzite.zza(t, zzhn & 1048575), zzhk(zzhq), zzekoVar);
                            continue;
                        case 28:
                            zzendVar.zzv(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 29:
                            zzendVar.zzw(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 30:
                            List<Integer> zza = this.zzite.zza(t, zzhn & 1048575);
                            zzendVar.zzx(zza);
                            obj = zzenl.zza(zzbhq, zza, zzhm(zzhq), obj, zzeobVar);
                            continue;
                        case 31:
                            zzendVar.zzy(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 32:
                            zzendVar.zzz(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 33:
                            zzendVar.zzaa(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 34:
                            zzendVar.zzab(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 35:
                            zzendVar.zzm(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 36:
                            zzendVar.zzn(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 37:
                            zzendVar.zzp(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 38:
                            zzendVar.zzo(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 39:
                            zzendVar.zzq(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 40:
                            zzendVar.zzr(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 41:
                            zzendVar.zzs(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 42:
                            zzendVar.zzt(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 43:
                            zzendVar.zzw(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 44:
                            List<Integer> zza2 = this.zzite.zza(t, zzhn & 1048575);
                            zzendVar.zzx(zza2);
                            obj = zzenl.zza(zzbhq, zza2, zzhm(zzhq), obj, zzeobVar);
                            continue;
                        case 45:
                            zzendVar.zzy(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 46:
                            zzendVar.zzz(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 47:
                            zzendVar.zzaa(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 48:
                            zzendVar.zzab(this.zzite.zza(t, zzhn & 1048575));
                            continue;
                        case 49:
                            zzendVar.zzb(this.zzite.zza(t, zzhn & 1048575), zzhk(zzhq), zzekoVar);
                            continue;
                        case 50:
                            Object zzhl = zzhl(zzhq);
                            long zzhn2 = zzhn(zzhq) & 1048575;
                            Object zzp = zzeoh.zzp(t, zzhn2);
                            if (zzp == null) {
                                zzp = this.zzith.zzar(zzhl);
                                zzeoh.zza(t, zzhn2, zzp);
                            } else if (this.zzith.zzap(zzp)) {
                                Object zzar = this.zzith.zzar(zzhl);
                                this.zzith.zzf(zzar, zzp);
                                zzeoh.zza(t, zzhn2, zzar);
                                zzp = zzar;
                            }
                            zzendVar.zza(this.zzith.zzan(zzp), this.zzith.zzas(zzhl), zzekoVar);
                            continue;
                        case 51:
                            zzeoh.zza(t, zzhn & 1048575, Double.valueOf(zzendVar.readDouble()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 52:
                            zzeoh.zza(t, zzhn & 1048575, Float.valueOf(zzendVar.readFloat()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 53:
                            zzeoh.zza(t, zzhn & 1048575, Long.valueOf(zzendVar.zzbgu()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 54:
                            zzeoh.zza(t, zzhn & 1048575, Long.valueOf(zzendVar.zzbgt()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 55:
                            zzeoh.zza(t, zzhn & 1048575, Integer.valueOf(zzendVar.zzbgv()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 56:
                            zzeoh.zza(t, zzhn & 1048575, Long.valueOf(zzendVar.zzbgw()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 57:
                            zzeoh.zza(t, zzhn & 1048575, Integer.valueOf(zzendVar.zzbgx()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 58:
                            zzeoh.zza(t, zzhn & 1048575, Boolean.valueOf(zzendVar.zzbgy()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 59:
                            zza(t, zzhn, zzendVar);
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 60:
                            if (zza((zzems<T>) t, zzbhq, zzhq)) {
                                long j4 = zzhn & 1048575;
                                zzeoh.zza(t, j4, zzeld.zze(zzeoh.zzp(t, j4), zzendVar.zza(zzhk(zzhq), zzekoVar)));
                            } else {
                                zzeoh.zza(t, zzhn & 1048575, zzendVar.zza(zzhk(zzhq), zzekoVar));
                                zzf((zzems<T>) t, zzhq);
                            }
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 61:
                            zzeoh.zza(t, zzhn & 1048575, zzendVar.zzbha());
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 62:
                            zzeoh.zza(t, zzhn & 1048575, Integer.valueOf(zzendVar.zzbhb()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 63:
                            int zzbhc2 = zzendVar.zzbhc();
                            zzeli zzhm2 = zzhm(zzhq);
                            if (zzhm2 != null && !zzhm2.zzi(zzbhc2)) {
                                obj = zzenl.zza(zzbhq, zzbhc2, obj, zzeobVar);
                                break;
                            }
                            zzeoh.zza(t, zzhn & 1048575, Integer.valueOf(zzbhc2));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 64:
                            zzeoh.zza(t, zzhn & 1048575, Integer.valueOf(zzendVar.zzbhd()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 65:
                            zzeoh.zza(t, zzhn & 1048575, Long.valueOf(zzendVar.zzbhe()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 66:
                            zzeoh.zza(t, zzhn & 1048575, Integer.valueOf(zzendVar.zzbhf()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 67:
                            zzeoh.zza(t, zzhn & 1048575, Long.valueOf(zzendVar.zzbhg()));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        case 68:
                            zzeoh.zza(t, zzhn & 1048575, zzendVar.zzb(zzhk(zzhq), zzekoVar));
                            zzb((zzems<T>) t, zzbhq, zzhq);
                            continue;
                        default:
                            if (obj == null) {
                                try {
                                    obj = zzeobVar.zzbky();
                                } catch (zzeln unused) {
                                    zzeobVar.zza(zzendVar);
                                    if (obj == null) {
                                        obj = zzeobVar.zzaz(t);
                                    }
                                    if (!zzeobVar.zza((zzeob) obj, zzendVar)) {
                                        for (int i2 = this.zzitb; i2 < this.zzitc; i2++) {
                                            obj = zza((Object) t, this.zzita[i2], (int) obj, (zzeob<UT, int>) zzeobVar);
                                        }
                                        if (obj != null) {
                                            zzeobVar.zzj(t, obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!zzeobVar.zza((zzeob) obj, zzendVar)) {
                                for (int i3 = this.zzitb; i3 < this.zzitc; i3++) {
                                    obj = zza((Object) t, this.zzita[i3], (int) obj, (zzeob<UT, int>) zzeobVar);
                                }
                                if (obj != null) {
                                    zzeobVar.zzj(t, obj);
                                    return;
                                }
                                return;
                            }
                            continue;
                    }
                } else if (zzbhq == Integer.MAX_VALUE) {
                    for (int i4 = this.zzitb; i4 < this.zzitc; i4++) {
                        obj = zza((Object) t, this.zzita[i4], (int) obj, (zzeob<UT, int>) zzeobVar);
                    }
                    if (obj != null) {
                        zzeobVar.zzj(t, obj);
                        return;
                    }
                    return;
                } else {
                    Object zza3 = !this.zzisw ? null : zzekqVar.zza(zzekoVar, this.zzisv, zzbhq);
                    if (zza3 != null) {
                        if (zzekuVar == null) {
                            zzekuVar = zzekqVar.zzaj(t);
                        }
                        zzeku<?> zzekuVar2 = zzekuVar;
                        obj = zzekqVar.zza(zzendVar, zza3, zzekoVar, zzekuVar2, obj, zzeobVar);
                        zzekuVar = zzekuVar2;
                    } else {
                        zzeobVar.zza(zzendVar);
                        if (obj == null) {
                            obj = zzeobVar.zzaz(t);
                        }
                        if (!zzeobVar.zza((zzeob) obj, zzendVar)) {
                            for (int i5 = this.zzitb; i5 < this.zzitc; i5++) {
                                obj = zza((Object) t, this.zzita[i5], (int) obj, (zzeob<UT, int>) zzeobVar);
                            }
                            if (obj != null) {
                                zzeobVar.zzj(t, obj);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.zzitb; i6 < this.zzitc; i6++) {
                    obj = zza((Object) t, this.zzita[i6], (int) obj, (zzeob<UT, int>) zzeobVar);
                }
                if (obj != null) {
                    zzeobVar.zzj(t, obj);
                }
                throw th;
            }
        }
    }

    private static int zza(byte[] bArr, int i2, int i3, zzeos zzeosVar, Class<?> cls, zzejm zzejmVar) throws IOException {
        switch (zzemr.zzimy[zzeosVar.ordinal()]) {
            case 1:
                int zzb = zzejn.zzb(bArr, i2, zzejmVar);
                zzejmVar.zzilu = Boolean.valueOf(zzejmVar.zzilt != 0);
                return zzb;
            case 2:
                return zzejn.zze(bArr, i2, zzejmVar);
            case 3:
                zzejmVar.zzilu = Double.valueOf(zzejn.zzj(bArr, i2));
                return i2 + 8;
            case 4:
            case 5:
                zzejmVar.zzilu = Integer.valueOf(zzejn.zzh(bArr, i2));
                return i2 + 4;
            case 6:
            case 7:
                zzejmVar.zzilu = Long.valueOf(zzejn.zzi(bArr, i2));
                return i2 + 8;
            case 8:
                zzejmVar.zzilu = Float.valueOf(zzejn.zzk(bArr, i2));
                return i2 + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzejn.zza(bArr, i2, zzejmVar);
                zzejmVar.zzilu = Integer.valueOf(zzejmVar.zzils);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzejn.zzb(bArr, i2, zzejmVar);
                zzejmVar.zzilu = Long.valueOf(zzejmVar.zzilt);
                return zzb2;
            case 14:
                return zzejn.zza(zzenc.zzbkf().zzh(cls), bArr, i2, i3, zzejmVar);
            case 15:
                int zza2 = zzejn.zza(bArr, i2, zzejmVar);
                zzejmVar.zzilu = Integer.valueOf(zzekc.zzgh(zzejmVar.zzils));
                return zza2;
            case 16:
                int zzb3 = zzejn.zzb(bArr, i2, zzejmVar);
                zzejmVar.zzilu = Long.valueOf(zzekc.zzfg(zzejmVar.zzilt));
                return zzb3;
            case 17:
                return zzejn.zzd(bArr, i2, zzejmVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0233 -> B:116:0x0234). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x016b -> B:67:0x016c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01e5 -> B:96:0x01e6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.ads.zzejm r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzejm):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> int zza(T t, byte[] bArr, int i2, int i3, int i4, long j2, zzejm zzejmVar) throws IOException {
        Unsafe unsafe = zzhzj;
        Object zzhl = zzhl(i4);
        Object object = unsafe.getObject(t, j2);
        if (this.zzith.zzap(object)) {
            Object zzar = this.zzith.zzar(zzhl);
            this.zzith.zzf(zzar, object);
            unsafe.putObject(t, j2, zzar);
            object = zzar;
        }
        zzemf<?, ?> zzas = this.zzith.zzas(zzhl);
        Map<?, ?> zzan = this.zzith.zzan(object);
        int zza = zzejn.zza(bArr, i2, zzejmVar);
        int i5 = zzejmVar.zzils;
        if (i5 >= 0 && i5 <= i3 - zza) {
            int i6 = i5 + zza;
            Object obj = (K) zzas.zzisl;
            Object obj2 = (V) zzas.zzclv;
            while (zza < i6) {
                int i7 = zza + 1;
                int i8 = bArr[zza];
                if (i8 < 0) {
                    i7 = zzejn.zza(i8, bArr, i7, zzejmVar);
                    i8 = zzejmVar.zzils;
                }
                int i9 = i7;
                int i10 = i8 >>> 3;
                int i11 = i8 & 7;
                if (i10 != 1) {
                    if (i10 == 2 && i11 == zzas.zzism.zzblj()) {
                        zza = zza(bArr, i9, i3, zzas.zzism, zzas.zzclv.getClass(), zzejmVar);
                        obj2 = zzejmVar.zzilu;
                    }
                    zza = zzejn.zza(i8, bArr, i9, i3, zzejmVar);
                } else if (i11 == zzas.zzisk.zzblj()) {
                    zza = zza(bArr, i9, i3, zzas.zzisk, (Class<?>) null, zzejmVar);
                    obj = (K) zzejmVar.zzilu;
                } else {
                    zza = zzejn.zza(i8, bArr, i9, i3, zzejmVar);
                }
            }
            if (zza == i6) {
                zzan.put(obj, obj2);
                return i6;
            }
            throw zzelo.zzbjh();
        }
        throw zzelo.zzbja();
    }

    private final int zza(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, zzejm zzejmVar) throws IOException {
        int zzb;
        Unsafe unsafe = zzhzj;
        long j3 = this.zzisr[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(zzejn.zzj(bArr, i2)));
                    zzb = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(zzejn.zzk(bArr, i2)));
                    zzb = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    zzb = zzejn.zzb(bArr, i2, zzejmVar);
                    unsafe.putObject(t, j2, Long.valueOf(zzejmVar.zzilt));
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    zzb = zzejn.zza(bArr, i2, zzejmVar);
                    unsafe.putObject(t, j2, Integer.valueOf(zzejmVar.zzils));
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(zzejn.zzi(bArr, i2)));
                    zzb = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(zzejn.zzh(bArr, i2)));
                    zzb = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    zzb = zzejn.zzb(bArr, i2, zzejmVar);
                    unsafe.putObject(t, j2, Boolean.valueOf(zzejmVar.zzilt != 0));
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    int zza = zzejn.zza(bArr, i2, zzejmVar);
                    int i10 = zzejmVar.zzils;
                    if (i10 == 0) {
                        unsafe.putObject(t, j2, "");
                    } else if ((i7 & 536870912) != 0 && !zzeok.zzm(bArr, zza, zza + i10)) {
                        throw zzelo.zzbji();
                    } else {
                        unsafe.putObject(t, j2, new String(bArr, zza, i10, zzeld.UTF_8));
                        zza += i10;
                    }
                    unsafe.putInt(t, j3, i5);
                    return zza;
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    int zza2 = zzejn.zza(zzhk(i9), bArr, i2, i3, zzejmVar);
                    Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, zzejmVar.zzilu);
                    } else {
                        unsafe.putObject(t, j2, zzeld.zze(object, zzejmVar.zzilu));
                    }
                    unsafe.putInt(t, j3, i5);
                    return zza2;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    zzb = zzejn.zze(bArr, i2, zzejmVar);
                    unsafe.putObject(t, j2, zzejmVar.zzilu);
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int zza3 = zzejn.zza(bArr, i2, zzejmVar);
                    int i11 = zzejmVar.zzils;
                    zzeli zzhm = zzhm(i9);
                    if (zzhm != null && !zzhm.zzi(i11)) {
                        zzav(t).zzd(i4, Long.valueOf(i11));
                        return zza3;
                    }
                    unsafe.putObject(t, j2, Integer.valueOf(i11));
                    zzb = zza3;
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    zzb = zzejn.zza(bArr, i2, zzejmVar);
                    unsafe.putObject(t, j2, Integer.valueOf(zzekc.zzgh(zzejmVar.zzils)));
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    zzb = zzejn.zzb(bArr, i2, zzejmVar);
                    unsafe.putObject(t, j2, Long.valueOf(zzekc.zzfg(zzejmVar.zzilt)));
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    zzb = zzejn.zza(zzhk(i9), bArr, i2, i3, (i4 & (-8)) | 4, zzejmVar);
                    Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, zzejmVar.zzilu);
                    } else {
                        unsafe.putObject(t, j2, zzeld.zze(object2, zzejmVar.zzilu));
                    }
                    unsafe.putInt(t, j3, i5);
                    return zzb;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x04d7, code lost:
        if (r6 == 1048575) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x04d9, code lost:
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x04df, code lost:
        r1 = null;
        r2 = r9.zzitb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x04e4, code lost:
        if (r2 >= r9.zzitc) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04e6, code lost:
        r1 = (com.google.android.gms.internal.ads.zzeoe) r9.zza((java.lang.Object) r12, r9.zzita[r2], (int) r1, (com.google.android.gms.internal.ads.zzeob<UT, int>) r9.zzitf);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04f5, code lost:
        if (r1 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04f7, code lost:
        r9.zzitf.zzj(r12, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x04fc, code lost:
        if (r7 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0500, code lost:
        if (r0 != r31) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0507, code lost:
        throw com.google.android.gms.internal.ads.zzelo.zzbjh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x050a, code lost:
        if (r0 > r31) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x050c, code lost:
        if (r3 != r7) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x050e, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0513, code lost:
        throw com.google.android.gms.internal.ads.zzelo.zzbjh();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.ads.zzejm r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzejm):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02dc, code lost:
        if (r0 == r5) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02e0, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0323, code lost:
        if (r0 == r15) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0346, code lost:
        if (r0 == r15) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0348, code lost:
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzenj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.ads.zzejm r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzejm):void");
    }

    private final <UT, UB> UB zza(Object obj, int i2, UB ub, zzeob<UT, UB> zzeobVar) {
        zzeli zzhm;
        int i3 = this.zzisr[i2];
        Object zzp = zzeoh.zzp(obj, zzhn(i2) & 1048575);
        return (zzp == null || (zzhm = zzhm(i2)) == null) ? ub : (UB) zza(i2, i3, this.zzith.zzan(zzp), zzhm, (zzeli) ub, (zzeob<UT, zzeli>) zzeobVar);
    }

    private final <K, V, UT, UB> UB zza(int i2, int i3, Map<K, V> map, zzeli zzeliVar, UB ub, zzeob<UT, UB> zzeobVar) {
        zzemf<?, ?> zzas = this.zzith.zzas(zzhl(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzeliVar.zzi(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzeobVar.zzbky();
                }
                zzejz zzgb = zzejr.zzgb(zzemg.zza(zzas, next.getKey(), next.getValue()));
                try {
                    zzemg.zza(zzgb.zzbgr(), zzas, next.getKey(), next.getValue());
                    zzeobVar.zza((zzeob<UT, UB>) ub, i3, zzgb.zzbgq());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i2, zzenj zzenjVar) {
        return zzenjVar.zzaw(zzeoh.zzp(obj, i2 & 1048575));
    }

    private static void zza(int i2, Object obj, zzeoy zzeoyVar) throws IOException {
        if (obj instanceof String) {
            zzeoyVar.zzi(i2, (String) obj);
        } else {
            zzeoyVar.zza(i2, (zzejr) obj);
        }
    }

    private final void zza(Object obj, int i2, zzend zzendVar) throws IOException {
        if (zzhp(i2)) {
            zzeoh.zza(obj, i2 & 1048575, zzendVar.zzbgz());
        } else if (this.zzisx) {
            zzeoh.zza(obj, i2 & 1048575, zzendVar.readString());
        } else {
            zzeoh.zza(obj, i2 & 1048575, zzendVar.zzbha());
        }
    }

    private final boolean zza(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return zze((zzems<T>) t, i2);
        }
        return (i4 & i5) != 0;
    }

    private final boolean zza(T t, int i2, int i3) {
        return zzeoh.zzk(t, (long) (zzho(i3) & 1048575)) == i2;
    }
}
