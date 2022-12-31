package us.pinguo.loc;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;
/* compiled from: LocScheduler.java */
/* loaded from: classes5.dex */
public class u extends Scheduler {
    public static final u b = new u();
    private final NewThreadWorker a = new NewThreadWorker(new RxThreadFactory("LocScheduler"));

    /* compiled from: LocScheduler.java */
    /* loaded from: classes5.dex */
    private static final class b extends Scheduler.Worker {
        final CompositeSubscription a;
        final NewThreadWorker b;

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.a.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return schedule(action0, 0L, null);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.a.unsubscribe();
        }

        private b(NewThreadWorker newThreadWorker) {
            this.b = newThreadWorker;
            this.a = new CompositeSubscription();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j2, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.b.schedule(action0, j2, timeUnit);
        }
    }

    private u() {
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new b(this.a);
    }
}
