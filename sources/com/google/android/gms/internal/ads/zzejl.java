package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzejl<E> extends AbstractList<E> implements zzell<E> {
    private boolean zzilo = true;

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        zzbgg();
        return super.add(e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        zzbgg();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        zzbgg();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            if (!(obj instanceof RandomAccess)) {
                return super.equals(obj);
            }
            List list = (List) obj;
            int size = size();
            if (size != list.size()) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (!get(i2).equals(list.get(i2))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i2) {
        zzbgg();
        return (E) super.remove(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        zzbgg();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        zzbgg();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        zzbgg();
        return (E) super.set(i2, e2);
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public boolean zzbge() {
        return this.zzilo;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public final void zzbgf() {
        this.zzilo = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzbgg() {
        if (!this.zzilo) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        zzbgg();
        super.add(i2, e2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        zzbgg();
        return super.addAll(i2, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        zzbgg();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
