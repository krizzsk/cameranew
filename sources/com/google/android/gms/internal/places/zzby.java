package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes2.dex */
final class zzby extends zzq<Long> implements zzbh<Long>, zzcw, RandomAccess {
    private static final zzby zzkg;
    private int size;
    private long[] zzkh;

    static {
        zzby zzbyVar = new zzby(new long[0], 0);
        zzkg = zzbyVar;
        zzbyVar.zzab();
    }

    zzby() {
        this(new long[10], 0);
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

    private final void zzl(int i2, long j2) {
        int i3;
        zzac();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            long[] jArr = this.zzkh;
            if (i3 < jArr.length) {
                System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
            } else {
                long[] jArr2 = new long[((i3 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i2);
                System.arraycopy(this.zzkh, i2, jArr2, i2 + 1, this.size - i2);
                this.zzkh = jArr2;
            }
            this.zzkh[i2] = j2;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i2));
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        zzl(i2, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzby)) {
            return super.addAll(collection);
        }
        zzby zzbyVar = (zzby) collection;
        int i2 = zzbyVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.zzkh;
            if (i4 > jArr.length) {
                this.zzkh = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(zzbyVar.zzkh, 0, this.zzkh, this.size, zzbyVar.size);
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
        if (!(obj instanceof zzby)) {
            return super.equals(obj);
        }
        zzby zzbyVar = (zzby) obj;
        if (this.size != zzbyVar.size) {
            return false;
        }
        long[] jArr = zzbyVar.zzkh;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.zzkh[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(getLong(i2));
    }

    public final long getLong(int i2) {
        zzf(i2);
        return this.zzkh[i2];
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + zzbd.zzl(this.zzkh[i3]);
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (obj.equals(Long.valueOf(this.zzkh[i2]))) {
                long[] jArr = this.zzkh;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.size - i2) - 1);
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
            long[] jArr = this.zzkh;
            System.arraycopy(jArr, i3, jArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzac();
        zzf(i2);
        long[] jArr = this.zzkh;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh<Long> zzh(int i2) {
        if (i2 >= this.size) {
            return new zzby(Arrays.copyOf(this.zzkh, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzm(long j2) {
        zzl(this.size, j2);
    }

    private zzby(long[] jArr, int i2) {
        this.zzkh = jArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        zzac();
        zzf(i2);
        long[] jArr = this.zzkh;
        long j2 = jArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }
}
