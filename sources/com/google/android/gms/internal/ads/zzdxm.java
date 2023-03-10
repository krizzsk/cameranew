package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdxm<F, T> extends AbstractSequentialList<T> implements Serializable {
    private final List<F> zzhyb;
    final zzdvz<? super F, ? extends T> zzhyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxm(List<F> list, zzdvz<? super F, ? extends T> zzdvzVar) {
        this.zzhyb = (List) zzdwl.checkNotNull(list);
        this.zzhyc = (zzdvz) zzdwl.checkNotNull(zzdvzVar);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.zzhyb.clear();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator<T> listIterator(int i2) {
        return new zzdxp(this, this.zzhyb.listIterator(i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzhyb.size();
    }
}
