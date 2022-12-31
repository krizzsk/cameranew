package rx.internal.util.unsafe;

import sun.misc.Unsafe;
/* loaded from: classes3.dex */
public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long ARRAY_BASE;
    private static final int ELEMENT_SHIFT;
    protected final long[] sequenceBuffer;

    static {
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        if (8 == unsafe.arrayIndexScale(long[].class)) {
            int i2 = ConcurrentCircularArrayQueue.SPARSE_SHIFT;
            int i3 = i2 + 3;
            ELEMENT_SHIFT = i3;
            ARRAY_BASE = unsafe.arrayBaseOffset(long[].class) + (32 << (i3 - i2));
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i2) {
        super(i2);
        int i3 = (int) (this.mask + 1);
        this.sequenceBuffer = new long[(i3 << ConcurrentCircularArrayQueue.SPARSE_SHIFT) + 64];
        for (long j2 = 0; j2 < i3; j2++) {
            soSequence(this.sequenceBuffer, calcSequenceOffset(j2), j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long calcSequenceOffset(long j2) {
        return ARRAY_BASE + ((j2 & this.mask) << ELEMENT_SHIFT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvSequence(long[] jArr, long j2) {
        return UnsafeAccess.UNSAFE.getLongVolatile(jArr, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void soSequence(long[] jArr, long j2, long j3) {
        UnsafeAccess.UNSAFE.putOrderedLong(jArr, j2, j3);
    }
}
