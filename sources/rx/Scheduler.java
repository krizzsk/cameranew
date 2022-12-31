package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.subscriptions.MultipleAssignmentSubscription;
/* loaded from: classes3.dex */
public abstract class Scheduler {

    /* loaded from: classes3.dex */
    public static abstract class Worker implements Subscription {
        public long now() {
            return System.currentTimeMillis();
        }

        public abstract Subscription schedule(Action0 action0);

        public abstract Subscription schedule(Action0 action0, long j2, TimeUnit timeUnit);

        public Subscription schedulePeriodically(final Action0 action0, long j2, long j3, TimeUnit timeUnit) {
            final long nanos = timeUnit.toNanos(j3);
            final long nanos2 = TimeUnit.MILLISECONDS.toNanos(now()) + timeUnit.toNanos(j2);
            final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            Action0 action02 = new Action0() { // from class: rx.Scheduler.Worker.1
                long count = 0;

                @Override // rx.functions.Action0
                public void call() {
                    if (multipleAssignmentSubscription.isUnsubscribed()) {
                        return;
                    }
                    action0.call();
                    long j4 = nanos2;
                    long j5 = this.count + 1;
                    this.count = j5;
                    long j6 = j4 + (j5 * nanos);
                    MultipleAssignmentSubscription multipleAssignmentSubscription2 = multipleAssignmentSubscription;
                    Worker worker = Worker.this;
                    multipleAssignmentSubscription2.set(worker.schedule(this, j6 - TimeUnit.MILLISECONDS.toNanos(worker.now()), TimeUnit.NANOSECONDS));
                }
            };
            MultipleAssignmentSubscription multipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
            multipleAssignmentSubscription.set(multipleAssignmentSubscription2);
            multipleAssignmentSubscription2.set(schedule(action02, j2, timeUnit));
            return multipleAssignmentSubscription;
        }
    }

    public abstract Worker createWorker();

    public long now() {
        return System.currentTimeMillis();
    }
}
