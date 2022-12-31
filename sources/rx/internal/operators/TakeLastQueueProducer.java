package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
/* loaded from: classes3.dex */
final class TakeLastQueueProducer<T> extends AtomicLong implements Producer {
    private final Deque<Object> deque;
    private volatile boolean emittingStarted = false;
    private final NotificationLite<T> notification;
    private final Subscriber<? super T> subscriber;

    public TakeLastQueueProducer(NotificationLite<T> notificationLite, Deque<Object> deque, Subscriber<? super T> subscriber) {
        this.notification = notificationLite;
        this.deque = deque;
        this.subscriber = subscriber;
    }

    void emit(long j2) {
        Object poll;
        if (get() == LocationRequestCompat.PASSIVE_INTERVAL) {
            if (j2 == 0) {
                try {
                    for (Object obj : this.deque) {
                        if (this.subscriber.isUnsubscribed()) {
                            return;
                        }
                        this.notification.accept(this.subscriber, obj);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        } else if (j2 == 0) {
            while (true) {
                long j3 = get();
                int i2 = 0;
                while (true) {
                    j3--;
                    if (j3 < 0 || (poll = this.deque.poll()) == null) {
                        break;
                    } else if (this.subscriber.isUnsubscribed() || this.notification.accept(this.subscriber, poll)) {
                        return;
                    } else {
                        i2++;
                    }
                }
                while (true) {
                    long j4 = get();
                    long j5 = j4 - i2;
                    if (j4 != LocationRequestCompat.PASSIVE_INTERVAL) {
                        if (compareAndSet(j4, j5)) {
                            if (j5 == 0) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // rx.Producer
    public void request(long j2) {
        long andAddRequest;
        if (get() == LocationRequestCompat.PASSIVE_INTERVAL) {
            return;
        }
        if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
            andAddRequest = getAndSet(LocationRequestCompat.PASSIVE_INTERVAL);
        } else {
            andAddRequest = BackpressureUtils.getAndAddRequest(this, j2);
        }
        if (this.emittingStarted) {
            emit(andAddRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startEmitting() {
        if (this.emittingStarted) {
            return;
        }
        this.emittingStarted = true;
        emit(0L);
    }
}
