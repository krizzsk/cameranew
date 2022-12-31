package us.pinguo.common.pgdownloader.download;
/* compiled from: IDownloadTask.kt */
/* loaded from: classes4.dex */
public interface IDownloadTask {
    String getFilename();

    int getId();

    DownloadListener getListener();

    int getMinProgressCallbackInterval();

    String getPath();

    int getSoFarBytes();

    Status getStatus();

    String getTargetFilePath();

    int getTotalBytes();

    String getUrl();

    boolean isForceReDownload();

    boolean isPathAsDirectory();

    boolean isRunning();

    boolean isSyncCallback();

    boolean isWifiRequired();

    void pause();

    IDownloadTask setForceReDownload(boolean z);

    IDownloadTask setListener(DownloadListener downloadListener);

    IDownloadTask setMinProgressCallbackInterval(int i2);

    IDownloadTask setSyncCallback(boolean z);

    IDownloadTask setWifiRequired(boolean z);

    int start();

    int startAtFirst();

    int startRightNow();
}
