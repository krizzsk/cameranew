package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.s;
/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public final class e<V> extends kotlin.collections.d<V> implements Collection<V>, kotlin.jvm.internal.z.b {
    private final MapBuilder<?, V> a;

    public e(MapBuilder<?, V> backing) {
        s.h(backing, "backing");
        this.a = backing;
    }

    @Override // kotlin.collections.d
    public int a() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> elements) {
        s.h(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return this.a.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.a.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        s.h(elements, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        s.h(elements, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
