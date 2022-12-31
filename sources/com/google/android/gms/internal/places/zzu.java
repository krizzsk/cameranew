package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes2.dex */
final class zzu extends zzq<Boolean> implements zzbh<Boolean>, zzcw, RandomAccess {
    private static final zzu zzed;
    private int size;
    private boolean[] zzee;

    static {
        zzu zzuVar = new zzu(new boolean[0], 0);
        zzed = zzuVar;
        zzuVar.zzab();
    }

    zzu() {
        this(new boolean[10], 0);
    }

    private final void zzb(int i2, boolean z) {
        int i3;
        zzac();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            boolean[] zArr = this.zzee;
            if (i3 < zArr.length) {
                System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            } else {
                boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i2);
                System.arraycopy(this.zzee, i2, zArr2, i2 + 1, this.size - i2);
                this.zzee = zArr2;
            }
            this.zzee[i2] = z;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i2));
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
        zzb(i2, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzu)) {
            return super.addAll(collection);
        }
        zzu zzuVar = (zzu) collection;
        int i2 = zzuVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.zzee;
            if (i4 > zArr.length) {
                this.zzee = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(zzuVar.zzee, 0, this.zzee, this.size, zzuVar.size);
            this.size = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        zzb(this.size, z);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzu)) {
            return super.equals(obj);
        }
        zzu zzuVar = (zzu) obj;
        if (this.size != zzuVar.size) {
            return false;
        }
        boolean[] zArr = zzuVar.zzee;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.zzee[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzf(i2);
        return Boolean.valueOf(this.zzee[i2]);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + zzbd.zze(this.zzee[i3]);
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (obj.equals(Boolean.valueOf(this.zzee[i2]))) {
                boolean[] zArr = this.zzee;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.size - i2) - 1);
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
            boolean[] zArr = this.zzee;
            System.arraycopy(zArr, i3, zArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzac();
        zzf(i2);
        boolean[] zArr = this.zzee;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh<Boolean> zzh(int i2) {
        if (i2 >= this.size) {
            return new zzu(Arrays.copyOf(this.zzee, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzu(boolean[] zArr, int i2) {
        this.zzee = zArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        zzac();
        zzf(i2);
        boolean[] zArr = this.zzee;
        boolean z = zArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }
}
