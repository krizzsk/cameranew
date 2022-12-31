package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes3.dex */
public final class GenericScheduledExecutorService implements SchedulerLifecycle {
    static final ScheduledExecutorService NONE;
    private final AtomicReference<ScheduledExecutorService> executor = new AtomicReference<>(NONE);
    private static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
    private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);
    public static final GenericScheduledExecutorService INSTANCE = new GenericScheduledExecutorService();

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        NONE = newScheduledThreadPool;
        newScheduledThreadPool.shutdownNow();
    }

    private GenericScheduledExecutorService() {
        start();
    }

    public static ScheduledExecutorService getInstance() {
        return INSTANCE.executor.get();
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2;
        do {
            scheduledExecutorService = this.executor.get();
            scheduledExecutorService2 = NONE;
            if (scheduledExecutorService == scheduledExecutorService2) {
                return;
            }
        } while (!this.executor.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
        NewThreadWorker.deregisterExecutor(scheduledExecutorService);
        scheduledExecutorService.shutdownNow();
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(availableProcessors, THREAD_FACTORY);
        if (this.executor.compareAndSet(NONE, newScheduledThreadPool)) {
            if (NewThreadWorker.tryEnableCancelPolicy(newScheduledThreadPool) || !(newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
                return;
            }
            NewThreadWorker.registerExecutor((ScheduledThreadPoolExecutor) newScheduledThreadPool);
            return;
        }
        newScheduledThreadPool.shutdownNow();
    }
}
