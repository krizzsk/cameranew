package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
/* loaded from: classes3.dex */
public final class OperatorMapNotification<T, R> implements Observable.Operator<R, T> {
    private final Func0<? extends R> onCompleted;
    private final Func1<? super Throwable, ? extends R> onError;
    private final Func1<? super T, ? extends R> onNext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class MapNotificationSubscriber extends Subscriber<T> {
        final SingleEmitter<R> emitter;
        private final Subscriber<? super R> o;
        private final ProducerArbiter pa;

        void init() {
            this.o.setProducer(this.emitter);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onCompleted() {
            try {
                this.emitter.offerAndComplete(OperatorMapNotification.this.onCompleted.call());
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.o);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onError(Throwable th) {
            try {
                this.emitter.offerAndComplete(OperatorMapNotification.this.onError.call(th));
            } catch (Throwable th2) {
                Exceptions.throwOrReport(th2, this.o);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(T t) {
            try {
                this.emitter.offer(OperatorMapNotification.this.onNext.call(t));
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.o, t);
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.pa.setProducer(producer);
        }

        private MapNotificationSubscriber(ProducerArbiter producerArbiter, Subscriber<? super R> subscriber) {
            this.pa = producerArbiter;
            this.o = subscriber;
            this.emitter = new SingleEmitter<>(subscriber, producerArbiter, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SingleEmitter<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -249869671366010660L;
        final Subscription cancel;
        final Subscriber<? super T> child;
        volatile boolean complete;
        boolean emitting;
        boolean missed;
        final NotificationLite<T> nl;
        final Producer producer;
        final Queue<Object> queue;

        public SingleEmitter(Subscriber<? super T> subscriber, Producer producer, Subscription subscription) {
            this.child = subscriber;
            this.producer = producer;
            this.cancel = subscription;
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscArrayQueue<>(2) : new ConcurrentLinkedQueue<>();
            this.nl = NotificationLite.instance();
        }

        void drain() {
            boolean z;
            synchronized (this) {
                boolean z2 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                while (true) {
                    try {
                        long j2 = get();
                        boolean z3 = this.complete;
                        boolean isEmpty = this.queue.isEmpty();
                        if (z3 && isEmpty) {
                            this.child.onCompleted();
                            return;
                        }
                        if (j2 > 0) {
                            Object poll = this.queue.poll();
                            if (poll != null) {
                                this.child.onNext((T) this.nl.getValue(poll));
                                produced(1L);
                            } else if (z3) {
                                this.child.onCompleted();
                                return;
                            }
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (!this.missed) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.missed = false;
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = false;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            z = z2;
                            th = th3;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        public void offer(T t) {
            if (!this.queue.offer(t)) {
                this.child.onError(new MissingBackpressureException());
                unsubscribe();
                return;
            }
            drain();
        }

        public void offerAndComplete(T t) {
            if (!this.queue.offer(t)) {
                this.child.onError(new MissingBackpressureException());
                unsubscribe();
                return;
            }
            this.complete = true;
            drain();
        }

        void produced(long j2) {
            long j3;
            long j4;
            do {
                j3 = get();
                if (j3 < 0) {
                    return;
                }
                j4 = j3 - j2;
                if (j4 < 0) {
                    throw new IllegalStateException("More produced (" + j2 + ") than requested (" + j3 + ")");
                }
            } while (!compareAndSet(j3, j4));
        }

        @Override // rx.Producer
        public void request(long j2) {
            long j3;
            long j4;
            do {
                j3 = get();
                if (j3 < 0) {
                    return;
                }
                j4 = j3 + j2;
                if (j4 < 0) {
                    j4 = LocationRequestCompat.PASSIVE_INTERVAL;
                }
            } while (!compareAndSet(j3, j4));
            this.producer.request(j2);
            drain();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.cancel.unsubscribe();
        }
    }

    public OperatorMapNotification(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        this.onNext = func1;
        this.onError = func12;
        this.onCompleted = func0;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        MapNotificationSubscriber mapNotificationSubscriber = new MapNotificationSubscriber(new ProducerArbiter(), subscriber);
        subscriber.add(mapNotificationSubscriber);
        mapNotificationSubscriber.init();
        return mapNotificationSubscriber;
    }
}
