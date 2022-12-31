package us.pinguo.common.pgdownloader.config;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.common.pgdownloader.download.DownloadTask;
/* compiled from: FixCountConfig.kt */
/* loaded from: classes4.dex */
public class FixCountConfig implements DownloadConfig {
    private final int blockCount;
    private final int taskCount;

    public FixCountConfig() {
        this(0, 0, 3, null);
    }

    public FixCountConfig(int i2, int i3) {
        this.taskCount = i2;
        this.blockCount = i3;
    }

    @Override // us.pinguo.common.pgdownloader.config.DownloadConfig
    public int blockCountOfTask(DownloadTask task) {
        s.h(task, "task");
        return this.blockCount;
    }

    @Override // us.pinguo.common.pgdownloader.config.DownloadConfig
    public int parallelTaskCount() {
        return this.taskCount;
    }

    public /* synthetic */ FixCountConfig(int i2, int i3, int i4, o oVar) {
        this((i4 & 1) != 0 ? 1 : i2, (i4 & 2) != 0 ? 1 : i3);
    }
}
