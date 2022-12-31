package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class SingleThreadFutureScheduler implements FutureScheduler {
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    public SingleThreadFutureScheduler(final String str, boolean z) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryWrapper(str), new RejectedExecutionHandler() { // from class: com.adjust.sdk.scheduler.SingleThreadFutureScheduler.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), str);
            }
        });
        this.scheduledThreadPoolExecutor = scheduledThreadPoolExecutor;
        if (z) {
            return;
        }
        scheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
        this.scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public ScheduledFuture<?> scheduleFuture(Runnable runnable, long j2) {
        return this.scheduledThreadPoolExecutor.schedule(new RunnableWrapper(runnable), j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public ScheduledFuture<?> scheduleFutureWithFixedDelay(Runnable runnable, long j2, long j3) {
        return this.scheduledThreadPoolExecutor.scheduleWithFixedDelay(new RunnableWrapper(runnable), j2, j3, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public <V> ScheduledFuture<V> scheduleFutureWithReturn(final Callable<V> callable, long j2) {
        return this.scheduledThreadPoolExecutor.schedule(new Callable<V>() { // from class: com.adjust.sdk.scheduler.SingleThreadFutureScheduler.2
            /* JADX WARN: Type inference failed for: r0v6, types: [V, java.lang.Object] */
            @Override // java.util.concurrent.Callable
            public V call() {
                try {
                    return callable.call();
                } catch (Throwable th) {
                    AdjustFactory.getLogger().error("Callable error [%s] of type [%s]", th.getMessage(), th.getClass().getCanonicalName());
                    return null;
                }
            }
        }, j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public void teardown() {
        this.scheduledThreadPoolExecutor.shutdownNow();
    }
}
