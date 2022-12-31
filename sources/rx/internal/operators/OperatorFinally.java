package rx.internal.operators;

import java.util.Objects;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
/* loaded from: classes3.dex */
public final class OperatorFinally<T> implements Observable.Operator<T, T> {
    final Action0 action;

    public OperatorFinally(Action0 action0) {
        Objects.requireNonNull(action0, "Action can not be null");
        this.action = action0;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorFinally.1
            @Override // rx.Observer
            public void onCompleted() {
                try {
                    subscriber.onCompleted();
                } finally {
                    OperatorFinally.this.action.call();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                try {
                    subscriber.onError(th);
                } finally {
                    OperatorFinally.this.action.call();
                }
            }

            @Override // rx.Observer
            public void onNext(T t) {
                subscriber.onNext(t);
            }
        };
    }
}
