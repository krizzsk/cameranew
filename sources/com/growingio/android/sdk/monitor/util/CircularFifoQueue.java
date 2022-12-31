package com.growingio.android.sdk.monitor.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
/* loaded from: classes2.dex */
public class CircularFifoQueue<E> extends AbstractCollection<E> implements Queue<E>, Serializable {
    private static final long serialVersionUID = -8423413834657610406L;
    private transient E[] elements;
    private transient int end;
    private transient boolean full;
    private final int maxElements;
    private transient int start;

    public CircularFifoQueue() {
        this(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decrement(int i2) {
        int i3 = i2 - 1;
        return i3 < 0 ? this.maxElements - 1 : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int increment(int i2) {
        int i3 = i2 + 1;
        if (i3 >= this.maxElements) {
            return 0;
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.elements = (E[]) new Object[this.maxElements];
        int readInt = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.elements[i2] = objectInputStream.readObject();
        }
        this.start = 0;
        boolean z = readInt == this.maxElements;
        this.full = z;
        if (z) {
            this.end = 0;
        } else {
            this.end = readInt;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        Objects.requireNonNull(e2, "Attempted to add null object to queue");
        if (isAtFullCapacity()) {
            remove();
        }
        E[] eArr = this.elements;
        int i2 = this.end;
        int i3 = i2 + 1;
        this.end = i3;
        eArr[i2] = e2;
        if (i3 >= this.maxElements) {
            this.end = 0;
        }
        if (this.end == this.start) {
            this.full = true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.full = false;
        this.start = 0;
        this.end = 0;
        Arrays.fill(this.elements, (Object) null);
    }

    @Override // java.util.Queue
    public E element() {
        if (!isEmpty()) {
            return peek();
        }
        throw new NoSuchElementException("queue is empty");
    }

    public E get(int i2) {
        int size = size();
        if (i2 >= 0 && i2 < size) {
            return this.elements[(this.start + i2) % this.maxElements];
        }
        throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", Integer.valueOf(i2), Integer.valueOf(size)));
    }

    public boolean isAtFullCapacity() {
        return size() == this.maxElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: com.growingio.android.sdk.monitor.util.CircularFifoQueue.1
            private int index;
            private boolean isFirst;
            private int lastReturnedIndex = -1;

            {
                this.index = CircularFifoQueue.this.start;
                this.isFirst = CircularFifoQueue.this.full;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.isFirst || this.index != CircularFifoQueue.this.end;
            }

            @Override // java.util.Iterator
            public E next() {
                if (hasNext()) {
                    this.isFirst = false;
                    int i2 = this.index;
                    this.lastReturnedIndex = i2;
                    this.index = CircularFifoQueue.this.increment(i2);
                    return (E) CircularFifoQueue.this.elements[this.lastReturnedIndex];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                int i2 = this.lastReturnedIndex;
                if (i2 != -1) {
                    if (i2 == CircularFifoQueue.this.start) {
                        CircularFifoQueue.this.remove();
                        this.lastReturnedIndex = -1;
                        return;
                    }
                    int i3 = this.lastReturnedIndex + 1;
                    if (CircularFifoQueue.this.start >= this.lastReturnedIndex || i3 >= CircularFifoQueue.this.end) {
                        while (i3 != CircularFifoQueue.this.end) {
                            if (i3 >= CircularFifoQueue.this.maxElements) {
                                CircularFifoQueue.this.elements[i3 - 1] = CircularFifoQueue.this.elements[0];
                                i3 = 0;
                            } else {
                                CircularFifoQueue.this.elements[CircularFifoQueue.this.decrement(i3)] = CircularFifoQueue.this.elements[i3];
                                i3 = CircularFifoQueue.this.increment(i3);
                            }
                        }
                    } else {
                        System.arraycopy(CircularFifoQueue.this.elements, i3, CircularFifoQueue.this.elements, this.lastReturnedIndex, CircularFifoQueue.this.end - i3);
                    }
                    this.lastReturnedIndex = -1;
                    CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                    circularFifoQueue.end = circularFifoQueue.decrement(circularFifoQueue.end);
                    CircularFifoQueue.this.elements[CircularFifoQueue.this.end] = null;
                    CircularFifoQueue.this.full = false;
                    this.index = CircularFifoQueue.this.decrement(this.index);
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }

    public int maxSize() {
        return this.maxElements;
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        return add(e2);
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.elements[this.start];
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public E remove() {
        if (!isEmpty()) {
            E[] eArr = this.elements;
            int i2 = this.start;
            E e2 = eArr[i2];
            if (e2 != null) {
                int i3 = i2 + 1;
                this.start = i3;
                eArr[i2] = null;
                if (i3 >= this.maxElements) {
                    this.start = 0;
                }
                this.full = false;
            }
            return e2;
        }
        throw new NoSuchElementException("queue is empty");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i2 = this.end;
        int i3 = this.start;
        if (i2 < i3) {
            return (this.maxElements - i3) + i2;
        }
        if (i2 == i3) {
            if (this.full) {
                return this.maxElements;
            }
            return 0;
        }
        return i2 - i3;
    }

    public CircularFifoQueue(int i2) {
        this.start = 0;
        this.end = 0;
        this.full = false;
        if (i2 > 0) {
            E[] eArr = (E[]) new Object[i2];
            this.elements = eArr;
            this.maxElements = eArr.length;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }

    public CircularFifoQueue(Collection<? extends E> collection) {
        this(collection.size());
        addAll(collection);
    }
}
