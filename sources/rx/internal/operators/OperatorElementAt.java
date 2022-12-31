package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
/* loaded from: classes3.dex */
public final class OperatorElementAt<T> implements Observable.Operator<T, T> {
    private final T defaultValue;
    private final boolean hasDefault;
    private final int index;

    /* loaded from: classes3.dex */
    static class InnerProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 1;
        final Producer actual;

        public InnerProducer(Producer producer) {
            this.actual = producer;
        }

        @Override // rx.Producer
        public void request(long j2) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 >= 0) {
                if (i2 <= 0 || !compareAndSet(false, true)) {
                    return;
                }
                this.actual.request(LocationRequestCompat.PASSIVE_INTERVAL);
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }

    public OperatorElementAt(int i2) {
        this(i2, null, false);
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorElementAt(int i2, T t) {
        this(i2, t, true);
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        Subscriber subscriber2 = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorElementAt.1
            private int currentIndex = 0;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onCompleted() {
                if (this.currentIndex <= OperatorElementAt.this.index) {
                    if (OperatorElementAt.this.hasDefault) {
                        subscriber.onNext(OperatorElementAt.this.defaultValue);
                        subscriber.onCompleted();
                        return;
                    }
                    Subscriber subscriber3 = subscriber;
                    subscriber3.onError(new IndexOutOfBoundsException(OperatorElementAt.this.index + " is out of bounds"));
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                int i2 = this.currentIndex;
                this.currentIndex = i2 + 1;
                if (i2 == OperatorElementAt.this.index) {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                    unsubscribe();
                }
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                subscriber.setProducer(new InnerProducer(producer));
            }
        };
        subscriber.add(subscriber2);
        return subscriber2;
    }

    private OperatorElementAt(int i2, T t, boolean z) {
        if (i2 >= 0) {
            this.index = i2;
            this.defaultValue = t;
            this.hasDefault = z;
            return;
        }
        throw new IndexOutOfBoundsException(i2 + " is out of bounds");
    }
}
