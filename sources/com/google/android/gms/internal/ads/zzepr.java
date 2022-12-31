package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzepr<E> extends AbstractList<E> {
    private static final zzept zzdc = zzept.zzn(zzepr.class);
    List<E> zzjbk;
    Iterator<E> zzjbl;

    public zzepr(List<E> list, Iterator<E> it) {
        this.zzjbk = list;
        this.zzjbl = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        if (this.zzjbk.size() > i2) {
            return this.zzjbk.get(i2);
        }
        if (this.zzjbl.hasNext()) {
            this.zzjbk.add(this.zzjbl.next());
            return get(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new zzepu(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        zzept zzeptVar = zzdc;
        zzeptVar.zzio("potentially expensive size() call");
        zzeptVar.zzio("blowup running");
        while (this.zzjbl.hasNext()) {
            this.zzjbk.add(this.zzjbl.next());
        }
        return this.zzjbk.size();
    }
}
