package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: ArrayIterator.kt */
/* loaded from: classes3.dex */
final class g<T> implements Iterator<T>, kotlin.jvm.internal.z.a {
    private final T[] a;
    private int b;

    public g(T[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
