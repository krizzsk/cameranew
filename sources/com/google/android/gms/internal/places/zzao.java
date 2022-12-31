package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes2.dex */
final class zzao extends zzq<Double> implements zzbh<Double>, zzcw, RandomAccess {
    private static final zzao zzex;
    private int size;
    private double[] zzey;

    static {
        zzao zzaoVar = new zzao(new double[0], 0);
        zzex = zzaoVar;
        zzaoVar.zzab();
    }

    zzao() {
        this(new double[10], 0);
    }

    private final void zzf(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
    }

    private final String zzg(int i2) {
        int i3 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        zzd(i2, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzao)) {
            return super.addAll(collection);
        }
        zzao zzaoVar = (zzao) collection;
        int i2 = zzaoVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.zzey;
            if (i4 > dArr.length) {
                this.zzey = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(zzaoVar.zzey, 0, this.zzey, this.size, zzaoVar.size);
            this.size = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzao)) {
            return super.equals(obj);
        }
        zzao zzaoVar = (zzao) obj;
        if (this.size != zzaoVar.size) {
            return false;
        }
        double[] dArr = zzaoVar.zzey;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (Double.doubleToLongBits(this.zzey[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzf(i2);
        return Double.valueOf(this.zzey[i2]);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + zzbd.zzl(Double.doubleToLongBits(this.zzey[i3]));
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (obj.equals(Double.valueOf(this.zzey[i2]))) {
                double[] dArr = this.zzey;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.size - i2) - 1);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        zzac();
        if (i3 >= i2) {
            double[] dArr = this.zzey;
            System.arraycopy(dArr, i3, dArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzac();
        zzf(i2);
        double[] dArr = this.zzey;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzd(double d2) {
        zzd(this.size, d2);
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh<Double> zzh(int i2) {
        if (i2 >= this.size) {
            return new zzao(Arrays.copyOf(this.zzey, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzao(double[] dArr, int i2) {
        this.zzey = dArr;
        this.size = i2;
    }

    private final void zzd(int i2, double d2) {
        int i3;
        zzac();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            double[] dArr = this.zzey;
            if (i3 < dArr.length) {
                System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
            } else {
                double[] dArr2 = new double[((i3 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i2);
                System.arraycopy(this.zzey, i2, dArr2, i2 + 1, this.size - i2);
                this.zzey = dArr2;
            }
            this.zzey[i2] = d2;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i2));
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        zzac();
        zzf(i2);
        double[] dArr = this.zzey;
        double d2 = dArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }
}
