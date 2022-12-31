package rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
/* loaded from: classes3.dex */
public final class AndroidSchedulers {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MainThreadSchedulerHolder {
        static final Scheduler MAIN_THREAD_SCHEDULER = new HandlerScheduler(new Handler(Looper.getMainLooper()));

        private MainThreadSchedulerHolder() {
        }
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances");
    }

    public static Scheduler mainThread() {
        Scheduler mainThreadScheduler = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
        return mainThreadScheduler != null ? mainThreadScheduler : MainThreadSchedulerHolder.MAIN_THREAD_SCHEDULER;
    }
}
