package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdwy<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzhxn = new Object[0];

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(@NullableDecl Object obj);

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(zzhxn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i2) {
        zzdya zzdyaVar = (zzdya) iterator();
        while (zzdyaVar.hasNext()) {
            objArr[i2] = zzdyaVar.next();
            i2++;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzazg */
    public abstract zzdya<E> iterator();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzazh() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzazi() {
        throw new UnsupportedOperationException();
    }

    int zzazj() {
        throw new UnsupportedOperationException();
    }

    public zzdxd<E> zzazk() {
        return isEmpty() ? zzdxd.zzazm() : zzdxd.zzc(toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzazl();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzdwl.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzazh = zzazh();
            if (zzazh != null) {
                return (T[]) Arrays.copyOfRange(zzazh, zzazi(), zzazj(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }
}
