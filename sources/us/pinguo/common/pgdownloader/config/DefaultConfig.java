package us.pinguo.common.pgdownloader.config;

import kotlin.jvm.internal.s;
import us.pinguo.common.pgdownloader.download.DownloadTask;
/* compiled from: DefaultConfig.kt */
/* loaded from: classes4.dex */
public final class DefaultConfig implements DownloadConfig {
    @Override // us.pinguo.common.pgdownloader.config.DownloadConfig
    public int blockCountOfTask(DownloadTask task) {
        s.h(task, "task");
        int totalBytes = task.getTotalBytes();
        boolean z = false;
        if (totalBytes >= 0 && totalBytes < 2500000) {
            return 1;
        }
        if (2500000 <= totalBytes && totalBytes < 100000000) {
            return 2;
        }
        if (100000000 <= totalBytes && totalBytes < Integer.MAX_VALUE) {
            z = true;
        }
        return z ? 3 : 1;
    }

    @Override // us.pinguo.common.pgdownloader.config.DownloadConfig
    public int parallelTaskCount() {
        return 3;
    }
}
