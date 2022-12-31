package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzejp extends zzejl<Boolean> implements zzell<Boolean>, zzena, RandomAccess {
    private static final zzejp zzilw;
    private int size;
    private boolean[] zzilx;

    static {
        zzejp zzejpVar = new zzejp(new boolean[0], 0);
        zzilw = zzejpVar;
        zzejpVar.zzbgf();
    }

    zzejp() {
        this(new boolean[10], 0);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbgg();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            boolean[] zArr = this.zzilx;
            if (i3 < zArr.length) {
                System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            } else {
                boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i2);
                System.arraycopy(this.zzilx, i2, zArr2, i2 + 1, this.size - i2);
                this.zzilx = zArr2;
            }
            this.zzilx[i2] = booleanValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzfx(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbgg();
        zzeld.checkNotNull(collection);
        if (!(collection instanceof zzejp)) {
            return super.addAll(collection);
        }
        zzejp zzejpVar = (zzejp) collection;
        int i2 = zzejpVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.zzilx;
            if (i4 > zArr.length) {
                this.zzilx = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(zzejpVar.zzilx, 0, this.zzilx, this.size, zzejpVar.size);
            this.size = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        zzbgg();
        int i2 = this.size;
        boolean[] zArr = this.zzilx;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.zzilx = zArr2;
        }
        boolean[] zArr3 = this.zzilx;
        int i3 = this.size;
        this.size = i3 + 1;
        zArr3[i3] = z;
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
        if (!(obj instanceof zzejp)) {
            return super.equals(obj);
        }
        zzejp zzejpVar = (zzejp) obj;
        if (this.size != zzejpVar.size) {
            return false;
        }
        boolean[] zArr = zzejpVar.zzilx;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.zzilx[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzfw(i2);
        return Boolean.valueOf(this.zzilx[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + zzeld.zzbt(this.zzilx[i3]);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.zzilx[i2] == booleanValue) {
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
        boolean[] zArr = this.zzilx;
        boolean z = zArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        zzbgg();
        if (i3 >= i2) {
            boolean[] zArr = this.zzilx;
            System.arraycopy(zArr, i3, zArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbgg();
        zzfw(i2);
        boolean[] zArr = this.zzilx;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public final /* synthetic */ zzell<Boolean> zzfy(int i2) {
        if (i2 >= this.size) {
            return new zzejp(Arrays.copyOf(this.zzilx, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzejp(boolean[] zArr, int i2) {
        this.zzilx = zArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }
}
