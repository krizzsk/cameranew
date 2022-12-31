package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class OperatorTimeoutBase<T> implements Observable.Operator<T, T> {
    private final FirstTimeoutStub<T> firstTimeoutStub;
    private final Observable<? extends T> other;
    private final Scheduler scheduler;
    private final TimeoutStub<T> timeoutStub;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface FirstTimeoutStub<T> extends Func3<TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface TimeoutStub<T> extends Func4<TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class TimeoutSubscriber<T> extends Subscriber<T> {
        final AtomicLong actual;
        private final Object gate;
        private final Scheduler.Worker inner;
        private final Observable<? extends T> other;
        private final SerialSubscription serial;
        private final SerializedSubscriber<T> serializedSubscriber;
        final AtomicInteger terminated;
        private final TimeoutStub<T> timeoutStub;

        @Override // rx.Observer
        public void onCompleted() {
            boolean z;
            synchronized (this.gate) {
                z = true;
                if (this.terminated.getAndSet(1) != 0) {
                    z = false;
                }
            }
            if (z) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            boolean z;
            synchronized (this.gate) {
                z = true;
                if (this.terminated.getAndSet(1) != 0) {
                    z = false;
                }
            }
            if (z) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            boolean z;
            synchronized (this.gate) {
                if (this.terminated.get() == 0) {
                    this.actual.incrementAndGet();
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                this.serializedSubscriber.onNext(t);
                this.serial.set(this.timeoutStub.call(this, Long.valueOf(this.actual.get()), t, this.inner));
            }
        }

        public void onTimeout(long j2) {
            boolean z;
            synchronized (this.gate) {
                z = true;
                if (j2 != this.actual.get() || this.terminated.getAndSet(1) != 0) {
                    z = false;
                }
            }
            if (z) {
                Observable<? extends T> observable = this.other;
                if (observable == null) {
                    this.serializedSubscriber.onError(new TimeoutException());
                    return;
                }
                observable.unsafeSubscribe(this.serializedSubscriber);
                this.serial.set(this.serializedSubscriber);
            }
        }

        private TimeoutSubscriber(SerializedSubscriber<T> serializedSubscriber, TimeoutStub<T> timeoutStub, SerialSubscription serialSubscription, Observable<? extends T> observable, Scheduler.Worker worker) {
            super(serializedSubscriber);
            this.gate = new Object();
            this.terminated = new AtomicInteger();
            this.actual = new AtomicLong();
            this.serializedSubscriber = serializedSubscriber;
            this.timeoutStub = timeoutStub;
            this.serial = serialSubscription;
            this.other = observable;
            this.inner = worker;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OperatorTimeoutBase(FirstTimeoutStub<T> firstTimeoutStub, TimeoutStub<T> timeoutStub, Observable<? extends T> observable, Scheduler scheduler) {
        this.firstTimeoutStub = firstTimeoutStub;
        this.timeoutStub = timeoutStub;
        this.other = observable;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(new SerializedSubscriber(subscriber), this.timeoutStub, serialSubscription, this.other, createWorker);
        serialSubscription.set(this.firstTimeoutStub.call(timeoutSubscriber, 0L, createWorker));
        return timeoutSubscriber;
    }
}
