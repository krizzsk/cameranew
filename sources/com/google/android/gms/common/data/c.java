package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.q;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class c<T> implements Iterator<T> {
    protected final b<T> a;
    protected int b;

    public c(b<T> bVar) {
        q.j(bVar);
        this.a = bVar;
        this.b = -1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            b<T> bVar = this.a;
            int i2 = this.b + 1;
            this.b = i2;
            return bVar.get(i2);
        }
        int i3 = this.b;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i3);
        throw new NoSuchElementException(sb.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
