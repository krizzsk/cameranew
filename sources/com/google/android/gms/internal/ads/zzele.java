package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzele extends zzejl<Integer> implements zzelh, zzena, RandomAccess {
    private static final zzele zzirc;
    private int size;
    private int[] zzird;

    static {
        zzele zzeleVar = new zzele(new int[0], 0);
        zzirc = zzeleVar;
        zzeleVar.zzbgf();
    }

    zzele() {
        this(new int[10], 0);
    }

    public static zzele zzbiz() {
        return zzirc;
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
        int intValue = ((Integer) obj).intValue();
        zzbgg();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            int[] iArr = this.zzird;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                System.arraycopy(this.zzird, i2, iArr2, i2 + 1, this.size - i2);
                this.zzird = iArr2;
            }
            this.zzird[i2] = intValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzfx(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbgg();
        zzeld.checkNotNull(collection);
        if (!(collection instanceof zzele)) {
            return super.addAll(collection);
        }
        zzele zzeleVar = (zzele) collection;
        int i2 = zzeleVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.zzird;
            if (i4 > iArr.length) {
                this.zzird = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(zzeleVar.zzird, 0, this.zzird, this.size, zzeleVar.size);
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
        if (!(obj instanceof zzele)) {
            return super.equals(obj);
        }
        zzele zzeleVar = (zzele) obj;
        if (this.size != zzeleVar.size) {
            return false;
        }
        int[] iArr = zzeleVar.zzird;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.zzird[i2] != iArr[i2]) {
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
        zzfw(i2);
        return this.zzird[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + this.zzird[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.zzird[i2] == intValue) {
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
        int[] iArr = this.zzird;
        int i4 = iArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        zzbgg();
        if (i3 >= i2) {
            int[] iArr = this.zzird;
            System.arraycopy(iArr, i3, iArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbgg();
        zzfw(i2);
        int[] iArr = this.zzird;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    /* renamed from: zzhg */
    public final zzelh zzfy(int i2) {
        if (i2 >= this.size) {
            return new zzele(Arrays.copyOf(this.zzird, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzelh
    public final void zzhh(int i2) {
        zzbgg();
        int i3 = this.size;
        int[] iArr = this.zzird;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.zzird = iArr2;
        }
        int[] iArr3 = this.zzird;
        int i4 = this.size;
        this.size = i4 + 1;
        iArr3[i4] = i2;
    }

    private zzele(int[] iArr, int i2) {
        this.zzird = iArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzhh(((Integer) obj).intValue());
        return true;
    }
}
