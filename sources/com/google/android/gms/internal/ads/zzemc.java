package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzemc extends zzejl<Long> implements zzelm, zzena, RandomAccess {
    private static final zzemc zzish;
    private int size;
    private long[] zzisi;

    static {
        zzemc zzemcVar = new zzemc(new long[0], 0);
        zzish = zzemcVar;
        zzemcVar.zzbgf();
    }

    zzemc() {
        this(new long[10], 0);
    }

    public static zzemc zzbjr() {
        return zzish;
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
        long longValue = ((Long) obj).longValue();
        zzbgg();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            long[] jArr = this.zzisi;
            if (i3 < jArr.length) {
                System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
            } else {
                long[] jArr2 = new long[((i3 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i2);
                System.arraycopy(this.zzisi, i2, jArr2, i2 + 1, this.size - i2);
                this.zzisi = jArr2;
            }
            this.zzisi[i2] = longValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzfx(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzbgg();
        zzeld.checkNotNull(collection);
        if (!(collection instanceof zzemc)) {
            return super.addAll(collection);
        }
        zzemc zzemcVar = (zzemc) collection;
        int i2 = zzemcVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.zzisi;
            if (i4 > jArr.length) {
                this.zzisi = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(zzemcVar.zzisi, 0, this.zzisi, this.size, zzemcVar.size);
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
        if (!(obj instanceof zzemc)) {
            return super.equals(obj);
        }
        zzemc zzemcVar = (zzemc) obj;
        if (this.size != zzemcVar.size) {
            return false;
        }
        long[] jArr = zzemcVar.zzisi;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.zzisi[i2] != jArr[i2]) {
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
        zzfw(i2);
        return this.zzisi[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + zzeld.zzfq(this.zzisi[i3]);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.zzisi[i2] == longValue) {
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
        long[] jArr = this.zzisi;
        long j2 = jArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        zzbgg();
        if (i3 >= i2) {
            long[] jArr = this.zzisi;
            System.arraycopy(jArr, i3, jArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbgg();
        zzfw(i2);
        long[] jArr = this.zzisi;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzfr(long j2) {
        zzbgg();
        int i2 = this.size;
        long[] jArr = this.zzisi;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.zzisi = jArr2;
        }
        long[] jArr3 = this.zzisi;
        int i3 = this.size;
        this.size = i3 + 1;
        jArr3[i3] = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    /* renamed from: zzhi */
    public final zzelm zzfy(int i2) {
        if (i2 >= this.size) {
            return new zzemc(Arrays.copyOf(this.zzisi, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzemc(long[] jArr, int i2) {
        this.zzisi = jArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzfr(((Long) obj).longValue());
        return true;
    }
}
