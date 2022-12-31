package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
/* loaded from: classes3.dex */
public final class OnSubscribeRange implements Observable.OnSubscribe<Integer> {
    private final int end;
    private final int start;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class RangeProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = 4114392207069098388L;
        private final int end;
        private long index;
        private final Subscriber<? super Integer> o;

        void fastpath() {
            long j2 = this.end + 1;
            Subscriber<? super Integer> subscriber = this.o;
            for (long j3 = this.index; j3 != j2; j3++) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onNext(Integer.valueOf((int) j3));
            }
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onCompleted();
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
            long j3 = this.index;
            while (true) {
                long j4 = (this.end - j3) + 1;
                long min = Math.min(j4, j2);
                boolean z = j4 <= j2;
                long j5 = min + j3;
                Subscriber<? super Integer> subscriber = this.o;
                while (j3 != j5) {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onNext(Integer.valueOf((int) j3));
                    j3++;
                }
                if (z) {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onCompleted();
                    return;
                }
                this.index = j5;
                j2 = addAndGet(-min);
                if (j2 == 0) {
                    return;
                }
                j3 = j5;
            }
        }

        private RangeProducer(Subscriber<? super Integer> subscriber, int i2, int i3) {
            this.o = subscriber;
            this.index = i2;
            this.end = i3;
        }
    }

    public OnSubscribeRange(int i2, int i3) {
        this.start = i2;
        this.end = i3;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super Integer> subscriber) {
        subscriber.setProducer(new RangeProducer(subscriber, this.start, this.end));
    }
}
