package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;
/* loaded from: classes3.dex */
public final class OperatorConcat<T> implements Observable.Operator<T, Observable<? extends T>> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ConcatInnerSubscriber<T> extends Subscriber<T> {
        private final ProducerArbiter arbiter;
        private final Subscriber<T> child;
        private final AtomicInteger once = new AtomicInteger();
        private final ConcatSubscriber<T> parent;

        public ConcatInnerSubscriber(ConcatSubscriber<T> concatSubscriber, Subscriber<T> subscriber, ProducerArbiter producerArbiter) {
            this.parent = concatSubscriber;
            this.child = subscriber;
            this.arbiter = producerArbiter;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.once.compareAndSet(0, 1)) {
                this.parent.completeInner();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.once.compareAndSet(0, 1)) {
                this.parent.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.child.onNext(t);
            this.parent.decrementRequested();
            this.arbiter.produced(1L);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ConcatProducer<T> implements Producer {
        final ConcatSubscriber<T> cs;

        ConcatProducer(ConcatSubscriber<T> concatSubscriber) {
            this.cs = concatSubscriber;
        }

        @Override // rx.Producer
        public void request(long j2) {
            this.cs.requestFromChild(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ConcatSubscriber<T> extends Subscriber<Observable<? extends T>> {
        private final ProducerArbiter arbiter;
        private final Subscriber<T> child;
        private final SerialSubscription current;
        volatile ConcatInnerSubscriber<T> currentSubscriber;
        final NotificationLite<Observable<? extends T>> nl;
        final ConcurrentLinkedQueue<Object> queue;
        private final AtomicLong requested;
        final AtomicInteger wip;

        public ConcatSubscriber(Subscriber<T> subscriber, SerialSubscription serialSubscription) {
            super(subscriber);
            this.nl = NotificationLite.instance();
            this.wip = new AtomicInteger();
            this.requested = new AtomicLong();
            this.child = subscriber;
            this.current = serialSubscription;
            this.arbiter = new ProducerArbiter();
            this.queue = new ConcurrentLinkedQueue<>();
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorConcat.ConcatSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    ConcatSubscriber.this.queue.clear();
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decrementRequested() {
            this.requested.decrementAndGet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestFromChild(long j2) {
            if (j2 <= 0) {
                return;
            }
            long andAddRequest = BackpressureUtils.getAndAddRequest(this.requested, j2);
            this.arbiter.request(j2);
            if (andAddRequest == 0 && this.currentSubscriber == null && this.wip.get() > 0) {
                subscribeNext();
            }
        }

        void completeInner() {
            this.currentSubscriber = null;
            if (this.wip.decrementAndGet() > 0) {
                subscribeNext();
            }
            request(1L);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.queue.add(this.nl.completed());
            if (this.wip.getAndIncrement() == 0) {
                subscribeNext();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.child.onError(th);
            unsubscribe();
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Observable) ((Observable) obj));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(2L);
        }

        void subscribeNext() {
            if (this.requested.get() > 0) {
                Object poll = this.queue.poll();
                if (this.nl.isCompleted(poll)) {
                    this.child.onCompleted();
                    return;
                } else if (poll != null) {
                    this.currentSubscriber = new ConcatInnerSubscriber<>(this, this.child, this.arbiter);
                    this.current.set(this.currentSubscriber);
                    this.nl.getValue(poll).unsafeSubscribe(this.currentSubscriber);
                    return;
                } else {
                    return;
                }
            }
            if (this.nl.isCompleted(this.queue.peek())) {
                this.child.onCompleted();
            }
        }

        public void onNext(Observable<? extends T> observable) {
            this.queue.add(this.nl.next(observable));
            if (this.wip.getAndIncrement() == 0) {
                subscribeNext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Holder {
        static final OperatorConcat<Object> INSTANCE = new OperatorConcat<>();

        private Holder() {
        }
    }

    public static <T> OperatorConcat<T> instance() {
        return (OperatorConcat<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    private OperatorConcat() {
    }

    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        ConcatSubscriber concatSubscriber = new ConcatSubscriber(serializedSubscriber, serialSubscription);
        subscriber.setProducer(new ConcatProducer(concatSubscriber));
        return concatSubscriber;
    }
}
