package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdxk<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
    private final List<F> zzhyb;
    final zzdvz<? super F, ? extends T> zzhyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxk(List<F> list, zzdvz<? super F, ? extends T> zzdvzVar) {
        this.zzhyb = (List) zzdwl.checkNotNull(list);
        this.zzhyc = (zzdvz) zzdwl.checkNotNull(zzdvzVar);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.zzhyb.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int i2) {
        return this.zzhyc.apply((F) this.zzhyb.get(i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.zzhyb.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<T> listIterator(int i2) {
        return new zzdxn(this, this.zzhyb.listIterator(i2));
    }

    @Override // java.util.AbstractList, java.util.List
    public final T remove(int i2) {
        return this.zzhyc.apply((F) this.zzhyb.remove(i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzhyb.size();
    }
}
