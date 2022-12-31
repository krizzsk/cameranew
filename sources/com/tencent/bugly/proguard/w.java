package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class w {
    private static final AtomicInteger a = new AtomicInteger(1);
    private static w b;
    private ScheduledExecutorService c;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    final class a implements ThreadFactory {
        a(w wVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("BuglyThread-" + w.a.getAndIncrement());
            return thread;
        }
    }

    protected w() {
        this.c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new a(this));
        this.c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (b == null) {
                b = new w();
            }
            wVar = b;
        }
        return wVar;
    }

    public final synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            x.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.c.shutdownNow();
        }
    }

    public final synchronized boolean c() {
        boolean z;
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null) {
            z = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z;
    }

    public final synchronized boolean a(Runnable runnable, long j2) {
        if (!c()) {
            x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            if (j2 <= 0) {
                j2 = 0;
            }
            x.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j2), runnable.getClass().getName());
            this.c.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            return true;
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            x.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            this.c.execute(runnable);
            return true;
        }
    }
}
