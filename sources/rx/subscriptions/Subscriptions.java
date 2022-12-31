package rx.subscriptions;

import java.util.concurrent.Future;
import rx.Subscription;
import rx.functions.Action0;
/* loaded from: classes3.dex */
public final class Subscriptions {
    private static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();

    /* loaded from: classes3.dex */
    private static final class FutureSubscription implements Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Future<?> f8989f;

        public FutureSubscription(Future<?> future) {
            this.f8989f = future;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f8989f.isCancelled();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.f8989f.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Unsubscribed implements Subscription {
        private Unsubscribed() {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    }

    private Subscriptions() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription create(Action0 action0) {
        return BooleanSubscription.create(action0);
    }

    public static Subscription empty() {
        return BooleanSubscription.create();
    }

    public static Subscription from(Future<?> future) {
        return new FutureSubscription(future);
    }

    public static Subscription unsubscribed() {
        return UNSUBSCRIBED;
    }

    public static CompositeSubscription from(Subscription... subscriptionArr) {
        return new CompositeSubscription(subscriptionArr);
    }
}
