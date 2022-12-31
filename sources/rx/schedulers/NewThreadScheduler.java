package rx.schedulers;

import rx.Scheduler;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes3.dex */
public final class NewThreadScheduler extends Scheduler {
    private static final String THREAD_NAME_PREFIX = "RxNewThreadScheduler-";
    private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);
    private static final NewThreadScheduler INSTANCE = new NewThreadScheduler();

    private NewThreadScheduler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NewThreadScheduler instance() {
        return INSTANCE;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(THREAD_FACTORY);
    }
}
