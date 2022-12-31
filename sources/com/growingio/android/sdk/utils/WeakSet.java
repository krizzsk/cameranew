package com.growingio.android.sdk.utils;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class WeakSet<T> implements Set<T> {
    private static final Object PRESENT = new Object();
    private transient WeakHashMap<T, Object> map;

    /* loaded from: classes2.dex */
    private static class EmptyIterator<E> implements Iterator<E> {
        private static EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

        private EmptyIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            throw new UnsupportedOperationException("EmptyIterator should not call this method directly");
        }
    }

    /* loaded from: classes2.dex */
    private static class NonEmptyIterator<E> implements Iterator<E> {
        private final Iterator<WeakReference<E>> iterator;

        private NonEmptyIterator(Iterator<WeakReference<E>> it) {
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.iterator.next().get();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T t) {
        if (t != null) {
            if (this.map == null) {
                this.map = new WeakHashMap<>();
            }
            return this.map.put(t, PRESENT) != null;
        }
        throw new IllegalArgumentException("The argument t can't be null");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        throw new UnsupportedOperationException("method addAll not supported now");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        WeakHashMap<T, Object> weakHashMap = this.map;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty() || obj == null) {
            return false;
        }
        return this.map.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException("method containsAll not supported");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<T> iterator() {
        if (isEmpty()) {
            return EmptyIterator.EMPTY_ITERATOR;
        }
        return this.map.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return (isEmpty() || obj == null || this.map.remove(obj) != PRESENT) ? false : true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException("method removeAll not supported now");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException("method retainAll not supported now");
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        WeakHashMap<T, Object> weakHashMap = this.map;
        if (weakHashMap == null) {
            return 0;
        }
        return weakHashMap.size();
    }

    @Override // java.util.Set, java.util.Collection
    @NonNull
    public Object[] toArray() {
        throw new UnsupportedOperationException("method toArray() not supported");
    }

    @Override // java.util.Set, java.util.Collection
    @NonNull
    public <T1> T1[] toArray(@NonNull T1[] t1Arr) {
        throw new UnsupportedOperationException("method toArray(T[] a) not supported");
    }
}
