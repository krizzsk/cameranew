package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzhb extends zzgc<Double> implements RandomAccess, zzhz, zzje {
    private static final zzhb zza;
    private double[] zzb;
    private int zzc;

    static {
        zzhb zzhbVar = new zzhb(new double[0], 0);
        zza = zzhbVar;
        zzhbVar.zzb();
    }

    zzhb() {
        this(new double[10], 0);
    }

    private final void zzf(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
    }

    private final String zzg(int i2) {
        int i3 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        zzbL();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
        double[] dArr = this.zzb;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.zzb, i2, dArr2, i2 + 1, this.zzc - i2);
            this.zzb = dArr2;
        }
        this.zzb[i2] = doubleValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzd(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzbL();
        zzia.zza(collection);
        if (!(collection instanceof zzhb)) {
            return super.addAll(collection);
        }
        zzhb zzhbVar = (zzhb) collection;
        int i2 = zzhbVar.zzc;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.zzb;
            if (i4 > dArr.length) {
                this.zzb = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(zzhbVar.zzb, 0, this.zzb, this.zzc, zzhbVar.zzc);
            this.zzc = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhb)) {
            return super.equals(obj);
        }
        zzhb zzhbVar = (zzhb) obj;
        if (this.zzc != zzhbVar.zzc) {
            return false;
        }
        double[] dArr = zzhbVar.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (Double.doubleToLongBits(this.zzb[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        zzf(i2);
        return Double.valueOf(this.zzb[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            i2 = (i2 * 31) + zzia.zze(Double.doubleToLongBits(this.zzb[i3]));
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int i2 = this.zzc;
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.zzb[i3] == doubleValue) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        int i3;
        zzbL();
        zzf(i2);
        double[] dArr = this.zzb;
        double d2 = dArr[i2];
        if (i2 < this.zzc - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        zzbL();
        if (i3 >= i2) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, i3, dArr, i2, this.zzc - i3);
            this.zzc -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbL();
        zzf(i2);
        double[] dArr = this.zzb;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    public final void zzd(double d2) {
        zzbL();
        int i2 = this.zzc;
        double[] dArr = this.zzb;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final /* bridge */ /* synthetic */ zzhz zze(int i2) {
        if (i2 >= this.zzc) {
            return new zzhb(Arrays.copyOf(this.zzb, i2), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzhb(double[] dArr, int i2) {
        this.zzb = dArr;
        this.zzc = i2;
    }
}
