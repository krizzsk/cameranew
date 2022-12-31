package us.pinguo.common.pgdownloader.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.common.log.a;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.DownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.common.pgdownloader.download.Status;
import us.pinguo.common.pgdownloader.exception.ErrorCode;
import us.pinguo.common.pgdownloader.util.FileDownloadUtils;
/* compiled from: DispatchHandler.kt */
/* loaded from: classes4.dex */
public final class DispatchHandler extends Handler {
    public static final Companion Companion = new Companion(null);
    public static final int DISPATCH_TO_QUEUE_HEAD = 1;
    public static final int DISPATCH_TO_QUEUE_TAIL = 2;
    public static final int DISPATCH_TO_RUNNING = 3;

    /* compiled from: DispatchHandler.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public DispatchHandler(Looper looper) {
        super(looper);
    }

    private final void add(boolean z, DownloadTask downloadTask) {
        clearDownloadedStatusIfNeeded(downloadTask);
        if (downloadTask.getStatus().couldEnqueue$pgdownloader2_release()) {
            PGDownloadManger.Companion companion = PGDownloadManger.Companion;
            companion.getInstance().getTaskDeque$pgdownloader2_release().setOfferToFirst(z);
            downloadTask.setStatus$pgdownloader2_release(Status.IN_QUEUE);
            companion.getInstance().getTaskExecutor$pgdownloader2_release().execute(new TaskRunnable(downloadTask));
            return;
        }
        DownloadListener listener = downloadTask.getListener();
        if (listener == null) {
            return;
        }
        listener.onError(downloadTask, ErrorCode.REPEAT_SUBMIT_ERROR);
    }

    private final void addToCurrent(DownloadTask downloadTask) {
        clearDownloadedStatusIfNeeded(downloadTask);
        if (downloadTask.getStatus().couldEnqueue$pgdownloader2_release()) {
            tryAddToCurrent(downloadTask);
            return;
        }
        DownloadListener listener = downloadTask.getListener();
        if (listener == null) {
            return;
        }
        listener.onError(downloadTask, ErrorCode.REPEAT_SUBMIT_ERROR);
    }

    private final void clearDownloadedStatusIfNeeded(DownloadTask downloadTask) {
        if (downloadTask.getStatus() == Status.FINISHED && downloadTask.isForceReDownload()) {
            downloadTask.setStatus$pgdownloader2_release(Status.READY);
            downloadTask.clearBlocks$pgdownloader2_release();
            FileDownloadUtils.deleteFile(downloadTask.getTargetFilePath());
        }
    }

    private final void tryAddToCurrent(DownloadTask downloadTask) {
        while (true) {
            PGDownloadManger.Companion companion = PGDownloadManger.Companion;
            if (companion.getInstance().getTaskExecutor$pgdownloader2_release().getActiveCount() < 3) {
                add(true, downloadTask);
                return;
            }
            a.d("DLTest", "try to find running task", new Object[0]);
            for (DownloadTask runningTask : companion.getInstance().getTaskMaps$pgdownloader2_release().values()) {
                if (runningTask.isRunning()) {
                    a.d("DLTest", "find task_%d is running", Integer.valueOf(runningTask.getId()));
                    runningTask.pause();
                    PGDownloadManger.Companion companion2 = PGDownloadManger.Companion;
                    companion2.getInstance().getTaskDeque$pgdownloader2_release().setOfferToFirst(true);
                    ThreadPoolExecutor taskExecutor$pgdownloader2_release = companion2.getInstance().getTaskExecutor$pgdownloader2_release();
                    s.g(runningTask, "runningTask");
                    taskExecutor$pgdownloader2_release.execute(new TaskRunnable(runningTask));
                    downloadTask.setStatus$pgdownloader2_release(Status.IN_QUEUE);
                    companion2.getInstance().getTaskExecutor$pgdownloader2_release().execute(new TaskRunnable(downloadTask));
                    return;
                }
            }
            a.d("DLTest", "no running task find, wait a moment and find again", new Object[0]);
            Thread.sleep(50L);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        Object obj = message.obj;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.common.pgdownloader.download.DownloadTask");
        DownloadTask downloadTask = (DownloadTask) obj;
        int i2 = message.what;
        if (i2 == 1) {
            a.d("DLTest", "dispatch to head, task=%d", Integer.valueOf(downloadTask.getId()));
            add(true, downloadTask);
        } else if (i2 == 2) {
            a.d("DLTest", "dispatch to tail, task=%d", Integer.valueOf(downloadTask.getId()));
            add(false, downloadTask);
        } else if (i2 != 3) {
        } else {
            a.d("DLTest", "dispatch to running, task=%d", Integer.valueOf(downloadTask.getId()));
            addToCurrent(downloadTask);
        }
    }
}
