package com.facebook.common.executors;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
/* compiled from: ScheduledFutureImpl.java */
/* loaded from: classes.dex */
public class d<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    private final FutureTask<V> a;

    public d(Handler handler, Callable<V> callable) {
        this.a = new FutureTask<>(callable);
    }

    public int a(Delayed delayed) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        a(delayed);
        throw null;
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.a.get();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.a.isDone();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.a.run();
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.a.get(j2, timeUnit);
    }

    public d(Handler handler, Runnable runnable, @Nullable V v) {
        this.a = new FutureTask<>(runnable, v);
    }
}
