package rx.internal.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.functions.Action0;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.unsafe.MpmcArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public abstract class ObjectPool<T> implements SchedulerLifecycle {
    private final int maxSize;
    private final int minSize;
    private Queue<T> pool;
    private final AtomicReference<Scheduler.Worker> schedulerWorker;
    private final long validationInterval;

    public ObjectPool() {
        this(0, 0, 67L);
    }

    private void initialize(int i2) {
        if (UnsafeAccess.isUnsafeAvailable()) {
            this.pool = new MpmcArrayQueue(Math.max(this.maxSize, 1024));
        } else {
            this.pool = new ConcurrentLinkedQueue();
        }
        for (int i3 = 0; i3 < i2; i3++) {
            this.pool.add(createObject());
        }
    }

    public T borrowObject() {
        T poll = this.pool.poll();
        return poll == null ? createObject() : poll;
    }

    protected abstract T createObject();

    public void returnObject(T t) {
        if (t == null) {
            return;
        }
        this.pool.offer(t);
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        Scheduler.Worker andSet = this.schedulerWorker.getAndSet(null);
        if (andSet != null) {
            andSet.unsubscribe();
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        Scheduler.Worker createWorker = Schedulers.computation().createWorker();
        if (this.schedulerWorker.compareAndSet(null, createWorker)) {
            Action0 action0 = new Action0() { // from class: rx.internal.util.ObjectPool.1
                @Override // rx.functions.Action0
                public void call() {
                    int size = ObjectPool.this.pool.size();
                    int i2 = 0;
                    if (size < ObjectPool.this.minSize) {
                        int i3 = ObjectPool.this.maxSize - size;
                        while (i2 < i3) {
                            ObjectPool.this.pool.add(ObjectPool.this.createObject());
                            i2++;
                        }
                    } else if (size > ObjectPool.this.maxSize) {
                        int i4 = size - ObjectPool.this.maxSize;
                        while (i2 < i4) {
                            ObjectPool.this.pool.poll();
                            i2++;
                        }
                    }
                }
            };
            long j2 = this.validationInterval;
            createWorker.schedulePeriodically(action0, j2, j2, TimeUnit.SECONDS);
            return;
        }
        createWorker.unsubscribe();
    }

    private ObjectPool(int i2, int i3, long j2) {
        this.minSize = i2;
        this.maxSize = i3;
        this.validationInterval = j2;
        this.schedulerWorker = new AtomicReference<>();
        initialize(i2);
        start();
    }
}
