package com.huawei.hianalytics.v2.a.b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class q {
    private static q b = new q();
    private static q c = new q();
    private ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000));

    /* loaded from: classes2.dex */
    private static class a implements Runnable {
        private Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    com.huawei.hianalytics.b.b.c("TaskThread", "run(): exception in run");
                }
            }
        }
    }

    public static q a() {
        return b;
    }

    public static q b() {
        return c;
    }

    public void a(l lVar) {
        try {
            this.a.execute(new a(lVar));
        } catch (RejectedExecutionException unused) {
            com.huawei.hianalytics.b.b.c("TaskThread", "addToQueue(): RejectedExecutionException: queue is full");
        }
    }
}
