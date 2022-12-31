package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.Util;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class TimerOnce {
    private Runnable command;
    private ILogger logger = AdjustFactory.getLogger();
    private String name;
    private FutureScheduler scheduler;
    private ScheduledFuture waitingTask;

    public TimerOnce(Runnable runnable, String str) {
        this.name = str;
        this.scheduler = new SingleThreadFutureScheduler(str, true);
        this.command = runnable;
    }

    private void cancel(boolean z) {
        ScheduledFuture scheduledFuture = this.waitingTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(z);
        }
        this.waitingTask = null;
        this.logger.verbose("%s canceled", this.name);
    }

    public long getFireIn() {
        ScheduledFuture scheduledFuture = this.waitingTask;
        if (scheduledFuture == null) {
            return 0L;
        }
        return scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
    }

    public void startIn(long j2) {
        cancel(false);
        this.logger.verbose("%s starting. Launching in %s seconds", this.name, Util.SecondsDisplayFormat.format(j2 / 1000.0d));
        this.waitingTask = this.scheduler.scheduleFuture(new Runnable() { // from class: com.adjust.sdk.scheduler.TimerOnce.1
            @Override // java.lang.Runnable
            public void run() {
                TimerOnce.this.logger.verbose("%s fired", TimerOnce.this.name);
                TimerOnce.this.command.run();
                TimerOnce.this.waitingTask = null;
            }
        }, j2);
    }

    public void teardown() {
        cancel(true);
        FutureScheduler futureScheduler = this.scheduler;
        if (futureScheduler != null) {
            futureScheduler.teardown();
        }
        this.scheduler = null;
    }

    public void cancel() {
        cancel(false);
    }
}
