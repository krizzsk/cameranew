package us.pinguo.common.pgdownloader.download;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import j.a.f.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.bigdata.config.BDConfig;
import us.pinguo.common.log.a;
import us.pinguo.common.pgdownloader.config.DefaultConfig;
import us.pinguo.common.pgdownloader.config.DownloadConfig;
import us.pinguo.common.pgdownloader.core.DispatchHandler;
import us.pinguo.common.pgdownloader.core.DynamicBlockingDeque;
import us.pinguo.common.pgdownloader.util.FileDownloadUtils;
/* compiled from: PGDownloadManger.kt */
/* loaded from: classes4.dex */
public final class PGDownloadManger {
    public static final int MAX_TASK_SIZE = 3;
    private Application application;
    private final ExecutorService blockExecutor;
    private final Handler dispatchHandler;
    private final HandlerThread dispatchThread;
    private final DynamicBlockingDeque<Runnable> taskDeque;
    private final ThreadPoolExecutor taskExecutor;
    private final HashMap<Integer, DownloadTask> taskMaps;
    public static final Companion Companion = new Companion(null);
    private static DownloadConfig config = new DefaultConfig();

    /* compiled from: PGDownloadManger.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final DownloadConfig getConfig() {
            return PGDownloadManger.config;
        }

        public final PGDownloadManger getInstance() {
            return Inner.INSTANCE.getInstance();
        }

        public final void recreate$pgdownloader2_release() {
            Inner inner = Inner.INSTANCE;
            inner.getInstance().dispatchThread.interrupt();
            inner.getInstance().pauseAll();
            inner.setInstance(new PGDownloadManger(null));
        }

        public final void setConfig(DownloadConfig downloadConfig) {
            s.h(downloadConfig, "<set-?>");
            PGDownloadManger.config = downloadConfig;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PGDownloadManger.kt */
    /* loaded from: classes4.dex */
    public static final class Inner {
        public static final Inner INSTANCE = new Inner();
        private static PGDownloadManger instance = new PGDownloadManger(null);

        private Inner() {
        }

        public final PGDownloadManger getInstance() {
            return instance;
        }

        public final void setInstance(PGDownloadManger pGDownloadManger) {
            s.h(pGDownloadManger, "<set-?>");
            instance = pGDownloadManger;
        }
    }

    private PGDownloadManger() {
        DynamicBlockingDeque<Runnable> dynamicBlockingDeque = new DynamicBlockingDeque<>();
        this.taskDeque = dynamicBlockingDeque;
        this.taskExecutor = new ThreadPoolExecutor(config.parallelTaskCount(), config.parallelTaskCount(), 8L, TimeUnit.SECONDS, dynamicBlockingDeque);
        this.blockExecutor = Executors.newCachedThreadPool();
        this.taskMaps = new HashMap<>();
        HandlerThread handlerThread = new HandlerThread("DispatchThread");
        this.dispatchThread = handlerThread;
        a.d("object_test", "init", new Object[0]);
        handlerThread.start();
        this.dispatchHandler = new DispatchHandler(handlerThread.getLooper());
    }

    public /* synthetic */ PGDownloadManger(o oVar) {
        this();
    }

    public static final PGDownloadManger getInstance() {
        return Companion.getInstance();
    }

    public final IDownloadTask create(String remoteUrl, String path) {
        s.h(remoteUrl, "remoteUrl");
        s.h(path, "path");
        return create(remoteUrl, path, false);
    }

    public final IDownloadTask get(int i2) {
        return this.taskMaps.get(Integer.valueOf(i2));
    }

    public final ExecutorService getBlockExecutor$pgdownloader2_release() {
        return this.blockExecutor;
    }

    public final DynamicBlockingDeque<Runnable> getTaskDeque$pgdownloader2_release() {
        return this.taskDeque;
    }

    public final ThreadPoolExecutor getTaskExecutor$pgdownloader2_release() {
        return this.taskExecutor;
    }

    public final HashMap<Integer, DownloadTask> getTaskMaps$pgdownloader2_release() {
        return this.taskMaps;
    }

    public final void init(Application application, boolean z, boolean z2) {
        s.h(application, "application");
        this.application = application;
        i.a.b(application);
        us.pinguo.bigdata.a.m(z2);
        us.pinguo.bigdata.a.c = z;
        us.pinguo.bigdata.a.g(new BDConfig.Builder(application).setDebug(z).build());
    }

    public final void pause(int i2) {
        DownloadTask downloadTask = this.taskMaps.get(Integer.valueOf(i2));
        if (downloadTask == null) {
            return;
        }
        downloadTask.pause();
    }

    public final void pauseAll() {
        Collection<DownloadTask> values = this.taskMaps.values();
        s.g(values, "taskMaps.values");
        for (DownloadTask downloadTask : values) {
            downloadTask.pause();
        }
    }

    public final void printTasks() {
        a.c("taskCount = %d, activeCount = %d, queueSize = %d", Long.valueOf(this.taskExecutor.getTaskCount()), Integer.valueOf(this.taskExecutor.getActiveCount()), Integer.valueOf(this.taskDeque.size()));
        Collection<DownloadTask> values = this.taskMaps.values();
        s.g(values, "taskMaps.values");
        for (DownloadTask downloadTask : values) {
            a.c("task_%d is %s", Integer.valueOf(downloadTask.getId()), downloadTask.getStatus().toString());
        }
    }

    public final void submit(DownloadTask task) {
        s.h(task, "task");
        Message.obtain(this.dispatchHandler, 2, task).sendToTarget();
    }

    public final void submitToCurrent(DownloadTask task) {
        s.h(task, "task");
        Message.obtain(this.dispatchHandler, 3, task).sendToTarget();
    }

    public final void submitToFirst(DownloadTask task) {
        s.h(task, "task");
        Message.obtain(this.dispatchHandler, 1, task).sendToTarget();
    }

    public final IDownloadTask create(String remoteUrl, String path, boolean z) {
        s.h(remoteUrl, "remoteUrl");
        s.h(path, "path");
        return create(remoteUrl, path, z, 0);
    }

    public final IDownloadTask create(String remoteUrl, String path, boolean z, int i2) {
        s.h(remoteUrl, "remoteUrl");
        s.h(path, "path");
        if (this.application != null) {
            IDownloadTask iDownloadTask = get(FileDownloadUtils.generateId(remoteUrl, path, z));
            if (iDownloadTask == null) {
                a.c("create new task", new Object[0]);
                DownloadTask downloadTask = new DownloadTask(remoteUrl, path, z, i2);
                this.taskMaps.put(Integer.valueOf(downloadTask.getId()), downloadTask);
                return downloadTask;
            }
            return iDownloadTask;
        }
        throw new RuntimeException("please call init method in Application class before create");
    }
}
