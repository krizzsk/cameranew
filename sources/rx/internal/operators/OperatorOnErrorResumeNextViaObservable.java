package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaPlugins;
/* loaded from: classes3.dex */
public final class OperatorOnErrorResumeNextViaObservable<T> implements Observable.Operator<T, T> {
    final Observable<? extends T> resumeSequence;

    public OperatorOnErrorResumeNextViaObservable(Observable<? extends T> observable) {
        this.resumeSequence = observable;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        Subscriber subscriber2 = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaObservable.1
            private boolean done = false;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (this.done) {
                    Exceptions.throwIfFatal(th);
                    return;
                }
                this.done = true;
                RxJavaPlugins.getInstance().getErrorHandler().handleError(th);
                unsubscribe();
                OperatorOnErrorResumeNextViaObservable.this.resumeSequence.unsafeSubscribe(subscriber);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (this.done) {
                    return;
                }
                subscriber.onNext(t);
            }

            @Override // rx.Subscriber
            public void setProducer(final Producer producer) {
                subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaObservable.1.1
                    @Override // rx.Producer
                    public void request(long j2) {
                        producer.request(j2);
                    }
                });
            }
        };
        subscriber.add(subscriber2);
        return subscriber2;
    }
}
