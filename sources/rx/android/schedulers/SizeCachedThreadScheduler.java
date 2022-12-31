package rx.android.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;
/* loaded from: classes3.dex */
public class SizeCachedThreadScheduler extends Scheduler implements SchedulerLifecycle {
    static final FixedSchedulerPool NONE;
    static final PoolWorker SHUTDOWN_WORKER;
    final AtomicReference<FixedSchedulerPool> pool;
    private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool-";
    static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);
    static int threadSize = 6;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class FixedSchedulerPool {
        final int cores;
        final PoolWorker[] eventLoops;
        long n;

        FixedSchedulerPool(int i2) {
            this.cores = i2;
            this.eventLoops = new PoolWorker[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.eventLoops[i3] = new PoolWorker(SizeCachedThreadScheduler.THREAD_FACTORY);
            }
        }

        public PoolWorker getEventLoop() {
            int i2 = this.cores;
            if (i2 == 0) {
                return SizeCachedThreadScheduler.SHUTDOWN_WORKER;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j2 = this.n;
            this.n = 1 + j2;
            return poolWorkerArr[(int) (j2 % i2)];
        }

        public void shutdown() {
            for (PoolWorker poolWorker : this.eventLoops) {
                poolWorker.unsubscribe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown-"));
        SHUTDOWN_WORKER = poolWorker;
        poolWorker.unsubscribe();
        NONE = new FixedSchedulerPool(0);
    }

    public SizeCachedThreadScheduler(int i2) {
        threadSize = i2;
        this.pool = new AtomicReference<>(NONE);
        start();
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    public Subscription scheduleDirect(Action0 action0) {
        return this.pool.get().getEventLoop().scheduleActual(action0, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.pool.get();
            fixedSchedulerPool2 = NONE;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!this.pool.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.shutdown();
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(threadSize);
        if (this.pool.compareAndSet(NONE, fixedSchedulerPool)) {
            return;
        }
        fixedSchedulerPool.shutdown();
    }

    /* loaded from: classes3.dex */
    private static class EventLoopWorker extends Scheduler.Worker {
        private final SubscriptionList both;
        private final PoolWorker poolWorker;
        private final SubscriptionList serial;
        private final CompositeSubscription timed;

        EventLoopWorker(PoolWorker poolWorker) {
            SubscriptionList subscriptionList = new SubscriptionList();
            this.serial = subscriptionList;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.timed = compositeSubscription;
            this.both = new SubscriptionList(subscriptionList, compositeSubscription);
            this.poolWorker = poolWorker;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.both.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual(action0, 0L, (TimeUnit) null, this.serial);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.both.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j2, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual(action0, j2, timeUnit, this.timed);
        }
    }
}
