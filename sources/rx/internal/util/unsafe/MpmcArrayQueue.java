package rx.internal.util.unsafe;

import androidx.core.location.LocationRequestCompat;
import java.util.Objects;
/* loaded from: classes3.dex */
public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;
    long p40;
    long p41;
    long p42;
    long p43;
    long p44;
    long p45;
    long p46;

    public MpmcArrayQueue(int i2) {
        super(Math.max(2, i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e2) {
        Objects.requireNonNull(e2, "Null is not a valid element");
        long j2 = this.mask + 1;
        long[] jArr = this.sequenceBuffer;
        long j3 = LocationRequestCompat.PASSIVE_INTERVAL;
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvProducerIndex);
            int i2 = ((lvSequence(jArr, calcSequenceOffset) - lvProducerIndex) > 0L ? 1 : ((lvSequence(jArr, calcSequenceOffset) - lvProducerIndex) == 0L ? 0 : -1));
            if (i2 == 0) {
                long j4 = lvProducerIndex + 1;
                if (casProducerIndex(lvProducerIndex, j4)) {
                    spElement(calcElementOffset(lvProducerIndex), e2);
                    soSequence(jArr, calcSequenceOffset, j4);
                    return true;
                }
            } else if (i2 < 0) {
                long j5 = lvProducerIndex - j2;
                if (j5 <= j3) {
                    j3 = lvConsumerIndex();
                    if (j5 <= j3) {
                        return false;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        long lvConsumerIndex;
        E lpElement;
        do {
            lvConsumerIndex = lvConsumerIndex();
            lpElement = lpElement(calcElementOffset(lvConsumerIndex));
            if (lpElement != null) {
                break;
            }
        } while (lvConsumerIndex != lvProducerIndex());
        return lpElement;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long[] jArr = this.sequenceBuffer;
        long j2 = -1;
        while (true) {
            long lvConsumerIndex = lvConsumerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvConsumerIndex);
            long j3 = lvConsumerIndex + 1;
            int i2 = ((lvSequence(jArr, calcSequenceOffset) - j3) > 0L ? 1 : ((lvSequence(jArr, calcSequenceOffset) - j3) == 0L ? 0 : -1));
            if (i2 == 0) {
                if (casConsumerIndex(lvConsumerIndex, j3)) {
                    long calcElementOffset = calcElementOffset(lvConsumerIndex);
                    E lpElement = lpElement(calcElementOffset);
                    spElement(calcElementOffset, null);
                    soSequence(jArr, calcSequenceOffset, lvConsumerIndex + this.mask + 1);
                    return lpElement;
                }
            } else if (i2 < 0 && lvConsumerIndex >= j2) {
                j2 = lvProducerIndex();
                if (lvConsumerIndex == j2) {
                    return null;
                }
            }
        }
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
