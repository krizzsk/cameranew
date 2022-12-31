package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.s;
/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public final class c<K, V> extends a<Map.Entry<K, V>, K, V> {
    private final MapBuilder<K, V> a;

    public c(MapBuilder<K, V> backing) {
        s.h(backing, "backing");
        this.a = backing;
    }

    @Override // kotlin.collections.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        d((Map.Entry) obj);
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> elements) {
        s.h(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.builders.a
    public boolean b(Map.Entry<? extends K, ? extends V> element) {
        s.h(element, "element");
        return this.a.containsEntry$kotlin_stdlib(element);
    }

    @Override // kotlin.collections.builders.a
    public boolean c(Map.Entry element) {
        s.h(element, "element");
        return this.a.removeEntry$kotlin_stdlib(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        s.h(elements, "elements");
        return this.a.containsAllEntries$kotlin_stdlib(elements);
    }

    public boolean d(Map.Entry<K, V> element) {
        s.h(element, "element");
        throw new UnsupportedOperationException();
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
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.a.entriesIterator$kotlin_stdlib();
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
