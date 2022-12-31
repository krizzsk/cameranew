package kotlin.collections;

import java.util.Collection;
/* compiled from: AbstractCollection.kt */
/* loaded from: classes3.dex */
public abstract class AbstractCollection<E> implements Collection<E>, kotlin.jvm.internal.z.a {
    public abstract int a();

    @Override // java.util.Collection
    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(E e2) {
        if (isEmpty()) {
            return false;
        }
        for (E e3 : this) {
            if (kotlin.jvm.internal.s.c(e3, e2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.s.h(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.n.a(this);
    }

    public String toString() {
        String J;
        J = c0.J(this, ", ", "[", "]", 0, null, new AbstractCollection$toString$1(this), 24, null);
        return J;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.s.h(array, "array");
        T[] tArr = (T[]) kotlin.jvm.internal.n.b(this, array);
        kotlin.jvm.internal.s.f(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt__CollectionsJVMKt.copyToArrayImpl>");
        return tArr;
    }
}
