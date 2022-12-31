package us.pinguo.hawkeye.util;

import java.util.Collection;
import java.util.LinkedList;
import kotlin.jvm.internal.s;
/* compiled from: LruList.kt */
/* loaded from: classes4.dex */
public final class LruList<T> extends LinkedList<T> {
    private final int capacity;

    public LruList(int i2) {
        this.capacity = i2;
    }

    private final void removeEldestEntryIfOverload() {
        if (size() >= this.capacity) {
            removeFirst();
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(T t) {
        removeEldestEntryIfOverload();
        return super.add(t);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> elements) {
        s.i(elements, "elements");
        throw new RuntimeException("Not support");
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addFirst(T t) {
        throw new RuntimeException("Not support");
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addLast(T t) {
        removeEldestEntryIfOverload();
        super.addLast(t);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i2) {
        return (T) removeAt(i2);
    }

    public /* bridge */ Object removeAt(int i2) {
        return super.remove(i2);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends T> elements) {
        s.i(elements, "elements");
        throw new RuntimeException("Not support");
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        throw new RuntimeException("Not support");
    }
}
