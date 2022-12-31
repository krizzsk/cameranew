package us.pinguo.common.pgdownloader.config;

import us.pinguo.common.pgdownloader.download.DownloadTask;
/* compiled from: DownloadConfig.kt */
/* loaded from: classes4.dex */
public interface DownloadConfig {
    int blockCountOfTask(DownloadTask downloadTask);

    int parallelTaskCount();
}
