package com.nostra13.universalimageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements Object<E>, Serializable, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient e<E> first;
    transient e<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* loaded from: classes3.dex */
    private abstract class b implements Iterator<E> {
        e<E> a;
        E b;
        private e<E> c;

        b() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> b = b();
                this.a = b;
                this.b = b == null ? null : b.a;
            } finally {
                reentrantLock.unlock();
            }
        }

        private e<E> d(e<E> eVar) {
            while (true) {
                e<E> c = c(eVar);
                if (c == null) {
                    return null;
                }
                if (c.a != null) {
                    return c;
                }
                if (c == eVar) {
                    return b();
                }
                eVar = c;
            }
        }

        void a() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> d2 = d(this.a);
                this.a = d2;
                this.b = d2 == null ? null : d2.a;
            } finally {
                reentrantLock.unlock();
            }
        }

        abstract e<E> b();

        abstract e<E> c(e<E> eVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            e<E> eVar = this.a;
            if (eVar != null) {
                this.c = eVar;
                E e2 = this.b;
                a();
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            e<E> eVar = this.c;
            if (eVar != null) {
                this.c = null;
                ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
                reentrantLock.lock();
                try {
                    if (eVar.a != null) {
                        LinkedBlockingDeque.this.unlink(eVar);
                    }
                    return;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes3.dex */
    private class c extends b {
        private c() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        e<E> b() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        e<E> c(e<E> eVar) {
            return eVar.b;
        }
    }

    /* loaded from: classes3.dex */
    private class d extends b {
        private d() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        e<E> b() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        e<E> c(e<E> eVar) {
            return eVar.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class e<E> {
        E a;
        e<E> b;
        e<E> c;

        e(E e2) {
            this.a = e2;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    private boolean linkFirst(e<E> eVar) {
        int i2 = this.count;
        if (i2 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.first;
        eVar.c = eVar2;
        this.first = eVar;
        if (this.last == null) {
            this.last = eVar;
        } else {
            eVar2.b = eVar;
        }
        this.count = i2 + 1;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(e<E> eVar) {
        int i2 = this.count;
        if (i2 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.last;
        eVar.b = eVar2;
        this.last = eVar;
        if (this.first == null) {
            this.first = eVar;
        } else {
            eVar2.c = eVar;
        }
        this.count = i2 + 1;
        this.notEmpty.signal();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            add(readObject);
        }
    }

    private E unlinkFirst() {
        e<E> eVar = this.first;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.c;
        E e2 = eVar.a;
        eVar.a = null;
        eVar.c = eVar;
        this.first = eVar2;
        if (eVar2 == null) {
            this.last = null;
        } else {
            eVar2.b = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private E unlinkLast() {
        e<E> eVar = this.last;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.b;
        E e2 = eVar.a;
        eVar.a = null;
        eVar.b = eVar;
        this.last = eVar2;
        if (eVar2 == null) {
            this.first = null;
        } else {
            eVar2.c = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.c) {
                objectOutputStream.writeObject(eVar.a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    public void addFirst(E e2) {
        if (!offerFirst(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e2) {
        if (!offerLast(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            while (eVar != null) {
                eVar.a = null;
                e<E> eVar2 = eVar.c;
                eVar.b = null;
                eVar.c = null;
                eVar = eVar2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.c) {
                if (obj.equals(eVar.a)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> descendingIterator() {
        return new c();
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new d();
    }

    public boolean offer(E e2) {
        return offerLast(e2);
    }

    public boolean offerFirst(E e2) {
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerLast(E e2) {
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            return eVar == null ? null : eVar.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.last;
            return eVar == null ? null : eVar.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e2) {
        addFirst(e2);
    }

    public void put(E e2) throws InterruptedException {
        putLast(e2);
    }

    public void putFirst(E e2) throws InterruptedException {
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(eVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void putLast(E e2) throws InterruptedException {
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(eVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.c) {
                if (obj.equals(eVar.a)) {
                    unlink(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.last; eVar != null; eVar = eVar.b) {
                if (obj.equals(eVar.a)) {
                    unlink(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() throws InterruptedException {
        return takeFirst();
    }

    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i2 = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                int i3 = i2 + 1;
                objArr[i2] = eVar.a;
                eVar = eVar.c;
                i2 = i3;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            if (eVar == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = eVar.a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                eVar = eVar.c;
                if (eVar == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    void unlink(e<E> eVar) {
        e<E> eVar2 = eVar.b;
        e<E> eVar3 = eVar.c;
        if (eVar2 == null) {
            unlinkFirst();
        } else if (eVar3 == null) {
            unlinkLast();
        } else {
            eVar2.c = eVar3;
            eVar3.b = eVar2;
            eVar.a = null;
            this.count--;
            this.notFull.signal();
        }
    }

    public LinkedBlockingDeque(int i2) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        if (i2 > 0) {
            this.capacity = i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int drainTo(Collection<? super E> collection, int i2) {
        Objects.requireNonNull(collection);
        if (collection != this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int min = Math.min(i2, this.count);
                for (int i3 = 0; i3 < min; i3++) {
                    collection.add((E) this.first.a);
                    unlinkFirst();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean offer(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e2, j2, timeUnit);
    }

    public E poll(long j2, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j2, timeUnit);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E pollFirst(long j2, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollLast(long j2, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean offerFirst(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkFirst(eVar)) {
                    z = true;
                    break;
                } else if (nanos <= 0) {
                    z = false;
                    break;
                } else {
                    nanos = this.notFull.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    public boolean offerLast(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkLast(eVar)) {
                    z = true;
                    break;
                } else if (nanos <= 0) {
                    z = false;
                    break;
                } else {
                    nanos = this.notFull.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e2 : collection) {
                if (e2 != null) {
                    if (!linkLast(new e<>(e2))) {
                        throw new IllegalStateException("Deque full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
            }
            int i2 = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                tArr[i2] = eVar.a;
                eVar = eVar.c;
                i2++;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }
}
