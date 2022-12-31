package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzob extends zzoh {
    private zzoe zzbhp;
    private final SparseArray<Map<zznu, zzod>> zzbhn = new SparseArray<>();
    private final SparseBooleanArray zzbho = new SparseBooleanArray();
    private int zzaif = 0;

    @Override // com.google.android.gms.internal.ads.zzoh
    public final zzoj zza(zzib[] zzibVarArr, zznu zznuVar) throws zzhe {
        int[] iArr;
        int[] iArr2 = new int[zzibVarArr.length + 1];
        int length = zzibVarArr.length + 1;
        zznr[][] zznrVarArr = new zznr[length];
        int[][][] iArr3 = new int[zzibVarArr.length + 1][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = zznuVar.length;
            zznrVarArr[i2] = new zznr[i3];
            iArr3[i2] = new int[i3];
        }
        int length2 = zzibVarArr.length;
        int[] iArr4 = new int[length2];
        for (int i4 = 0; i4 < length2; i4++) {
            iArr4[i4] = zzibVarArr[i4].zzeg();
        }
        for (int i5 = 0; i5 < zznuVar.length; i5++) {
            zznr zzbc = zznuVar.zzbc(i5);
            int length3 = zzibVarArr.length;
            int i6 = 0;
            for (int i7 = 0; i7 < zzibVarArr.length; i7++) {
                zzib zzibVar = zzibVarArr[i7];
                for (int i8 = 0; i8 < zzbc.length; i8++) {
                    int zza = zzibVar.zza(zzbc.zzbb(i8)) & 3;
                    if (zza > i6) {
                        length3 = i7;
                        if (zza == 3) {
                            break;
                        }
                        i6 = zza;
                    }
                }
            }
            if (length3 == zzibVarArr.length) {
                iArr = new int[zzbc.length];
            } else {
                zzib zzibVar2 = zzibVarArr[length3];
                int[] iArr5 = new int[zzbc.length];
                for (int i9 = 0; i9 < zzbc.length; i9++) {
                    iArr5[i9] = zzibVar2.zza(zzbc.zzbb(i9));
                }
                iArr = iArr5;
            }
            int i10 = iArr2[length3];
            zznrVarArr[length3][i10] = zzbc;
            iArr3[length3][i10] = iArr;
            iArr2[length3] = iArr2[length3] + 1;
        }
        zznu[] zznuVarArr = new zznu[zzibVarArr.length];
        int[] iArr6 = new int[zzibVarArr.length];
        for (int i11 = 0; i11 < zzibVarArr.length; i11++) {
            int i12 = iArr2[i11];
            zznuVarArr[i11] = new zznu((zznr[]) Arrays.copyOf(zznrVarArr[i11], i12));
            iArr3[i11] = (int[][]) Arrays.copyOf(iArr3[i11], i12);
            iArr6[i11] = zzibVarArr[i11].getTrackType();
        }
        zznu zznuVar2 = new zznu((zznr[]) Arrays.copyOf(zznrVarArr[zzibVarArr.length], iArr2[zzibVarArr.length]));
        zzog[] zza2 = zza(zzibVarArr, zznuVarArr, iArr3);
        int i13 = 0;
        while (true) {
            if (i13 < zzibVarArr.length) {
                if (this.zzbho.get(i13)) {
                    zza2[i13] = null;
                } else {
                    zznu zznuVar3 = zznuVarArr[i13];
                    Map<zznu, zzod> map = this.zzbhn.get(i13);
                    if ((map != null ? map.get(zznuVar3) : null) != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i13++;
            } else {
                zzoe zzoeVar = new zzoe(iArr6, zznuVarArr, iArr4, iArr3, zznuVar2);
                zzia[] zziaVarArr = new zzia[zzibVarArr.length];
                for (int i14 = 0; i14 < zzibVarArr.length; i14++) {
                    zziaVarArr[i14] = zza2[i14] != null ? zzia.zzaie : null;
                }
                return new zzoj(zznuVar, new zzoi(zza2), zzoeVar, zziaVarArr);
            }
        }
    }

    protected abstract zzog[] zza(zzib[] zzibVarArr, zznu[] zznuVarArr, int[][][] iArr) throws zzhe;

    @Override // com.google.android.gms.internal.ads.zzoh
    public final void zzd(Object obj) {
        this.zzbhp = (zzoe) obj;
    }

    public final void zzf(int i2, boolean z) {
        if (this.zzbho.get(i2) == z) {
            return;
        }
        this.zzbho.put(i2, z);
        invalidate();
    }
}
