package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
/* loaded from: classes3.dex */
public final class OperatorMapPair<T, U, R> implements Observable.Operator<Observable<? extends R>, T> {
    final Func1<? super T, ? extends Observable<? extends U>> collectionSelector;
    final Func2<? super T, ? super U, ? extends R> resultSelector;

    public OperatorMapPair(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        this.collectionSelector = func1;
        this.resultSelector = func2;
    }

    public static <T, U> Func1<T, Observable<U>> convertSelector(final Func1<? super T, ? extends Iterable<? extends U>> func1) {
        return new Func1<T, Observable<U>>() { // from class: rx.internal.operators.OperatorMapPair.1
            @Override // rx.functions.Func1
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((AnonymousClass1) obj);
            }

            @Override // rx.functions.Func1
            public Observable<U> call(T t) {
                return Observable.from((Iterable) Func1.this.call(t));
            }
        };
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(final Subscriber<? super Observable<? extends R>> subscriber) {
        return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorMapPair.2
            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(final T t) {
                try {
                    subscriber.onNext(OperatorMapPair.this.collectionSelector.call(t).map(new Func1<U, R>() { // from class: rx.internal.operators.OperatorMapPair.2.1
                        @Override // rx.functions.Func1
                        public R call(U u) {
                            return OperatorMapPair.this.resultSelector.call((Object) t, u);
                        }
                    }));
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber, t);
                }
            }
        };
    }
}
