package rx;

import androidx.core.location.LocationRequestCompat;
import rx.internal.util.SubscriptionList;
/* loaded from: classes3.dex */
public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final Long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    /* JADX INFO: Access modifiers changed from: protected */
    public Subscriber() {
        this(null, false);
    }

    private void addToRequested(long j2) {
        if (this.requested == NOT_SET.longValue()) {
            this.requested = j2;
            return;
        }
        long j3 = this.requested + j2;
        if (j3 < 0) {
            this.requested = LocationRequestCompat.PASSIVE_INTERVAL;
        } else {
            this.requested = j3;
        }
    }

    public final void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void request(long j2) {
        if (j2 >= 0) {
            synchronized (this) {
                Producer producer = this.producer;
                if (producer != null) {
                    producer.request(j2);
                    return;
                } else {
                    addToRequested(j2);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("number requested cannot be negative: " + j2);
    }

    public void setProducer(Producer producer) {
        long j2;
        boolean z;
        synchronized (this) {
            j2 = this.requested;
            this.producer = producer;
            z = this.subscriber != null && j2 == NOT_SET.longValue();
        }
        if (z) {
            this.subscriber.setProducer(this.producer);
        } else if (j2 == NOT_SET.longValue()) {
            this.producer.request(LocationRequestCompat.PASSIVE_INTERVAL);
        } else {
            this.producer.request(j2);
        }
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Subscriber(Subscriber<?> subscriber) {
        this(subscriber, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Subscriber(Subscriber<?> subscriber, boolean z) {
        this.requested = NOT_SET.longValue();
        this.subscriber = subscriber;
        this.subscriptions = (!z || subscriber == null) ? new SubscriptionList() : subscriber.subscriptions;
    }
}
