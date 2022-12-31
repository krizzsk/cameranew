package rx.android.schedulers;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
/* loaded from: classes3.dex */
public final class AndroidNewSchedulers {

    /* loaded from: classes3.dex */
    private static class ThreadSchedulerHolder {
        static Scheduler HANDLER_THREAD_SCHEDULER = null;
        private static final int MAX_THREAD_SIZE = 6;
        static final Scheduler MAIN_THREAD_SCHEDULER = new HandlerScheduler(new Handler(Looper.getMainLooper()));
        static final Scheduler SIZE_CACHED_THREAD_SCHEDULER = new SizeCachedThreadScheduler(6);

        static {
            HANDLER_THREAD_SCHEDULER = null;
            HandlerThread handlerThread = new HandlerThread("AndroidSchedulers");
            handlerThread.start();
            HANDLER_THREAD_SCHEDULER = new HandlerScheduler(new Handler(handlerThread.getLooper()));
        }

        private ThreadSchedulerHolder() {
        }
    }

    private AndroidNewSchedulers() {
        throw new AssertionError("No instances");
    }

    public static Scheduler handlerThread() {
        return ThreadSchedulerHolder.HANDLER_THREAD_SCHEDULER;
    }

    public static Scheduler mainThread() {
        Scheduler mainThreadScheduler = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
        return mainThreadScheduler != null ? mainThreadScheduler : ThreadSchedulerHolder.MAIN_THREAD_SCHEDULER;
    }

    public static Scheduler sizeIo() {
        return ThreadSchedulerHolder.SIZE_CACHED_THREAD_SCHEDULER;
    }
}
