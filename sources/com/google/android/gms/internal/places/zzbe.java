package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzbe extends zzq<Integer> implements zzbi, zzcw, RandomAccess {
    private static final zzbe zzjc;
    private int size;
    private int[] zzjd;

    static {
        zzbe zzbeVar = new zzbe(new int[0], 0);
        zzjc = zzbeVar;
        zzbeVar.zzab();
    }

    zzbe() {
        this(new int[10], 0);
    }

    public static zzbe zzbo() {
        return zzjc;
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

    private final void zzp(int i2, int i3) {
        int i4;
        zzac();
        if (i2 >= 0 && i2 <= (i4 = this.size)) {
            int[] iArr = this.zzjd;
            if (i4 < iArr.length) {
                System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
            } else {
                int[] iArr2 = new int[((i4 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                System.arraycopy(this.zzjd, i2, iArr2, i2 + 1, this.size - i2);
                this.zzjd = iArr2;
            }
            this.zzjd[i2] = i3;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i2));
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        zzp(i2, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzbe)) {
            return super.addAll(collection);
        }
        zzbe zzbeVar = (zzbe) collection;
        int i2 = zzbeVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.zzjd;
            if (i4 > iArr.length) {
                this.zzjd = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(zzbeVar.zzjd, 0, this.zzjd, this.size, zzbeVar.size);
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
        if (!(obj instanceof zzbe)) {
            return super.equals(obj);
        }
        zzbe zzbeVar = (zzbe) obj;
        if (this.size != zzbeVar.size) {
            return false;
        }
        int[] iArr = zzbeVar.zzjd;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.zzjd[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(getInt(i2));
    }

    public final int getInt(int i2) {
        zzf(i2);
        return this.zzjd[i2];
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + this.zzjd[i3];
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (obj.equals(Integer.valueOf(this.zzjd[i2]))) {
                int[] iArr = this.zzjd;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.size - i2) - 1);
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
            int[] iArr = this.zzjd;
            System.arraycopy(iArr, i3, iArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzac();
        zzf(i2);
        int[] iArr = this.zzjd;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzac(int i2) {
        zzp(this.size, i2);
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh<Integer> zzh(int i2) {
        if (i2 >= this.size) {
            return new zzbe(Arrays.copyOf(this.zzjd, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzbe(int[] iArr, int i2) {
        this.zzjd = iArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        zzac();
        zzf(i2);
        int[] iArr = this.zzjd;
        int i4 = iArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }
}
