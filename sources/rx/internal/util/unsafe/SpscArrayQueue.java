package rx.internal.util.unsafe;

import java.util.Objects;
/* loaded from: classes3.dex */
public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int i2) {
        super(i2);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, SpscArrayQueueConsumerField.C_INDEX_OFFSET);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, SpscArrayQueueProducerFields.P_INDEX_OFFSET);
    }

    private void soConsumerIndex(long j2) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, SpscArrayQueueConsumerField.C_INDEX_OFFSET, j2);
    }

    private void soProducerIndex(long j2) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, SpscArrayQueueProducerFields.P_INDEX_OFFSET, j2);
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e2) {
        Objects.requireNonNull(e2, "null elements not allowed");
        E[] eArr = this.buffer;
        long j2 = this.producerIndex;
        long calcElementOffset = calcElementOffset(j2);
        if (lvElement(eArr, calcElementOffset) != null) {
            return false;
        }
        soProducerIndex(j2 + 1);
        soElement(eArr, calcElementOffset, e2);
        return true;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long j2 = this.consumerIndex;
        long calcElementOffset = calcElementOffset(j2);
        E[] eArr = this.buffer;
        E lvElement = lvElement(eArr, calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j2 + 1);
        soElement(eArr, calcElementOffset, null);
        return lvElement;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
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
}
