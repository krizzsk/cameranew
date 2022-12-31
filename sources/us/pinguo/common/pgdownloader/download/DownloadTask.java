package us.pinguo.common.pgdownloader.download;

import java.io.File;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.common.pgdownloader.download.DownloadBlock;
import us.pinguo.common.pgdownloader.util.FileDownloadUtils;
/* compiled from: DownloadTask.kt */
/* loaded from: classes4.dex */
public final class DownloadTask implements IDownloadTask {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PROGRESS_INTERVAL = 16;
    private final int blockCount;
    private DownloadBlock[] blocks;
    private String filename;
    private final int id;
    private boolean isForceReDownload;
    private boolean isWifiRequired;
    private DownloadListener listener;
    private final String path;
    private final boolean pathAsDirectory;
    private int progressCallbackInterval;
    private Status status;
    private boolean syncCallback;
    private int totalBytes;
    private final String url;

    /* compiled from: DownloadTask.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public DownloadTask(String url, String path, boolean z, int i2) {
        s.h(url, "url");
        s.h(path, "path");
        this.url = url;
        this.path = path;
        this.pathAsDirectory = z;
        this.blockCount = i2;
        this.id = FileDownloadUtils.generateId(url, path, z);
        this.status = Status.READY;
        this.progressCallbackInterval = 16;
        if (z) {
            this.filename = null;
        } else {
            this.filename = new File(path).getName();
        }
    }

    public final void clearBlocks$pgdownloader2_release() {
        this.blocks = null;
    }

    public final int getBlockCount$pgdownloader2_release() {
        return this.blockCount;
    }

    public final DownloadBlock[] getBlocks$pgdownloader2_release() {
        return this.blocks;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public String getFilename() {
        return this.filename;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public int getId() {
        return this.id;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public DownloadListener getListener() {
        return this.listener;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public int getMinProgressCallbackInterval() {
        return this.progressCallbackInterval;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public String getPath() {
        return this.path;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public int getSoFarBytes() {
        DownloadBlock[] downloadBlockArr = this.blocks;
        int i2 = 0;
        if (downloadBlockArr == null) {
            return 0;
        }
        int length = downloadBlockArr.length;
        int i3 = 0;
        while (i2 < length) {
            DownloadBlock downloadBlock = downloadBlockArr[i2];
            i2++;
            i3 += downloadBlock.getCurrent() - downloadBlock.getStart();
        }
        return i3;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public Status getStatus() {
        return this.status;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public String getTargetFilePath() {
        return FileDownloadUtils.getTargetFilePath(getPath(), isPathAsDirectory(), getFilename());
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public int getTotalBytes() {
        return this.totalBytes;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public String getUrl() {
        return this.url;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public boolean isForceReDownload() {
        return this.isForceReDownload;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public boolean isPathAsDirectory() {
        return this.pathAsDirectory;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public boolean isRunning() {
        return this.status == Status.RUNNING;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public boolean isSyncCallback() {
        return this.syncCallback;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public boolean isWifiRequired() {
        return this.isWifiRequired;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public void pause() {
        this.status = Status.PAUSED;
        DownloadBlock[] blocks$pgdownloader2_release = getBlocks$pgdownloader2_release();
        if (blocks$pgdownloader2_release == null) {
            return;
        }
        int i2 = 0;
        int length = blocks$pgdownloader2_release.length;
        while (i2 < length) {
            DownloadBlock downloadBlock = blocks$pgdownloader2_release[i2];
            i2++;
            downloadBlock.setStatus(DownloadBlock.BlockStatus.READY);
        }
    }

    public final void setBlocks$pgdownloader2_release(DownloadBlock[] blocks) {
        s.h(blocks, "blocks");
        this.blocks = blocks;
    }

    public final void setFilename$pgdownloader2_release(String name) {
        s.h(name, "name");
        if (this.filename == null) {
            this.filename = name;
        }
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public IDownloadTask setForceReDownload(boolean z) {
        this.isForceReDownload = z;
        return this;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public IDownloadTask setListener(DownloadListener listener) {
        s.h(listener, "listener");
        this.listener = listener;
        return this;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public IDownloadTask setMinProgressCallbackInterval(int i2) {
        this.progressCallbackInterval = i2;
        return this;
    }

    public final synchronized void setStatus$pgdownloader2_release(Status status) {
        s.h(status, "status");
        this.status = status;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public IDownloadTask setSyncCallback(boolean z) {
        this.syncCallback = z;
        return this;
    }

    public final void setTotalBytes$pgdownloader2_release(int i2) {
        this.totalBytes = i2;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public IDownloadTask setWifiRequired(boolean z) {
        this.isWifiRequired = z;
        return this;
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public int start() {
        PGDownloadManger.Companion.getInstance().submit(this);
        return getId();
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public int startAtFirst() {
        PGDownloadManger.Companion.getInstance().submitToFirst(this);
        return getId();
    }

    @Override // us.pinguo.common.pgdownloader.download.IDownloadTask
    public int startRightNow() {
        PGDownloadManger.Companion.getInstance().submitToCurrent(this);
        return getId();
    }

    public /* synthetic */ DownloadTask(String str, String str2, boolean z, int i2, int i3, o oVar) {
        this(str, str2, z, (i3 & 8) != 0 ? 0 : i2);
    }
}
