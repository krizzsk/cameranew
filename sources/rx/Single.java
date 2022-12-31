package rx;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.annotations.Beta;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.internal.operators.OnSubscribeToObservableFuture;
import rx.internal.operators.OperatorDelay;
import rx.internal.operators.OperatorDoOnEach;
import rx.internal.operators.OperatorMap;
import rx.internal.operators.OperatorObserveOn;
import rx.internal.operators.OperatorOnErrorReturn;
import rx.internal.operators.OperatorSubscribeOn;
import rx.internal.operators.OperatorTimeout;
import rx.internal.operators.OperatorZip;
import rx.internal.producers.SingleDelayedProducer;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaObservableExecutionHook;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;
import rx.singles.BlockingSingle;
import rx.subscriptions.Subscriptions;
@Beta
/* loaded from: classes3.dex */
public class Single<T> {
    private static final RxJavaObservableExecutionHook hook = RxJavaPlugins.getInstance().getObservableExecutionHook();
    final Observable.OnSubscribe<T> onSubscribe;

    /* loaded from: classes3.dex */
    public interface OnSubscribe<T> extends Action1<SingleSubscriber<? super T>> {
    }

    /* loaded from: classes3.dex */
    public interface Transformer<T, R> extends Func1<Single<T>, Single<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Single(final OnSubscribe<T> onSubscribe) {
        this.onSubscribe = new Observable.OnSubscribe<T>() { // from class: rx.Single.1
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super T> subscriber) {
                final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
                subscriber.setProducer(singleDelayedProducer);
                SingleSubscriber<T> singleSubscriber = new SingleSubscriber<T>() { // from class: rx.Single.1.1
                    @Override // rx.SingleSubscriber
                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    @Override // rx.SingleSubscriber
                    public void onSuccess(T t) {
                        singleDelayedProducer.setValue(t);
                    }
                };
                subscriber.add(singleSubscriber);
                onSubscribe.call(singleSubscriber);
            }
        };
    }

    private static <T> Observable<T> asObservable(Single<T> single) {
        return Observable.create(single.onSubscribe);
    }

    public static final <T> Observable<T> concat(Single<? extends T> single, Single<? extends T> single2) {
        return Observable.concat(asObservable(single), asObservable(single2));
    }

    public static final <T> Single<T> create(OnSubscribe<T> onSubscribe) {
        return new Single<>(onSubscribe);
    }

    @Experimental
    public static <T> Single<T> defer(final Callable<Single<T>> callable) {
        return create(new OnSubscribe<T>() { // from class: rx.Single.13
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SingleSubscriber) ((SingleSubscriber) obj));
            }

            public void call(SingleSubscriber<? super T> singleSubscriber) {
                try {
                    ((Single) callable.call()).subscribe(singleSubscriber);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    singleSubscriber.onError(th);
                }
            }
        });
    }

    public static final <T> Single<T> error(final Throwable th) {
        return create(new OnSubscribe<T>() { // from class: rx.Single.3
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SingleSubscriber) ((SingleSubscriber) obj));
            }

            public void call(SingleSubscriber<? super T> singleSubscriber) {
                singleSubscriber.onError(th);
            }
        });
    }

    public static final <T> Single<T> from(Future<? extends T> future) {
        return new Single<>(OnSubscribeToObservableFuture.toObservableFuture(future));
    }

    @Experimental
    public static <T> Single<T> fromCallable(final Callable<? extends T> callable) {
        return create(new OnSubscribe<T>() { // from class: rx.Single.4
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SingleSubscriber) ((SingleSubscriber) obj));
            }

            public void call(SingleSubscriber<? super T> singleSubscriber) {
                try {
                    singleSubscriber.onSuccess((Object) callable.call());
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    singleSubscriber.onError(th);
                }
            }
        });
    }

    public static final <T> Single<T> just(final T t) {
        return create(new OnSubscribe<T>() { // from class: rx.Single.5
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SingleSubscriber) ((SingleSubscriber) obj));
            }

            public void call(SingleSubscriber<? super T> singleSubscriber) {
                singleSubscriber.onSuccess((Object) t);
            }
        });
    }

    private final <R> Single<R> lift(final Observable.Operator<? extends R, ? super T> operator) {
        return new Single<>(new Observable.OnSubscribe<R>() { // from class: rx.Single.2
            @Override // rx.functions.Action1
            public void call(Subscriber<? super R> subscriber) {
                try {
                    Subscriber<? super T> call = Single.hook.onLift(operator).call(subscriber);
                    call.onStart();
                    Single.this.onSubscribe.call(call);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscriber.onError(th);
                }
            }
        });
    }

    public static final <T> Single<T> merge(Single<? extends Single<? extends T>> single) {
        return create(new OnSubscribe<T>() { // from class: rx.Single.6
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SingleSubscriber) ((SingleSubscriber) obj));
            }

            public void call(final SingleSubscriber<? super T> singleSubscriber) {
                Single.this.subscribe(new SingleSubscriber<Single<? extends T>>() { // from class: rx.Single.6.1
                    @Override // rx.SingleSubscriber
                    public void onError(Throwable th) {
                        singleSubscriber.onError(th);
                    }

                    @Override // rx.SingleSubscriber
                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((Single) ((Single) obj));
                    }

                    public void onSuccess(Single<? extends T> single2) {
                        single2.subscribe(singleSubscriber);
                    }
                });
            }
        });
    }

    private final Single<Observable<T>> nest() {
        return just(asObservable(this));
    }

    public static final <T1, T2, R> Single<R> zip(Single<? extends T1> single, Single<? extends T2> single2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return just(new Observable[]{asObservable(single), asObservable(single2)}).lift(new OperatorZip(func2));
    }

    public <R> Single<R> compose(Transformer<? super T, ? extends R> transformer) {
        return (Single) transformer.call(this);
    }

    public final Observable<T> concatWith(Single<? extends T> single) {
        return concat(this, single);
    }

    @Experimental
    public final Single<T> delay(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return (Single<T>) lift(new OperatorDelay(j2, timeUnit, scheduler));
    }

    @Experimental
    public final Single<T> doOnError(final Action1<Throwable> action1) {
        return (Single<T>) lift(new OperatorDoOnEach(new Observer<T>() { // from class: rx.Single.11
            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                action1.call(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
            }
        }));
    }

    @Experimental
    public final Single<T> doOnSuccess(final Action1<? super T> action1) {
        return (Single<T>) lift(new OperatorDoOnEach(new Observer<T>() { // from class: rx.Single.12
            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
            }

            @Override // rx.Observer
            public void onNext(T t) {
                action1.call(t);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Single<R> flatMap(Func1<? super T, ? extends Single<? extends R>> func1) {
        return merge(map(func1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMapObservable(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.merge(asObservable(map(func1)));
    }

    public final <R> Single<R> map(Func1<? super T, ? extends R> func1) {
        return lift(new OperatorMap(func1));
    }

    public final Observable<T> mergeWith(Single<? extends T> single) {
        return merge(this, single);
    }

    public final Single<T> observeOn(Scheduler scheduler) {
        return (Single<T>) lift(new OperatorObserveOn(scheduler));
    }

    public final Single<T> onErrorReturn(Func1<Throwable, ? extends T> func1) {
        return (Single<T>) lift(new OperatorOnErrorReturn(func1));
    }

    public final Subscription subscribe() {
        return subscribe(new Subscriber<T>() { // from class: rx.Single.7
            @Override // rx.Observer
            public final void onCompleted() {
            }

            @Override // rx.Observer
            public final void onError(Throwable th) {
                throw new OnErrorNotImplementedException(th);
            }

            @Override // rx.Observer
            public final void onNext(T t) {
            }
        });
    }

    public final Single<T> subscribeOn(Scheduler scheduler) {
        return (Single<T>) nest().lift(new OperatorSubscribeOn(scheduler));
    }

    public final Single<T> timeout(long j2, TimeUnit timeUnit) {
        return timeout(j2, timeUnit, null, Schedulers.computation());
    }

    @Experimental
    public final BlockingSingle<T> toBlocking() {
        return BlockingSingle.from(this);
    }

    public final Observable<T> toObservable() {
        return asObservable(this);
    }

    public final void unsafeSubscribe(Subscriber<? super T> subscriber) {
        RuntimeException runtimeException;
        try {
            subscriber.onStart();
            this.onSubscribe.call(subscriber);
            hook.onSubscribeReturn(subscriber);
        } finally {
            try {
            } catch (Throwable th) {
            }
        }
    }

    public final <T2, R> Single<R> zipWith(Single<? extends T2> single, Func2<? super T, ? super T2, ? extends R> func2) {
        return zip(this, single, func2);
    }

    public static final <T> Observable<T> concat(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3) {
        return Observable.concat(asObservable(single), asObservable(single2), asObservable(single3));
    }

    public static final <T> Single<T> from(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        return new Single<>(OnSubscribeToObservableFuture.toObservableFuture(future, j2, timeUnit));
    }

    public static final <T> Observable<T> merge(Single<? extends T> single, Single<? extends T> single2) {
        return Observable.merge(asObservable(single), asObservable(single2));
    }

    public static final <T1, T2, T3, R> Single<R> zip(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return just(new Observable[]{asObservable(single), asObservable(single2), asObservable(single3)}).lift(new OperatorZip(func3));
    }

    @Experimental
    public final Single<T> delay(long j2, TimeUnit timeUnit) {
        return delay(j2, timeUnit, Schedulers.computation());
    }

    public final Subscription subscribe(final Action1<? super T> action1) {
        if (action1 != null) {
            return subscribe(new Subscriber<T>() { // from class: rx.Single.8
                @Override // rx.Observer
                public final void onCompleted() {
                }

                @Override // rx.Observer
                public final void onError(Throwable th) {
                    throw new OnErrorNotImplementedException(th);
                }

                @Override // rx.Observer
                public final void onNext(T t) {
                    action1.call(t);
                }
            });
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    public final Single<T> timeout(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(j2, timeUnit, null, scheduler);
    }

    private Single(Observable.OnSubscribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public static final <T> Observable<T> concat(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4) {
        return Observable.concat(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4));
    }

    public static final <T> Single<T> from(Future<? extends T> future, Scheduler scheduler) {
        return new Single(OnSubscribeToObservableFuture.toObservableFuture(future)).subscribeOn(scheduler);
    }

    public static final <T> Observable<T> merge(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3) {
        return Observable.merge(asObservable(single), asObservable(single2), asObservable(single3));
    }

    public static final <T1, T2, T3, T4, R> Single<R> zip(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return just(new Observable[]{asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4)}).lift(new OperatorZip(func4));
    }

    public final Single<T> timeout(long j2, TimeUnit timeUnit, Single<? extends T> single) {
        return timeout(j2, timeUnit, single, Schedulers.computation());
    }

    public static final <T> Observable<T> concat(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5) {
        return Observable.concat(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5));
    }

    public static final <T> Observable<T> merge(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4) {
        return Observable.merge(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4));
    }

    public static final <T1, T2, T3, T4, T5, R> Single<R> zip(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return just(new Observable[]{asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5)}).lift(new OperatorZip(func5));
    }

    public final Subscription subscribe(final Action1<? super T> action1, final Action1<Throwable> action12) {
        if (action1 != null) {
            if (action12 != null) {
                return subscribe(new Subscriber<T>() { // from class: rx.Single.9
                    @Override // rx.Observer
                    public final void onCompleted() {
                    }

                    @Override // rx.Observer
                    public final void onError(Throwable th) {
                        action12.call(th);
                    }

                    @Override // rx.Observer
                    public final void onNext(T t) {
                        action1.call(t);
                    }
                });
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    public final Single<T> timeout(long j2, TimeUnit timeUnit, Single<? extends T> single, Scheduler scheduler) {
        if (single == null) {
            single = error(new TimeoutException());
        }
        return (Single<T>) lift(new OperatorTimeout(j2, timeUnit, asObservable(single), scheduler));
    }

    public static final <T> Observable<T> concat(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6) {
        return Observable.concat(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6));
    }

    public static final <T> Observable<T> merge(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5) {
        return Observable.merge(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5));
    }

    public static final <T1, T2, T3, T4, T5, T6, R> Single<R> zip(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Single<? extends T6> single6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return just(new Observable[]{asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6)}).lift(new OperatorZip(func6));
    }

    public static final <T> Observable<T> concat(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7) {
        return Observable.concat(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7));
    }

    public static final <T> Observable<T> merge(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6) {
        return Observable.merge(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Single<? extends T6> single6, Single<? extends T7> single7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return just(new Observable[]{asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7)}).lift(new OperatorZip(func7));
    }

    public static final <T> Observable<T> concat(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7, Single<? extends T> single8) {
        return Observable.concat(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7), asObservable(single8));
    }

    public static final <T> Observable<T> merge(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7) {
        return Observable.merge(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Single<? extends T6> single6, Single<? extends T7> single7, Single<? extends T8> single8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return just(new Observable[]{asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7), asObservable(single8)}).lift(new OperatorZip(func8));
    }

    public final Subscription subscribe(Subscriber<? super T> subscriber) {
        if (subscriber != null) {
            if (this.onSubscribe != null) {
                subscriber.onStart();
                if (!(subscriber instanceof SafeSubscriber)) {
                    subscriber = new SafeSubscriber(subscriber);
                }
                try {
                    this.onSubscribe.call(subscriber);
                    return hook.onSubscribeReturn(subscriber);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    try {
                        subscriber.onError(hook.onSubscribeError(th));
                        return Subscriptions.empty();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        hook.onSubscribeError(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        throw new IllegalArgumentException("observer can not be null");
    }

    public static final <T> Observable<T> concat(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7, Single<? extends T> single8, Single<? extends T> single9) {
        return Observable.concat(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7), asObservable(single8), asObservable(single9));
    }

    public static final <T> Observable<T> merge(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7, Single<? extends T> single8) {
        return Observable.merge(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7), asObservable(single8));
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Single<? extends T6> single6, Single<? extends T7> single7, Single<? extends T8> single8, Single<? extends T9> single9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return just(new Observable[]{asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7), asObservable(single8), asObservable(single9)}).lift(new OperatorZip(func9));
    }

    public static final <T> Observable<T> merge(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7, Single<? extends T> single8, Single<? extends T> single9) {
        return Observable.merge(asObservable(single), asObservable(single2), asObservable(single3), asObservable(single4), asObservable(single5), asObservable(single6), asObservable(single7), asObservable(single8), asObservable(single9));
    }

    public final Subscription subscribe(final SingleSubscriber<? super T> singleSubscriber) {
        Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.Single.10
            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                singleSubscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                singleSubscriber.onSuccess(t);
            }
        };
        singleSubscriber.add(subscriber);
        subscribe(subscriber);
        return subscriber;
    }
}
