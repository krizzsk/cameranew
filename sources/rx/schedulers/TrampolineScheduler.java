package rx.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;
/* loaded from: classes3.dex */
public final class TrampolineScheduler extends Scheduler {
    private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    /* loaded from: classes3.dex */
    private static class InnerCurrentThreadScheduler extends Scheduler.Worker implements Subscription {
        final AtomicInteger counter;
        private final BooleanSubscription innerSubscription;
        private final PriorityBlockingQueue<TimedAction> queue;
        private final AtomicInteger wip;

        private InnerCurrentThreadScheduler() {
            this.counter = new AtomicInteger();
            this.queue = new PriorityBlockingQueue<>();
            this.innerSubscription = new BooleanSubscription();
            this.wip = new AtomicInteger();
        }

        private Subscription enqueue(Action0 action0, long j2) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            final TimedAction timedAction = new TimedAction(action0, Long.valueOf(j2), this.counter.incrementAndGet());
            this.queue.add(timedAction);
            if (this.wip.getAndIncrement() == 0) {
                do {
                    TimedAction poll = this.queue.poll();
                    if (poll != null) {
                        poll.action.call();
                    }
                } while (this.wip.decrementAndGet() > 0);
                return Subscriptions.unsubscribed();
            }
            return Subscriptions.create(new Action0() { // from class: rx.schedulers.TrampolineScheduler.InnerCurrentThreadScheduler.1
                @Override // rx.functions.Action0
                public void call() {
                    InnerCurrentThreadScheduler.this.queue.remove(timedAction);
                }
            });
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return enqueue(action0, now());
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j2, TimeUnit timeUnit) {
            long now = now() + timeUnit.toMillis(j2);
            return enqueue(new SleepingAction(action0, this, now), now);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class TimedAction implements Comparable<TimedAction> {
        final Action0 action;
        final int count;
        final Long execTime;

        private TimedAction(Action0 action0, Long l2, int i2) {
            this.action = action0;
            this.execTime = l2;
            this.count = i2;
        }

        @Override // java.lang.Comparable
        public int compareTo(TimedAction timedAction) {
            int compareTo = this.execTime.compareTo(timedAction.execTime);
            return compareTo == 0 ? TrampolineScheduler.compare(this.count, timedAction.count) : compareTo;
        }
    }

    TrampolineScheduler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compare(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TrampolineScheduler instance() {
        return INSTANCE;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new InnerCurrentThreadScheduler();
    }
}
