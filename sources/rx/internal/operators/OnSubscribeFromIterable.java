package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
/* loaded from: classes3.dex */
public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends T> is;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final Subscriber<? super T> o;

        void fastpath() {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it = this.it;
            while (!subscriber.isUnsubscribed()) {
                if (it.hasNext()) {
                    subscriber.onNext((T) it.next());
                } else if (subscriber.isUnsubscribed()) {
                    return;
                } else {
                    subscriber.onCompleted();
                    return;
                }
            }
        }

        @Override // rx.Producer
        public void request(long j2) {
            if (get() == LocationRequestCompat.PASSIVE_INTERVAL) {
                return;
            }
            if (j2 == LocationRequestCompat.PASSIVE_INTERVAL && compareAndSet(0L, LocationRequestCompat.PASSIVE_INTERVAL)) {
                fastpath();
            } else if (j2 <= 0 || BackpressureUtils.getAndAddRequest(this, j2) != 0) {
            } else {
                slowpath(j2);
            }
        }

        void slowpath(long j2) {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j3 = j2;
                while (!subscriber.isUnsubscribed()) {
                    if (!it.hasNext()) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onCompleted();
                        return;
                    }
                    j3--;
                    if (j3 >= 0) {
                        subscriber.onNext((T) it.next());
                    } else {
                        j2 = addAndGet(-j2);
                    }
                }
                return;
            } while (j2 != 0);
        }

        private IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.o = subscriber;
            this.it = it;
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "iterable must not be null");
        this.is = iterable;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        Iterator<? extends T> it = this.is.iterator();
        if (!it.hasNext() && !subscriber.isUnsubscribed()) {
            subscriber.onCompleted();
        } else {
            subscriber.setProducer(new IterableProducer(subscriber, it));
        }
    }
}
