package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzjx {
    private static final zzjx zza = new zzjx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzjx() {
        this(0, new int[8], new Object[8], true);
    }

    private zzjx(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i2;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzjx zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjx zzb() {
        return new zzjx(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjx zzc(zzjx zzjxVar, zzjx zzjxVar2) {
        int i2 = zzjxVar.zzb + zzjxVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzjxVar.zzc, i2);
        System.arraycopy(zzjxVar2.zzc, 0, copyOf, zzjxVar.zzb, zzjxVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzjxVar.zzd, i2);
        System.arraycopy(zzjxVar2.zzd, 0, copyOf2, zzjxVar.zzb, zzjxVar2.zzb);
        return new zzjx(i2, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzjx)) {
            zzjx zzjxVar = (zzjx) obj;
            int i2 = this.zzb;
            if (i2 == zzjxVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzjxVar.zzc;
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        Object[] objArr = this.zzd;
                        Object[] objArr2 = zzjxVar.zzd;
                        int i4 = this.zzb;
                        for (int i5 = 0; i5 < i4; i5++) {
                            if (objArr[i5].equals(objArr2[i5])) {
                            }
                        }
                        return true;
                    } else if (iArr[i3] != iArr2[i3]) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.zzc;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.zzd;
        int i8 = this.zzb;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final void zzd() {
        this.zzf = false;
    }

    public final int zze() {
        int i2 = this.zze;
        if (i2 == -1) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4];
                int zzw = zzgz.zzw(8);
                int zzw2 = zzgz.zzw(16);
                int zzw3 = zzgz.zzw(i5 >>> 3);
                int zzw4 = zzgz.zzw(24);
                int zzc = ((zzgs) this.zzd[i4]).zzc();
                i3 += zzw + zzw + zzw2 + zzw3 + zzw4 + zzgz.zzw(zzc) + zzc;
            }
            this.zze = i3;
            return i3;
        }
        return i2;
    }

    public final int zzf() {
        int zzw;
        int zzx;
        int i2;
        int i3 = this.zze;
        if (i3 == -1) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.zzb; i5++) {
                int i6 = this.zzc[i5];
                int i7 = i6 >>> 3;
                int i8 = i6 & 7;
                if (i8 != 0) {
                    if (i8 == 1) {
                        ((Long) this.zzd[i5]).longValue();
                        i2 = zzgz.zzw(i7 << 3) + 8;
                    } else if (i8 == 2) {
                        int zzw2 = zzgz.zzw(i7 << 3);
                        int zzc = ((zzgs) this.zzd[i5]).zzc();
                        i4 += zzw2 + zzgz.zzw(zzc) + zzc;
                    } else if (i8 == 3) {
                        int zzu = zzgz.zzu(i7);
                        zzw = zzu + zzu;
                        zzx = ((zzjx) this.zzd[i5]).zzf();
                    } else if (i8 == 5) {
                        ((Integer) this.zzd[i5]).intValue();
                        i2 = zzgz.zzw(i7 << 3) + 4;
                    } else {
                        throw new IllegalStateException(zzic.zzd());
                    }
                    i4 += i2;
                } else {
                    long longValue = ((Long) this.zzd[i5]).longValue();
                    zzw = zzgz.zzw(i7 << 3);
                    zzx = zzgz.zzx(longValue);
                }
                i2 = zzw + zzx;
                i4 += i2;
            }
            this.zze = i4;
            return i4;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zziz.zzb(sb, i2, String.valueOf(this.zzc[i3] >>> 3), this.zzd[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(int i2, Object obj) {
        if (this.zzf) {
            int i3 = this.zzb;
            int[] iArr = this.zzc;
            if (i3 == iArr.length) {
                int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
                this.zzc = Arrays.copyOf(iArr, i4);
                this.zzd = Arrays.copyOf(this.zzd, i4);
            }
            int[] iArr2 = this.zzc;
            int i5 = this.zzb;
            iArr2[i5] = i2;
            this.zzd[i5] = obj;
            this.zzb = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zzha zzhaVar) throws IOException {
        if (this.zzb != 0) {
            for (int i2 = 0; i2 < this.zzb; i2++) {
                int i3 = this.zzc[i2];
                Object obj = this.zzd[i2];
                int i4 = i3 >>> 3;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    zzhaVar.zzc(i4, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zzhaVar.zzj(i4, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zzhaVar.zzn(i4, (zzgs) obj);
                } else if (i5 == 3) {
                    zzhaVar.zzt(i4);
                    ((zzjx) obj).zzi(zzhaVar);
                    zzhaVar.zzu(i4);
                } else if (i5 == 5) {
                    zzhaVar.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzic.zzd());
                }
            }
        }
    }
}
