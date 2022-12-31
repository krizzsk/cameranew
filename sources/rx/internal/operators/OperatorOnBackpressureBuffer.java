package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes3.dex */
public class OperatorOnBackpressureBuffer<T> implements Observable.Operator<T, T> {
    private final Long capacity;
    private final Action0 onOverflow;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class BufferSubscriber<T> extends Subscriber<T> implements BackpressureDrainManager.BackpressureQueueCallback {
        private final Long baseCapacity;
        private final AtomicLong capacity;
        private final Subscriber<? super T> child;
        private final BackpressureDrainManager manager;
        private final Action0 onOverflow;
        private final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean saturated = new AtomicBoolean(false);
        private final NotificationLite<T> on = NotificationLite.instance();

        public BufferSubscriber(Subscriber<? super T> subscriber, Long l2, Action0 action0) {
            this.child = subscriber;
            this.baseCapacity = l2;
            this.capacity = l2 != null ? new AtomicLong(l2.longValue()) : null;
            this.onOverflow = action0;
            this.manager = new BackpressureDrainManager(this);
        }

        private boolean assertCapacity() {
            long j2;
            if (this.capacity == null) {
                return true;
            }
            do {
                j2 = this.capacity.get();
                if (j2 <= 0) {
                    if (this.saturated.compareAndSet(false, true)) {
                        unsubscribe();
                        Subscriber<? super T> subscriber = this.child;
                        subscriber.onError(new MissingBackpressureException("Overflowed buffer of " + this.baseCapacity));
                        Action0 action0 = this.onOverflow;
                        if (action0 != null) {
                            action0.call();
                        }
                    }
                    return false;
                }
            } while (!this.capacity.compareAndSet(j2, j2 - 1));
            return true;
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public boolean accept(Object obj) {
            return this.on.accept(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public void complete(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        protected Producer manager() {
            return this.manager;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.saturated.get()) {
                return;
            }
            this.manager.terminateAndDrain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.saturated.get()) {
                return;
            }
            this.manager.terminateAndDrain(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (assertCapacity()) {
                this.queue.offer(this.on.next(t));
                this.manager.drain();
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(LocationRequestCompat.PASSIVE_INTERVAL);
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public Object peek() {
            return this.queue.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public Object poll() {
            Object poll = this.queue.poll();
            AtomicLong atomicLong = this.capacity;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Holder {
        static final OperatorOnBackpressureBuffer<?> INSTANCE = new OperatorOnBackpressureBuffer<>();

        private Holder() {
        }
    }

    public static <T> OperatorOnBackpressureBuffer<T> instance() {
        return (OperatorOnBackpressureBuffer<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    private OperatorOnBackpressureBuffer() {
        this.capacity = null;
        this.onOverflow = null;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        BufferSubscriber bufferSubscriber = new BufferSubscriber(subscriber, this.capacity, this.onOverflow);
        subscriber.add(bufferSubscriber);
        subscriber.setProducer(bufferSubscriber.manager());
        return bufferSubscriber;
    }

    public OperatorOnBackpressureBuffer(long j2) {
        this(j2, null);
    }

    public OperatorOnBackpressureBuffer(long j2, Action0 action0) {
        if (j2 > 0) {
            this.capacity = Long.valueOf(j2);
            this.onOverflow = action0;
            return;
        }
        throw new IllegalArgumentException("Buffer capacity must be > 0");
    }
}
