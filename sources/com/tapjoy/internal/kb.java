package com.tapjoy.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class kb implements ke {
    private final a a = new a();
    private final kd b = new kd();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(@Nullable Object obj) {
        boolean a2 = this.a.a(obj, null, 2);
        if (a2) {
            this.b.a();
        }
        return a2;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (this.a.a(null, null, 4)) {
            this.b.a();
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j2, TimeUnit timeUnit) {
        a aVar = this.a;
        if (aVar.tryAcquireSharedNanos(-1, timeUnit.toNanos(j2))) {
            return aVar.a();
        }
        throw new TimeoutException("Timeout waiting for task.");
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.a.c();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(Throwable th) {
        boolean a2 = this.a.a(null, (Throwable) jp.a(th), 2);
        if (a2) {
            this.b.a();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return a2;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        a aVar = this.a;
        aVar.acquireSharedInterruptibly(-1);
        return aVar.a();
    }

    /* loaded from: classes3.dex */
    static final class a extends AbstractQueuedSynchronizer {
        private Object a;
        private Throwable b;

        a() {
        }

        final Object a() {
            int state = getState();
            if (state == 2) {
                if (this.b == null) {
                    return this.a;
                }
                throw new ExecutionException(this.b);
            } else if (state != 4) {
                throw new IllegalStateException("Error, synchronizer in invalid state: " + state);
            } else {
                throw new CancellationException("Task was cancelled.");
            }
        }

        final boolean b() {
            return (getState() & 6) != 0;
        }

        final boolean c() {
            return getState() == 4;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final int tryAcquireShared(int i2) {
            return b() ? 1 : -1;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryReleaseShared(int i2) {
            setState(i2);
            return true;
        }

        final boolean a(@Nullable Object obj, @Nullable Throwable th, int i2) {
            boolean compareAndSetState = compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.a = obj;
                this.b = th;
                releaseShared(i2);
            } else if (getState() == 1) {
                acquireShared(-1);
            }
            return compareAndSetState;
        }
    }
}
