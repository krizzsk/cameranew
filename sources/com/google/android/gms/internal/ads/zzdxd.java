package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdxd<E> extends zzdwy<E> implements List<E>, RandomAccess {
    private static final zzdyd<Object> zzhxq = new zzdxf(zzdxr.zzhyi, 0);

    public static <E> zzdxd<E> zzac(E e2) {
        Object[] objArr = {e2};
        for (int i2 = 0; i2 <= 0; i2++) {
            zzdxo.zzd(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzdxd<E> zzazm() {
        return (zzdxd<E>) zzdxr.zzhyi;
    }

    public static <E> zzdxd<E> zzb(Collection<? extends E> collection) {
        if (collection instanceof zzdwy) {
            zzdxd<E> zzazk = ((zzdwy) collection).zzazk();
            if (zzazk.zzazl()) {
                Object[] array = zzazk.toArray();
                return zzb(array, array.length);
            }
            return zzazk;
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i2 = 0; i2 < length; i2++) {
            zzdxo.zzd(array2[i2], i2);
        }
        return zzb(array2, array2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> zzdxd<E> zzc(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    public static <E> zzdxd<E> zzh(Iterable<? extends E> iterable) {
        zzdwl.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return zzb((Collection) iterable);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return (zzdxd<E>) zzdxr.zzhyi;
        }
        E next = it.next();
        if (!it.hasNext()) {
            return zzac(next);
        }
        zzdxc zzdxcVar = (zzdxc) ((zzdxc) new zzdxc().zzaa(next)).zza(it);
        zzdxcVar.zzhxp = true;
        return zzb(zzdxcVar.zzhxo, zzdxcVar.size);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdwl.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (zzdwf.equal(get(i2), list.get(i2))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i3 = 0;
                while (true) {
                    if (i3 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e2 = get(i3);
                        i3++;
                        if (!zzdwf.equal(e2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = ~(~((i2 * 31) + get(i3).hashCode()));
        }
        return i2;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        int i2 = 0;
        if (obj == null) {
            while (i2 < size) {
                if (get(i2) == null) {
                    return i2;
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                if (obj.equals(get(i2))) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i2) {
        zzdwl.zzu(i2, size());
        if (isEmpty()) {
            return zzhxq;
        }
        return new zzdxf(this, i2);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public int zza(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final zzdya<E> zzazg() {
        return (zzdyd) listIterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final zzdxd<E> zzazk() {
        return this;
    }

    @Override // java.util.List
    /* renamed from: zzv */
    public zzdxd<E> subList(int i2, int i3) {
        zzdwl.zzf(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return (zzdxd<E>) zzdxr.zzhyi;
        }
        return new zzdxe(this, i2, i4);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzdyd) listIterator(0);
    }

    public static <E> zzdxd<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return (zzdxd<E>) zzdxr.zzhyi;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            zzdxo.zzd(objArr[i2], i2);
        }
        return zzb(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> zzdxd<E> zzb(Object[] objArr, int i2) {
        if (i2 == 0) {
            return (zzdxd<E>) zzdxr.zzhyi;
        }
        return new zzdxr(objArr, i2);
    }
}
