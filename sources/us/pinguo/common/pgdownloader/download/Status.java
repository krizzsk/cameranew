package us.pinguo.common.pgdownloader.download;
/* compiled from: Status.kt */
/* loaded from: classes4.dex */
public enum Status {
    READY,
    IN_QUEUE,
    RUNNING,
    PAUSED,
    ERROR,
    FINISHED;

    public final boolean couldEnqueue$pgdownloader2_release() {
        return this == READY || this == PAUSED || this == ERROR;
    }

    public final boolean couldRun$pgdownloader2_release() {
        return this == IN_QUEUE;
    }
}
