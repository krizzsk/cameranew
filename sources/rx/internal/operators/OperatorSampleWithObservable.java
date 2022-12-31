package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
/* loaded from: classes3.dex */
public final class OperatorSampleWithObservable<T, U> implements Observable.Operator<T, T> {
    static final Object EMPTY_TOKEN = new Object();
    final Observable<U> sampler;

    public OperatorSampleWithObservable(Observable<U> observable) {
        this.sampler = observable;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final AtomicReference atomicReference = new AtomicReference(EMPTY_TOKEN);
        Subscriber<U> subscriber2 = new Subscriber<U>(subscriber) { // from class: rx.internal.operators.OperatorSampleWithObservable.1
            @Override // rx.Observer
            public void onCompleted() {
                serializedSubscriber.onCompleted();
                unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                unsubscribe();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(U u) {
                AtomicReference atomicReference2 = atomicReference;
                Object obj = OperatorSampleWithObservable.EMPTY_TOKEN;
                Object andSet = atomicReference2.getAndSet(obj);
                if (andSet != obj) {
                    serializedSubscriber.onNext(andSet);
                }
            }
        };
        Subscriber subscriber3 = (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorSampleWithObservable.2
            @Override // rx.Observer
            public void onCompleted() {
                serializedSubscriber.onCompleted();
                unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(T t) {
                atomicReference.set(t);
            }
        };
        this.sampler.unsafeSubscribe(subscriber2);
        return subscriber3;
    }
}
