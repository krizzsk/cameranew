package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {
    private final AtomicInteger a;
    private final UncaughtThrowableStrategy b;

    /* loaded from: classes.dex */
    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
                }
            }
        },
        THROW { // from class: com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th) {
                super.handle(th);
                throw new RuntimeException(th);
            }
        };

        protected void handle(Throwable th) {
        }
    }

    /* loaded from: classes.dex */
    public static class b implements ThreadFactory {
        int a = 0;

        /* loaded from: classes.dex */
        class a extends Thread {
            a(b bVar, Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a aVar = new a(this, runnable, "fifo-pool-thread-" + this.a);
            this.a = this.a + 1;
            return aVar;
        }
    }

    /* loaded from: classes.dex */
    static class c<T> extends FutureTask<T> implements Comparable<c<?>> {
        private final int a;
        private final int b;

        public c(Runnable runnable, T t, int i2) {
            super(runnable, t);
            if (runnable instanceof com.bumptech.glide.load.engine.executor.a) {
                this.a = ((com.bumptech.glide.load.engine.executor.a) runnable).getPriority();
                this.b = i2;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c<?> cVar) {
            int i2 = this.a - cVar.a;
            return i2 == 0 ? this.b - cVar.b : i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.b == cVar.b && this.a == cVar.a;
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 31) + this.b;
        }
    }

    public FifoPriorityThreadPoolExecutor(int i2) {
        this(i2, UncaughtThrowableStrategy.LOG);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (!future.isDone() || future.isCancelled()) {
                return;
            }
            try {
                future.get();
            } catch (InterruptedException e2) {
                this.b.handle(e2);
            } catch (ExecutionException e3) {
                this.b.handle(e3);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new c(runnable, t, this.a.getAndIncrement());
    }

    public FifoPriorityThreadPoolExecutor(int i2, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(i2, i2, 0L, TimeUnit.MILLISECONDS, new b(), uncaughtThrowableStrategy);
    }

    public FifoPriorityThreadPoolExecutor(int i2, int i3, long j2, TimeUnit timeUnit, ThreadFactory threadFactory, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(i2, i3, j2, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.a = new AtomicInteger();
        this.b = uncaughtThrowableStrategy;
    }
}
