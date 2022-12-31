package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayDeque;
import rx.Observable;
import rx.Subscriber;
/* loaded from: classes3.dex */
public final class OperatorTakeLast<T> implements Observable.Operator<T, T> {
    private final int count;

    public OperatorTakeLast(int i2) {
        if (i2 >= 0) {
            this.count = i2;
            return;
        }
        throw new IndexOutOfBoundsException("count cannot be negative");
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final ArrayDeque arrayDeque = new ArrayDeque();
        final NotificationLite instance = NotificationLite.instance();
        final TakeLastQueueProducer takeLastQueueProducer = new TakeLastQueueProducer(instance, arrayDeque, subscriber);
        subscriber.setProducer(takeLastQueueProducer);
        return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorTakeLast.1
            @Override // rx.Observer
            public void onCompleted() {
                arrayDeque.offer(instance.completed());
                takeLastQueueProducer.startEmitting();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                arrayDeque.clear();
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (OperatorTakeLast.this.count == 0) {
                    return;
                }
                if (arrayDeque.size() == OperatorTakeLast.this.count) {
                    arrayDeque.removeFirst();
                }
                arrayDeque.offerLast(instance.next(t));
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        };
    }
}
