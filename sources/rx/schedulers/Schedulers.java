package rx.schedulers;

import java.util.concurrent.Executor;
import rx.Scheduler;
import rx.internal.schedulers.EventLoopsScheduler;
import rx.internal.schedulers.GenericScheduledExecutorService;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.RxRingBuffer;
import rx.plugins.RxJavaPlugins;
/* loaded from: classes3.dex */
public final class Schedulers {
    private static final Schedulers INSTANCE = new Schedulers();
    private final Scheduler computationScheduler;
    private final Scheduler ioScheduler;
    private final Scheduler newThreadScheduler;

    private Schedulers() {
        Scheduler computationScheduler = RxJavaPlugins.getInstance().getSchedulersHook().getComputationScheduler();
        if (computationScheduler != null) {
            this.computationScheduler = computationScheduler;
        } else {
            this.computationScheduler = new EventLoopsScheduler();
        }
        Scheduler iOScheduler = RxJavaPlugins.getInstance().getSchedulersHook().getIOScheduler();
        if (iOScheduler != null) {
            this.ioScheduler = iOScheduler;
        } else {
            this.ioScheduler = new CachedThreadScheduler();
        }
        Scheduler newThreadScheduler = RxJavaPlugins.getInstance().getSchedulersHook().getNewThreadScheduler();
        if (newThreadScheduler != null) {
            this.newThreadScheduler = newThreadScheduler;
        } else {
            this.newThreadScheduler = NewThreadScheduler.instance();
        }
    }

    public static Scheduler computation() {
        return INSTANCE.computationScheduler;
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    public static Scheduler immediate() {
        return ImmediateScheduler.instance();
    }

    public static Scheduler io() {
        return INSTANCE.ioScheduler;
    }

    public static Scheduler newThread() {
        return INSTANCE.newThreadScheduler;
    }

    public static void shutdown() {
        Schedulers schedulers = INSTANCE;
        synchronized (schedulers) {
            Scheduler scheduler = schedulers.computationScheduler;
            if (scheduler instanceof SchedulerLifecycle) {
                ((SchedulerLifecycle) scheduler).shutdown();
            }
            Scheduler scheduler2 = schedulers.ioScheduler;
            if (scheduler2 instanceof SchedulerLifecycle) {
                ((SchedulerLifecycle) scheduler2).shutdown();
            }
            Scheduler scheduler3 = schedulers.newThreadScheduler;
            if (scheduler3 instanceof SchedulerLifecycle) {
                ((SchedulerLifecycle) scheduler3).shutdown();
            }
            GenericScheduledExecutorService.INSTANCE.shutdown();
            RxRingBuffer.SPSC_POOL.shutdown();
            RxRingBuffer.SPMC_POOL.shutdown();
        }
    }

    static void start() {
        Schedulers schedulers = INSTANCE;
        synchronized (schedulers) {
            Scheduler scheduler = schedulers.computationScheduler;
            if (scheduler instanceof SchedulerLifecycle) {
                ((SchedulerLifecycle) scheduler).start();
            }
            Scheduler scheduler2 = schedulers.ioScheduler;
            if (scheduler2 instanceof SchedulerLifecycle) {
                ((SchedulerLifecycle) scheduler2).start();
            }
            Scheduler scheduler3 = schedulers.newThreadScheduler;
            if (scheduler3 instanceof SchedulerLifecycle) {
                ((SchedulerLifecycle) scheduler3).start();
            }
            GenericScheduledExecutorService.INSTANCE.start();
            RxRingBuffer.SPSC_POOL.start();
            RxRingBuffer.SPMC_POOL.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static Scheduler trampoline() {
        return TrampolineScheduler.instance();
    }
}
