package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;
/* loaded from: classes3.dex */
public class TestScheduler extends Scheduler {
    private static long counter;
    private final Queue<TimedAction> queue = new PriorityQueue(11, new CompareActionsByTime());
    private long time;

    /* loaded from: classes3.dex */
    private static class CompareActionsByTime implements Comparator<TimedAction> {
        private CompareActionsByTime() {
        }

        @Override // java.util.Comparator
        public int compare(TimedAction timedAction, TimedAction timedAction2) {
            if (timedAction.time == timedAction2.time) {
                if (timedAction.count < timedAction2.count) {
                    return -1;
                }
                return timedAction.count > timedAction2.count ? 1 : 0;
            } else if (timedAction.time < timedAction2.time) {
                return -1;
            } else {
                return timedAction.time > timedAction2.time ? 1 : 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class TimedAction {
        private final Action0 action;
        private final long count;
        private final Scheduler.Worker scheduler;
        private final long time;

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.time), this.action.toString());
        }

        private TimedAction(Scheduler.Worker worker, long j2, Action0 action0) {
            this.count = TestScheduler.access$108();
            this.time = j2;
            this.action = action0;
            this.scheduler = worker;
        }
    }

    static /* synthetic */ long access$108() {
        long j2 = counter;
        counter = 1 + j2;
        return j2;
    }

    public void advanceTimeBy(long j2, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j2, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j2));
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new InnerTestScheduler();
    }

    @Override // rx.Scheduler
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.time);
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long j2) {
        while (!this.queue.isEmpty()) {
            TimedAction peek = this.queue.peek();
            if (peek.time > j2) {
                break;
            }
            this.time = peek.time == 0 ? this.time : peek.time;
            this.queue.remove();
            if (!peek.scheduler.isUnsubscribed()) {
                peek.action.call();
            }
        }
        this.time = j2;
    }

    /* loaded from: classes3.dex */
    private final class InnerTestScheduler extends Scheduler.Worker {
        private final BooleanSubscription s;

        private InnerTestScheduler() {
            this.s = new BooleanSubscription();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public long now() {
            return TestScheduler.this.now();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j2, TimeUnit timeUnit) {
            final TimedAction timedAction = new TimedAction(this, TestScheduler.this.time + timeUnit.toNanos(j2), action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() { // from class: rx.schedulers.TestScheduler.InnerTestScheduler.1
                @Override // rx.functions.Action0
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.s.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            final TimedAction timedAction = new TimedAction(this, 0L, action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() { // from class: rx.schedulers.TestScheduler.InnerTestScheduler.2
                @Override // rx.functions.Action0
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }
    }
}
