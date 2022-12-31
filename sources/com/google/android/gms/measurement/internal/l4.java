package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class l4 extends j5 {

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicLong f3858l = new AtomicLong(Long.MIN_VALUE);
    @Nullable
    private k4 c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private k4 f3859d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityBlockingQueue<j4<?>> f3860e;

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue<j4<?>> f3861f;

    /* renamed from: g  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f3862g;

    /* renamed from: h  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f3863h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f3864i;

    /* renamed from: j  reason: collision with root package name */
    private final Semaphore f3865j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f3866k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l4(o4 o4Var) {
        super(o4Var);
        this.f3864i = new Object();
        this.f3865j = new Semaphore(2);
        this.f3860e = new PriorityBlockingQueue<>();
        this.f3861f = new LinkedBlockingQueue();
        this.f3862g = new i4(this, "Thread death: Uncaught exception on worker thread");
        this.f3863h = new i4(this, "Thread death: Uncaught exception on network thread");
    }

    private final void B(j4<?> j4Var) {
        synchronized (this.f3864i) {
            this.f3860e.add(j4Var);
            k4 k4Var = this.c;
            if (k4Var == null) {
                k4 k4Var2 = new k4(this, "Measurement Worker", this.f3860e);
                this.c = k4Var2;
                k4Var2.setUncaughtExceptionHandler(this.f3862g);
                this.c.start();
            } else {
                k4Var.a();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.i5
    public final void e() {
        if (Thread.currentThread() != this.f3859d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.i5
    public final void f() {
        if (Thread.currentThread() != this.c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.j5
    protected final boolean g() {
        return false;
    }

    public final boolean m() {
        return Thread.currentThread() == this.c;
    }

    public final <V> Future<V> n(Callable<V> callable) throws IllegalStateException {
        j();
        com.google.android.gms.common.internal.q.j(callable);
        j4<?> j4Var = new j4<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            if (!this.f3860e.isEmpty()) {
                this.a.a().p().a("Callable skipped the worker queue.");
            }
            j4Var.run();
        } else {
            B(j4Var);
        }
        return j4Var;
    }

    public final <V> Future<V> o(Callable<V> callable) throws IllegalStateException {
        j();
        com.google.android.gms.common.internal.q.j(callable);
        j4<?> j4Var = new j4<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            j4Var.run();
        } else {
            B(j4Var);
        }
        return j4Var;
    }

    public final void p(Runnable runnable) throws IllegalStateException {
        j();
        com.google.android.gms.common.internal.q.j(runnable);
        B(new j4<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final <T> T q(AtomicReference<T> atomicReference, long j2, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.a.c().p(runnable);
            try {
                atomicReference.wait(j2);
            } catch (InterruptedException unused) {
                this.a.a().p().a(str.length() != 0 ? "Interrupted waiting for ".concat(str) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            this.a.a().p().a(str.length() != 0 ? "Timed out waiting for ".concat(str) : new String("Timed out waiting for "));
        }
        return t;
    }

    public final void r(Runnable runnable) throws IllegalStateException {
        j();
        com.google.android.gms.common.internal.q.j(runnable);
        B(new j4<>(this, runnable, true, "Task exception on worker thread"));
    }

    public final void s(Runnable runnable) throws IllegalStateException {
        j();
        com.google.android.gms.common.internal.q.j(runnable);
        j4<?> j4Var = new j4<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f3864i) {
            this.f3861f.add(j4Var);
            k4 k4Var = this.f3859d;
            if (k4Var == null) {
                k4 k4Var2 = new k4(this, "Measurement Network", this.f3861f);
                this.f3859d = k4Var2;
                k4Var2.setUncaughtExceptionHandler(this.f3863h);
                this.f3859d.start();
            } else {
                k4Var.a();
            }
        }
    }
}
