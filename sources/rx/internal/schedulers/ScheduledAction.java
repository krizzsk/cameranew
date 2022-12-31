package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;
/* loaded from: classes3.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    private static final long serialVersionUID = -3962399486978279857L;
    final Action0 action;
    final SubscriptionList cancel;

    /* loaded from: classes3.dex */
    private final class FutureCompleter implements Subscription {

        /* renamed from: f  reason: collision with root package name */
        private final Future<?> f8988f;

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f8988f.isCancelled();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f8988f.cancel(true);
            } else {
                this.f8988f.cancel(false);
            }
        }

        private FutureCompleter(Future<?> future) {
            this.f8988f = future;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Remover extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        final CompositeSubscription parent;
        final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, CompositeSubscription compositeSubscription) {
            this.s = scheduledAction;
            this.parent = compositeSubscription;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this.s);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static final class Remover2 extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        final SubscriptionList parent;
        final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, SubscriptionList subscriptionList) {
            this.s = scheduledAction;
            this.parent = subscriptionList;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this.s);
            }
        }
    }

    public ScheduledAction(Action0 action0) {
        this.action = action0;
        this.cancel = new SubscriptionList();
    }

    public void add(Subscription subscription) {
        this.cancel.add(subscription);
    }

    public void addParent(CompositeSubscription compositeSubscription) {
        this.cancel.add(new Remover(this, compositeSubscription));
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            lazySet(Thread.currentThread());
            this.action.call();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.cancel.isUnsubscribed()) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public void add(Future<?> future) {
        this.cancel.add(new FutureCompleter(future));
    }

    public void addParent(SubscriptionList subscriptionList) {
        this.cancel.add(new Remover2(this, subscriptionList));
    }

    public ScheduledAction(Action0 action0, CompositeSubscription compositeSubscription) {
        this.action = action0;
        this.cancel = new SubscriptionList(new Remover(this, compositeSubscription));
    }

    public ScheduledAction(Action0 action0, SubscriptionList subscriptionList) {
        this.action = action0;
        this.cancel = new SubscriptionList(new Remover2(this, subscriptionList));
    }
}
