package rx.internal.util.unsafe;
/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
abstract class SpmcArrayQueueProducerField<E> extends SpmcArrayQueueL1Pad<E> {
    protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueProducerField.class, "producerIndex");
    private volatile long producerIndex;

    public SpmcArrayQueueProducerField(int i2) {
        super(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void soTail(long j2) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j2);
    }
}
