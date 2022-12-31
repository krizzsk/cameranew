package us.pinguo.common.pgdownloader.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.log.a;
import us.pinguo.common.pgdownloader.download.BlockListener;
import us.pinguo.common.pgdownloader.download.ConnectInfo;
import us.pinguo.common.pgdownloader.download.DownloadBlock;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.DownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.common.pgdownloader.download.Status;
import us.pinguo.common.pgdownloader.exception.ErrorCode;
import us.pinguo.common.pgdownloader.statistics.DownloaderStat;
import us.pinguo.common.pgdownloader.statistics.SS;
import us.pinguo.common.pgdownloader.util.FileDownloadUtils;
/* compiled from: TaskRunnable.kt */
/* loaded from: classes4.dex */
public final class TaskRunnable implements Runnable {
    public static final int CALLBACK_MSG_ERROR = 2;
    public static final int CALLBACK_MSG_FINISH = 1;
    public static final int CALLBACK_MSG_PAUSED = 3;
    public static final int CALLBACK_MSG_PROGRESS = 0;
    public static final Companion Companion = new Companion(null);
    private final DownloadTask task;
    private final TaskRunnable$uiHandler$1 uiHandler;

    /* compiled from: TaskRunnable.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    /* compiled from: TaskRunnable.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            iArr[Status.IN_QUEUE.ordinal()] = 1;
            iArr[Status.PAUSED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [us.pinguo.common.pgdownloader.core.TaskRunnable$uiHandler$1] */
    public TaskRunnable(DownloadTask task) {
        s.h(task, "task");
        this.task = task;
        final Looper mainLooper = Looper.getMainLooper();
        this.uiHandler = new Handler(mainLooper) { // from class: us.pinguo.common.pgdownloader.core.TaskRunnable$uiHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Integer valueOf = message == null ? null : Integer.valueOf(message.what);
                if (valueOf != null && valueOf.intValue() == 0) {
                    TaskRunnable taskRunnable = TaskRunnable.this;
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    Object obj = message.obj;
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    taskRunnable.callProgress(i2, i3, ((Integer) obj).intValue());
                } else if (valueOf != null && valueOf.intValue() == 1) {
                    TaskRunnable.this.callFinish();
                } else if (valueOf != null && valueOf.intValue() == 2) {
                    TaskRunnable.this.callError(message.arg1);
                } else if (valueOf != null && valueOf.intValue() == 3) {
                    TaskRunnable.this.callPaused();
                }
            }
        };
    }

    private final void allocateBlocks() {
        int blockCount$pgdownloader2_release = this.task.getBlockCount$pgdownloader2_release() > 0 ? this.task.getBlockCount$pgdownloader2_release() : PGDownloadManger.Companion.getConfig().blockCountOfTask(this.task);
        int totalBytes = this.task.getTotalBytes();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < blockCount$pgdownloader2_release) {
            int i3 = i2 + 1;
            int i4 = (i2 * totalBytes) / blockCount$pgdownloader2_release;
            int i5 = i3 == blockCount$pgdownloader2_release ? totalBytes : ((i3 * totalBytes) / blockCount$pgdownloader2_release) - 1;
            String url = this.task.getUrl();
            String targetFilePath = this.task.getTargetFilePath();
            s.e(targetFilePath);
            arrayList.add(new DownloadBlock(url, targetFilePath, i4, i5, null, null, null));
            i2 = i3;
        }
        DownloadTask downloadTask = this.task;
        Object[] array = arrayList.toArray(new DownloadBlock[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        downloadTask.setBlocks$pgdownloader2_release((DownloadBlock[]) array);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callError(int i2) {
        this.task.setStatus$pgdownloader2_release(Status.ERROR);
        DownloadListener listener = this.task.getListener();
        if (listener == null) {
            return;
        }
        listener.onError(this.task, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callFinish() {
        this.task.setStatus$pgdownloader2_release(Status.FINISHED);
        DownloadListener listener = this.task.getListener();
        if (listener == null) {
            return;
        }
        listener.onComplete(this.task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callPaused() {
        this.task.setStatus$pgdownloader2_release(Status.PAUSED);
        DownloadListener listener = this.task.getListener();
        if (listener == null) {
            return;
        }
        listener.onPause(this.task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callProgress(int i2, int i3, int i4) {
        DownloadListener listener = this.task.getListener();
        if (listener == null) {
            return;
        }
        listener.onProgress(this.task, i2, i3, i4);
    }

    private final boolean checkPaused(DownloadTask downloadTask) {
        if (downloadTask.getStatus() == Status.PAUSED) {
            dispatchPaused();
            return true;
        }
        return false;
    }

    private final void dispatchError(int i2) {
        if (this.task.isSyncCallback()) {
            callError(i2);
        } else {
            Message.obtain(this.uiHandler, 2, Integer.valueOf(i2)).sendToTarget();
        }
    }

    private final void dispatchFinish() {
        if (this.task.isSyncCallback()) {
            callFinish();
        } else {
            Message.obtain(this.uiHandler, 1).sendToTarget();
        }
    }

    private final void dispatchPaused() {
        if (this.task.isSyncCallback()) {
            callPaused();
        } else {
            Message.obtain(this.uiHandler, 3).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchProgress(int i2, int i3, int i4) {
        if (this.task.isSyncCallback()) {
            callProgress(i2, i3, i4);
        } else {
            Message.obtain(this.uiHandler, 0, i2, i3, Integer.valueOf(i4)).sendToTarget();
        }
    }

    private final void fetchConnectionInfo() {
        ConnectInfo trailConnect = ConnectionProcessor.INSTANCE.trailConnect(this.task.getUrl());
        this.task.setFilename$pgdownloader2_release(trailConnect.getFilename());
        this.task.setTotalBytes$pgdownloader2_release(trailConnect.getContentLength());
    }

    private final void handleMultiBlockDownload(DownloadBlock[] downloadBlockArr) {
        CountDownLatch countDownLatch = new CountDownLatch(downloadBlockArr.length);
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        final int totalBytes = this.task.getTotalBytes();
        final int minProgressCallbackInterval = this.task.getMinProgressCallbackInterval();
        int i2 = 0;
        for (int length = downloadBlockArr.length; i2 < length; length = length) {
            final AtomicInteger atomicInteger3 = atomicInteger;
            final AtomicInteger atomicInteger4 = atomicInteger2;
            final Ref$LongRef ref$LongRef2 = ref$LongRef;
            PGDownloadManger.Companion.getInstance().getBlockExecutor$pgdownloader2_release().execute(new DownloadRunnable(downloadBlockArr[i2], new BlockListener() { // from class: us.pinguo.common.pgdownloader.core.TaskRunnable$handleMultiBlockDownload$1$1
                @Override // us.pinguo.common.pgdownloader.download.BlockListener
                public void onBlockError(String method, int i3, String msg) {
                    DownloadTask downloadTask;
                    s.h(method, "method");
                    s.h(msg, "msg");
                    DownloaderStat downloaderStat = SS.N_S;
                    downloadTask = this.task;
                    downloaderStat.network_health_tracking_error(downloadTask.getUrl(), "material", method, String.valueOf(i3), msg);
                }

                @Override // us.pinguo.common.pgdownloader.download.BlockListener
                public void onBlockFinish(String method, int i3, long j2) {
                    DownloadTask downloadTask;
                    s.h(method, "method");
                    DownloaderStat downloaderStat = SS.N_S;
                    downloadTask = this.task;
                    downloaderStat.network_health_tracking_cost(downloadTask.getUrl(), "material", method, String.valueOf(i3), String.valueOf(j2));
                }

                @Override // us.pinguo.common.pgdownloader.download.BlockListener
                public void onBlockProgress(int i3, int i4) {
                    long currentTimeMillis = System.currentTimeMillis();
                    atomicInteger3.getAndAdd(i3);
                    atomicInteger4.getAndAdd(i3);
                    if (currentTimeMillis - ref$LongRef2.element > minProgressCallbackInterval || atomicInteger4.get() == totalBytes) {
                        AtomicInteger atomicInteger5 = atomicInteger3;
                        Ref$LongRef ref$LongRef3 = ref$LongRef2;
                        int i5 = minProgressCallbackInterval;
                        AtomicInteger atomicInteger6 = atomicInteger4;
                        int i6 = totalBytes;
                        TaskRunnable taskRunnable = this;
                        synchronized (atomicInteger5) {
                            if (currentTimeMillis - ref$LongRef3.element > i5 || atomicInteger6.get() == i6) {
                                taskRunnable.dispatchProgress(atomicInteger5.get(), atomicInteger6.get(), i6);
                                ref$LongRef3.element = currentTimeMillis;
                                atomicInteger5.set(0);
                            }
                            u uVar = u.a;
                        }
                    }
                }
            }, countDownLatch));
            i2++;
            atomicInteger = atomicInteger;
            ref$LongRef = ref$LongRef;
            atomicInteger2 = atomicInteger2;
        }
        countDownLatch.await();
        int length2 = downloadBlockArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length2) {
            DownloadBlock downloadBlock = downloadBlockArr[i4];
            i4++;
            if (downloadBlock.getStatus() == DownloadBlock.BlockStatus.FINISHED) {
                i3++;
            } else if (downloadBlock.getStatus() == DownloadBlock.BlockStatus.READY) {
                dispatchPaused();
            } else if (downloadBlock.getStatus() == DownloadBlock.BlockStatus.ERROR) {
                dispatchError(downloadBlock.getStatus().getCode());
            }
        }
        if (i3 == downloadBlockArr.length) {
            dispatchFinish();
        } else {
            dispatchError(ErrorCode.UNKNOWN_ERROR);
        }
    }

    private final void handleSingleBlockDownload(DownloadBlock downloadBlock) {
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        final int totalBytes = this.task.getTotalBytes();
        final int minProgressCallbackInterval = this.task.getMinProgressCallbackInterval();
        new DownloadRunnable(downloadBlock, new BlockListener() { // from class: us.pinguo.common.pgdownloader.core.TaskRunnable$handleSingleBlockDownload$1
            @Override // us.pinguo.common.pgdownloader.download.BlockListener
            public void onBlockError(String method, int i2, String msg) {
                DownloadTask downloadTask;
                s.h(method, "method");
                s.h(msg, "msg");
                DownloaderStat downloaderStat = SS.N_S;
                downloadTask = this.task;
                downloaderStat.network_health_tracking_error(downloadTask.getUrl(), "material", method, String.valueOf(i2), msg);
            }

            @Override // us.pinguo.common.pgdownloader.download.BlockListener
            public void onBlockFinish(String method, int i2, long j2) {
                DownloadTask downloadTask;
                s.h(method, "method");
                DownloaderStat downloaderStat = SS.N_S;
                downloadTask = this.task;
                downloaderStat.network_health_tracking_cost(downloadTask.getUrl(), "material", method, String.valueOf(i2), String.valueOf(j2));
            }

            @Override // us.pinguo.common.pgdownloader.download.BlockListener
            public void onBlockProgress(int i2, int i3) {
                long currentTimeMillis = System.currentTimeMillis();
                Ref$IntRef ref$IntRef2 = Ref$IntRef.this;
                int i4 = ref$IntRef2.element + i2;
                ref$IntRef2.element = i4;
                if (currentTimeMillis - ref$LongRef.element > minProgressCallbackInterval || i3 == totalBytes) {
                    this.dispatchProgress(i4, i3, totalBytes);
                    ref$LongRef.element = currentTimeMillis;
                    Ref$IntRef.this.element = 0;
                }
            }
        }, null, 4, null).run();
        a.c(s.q("block status:", downloadBlock.getStatus()), new Object[0]);
        if (downloadBlock.getStatus() == DownloadBlock.BlockStatus.FINISHED) {
            dispatchFinish();
        } else if (downloadBlock.getStatus() == DownloadBlock.BlockStatus.READY) {
            dispatchPaused();
        } else if (downloadBlock.getStatus() == DownloadBlock.BlockStatus.ERROR) {
            dispatchError(downloadBlock.getStatus().getCode());
        } else {
            dispatchError(ErrorCode.UNKNOWN_ERROR);
        }
    }

    private final void runTask() {
        a.d("DLTest", "task started", new Object[0]);
        this.task.setStatus$pgdownloader2_release(Status.RUNNING);
        if (this.task.getFilename() == null || this.task.getTotalBytes() == 0) {
            a.d("DLTest", "start fetch connection info:%s", this.task.getUrl());
            try {
                fetchConnectionInfo();
            } catch (IOException e2) {
                e2.printStackTrace();
                dispatchError(ErrorCode.NETWORK_ERROR);
                return;
            }
        }
        if (!FileDownloadUtils.createOrExistsFile(FileDownloadUtils.getFileByPath(this.task.getTargetFilePath()))) {
            dispatchError(ErrorCode.FILE_IO_ERROR);
        } else if (checkPaused(this.task)) {
        } else {
            if (this.task.getBlocks$pgdownloader2_release() == null) {
                a.d("DLTest", "start allocate blocks", new Object[0]);
                allocateBlocks();
            }
            DownloadBlock[] blocks$pgdownloader2_release = this.task.getBlocks$pgdownloader2_release();
            s.e(blocks$pgdownloader2_release);
            a.d("DLTest", "blocks count=%d", Integer.valueOf(blocks$pgdownloader2_release.length));
            a.d("DLTest", "task and blocks prepared", new Object[0]);
            DownloadBlock[] blocks$pgdownloader2_release2 = this.task.getBlocks$pgdownloader2_release();
            s.e(blocks$pgdownloader2_release2);
            if (blocks$pgdownloader2_release2.length == 0) {
                dispatchError(ErrorCode.BLOCK_COUNT_ERROR);
            } else if (blocks$pgdownloader2_release2.length == 1) {
                handleSingleBlockDownload(blocks$pgdownloader2_release2[0]);
            } else {
                handleMultiBlockDownload(blocks$pgdownloader2_release2);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.task.getStatus().ordinal()];
        if (i2 == 1) {
            runTask();
        } else if (i2 != 2) {
            dispatchError(ErrorCode.TASK_STATUS_ERROR);
        } else {
            dispatchPaused();
        }
    }
}
