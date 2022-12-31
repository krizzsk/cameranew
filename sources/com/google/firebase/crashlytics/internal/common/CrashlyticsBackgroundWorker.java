package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class CrashlyticsBackgroundWorker {
    private final Executor executor;
    private g<Void> tail = j.e(null);
    private final Object tailLock = new Object();
    private final ThreadLocal<Boolean> isExecutorThread = new ThreadLocal<>();

    public CrashlyticsBackgroundWorker(Executor executor) {
        this.executor = executor;
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.1
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsBackgroundWorker.this.isExecutorThread.set(Boolean.TRUE);
            }
        });
    }

    private <T> g<Void> ignoreResult(g<T> gVar) {
        return gVar.f(this.executor, (a<T, Void>) new a<T, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.4
            @Override // com.google.android.gms.tasks.a
            public Void then(@NonNull g<T> gVar2) throws Exception {
                return null;
            }
        });
    }

    private boolean isRunningOnThread() {
        return Boolean.TRUE.equals(this.isExecutorThread.get());
    }

    private <T> a<Void, T> newContinuation(final Callable<T> callable) {
        return new a<Void, T>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.3
            /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
            @Override // com.google.android.gms.tasks.a
            public T then(@NonNull g<Void> gVar) throws Exception {
                return callable.call();
            }
        };
    }

    public void checkRunningOnThread() {
        if (!isRunningOnThread()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor getExecutor() {
        return this.executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g<Void> submit(final Runnable runnable) {
        return submit(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.2
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    public <T> g<T> submitTask(Callable<g<T>> callable) {
        g<T> h2;
        synchronized (this.tailLock) {
            h2 = this.tail.h(this.executor, newContinuation(callable));
            this.tail = ignoreResult(h2);
        }
        return h2;
    }

    public <T> g<T> submit(Callable<T> callable) {
        g<T> f2;
        synchronized (this.tailLock) {
            f2 = this.tail.f(this.executor, newContinuation(callable));
            this.tail = ignoreResult(f2);
        }
        return f2;
    }
}
