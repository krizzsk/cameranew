package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
/* loaded from: classes3.dex */
public class OperatorIgnoreElements<T> implements Observable.Operator<T, T> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Holder {
        static final OperatorIgnoreElements<?> INSTANCE = new OperatorIgnoreElements<>();

        private Holder() {
        }
    }

    public static <T> OperatorIgnoreElements<T> instance() {
        return (OperatorIgnoreElements<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    private OperatorIgnoreElements() {
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        Subscriber subscriber2 = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorIgnoreElements.1
            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
            }
        };
        subscriber.add(subscriber2);
        return subscriber2;
    }
}
