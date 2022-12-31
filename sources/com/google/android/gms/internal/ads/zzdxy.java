package com.google.android.gms.internal.ads;

import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzdxy<F, T> implements Iterator<T> {
    final Iterator<? extends F> zzhyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxy(Iterator<? extends F> it) {
        this.zzhyq = (Iterator) zzdwl.checkNotNull(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzhyq.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return zzae(this.zzhyq.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzhyq.remove();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzae(F f2);
}
