package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.SynchronizedQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.schedulers.ImmediateScheduler;
import rx.schedulers.TrampolineScheduler;
/* loaded from: classes3.dex */
public final class OperatorObserveOn<T> implements Observable.Operator<T, T> {
    private final Scheduler scheduler;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ObserveOnSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> child;
        volatile Throwable error;
        final Queue<Object> queue;
        final Scheduler.Worker recursiveScheduler;
        final ScheduledUnsubscribe scheduledUnsubscribe;
        final NotificationLite<T> on = NotificationLite.instance();
        volatile boolean finished = false;
        final AtomicLong requested = new AtomicLong();
        final AtomicLong counter = new AtomicLong();
        final Action0 action = new Action0() { // from class: rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber.2
            @Override // rx.functions.Action0
            public void call() {
                ObserveOnSubscriber.this.pollQueue();
            }
        };

        public ObserveOnSubscriber(Scheduler scheduler, Subscriber<? super T> subscriber) {
            this.child = subscriber;
            Scheduler.Worker createWorker = scheduler.createWorker();
            this.recursiveScheduler = createWorker;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.queue = new SynchronizedQueue(RxRingBuffer.SIZE);
            }
            this.scheduledUnsubscribe = new ScheduledUnsubscribe(createWorker);
        }

        void init() {
            this.child.add(this.scheduledUnsubscribe);
            this.child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber.1
                @Override // rx.Producer
                public void request(long j2) {
                    BackpressureUtils.getAndAddRequest(ObserveOnSubscriber.this.requested, j2);
                    ObserveOnSubscriber.this.schedule();
                }
            });
            this.child.add(this.recursiveScheduler);
            this.child.add(this);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (isUnsubscribed() || this.finished) {
                return;
            }
            this.finished = true;
            schedule();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.finished) {
                return;
            }
            this.error = th;
            unsubscribe();
            this.finished = true;
            schedule();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (isUnsubscribed()) {
                return;
            }
            if (!this.queue.offer(this.on.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                schedule();
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RxRingBuffer.SIZE);
        }

        void pollQueue() {
            Object poll;
            AtomicLong atomicLong = this.requested;
            AtomicLong atomicLong2 = this.counter;
            int i2 = 0;
            do {
                atomicLong2.set(1L);
                long j2 = atomicLong.get();
                long j3 = 0;
                while (!this.child.isUnsubscribed()) {
                    if (this.finished) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.queue.clear();
                            this.child.onError(th);
                            return;
                        } else if (this.queue.isEmpty()) {
                            this.child.onCompleted();
                            return;
                        }
                    }
                    if (j2 > 0 && (poll = this.queue.poll()) != null) {
                        this.child.onNext((T) this.on.getValue(poll));
                        j2--;
                        i2++;
                        j3++;
                    } else if (j3 > 0 && atomicLong.get() != LocationRequestCompat.PASSIVE_INTERVAL) {
                        atomicLong.addAndGet(-j3);
                    }
                }
                return;
            } while (atomicLong2.decrementAndGet() > 0);
            if (i2 > 0) {
                request(i2);
            }
        }

        protected void schedule() {
            if (this.counter.getAndIncrement() == 0) {
                this.recursiveScheduler.schedule(this.action);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ScheduledUnsubscribe extends AtomicInteger implements Subscription {
        volatile boolean unsubscribed = false;
        final Scheduler.Worker worker;

        public ScheduledUnsubscribe(Scheduler.Worker worker) {
            this.worker = worker;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.unsubscribed;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (getAndSet(1) == 0) {
                this.worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorObserveOn.ScheduledUnsubscribe.1
                    @Override // rx.functions.Action0
                    public void call() {
                        ScheduledUnsubscribe.this.worker.unsubscribe();
                        ScheduledUnsubscribe.this.unsubscribed = true;
                    }
                });
            }
        }
    }

    public OperatorObserveOn(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler scheduler = this.scheduler;
        if ((scheduler instanceof ImmediateScheduler) || (scheduler instanceof TrampolineScheduler)) {
            return subscriber;
        }
        ObserveOnSubscriber observeOnSubscriber = new ObserveOnSubscriber(this.scheduler, subscriber);
        observeOnSubscriber.init();
        return observeOnSubscriber;
    }
}
