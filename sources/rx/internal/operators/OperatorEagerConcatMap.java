package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;
/* loaded from: classes3.dex */
public final class OperatorEagerConcatMap<T, R> implements Observable.Operator<R, T> {
    final int bufferSize;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class EagerInnerSubscriber<T> extends Subscriber<T> {
        volatile boolean done;
        Throwable error;
        final EagerOuterSubscriber<?, T> parent;
        final Queue<T> queue;

        public EagerInnerSubscriber(EagerOuterSubscriber<?, T> eagerOuterSubscriber, int i2) {
            Queue<T> spscAtomicArrayQueue;
            this.parent = eagerOuterSubscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                spscAtomicArrayQueue = new SpscArrayQueue<>(i2);
            } else {
                spscAtomicArrayQueue = new SpscAtomicArrayQueue<>(i2);
            }
            this.queue = spscAtomicArrayQueue;
            request(i2);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            this.parent.drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.queue.offer(t);
            this.parent.drain();
        }

        void requestMore(long j2) {
            request(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class EagerOuterProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = -657299606803478389L;
        final EagerOuterSubscriber<?, ?> parent;

        public EagerOuterProducer(EagerOuterSubscriber<?, ?> eagerOuterSubscriber) {
            this.parent = eagerOuterSubscriber;
        }

        @Override // rx.Producer
        public void request(long j2) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j2);
            } else if (i2 > 0) {
                BackpressureUtils.getAndAddRequest(this, j2);
                this.parent.drain();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class EagerOuterSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final Func1<? super T, ? extends Observable<? extends R>> mapper;
        private EagerOuterProducer sharedProducer;
        final LinkedList<EagerInnerSubscriber<R>> subscribers = new LinkedList<>();
        final AtomicInteger wip = new AtomicInteger();

        public EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> func1, int i2, Subscriber<? super R> subscriber) {
            this.mapper = func1;
            this.bufferSize = i2;
            this.actual = subscriber;
        }

        void cleanup() {
            ArrayList<Subscription> arrayList;
            synchronized (this.subscribers) {
                arrayList = new ArrayList(this.subscribers);
                this.subscribers.clear();
            }
            for (Subscription subscription : arrayList) {
                subscription.unsubscribe();
            }
        }

        void drain() {
            EagerInnerSubscriber<R> peek;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            EagerOuterProducer eagerOuterProducer = this.sharedProducer;
            Subscriber<? super R> subscriber = this.actual;
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                synchronized (this.subscribers) {
                    peek = this.subscribers.peek();
                }
                boolean z2 = false;
                boolean z3 = peek == null;
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        cleanup();
                        subscriber.onError(th);
                        return;
                    } else if (z3) {
                        subscriber.onCompleted();
                        return;
                    }
                }
                if (!z3) {
                    long j2 = eagerOuterProducer.get();
                    boolean z4 = j2 == LocationRequestCompat.PASSIVE_INTERVAL;
                    Queue<R> queue = peek.queue;
                    long j3 = 0;
                    while (true) {
                        boolean z5 = peek.done;
                        Object obj = (R) queue.peek();
                        boolean z6 = obj == null;
                        if (z5) {
                            Throwable th2 = peek.error;
                            if (th2 == null) {
                                if (z6) {
                                    synchronized (this.subscribers) {
                                        this.subscribers.poll();
                                    }
                                    peek.unsubscribe();
                                    z2 = true;
                                    break;
                                }
                            } else {
                                cleanup();
                                subscriber.onError(th2);
                                return;
                            }
                        }
                        if (z6 || j2 == 0) {
                            break;
                        }
                        queue.poll();
                        try {
                            subscriber.onNext(obj);
                            j2--;
                            j3--;
                        } catch (Throwable th3) {
                            Exceptions.throwOrReport(th3, subscriber, obj);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        if (!z4) {
                            eagerOuterProducer.addAndGet(j3);
                        }
                        if (!z2) {
                            peek.requestMore(-j3);
                        }
                    }
                    if (z2) {
                        continue;
                    }
                }
                i2 = this.wip.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            cleanup();
        }

        void init() {
            this.sharedProducer = new EagerOuterProducer(this);
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    EagerOuterSubscriber.this.cancelled = true;
                    if (EagerOuterSubscriber.this.wip.getAndIncrement() == 0) {
                        EagerOuterSubscriber.this.cleanup();
                    }
                }
            }));
            this.actual.add(this);
            this.actual.setProducer(this.sharedProducer);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            try {
                Observable<? extends R> call = this.mapper.call(t);
                EagerInnerSubscriber<R> eagerInnerSubscriber = new EagerInnerSubscriber<>(this, this.bufferSize);
                if (this.cancelled) {
                    return;
                }
                synchronized (this.subscribers) {
                    if (this.cancelled) {
                        return;
                    }
                    this.subscribers.add(eagerInnerSubscriber);
                    if (this.cancelled) {
                        return;
                    }
                    call.unsafeSubscribe(eagerInnerSubscriber);
                    drain();
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.actual, t);
            }
        }
    }

    public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> func1, int i2) {
        this.mapper = func1;
        this.bufferSize = i2;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        EagerOuterSubscriber eagerOuterSubscriber = new EagerOuterSubscriber(this.mapper, this.bufferSize, subscriber);
        eagerOuterSubscriber.init();
        return eagerOuterSubscriber;
    }
}
