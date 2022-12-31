package com.facebook.common.executors;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ConstrainedExecutorService.java */
/* loaded from: classes.dex */
public class a extends AbstractExecutorService {

    /* renamed from: h  reason: collision with root package name */
    private static final Class<?> f2399h = a.class;
    private final String a;
    private final Executor b;
    private volatile int c;

    /* renamed from: d  reason: collision with root package name */
    private final BlockingQueue<Runnable> f2400d;

    /* renamed from: e  reason: collision with root package name */
    private final b f2401e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f2402f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f2403g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConstrainedExecutorService.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) a.this.f2400d.poll();
                if (runnable == null) {
                    com.facebook.common.logging.a.p(a.f2399h, "%s: Worker has nothing to run", a.this.a);
                } else {
                    runnable.run();
                }
                int decrementAndGet = a.this.f2402f.decrementAndGet();
                if (!a.this.f2400d.isEmpty()) {
                    a.this.f();
                } else {
                    com.facebook.common.logging.a.q(a.f2399h, "%s: worker finished; %d workers left", a.this.a, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = a.this.f2402f.decrementAndGet();
                if (!a.this.f2400d.isEmpty()) {
                    a.this.f();
                } else {
                    com.facebook.common.logging.a.q(a.f2399h, "%s: worker finished; %d workers left", a.this.a, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }

    public a(String str, int i2, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i2 > 0) {
            this.a = str;
            this.b = executor;
            this.c = i2;
            this.f2400d = blockingQueue;
            this.f2401e = new b();
            this.f2402f = new AtomicInteger(0);
            this.f2403g = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i2 = this.f2402f.get();
        while (i2 < this.c) {
            int i3 = i2 + 1;
            if (this.f2402f.compareAndSet(i2, i3)) {
                com.facebook.common.logging.a.r(f2399h, "%s: starting worker %d of %d", this.a, Integer.valueOf(i3), Integer.valueOf(this.c));
                this.b.execute(this.f2401e);
                return;
            }
            com.facebook.common.logging.a.p(f2399h, "%s: race in startWorkerIfNeeded; retrying", this.a);
            i2 = this.f2402f.get();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable parameter is null");
        if (this.f2400d.offer(runnable)) {
            int size = this.f2400d.size();
            int i2 = this.f2403g.get();
            if (size > i2 && this.f2403g.compareAndSet(i2, size)) {
                com.facebook.common.logging.a.q(f2399h, "%s: max pending work in queue = %d", this.a, Integer.valueOf(size));
            }
            f();
            return;
        }
        throw new RejectedExecutionException(this.a + " queue is full, size=" + this.f2400d.size());
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
