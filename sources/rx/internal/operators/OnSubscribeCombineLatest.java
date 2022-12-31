package rx.internal.operators;

import java.util.BitSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
/* loaded from: classes3.dex */
public final class OnSubscribeCombineLatest<T, R> implements Observable.OnSubscribe<R> {
    final FuncN<? extends R> combinator;
    final List<? extends Observable<? extends T>> sources;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class MultiSourceProducer<T, R> implements Producer {
        private final Subscriber<? super R> child;
        private final Object[] collectedValues;
        private final FuncN<? extends R> combinator;
        private final BitSet completion;
        private volatile int completionCount;
        private final BitSet haveValues;
        private volatile int haveValuesCount;
        private final List<? extends Observable<? extends T>> sources;
        private final MultiSourceRequestableSubscriber<T, R>[] subscribers;
        private final AtomicBoolean started = new AtomicBoolean();
        private final AtomicLong requested = new AtomicLong();
        private final RxRingBuffer buffer = RxRingBuffer.getSpmcInstance();
        private final AtomicLong counter = new AtomicLong();

        public MultiSourceProducer(Subscriber<? super R> subscriber, List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
            this.sources = list;
            this.child = subscriber;
            this.combinator = funcN;
            int size = list.size();
            this.subscribers = new MultiSourceRequestableSubscriber[size];
            this.collectedValues = new Object[size];
            this.haveValues = new BitSet(size);
            this.completion = new BitSet(size);
        }

        public void onCompleted(int i2, boolean z) {
            boolean z2;
            if (!z) {
                this.child.onCompleted();
                return;
            }
            synchronized (this) {
                z2 = false;
                if (!this.completion.get(i2)) {
                    this.completion.set(i2);
                    this.completionCount++;
                    if (this.completionCount == this.collectedValues.length) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                this.buffer.onCompleted();
                tick();
            }
        }

        public void onError(Throwable th) {
            this.child.onError(th);
        }

        public boolean onNext(int i2, T t) {
            synchronized (this) {
                if (!this.haveValues.get(i2)) {
                    this.haveValues.set(i2);
                    this.haveValuesCount++;
                }
                this.collectedValues[i2] = t;
                int i3 = this.haveValuesCount;
                Object[] objArr = this.collectedValues;
                if (i3 != objArr.length) {
                    return false;
                }
                try {
                    this.buffer.onNext(this.combinator.call(objArr));
                } catch (MissingBackpressureException e2) {
                    onError(e2);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this.child);
                }
                tick();
                return true;
            }
        }

        @Override // rx.Producer
        public void request(long j2) {
            BackpressureUtils.getAndAddRequest(this.requested, j2);
            if (!this.started.get()) {
                int i2 = 0;
                if (this.started.compareAndSet(false, true)) {
                    int i3 = RxRingBuffer.SIZE;
                    int size = i3 / this.sources.size();
                    int size2 = i3 % this.sources.size();
                    while (i2 < this.sources.size()) {
                        Observable<? extends T> observable = this.sources.get(i2);
                        MultiSourceRequestableSubscriber<T, R> multiSourceRequestableSubscriber = new MultiSourceRequestableSubscriber<>(i2, i2 == this.sources.size() - 1 ? size + size2 : size, this.child, this);
                        this.subscribers[i2] = multiSourceRequestableSubscriber;
                        observable.unsafeSubscribe(multiSourceRequestableSubscriber);
                        i2++;
                    }
                }
            }
            tick();
        }

        void tick() {
            Object poll;
            AtomicLong atomicLong = this.counter;
            if (atomicLong.getAndIncrement() == 0) {
                int i2 = 0;
                do {
                    if (this.requested.get() > 0 && (poll = this.buffer.poll()) != null) {
                        if (this.buffer.isCompleted(poll)) {
                            this.child.onCompleted();
                        } else {
                            this.buffer.accept(poll, this.child);
                            i2++;
                            this.requested.decrementAndGet();
                        }
                    }
                } while (atomicLong.decrementAndGet() > 0);
                if (i2 > 0) {
                    for (MultiSourceRequestableSubscriber<T, R> multiSourceRequestableSubscriber : this.subscribers) {
                        multiSourceRequestableSubscriber.requestUpTo(i2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class MultiSourceRequestableSubscriber<T, R> extends Subscriber<T> {
        final AtomicLong emitted;
        boolean hasValue;
        final int index;
        final MultiSourceProducer<T, R> producer;

        public MultiSourceRequestableSubscriber(int i2, int i3, Subscriber<? super R> subscriber, MultiSourceProducer<T, R> multiSourceProducer) {
            super(subscriber);
            this.emitted = new AtomicLong();
            this.hasValue = false;
            this.index = i2;
            this.producer = multiSourceProducer;
            request(i3);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.producer.onCompleted(this.index, this.hasValue);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.producer.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.hasValue = true;
            this.emitted.incrementAndGet();
            if (this.producer.onNext(this.index, t)) {
                return;
            }
            request(1L);
        }

        public void requestUpTo(long j2) {
            long j3;
            long min;
            do {
                j3 = this.emitted.get();
                min = Math.min(j3, j2);
            } while (!this.emitted.compareAndSet(j3, j3 - min));
            request(min);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SingleSourceProducer<T, R> implements Producer {
        final Subscriber<? super R> child;
        final FuncN<? extends R> combinator;
        final Observable<? extends T> source;
        final AtomicBoolean started = new AtomicBoolean();
        final SingleSourceRequestableSubscriber<T, R> subscriber;

        public SingleSourceProducer(Subscriber<? super R> subscriber, Observable<? extends T> observable, FuncN<? extends R> funcN) {
            this.source = observable;
            this.child = subscriber;
            this.combinator = funcN;
            this.subscriber = new SingleSourceRequestableSubscriber<>(subscriber, funcN);
        }

        @Override // rx.Producer
        public void request(long j2) {
            this.subscriber.requestMore(j2);
            if (this.started.compareAndSet(false, true)) {
                this.source.unsafeSubscribe(this.subscriber);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SingleSourceRequestableSubscriber<T, R> extends Subscriber<T> {
        private final Subscriber<? super R> child;
        private final FuncN<? extends R> combinator;

        SingleSourceRequestableSubscriber(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            super(subscriber);
            this.child = subscriber;
            this.combinator = funcN;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.child.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.child.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.child.onNext((R) this.combinator.call(t));
        }

        public void requestMore(long j2) {
            request(j2);
        }
    }

    public OnSubscribeCombineLatest(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
        this.sources = list;
        this.combinator = funcN;
        if (list.size() > RxRingBuffer.SIZE) {
            throw new IllegalArgumentException("More than RxRingBuffer.SIZE sources to combineLatest is not supported.");
        }
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        if (this.sources.isEmpty()) {
            subscriber.onCompleted();
        } else if (this.sources.size() == 1) {
            subscriber.setProducer(new SingleSourceProducer(subscriber, this.sources.get(0), this.combinator));
        } else {
            subscriber.setProducer(new MultiSourceProducer(subscriber, this.sources, this.combinator));
        }
    }
}
