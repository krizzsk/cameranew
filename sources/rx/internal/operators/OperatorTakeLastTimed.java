package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
/* loaded from: classes3.dex */
public final class OperatorTakeLastTimed<T> implements Observable.Operator<T, T> {
    private final long ageMillis;
    private final int count;
    private final Scheduler scheduler;

    public OperatorTakeLastTimed(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.ageMillis = timeUnit.toMillis(j2);
        this.scheduler = scheduler;
        this.count = -1;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final ArrayDeque arrayDeque = new ArrayDeque();
        final ArrayDeque arrayDeque2 = new ArrayDeque();
        final NotificationLite instance = NotificationLite.instance();
        final TakeLastQueueProducer takeLastQueueProducer = new TakeLastQueueProducer(instance, arrayDeque, subscriber);
        subscriber.setProducer(takeLastQueueProducer);
        return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorTakeLastTimed.1
            @Override // rx.Observer
            public void onCompleted() {
                runEvictionPolicy(OperatorTakeLastTimed.this.scheduler.now());
                arrayDeque2.clear();
                arrayDeque.offer(instance.completed());
                takeLastQueueProducer.startEmitting();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                arrayDeque2.clear();
                arrayDeque.clear();
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                long now = OperatorTakeLastTimed.this.scheduler.now();
                arrayDeque2.add(Long.valueOf(now));
                arrayDeque.add(instance.next(t));
                runEvictionPolicy(now);
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(LocationRequestCompat.PASSIVE_INTERVAL);
            }

            protected void runEvictionPolicy(long j2) {
                while (OperatorTakeLastTimed.this.count >= 0 && arrayDeque.size() > OperatorTakeLastTimed.this.count) {
                    arrayDeque2.pollFirst();
                    arrayDeque.pollFirst();
                }
                while (!arrayDeque.isEmpty() && ((Long) arrayDeque2.peekFirst()).longValue() < j2 - OperatorTakeLastTimed.this.ageMillis) {
                    arrayDeque2.pollFirst();
                    arrayDeque.pollFirst();
                }
            }
        };
    }

    public OperatorTakeLastTimed(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        if (i2 >= 0) {
            this.ageMillis = timeUnit.toMillis(j2);
            this.scheduler = scheduler;
            this.count = i2;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
