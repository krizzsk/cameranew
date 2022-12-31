package com.pinguo.camera360.data;

import java.util.LinkedList;
/* loaded from: classes3.dex */
public class LimitedLinkedList<T> extends LinkedList<T> {
    private int mMaxSize;

    public LimitedLinkedList(int i2) {
        this.mMaxSize = 0;
        this.mMaxSize = i2;
    }

    private void checkAndRemoveLast() {
        if (size() == this.mMaxSize) {
            removeLast();
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(T t) {
        addFirst(t);
        return true;
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addFirst(T t) {
        checkAndRemoveLast();
        super.addFirst(t);
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addLast(T t) {
        checkAndRemoveLast();
        super.addLast(t);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        checkAndRemoveLast();
        super.add(i2, t);
    }
}
