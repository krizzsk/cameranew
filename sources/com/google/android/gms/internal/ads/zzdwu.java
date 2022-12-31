package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzdwu<E> extends zzdyd<E> {
    private int position;
    private final int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdwu(int i2, int i3) {
        zzdwl.zzu(i3, i2);
        this.size = i2;
        this.position = i3;
    }

    protected abstract E get(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.position < this.size;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.position > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i2 = this.position;
            this.position = i2 + 1;
            return get(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.position;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.position - 1;
            this.position = i2;
            return get(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.position - 1;
    }
}
