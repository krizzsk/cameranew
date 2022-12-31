package us.pinguo.common.pgdownloader.download;
/* compiled from: DownloadListener.kt */
/* loaded from: classes4.dex */
public interface DownloadListener {
    void onComplete(IDownloadTask iDownloadTask);

    void onError(IDownloadTask iDownloadTask, int i2);

    void onPause(IDownloadTask iDownloadTask);

    void onProgress(IDownloadTask iDownloadTask, int i2, int i3, int i4);
}
