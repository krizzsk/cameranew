package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;
/* loaded from: classes3.dex */
public final class SpscLinkedArrayQueue<T> implements Queue<T> {
    protected AtomicReferenceArray<Object> consumerBuffer;
    protected volatile long consumerIndex;
    protected int consumerMask;
    protected AtomicReferenceArray<Object> producerBuffer;
    protected volatile long producerIndex;
    protected long producerLookAhead;
    protected int producerLookAheadStep;
    protected int producerMask;
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    static final AtomicLongFieldUpdater<SpscLinkedArrayQueue> PRODUCER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscLinkedArrayQueue.class, "producerIndex");
    static final AtomicLongFieldUpdater<SpscLinkedArrayQueue> CONSUMER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscLinkedArrayQueue.class, "consumerIndex");
    private static final Object HAS_NEXT = new Object();

    public SpscLinkedArrayQueue(int i2) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
        int i3 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i3;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i3;
        this.producerLookAhead = i3 - 1;
        soProducerIndex(0L);
    }

    private void adjustLookAheadStep(int i2) {
        this.producerLookAheadStep = Math.min(i2 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static final int calcDirectOffset(int i2) {
        return i2;
    }

    private static final int calcWrappedOffset(long j2, int i2) {
        return calcDirectOffset(((int) j2) & i2);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex;
    }

    private long lpProducerIndex() {
        return this.producerIndex;
    }

    private long lvConsumerIndex() {
        return this.consumerIndex;
    }

    private static final <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> lvNext(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1));
    }

    private long lvProducerIndex() {
        return this.producerIndex;
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.consumerBuffer = atomicReferenceArray;
        return (T) lvElement(atomicReferenceArray, calcWrappedOffset(j2, i2));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.consumerBuffer = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j2, i2);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (t == null) {
            return null;
        }
        soConsumerIndex(j2 + 1);
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        return t;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = (j3 + j2) - 1;
        soProducerIndex(j2 + 1);
        soElement(atomicReferenceArray2, i2, t);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i2, HAS_NEXT);
    }

    private void soConsumerIndex(long j2) {
        CONSUMER_INDEX.lazySet(this, j2);
    }

    private static final void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long j2) {
        PRODUCER_INDEX.lazySet(this, j2);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        soProducerIndex(j2 + 1);
        soElement(atomicReferenceArray, i2, t);
        return true;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lpProducerIndex = lpProducerIndex();
        int i2 = this.producerMask;
        int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i2);
        if (lpProducerIndex < this.producerLookAhead) {
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        }
        long j2 = this.producerLookAheadStep + lpProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j2, i2)) == null) {
            this.producerLookAhead = j2 - 1;
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        } else if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i2)) == null) {
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        } else {
            resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t, i2);
            return true;
        }
    }

    @Override // java.util.Queue
    public final T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i2 = this.consumerMask;
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i2));
        return t == HAS_NEXT ? newBufferPeek(lvNext(atomicReferenceArray), lpConsumerIndex, i2) : t;
    }

    @Override // java.util.Queue
    public final T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i2 = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i2);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z = t == HAS_NEXT;
        if (t == null || z) {
            if (z) {
                return newBufferPoll(lvNext(atomicReferenceArray), lpConsumerIndex, i2);
            }
            return null;
        }
        soConsumerIndex(lpConsumerIndex + 1);
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        return t;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long j2 = this.producerIndex;
        int i2 = this.producerMask;
        long j3 = 2 + j2;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j3, i2)) == null) {
            int calcWrappedOffset = calcWrappedOffset(j2, i2);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t2);
            soProducerIndex(j3);
            soElement(atomicReferenceArray, calcWrappedOffset, t);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(j2, i2);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t2);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soProducerIndex(j3);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        return true;
    }
}
