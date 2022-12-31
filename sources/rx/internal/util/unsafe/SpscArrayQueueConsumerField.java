package rx.internal.util.unsafe;
/* compiled from: SpscArrayQueue.java */
/* loaded from: classes3.dex */
abstract class SpscArrayQueueConsumerField<E> extends SpscArrayQueueL2Pad<E> {
    protected static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueConsumerField.class, "consumerIndex");
    protected long consumerIndex;

    public SpscArrayQueueConsumerField(int i2) {
        super(i2);
    }
}
