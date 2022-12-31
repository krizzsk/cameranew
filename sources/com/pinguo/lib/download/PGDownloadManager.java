package com.pinguo.lib.download;

import android.os.Handler;
import android.os.Looper;
import com.pinguo.lib.download.PGDownloadTask;
import com.pinguo.lib.download.listener.DownloadCancelListener;
import com.pinguo.lib.download.listener.DownloadListener;
import com.pinguo.lib.download.listener.DownloadProcessListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public final class PGDownloadManager implements PGDownloadTask.TaskFinishListener {
    private static PGDownloadManager instance = new PGDownloadManager();
    private Handler mHandler;
    private Executor mTaskExecutor;
    private Map<Config, PGDownloadTask> mTaskMap = new ConcurrentHashMap();

    private PGDownloadManager() {
        this.mTaskExecutor = null;
        this.mHandler = null;
        this.mTaskExecutor = PGDownloadUtils.createExecutor(3, 4);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public static PGDownloadManager get() {
        return instance;
    }

    public boolean cancel(Config config, DownloadCancelListener downloadCancelListener) {
        PGDownloadTask pGDownloadTask = this.mTaskMap.get(config);
        if (pGDownloadTask == null) {
            return false;
        }
        pGDownloadTask.cancel(downloadCancelListener);
        return true;
    }

    @Override // com.pinguo.lib.download.PGDownloadTask.TaskFinishListener
    public void finish(Config config) {
        this.mTaskMap.remove(config);
    }

    public int getTaskSize() {
        return this.mTaskMap.size();
    }

    public boolean inQueue(Config config) {
        return this.mTaskMap.containsKey(config);
    }

    public boolean setDownloadListener(Config config, DownloadListener downloadListener) {
        PGDownloadTask pGDownloadTask = this.mTaskMap.get(config);
        if (pGDownloadTask == null) {
            return false;
        }
        pGDownloadTask.setDownloadListener(downloadListener);
        return true;
    }

    public boolean setProcessListener(Config config, DownloadProcessListener downloadProcessListener) {
        PGDownloadTask pGDownloadTask = this.mTaskMap.get(config);
        if (pGDownloadTask == null) {
            return false;
        }
        pGDownloadTask.setProcessListener(downloadProcessListener);
        return true;
    }

    public boolean start(Config config, DownloadListener downloadListener, DownloadProcessListener downloadProcessListener) {
        if (this.mTaskMap.get(config) != null) {
            return false;
        }
        PGDownloadTask pGDownloadTask = new PGDownloadTask(config, downloadListener, this.mHandler, this, downloadProcessListener);
        this.mTaskMap.put(config, pGDownloadTask);
        this.mTaskExecutor.execute(pGDownloadTask);
        return true;
    }
}
