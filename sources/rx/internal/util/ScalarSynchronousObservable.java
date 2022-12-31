package rx.internal.util;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;
/* loaded from: classes3.dex */
public final class ScalarSynchronousObservable<T> extends Observable<T> {
    private final T t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class DirectScheduledEmission<T> implements Observable.OnSubscribe<T> {
        private final EventLoopsScheduler es;
        private final T value;

        DirectScheduledEmission(EventLoopsScheduler eventLoopsScheduler, T t) {
            this.es = eventLoopsScheduler;
            this.value = t;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            subscriber.add(this.es.scheduleDirect(new ScalarSynchronousAction(subscriber, this.value)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class NormalScheduledEmission<T> implements Observable.OnSubscribe<T> {
        private final Scheduler scheduler;
        private final T value;

        NormalScheduledEmission(Scheduler scheduler, T t) {
            this.scheduler = scheduler;
            this.value = t;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            Scheduler.Worker createWorker = this.scheduler.createWorker();
            subscriber.add(createWorker);
            createWorker.schedule(new ScalarSynchronousAction(subscriber, this.value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ScalarSynchronousAction<T> implements Action0 {
        private final Subscriber<? super T> subscriber;
        private final T value;

        @Override // rx.functions.Action0
        public void call() {
            try {
                this.subscriber.onNext((T) this.value);
                this.subscriber.onCompleted();
            } catch (Throwable th) {
                this.subscriber.onError(th);
            }
        }

        private ScalarSynchronousAction(Subscriber<? super T> subscriber, T t) {
            this.subscriber = subscriber;
            this.value = t;
        }
    }

    protected ScalarSynchronousObservable(final T t) {
        super(new Observable.OnSubscribe<T>() { // from class: rx.internal.util.ScalarSynchronousObservable.1
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(Subscriber<? super T> subscriber) {
                subscriber.onNext((Object) t);
                subscriber.onCompleted();
            }
        });
        this.t = t;
    }

    public static final <T> ScalarSynchronousObservable<T> create(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public T get() {
        return this.t;
    }

    public <R> Observable<R> scalarFlatMap(final Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.create(new Observable.OnSubscribe<R>() { // from class: rx.internal.util.ScalarSynchronousObservable.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.Action1
            public void call(final Subscriber<? super R> subscriber) {
                Observable observable = (Observable) func1.call(ScalarSynchronousObservable.this.t);
                if (observable.getClass() == ScalarSynchronousObservable.class) {
                    subscriber.onNext(((ScalarSynchronousObservable) observable).t);
                    subscriber.onCompleted();
                    return;
                }
                observable.unsafeSubscribe(new Subscriber<R>(subscriber) { // from class: rx.internal.util.ScalarSynchronousObservable.2.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    @Override // rx.Observer
                    public void onNext(R r) {
                        subscriber.onNext(r);
                    }
                });
            }
        });
    }

    public Observable<T> scalarScheduleOn(Scheduler scheduler) {
        if (scheduler instanceof EventLoopsScheduler) {
            return Observable.create(new DirectScheduledEmission((EventLoopsScheduler) scheduler, this.t));
        }
        return Observable.create(new NormalScheduledEmission(scheduler, this.t));
    }
}
