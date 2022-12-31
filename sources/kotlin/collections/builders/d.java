package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.g;
import kotlin.jvm.internal.s;
/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public final class d<E> extends g<E> implements Set<E>, Object {
    private final MapBuilder<E, ?> a;

    public d(MapBuilder<E, ?> backing) {
        s.h(backing, "backing");
        this.a = backing;
    }

    @Override // kotlin.collections.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        s.h(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // kotlin.collections.g
    public int getSize() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.a.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.a.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        s.h(elements, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        s.h(elements, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
