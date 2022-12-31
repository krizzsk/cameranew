package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeoe {
    private static final zzeoe zziva = new zzeoe(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzilo;
    private int zziql;
    private Object[] zziss;
    private int[] zzivb;

    private zzeoe() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeoe zza(zzeoe zzeoeVar, zzeoe zzeoeVar2) {
        int i2 = zzeoeVar.count + zzeoeVar2.count;
        int[] copyOf = Arrays.copyOf(zzeoeVar.zzivb, i2);
        System.arraycopy(zzeoeVar2.zzivb, 0, copyOf, zzeoeVar.count, zzeoeVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzeoeVar.zziss, i2);
        System.arraycopy(zzeoeVar2.zziss, 0, copyOf2, zzeoeVar.count, zzeoeVar2.count);
        return new zzeoe(i2, copyOf, copyOf2, true);
    }

    public static zzeoe zzbkz() {
        return zziva;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeoe zzbla() {
        return new zzeoe();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzeoe)) {
            zzeoe zzeoeVar = (zzeoe) obj;
            int i2 = this.count;
            if (i2 == zzeoeVar.count) {
                int[] iArr = this.zzivb;
                int[] iArr2 = zzeoeVar.zzivb;
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        z = true;
                        break;
                    } else if (iArr[i3] != iArr2[i3]) {
                        z = false;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    Object[] objArr = this.zziss;
                    Object[] objArr2 = zzeoeVar.zziss;
                    int i4 = this.count;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= i4) {
                            z2 = true;
                            break;
                        } else if (!objArr[i5].equals(objArr2[i5])) {
                            z2 = false;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (z2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.count;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.zzivb;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.zziss;
        int i8 = this.count;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final void zzb(zzeoy zzeoyVar) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (zzeoyVar.zzbhv() == zzeox.zzixh) {
            for (int i2 = 0; i2 < this.count; i2++) {
                zzb(this.zzivb[i2], this.zziss[i2], zzeoyVar);
            }
            return;
        }
        for (int i3 = this.count - 1; i3 >= 0; i3--) {
            zzb(this.zzivb[i3], this.zziss[i3], zzeoyVar);
        }
    }

    public final void zzbgf() {
        this.zzilo = false;
    }

    public final int zzbik() {
        int zzm;
        int i2 = this.zziql;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzivb[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                zzm = zzekl.zzm(i6, ((Long) this.zziss[i4]).longValue());
            } else if (i7 == 1) {
                zzm = zzekl.zzo(i6, ((Long) this.zziss[i4]).longValue());
            } else if (i7 == 2) {
                zzm = zzekl.zzc(i6, (zzejr) this.zziss[i4]);
            } else if (i7 == 3) {
                zzm = (zzekl.zzgv(i6) << 1) + ((zzeoe) this.zziss[i4]).zzbik();
            } else if (i7 == 5) {
                zzm = zzekl.zzaj(i6, ((Integer) this.zziss[i4]).intValue());
            } else {
                throw new IllegalStateException(zzelo.zzbjf());
            }
            i3 += zzm;
        }
        this.zziql = i3;
        return i3;
    }

    public final int zzblb() {
        int i2 = this.zziql;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            i3 += zzekl.zzd(this.zzivb[i4] >>> 3, (zzejr) this.zziss[i4]);
        }
        this.zziql = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i2, Object obj) {
        if (this.zzilo) {
            int i3 = this.count;
            int[] iArr = this.zzivb;
            if (i3 == iArr.length) {
                int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
                this.zzivb = Arrays.copyOf(iArr, i4);
                this.zziss = Arrays.copyOf(this.zziss, i4);
            }
            int[] iArr2 = this.zzivb;
            int i5 = this.count;
            iArr2[i5] = i2;
            this.zziss[i5] = obj;
            this.count = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    private zzeoe(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.zziql = -1;
        this.count = i2;
        this.zzivb = iArr;
        this.zziss = objArr;
        this.zzilo = z;
    }

    private static void zzb(int i2, Object obj, zzeoy zzeoyVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            zzeoyVar.zzq(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            zzeoyVar.zzk(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            zzeoyVar.zza(i3, (zzejr) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                zzeoyVar.zzaf(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzelo.zzbjf());
        } else if (zzeoyVar.zzbhv() == zzeox.zzixh) {
            zzeoyVar.zzhe(i3);
            ((zzeoe) obj).zzb(zzeoyVar);
            zzeoyVar.zzhf(i3);
        } else {
            zzeoyVar.zzhf(i3);
            ((zzeoe) obj).zzb(zzeoyVar);
            zzeoyVar.zzhe(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzeoy zzeoyVar) throws IOException {
        if (zzeoyVar.zzbhv() == zzeox.zzixi) {
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzeoyVar.zzc(this.zzivb[i2] >>> 3, this.zziss[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.count; i3++) {
            zzeoyVar.zzc(this.zzivb[i3] >>> 3, this.zziss[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.count; i3++) {
            zzemp.zza(sb, i2, String.valueOf(this.zzivb[i3] >>> 3), this.zziss[i3]);
        }
    }
}
