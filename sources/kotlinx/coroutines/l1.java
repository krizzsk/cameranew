package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.CoroutineContext;
/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
public final class l1 extends ExecutorCoroutineDispatcher implements u0 {
    private final Executor a;

    public l1(Executor executor) {
        this.a = executor;
        kotlinx.coroutines.internal.e.a(z());
    }

    private final ScheduledFuture<?> A(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j2) {
        try {
            return scheduledExecutorService.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            s(coroutineContext, e2);
            return null;
        }
    }

    private final void s(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        y1.c(coroutineContext, k1.a("The task was rejected", rejectedExecutionException));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor z = z();
        ExecutorService executorService = z instanceof ExecutorService ? (ExecutorService) z : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor z = z();
            d a = e.a();
            z.execute(a == null ? runnable : a.h(runnable));
        } catch (RejectedExecutionException e2) {
            d a2 = e.a();
            if (a2 != null) {
                a2.e();
            }
            s(coroutineContext, e2);
            z0.b().dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.u0
    public void e(long j2, p<? super kotlin.u> pVar) {
        Executor z = z();
        ScheduledExecutorService scheduledExecutorService = z instanceof ScheduledExecutorService ? (ScheduledExecutorService) z : null;
        ScheduledFuture<?> A = scheduledExecutorService != null ? A(scheduledExecutorService, new o2(this, pVar), pVar.getContext(), j2) : null;
        if (A != null) {
            y1.e(pVar, A);
        } else {
            q0.f8788f.e(j2, pVar);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof l1) && ((l1) obj).z() == z();
    }

    public int hashCode() {
        return System.identityHashCode(z());
    }

    @Override // kotlinx.coroutines.u0
    public b1 m(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        Executor z = z();
        ScheduledExecutorService scheduledExecutorService = z instanceof ScheduledExecutorService ? (ScheduledExecutorService) z : null;
        ScheduledFuture<?> A = scheduledExecutorService != null ? A(scheduledExecutorService, runnable, coroutineContext, j2) : null;
        if (A != null) {
            return new a1(A);
        }
        return q0.f8788f.m(j2, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return z().toString();
    }

    public Executor z() {
        return this.a;
    }
}
