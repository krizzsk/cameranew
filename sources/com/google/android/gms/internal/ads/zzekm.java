package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzekm extends zzejl<Double> implements zzell<Double>, zzena, RandomAccess {
    private static final zzekm zzine;
    private int size;
    private double[] zzinf;

    static {
        zzekm zzekmVar = new zzekm(new double[0], 0);
        zzine = zzekmVar;
        zzekmVar.zzbgf();
    }

    zzekm() {
        this(new double[10], 0);
    }

    private final void zzfw(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(zzfx(i2));
        }
    }

    private final String zzfx(int i2) {
        int i3 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        zzbgg();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            double[] dArr = this.zzinf;
            if (i3 < dArr.length) {
                System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
            } else {
                double[] dArr2 = new double[((i3 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i2);
                System.arraycopy(this.zzinf, i2, dArr2, i2 + 1, this.size - i2);
                this.zzinf = dArr2;
            }
            this.zzinf[i2] = doubleValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzfx(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzbgg();
        zzeld.checkNotNull(collection);
        if (!(collection instanceof zzekm)) {
            return super.addAll(collection);
        }
        zzekm zzekmVar = (zzekm) collection;
        int i2 = zzekmVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.zzinf;
            if (i4 > dArr.length) {
                this.zzinf = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(zzekmVar.zzinf, 0, this.zzinf, this.size, zzekmVar.size);
            this.size = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzekm)) {
            return super.equals(obj);
        }
        zzekm zzekmVar = (zzekm) obj;
        if (this.size != zzekmVar.size) {
            return false;
        }
        double[] dArr = zzekmVar.zzinf;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (Double.doubleToLongBits(this.zzinf[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzfw(i2);
        return Double.valueOf(this.zzinf[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + zzeld.zzfq(Double.doubleToLongBits(this.zzinf[i3]));
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.zzinf[i2] == doubleValue) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        zzbgg();
        zzfw(i2);
        double[] dArr = this.zzinf;
        double d2 = dArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        zzbgg();
        if (i3 >= i2) {
            double[] dArr = this.zzinf;
            System.arraycopy(dArr, i3, dArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbgg();
        zzfw(i2);
        double[] dArr = this.zzinf;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zze(double d2) {
        zzbgg();
        int i2 = this.size;
        double[] dArr = this.zzinf;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.zzinf = dArr2;
        }
        double[] dArr3 = this.zzinf;
        int i3 = this.size;
        this.size = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public final /* synthetic */ zzell<Double> zzfy(int i2) {
        if (i2 >= this.size) {
            return new zzekm(Arrays.copyOf(this.zzinf, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzekm(double[] dArr, int i2) {
        this.zzinf = dArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
