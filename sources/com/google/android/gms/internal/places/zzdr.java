package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class zzdr {
    private static final zzdr zzmh = new zzdr(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzdy;
    private int zzii;
    private Object[] zzkt;
    private int[] zzmi;

    private zzdr() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdr zzb(zzdr zzdrVar, zzdr zzdrVar2) {
        int i2 = zzdrVar.count + zzdrVar2.count;
        int[] copyOf = Arrays.copyOf(zzdrVar.zzmi, i2);
        System.arraycopy(zzdrVar2.zzmi, 0, copyOf, zzdrVar.count, zzdrVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzdrVar.zzkt, i2);
        System.arraycopy(zzdrVar2.zzkt, 0, copyOf2, zzdrVar.count, zzdrVar2.count);
        return new zzdr(i2, copyOf, copyOf2, true);
    }

    public static zzdr zzdh() {
        return zzmh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdr zzdi() {
        return new zzdr();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzdr)) {
            zzdr zzdrVar = (zzdr) obj;
            int i2 = this.count;
            if (i2 == zzdrVar.count) {
                int[] iArr = this.zzmi;
                int[] iArr2 = zzdrVar.zzmi;
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
                    Object[] objArr = this.zzkt;
                    Object[] objArr2 = zzdrVar.zzkt;
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
        int[] iArr = this.zzmi;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.zzkt;
        int i8 = this.count;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final void zzab() {
        this.zzdy = false;
    }

    public final int zzbh() {
        int zzf;
        int i2 = this.zzii;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzmi[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                zzf = zzaj.zzf(i6, ((Long) this.zzkt[i4]).longValue());
            } else if (i7 == 1) {
                zzf = zzaj.zzh(i6, ((Long) this.zzkt[i4]).longValue());
            } else if (i7 == 2) {
                zzf = zzaj.zzd(i6, (zzw) this.zzkt[i4]);
            } else if (i7 == 3) {
                zzf = (zzaj.zzr(i6) << 1) + ((zzdr) this.zzkt[i4]).zzbh();
            } else if (i7 == 5) {
                zzf = zzaj.zzk(i6, ((Integer) this.zzkt[i4]).intValue());
            } else {
                throw new IllegalStateException(zzbk.zzbs());
            }
            i3 += zzf;
        }
        this.zzii = i3;
        return i3;
    }

    public final void zzc(zzel zzelVar) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (zzelVar.zzam() == zzbc.zze.zziw) {
            for (int i2 = 0; i2 < this.count; i2++) {
                zzc(this.zzmi[i2], this.zzkt[i2], zzelVar);
            }
            return;
        }
        for (int i3 = this.count - 1; i3 >= 0; i3--) {
            zzc(this.zzmi[i3], this.zzkt[i3], zzelVar);
        }
    }

    public final int zzdj() {
        int i2 = this.zzii;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            i3 += zzaj.zze(this.zzmi[i4] >>> 3, (zzw) this.zzkt[i4]);
        }
        this.zzii = i3;
        return i3;
    }

    private zzdr(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.zzii = -1;
        this.count = i2;
        this.zzmi = iArr;
        this.zzkt = objArr;
        this.zzdy = z;
    }

    private static void zzc(int i2, Object obj, zzel zzelVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            zzelVar.zzj(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            zzelVar.zzd(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            zzelVar.zzb(i3, (zzw) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                zzelVar.zzg(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzbk.zzbs());
        } else if (zzelVar.zzam() == zzbc.zze.zziw) {
            zzelVar.zzaa(i3);
            ((zzdr) obj).zzc(zzelVar);
            zzelVar.zzab(i3);
        } else {
            zzelVar.zzab(i3);
            ((zzdr) obj).zzc(zzelVar);
            zzelVar.zzaa(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzel zzelVar) throws IOException {
        if (zzelVar.zzam() == zzbc.zze.zzix) {
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzelVar.zzb(this.zzmi[i2] >>> 3, this.zzkt[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.count; i3++) {
            zzelVar.zzb(this.zzmi[i3] >>> 3, this.zzkt[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.count; i3++) {
            zzcl.zzb(sb, i2, String.valueOf(this.zzmi[i3] >>> 3), this.zzkt[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(int i2, Object obj) {
        if (this.zzdy) {
            int i3 = this.count;
            int[] iArr = this.zzmi;
            if (i3 == iArr.length) {
                int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
                this.zzmi = Arrays.copyOf(iArr, i4);
                this.zzkt = Arrays.copyOf(this.zzkt, i4);
            }
            int[] iArr2 = this.zzmi;
            int i5 = this.count;
            iArr2[i5] = i2;
            this.zzkt[i5] = obj;
            this.count = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
