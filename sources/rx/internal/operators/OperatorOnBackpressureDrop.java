package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action1;
/* loaded from: classes3.dex */
public class OperatorOnBackpressureDrop<T> implements Observable.Operator<T, T> {
    private final Action1<? super T> onDrop;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Holder {
        static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop<>();

        private Holder() {
        }
    }

    public static <T> OperatorOnBackpressureDrop<T> instance() {
        return (OperatorOnBackpressureDrop<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    private OperatorOnBackpressureDrop() {
        this((Action1) null);
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final AtomicLong atomicLong = new AtomicLong();
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorOnBackpressureDrop.1
            @Override // rx.Producer
            public void request(long j2) {
                BackpressureUtils.getAndAddRequest(atomicLong, j2);
            }
        });
        return (Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorOnBackpressureDrop.2
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
                if (atomicLong.get() <= 0) {
                    if (OperatorOnBackpressureDrop.this.onDrop != null) {
                        OperatorOnBackpressureDrop.this.onDrop.call(t);
                        return;
                    }
                    return;
                }
                subscriber.onNext(t);
                atomicLong.decrementAndGet();
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        };
    }

    public OperatorOnBackpressureDrop(Action1<? super T> action1) {
        this.onDrop = action1;
    }
}
